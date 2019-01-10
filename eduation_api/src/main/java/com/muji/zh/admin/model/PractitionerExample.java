package com.muji.zh.admin.model;

import java.util.ArrayList;
import java.util.List;

public class PractitionerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PractitionerExample() {
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

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
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

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberIsNull() {
            addCriterion("bank_card_number is null");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberIsNotNull() {
            addCriterion("bank_card_number is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberEqualTo(String value) {
            addCriterion("bank_card_number =", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotEqualTo(String value) {
            addCriterion("bank_card_number <>", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberGreaterThan(String value) {
            addCriterion("bank_card_number >", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_number >=", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberLessThan(String value) {
            addCriterion("bank_card_number <", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberLessThanOrEqualTo(String value) {
            addCriterion("bank_card_number <=", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberLike(String value) {
            addCriterion("bank_card_number like", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotLike(String value) {
            addCriterion("bank_card_number not like", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberIn(List<String> values) {
            addCriterion("bank_card_number in", values, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotIn(List<String> values) {
            addCriterion("bank_card_number not in", values, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberBetween(String value1, String value2) {
            addCriterion("bank_card_number between", value1, value2, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotBetween(String value1, String value2) {
            addCriterion("bank_card_number not between", value1, value2, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNull() {
            addCriterion("native_place is null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNotNull() {
            addCriterion("native_place is not null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceEqualTo(String value) {
            addCriterion("native_place =", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotEqualTo(String value) {
            addCriterion("native_place <>", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThan(String value) {
            addCriterion("native_place >", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("native_place >=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThan(String value) {
            addCriterion("native_place <", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("native_place <=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLike(String value) {
            addCriterion("native_place like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotLike(String value) {
            addCriterion("native_place not like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIn(List<String> values) {
            addCriterion("native_place in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotIn(List<String> values) {
            addCriterion("native_place not in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceBetween(String value1, String value2) {
            addCriterion("native_place between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotBetween(String value1, String value2) {
            addCriterion("native_place not between", value1, value2, "nativePlace");
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

        public Criteria andArrderssIsNull() {
            addCriterion("arrderss is null");
            return (Criteria) this;
        }

        public Criteria andArrderssIsNotNull() {
            addCriterion("arrderss is not null");
            return (Criteria) this;
        }

        public Criteria andArrderssEqualTo(String value) {
            addCriterion("arrderss =", value, "arrderss");
            return (Criteria) this;
        }

        public Criteria andArrderssNotEqualTo(String value) {
            addCriterion("arrderss <>", value, "arrderss");
            return (Criteria) this;
        }

        public Criteria andArrderssGreaterThan(String value) {
            addCriterion("arrderss >", value, "arrderss");
            return (Criteria) this;
        }

        public Criteria andArrderssGreaterThanOrEqualTo(String value) {
            addCriterion("arrderss >=", value, "arrderss");
            return (Criteria) this;
        }

        public Criteria andArrderssLessThan(String value) {
            addCriterion("arrderss <", value, "arrderss");
            return (Criteria) this;
        }

        public Criteria andArrderssLessThanOrEqualTo(String value) {
            addCriterion("arrderss <=", value, "arrderss");
            return (Criteria) this;
        }

        public Criteria andArrderssLike(String value) {
            addCriterion("arrderss like", value, "arrderss");
            return (Criteria) this;
        }

        public Criteria andArrderssNotLike(String value) {
            addCriterion("arrderss not like", value, "arrderss");
            return (Criteria) this;
        }

        public Criteria andArrderssIn(List<String> values) {
            addCriterion("arrderss in", values, "arrderss");
            return (Criteria) this;
        }

        public Criteria andArrderssNotIn(List<String> values) {
            addCriterion("arrderss not in", values, "arrderss");
            return (Criteria) this;
        }

        public Criteria andArrderssBetween(String value1, String value2) {
            addCriterion("arrderss between", value1, value2, "arrderss");
            return (Criteria) this;
        }

        public Criteria andArrderssNotBetween(String value1, String value2) {
            addCriterion("arrderss not between", value1, value2, "arrderss");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andGraduationIsNull() {
            addCriterion("graduation is null");
            return (Criteria) this;
        }

        public Criteria andGraduationIsNotNull() {
            addCriterion("graduation is not null");
            return (Criteria) this;
        }

        public Criteria andGraduationEqualTo(String value) {
            addCriterion("graduation =", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationNotEqualTo(String value) {
            addCriterion("graduation <>", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationGreaterThan(String value) {
            addCriterion("graduation >", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationGreaterThanOrEqualTo(String value) {
            addCriterion("graduation >=", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationLessThan(String value) {
            addCriterion("graduation <", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationLessThanOrEqualTo(String value) {
            addCriterion("graduation <=", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationLike(String value) {
            addCriterion("graduation like", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationNotLike(String value) {
            addCriterion("graduation not like", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationIn(List<String> values) {
            addCriterion("graduation in", values, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationNotIn(List<String> values) {
            addCriterion("graduation not in", values, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationBetween(String value1, String value2) {
            addCriterion("graduation between", value1, value2, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationNotBetween(String value1, String value2) {
            addCriterion("graduation not between", value1, value2, "graduation");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNull() {
            addCriterion("certificate is null");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNotNull() {
            addCriterion("certificate is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateEqualTo(String value) {
            addCriterion("certificate =", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotEqualTo(String value) {
            addCriterion("certificate <>", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThan(String value) {
            addCriterion("certificate >", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("certificate >=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThan(String value) {
            addCriterion("certificate <", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThanOrEqualTo(String value) {
            addCriterion("certificate <=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLike(String value) {
            addCriterion("certificate like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotLike(String value) {
            addCriterion("certificate not like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateIn(List<String> values) {
            addCriterion("certificate in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotIn(List<String> values) {
            addCriterion("certificate not in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateBetween(String value1, String value2) {
            addCriterion("certificate between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotBetween(String value1, String value2) {
            addCriterion("certificate not between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentIsNull() {
            addCriterion("isussing_deartment is null");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentIsNotNull() {
            addCriterion("isussing_deartment is not null");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentEqualTo(String value) {
            addCriterion("isussing_deartment =", value, "isussingDeartment");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentNotEqualTo(String value) {
            addCriterion("isussing_deartment <>", value, "isussingDeartment");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentGreaterThan(String value) {
            addCriterion("isussing_deartment >", value, "isussingDeartment");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentGreaterThanOrEqualTo(String value) {
            addCriterion("isussing_deartment >=", value, "isussingDeartment");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentLessThan(String value) {
            addCriterion("isussing_deartment <", value, "isussingDeartment");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentLessThanOrEqualTo(String value) {
            addCriterion("isussing_deartment <=", value, "isussingDeartment");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentLike(String value) {
            addCriterion("isussing_deartment like", value, "isussingDeartment");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentNotLike(String value) {
            addCriterion("isussing_deartment not like", value, "isussingDeartment");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentIn(List<String> values) {
            addCriterion("isussing_deartment in", values, "isussingDeartment");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentNotIn(List<String> values) {
            addCriterion("isussing_deartment not in", values, "isussingDeartment");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentBetween(String value1, String value2) {
            addCriterion("isussing_deartment between", value1, value2, "isussingDeartment");
            return (Criteria) this;
        }

        public Criteria andIsussingDeartmentNotBetween(String value1, String value2) {
            addCriterion("isussing_deartment not between", value1, value2, "isussingDeartment");
            return (Criteria) this;
        }

        public Criteria andKinderIdIsNull() {
            addCriterion("kinder_id is null");
            return (Criteria) this;
        }

        public Criteria andKinderIdIsNotNull() {
            addCriterion("kinder_id is not null");
            return (Criteria) this;
        }

        public Criteria andKinderIdEqualTo(Integer value) {
            addCriterion("kinder_id =", value, "kinderId");
            return (Criteria) this;
        }

        public Criteria andKinderIdNotEqualTo(Integer value) {
            addCriterion("kinder_id <>", value, "kinderId");
            return (Criteria) this;
        }

        public Criteria andKinderIdGreaterThan(Integer value) {
            addCriterion("kinder_id >", value, "kinderId");
            return (Criteria) this;
        }

        public Criteria andKinderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("kinder_id >=", value, "kinderId");
            return (Criteria) this;
        }

        public Criteria andKinderIdLessThan(Integer value) {
            addCriterion("kinder_id <", value, "kinderId");
            return (Criteria) this;
        }

        public Criteria andKinderIdLessThanOrEqualTo(Integer value) {
            addCriterion("kinder_id <=", value, "kinderId");
            return (Criteria) this;
        }

        public Criteria andKinderIdIn(List<Integer> values) {
            addCriterion("kinder_id in", values, "kinderId");
            return (Criteria) this;
        }

        public Criteria andKinderIdNotIn(List<Integer> values) {
            addCriterion("kinder_id not in", values, "kinderId");
            return (Criteria) this;
        }

        public Criteria andKinderIdBetween(Integer value1, Integer value2) {
            addCriterion("kinder_id between", value1, value2, "kinderId");
            return (Criteria) this;
        }

        public Criteria andKinderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("kinder_id not between", value1, value2, "kinderId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNull() {
            addCriterion("legal_person is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNotNull() {
            addCriterion("legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonEqualTo(String value) {
            addCriterion("legal_person =", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotEqualTo(String value) {
            addCriterion("legal_person <>", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThan(String value) {
            addCriterion("legal_person >", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person >=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThan(String value) {
            addCriterion("legal_person <", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("legal_person <=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLike(String value) {
            addCriterion("legal_person like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotLike(String value) {
            addCriterion("legal_person not like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIn(List<String> values) {
            addCriterion("legal_person in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotIn(List<String> values) {
            addCriterion("legal_person not in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonBetween(String value1, String value2) {
            addCriterion("legal_person between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotBetween(String value1, String value2) {
            addCriterion("legal_person not between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameIsNull() {
            addCriterion("legal_parson_name is null");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameIsNotNull() {
            addCriterion("legal_parson_name is not null");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameEqualTo(String value) {
            addCriterion("legal_parson_name =", value, "legalParsonName");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameNotEqualTo(String value) {
            addCriterion("legal_parson_name <>", value, "legalParsonName");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameGreaterThan(String value) {
            addCriterion("legal_parson_name >", value, "legalParsonName");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameGreaterThanOrEqualTo(String value) {
            addCriterion("legal_parson_name >=", value, "legalParsonName");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameLessThan(String value) {
            addCriterion("legal_parson_name <", value, "legalParsonName");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameLessThanOrEqualTo(String value) {
            addCriterion("legal_parson_name <=", value, "legalParsonName");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameLike(String value) {
            addCriterion("legal_parson_name like", value, "legalParsonName");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameNotLike(String value) {
            addCriterion("legal_parson_name not like", value, "legalParsonName");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameIn(List<String> values) {
            addCriterion("legal_parson_name in", values, "legalParsonName");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameNotIn(List<String> values) {
            addCriterion("legal_parson_name not in", values, "legalParsonName");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameBetween(String value1, String value2) {
            addCriterion("legal_parson_name between", value1, value2, "legalParsonName");
            return (Criteria) this;
        }

        public Criteria andLegalParsonNameNotBetween(String value1, String value2) {
            addCriterion("legal_parson_name not between", value1, value2, "legalParsonName");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneIsNull() {
            addCriterion("legal_parson_phone is null");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneIsNotNull() {
            addCriterion("legal_parson_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneEqualTo(String value) {
            addCriterion("legal_parson_phone =", value, "legalParsonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneNotEqualTo(String value) {
            addCriterion("legal_parson_phone <>", value, "legalParsonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneGreaterThan(String value) {
            addCriterion("legal_parson_phone >", value, "legalParsonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("legal_parson_phone >=", value, "legalParsonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneLessThan(String value) {
            addCriterion("legal_parson_phone <", value, "legalParsonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneLessThanOrEqualTo(String value) {
            addCriterion("legal_parson_phone <=", value, "legalParsonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneLike(String value) {
            addCriterion("legal_parson_phone like", value, "legalParsonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneNotLike(String value) {
            addCriterion("legal_parson_phone not like", value, "legalParsonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneIn(List<String> values) {
            addCriterion("legal_parson_phone in", values, "legalParsonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneNotIn(List<String> values) {
            addCriterion("legal_parson_phone not in", values, "legalParsonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneBetween(String value1, String value2) {
            addCriterion("legal_parson_phone between", value1, value2, "legalParsonPhone");
            return (Criteria) this;
        }

        public Criteria andLegalParsonPhoneNotBetween(String value1, String value2) {
            addCriterion("legal_parson_phone not between", value1, value2, "legalParsonPhone");
            return (Criteria) this;
        }

        public Criteria andWagesIsNull() {
            addCriterion("wages is null");
            return (Criteria) this;
        }

        public Criteria andWagesIsNotNull() {
            addCriterion("wages is not null");
            return (Criteria) this;
        }

        public Criteria andWagesEqualTo(Integer value) {
            addCriterion("wages =", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesNotEqualTo(Integer value) {
            addCriterion("wages <>", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesGreaterThan(Integer value) {
            addCriterion("wages >", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesGreaterThanOrEqualTo(Integer value) {
            addCriterion("wages >=", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesLessThan(Integer value) {
            addCriterion("wages <", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesLessThanOrEqualTo(Integer value) {
            addCriterion("wages <=", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesIn(List<Integer> values) {
            addCriterion("wages in", values, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesNotIn(List<Integer> values) {
            addCriterion("wages not in", values, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesBetween(Integer value1, Integer value2) {
            addCriterion("wages between", value1, value2, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesNotBetween(Integer value1, Integer value2) {
            addCriterion("wages not between", value1, value2, "wages");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIsNull() {
            addCriterion("social_security is null");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIsNotNull() {
            addCriterion("social_security is not null");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityEqualTo(String value) {
            addCriterion("social_security =", value, "socialSecurity");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityNotEqualTo(String value) {
            addCriterion("social_security <>", value, "socialSecurity");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityGreaterThan(String value) {
            addCriterion("social_security >", value, "socialSecurity");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityGreaterThanOrEqualTo(String value) {
            addCriterion("social_security >=", value, "socialSecurity");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityLessThan(String value) {
            addCriterion("social_security <", value, "socialSecurity");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityLessThanOrEqualTo(String value) {
            addCriterion("social_security <=", value, "socialSecurity");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityLike(String value) {
            addCriterion("social_security like", value, "socialSecurity");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityNotLike(String value) {
            addCriterion("social_security not like", value, "socialSecurity");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIn(List<String> values) {
            addCriterion("social_security in", values, "socialSecurity");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityNotIn(List<String> values) {
            addCriterion("social_security not in", values, "socialSecurity");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityBetween(String value1, String value2) {
            addCriterion("social_security between", value1, value2, "socialSecurity");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityNotBetween(String value1, String value2) {
            addCriterion("social_security not between", value1, value2, "socialSecurity");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesIsNull() {
            addCriterion("positional_titles is null");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesIsNotNull() {
            addCriterion("positional_titles is not null");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesEqualTo(String value) {
            addCriterion("positional_titles =", value, "positionalTitles");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesNotEqualTo(String value) {
            addCriterion("positional_titles <>", value, "positionalTitles");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesGreaterThan(String value) {
            addCriterion("positional_titles >", value, "positionalTitles");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesGreaterThanOrEqualTo(String value) {
            addCriterion("positional_titles >=", value, "positionalTitles");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesLessThan(String value) {
            addCriterion("positional_titles <", value, "positionalTitles");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesLessThanOrEqualTo(String value) {
            addCriterion("positional_titles <=", value, "positionalTitles");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesLike(String value) {
            addCriterion("positional_titles like", value, "positionalTitles");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesNotLike(String value) {
            addCriterion("positional_titles not like", value, "positionalTitles");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesIn(List<String> values) {
            addCriterion("positional_titles in", values, "positionalTitles");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesNotIn(List<String> values) {
            addCriterion("positional_titles not in", values, "positionalTitles");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesBetween(String value1, String value2) {
            addCriterion("positional_titles between", value1, value2, "positionalTitles");
            return (Criteria) this;
        }

        public Criteria andPositionalTitlesNotBetween(String value1, String value2) {
            addCriterion("positional_titles not between", value1, value2, "positionalTitles");
            return (Criteria) this;
        }

        public Criteria andMentalImageIsNull() {
            addCriterion("mental_image is null");
            return (Criteria) this;
        }

        public Criteria andMentalImageIsNotNull() {
            addCriterion("mental_image is not null");
            return (Criteria) this;
        }

        public Criteria andMentalImageEqualTo(String value) {
            addCriterion("mental_image =", value, "mentalImage");
            return (Criteria) this;
        }

        public Criteria andMentalImageNotEqualTo(String value) {
            addCriterion("mental_image <>", value, "mentalImage");
            return (Criteria) this;
        }

        public Criteria andMentalImageGreaterThan(String value) {
            addCriterion("mental_image >", value, "mentalImage");
            return (Criteria) this;
        }

        public Criteria andMentalImageGreaterThanOrEqualTo(String value) {
            addCriterion("mental_image >=", value, "mentalImage");
            return (Criteria) this;
        }

        public Criteria andMentalImageLessThan(String value) {
            addCriterion("mental_image <", value, "mentalImage");
            return (Criteria) this;
        }

        public Criteria andMentalImageLessThanOrEqualTo(String value) {
            addCriterion("mental_image <=", value, "mentalImage");
            return (Criteria) this;
        }

        public Criteria andMentalImageLike(String value) {
            addCriterion("mental_image like", value, "mentalImage");
            return (Criteria) this;
        }

        public Criteria andMentalImageNotLike(String value) {
            addCriterion("mental_image not like", value, "mentalImage");
            return (Criteria) this;
        }

        public Criteria andMentalImageIn(List<String> values) {
            addCriterion("mental_image in", values, "mentalImage");
            return (Criteria) this;
        }

        public Criteria andMentalImageNotIn(List<String> values) {
            addCriterion("mental_image not in", values, "mentalImage");
            return (Criteria) this;
        }

        public Criteria andMentalImageBetween(String value1, String value2) {
            addCriterion("mental_image between", value1, value2, "mentalImage");
            return (Criteria) this;
        }

        public Criteria andMentalImageNotBetween(String value1, String value2) {
            addCriterion("mental_image not between", value1, value2, "mentalImage");
            return (Criteria) this;
        }

        public Criteria andMentalHealthIsNull() {
            addCriterion("mental_health is null");
            return (Criteria) this;
        }

        public Criteria andMentalHealthIsNotNull() {
            addCriterion("mental_health is not null");
            return (Criteria) this;
        }

        public Criteria andMentalHealthEqualTo(String value) {
            addCriterion("mental_health =", value, "mentalHealth");
            return (Criteria) this;
        }

        public Criteria andMentalHealthNotEqualTo(String value) {
            addCriterion("mental_health <>", value, "mentalHealth");
            return (Criteria) this;
        }

        public Criteria andMentalHealthGreaterThan(String value) {
            addCriterion("mental_health >", value, "mentalHealth");
            return (Criteria) this;
        }

        public Criteria andMentalHealthGreaterThanOrEqualTo(String value) {
            addCriterion("mental_health >=", value, "mentalHealth");
            return (Criteria) this;
        }

        public Criteria andMentalHealthLessThan(String value) {
            addCriterion("mental_health <", value, "mentalHealth");
            return (Criteria) this;
        }

        public Criteria andMentalHealthLessThanOrEqualTo(String value) {
            addCriterion("mental_health <=", value, "mentalHealth");
            return (Criteria) this;
        }

        public Criteria andMentalHealthLike(String value) {
            addCriterion("mental_health like", value, "mentalHealth");
            return (Criteria) this;
        }

        public Criteria andMentalHealthNotLike(String value) {
            addCriterion("mental_health not like", value, "mentalHealth");
            return (Criteria) this;
        }

        public Criteria andMentalHealthIn(List<String> values) {
            addCriterion("mental_health in", values, "mentalHealth");
            return (Criteria) this;
        }

        public Criteria andMentalHealthNotIn(List<String> values) {
            addCriterion("mental_health not in", values, "mentalHealth");
            return (Criteria) this;
        }

        public Criteria andMentalHealthBetween(String value1, String value2) {
            addCriterion("mental_health between", value1, value2, "mentalHealth");
            return (Criteria) this;
        }

        public Criteria andMentalHealthNotBetween(String value1, String value2) {
            addCriterion("mental_health not between", value1, value2, "mentalHealth");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageIsNull() {
            addCriterion("physical_image is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageIsNotNull() {
            addCriterion("physical_image is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageEqualTo(String value) {
            addCriterion("physical_image =", value, "physicalImage");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageNotEqualTo(String value) {
            addCriterion("physical_image <>", value, "physicalImage");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageGreaterThan(String value) {
            addCriterion("physical_image >", value, "physicalImage");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageGreaterThanOrEqualTo(String value) {
            addCriterion("physical_image >=", value, "physicalImage");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageLessThan(String value) {
            addCriterion("physical_image <", value, "physicalImage");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageLessThanOrEqualTo(String value) {
            addCriterion("physical_image <=", value, "physicalImage");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageLike(String value) {
            addCriterion("physical_image like", value, "physicalImage");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageNotLike(String value) {
            addCriterion("physical_image not like", value, "physicalImage");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageIn(List<String> values) {
            addCriterion("physical_image in", values, "physicalImage");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageNotIn(List<String> values) {
            addCriterion("physical_image not in", values, "physicalImage");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageBetween(String value1, String value2) {
            addCriterion("physical_image between", value1, value2, "physicalImage");
            return (Criteria) this;
        }

        public Criteria andPhysicalImageNotBetween(String value1, String value2) {
            addCriterion("physical_image not between", value1, value2, "physicalImage");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthIsNull() {
            addCriterion("physical_health is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthIsNotNull() {
            addCriterion("physical_health is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthEqualTo(String value) {
            addCriterion("physical_health =", value, "physicalHealth");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthNotEqualTo(String value) {
            addCriterion("physical_health <>", value, "physicalHealth");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthGreaterThan(String value) {
            addCriterion("physical_health >", value, "physicalHealth");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthGreaterThanOrEqualTo(String value) {
            addCriterion("physical_health >=", value, "physicalHealth");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthLessThan(String value) {
            addCriterion("physical_health <", value, "physicalHealth");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthLessThanOrEqualTo(String value) {
            addCriterion("physical_health <=", value, "physicalHealth");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthLike(String value) {
            addCriterion("physical_health like", value, "physicalHealth");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthNotLike(String value) {
            addCriterion("physical_health not like", value, "physicalHealth");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthIn(List<String> values) {
            addCriterion("physical_health in", values, "physicalHealth");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthNotIn(List<String> values) {
            addCriterion("physical_health not in", values, "physicalHealth");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthBetween(String value1, String value2) {
            addCriterion("physical_health between", value1, value2, "physicalHealth");
            return (Criteria) this;
        }

        public Criteria andPhysicalHealthNotBetween(String value1, String value2) {
            addCriterion("physical_health not between", value1, value2, "physicalHealth");
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

        public Criteria andUbranIdIsNull() {
            addCriterion("ubran_id is null");
            return (Criteria) this;
        }

        public Criteria andUbranIdIsNotNull() {
            addCriterion("ubran_id is not null");
            return (Criteria) this;
        }

        public Criteria andUbranIdEqualTo(Integer value) {
            addCriterion("ubran_id =", value, "ubranId");
            return (Criteria) this;
        }

        public Criteria andUbranIdNotEqualTo(Integer value) {
            addCriterion("ubran_id <>", value, "ubranId");
            return (Criteria) this;
        }

        public Criteria andUbranIdGreaterThan(Integer value) {
            addCriterion("ubran_id >", value, "ubranId");
            return (Criteria) this;
        }

        public Criteria andUbranIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ubran_id >=", value, "ubranId");
            return (Criteria) this;
        }

        public Criteria andUbranIdLessThan(Integer value) {
            addCriterion("ubran_id <", value, "ubranId");
            return (Criteria) this;
        }

        public Criteria andUbranIdLessThanOrEqualTo(Integer value) {
            addCriterion("ubran_id <=", value, "ubranId");
            return (Criteria) this;
        }

        public Criteria andUbranIdIn(List<Integer> values) {
            addCriterion("ubran_id in", values, "ubranId");
            return (Criteria) this;
        }

        public Criteria andUbranIdNotIn(List<Integer> values) {
            addCriterion("ubran_id not in", values, "ubranId");
            return (Criteria) this;
        }

        public Criteria andUbranIdBetween(Integer value1, Integer value2) {
            addCriterion("ubran_id between", value1, value2, "ubranId");
            return (Criteria) this;
        }

        public Criteria andUbranIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ubran_id not between", value1, value2, "ubranId");
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

        public Criteria andClasDirectorIsNull() {
            addCriterion("clas_director is null");
            return (Criteria) this;
        }

        public Criteria andClasDirectorIsNotNull() {
            addCriterion("clas_director is not null");
            return (Criteria) this;
        }

        public Criteria andClasDirectorEqualTo(Integer value) {
            addCriterion("clas_director =", value, "clasDirector");
            return (Criteria) this;
        }

        public Criteria andClasDirectorNotEqualTo(Integer value) {
            addCriterion("clas_director <>", value, "clasDirector");
            return (Criteria) this;
        }

        public Criteria andClasDirectorGreaterThan(Integer value) {
            addCriterion("clas_director >", value, "clasDirector");
            return (Criteria) this;
        }

        public Criteria andClasDirectorGreaterThanOrEqualTo(Integer value) {
            addCriterion("clas_director >=", value, "clasDirector");
            return (Criteria) this;
        }

        public Criteria andClasDirectorLessThan(Integer value) {
            addCriterion("clas_director <", value, "clasDirector");
            return (Criteria) this;
        }

        public Criteria andClasDirectorLessThanOrEqualTo(Integer value) {
            addCriterion("clas_director <=", value, "clasDirector");
            return (Criteria) this;
        }

        public Criteria andClasDirectorIn(List<Integer> values) {
            addCriterion("clas_director in", values, "clasDirector");
            return (Criteria) this;
        }

        public Criteria andClasDirectorNotIn(List<Integer> values) {
            addCriterion("clas_director not in", values, "clasDirector");
            return (Criteria) this;
        }

        public Criteria andClasDirectorBetween(Integer value1, Integer value2) {
            addCriterion("clas_director between", value1, value2, "clasDirector");
            return (Criteria) this;
        }

        public Criteria andClasDirectorNotBetween(Integer value1, Integer value2) {
            addCriterion("clas_director not between", value1, value2, "clasDirector");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(Integer value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(Integer value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(Integer value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(Integer value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(Integer value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<Integer> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<Integer> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(Integer value1, Integer value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(Integer value1, Integer value2) {
            addCriterion("sign not between", value1, value2, "sign");
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

        public Criteria andFlag3IsNull() {
            addCriterion("flag3 is null");
            return (Criteria) this;
        }

        public Criteria andFlag3IsNotNull() {
            addCriterion("flag3 is not null");
            return (Criteria) this;
        }

        public Criteria andFlag3EqualTo(String value) {
            addCriterion("flag3 =", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3NotEqualTo(String value) {
            addCriterion("flag3 <>", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3GreaterThan(String value) {
            addCriterion("flag3 >", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3GreaterThanOrEqualTo(String value) {
            addCriterion("flag3 >=", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3LessThan(String value) {
            addCriterion("flag3 <", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3LessThanOrEqualTo(String value) {
            addCriterion("flag3 <=", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3Like(String value) {
            addCriterion("flag3 like", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3NotLike(String value) {
            addCriterion("flag3 not like", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3In(List<String> values) {
            addCriterion("flag3 in", values, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3NotIn(List<String> values) {
            addCriterion("flag3 not in", values, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3Between(String value1, String value2) {
            addCriterion("flag3 between", value1, value2, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3NotBetween(String value1, String value2) {
            addCriterion("flag3 not between", value1, value2, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag4IsNull() {
            addCriterion("flag4 is null");
            return (Criteria) this;
        }

        public Criteria andFlag4IsNotNull() {
            addCriterion("flag4 is not null");
            return (Criteria) this;
        }

        public Criteria andFlag4EqualTo(String value) {
            addCriterion("flag4 =", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4NotEqualTo(String value) {
            addCriterion("flag4 <>", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4GreaterThan(String value) {
            addCriterion("flag4 >", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4GreaterThanOrEqualTo(String value) {
            addCriterion("flag4 >=", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4LessThan(String value) {
            addCriterion("flag4 <", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4LessThanOrEqualTo(String value) {
            addCriterion("flag4 <=", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4Like(String value) {
            addCriterion("flag4 like", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4NotLike(String value) {
            addCriterion("flag4 not like", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4In(List<String> values) {
            addCriterion("flag4 in", values, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4NotIn(List<String> values) {
            addCriterion("flag4 not in", values, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4Between(String value1, String value2) {
            addCriterion("flag4 between", value1, value2, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4NotBetween(String value1, String value2) {
            addCriterion("flag4 not between", value1, value2, "flag4");
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