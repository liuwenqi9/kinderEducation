package com.muji.zh.admin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class KindergartenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KindergartenExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andKIdIsNull() {
            addCriterion("k_id is null");
            return (Criteria) this;
        }

        public Criteria andKIdIsNotNull() {
            addCriterion("k_id is not null");
            return (Criteria) this;
        }

        public Criteria andKIdEqualTo(Integer value) {
            addCriterion("k_id =", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdNotEqualTo(Integer value) {
            addCriterion("k_id <>", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdGreaterThan(Integer value) {
            addCriterion("k_id >", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("k_id >=", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdLessThan(Integer value) {
            addCriterion("k_id <", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdLessThanOrEqualTo(Integer value) {
            addCriterion("k_id <=", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdIn(List<Integer> values) {
            addCriterion("k_id in", values, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdNotIn(List<Integer> values) {
            addCriterion("k_id not in", values, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdBetween(Integer value1, Integer value2) {
            addCriterion("k_id between", value1, value2, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdNotBetween(Integer value1, Integer value2) {
            addCriterion("k_id not between", value1, value2, "kId");
            return (Criteria) this;
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

        public Criteria andKnameIsNull() {
            addCriterion("kname is null");
            return (Criteria) this;
        }

        public Criteria andKnameIsNotNull() {
            addCriterion("kname is not null");
            return (Criteria) this;
        }

        public Criteria andKnameEqualTo(String value) {
            addCriterion("kname =", value, "kname");
            return (Criteria) this;
        }

        public Criteria andKnameNotEqualTo(String value) {
            addCriterion("kname <>", value, "kname");
            return (Criteria) this;
        }

        public Criteria andKnameGreaterThan(String value) {
            addCriterion("kname >", value, "kname");
            return (Criteria) this;
        }

        public Criteria andKnameGreaterThanOrEqualTo(String value) {
            addCriterion("kname >=", value, "kname");
            return (Criteria) this;
        }

        public Criteria andKnameLessThan(String value) {
            addCriterion("kname <", value, "kname");
            return (Criteria) this;
        }

        public Criteria andKnameLessThanOrEqualTo(String value) {
            addCriterion("kname <=", value, "kname");
            return (Criteria) this;
        }

        public Criteria andKnameLike(String value) {
            addCriterion("kname like", value, "kname");
            return (Criteria) this;
        }

        public Criteria andKnameNotLike(String value) {
            addCriterion("kname not like", value, "kname");
            return (Criteria) this;
        }

        public Criteria andKnameIn(List<String> values) {
            addCriterion("kname in", values, "kname");
            return (Criteria) this;
        }

        public Criteria andKnameNotIn(List<String> values) {
            addCriterion("kname not in", values, "kname");
            return (Criteria) this;
        }

        public Criteria andKnameBetween(String value1, String value2) {
            addCriterion("kname between", value1, value2, "kname");
            return (Criteria) this;
        }

        public Criteria andKnameNotBetween(String value1, String value2) {
            addCriterion("kname not between", value1, value2, "kname");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureIsNull() {
            addCriterion("business_nature is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureIsNotNull() {
            addCriterion("business_nature is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureEqualTo(String value) {
            addCriterion("business_nature =", value, "businessNature");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureNotEqualTo(String value) {
            addCriterion("business_nature <>", value, "businessNature");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureGreaterThan(String value) {
            addCriterion("business_nature >", value, "businessNature");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureGreaterThanOrEqualTo(String value) {
            addCriterion("business_nature >=", value, "businessNature");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureLessThan(String value) {
            addCriterion("business_nature <", value, "businessNature");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureLessThanOrEqualTo(String value) {
            addCriterion("business_nature <=", value, "businessNature");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureLike(String value) {
            addCriterion("business_nature like", value, "businessNature");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureNotLike(String value) {
            addCriterion("business_nature not like", value, "businessNature");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureIn(List<String> values) {
            addCriterion("business_nature in", values, "businessNature");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureNotIn(List<String> values) {
            addCriterion("business_nature not in", values, "businessNature");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureBetween(String value1, String value2) {
            addCriterion("business_nature between", value1, value2, "businessNature");
            return (Criteria) this;
        }

        public Criteria andBusinessNatureNotBetween(String value1, String value2) {
            addCriterion("business_nature not between", value1, value2, "businessNature");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberIsNull() {
            addCriterion("license_number is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberIsNotNull() {
            addCriterion("license_number is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberEqualTo(String value) {
            addCriterion("license_number =", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberNotEqualTo(String value) {
            addCriterion("license_number <>", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberGreaterThan(String value) {
            addCriterion("license_number >", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberGreaterThanOrEqualTo(String value) {
            addCriterion("license_number >=", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberLessThan(String value) {
            addCriterion("license_number <", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberLessThanOrEqualTo(String value) {
            addCriterion("license_number <=", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberLike(String value) {
            addCriterion("license_number like", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberNotLike(String value) {
            addCriterion("license_number not like", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberIn(List<String> values) {
            addCriterion("license_number in", values, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberNotIn(List<String> values) {
            addCriterion("license_number not in", values, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberBetween(String value1, String value2) {
            addCriterion("license_number between", value1, value2, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberNotBetween(String value1, String value2) {
            addCriterion("license_number not between", value1, value2, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andEduIdIsNull() {
            addCriterion("edu_id is null");
            return (Criteria) this;
        }

        public Criteria andEduIdIsNotNull() {
            addCriterion("edu_id is not null");
            return (Criteria) this;
        }

        public Criteria andEduIdEqualTo(Integer value) {
            addCriterion("edu_id =", value, "eduId");
            return (Criteria) this;
        }

        public Criteria andEduIdNotEqualTo(Integer value) {
            addCriterion("edu_id <>", value, "eduId");
            return (Criteria) this;
        }

        public Criteria andEduIdGreaterThan(Integer value) {
            addCriterion("edu_id >", value, "eduId");
            return (Criteria) this;
        }

        public Criteria andEduIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("edu_id >=", value, "eduId");
            return (Criteria) this;
        }

        public Criteria andEduIdLessThan(Integer value) {
            addCriterion("edu_id <", value, "eduId");
            return (Criteria) this;
        }

        public Criteria andEduIdLessThanOrEqualTo(Integer value) {
            addCriterion("edu_id <=", value, "eduId");
            return (Criteria) this;
        }

        public Criteria andEduIdIn(List<Integer> values) {
            addCriterion("edu_id in", values, "eduId");
            return (Criteria) this;
        }

        public Criteria andEduIdNotIn(List<Integer> values) {
            addCriterion("edu_id not in", values, "eduId");
            return (Criteria) this;
        }

        public Criteria andEduIdBetween(Integer value1, Integer value2) {
            addCriterion("edu_id between", value1, value2, "eduId");
            return (Criteria) this;
        }

        public Criteria andEduIdNotBetween(Integer value1, Integer value2) {
            addCriterion("edu_id not between", value1, value2, "eduId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
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

        public Criteria andLegalIdIsNull() {
            addCriterion("legal_id is null");
            return (Criteria) this;
        }

        public Criteria andLegalIdIsNotNull() {
            addCriterion("legal_id is not null");
            return (Criteria) this;
        }

        public Criteria andLegalIdEqualTo(Integer value) {
            addCriterion("legal_id =", value, "legalId");
            return (Criteria) this;
        }

        public Criteria andLegalIdNotEqualTo(Integer value) {
            addCriterion("legal_id <>", value, "legalId");
            return (Criteria) this;
        }

        public Criteria andLegalIdGreaterThan(Integer value) {
            addCriterion("legal_id >", value, "legalId");
            return (Criteria) this;
        }

        public Criteria andLegalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("legal_id >=", value, "legalId");
            return (Criteria) this;
        }

        public Criteria andLegalIdLessThan(Integer value) {
            addCriterion("legal_id <", value, "legalId");
            return (Criteria) this;
        }

        public Criteria andLegalIdLessThanOrEqualTo(Integer value) {
            addCriterion("legal_id <=", value, "legalId");
            return (Criteria) this;
        }

        public Criteria andLegalIdIn(List<Integer> values) {
            addCriterion("legal_id in", values, "legalId");
            return (Criteria) this;
        }

        public Criteria andLegalIdNotIn(List<Integer> values) {
            addCriterion("legal_id not in", values, "legalId");
            return (Criteria) this;
        }

        public Criteria andLegalIdBetween(Integer value1, Integer value2) {
            addCriterion("legal_id between", value1, value2, "legalId");
            return (Criteria) this;
        }

        public Criteria andLegalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("legal_id not between", value1, value2, "legalId");
            return (Criteria) this;
        }

        public Criteria andPlanClassIsNull() {
            addCriterion("plan_class is null");
            return (Criteria) this;
        }

        public Criteria andPlanClassIsNotNull() {
            addCriterion("plan_class is not null");
            return (Criteria) this;
        }

        public Criteria andPlanClassEqualTo(Integer value) {
            addCriterion("plan_class =", value, "planClass");
            return (Criteria) this;
        }

        public Criteria andPlanClassNotEqualTo(Integer value) {
            addCriterion("plan_class <>", value, "planClass");
            return (Criteria) this;
        }

        public Criteria andPlanClassGreaterThan(Integer value) {
            addCriterion("plan_class >", value, "planClass");
            return (Criteria) this;
        }

        public Criteria andPlanClassGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_class >=", value, "planClass");
            return (Criteria) this;
        }

        public Criteria andPlanClassLessThan(Integer value) {
            addCriterion("plan_class <", value, "planClass");
            return (Criteria) this;
        }

        public Criteria andPlanClassLessThanOrEqualTo(Integer value) {
            addCriterion("plan_class <=", value, "planClass");
            return (Criteria) this;
        }

        public Criteria andPlanClassIn(List<Integer> values) {
            addCriterion("plan_class in", values, "planClass");
            return (Criteria) this;
        }

        public Criteria andPlanClassNotIn(List<Integer> values) {
            addCriterion("plan_class not in", values, "planClass");
            return (Criteria) this;
        }

        public Criteria andPlanClassBetween(Integer value1, Integer value2) {
            addCriterion("plan_class between", value1, value2, "planClass");
            return (Criteria) this;
        }

        public Criteria andPlanClassNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_class not between", value1, value2, "planClass");
            return (Criteria) this;
        }

        public Criteria andPlanPeopleIsNull() {
            addCriterion("plan_people is null");
            return (Criteria) this;
        }

        public Criteria andPlanPeopleIsNotNull() {
            addCriterion("plan_people is not null");
            return (Criteria) this;
        }

        public Criteria andPlanPeopleEqualTo(Integer value) {
            addCriterion("plan_people =", value, "planPeople");
            return (Criteria) this;
        }

        public Criteria andPlanPeopleNotEqualTo(Integer value) {
            addCriterion("plan_people <>", value, "planPeople");
            return (Criteria) this;
        }

        public Criteria andPlanPeopleGreaterThan(Integer value) {
            addCriterion("plan_people >", value, "planPeople");
            return (Criteria) this;
        }

        public Criteria andPlanPeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_people >=", value, "planPeople");
            return (Criteria) this;
        }

        public Criteria andPlanPeopleLessThan(Integer value) {
            addCriterion("plan_people <", value, "planPeople");
            return (Criteria) this;
        }

        public Criteria andPlanPeopleLessThanOrEqualTo(Integer value) {
            addCriterion("plan_people <=", value, "planPeople");
            return (Criteria) this;
        }

        public Criteria andPlanPeopleIn(List<Integer> values) {
            addCriterion("plan_people in", values, "planPeople");
            return (Criteria) this;
        }

        public Criteria andPlanPeopleNotIn(List<Integer> values) {
            addCriterion("plan_people not in", values, "planPeople");
            return (Criteria) this;
        }

        public Criteria andPlanPeopleBetween(Integer value1, Integer value2) {
            addCriterion("plan_people between", value1, value2, "planPeople");
            return (Criteria) this;
        }

        public Criteria andPlanPeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_people not between", value1, value2, "planPeople");
            return (Criteria) this;
        }

        public Criteria andPlanTeacherIsNull() {
            addCriterion("plan_teacher is null");
            return (Criteria) this;
        }

        public Criteria andPlanTeacherIsNotNull() {
            addCriterion("plan_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTeacherEqualTo(Integer value) {
            addCriterion("plan_teacher =", value, "planTeacher");
            return (Criteria) this;
        }

        public Criteria andPlanTeacherNotEqualTo(Integer value) {
            addCriterion("plan_teacher <>", value, "planTeacher");
            return (Criteria) this;
        }

        public Criteria andPlanTeacherGreaterThan(Integer value) {
            addCriterion("plan_teacher >", value, "planTeacher");
            return (Criteria) this;
        }

        public Criteria andPlanTeacherGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_teacher >=", value, "planTeacher");
            return (Criteria) this;
        }

        public Criteria andPlanTeacherLessThan(Integer value) {
            addCriterion("plan_teacher <", value, "planTeacher");
            return (Criteria) this;
        }

        public Criteria andPlanTeacherLessThanOrEqualTo(Integer value) {
            addCriterion("plan_teacher <=", value, "planTeacher");
            return (Criteria) this;
        }

        public Criteria andPlanTeacherIn(List<Integer> values) {
            addCriterion("plan_teacher in", values, "planTeacher");
            return (Criteria) this;
        }

        public Criteria andPlanTeacherNotIn(List<Integer> values) {
            addCriterion("plan_teacher not in", values, "planTeacher");
            return (Criteria) this;
        }

        public Criteria andPlanTeacherBetween(Integer value1, Integer value2) {
            addCriterion("plan_teacher between", value1, value2, "planTeacher");
            return (Criteria) this;
        }

        public Criteria andPlanTeacherNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_teacher not between", value1, value2, "planTeacher");
            return (Criteria) this;
        }

        public Criteria andGovernessIsNull() {
            addCriterion("governess is null");
            return (Criteria) this;
        }

        public Criteria andGovernessIsNotNull() {
            addCriterion("governess is not null");
            return (Criteria) this;
        }

        public Criteria andGovernessEqualTo(Integer value) {
            addCriterion("governess =", value, "governess");
            return (Criteria) this;
        }

        public Criteria andGovernessNotEqualTo(Integer value) {
            addCriterion("governess <>", value, "governess");
            return (Criteria) this;
        }

        public Criteria andGovernessGreaterThan(Integer value) {
            addCriterion("governess >", value, "governess");
            return (Criteria) this;
        }

        public Criteria andGovernessGreaterThanOrEqualTo(Integer value) {
            addCriterion("governess >=", value, "governess");
            return (Criteria) this;
        }

        public Criteria andGovernessLessThan(Integer value) {
            addCriterion("governess <", value, "governess");
            return (Criteria) this;
        }

        public Criteria andGovernessLessThanOrEqualTo(Integer value) {
            addCriterion("governess <=", value, "governess");
            return (Criteria) this;
        }

        public Criteria andGovernessIn(List<Integer> values) {
            addCriterion("governess in", values, "governess");
            return (Criteria) this;
        }

        public Criteria andGovernessNotIn(List<Integer> values) {
            addCriterion("governess not in", values, "governess");
            return (Criteria) this;
        }

        public Criteria andGovernessBetween(Integer value1, Integer value2) {
            addCriterion("governess between", value1, value2, "governess");
            return (Criteria) this;
        }

        public Criteria andGovernessNotBetween(Integer value1, Integer value2) {
            addCriterion("governess not between", value1, value2, "governess");
            return (Criteria) this;
        }

        public Criteria andOtherPeopleIsNull() {
            addCriterion("other_people is null");
            return (Criteria) this;
        }

        public Criteria andOtherPeopleIsNotNull() {
            addCriterion("other_people is not null");
            return (Criteria) this;
        }

        public Criteria andOtherPeopleEqualTo(Integer value) {
            addCriterion("other_people =", value, "otherPeople");
            return (Criteria) this;
        }

        public Criteria andOtherPeopleNotEqualTo(Integer value) {
            addCriterion("other_people <>", value, "otherPeople");
            return (Criteria) this;
        }

        public Criteria andOtherPeopleGreaterThan(Integer value) {
            addCriterion("other_people >", value, "otherPeople");
            return (Criteria) this;
        }

        public Criteria andOtherPeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("other_people >=", value, "otherPeople");
            return (Criteria) this;
        }

        public Criteria andOtherPeopleLessThan(Integer value) {
            addCriterion("other_people <", value, "otherPeople");
            return (Criteria) this;
        }

        public Criteria andOtherPeopleLessThanOrEqualTo(Integer value) {
            addCriterion("other_people <=", value, "otherPeople");
            return (Criteria) this;
        }

        public Criteria andOtherPeopleIn(List<Integer> values) {
            addCriterion("other_people in", values, "otherPeople");
            return (Criteria) this;
        }

        public Criteria andOtherPeopleNotIn(List<Integer> values) {
            addCriterion("other_people not in", values, "otherPeople");
            return (Criteria) this;
        }

        public Criteria andOtherPeopleBetween(Integer value1, Integer value2) {
            addCriterion("other_people between", value1, value2, "otherPeople");
            return (Criteria) this;
        }

        public Criteria andOtherPeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("other_people not between", value1, value2, "otherPeople");
            return (Criteria) this;
        }

        public Criteria andLeavePeopleIsNull() {
            addCriterion("leave_people is null");
            return (Criteria) this;
        }

        public Criteria andLeavePeopleIsNotNull() {
            addCriterion("leave_people is not null");
            return (Criteria) this;
        }

        public Criteria andLeavePeopleEqualTo(Integer value) {
            addCriterion("leave_people =", value, "leavePeople");
            return (Criteria) this;
        }

        public Criteria andLeavePeopleNotEqualTo(Integer value) {
            addCriterion("leave_people <>", value, "leavePeople");
            return (Criteria) this;
        }

        public Criteria andLeavePeopleGreaterThan(Integer value) {
            addCriterion("leave_people >", value, "leavePeople");
            return (Criteria) this;
        }

        public Criteria andLeavePeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_people >=", value, "leavePeople");
            return (Criteria) this;
        }

        public Criteria andLeavePeopleLessThan(Integer value) {
            addCriterion("leave_people <", value, "leavePeople");
            return (Criteria) this;
        }

        public Criteria andLeavePeopleLessThanOrEqualTo(Integer value) {
            addCriterion("leave_people <=", value, "leavePeople");
            return (Criteria) this;
        }

        public Criteria andLeavePeopleIn(List<Integer> values) {
            addCriterion("leave_people in", values, "leavePeople");
            return (Criteria) this;
        }

        public Criteria andLeavePeopleNotIn(List<Integer> values) {
            addCriterion("leave_people not in", values, "leavePeople");
            return (Criteria) this;
        }

        public Criteria andLeavePeopleBetween(Integer value1, Integer value2) {
            addCriterion("leave_people between", value1, value2, "leavePeople");
            return (Criteria) this;
        }

        public Criteria andLeavePeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_people not between", value1, value2, "leavePeople");
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

        public Criteria andGrossProductionIsNull() {
            addCriterion("gross_production is null");
            return (Criteria) this;
        }

        public Criteria andGrossProductionIsNotNull() {
            addCriterion("gross_production is not null");
            return (Criteria) this;
        }

        public Criteria andGrossProductionEqualTo(Integer value) {
            addCriterion("gross_production =", value, "grossProduction");
            return (Criteria) this;
        }

        public Criteria andGrossProductionNotEqualTo(Integer value) {
            addCriterion("gross_production <>", value, "grossProduction");
            return (Criteria) this;
        }

        public Criteria andGrossProductionGreaterThan(Integer value) {
            addCriterion("gross_production >", value, "grossProduction");
            return (Criteria) this;
        }

        public Criteria andGrossProductionGreaterThanOrEqualTo(Integer value) {
            addCriterion("gross_production >=", value, "grossProduction");
            return (Criteria) this;
        }

        public Criteria andGrossProductionLessThan(Integer value) {
            addCriterion("gross_production <", value, "grossProduction");
            return (Criteria) this;
        }

        public Criteria andGrossProductionLessThanOrEqualTo(Integer value) {
            addCriterion("gross_production <=", value, "grossProduction");
            return (Criteria) this;
        }

        public Criteria andGrossProductionIn(List<Integer> values) {
            addCriterion("gross_production in", values, "grossProduction");
            return (Criteria) this;
        }

        public Criteria andGrossProductionNotIn(List<Integer> values) {
            addCriterion("gross_production not in", values, "grossProduction");
            return (Criteria) this;
        }

        public Criteria andGrossProductionBetween(Integer value1, Integer value2) {
            addCriterion("gross_production between", value1, value2, "grossProduction");
            return (Criteria) this;
        }

        public Criteria andGrossProductionNotBetween(Integer value1, Integer value2) {
            addCriterion("gross_production not between", value1, value2, "grossProduction");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredIsNull() {
            addCriterion("area_covered is null");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredIsNotNull() {
            addCriterion("area_covered is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredEqualTo(Integer value) {
            addCriterion("area_covered =", value, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredNotEqualTo(Integer value) {
            addCriterion("area_covered <>", value, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredGreaterThan(Integer value) {
            addCriterion("area_covered >", value, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_covered >=", value, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredLessThan(Integer value) {
            addCriterion("area_covered <", value, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredLessThanOrEqualTo(Integer value) {
            addCriterion("area_covered <=", value, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredIn(List<Integer> values) {
            addCriterion("area_covered in", values, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredNotIn(List<Integer> values) {
            addCriterion("area_covered not in", values, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredBetween(Integer value1, Integer value2) {
            addCriterion("area_covered between", value1, value2, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredNotBetween(Integer value1, Integer value2) {
            addCriterion("area_covered not between", value1, value2, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAnnualIsNull() {
            addCriterion("annual is null");
            return (Criteria) this;
        }

        public Criteria andAnnualIsNotNull() {
            addCriterion("annual is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualEqualTo(Integer value) {
            addCriterion("annual =", value, "annual");
            return (Criteria) this;
        }

        public Criteria andAnnualNotEqualTo(Integer value) {
            addCriterion("annual <>", value, "annual");
            return (Criteria) this;
        }

        public Criteria andAnnualGreaterThan(Integer value) {
            addCriterion("annual >", value, "annual");
            return (Criteria) this;
        }

        public Criteria andAnnualGreaterThanOrEqualTo(Integer value) {
            addCriterion("annual >=", value, "annual");
            return (Criteria) this;
        }

        public Criteria andAnnualLessThan(Integer value) {
            addCriterion("annual <", value, "annual");
            return (Criteria) this;
        }

        public Criteria andAnnualLessThanOrEqualTo(Integer value) {
            addCriterion("annual <=", value, "annual");
            return (Criteria) this;
        }

        public Criteria andAnnualIn(List<Integer> values) {
            addCriterion("annual in", values, "annual");
            return (Criteria) this;
        }

        public Criteria andAnnualNotIn(List<Integer> values) {
            addCriterion("annual not in", values, "annual");
            return (Criteria) this;
        }

        public Criteria andAnnualBetween(Integer value1, Integer value2) {
            addCriterion("annual between", value1, value2, "annual");
            return (Criteria) this;
        }

        public Criteria andAnnualNotBetween(Integer value1, Integer value2) {
            addCriterion("annual not between", value1, value2, "annual");
            return (Criteria) this;
        }

        public Criteria andSocialDonationIsNull() {
            addCriterion("social_donation is null");
            return (Criteria) this;
        }

        public Criteria andSocialDonationIsNotNull() {
            addCriterion("social_donation is not null");
            return (Criteria) this;
        }

        public Criteria andSocialDonationEqualTo(Integer value) {
            addCriterion("social_donation =", value, "socialDonation");
            return (Criteria) this;
        }

        public Criteria andSocialDonationNotEqualTo(Integer value) {
            addCriterion("social_donation <>", value, "socialDonation");
            return (Criteria) this;
        }

        public Criteria andSocialDonationGreaterThan(Integer value) {
            addCriterion("social_donation >", value, "socialDonation");
            return (Criteria) this;
        }

        public Criteria andSocialDonationGreaterThanOrEqualTo(Integer value) {
            addCriterion("social_donation >=", value, "socialDonation");
            return (Criteria) this;
        }

        public Criteria andSocialDonationLessThan(Integer value) {
            addCriterion("social_donation <", value, "socialDonation");
            return (Criteria) this;
        }

        public Criteria andSocialDonationLessThanOrEqualTo(Integer value) {
            addCriterion("social_donation <=", value, "socialDonation");
            return (Criteria) this;
        }

        public Criteria andSocialDonationIn(List<Integer> values) {
            addCriterion("social_donation in", values, "socialDonation");
            return (Criteria) this;
        }

        public Criteria andSocialDonationNotIn(List<Integer> values) {
            addCriterion("social_donation not in", values, "socialDonation");
            return (Criteria) this;
        }

        public Criteria andSocialDonationBetween(Integer value1, Integer value2) {
            addCriterion("social_donation between", value1, value2, "socialDonation");
            return (Criteria) this;
        }

        public Criteria andSocialDonationNotBetween(Integer value1, Integer value2) {
            addCriterion("social_donation not between", value1, value2, "socialDonation");
            return (Criteria) this;
        }

        public Criteria andPremiumsIsNull() {
            addCriterion("premiums is null");
            return (Criteria) this;
        }

        public Criteria andPremiumsIsNotNull() {
            addCriterion("premiums is not null");
            return (Criteria) this;
        }

        public Criteria andPremiumsEqualTo(Integer value) {
            addCriterion("premiums =", value, "premiums");
            return (Criteria) this;
        }

        public Criteria andPremiumsNotEqualTo(Integer value) {
            addCriterion("premiums <>", value, "premiums");
            return (Criteria) this;
        }

        public Criteria andPremiumsGreaterThan(Integer value) {
            addCriterion("premiums >", value, "premiums");
            return (Criteria) this;
        }

        public Criteria andPremiumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("premiums >=", value, "premiums");
            return (Criteria) this;
        }

        public Criteria andPremiumsLessThan(Integer value) {
            addCriterion("premiums <", value, "premiums");
            return (Criteria) this;
        }

        public Criteria andPremiumsLessThanOrEqualTo(Integer value) {
            addCriterion("premiums <=", value, "premiums");
            return (Criteria) this;
        }

        public Criteria andPremiumsIn(List<Integer> values) {
            addCriterion("premiums in", values, "premiums");
            return (Criteria) this;
        }

        public Criteria andPremiumsNotIn(List<Integer> values) {
            addCriterion("premiums not in", values, "premiums");
            return (Criteria) this;
        }

        public Criteria andPremiumsBetween(Integer value1, Integer value2) {
            addCriterion("premiums between", value1, value2, "premiums");
            return (Criteria) this;
        }

        public Criteria andPremiumsNotBetween(Integer value1, Integer value2) {
            addCriterion("premiums not between", value1, value2, "premiums");
            return (Criteria) this;
        }

        public Criteria andDayCareIsNull() {
            addCriterion("day_care is null");
            return (Criteria) this;
        }

        public Criteria andDayCareIsNotNull() {
            addCriterion("day_care is not null");
            return (Criteria) this;
        }

        public Criteria andDayCareEqualTo(Integer value) {
            addCriterion("day_care =", value, "dayCare");
            return (Criteria) this;
        }

        public Criteria andDayCareNotEqualTo(Integer value) {
            addCriterion("day_care <>", value, "dayCare");
            return (Criteria) this;
        }

        public Criteria andDayCareGreaterThan(Integer value) {
            addCriterion("day_care >", value, "dayCare");
            return (Criteria) this;
        }

        public Criteria andDayCareGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_care >=", value, "dayCare");
            return (Criteria) this;
        }

        public Criteria andDayCareLessThan(Integer value) {
            addCriterion("day_care <", value, "dayCare");
            return (Criteria) this;
        }

        public Criteria andDayCareLessThanOrEqualTo(Integer value) {
            addCriterion("day_care <=", value, "dayCare");
            return (Criteria) this;
        }

        public Criteria andDayCareIn(List<Integer> values) {
            addCriterion("day_care in", values, "dayCare");
            return (Criteria) this;
        }

        public Criteria andDayCareNotIn(List<Integer> values) {
            addCriterion("day_care not in", values, "dayCare");
            return (Criteria) this;
        }

        public Criteria andDayCareBetween(Integer value1, Integer value2) {
            addCriterion("day_care between", value1, value2, "dayCare");
            return (Criteria) this;
        }

        public Criteria andDayCareNotBetween(Integer value1, Integer value2) {
            addCriterion("day_care not between", value1, value2, "dayCare");
            return (Criteria) this;
        }

        public Criteria andFullCareIsNull() {
            addCriterion("full_care is null");
            return (Criteria) this;
        }

        public Criteria andFullCareIsNotNull() {
            addCriterion("full_care is not null");
            return (Criteria) this;
        }

        public Criteria andFullCareEqualTo(Integer value) {
            addCriterion("full_care =", value, "fullCare");
            return (Criteria) this;
        }

        public Criteria andFullCareNotEqualTo(Integer value) {
            addCriterion("full_care <>", value, "fullCare");
            return (Criteria) this;
        }

        public Criteria andFullCareGreaterThan(Integer value) {
            addCriterion("full_care >", value, "fullCare");
            return (Criteria) this;
        }

        public Criteria andFullCareGreaterThanOrEqualTo(Integer value) {
            addCriterion("full_care >=", value, "fullCare");
            return (Criteria) this;
        }

        public Criteria andFullCareLessThan(Integer value) {
            addCriterion("full_care <", value, "fullCare");
            return (Criteria) this;
        }

        public Criteria andFullCareLessThanOrEqualTo(Integer value) {
            addCriterion("full_care <=", value, "fullCare");
            return (Criteria) this;
        }

        public Criteria andFullCareIn(List<Integer> values) {
            addCriterion("full_care in", values, "fullCare");
            return (Criteria) this;
        }

        public Criteria andFullCareNotIn(List<Integer> values) {
            addCriterion("full_care not in", values, "fullCare");
            return (Criteria) this;
        }

        public Criteria andFullCareBetween(Integer value1, Integer value2) {
            addCriterion("full_care between", value1, value2, "fullCare");
            return (Criteria) this;
        }

        public Criteria andFullCareNotBetween(Integer value1, Integer value2) {
            addCriterion("full_care not between", value1, value2, "fullCare");
            return (Criteria) this;
        }

        public Criteria andLittleTobIsNull() {
            addCriterion("little_tob is null");
            return (Criteria) this;
        }

        public Criteria andLittleTobIsNotNull() {
            addCriterion("little_tob is not null");
            return (Criteria) this;
        }

        public Criteria andLittleTobEqualTo(Integer value) {
            addCriterion("little_tob =", value, "littleTob");
            return (Criteria) this;
        }

        public Criteria andLittleTobNotEqualTo(Integer value) {
            addCriterion("little_tob <>", value, "littleTob");
            return (Criteria) this;
        }

        public Criteria andLittleTobGreaterThan(Integer value) {
            addCriterion("little_tob >", value, "littleTob");
            return (Criteria) this;
        }

        public Criteria andLittleTobGreaterThanOrEqualTo(Integer value) {
            addCriterion("little_tob >=", value, "littleTob");
            return (Criteria) this;
        }

        public Criteria andLittleTobLessThan(Integer value) {
            addCriterion("little_tob <", value, "littleTob");
            return (Criteria) this;
        }

        public Criteria andLittleTobLessThanOrEqualTo(Integer value) {
            addCriterion("little_tob <=", value, "littleTob");
            return (Criteria) this;
        }

        public Criteria andLittleTobIn(List<Integer> values) {
            addCriterion("little_tob in", values, "littleTob");
            return (Criteria) this;
        }

        public Criteria andLittleTobNotIn(List<Integer> values) {
            addCriterion("little_tob not in", values, "littleTob");
            return (Criteria) this;
        }

        public Criteria andLittleTobBetween(Integer value1, Integer value2) {
            addCriterion("little_tob between", value1, value2, "littleTob");
            return (Criteria) this;
        }

        public Criteria andLittleTobNotBetween(Integer value1, Integer value2) {
            addCriterion("little_tob not between", value1, value2, "littleTob");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Integer value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Integer value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Integer value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Integer value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Integer value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Integer> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Integer> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Integer value1, Integer value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Integer value1, Integer value2) {
            addCriterion("rank not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andUrbanIdIsNull() {
            addCriterion("urban_id is null");
            return (Criteria) this;
        }

        public Criteria andUrbanIdIsNotNull() {
            addCriterion("urban_id is not null");
            return (Criteria) this;
        }

        public Criteria andUrbanIdEqualTo(Integer value) {
            addCriterion("urban_id =", value, "urbanId");
            return (Criteria) this;
        }

        public Criteria andUrbanIdNotEqualTo(Integer value) {
            addCriterion("urban_id <>", value, "urbanId");
            return (Criteria) this;
        }

        public Criteria andUrbanIdGreaterThan(Integer value) {
            addCriterion("urban_id >", value, "urbanId");
            return (Criteria) this;
        }

        public Criteria andUrbanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("urban_id >=", value, "urbanId");
            return (Criteria) this;
        }

        public Criteria andUrbanIdLessThan(Integer value) {
            addCriterion("urban_id <", value, "urbanId");
            return (Criteria) this;
        }

        public Criteria andUrbanIdLessThanOrEqualTo(Integer value) {
            addCriterion("urban_id <=", value, "urbanId");
            return (Criteria) this;
        }

        public Criteria andUrbanIdIn(List<Integer> values) {
            addCriterion("urban_id in", values, "urbanId");
            return (Criteria) this;
        }

        public Criteria andUrbanIdNotIn(List<Integer> values) {
            addCriterion("urban_id not in", values, "urbanId");
            return (Criteria) this;
        }

        public Criteria andUrbanIdBetween(Integer value1, Integer value2) {
            addCriterion("urban_id between", value1, value2, "urbanId");
            return (Criteria) this;
        }

        public Criteria andUrbanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("urban_id not between", value1, value2, "urbanId");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1IsNull() {
            addCriterion("edu_department1 is null");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1IsNotNull() {
            addCriterion("edu_department1 is not null");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1EqualTo(String value) {
            addCriterion("edu_department1 =", value, "eduDepartment1");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1NotEqualTo(String value) {
            addCriterion("edu_department1 <>", value, "eduDepartment1");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1GreaterThan(String value) {
            addCriterion("edu_department1 >", value, "eduDepartment1");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1GreaterThanOrEqualTo(String value) {
            addCriterion("edu_department1 >=", value, "eduDepartment1");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1LessThan(String value) {
            addCriterion("edu_department1 <", value, "eduDepartment1");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1LessThanOrEqualTo(String value) {
            addCriterion("edu_department1 <=", value, "eduDepartment1");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1Like(String value) {
            addCriterion("edu_department1 like", value, "eduDepartment1");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1NotLike(String value) {
            addCriterion("edu_department1 not like", value, "eduDepartment1");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1In(List<String> values) {
            addCriterion("edu_department1 in", values, "eduDepartment1");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1NotIn(List<String> values) {
            addCriterion("edu_department1 not in", values, "eduDepartment1");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1Between(String value1, String value2) {
            addCriterion("edu_department1 between", value1, value2, "eduDepartment1");
            return (Criteria) this;
        }

        public Criteria andEduDepartment1NotBetween(String value1, String value2) {
            addCriterion("edu_department1 not between", value1, value2, "eduDepartment1");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2IsNull() {
            addCriterion("edu_department2 is null");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2IsNotNull() {
            addCriterion("edu_department2 is not null");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2EqualTo(String value) {
            addCriterion("edu_department2 =", value, "eduDepartment2");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2NotEqualTo(String value) {
            addCriterion("edu_department2 <>", value, "eduDepartment2");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2GreaterThan(String value) {
            addCriterion("edu_department2 >", value, "eduDepartment2");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2GreaterThanOrEqualTo(String value) {
            addCriterion("edu_department2 >=", value, "eduDepartment2");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2LessThan(String value) {
            addCriterion("edu_department2 <", value, "eduDepartment2");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2LessThanOrEqualTo(String value) {
            addCriterion("edu_department2 <=", value, "eduDepartment2");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2Like(String value) {
            addCriterion("edu_department2 like", value, "eduDepartment2");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2NotLike(String value) {
            addCriterion("edu_department2 not like", value, "eduDepartment2");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2In(List<String> values) {
            addCriterion("edu_department2 in", values, "eduDepartment2");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2NotIn(List<String> values) {
            addCriterion("edu_department2 not in", values, "eduDepartment2");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2Between(String value1, String value2) {
            addCriterion("edu_department2 between", value1, value2, "eduDepartment2");
            return (Criteria) this;
        }

        public Criteria andEduDepartment2NotBetween(String value1, String value2) {
            addCriterion("edu_department2 not between", value1, value2, "eduDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2IsNull() {
            addCriterion("price_department2 is null");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2IsNotNull() {
            addCriterion("price_department2 is not null");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2EqualTo(String value) {
            addCriterion("price_department2 =", value, "priceDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2NotEqualTo(String value) {
            addCriterion("price_department2 <>", value, "priceDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2GreaterThan(String value) {
            addCriterion("price_department2 >", value, "priceDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2GreaterThanOrEqualTo(String value) {
            addCriterion("price_department2 >=", value, "priceDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2LessThan(String value) {
            addCriterion("price_department2 <", value, "priceDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2LessThanOrEqualTo(String value) {
            addCriterion("price_department2 <=", value, "priceDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2Like(String value) {
            addCriterion("price_department2 like", value, "priceDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2NotLike(String value) {
            addCriterion("price_department2 not like", value, "priceDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2In(List<String> values) {
            addCriterion("price_department2 in", values, "priceDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2NotIn(List<String> values) {
            addCriterion("price_department2 not in", values, "priceDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2Between(String value1, String value2) {
            addCriterion("price_department2 between", value1, value2, "priceDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment2NotBetween(String value1, String value2) {
            addCriterion("price_department2 not between", value1, value2, "priceDepartment2");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1IsNull() {
            addCriterion("price_department1 is null");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1IsNotNull() {
            addCriterion("price_department1 is not null");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1EqualTo(String value) {
            addCriterion("price_department1 =", value, "priceDepartment1");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1NotEqualTo(String value) {
            addCriterion("price_department1 <>", value, "priceDepartment1");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1GreaterThan(String value) {
            addCriterion("price_department1 >", value, "priceDepartment1");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1GreaterThanOrEqualTo(String value) {
            addCriterion("price_department1 >=", value, "priceDepartment1");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1LessThan(String value) {
            addCriterion("price_department1 <", value, "priceDepartment1");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1LessThanOrEqualTo(String value) {
            addCriterion("price_department1 <=", value, "priceDepartment1");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1Like(String value) {
            addCriterion("price_department1 like", value, "priceDepartment1");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1NotLike(String value) {
            addCriterion("price_department1 not like", value, "priceDepartment1");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1In(List<String> values) {
            addCriterion("price_department1 in", values, "priceDepartment1");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1NotIn(List<String> values) {
            addCriterion("price_department1 not in", values, "priceDepartment1");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1Between(String value1, String value2) {
            addCriterion("price_department1 between", value1, value2, "priceDepartment1");
            return (Criteria) this;
        }

        public Criteria andPriceDepartment1NotBetween(String value1, String value2) {
            addCriterion("price_department1 not between", value1, value2, "priceDepartment1");
            return (Criteria) this;
        }

        public Criteria andChargename2IsNull() {
            addCriterion("chargename2 is null");
            return (Criteria) this;
        }

        public Criteria andChargename2IsNotNull() {
            addCriterion("chargename2 is not null");
            return (Criteria) this;
        }

        public Criteria andChargename2EqualTo(String value) {
            addCriterion("chargename2 =", value, "chargename2");
            return (Criteria) this;
        }

        public Criteria andChargename2NotEqualTo(String value) {
            addCriterion("chargename2 <>", value, "chargename2");
            return (Criteria) this;
        }

        public Criteria andChargename2GreaterThan(String value) {
            addCriterion("chargename2 >", value, "chargename2");
            return (Criteria) this;
        }

        public Criteria andChargename2GreaterThanOrEqualTo(String value) {
            addCriterion("chargename2 >=", value, "chargename2");
            return (Criteria) this;
        }

        public Criteria andChargename2LessThan(String value) {
            addCriterion("chargename2 <", value, "chargename2");
            return (Criteria) this;
        }

        public Criteria andChargename2LessThanOrEqualTo(String value) {
            addCriterion("chargename2 <=", value, "chargename2");
            return (Criteria) this;
        }

        public Criteria andChargename2Like(String value) {
            addCriterion("chargename2 like", value, "chargename2");
            return (Criteria) this;
        }

        public Criteria andChargename2NotLike(String value) {
            addCriterion("chargename2 not like", value, "chargename2");
            return (Criteria) this;
        }

        public Criteria andChargename2In(List<String> values) {
            addCriterion("chargename2 in", values, "chargename2");
            return (Criteria) this;
        }

        public Criteria andChargename2NotIn(List<String> values) {
            addCriterion("chargename2 not in", values, "chargename2");
            return (Criteria) this;
        }

        public Criteria andChargename2Between(String value1, String value2) {
            addCriterion("chargename2 between", value1, value2, "chargename2");
            return (Criteria) this;
        }

        public Criteria andChargename2NotBetween(String value1, String value2) {
            addCriterion("chargename2 not between", value1, value2, "chargename2");
            return (Criteria) this;
        }

        public Criteria andOfficalname1IsNull() {
            addCriterion("officalname1 is null");
            return (Criteria) this;
        }

        public Criteria andOfficalname1IsNotNull() {
            addCriterion("officalname1 is not null");
            return (Criteria) this;
        }

        public Criteria andOfficalname1EqualTo(String value) {
            addCriterion("officalname1 =", value, "officalname1");
            return (Criteria) this;
        }

        public Criteria andOfficalname1NotEqualTo(String value) {
            addCriterion("officalname1 <>", value, "officalname1");
            return (Criteria) this;
        }

        public Criteria andOfficalname1GreaterThan(String value) {
            addCriterion("officalname1 >", value, "officalname1");
            return (Criteria) this;
        }

        public Criteria andOfficalname1GreaterThanOrEqualTo(String value) {
            addCriterion("officalname1 >=", value, "officalname1");
            return (Criteria) this;
        }

        public Criteria andOfficalname1LessThan(String value) {
            addCriterion("officalname1 <", value, "officalname1");
            return (Criteria) this;
        }

        public Criteria andOfficalname1LessThanOrEqualTo(String value) {
            addCriterion("officalname1 <=", value, "officalname1");
            return (Criteria) this;
        }

        public Criteria andOfficalname1Like(String value) {
            addCriterion("officalname1 like", value, "officalname1");
            return (Criteria) this;
        }

        public Criteria andOfficalname1NotLike(String value) {
            addCriterion("officalname1 not like", value, "officalname1");
            return (Criteria) this;
        }

        public Criteria andOfficalname1In(List<String> values) {
            addCriterion("officalname1 in", values, "officalname1");
            return (Criteria) this;
        }

        public Criteria andOfficalname1NotIn(List<String> values) {
            addCriterion("officalname1 not in", values, "officalname1");
            return (Criteria) this;
        }

        public Criteria andOfficalname1Between(String value1, String value2) {
            addCriterion("officalname1 between", value1, value2, "officalname1");
            return (Criteria) this;
        }

        public Criteria andOfficalname1NotBetween(String value1, String value2) {
            addCriterion("officalname1 not between", value1, value2, "officalname1");
            return (Criteria) this;
        }

        public Criteria andOfficalname2IsNull() {
            addCriterion("officalname2 is null");
            return (Criteria) this;
        }

        public Criteria andOfficalname2IsNotNull() {
            addCriterion("officalname2 is not null");
            return (Criteria) this;
        }

        public Criteria andOfficalname2EqualTo(String value) {
            addCriterion("officalname2 =", value, "officalname2");
            return (Criteria) this;
        }

        public Criteria andOfficalname2NotEqualTo(String value) {
            addCriterion("officalname2 <>", value, "officalname2");
            return (Criteria) this;
        }

        public Criteria andOfficalname2GreaterThan(String value) {
            addCriterion("officalname2 >", value, "officalname2");
            return (Criteria) this;
        }

        public Criteria andOfficalname2GreaterThanOrEqualTo(String value) {
            addCriterion("officalname2 >=", value, "officalname2");
            return (Criteria) this;
        }

        public Criteria andOfficalname2LessThan(String value) {
            addCriterion("officalname2 <", value, "officalname2");
            return (Criteria) this;
        }

        public Criteria andOfficalname2LessThanOrEqualTo(String value) {
            addCriterion("officalname2 <=", value, "officalname2");
            return (Criteria) this;
        }

        public Criteria andOfficalname2Like(String value) {
            addCriterion("officalname2 like", value, "officalname2");
            return (Criteria) this;
        }

        public Criteria andOfficalname2NotLike(String value) {
            addCriterion("officalname2 not like", value, "officalname2");
            return (Criteria) this;
        }

        public Criteria andOfficalname2In(List<String> values) {
            addCriterion("officalname2 in", values, "officalname2");
            return (Criteria) this;
        }

        public Criteria andOfficalname2NotIn(List<String> values) {
            addCriterion("officalname2 not in", values, "officalname2");
            return (Criteria) this;
        }

        public Criteria andOfficalname2Between(String value1, String value2) {
            addCriterion("officalname2 between", value1, value2, "officalname2");
            return (Criteria) this;
        }

        public Criteria andOfficalname2NotBetween(String value1, String value2) {
            addCriterion("officalname2 not between", value1, value2, "officalname2");
            return (Criteria) this;
        }

        public Criteria andFireworkIsNull() {
            addCriterion("firework is null");
            return (Criteria) this;
        }

        public Criteria andFireworkIsNotNull() {
            addCriterion("firework is not null");
            return (Criteria) this;
        }

        public Criteria andFireworkEqualTo(String value) {
            addCriterion("firework =", value, "firework");
            return (Criteria) this;
        }

        public Criteria andFireworkNotEqualTo(String value) {
            addCriterion("firework <>", value, "firework");
            return (Criteria) this;
        }

        public Criteria andFireworkGreaterThan(String value) {
            addCriterion("firework >", value, "firework");
            return (Criteria) this;
        }

        public Criteria andFireworkGreaterThanOrEqualTo(String value) {
            addCriterion("firework >=", value, "firework");
            return (Criteria) this;
        }

        public Criteria andFireworkLessThan(String value) {
            addCriterion("firework <", value, "firework");
            return (Criteria) this;
        }

        public Criteria andFireworkLessThanOrEqualTo(String value) {
            addCriterion("firework <=", value, "firework");
            return (Criteria) this;
        }

        public Criteria andFireworkLike(String value) {
            addCriterion("firework like", value, "firework");
            return (Criteria) this;
        }

        public Criteria andFireworkNotLike(String value) {
            addCriterion("firework not like", value, "firework");
            return (Criteria) this;
        }

        public Criteria andFireworkIn(List<String> values) {
            addCriterion("firework in", values, "firework");
            return (Criteria) this;
        }

        public Criteria andFireworkNotIn(List<String> values) {
            addCriterion("firework not in", values, "firework");
            return (Criteria) this;
        }

        public Criteria andFireworkBetween(String value1, String value2) {
            addCriterion("firework between", value1, value2, "firework");
            return (Criteria) this;
        }

        public Criteria andFireworkNotBetween(String value1, String value2) {
            addCriterion("firework not between", value1, value2, "firework");
            return (Criteria) this;
        }

        public Criteria andFireworknoIsNull() {
            addCriterion("fireworkNo is null");
            return (Criteria) this;
        }

        public Criteria andFireworknoIsNotNull() {
            addCriterion("fireworkNo is not null");
            return (Criteria) this;
        }

        public Criteria andFireworknoEqualTo(String value) {
            addCriterion("fireworkNo =", value, "fireworkno");
            return (Criteria) this;
        }

        public Criteria andFireworknoNotEqualTo(String value) {
            addCriterion("fireworkNo <>", value, "fireworkno");
            return (Criteria) this;
        }

        public Criteria andFireworknoGreaterThan(String value) {
            addCriterion("fireworkNo >", value, "fireworkno");
            return (Criteria) this;
        }

        public Criteria andFireworknoGreaterThanOrEqualTo(String value) {
            addCriterion("fireworkNo >=", value, "fireworkno");
            return (Criteria) this;
        }

        public Criteria andFireworknoLessThan(String value) {
            addCriterion("fireworkNo <", value, "fireworkno");
            return (Criteria) this;
        }

        public Criteria andFireworknoLessThanOrEqualTo(String value) {
            addCriterion("fireworkNo <=", value, "fireworkno");
            return (Criteria) this;
        }

        public Criteria andFireworknoLike(String value) {
            addCriterion("fireworkNo like", value, "fireworkno");
            return (Criteria) this;
        }

        public Criteria andFireworknoNotLike(String value) {
            addCriterion("fireworkNo not like", value, "fireworkno");
            return (Criteria) this;
        }

        public Criteria andFireworknoIn(List<String> values) {
            addCriterion("fireworkNo in", values, "fireworkno");
            return (Criteria) this;
        }

        public Criteria andFireworknoNotIn(List<String> values) {
            addCriterion("fireworkNo not in", values, "fireworkno");
            return (Criteria) this;
        }

        public Criteria andFireworknoBetween(String value1, String value2) {
            addCriterion("fireworkNo between", value1, value2, "fireworkno");
            return (Criteria) this;
        }

        public Criteria andFireworknoNotBetween(String value1, String value2) {
            addCriterion("fireworkNo not between", value1, value2, "fireworkno");
            return (Criteria) this;
        }

        public Criteria andChargename1IsNull() {
            addCriterion("chargename1 is null");
            return (Criteria) this;
        }

        public Criteria andChargename1IsNotNull() {
            addCriterion("chargename1 is not null");
            return (Criteria) this;
        }

        public Criteria andChargename1EqualTo(String value) {
            addCriterion("chargename1 =", value, "chargename1");
            return (Criteria) this;
        }

        public Criteria andChargename1NotEqualTo(String value) {
            addCriterion("chargename1 <>", value, "chargename1");
            return (Criteria) this;
        }

        public Criteria andChargename1GreaterThan(String value) {
            addCriterion("chargename1 >", value, "chargename1");
            return (Criteria) this;
        }

        public Criteria andChargename1GreaterThanOrEqualTo(String value) {
            addCriterion("chargename1 >=", value, "chargename1");
            return (Criteria) this;
        }

        public Criteria andChargename1LessThan(String value) {
            addCriterion("chargename1 <", value, "chargename1");
            return (Criteria) this;
        }

        public Criteria andChargename1LessThanOrEqualTo(String value) {
            addCriterion("chargename1 <=", value, "chargename1");
            return (Criteria) this;
        }

        public Criteria andChargename1Like(String value) {
            addCriterion("chargename1 like", value, "chargename1");
            return (Criteria) this;
        }

        public Criteria andChargename1NotLike(String value) {
            addCriterion("chargename1 not like", value, "chargename1");
            return (Criteria) this;
        }

        public Criteria andChargename1In(List<String> values) {
            addCriterion("chargename1 in", values, "chargename1");
            return (Criteria) this;
        }

        public Criteria andChargename1NotIn(List<String> values) {
            addCriterion("chargename1 not in", values, "chargename1");
            return (Criteria) this;
        }

        public Criteria andChargename1Between(String value1, String value2) {
            addCriterion("chargename1 between", value1, value2, "chargename1");
            return (Criteria) this;
        }

        public Criteria andChargename1NotBetween(String value1, String value2) {
            addCriterion("chargename1 not between", value1, value2, "chargename1");
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

        public Criteria andFlag5IsNull() {
            addCriterion("flag5 is null");
            return (Criteria) this;
        }

        public Criteria andFlag5IsNotNull() {
            addCriterion("flag5 is not null");
            return (Criteria) this;
        }

        public Criteria andFlag5EqualTo(String value) {
            addCriterion("flag5 =", value, "flag5");
            return (Criteria) this;
        }

        public Criteria andFlag5NotEqualTo(String value) {
            addCriterion("flag5 <>", value, "flag5");
            return (Criteria) this;
        }

        public Criteria andFlag5GreaterThan(String value) {
            addCriterion("flag5 >", value, "flag5");
            return (Criteria) this;
        }

        public Criteria andFlag5GreaterThanOrEqualTo(String value) {
            addCriterion("flag5 >=", value, "flag5");
            return (Criteria) this;
        }

        public Criteria andFlag5LessThan(String value) {
            addCriterion("flag5 <", value, "flag5");
            return (Criteria) this;
        }

        public Criteria andFlag5LessThanOrEqualTo(String value) {
            addCriterion("flag5 <=", value, "flag5");
            return (Criteria) this;
        }

        public Criteria andFlag5Like(String value) {
            addCriterion("flag5 like", value, "flag5");
            return (Criteria) this;
        }

        public Criteria andFlag5NotLike(String value) {
            addCriterion("flag5 not like", value, "flag5");
            return (Criteria) this;
        }

        public Criteria andFlag5In(List<String> values) {
            addCriterion("flag5 in", values, "flag5");
            return (Criteria) this;
        }

        public Criteria andFlag5NotIn(List<String> values) {
            addCriterion("flag5 not in", values, "flag5");
            return (Criteria) this;
        }

        public Criteria andFlag5Between(String value1, String value2) {
            addCriterion("flag5 between", value1, value2, "flag5");
            return (Criteria) this;
        }

        public Criteria andFlag5NotBetween(String value1, String value2) {
            addCriterion("flag5 not between", value1, value2, "flag5");
            return (Criteria) this;
        }

        public Criteria andFlag6IsNull() {
            addCriterion("flag6 is null");
            return (Criteria) this;
        }

        public Criteria andFlag6IsNotNull() {
            addCriterion("flag6 is not null");
            return (Criteria) this;
        }

        public Criteria andFlag6EqualTo(String value) {
            addCriterion("flag6 =", value, "flag6");
            return (Criteria) this;
        }

        public Criteria andFlag6NotEqualTo(String value) {
            addCriterion("flag6 <>", value, "flag6");
            return (Criteria) this;
        }

        public Criteria andFlag6GreaterThan(String value) {
            addCriterion("flag6 >", value, "flag6");
            return (Criteria) this;
        }

        public Criteria andFlag6GreaterThanOrEqualTo(String value) {
            addCriterion("flag6 >=", value, "flag6");
            return (Criteria) this;
        }

        public Criteria andFlag6LessThan(String value) {
            addCriterion("flag6 <", value, "flag6");
            return (Criteria) this;
        }

        public Criteria andFlag6LessThanOrEqualTo(String value) {
            addCriterion("flag6 <=", value, "flag6");
            return (Criteria) this;
        }

        public Criteria andFlag6Like(String value) {
            addCriterion("flag6 like", value, "flag6");
            return (Criteria) this;
        }

        public Criteria andFlag6NotLike(String value) {
            addCriterion("flag6 not like", value, "flag6");
            return (Criteria) this;
        }

        public Criteria andFlag6In(List<String> values) {
            addCriterion("flag6 in", values, "flag6");
            return (Criteria) this;
        }

        public Criteria andFlag6NotIn(List<String> values) {
            addCriterion("flag6 not in", values, "flag6");
            return (Criteria) this;
        }

        public Criteria andFlag6Between(String value1, String value2) {
            addCriterion("flag6 between", value1, value2, "flag6");
            return (Criteria) this;
        }

        public Criteria andFlag6NotBetween(String value1, String value2) {
            addCriterion("flag6 not between", value1, value2, "flag6");
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