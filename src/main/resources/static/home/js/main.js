window.onload = function () {
    pageInit()
}
//登录链接
const loginUrl = 'http://localhost:8080/login'
//表格链接
const getDataUrl = 'http://localhost:8080/get/data'
let pageInit = function () {
    return new Vue({
        el: "#app",
        data: {
            pageLoading: false,  //全屏加载
            tableLoading: false, //表格加载
            isLoginSuccess: false, //是否登陆成功
            userName: '',//登录名
            password: '',  //密码
            userNickName: '',  //用户的名字
            searchValue: '', //搜索词
            isHasPermissSubmitData: false,//是否有添加信息的权限
            submitDataList: [],//弹出窗的字段
            dialogField:{},//弹出层的字段容器
            submitDataUrl: '',//弹出层的提交url
            userMenus: [], //菜单项
            tablefiledList: [], //表格名列表
            tableData: [], //表数据
            pageNumber: 1,
            totalPage: 1,
            typeList: ["食堂采购", "宿舍采购","教学楼采购","门窗损坏","漏水断电","电子损坏"
                ,"其他","宿舍意见","食堂意见","教学楼意见","其他类型意见","学生","老师"],
            statusList: ["未维修", "已维修"]
        },
        methods: {
            pageRender() {
                this.tableLoading = true
                let activeMenu = this.userMenus.find((item) => item.isActive)
                let formData = {
                    type: activeMenu.typeName,
                    pageNumber: this.pageNumber,
                    searchName: this.searchValue
                }
                this.serverHelper(getDataUrl, formData).then(res => {
                    console.log(res)
                    this.tableData = []
                    this.tablefiledList = res.tableFields
                    this.pageNumber = res.pageNumber
                    this.totalPage = res.totalPage
                    res.data.forEach(item => {
                        let arr = []
                        Object.keys(item).forEach((key, index) => {
                            if (key.indexOf('Time') > 0) {
                                item[key] = this.formatDate(item[key])
                            }
                            if (key.indexOf('typeId') == 0) {
                                item[key] = this.getTypeName(item[key], "type")
                            }
                            if (key.indexOf('status') == 0) {
                                item[key] = this.getTypeName(item[key], "status")
                            }
                            arr.push(item[key])
                        })
                        arr = arr.splice(1, arr.length - 2)
                        this.tableData.push(arr)
                    })
                    this.tableLoading = false
                }).catch(err => {
                    console.log(err)
                    this.tableLoading = false
                    this.$message.error('获取数据失败！'+err.msg)
                })

            },
            search(){
                this.pageNumber=1
                this.pageRender()
            },
            changeMenu(value) {
                this.dialogField={}
                this.userMenus.forEach(item => {
                    if (item.menuItem === value.menuItem) {
                        item.isActive = true
                        //判断是否展示添加按钮
                        if (item.isCanSubmit) {
                            this.isHasPermissSubmitData = true
                            this.submitDataUrl = item.url
                            this.submitDataList = item.dialog
                            this.pageNumber=1
                        } else {
                            this.isHasPermissSubmitData = false
                            this.submitDataUrl = false
                            this.submitDataList=[]
                            this.pageNumber = 1
                        }
                    } else {
                        item.isActive = false
                    }
                });
                this.pageRender()
            },
            login() {
                if (!this.userName || !this.password) {
                    this.$message.warning('请输入账号和密码！')
                    return;
                }
                this.pageLoading = true
                let formData = {
                    loginacct: this.userName,
                    userpswd: this.password
                }
                this.serverHelper(loginUrl, formData).then(result => {
                    console.log(result)
                    this.pageLoading = false
                    this.isLoginSuccess = true
                    if (result.menuList.length > 0) {
                        result.menuList.forEach(item => {
                            item.isActive = false
                        })
                        result.menuList[0].isActive = true
                    }
                    this.userMenus = result.menuList
                    this.userNickName = result.username
                    this.changeMenu(this.userMenus[0])
                }).catch(err => {
                    this.pageLoading = false
                    this.$message.error(err.msg)
                })
            },
            submitData(){
                let lenght= 0,isComplete=true
                Object.keys(this.dialogField).forEach(key=>{
                    if(!this.dialogField[key]){
                    isComplete=false
                }
                lenght++
            })
                if(lenght!==this.submitDataList.length || !isComplete){
                    this.$message.warning('请补充完整信息！！！');
                    return
                }
                this.serverHelper(this.submitDataUrl, this.dialogField, 'post').then(res => {
                    this.$message.success('提交成功！')
                    $('#dialog').attr('class', 'mark animated fadeOutUpBig')
                $('#reset-form').click()
                this.search()
            }).catch(err => {
                    console.log(err)
                    this.$message.error('操作失败:' + err.msg)
                })
            },
            exit() {
                this.isLoginSuccess = false
                this.tablefiledList = []
            },
            backup(){
                window.open('http://localhost:8080/go/to/index');
            },
            changePage(e){
                this.pageNumber=e
                this.pageRender()
            },
            serverHelper(url, data, ajaxType) {
                return new Promise((resolve, reject) => {
                    $.ajax({
                        type: ajaxType || "get",
                        dataType: "json",
                        url: url,
                        data: data,
                        success: function (res) {
                            if (res.code == 200) {
                                resolve(res)
                            } else {
                                reject(res)
                            }
                        },
                        error: function (err) {
                            reject(err)
                        },
                        complete: function (err) {
                            console.log(arguments)
                            if (err.status != 200) {
                                reject(err)
                            }
                        }
                    })
                })
            },
            formatDate(time) {
                let t = (e) => e < 9 ? '0' + e : e
                let date = new Date(time)
                let y = date.getFullYear()
                let m = t(date.getMonth() + 1)
                let d = t(date.getDate())
                let h = t(date.getHours())
                let ms = t(date.getMinutes())
                let s = t(date.getSeconds())
                return `${y}-${m}-${d} ${h}:${ms}:${s}`
            },
            getTypeName(index, area){
                let typeList = this.typeList
                let statusList = this.statusList
                if(area == "type"){
                    return typeList[index - 1]
                }else{
                    return statusList[index]
                }
            }
        },
    })
}

