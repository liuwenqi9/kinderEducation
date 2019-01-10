package com.muji.zh.admin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoticeExample() {
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

        public Criteria andNnameIsNull() {
            addCriterion("nname is null");
            return (Criteria) this;
        }

        public Criteria andNnameIsNotNull() {
            addCriterion("nname is not null");
            return (Criteria) this;
        }

        public Criteria andNnameEqualTo(String value) {
            addCriterion("nname =", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameNotEqualTo(String value) {
            addCriterion("nname <>", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameGreaterThan(String value) {
            addCriterion("nname >", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameGreaterThanOrEqualTo(String value) {
            addCriterion("nname >=", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameLessThan(String value) {
            addCriterion("nname <", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameLessThanOrEqualTo(String value) {
            addCriterion("nname <=", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameLike(String value) {
            addCriterion("nname like", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameNotLike(String value) {
            addCriterion("nname not like", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameIn(List<String> values) {
            addCriterion("nname in", values, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameNotIn(List<String> values) {
            addCriterion("nname not in", values, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameBetween(String value1, String value2) {
            addCriterion("nname between", value1, value2, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameNotBetween(String value1, String value2) {
            addCriterion("nname not between", value1, value2, "nname");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andFileIsNull() {
            addCriterion("file is null");
            return (Criteria) this;
        }

        public Criteria andFileIsNotNull() {
            addCriterion("file is not null");
            return (Criteria) this;
        }

        public Criteria andFileEqualTo(String value) {
            addCriterion("file =", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotEqualTo(String value) {
            addCriterion("file <>", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileGreaterThan(String value) {
            addCriterion("file >", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileGreaterThanOrEqualTo(String value) {
            addCriterion("file >=", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLessThan(String value) {
            addCriterion("file <", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLessThanOrEqualTo(String value) {
            addCriterion("file <=", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLike(String value) {
            addCriterion("file like", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotLike(String value) {
            addCriterion("file not like", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileIn(List<String> values) {
            addCriterion("file in", values, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotIn(List<String> values) {
            addCriterion("file not in", values, "file");
            return (Criteria) this;
        }

        public Criteria andFileBetween(String value1, String value2) {
            addCriterion("file between", value1, value2, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotBetween(String value1, String value2) {
            addCriterion("file not between", value1, value2, "file");
            return (Criteria) this;
        }

        public Criteria andWhoIdIsNull() {
            addCriterion("who_id is null");
            return (Criteria) this;
        }

        public Criteria andWhoIdIsNotNull() {
            addCriterion("who_id is not null");
            return (Criteria) this;
        }

        public Criteria andWhoIdEqualTo(Integer value) {
            addCriterion("who_id =", value, "whoId");
            return (Criteria) this;
        }

        public Criteria andWhoIdNotEqualTo(Integer value) {
            addCriterion("who_id <>", value, "whoId");
            return (Criteria) this;
        }

        public Criteria andWhoIdGreaterThan(Integer value) {
            addCriterion("who_id >", value, "whoId");
            return (Criteria) this;
        }

        public Criteria andWhoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("who_id >=", value, "whoId");
            return (Criteria) this;
        }

        public Criteria andWhoIdLessThan(Integer value) {
            addCriterion("who_id <", value, "whoId");
            return (Criteria) this;
        }

        public Criteria andWhoIdLessThanOrEqualTo(Integer value) {
            addCriterion("who_id <=", value, "whoId");
            return (Criteria) this;
        }

        public Criteria andWhoIdIn(List<Integer> values) {
            addCriterion("who_id in", values, "whoId");
            return (Criteria) this;
        }

        public Criteria andWhoIdNotIn(List<Integer> values) {
            addCriterion("who_id not in", values, "whoId");
            return (Criteria) this;
        }

        public Criteria andWhoIdBetween(Integer value1, Integer value2) {
            addCriterion("who_id between", value1, value2, "whoId");
            return (Criteria) this;
        }

        public Criteria andWhoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("who_id not between", value1, value2, "whoId");
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

        public Criteria andAreaIdEqualTo(String value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(String value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(String value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(String value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(String value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(String value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLike(String value) {
            addCriterion("area_id like", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotLike(String value) {
            addCriterion("area_id not like", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<String> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<String> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(String value1, String value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(String value1, String value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAimIsNull() {
            addCriterion("aim is null");
            return (Criteria) this;
        }

        public Criteria andAimIsNotNull() {
            addCriterion("aim is not null");
            return (Criteria) this;
        }

        public Criteria andAimEqualTo(String value) {
            addCriterion("aim =", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimNotEqualTo(String value) {
            addCriterion("aim <>", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimGreaterThan(String value) {
            addCriterion("aim >", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimGreaterThanOrEqualTo(String value) {
            addCriterion("aim >=", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimLessThan(String value) {
            addCriterion("aim <", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimLessThanOrEqualTo(String value) {
            addCriterion("aim <=", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimLike(String value) {
            addCriterion("aim like", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimNotLike(String value) {
            addCriterion("aim not like", value, "aim");
            return (Criteria) this;
        }

        public Criteria andAimIn(List<String> values) {
            addCriterion("aim in", values, "aim");
            return (Criteria) this;
        }

        public Criteria andAimNotIn(List<String> values) {
            addCriterion("aim not in", values, "aim");
            return (Criteria) this;
        }

        public Criteria andAimBetween(String value1, String value2) {
            addCriterion("aim between", value1, value2, "aim");
            return (Criteria) this;
        }

        public Criteria andAimNotBetween(String value1, String value2) {
            addCriterion("aim not between", value1, value2, "aim");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNull() {
            addCriterion("auditor is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("auditor is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(String value) {
            addCriterion("auditor =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(String value) {
            addCriterion("auditor <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(String value) {
            addCriterion("auditor >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("auditor >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(String value) {
            addCriterion("auditor <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(String value) {
            addCriterion("auditor <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLike(String value) {
            addCriterion("auditor like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotLike(String value) {
            addCriterion("auditor not like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<String> values) {
            addCriterion("auditor in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<String> values) {
            addCriterion("auditor not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(String value1, String value2) {
            addCriterion("auditor between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(String value1, String value2) {
            addCriterion("auditor not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNull() {
            addCriterion("approval_time is null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNotNull() {
            addCriterion("approval_time is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeEqualTo(Date value) {
            addCriterion("approval_time =", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotEqualTo(Date value) {
            addCriterion("approval_time <>", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThan(Date value) {
            addCriterion("approval_time >", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approval_time >=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThan(Date value) {
            addCriterion("approval_time <", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThanOrEqualTo(Date value) {
            addCriterion("approval_time <=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIn(List<Date> values) {
            addCriterion("approval_time in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotIn(List<Date> values) {
            addCriterion("approval_time not in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeBetween(Date value1, Date value2) {
            addCriterion("approval_time between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotBetween(Date value1, Date value2) {
            addCriterion("approval_time not between", value1, value2, "approvalTime");
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