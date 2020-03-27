package com.logistics.manage.service.result;

import java.util.List;

/**
 * @Create 2020-03-18 20:56
 */
public class LoginResult {


    /**
     * code : 200
     * msg : yes
     * username :
     * menuList : [{"menuItem":"name","dataNum":"100","fileName":"name","isCanSubmit":false},{"menuItem":"loud","dataNum":"100","fileName":"loud","isCanSubmit":false,"url":""},{"menuItem":"weixiu","dataNum":"100","fileName":"xues","isCanSubmit":true,"url":"https://asdasd5asd4","dialog":[{"fieldName":"维修类型","fieldicon":"fa","paramName":"type"},{"fieldName":"维修内容描述","fieldicon":"fa","paramName":"description"}]}]
     */

    private Integer code;
    private String msg;
    private String username;
    private String roleName;
    private List<MenuListBean> menuList;

    public LoginResult(Integer code, String msg, String username, String roleName, List<MenuListBean> menuList) {
        this.code = code;
        this.msg = msg;
        this.username = username;
        this.roleName = roleName;
        this.menuList = menuList;
    }

    public static LoginResult faild(Integer code, String msg){
        return new LoginResult(code, msg, null, null, null);
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<MenuListBean> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuListBean> menuList) {
        this.menuList = menuList;
    }

    public static class MenuListBean {
        /**
         * menuItem : name
         * dataNum : 100
         * fileName : name
         * isCanSubmit : false
         * url :
         * dialog : [{"fieldName":"维修类型","fieldicon":"fa","paramName":"type"},{"fieldName":"维修内容描述","fieldicon":"fa","paramName":"description"}]
         */

        private String menuItem;
        private Integer dataNum;
        private String typeName;
        private boolean isCanSubmit;
        private String url;
        private List<DialogBean> dialog;

        public static MenuListBean menuWithNoDialog(String menuItem, Integer dataNum, String typeName){
            return new MenuListBean(menuItem, dataNum, typeName, false, null, null);
        }

        public MenuListBean(String menuItem, Integer dataNum, String typeName, boolean isCanSubmit, String url, List<DialogBean> dialog) {
            this.menuItem = menuItem;
            this.dataNum = dataNum;
            this.typeName = typeName;
            this.isCanSubmit = isCanSubmit;
            this.url = url;
            this.dialog = dialog;
        }

        public String getMenuItem() {
            return menuItem;
        }

        public void setMenuItem(String menuItem) {
            this.menuItem = menuItem;
        }

        public Integer getDataNum() {
            return dataNum;
        }

        public void setDataNum(Integer dataNum) {
            this.dataNum = dataNum;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public boolean isIsCanSubmit() {
            return isCanSubmit;
        }

        public void setIsCanSubmit(boolean isCanSubmit) {
            this.isCanSubmit = isCanSubmit;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<DialogBean> getDialog() {
            return dialog;
        }

        public void setDialog(List<DialogBean> dialog) {
            this.dialog = dialog;
        }

        public static class DialogBean {
            /**
             * fieldName : 维修类型
             * fieldicon : fa
             * paramName : type
             */

            private String fieldName;
            private String fieldicon;
            private String paramName;
            private String inputType;
            private List<SelectType> types;

            public DialogBean(String fieldName, String fieldicon, String paramName, String inputType, List<SelectType> types) {
                this.fieldName = fieldName;
                this.fieldicon = fieldicon;
                this.paramName = paramName;
                this.inputType = inputType;
                this.types = types;
            }

            public String getInputType() {
                return inputType;
            }

            public void setInputType(String inputType) {
                this.inputType = inputType;
            }

            public List<SelectType> getTypes() {
                return types;
            }

            public void setTypes(List<SelectType> types) {
                this.types = types;
            }

            public String getFieldName() {
                return fieldName;
            }

            public void setFieldName(String fieldName) {
                this.fieldName = fieldName;
            }

            public String getFieldicon() {
                return fieldicon;
            }

            public void setFieldicon(String fieldicon) {
                this.fieldicon = fieldicon;
            }

            public String getParamName() {
                return paramName;
            }

            public void setParamName(String paramName) {
                this.paramName = paramName;
            }

            public static class SelectType{
                private Integer typeCode;
                private String typeName;

                public SelectType(Integer typeCode, String typeName) {
                    this.typeCode = typeCode;
                    this.typeName = typeName;
                }

                public Integer getTypeCode() {
                    return typeCode;
                }

                public void setTypeCode(Integer typeCode) {
                    this.typeCode = typeCode;
                }

                public String getTypeName() {
                    return typeName;
                }

                public void setTypeName(String typeName) {
                    this.typeName = typeName;
                }
            }
        }
    }
}
