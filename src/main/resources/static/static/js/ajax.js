
/**
 * url : 后台接口
 * id : 删除的id
 * jsText : js字符串，成功时调用
 */
let _deleteById = function (url, id, jsText) {
    layer.confirm('确认要删除吗？', function () {
        _pageLoading()
        let data = {
            id: id
        }
        $.ajax({
            url: url,
            type: 'GET',
            data: data,
            dataType: "JSON",
            success: function (res) {
                if(res.code == 200){
                    _closeLoading(1)
                    _tips('删除成功')
                    setTimeout(() => {
                        location.reload();
                    }, 800);

                }
            },
            error: function (err) {
                _closeLoading(1)
                _tips('加载失败')
                console.log(err);
            }
        })
    });

}
/**
 * 多选删除
 * @param {*} id  表格id
 * @param {*} url 
 * @param {*} cb 
 */
function _deleteSelectItem(id, url, cb) {
    let element = $('#' + id)
    let arr = _elementTransArr(element.find('.layui-form-checked'))
    if (arr.length === 0) {
        _tips('请先选择想要删除的数据')
        return
    }
    layer.confirm('确认要删除吗？此操作不可撤销！', function () {

        let deleteIds = []
        arr.forEach(item => {
            deleteIds.push(item.parentNode.nextElementSibling.innerText)
        })
        _saveData(url, { ids: deleteIds.join(',') }, cb)
    });
}
/**
 * 保存数据通用接口
 * @param {*} url 
 * @param {*} data 
 * @param {*} cb 
 */
let _saveData = function (url, data, cb) {
    _pageLoading('提交中')
    $.ajax({
        url: url,
        type: 'POST',
        data: data,
        dataType: "json",
        success: function (res) {
            console.log(res)
            _closeLoading(1)
            _tips(res.msg)
            if (cb && typeof cb === 'string') {
                setTimeout(() => { eval(cb) }, 800);
            } else {
                setTimeout(() => { cb && cb() }, 800);
            }

        },
        error: function (err, textStatus, errorThrown) {
            console.log("3 异步调用返回失败,textStatus:"+textStatus);
            console.log("4 异步调用返回失败,errorThrown:"+errorThrown);
            console.log(err)
            _closeLoading(1)
            _tips('操作失败！')
        }

    })
    // return false
}
/**
 * 元素转为数组
 * @param {*} element 
 */
let _elementTransArr = function (element) {
    let arr = new Array()
    element.each(function (idx, item) {
        if (item.type !== 'button' && item.type !== 'submit') {
            arr.push(item)
        }
    })
    return arr
}
/**
 * 获取表单内的元素
 * @param {*} fromId 
 */
let _getFromElement = function (fromId) {
    let element = $('#' + fromId)
    let inputArr = element.find('input')
    let selectArr = element.find('select')
    return [].concat(_elementTransArr(inputArr))
}
/**
 * 通用的dialog开关事件
 * @param {*} flag 
 */
function _dialogStatus(flag) {
    if (flag) {
        $('#list-dialog').css('display', 'block')
        if (flag === 'add') {
            //清空所有值
            let waitFillFrom = _getFromElement('editInfoData')
            waitFillFrom.forEach(item => {
                item.value = ''
            })
            $('#dialogTitle')[0].innerText = '增加'
            $('#submit_button').text('添加')
        }
    } else {
        $('#list-dialog').css('display', 'none')
        $('#dialogTitle')[0].innerText = '修改信息'
    }
}
/**
 * 通用的数据回显事件
 * @param {*} e 
 */
function _viewData(e) {
    let element = e[0].parentNode.parentNode
    let arr = _elementTransArr($(element).find('td'))
    arr = arr.slice(1, arr.length - 2)//切除第一个选择框栏和最后一个操作栏以及创建时间
    let waitFillFrom = _getFromElement('editInfoData')
    console.log(waitFillFrom);
    //下拉框的候选值
    let cacheSelect = ['男', '女', '未维修', '已维修', '已启用', '已停用']
    let cachePower = ['宿舍管理', '食堂管理', '采购管理', '维修管理', '学生意见墙管理']

    arr.forEach((item, index) => {
        //针对lay的下拉框进行特殊处理
        if (cacheSelect.indexOf(item.innerText) >= 0) {
            $("#sexSelect").each(function () {
                // this代表的是<option></option>，对option再进行遍历
                $(this).children("option").each(function () {
                    // 判断需要对那个选项进行回显
                    if (this.value == item.innerText) {
                        // 进行回显
                        waitFillFrom[index].value = item.innerText
                        $(this).attr("selected", "selected");
                        //针对layui封装的下拉框进行回显  mmp
                        $('.layui-anim-upbit').children('dd').each(function () {
                            if (this['lay-value'] === item.innerText) {
                                $(this).attr('class', 'layui-this');
                            } else {
                                $(this).removeClass('layui-this');
                            }
                        })
                    }
                });
            })

        } else if ($('#editInfoData').find('#openPowerSelect').length > 0 && _vaildIsPower(item.innerText)){//检验表单中是否有多选权限的元素  检验是否为权限管理
            if(window.xmSelectContaienr){
                let vaildArr = item.innerText.split('、')
                let arr=[]
                //设置回显
                vaildArr.forEach(item=>{
                    arr.push({name:item,value:item})
                    
                })
                window.xmSelectContaienr.setValue(arr)
            }
        } else {
            //其余input框直接赋值完事
            waitFillFrom[index].value = item.innerText
        }

    })
    _dialogStatus(true)
}
/**
 * 页面加载
 */
let _pageLoading = function (text = '加载中') {
    layer.msg(text, { time: 0, shade: 0.5 })
}
/**
 * 关闭加载
 */
let _closeLoading = function (index) {
    layer.close(index)
}
/**
 * 提示语
 */
let _tips = function (text) {
    layer.msg(text, { shade: 0.5 })
}
/**
 * 权限选择容器
 */
let _getPowerList = function () {
    return [
        { name: '宿舍管理', value: '宿舍管理' },
        { name: '食堂管理', value: '食堂管理' },
        { name: '采购管理', value: '采购管理' },
        { name: '维修管理', value: '维修管理' },
        { name: '学生意见墙管理', value: '学生意见墙管理' },
    ]
}
let _vaildIsPower = function (text) {
    let vaildArr = text.split('、')
    let arr = _getPowerList()
    let flag = false
    arr.forEach(item => {
        vaildArr.forEach(vaildItem => {
            if (item.name === vaildItem) {
                flag = true
            }
        })
    })
    return flag
}
/**
 * 初始化多选下拉框容器
 * @param {*} id 
 */
function _initXmSelectContaienr(id) {
    window.xmSelectContaienr = xmSelect.render({
        el: id,
        name: 'selectPower',
        toolbar: {
            show: true
        },
        model: {
            label: {
                type: 'block',
                block: {
                    //最大显示数量, 0:不限制
                    showCount: 1,
                    //是否显示删除图标
                    showIcon: true,
                }
            }
        },
        language: 'zn',
        data: _getPowerList()
    })
}