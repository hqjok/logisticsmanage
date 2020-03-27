package com.logistics.manage.service.result;

import java.util.List;

/**
 * @Create 2020-03-18 19:14
 */
public class FrontendResult<T> {

    private Integer code;
    private String msg;
    private Integer pageNumber;
    private Integer totalPage;
    private Long totalSize;
    private List<TableField> tableFields;
    private List<T> data;

    public FrontendResult(Integer code, String msg, Integer pageNumber, Integer totalPage, Long totalSize, List<TableField> tableFields, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.pageNumber = pageNumber;
        this.totalPage = totalPage;
        this.totalSize = totalSize;
        this.tableFields = tableFields;
        this.data = data;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public static FrontendResult failed(Integer code, String msg){
        return new FrontendResult(code, msg, null, null, null, null, null);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<TableField> getTableFields() {
        return tableFields;
    }

    public void setTableFields(List<TableField> tableFields) {
        this.tableFields = tableFields;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static class TableField{

        private String name;
        private String icon;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public TableField(String name, String icon) {
            this.name = name;
            this.icon = icon;
        }
    }
}
