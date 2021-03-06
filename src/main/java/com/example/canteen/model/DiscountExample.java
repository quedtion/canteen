package com.example.canteen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiscountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DiscountExample() {
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

        public Criteria andValidtimeIsNull() {
            addCriterion("validTime is null");
            return (Criteria) this;
        }

        public Criteria andValidtimeIsNotNull() {
            addCriterion("validTime is not null");
            return (Criteria) this;
        }

        public Criteria andValidtimeEqualTo(Date value) {
            addCriterion("validTime =", value, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeNotEqualTo(Date value) {
            addCriterion("validTime <>", value, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeGreaterThan(Date value) {
            addCriterion("validTime >", value, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("validTime >=", value, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeLessThan(Date value) {
            addCriterion("validTime <", value, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeLessThanOrEqualTo(Date value) {
            addCriterion("validTime <=", value, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeIn(List<Date> values) {
            addCriterion("validTime in", values, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeNotIn(List<Date> values) {
            addCriterion("validTime not in", values, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeBetween(Date value1, Date value2) {
            addCriterion("validTime between", value1, value2, "validtime");
            return (Criteria) this;
        }

        public Criteria andValidtimeNotBetween(Date value1, Date value2) {
            addCriterion("validTime not between", value1, value2, "validtime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
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