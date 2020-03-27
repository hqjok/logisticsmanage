package com.logistics.manage.entity.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserPOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLoginacctIsNull() {
            addCriterion("loginacct is null");
            return (Criteria) this;
        }

        public Criteria andLoginacctIsNotNull() {
            addCriterion("loginacct is not null");
            return (Criteria) this;
        }

        public Criteria andLoginacctEqualTo(String value) {
            addCriterion("loginacct =", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctNotEqualTo(String value) {
            addCriterion("loginacct <>", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctGreaterThan(String value) {
            addCriterion("loginacct >", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctGreaterThanOrEqualTo(String value) {
            addCriterion("loginacct >=", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctLessThan(String value) {
            addCriterion("loginacct <", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctLessThanOrEqualTo(String value) {
            addCriterion("loginacct <=", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctLike(String value) {
            addCriterion("loginacct like", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctNotLike(String value) {
            addCriterion("loginacct not like", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctIn(List<String> values) {
            addCriterion("loginacct in", values, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctNotIn(List<String> values) {
            addCriterion("loginacct not in", values, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctBetween(String value1, String value2) {
            addCriterion("loginacct between", value1, value2, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctNotBetween(String value1, String value2) {
            addCriterion("loginacct not between", value1, value2, "loginacct");
            return (Criteria) this;
        }

        public Criteria andUserpswdIsNull() {
            addCriterion("userpswd is null");
            return (Criteria) this;
        }

        public Criteria andUserpswdIsNotNull() {
            addCriterion("userpswd is not null");
            return (Criteria) this;
        }

        public Criteria andUserpswdEqualTo(String value) {
            addCriterion("userpswd =", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdNotEqualTo(String value) {
            addCriterion("userpswd <>", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdGreaterThan(String value) {
            addCriterion("userpswd >", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdGreaterThanOrEqualTo(String value) {
            addCriterion("userpswd >=", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdLessThan(String value) {
            addCriterion("userpswd <", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdLessThanOrEqualTo(String value) {
            addCriterion("userpswd <=", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdLike(String value) {
            addCriterion("userpswd like", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdNotLike(String value) {
            addCriterion("userpswd not like", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdIn(List<String> values) {
            addCriterion("userpswd in", values, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdNotIn(List<String> values) {
            addCriterion("userpswd not in", values, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdBetween(String value1, String value2) {
            addCriterion("userpswd between", value1, value2, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdNotBetween(String value1, String value2) {
            addCriterion("userpswd not between", value1, value2, "userpswd");
            return (Criteria) this;
        }

        public Criteria andTelphoneIsNull() {
            addCriterion("telphone is null");
            return (Criteria) this;
        }

        public Criteria andTelphoneIsNotNull() {
            addCriterion("telphone is not null");
            return (Criteria) this;
        }

        public Criteria andTelphoneEqualTo(String value) {
            addCriterion("telphone =", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotEqualTo(String value) {
            addCriterion("telphone <>", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneGreaterThan(String value) {
            addCriterion("telphone >", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("telphone >=", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLessThan(String value) {
            addCriterion("telphone <", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLessThanOrEqualTo(String value) {
            addCriterion("telphone <=", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLike(String value) {
            addCriterion("telphone like", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotLike(String value) {
            addCriterion("telphone not like", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneIn(List<String> values) {
            addCriterion("telphone in", values, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotIn(List<String> values) {
            addCriterion("telphone not in", values, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneBetween(String value1, String value2) {
            addCriterion("telphone between", value1, value2, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotBetween(String value1, String value2) {
            addCriterion("telphone not between", value1, value2, "telphone");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("role like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("role not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNull() {
            addCriterion("permission is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNotNull() {
            addCriterion("permission is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionEqualTo(String value) {
            addCriterion("permission =", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotEqualTo(String value) {
            addCriterion("permission <>", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThan(String value) {
            addCriterion("permission >", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThanOrEqualTo(String value) {
            addCriterion("permission >=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThan(String value) {
            addCriterion("permission <", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThanOrEqualTo(String value) {
            addCriterion("permission <=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLike(String value) {
            addCriterion("permission like", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotLike(String value) {
            addCriterion("permission not like", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionIn(List<String> values) {
            addCriterion("permission in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotIn(List<String> values) {
            addCriterion("permission not in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionBetween(String value1, String value2) {
            addCriterion("permission between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotBetween(String value1, String value2) {
            addCriterion("permission not between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andModifyPermissionTimeIsNull() {
            addCriterion("modify_permission_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeJustDay(String value) {
            addCriterion("DATE_FORMAT(create_time,'%Y-%m-%d') = ", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyPermissionTimeIsNotNull() {
            addCriterion("modify_permission_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyPermissionTimeEqualTo(Date value) {
            addCriterion("modify_permission_time =", value, "modifyPermissionTime");
            return (Criteria) this;
        }

        public Criteria andModifyPermissionTimeNotEqualTo(Date value) {
            addCriterion("modify_permission_time <>", value, "modifyPermissionTime");
            return (Criteria) this;
        }

        public Criteria andModifyPermissionTimeGreaterThan(Date value) {
            addCriterion("modify_permission_time >", value, "modifyPermissionTime");
            return (Criteria) this;
        }

        public Criteria andModifyPermissionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_permission_time >=", value, "modifyPermissionTime");
            return (Criteria) this;
        }

        public Criteria andModifyPermissionTimeLessThan(Date value) {
            addCriterion("modify_permission_time <", value, "modifyPermissionTime");
            return (Criteria) this;
        }

        public Criteria andModifyPermissionTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_permission_time <=", value, "modifyPermissionTime");
            return (Criteria) this;
        }

        public Criteria andModifyPermissionTimeIn(List<Date> values) {
            addCriterion("modify_permission_time in", values, "modifyPermissionTime");
            return (Criteria) this;
        }

        public Criteria andModifyPermissionTimeNotIn(List<Date> values) {
            addCriterion("modify_permission_time not in", values, "modifyPermissionTime");
            return (Criteria) this;
        }

        public Criteria andModifyPermissionTimeBetween(Date value1, Date value2) {
            addCriterion("modify_permission_time between", value1, value2, "modifyPermissionTime");
            return (Criteria) this;
        }

        public Criteria andModifyPermissionTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_permission_time not between", value1, value2, "modifyPermissionTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}