package com.muji.zh.admin.model;

import java.util.ArrayList;
import java.util.List;

public class KinderLegalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KinderLegalExample() {
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

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andKlnameIsNull() {
            addCriterion("klname is null");
            return (Criteria) this;
        }

        public Criteria andKlnameIsNotNull() {
            addCriterion("klname is not null");
            return (Criteria) this;
        }

        public Criteria andKlnameEqualTo(String value) {
            addCriterion("klname =", value, "klname");
            return (Criteria) this;
        }

        public Criteria andKlnameNotEqualTo(String value) {
            addCriterion("klname <>", value, "klname");
            return (Criteria) this;
        }

        public Criteria andKlnameGreaterThan(String value) {
            addCriterion("klname >", value, "klname");
            return (Criteria) this;
        }

        public Criteria andKlnameGreaterThanOrEqualTo(String value) {
            addCriterion("klname >=", value, "klname");
            return (Criteria) this;
        }

        public Criteria andKlnameLessThan(String value) {
            addCriterion("klname <", value, "klname");
            return (Criteria) this;
        }

        public Criteria andKlnameLessThanOrEqualTo(String value) {
            addCriterion("klname <=", value, "klname");
            return (Criteria) this;
        }

        public Criteria andKlnameLike(String value) {
            addCriterion("klname like", value, "klname");
            return (Criteria) this;
        }

        public Criteria andKlnameNotLike(String value) {
            addCriterion("klname not like", value, "klname");
            return (Criteria) this;
        }

        public Criteria andKlnameIn(List<String> values) {
            addCriterion("klname in", values, "klname");
            return (Criteria) this;
        }

        public Criteria andKlnameNotIn(List<String> values) {
            addCriterion("klname not in", values, "klname");
            return (Criteria) this;
        }

        public Criteria andKlnameBetween(String value1, String value2) {
            addCriterion("klname between", value1, value2, "klname");
            return (Criteria) this;
        }

