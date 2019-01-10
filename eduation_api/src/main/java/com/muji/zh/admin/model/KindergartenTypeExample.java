package com.muji.zh.admin.model;

import java.util.ArrayList;
import java.util.List;

public class KindergartenTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KindergartenTypeExample() {
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

        public Criteria andKtIdIsNull() {
            addCriterion("kt_id is null");
            return (Criteria) this;
        }

        public Criteria andKtIdIsNotNull() {
            addCriterion("kt_id is not null");
            return (Criteria) this;
        }

        public Criteria andKtIdEqualTo(Integer value) {
            addCriterion("kt_id =", value, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdNotEqualTo(Integer value) {
            addCriterion("kt_id <>", value, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdGreaterThan(Integer value) {
            addCriterion("kt_id >", value, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("kt_id >=", value, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdLessThan(Integer value) {
            addCriterion("kt_id <", value, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdLessThanOrEqualTo(Integer value) {
            addCriterion("kt_id <=", value, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdIn(List<Integer> values) {
            addCriterion("kt_id in", values, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdNotIn(List<Integer> values) {
            addCriterion("kt_id not in", values, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdBetween(Integer value1, Integer value2) {
            addCriterion("kt_id between", value1, value2, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("kt_id not between", value1, value2, "ktId");
            return (Criteria) this;
        }

        public Criteria andKtnameIsNull() {
            addCriterion("ktname is null");
            return (Criteria) this;
        }

        public Criteria andKtnameIsNotNull() {
            addCriterion("ktname is not null");
            return (Criteria) this;
        }

        public Criteria andKtnameEqualTo(String value) {
            addCriterion("ktname =", value, "ktname");
            return (Criteria) this;
        }

        public Criteria andKtnameNotEqualTo(String value) {
            addCriterion("ktname <>", value, "ktname");
            return (Criteria) this;
        }

        public Criteria andKtnameGreaterThan(String value) {
            addCriterion("ktname >", value, "ktname");
            return (Criteria) this;
        }

        public Criteria andKtnameGreaterThanOrEqualTo(String value) {
            addCriterion("ktname >=", value, "ktname");
            return (Criteria) this;
        }

        public Criteria andKtnameLessThan(String value) {
            addCriterion("ktname <", value, "ktname");
            return (Criteria) this;
        }

        public Criteria andKtnameLessThanOrEqualTo(String value) {
            addCriterion("ktname <=", value, "ktname");
            return (Criteria) this;
        }

        public Criteria andKtnameLike(String value) {
            addCriterion("ktname like", value, "ktname");
            return (Criteria) this;
        }

        public Criteria andKtnameNotLike(String value) {
            addCriterion("ktname not like", value, "ktname");
            return (Criteria) this;
        }

        public Criteria andKtnameIn(List<String> values) {
            addCriterion("ktname in", values, "ktname");
            return (Criteria) this;
        }

        public Criteria andKtnameNotIn(List<String> values) {
            addCriterion("ktname not in", values, "ktname");
            return (Criteria) this;
        }

        public Criteria andKtnameBetween(String value1, String value2) {
            addCriterion("ktname between", value1, value2, "ktname");
            return (Criteria) this;
        }

        public Criteria andKtnameNotBetween(String value1, String value2) {
            addCriterion("ktname not between", value1, value2, "ktname");
            return (Criteria) this;
        }

        public Criteria andFlag1IsNull() {
            addCriterion("flag1 is null");
            return (Criteria) this;
        }

        public Criteria andFlag1IsNotNull() {
            addCriterion("flag1 is not null");
            return (Criteria) this;
        }

        public Criteria andFlag1EqualTo(String value) {
            addCriterion("flag1 =", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1NotEqualTo(String value) {
            addCriterion("flag1 <>", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1GreaterThan(String value) {
            addCriterion("flag1 >", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1GreaterThanOrEqualTo(String value) {
            addCriterion("flag1 >=", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1LessThan(String value) {
            addCriterion("flag1 <", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1LessThanOrEqualTo(String value) {
            addCriterion("flag1 <=", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1Like(String value) {
            addCriterion("flag1 like", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1NotLike(String value) {
            addCriterion("flag1 not like", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1In(List<String> values) {
            addCriterion("flag1 in", values, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1NotIn(List<String> values) {
            addCriterion("flag1 not in", values, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1Between(String value1, String value2) {
            addCriterion("flag1 between", value1, value2, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1NotBetween(String value1, String value2) {
            addCriterion("flag1 not between", value1, value2, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag2IsNull() {
            addCriterion("flag2 is null");
            return (Criteria) this;
        }

        public Criteria andFlag2IsNotNull() {
            addCriterion("flag2 is not null");
            return (Criteria) this;
        }

        public Criteria andFlag2EqualTo(String value) {
            addCriterion("flag2 =", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2NotEqualTo(String value) {
            addCriterion("flag2 <>", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2GreaterThan(String value) {
            addCriterion("flag2 >", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2GreaterThanOrEqualTo(String value) {
            addCriterion("flag2 >=", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2LessThan(String value) {
            addCriterion("flag2 <", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2LessThanOrEqualTo(String value) {
            addCriterion("flag2 <=", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2Like(String value) {
            addCriterion("flag2 like", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2NotLike(String value) {
            addCriterion("flag2 not like", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2In(List<String> values) {
            addCriterion("flag2 in", values, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2NotIn(List<String> values) {
            addCriterion("flag2 not in", values, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2Between(String value1, String value2) {
            addCriterion("flag2 between", value1, value2, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2NotBetween(String value1, String value2) {
            addCriterion("flag2 not between", value1, value2, "flag2");
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