package com.logistics.manage.entity.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopPOExample() {
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

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("order_num like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("order_num not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andOrderContentIsNull() {
            addCriterion("order_content is null");
            return (Criteria) this;
        }

        public Criteria andOrderContentIsNotNull() {
            addCriterion("order_content is not null");
            return (Criteria) this;
        }

        public Criteria andOrderContentEqualTo(String value) {
            addCriterion("order_content =", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentNotEqualTo(String value) {
            addCriterion("order_content <>", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentGreaterThan(String value) {
            addCriterion("order_content >", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentGreaterThanOrEqualTo(String value) {
            addCriterion("order_content >=", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentLessThan(String value) {
            addCriterion("order_content <", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentLessThanOrEqualTo(String value) {
            addCriterion("order_content <=", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentLike(String value) {
            addCriterion("order_content like", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentNotLike(String value) {
            addCriterion("order_content not like", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentIn(List<String> values) {
            addCriterion("order_content in", values, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentNotIn(List<String> values) {
            addCriterion("order_content not in", values, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentBetween(String value1, String value2) {
            addCriterion("order_content between", value1, value2, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentNotBetween(String value1, String value2) {
            addCriterion("order_content not between", value1, value2, "orderContent");
            return (Criteria) this;
        }

        public Criteria andDirectorNameIsNull() {
            addCriterion("director_name is null");
            return (Criteria) this;
        }

        public Criteria andDirectorNameIsNotNull() {
            addCriterion("director_name is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorNameEqualTo(String value) {
            addCriterion("director_name =", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameNotEqualTo(String value) {
            addCriterion("director_name <>", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameGreaterThan(String value) {
            addCriterion("director_name >", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameGreaterThanOrEqualTo(String value) {
            addCriterion("director_name >=", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameLessThan(String value) {
            addCriterion("director_name <", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameLessThanOrEqualTo(String value) {
            addCriterion("director_name <=", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameLike(String value) {
            addCriterion("director_name like", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameNotLike(String value) {
            addCriterion("director_name not like", value, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameIn(List<String> values) {
            addCriterion("director_name in", values, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameNotIn(List<String> values) {
            addCriterion("director_name not in", values, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameBetween(String value1, String value2) {
            addCriterion("director_name between", value1, value2, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorNameNotBetween(String value1, String value2) {
            addCriterion("director_name not between", value1, value2, "directorName");
            return (Criteria) this;
        }

        public Criteria andDirectorTelphoneIsNull() {
            addCriterion("director_telphone is null");
            return (Criteria) this;
        }

        public Criteria andDirectorTelphoneIsNotNull() {
            addCriterion("director_telphone is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorTelphoneEqualTo(Integer value) {
            addCriterion("director_telphone =", value, "directorTelphone");
            return (Criteria) this;
        }

        public Criteria andDirectorTelphoneNotEqualTo(Integer value) {
            addCriterion("director_telphone <>", value, "directorTelphone");
            return (Criteria) this;
        }

        public Criteria andDirectorTelphoneGreaterThan(Integer value) {
            addCriterion("director_telphone >", value, "directorTelphone");
            return (Criteria) this;
        }

        public Criteria andDirectorTelphoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("director_telphone >=", value, "directorTelphone");
            return (Criteria) this;
        }

        public Criteria andDirectorTelphoneLessThan(Integer value) {
            addCriterion("director_telphone <", value, "directorTelphone");
            return (Criteria) this;
        }

        public Criteria andDirectorTelphoneLessThanOrEqualTo(Integer value) {
            addCriterion("director_telphone <=", value, "directorTelphone");
            return (Criteria) this;
        }

        public Criteria andDirectorTelphoneIn(List<Integer> values) {
            addCriterion("director_telphone in", values, "directorTelphone");
            return (Criteria) this;
        }

        public Criteria andDirectorTelphoneNotIn(List<Integer> values) {
            addCriterion("director_telphone not in", values, "directorTelphone");
            return (Criteria) this;
        }

        public Criteria andDirectorTelphoneBetween(Integer value1, Integer value2) {
            addCriterion("director_telphone between", value1, value2, "directorTelphone");
            return (Criteria) this;
        }

        public Criteria andDirectorTelphoneNotBetween(Integer value1, Integer value2) {
            addCriterion("director_telphone not between", value1, value2, "directorTelphone");
            return (Criteria) this;
        }

        public Criteria andCountPriceIsNull() {
            addCriterion("count_price is null");
            return (Criteria) this;
        }

        public Criteria andCountPriceIsNotNull() {
            addCriterion("count_price is not null");
            return (Criteria) this;
        }

        public Criteria andCountPriceEqualTo(BigDecimal value) {
            addCriterion("count_price =", value, "countPrice");
            return (Criteria) this;
        }

        public Criteria andCountPriceNotEqualTo(BigDecimal value) {
            addCriterion("count_price <>", value, "countPrice");
            return (Criteria) this;
        }

        public Criteria andCountPriceGreaterThan(BigDecimal value) {
            addCriterion("count_price >", value, "countPrice");
            return (Criteria) this;
        }

        public Criteria andCountPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("count_price >=", value, "countPrice");
            return (Criteria) this;
        }

        public Criteria andCountPriceLessThan(BigDecimal value) {
            addCriterion("count_price <", value, "countPrice");
            return (Criteria) this;
        }

        public Criteria andCountPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("count_price <=", value, "countPrice");
            return (Criteria) this;
        }

        public Criteria andCountPriceIn(List<BigDecimal> values) {
            addCriterion("count_price in", values, "countPrice");
            return (Criteria) this;
        }

        public Criteria andCountPriceNotIn(List<BigDecimal> values) {
            addCriterion("count_price not in", values, "countPrice");
            return (Criteria) this;
        }

        public Criteria andCountPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("count_price between", value1, value2, "countPrice");
            return (Criteria) this;
        }

        public Criteria andCountPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("count_price not between", value1, value2, "countPrice");
            return (Criteria) this;
        }

        public Criteria andShopTimeIsNull() {
            addCriterion("shop_time is null");
            return (Criteria) this;
        }

        public Criteria andShopTimeIsNotNull() {
            addCriterion("shop_time is not null");
            return (Criteria) this;
        }

        public Criteria andShopTimeJustDay(String value) {
            addCriterion("DATE_FORMAT(shop_time,'%Y-%m-%d') = ", value, "shopTime");
            return (Criteria) this;
        }

        public Criteria andShopTimeEqualTo(Date value) {
            addCriterion("shop_time =", value, "shopTime");
            return (Criteria) this;
        }

        public Criteria andShopTimeNotEqualTo(Date value) {
            addCriterion("shop_time <>", value, "shopTime");
            return (Criteria) this;
        }

        public Criteria andShopTimeGreaterThan(Date value) {
            addCriterion("shop_time >", value, "shopTime");
            return (Criteria) this;
        }

        public Criteria andShopTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shop_time >=", value, "shopTime");
            return (Criteria) this;
        }

        public Criteria andShopTimeLessThan(Date value) {
            addCriterion("shop_time <", value, "shopTime");
            return (Criteria) this;
        }

        public Criteria andShopTimeLessThanOrEqualTo(Date value) {
            addCriterion("shop_time <=", value, "shopTime");
            return (Criteria) this;
        }

        public Criteria andShopTimeIn(List<Date> values) {
            addCriterion("shop_time in", values, "shopTime");
            return (Criteria) this;
        }

        public Criteria andShopTimeNotIn(List<Date> values) {
            addCriterion("shop_time not in", values, "shopTime");
            return (Criteria) this;
        }

        public Criteria andShopTimeBetween(Date value1, Date value2) {
            addCriterion("shop_time between", value1, value2, "shopTime");
            return (Criteria) this;
        }

        public Criteria andShopTimeNotBetween(Date value1, Date value2) {
            addCriterion("shop_time not between", value1, value2, "shopTime");
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