        public Criteria andKlnameNotBetween(String value1, String value2) {
            addCriterion("klname not between", value1, value2, "klname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andKindIdIsNull() {
            addCriterion("kind_id is null");
            return (Criteria) this;
        }

        public Criteria andKindIdIsNotNull() {
            addCriterion("kind_id is not null");
            return (Criteria) this;
        }

        public Criteria andKindIdEqualTo(Integer value) {
            addCriterion("kind_id =", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotEqualTo(Integer value) {
            addCriterion("kind_id <>", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdGreaterThan(Integer value) {
            addCriterion("kind_id >", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("kind_id >=", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdLessThan(Integer value) {
            addCriterion("kind_id <", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdLessThanOrEqualTo(Integer value) {
            addCriterion("kind_id <=", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdIn(List<Integer> values) {
            addCriterion("kind_id in", values, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotIn(List<Integer> values) {
            addCriterion("kind_id not in", values, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdBetween(Integer value1, Integer value2) {
            addCriterion("kind_id between", value1, value2, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotBetween(Integer value1, Integer value2) {
            addCriterion("kind_id not between", value1, value2, "kindId");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andIcIdIsNull() {
            addCriterion("ic_id is null");
            return (Criteria) this;
        }

        public Criteria andIcIdIsNotNull() {
            addCriterion("ic_id is not null");
            return (Criteria) this;
        }

        public Criteria andIcIdEqualTo(Integer value) {
            addCriterion("ic_id =", value, "icId");
            return (Criteria) this;
        }

        public Criteria andIcIdNotEqualTo(Integer value) {
            addCriterion("ic_id <>", value, "icId");
            return (Criteria) this;
        }

        public Criteria andIcIdGreaterThan(Integer value) {
            addCriterion("ic_id >", value, "icId");
            return (Criteria) this;
        }

        public Criteria andIcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ic_id >=", value, "icId");
            return (Criteria) this;
        }

        public Criteria andIcIdLessThan(Integer value) {
            addCriterion("ic_id <", value, "icId");
            return (Criteria) this;
        }

        public Criteria andIcIdLessThanOrEqualTo(Integer value) {
            addCriterion("ic_id <=", value, "icId");
            return (Criteria) this;
        }

        public Criteria andIcIdIn(List<Integer> values) {
            addCriterion("ic_id in", values, "icId");
            return (Criteria) this;
        }

        public Criteria andIcIdNotIn(List<Integer> values) {
            addCriterion("ic_id not in", values, "icId");
            return (Criteria) this;
        }

        public Criteria andIcIdBetween(Integer value1, Integer value2) {
            addCriterion("ic_id between", value1, value2, "icId");
            return (Criteria) this;
        }

        public Criteria andIcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ic_id not between", value1, value2, "icId");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
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

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andFalg1IsNull() {
            addCriterion("falg1 is null");
            return (Criteria) this;
        }

        public Criteria andFalg1IsNotNull() {
            addCriterion("falg1 is not null");
            return (Criteria) this;
        }

        public Criteria andFalg1EqualTo(String value) {
            addCriterion("falg1 =", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1NotEqualTo(String value) {
            addCriterion("falg1 <>", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1GreaterThan(String value) {
            addCriterion("falg1 >", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1GreaterThanOrEqualTo(String value) {
            addCriterion("falg1 >=", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1LessThan(String value) {
            addCriterion("falg1 <", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1LessThanOrEqualTo(String value) {
            addCriterion("falg1 <=", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1Like(String value) {
            addCriterion("falg1 like", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1NotLike(String value) {
            addCriterion("falg1 not like", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1In(List<String> values) {
            addCriterion("falg1 in", values, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1NotIn(List<String> values) {
            addCriterion("falg1 not in", values, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1Between(String value1, String value2) {
            addCriterion("falg1 between", value1, value2, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1NotBetween(String value1, String value2) {
            addCriterion("falg1 not between", value1, value2, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg2IsNull() {
            addCriterion("falg2 is null");
            return (Criteria) this;
        }

        public Criteria andFalg2IsNotNull() {
            addCriterion("falg2 is not null");
            return (Criteria) this;
        }

        public Criteria andFalg2EqualTo(String value) {
            addCriterion("falg2 =", value, "falg2");
            return (Criteria) this;
        }

        public Criteria andFalg2NotEqualTo(String value) {
            addCriterion("falg2 <>", value, "falg2");
            return (Criteria) this;
        }

        public Criteria andFalg2GreaterThan(String value) {
            addCriterion("falg2 >", value, "falg2");
            return (Criteria) this;
        }

        public Criteria andFalg2GreaterThanOrEqualTo(String value) {
            addCriterion("falg2 >=", value, "falg2");
            return (Criteria) this;
        }

        public Criteria andFalg2LessThan(String value) {
            addCriterion("falg2 <", value, "falg2");
            return (Criteria) this;
        }

        public Criteria andFalg2LessThanOrEqualTo(String value) {
            addCriterion("falg2 <=", value, "falg2");
            return (Criteria) this;
        }

        public Criteria andFalg2Like(String value) {
            addCriterion("falg2 like", value, "falg2");
            return (Criteria) this;
        }

        public Criteria andFalg2NotLike(String value) {
            addCriterion("falg2 not like", value, "falg2");
            return (Criteria) this;
        }

        public Criteria andFalg2In(List<String> values) {
            addCriterion("falg2 in", values, "falg2");
            return (Criteria) this;
        }

        public Criteria andFalg2NotIn(List<String> values) {
            addCriterion("falg2 not in", values, "falg2");
            return (Criteria) this;
        }

        public Criteria andFalg2Between(String value1, String value2) {
            addCriterion("falg2 between", value1, value2, "falg2");
            return (Criteria) this;
        }

        public Criteria andFalg2NotBetween(String value1, String value2) {
            addCriterion("falg2 not between", value1, value2, "falg2");
            return (Criteria) this;
        }

        public Criteria andFalg3IsNull() {
            addCriterion("falg3 is null");
            return (Criteria) this;
        }

        public Criteria andFalg3IsNotNull() {
            addCriterion("falg3 is not null");
            return (Criteria) this;
        }

        public Criteria andFalg3EqualTo(String value) {
            addCriterion("falg3 =", value, "falg3");
            return (Criteria) this;
        }

        public Criteria andFalg3NotEqualTo(String value) {
            addCriterion("falg3 <>", value, "falg3");
            return (Criteria) this;
        }

        public Criteria andFalg3GreaterThan(String value) {
            addCriterion("falg3 >", value, "falg3");
            return (Criteria) this;
        }

        public Criteria andFalg3GreaterThanOrEqualTo(String value) {
            addCriterion("falg3 >=", value, "falg3");
            return (Criteria) this;
        }

        public Criteria andFalg3LessThan(String value) {
            addCriterion("falg3 <", value, "falg3");
            return (Criteria) this;
        }

        public Criteria andFalg3LessThanOrEqualTo(String value) {
            addCriterion("falg3 <=", value, "falg3");
            return (Criteria) this;
        }

        public Criteria andFalg3Like(String value) {
            addCriterion("falg3 like", value, "falg3");
            return (Criteria) this;
        }

        public Criteria andFalg3NotLike(String value) {
            addCriterion("falg3 not like", value, "falg3");
            return (Criteria) this;
        }

        public Criteria andFalg3In(List<String> values) {
            addCriterion("falg3 in", values, "falg3");
            return (Criteria) this;
        }

        public Criteria andFalg3NotIn(List<String> values) {
            addCriterion("falg3 not in", values, "falg3");
            return (Criteria) this;
        }

        public Criteria andFalg3Between(String value1, String value2) {
            addCriterion("falg3 between", value1, value2, "falg3");
            return (Criteria) this;
        }

        public Criteria andFalg3NotBetween(String value1, String value2) {
            addCriterion("falg3 not between", value1, value2, "falg3");
            return (Criteria) this;
        }

        public Criteria andFalg4IsNull() {
            addCriterion("falg4 is null");
            return (Criteria) this;
        }

        public Criteria andFalg4IsNotNull() {
            addCriterion("falg4 is not null");
            return (Criteria) this;
        }

        public Criteria andFalg4EqualTo(String value) {
            addCriterion("falg4 =", value, "falg4");
            return (Criteria) this;
        }

        public Criteria andFalg4NotEqualTo(String value) {
            addCriterion("falg4 <>", value, "falg4");
            return (Criteria) this;
        }

        public Criteria andFalg4GreaterThan(String value) {
            addCriterion("falg4 >", value, "falg4");
            return (Criteria) this;
        }

        public Criteria andFalg4GreaterThanOrEqualTo(String value) {
            addCriterion("falg4 >=", value, "falg4");
            return (Criteria) this;
        }

        public Criteria andFalg4LessThan(String value) {
            addCriterion("falg4 <", value, "falg4");
            return (Criteria) this;
        }

        public Criteria andFalg4LessThanOrEqualTo(String value) {
            addCriterion("falg4 <=", value, "falg4");
            return (Criteria) this;
        }

        public Criteria andFalg4Like(String value) {
            addCriterion("falg4 like", value, "falg4");
            return (Criteria) this;
        }

        public Criteria andFalg4NotLike(String value) {
            addCriterion("falg4 not like", value, "falg4");
            return (Criteria) this;
        }

        public Criteria andFalg4In(List<String> values) {
            addCriterion("falg4 in", values, "falg4");
            return (Criteria) this;
        }

        public Criteria andFalg4NotIn(List<String> values) {
            addCriterion("falg4 not in", values, "falg4");
            return (Criteria) this;
        }

        public Criteria andFalg4Between(String value1, String value2) {
            addCriterion("falg4 between", value1, value2, "falg4");
            return (Criteria) this;
        }

        public Criteria andFalg4NotBetween(String value1, String value2) {
            addCriterion("falg4 not between", value1, value2, "falg4");
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