package com.example.canteen.model;

import java.util.ArrayList;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCanteennameIsNull() {
            addCriterion("canteenName is null");
            return (Criteria) this;
        }

        public Criteria andCanteennameIsNotNull() {
            addCriterion("canteenName is not null");
            return (Criteria) this;
        }

        public Criteria andCanteennameEqualTo(String value) {
            addCriterion("canteenName =", value, "canteenname");
            return (Criteria) this;
        }

        public Criteria andCanteennameNotEqualTo(String value) {
            addCriterion("canteenName <>", value, "canteenname");
            return (Criteria) this;
        }

        public Criteria andCanteennameGreaterThan(String value) {
            addCriterion("canteenName >", value, "canteenname");
            return (Criteria) this;
        }

        public Criteria andCanteennameGreaterThanOrEqualTo(String value) {
            addCriterion("canteenName >=", value, "canteenname");
            return (Criteria) this;
        }

        public Criteria andCanteennameLessThan(String value) {
            addCriterion("canteenName <", value, "canteenname");
            return (Criteria) this;
        }

        public Criteria andCanteennameLessThanOrEqualTo(String value) {
            addCriterion("canteenName <=", value, "canteenname");
            return (Criteria) this;
        }

        public Criteria andCanteennameLike(String value) {
            addCriterion("canteenName like", value, "canteenname");
            return (Criteria) this;
        }

        public Criteria andCanteennameNotLike(String value) {
            addCriterion("canteenName not like", value, "canteenname");
            return (Criteria) this;
        }

        public Criteria andCanteennameIn(List<String> values) {
            addCriterion("canteenName in", values, "canteenname");
            return (Criteria) this;
        }

        public Criteria andCanteennameNotIn(List<String> values) {
            addCriterion("canteenName not in", values, "canteenname");
            return (Criteria) this;
        }

        public Criteria andCanteennameBetween(String value1, String value2) {
            addCriterion("canteenName between", value1, value2, "canteenname");
            return (Criteria) this;
        }

        public Criteria andCanteennameNotBetween(String value1, String value2) {
            addCriterion("canteenName not between", value1, value2, "canteenname");
            return (Criteria) this;
        }

        public Criteria andCanteenidIsNull() {
            addCriterion("canteenId is null");
            return (Criteria) this;
        }

        public Criteria andCanteenidIsNotNull() {
            addCriterion("canteenId is not null");
            return (Criteria) this;
        }

        public Criteria andCanteenidEqualTo(Integer value) {
            addCriterion("canteenId =", value, "canteenid");
            return (Criteria) this;
        }

        public Criteria andCanteenidNotEqualTo(Integer value) {
            addCriterion("canteenId <>", value, "canteenid");
            return (Criteria) this;
        }

        public Criteria andCanteenidGreaterThan(Integer value) {
            addCriterion("canteenId >", value, "canteenid");
            return (Criteria) this;
        }

        public Criteria andCanteenidGreaterThanOrEqualTo(Integer value) {
            addCriterion("canteenId >=", value, "canteenid");
            return (Criteria) this;
        }

        public Criteria andCanteenidLessThan(Integer value) {
            addCriterion("canteenId <", value, "canteenid");
            return (Criteria) this;
        }

        public Criteria andCanteenidLessThanOrEqualTo(Integer value) {
            addCriterion("canteenId <=", value, "canteenid");
            return (Criteria) this;
        }

        public Criteria andCanteenidIn(List<Integer> values) {
            addCriterion("canteenId in", values, "canteenid");
            return (Criteria) this;
        }

        public Criteria andCanteenidNotIn(List<Integer> values) {
            addCriterion("canteenId not in", values, "canteenid");
            return (Criteria) this;
        }

        public Criteria andCanteenidBetween(Integer value1, Integer value2) {
            addCriterion("canteenId between", value1, value2, "canteenid");
            return (Criteria) this;
        }

        public Criteria andCanteenidNotBetween(Integer value1, Integer value2) {
            addCriterion("canteenId not between", value1, value2, "canteenid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createTime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createTime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
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

        public Criteria andShouldpayIsNull() {
            addCriterion("shouldPay is null");
            return (Criteria) this;
        }

        public Criteria andShouldpayIsNotNull() {
            addCriterion("shouldPay is not null");
            return (Criteria) this;
        }

        public Criteria andShouldpayEqualTo(Double value) {
            addCriterion("shouldPay =", value, "shouldpay");
            return (Criteria) this;
        }

        public Criteria andShouldpayNotEqualTo(Double value) {
            addCriterion("shouldPay <>", value, "shouldpay");
            return (Criteria) this;
        }

        public Criteria andShouldpayGreaterThan(Double value) {
            addCriterion("shouldPay >", value, "shouldpay");
            return (Criteria) this;
        }

        public Criteria andShouldpayGreaterThanOrEqualTo(Double value) {
            addCriterion("shouldPay >=", value, "shouldpay");
            return (Criteria) this;
        }

        public Criteria andShouldpayLessThan(Double value) {
            addCriterion("shouldPay <", value, "shouldpay");
            return (Criteria) this;
        }

        public Criteria andShouldpayLessThanOrEqualTo(Double value) {
            addCriterion("shouldPay <=", value, "shouldpay");
            return (Criteria) this;
        }

        public Criteria andShouldpayIn(List<Double> values) {
            addCriterion("shouldPay in", values, "shouldpay");
            return (Criteria) this;
        }

        public Criteria andShouldpayNotIn(List<Double> values) {
            addCriterion("shouldPay not in", values, "shouldpay");
            return (Criteria) this;
        }

        public Criteria andShouldpayBetween(Double value1, Double value2) {
            addCriterion("shouldPay between", value1, value2, "shouldpay");
            return (Criteria) this;
        }

        public Criteria andShouldpayNotBetween(Double value1, Double value2) {
            addCriterion("shouldPay not between", value1, value2, "shouldpay");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andReceIsNull() {
            addCriterion("rece is null");
            return (Criteria) this;
        }

        public Criteria andReceIsNotNull() {
            addCriterion("rece is not null");
            return (Criteria) this;
        }

        public Criteria andReceEqualTo(String value) {
            addCriterion("rece =", value, "rece");
            return (Criteria) this;
        }

        public Criteria andReceNotEqualTo(String value) {
            addCriterion("rece <>", value, "rece");
            return (Criteria) this;
        }

        public Criteria andReceGreaterThan(String value) {
            addCriterion("rece >", value, "rece");
            return (Criteria) this;
        }

        public Criteria andReceGreaterThanOrEqualTo(String value) {
            addCriterion("rece >=", value, "rece");
            return (Criteria) this;
        }

        public Criteria andReceLessThan(String value) {
            addCriterion("rece <", value, "rece");
            return (Criteria) this;
        }

        public Criteria andReceLessThanOrEqualTo(String value) {
            addCriterion("rece <=", value, "rece");
            return (Criteria) this;
        }

        public Criteria andReceLike(String value) {
            addCriterion("rece like", value, "rece");
            return (Criteria) this;
        }

        public Criteria andReceNotLike(String value) {
            addCriterion("rece not like", value, "rece");
            return (Criteria) this;
        }

        public Criteria andReceIn(List<String> values) {
            addCriterion("rece in", values, "rece");
            return (Criteria) this;
        }

        public Criteria andReceNotIn(List<String> values) {
            addCriterion("rece not in", values, "rece");
            return (Criteria) this;
        }

        public Criteria andReceBetween(String value1, String value2) {
            addCriterion("rece between", value1, value2, "rece");
            return (Criteria) this;
        }

        public Criteria andReceNotBetween(String value1, String value2) {
            addCriterion("rece not between", value1, value2, "rece");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
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