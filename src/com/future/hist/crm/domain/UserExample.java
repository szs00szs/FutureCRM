package com.future.hist.crm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
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

        public Criteria andUpdaterIsNull() {
            addCriterion("updater is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNotNull() {
            addCriterion("updater is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterEqualTo(String value) {
            addCriterion("updater =", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotEqualTo(String value) {
            addCriterion("updater <>", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThan(String value) {
            addCriterion("updater >", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("updater >=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThan(String value) {
            addCriterion("updater <", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThanOrEqualTo(String value) {
            addCriterion("updater <=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLike(String value) {
            addCriterion("updater like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotLike(String value) {
            addCriterion("updater not like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIn(List<String> values) {
            addCriterion("updater in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotIn(List<String> values) {
            addCriterion("updater not in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterBetween(String value1, String value2) {
            addCriterion("updater between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotBetween(String value1, String value2) {
            addCriterion("updater not between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(String value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(String value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(String value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(String value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLike(String value) {
            addCriterion("updateTime like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotLike(String value) {
            addCriterion("updateTime not like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<String> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<String> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(String value1, String value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
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

        public Criteria andBegindateIsNull() {
            addCriterion("beginDate is null");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNotNull() {
            addCriterion("beginDate is not null");
            return (Criteria) this;
        }

        public Criteria andBegindateEqualTo(Date value) {
            addCriterion("beginDate =", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotEqualTo(Date value) {
            addCriterion("beginDate <>", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThan(Date value) {
            addCriterion("beginDate >", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThanOrEqualTo(Date value) {
            addCriterion("beginDate >=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThan(Date value) {
            addCriterion("beginDate <", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThanOrEqualTo(Date value) {
            addCriterion("beginDate <=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateIn(List<Date> values) {
            addCriterion("beginDate in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotIn(List<Date> values) {
            addCriterion("beginDate not in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateBetween(Date value1, Date value2) {
            addCriterion("beginDate between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotBetween(Date value1, Date value2) {
            addCriterion("beginDate not between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("endDate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("endDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterion("endDate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterion("endDate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterion("endDate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("endDate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterion("endDate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterion("endDate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterion("endDate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterion("endDate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterion("endDate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterion("endDate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(Integer value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(Integer value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(Integer value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(Integer value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<Integer> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<Integer> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCommendmanIsNull() {
            addCriterion("commendMan is null");
            return (Criteria) this;
        }

        public Criteria andCommendmanIsNotNull() {
            addCriterion("commendMan is not null");
            return (Criteria) this;
        }

        public Criteria andCommendmanEqualTo(String value) {
            addCriterion("commendMan =", value, "commendman");
            return (Criteria) this;
        }

        public Criteria andCommendmanNotEqualTo(String value) {
            addCriterion("commendMan <>", value, "commendman");
            return (Criteria) this;
        }

        public Criteria andCommendmanGreaterThan(String value) {
            addCriterion("commendMan >", value, "commendman");
            return (Criteria) this;
        }

        public Criteria andCommendmanGreaterThanOrEqualTo(String value) {
            addCriterion("commendMan >=", value, "commendman");
            return (Criteria) this;
        }

        public Criteria andCommendmanLessThan(String value) {
            addCriterion("commendMan <", value, "commendman");
            return (Criteria) this;
        }

        public Criteria andCommendmanLessThanOrEqualTo(String value) {
            addCriterion("commendMan <=", value, "commendman");
            return (Criteria) this;
        }

        public Criteria andCommendmanLike(String value) {
            addCriterion("commendMan like", value, "commendman");
            return (Criteria) this;
        }

        public Criteria andCommendmanNotLike(String value) {
            addCriterion("commendMan not like", value, "commendman");
            return (Criteria) this;
        }

        public Criteria andCommendmanIn(List<String> values) {
            addCriterion("commendMan in", values, "commendman");
            return (Criteria) this;
        }

        public Criteria andCommendmanNotIn(List<String> values) {
            addCriterion("commendMan not in", values, "commendman");
            return (Criteria) this;
        }

        public Criteria andCommendmanBetween(String value1, String value2) {
            addCriterion("commendMan between", value1, value2, "commendman");
            return (Criteria) this;
        }

        public Criteria andCommendmanNotBetween(String value1, String value2) {
            addCriterion("commendMan not between", value1, value2, "commendman");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneIsNull() {
            addCriterion("movetelePhone is null");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneIsNotNull() {
            addCriterion("movetelePhone is not null");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneEqualTo(String value) {
            addCriterion("movetelePhone =", value, "movetelephone");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneNotEqualTo(String value) {
            addCriterion("movetelePhone <>", value, "movetelephone");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneGreaterThan(String value) {
            addCriterion("movetelePhone >", value, "movetelephone");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("movetelePhone >=", value, "movetelephone");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneLessThan(String value) {
            addCriterion("movetelePhone <", value, "movetelephone");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneLessThanOrEqualTo(String value) {
            addCriterion("movetelePhone <=", value, "movetelephone");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneLike(String value) {
            addCriterion("movetelePhone like", value, "movetelephone");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneNotLike(String value) {
            addCriterion("movetelePhone not like", value, "movetelephone");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneIn(List<String> values) {
            addCriterion("movetelePhone in", values, "movetelephone");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneNotIn(List<String> values) {
            addCriterion("movetelePhone not in", values, "movetelephone");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneBetween(String value1, String value2) {
            addCriterion("movetelePhone between", value1, value2, "movetelephone");
            return (Criteria) this;
        }

        public Criteria andMovetelephoneNotBetween(String value1, String value2) {
            addCriterion("movetelePhone not between", value1, value2, "movetelephone");
            return (Criteria) this;
        }

        public Criteria andNowaddressIsNull() {
            addCriterion("nowAddress is null");
            return (Criteria) this;
        }

        public Criteria andNowaddressIsNotNull() {
            addCriterion("nowAddress is not null");
            return (Criteria) this;
        }

        public Criteria andNowaddressEqualTo(String value) {
            addCriterion("nowAddress =", value, "nowaddress");
            return (Criteria) this;
        }

        public Criteria andNowaddressNotEqualTo(String value) {
            addCriterion("nowAddress <>", value, "nowaddress");
            return (Criteria) this;
        }

        public Criteria andNowaddressGreaterThan(String value) {
            addCriterion("nowAddress >", value, "nowaddress");
            return (Criteria) this;
        }

        public Criteria andNowaddressGreaterThanOrEqualTo(String value) {
            addCriterion("nowAddress >=", value, "nowaddress");
            return (Criteria) this;
        }

        public Criteria andNowaddressLessThan(String value) {
            addCriterion("nowAddress <", value, "nowaddress");
            return (Criteria) this;
        }

        public Criteria andNowaddressLessThanOrEqualTo(String value) {
            addCriterion("nowAddress <=", value, "nowaddress");
            return (Criteria) this;
        }

        public Criteria andNowaddressLike(String value) {
            addCriterion("nowAddress like", value, "nowaddress");
            return (Criteria) this;
        }

        public Criteria andNowaddressNotLike(String value) {
            addCriterion("nowAddress not like", value, "nowaddress");
            return (Criteria) this;
        }

        public Criteria andNowaddressIn(List<String> values) {
            addCriterion("nowAddress in", values, "nowaddress");
            return (Criteria) this;
        }

        public Criteria andNowaddressNotIn(List<String> values) {
            addCriterion("nowAddress not in", values, "nowaddress");
            return (Criteria) this;
        }

        public Criteria andNowaddressBetween(String value1, String value2) {
            addCriterion("nowAddress between", value1, value2, "nowaddress");
            return (Criteria) this;
        }

        public Criteria andNowaddressNotBetween(String value1, String value2) {
            addCriterion("nowAddress not between", value1, value2, "nowaddress");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneIsNull() {
            addCriterion("nowTelePhone is null");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneIsNotNull() {
            addCriterion("nowTelePhone is not null");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneEqualTo(String value) {
            addCriterion("nowTelePhone =", value, "nowtelephone");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneNotEqualTo(String value) {
            addCriterion("nowTelePhone <>", value, "nowtelephone");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneGreaterThan(String value) {
            addCriterion("nowTelePhone >", value, "nowtelephone");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("nowTelePhone >=", value, "nowtelephone");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneLessThan(String value) {
            addCriterion("nowTelePhone <", value, "nowtelephone");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneLessThanOrEqualTo(String value) {
            addCriterion("nowTelePhone <=", value, "nowtelephone");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneLike(String value) {
            addCriterion("nowTelePhone like", value, "nowtelephone");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneNotLike(String value) {
            addCriterion("nowTelePhone not like", value, "nowtelephone");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneIn(List<String> values) {
            addCriterion("nowTelePhone in", values, "nowtelephone");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneNotIn(List<String> values) {
            addCriterion("nowTelePhone not in", values, "nowtelephone");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneBetween(String value1, String value2) {
            addCriterion("nowTelePhone between", value1, value2, "nowtelephone");
            return (Criteria) this;
        }

        public Criteria andNowtelephoneNotBetween(String value1, String value2) {
            addCriterion("nowTelePhone not between", value1, value2, "nowtelephone");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeIsNull() {
            addCriterion("identityCode is null");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeIsNotNull() {
            addCriterion("identityCode is not null");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeEqualTo(String value) {
            addCriterion("identityCode =", value, "identitycode");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeNotEqualTo(String value) {
            addCriterion("identityCode <>", value, "identitycode");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeGreaterThan(String value) {
            addCriterion("identityCode >", value, "identitycode");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeGreaterThanOrEqualTo(String value) {
            addCriterion("identityCode >=", value, "identitycode");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeLessThan(String value) {
            addCriterion("identityCode <", value, "identitycode");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeLessThanOrEqualTo(String value) {
            addCriterion("identityCode <=", value, "identitycode");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeLike(String value) {
            addCriterion("identityCode like", value, "identitycode");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeNotLike(String value) {
            addCriterion("identityCode not like", value, "identitycode");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeIn(List<String> values) {
            addCriterion("identityCode in", values, "identitycode");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeNotIn(List<String> values) {
            addCriterion("identityCode not in", values, "identitycode");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeBetween(String value1, String value2) {
            addCriterion("identityCode between", value1, value2, "identitycode");
            return (Criteria) this;
        }

        public Criteria andIdentitycodeNotBetween(String value1, String value2) {
            addCriterion("identityCode not between", value1, value2, "identitycode");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeIsNull() {
            addCriterion("insuranceCode is null");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeIsNotNull() {
            addCriterion("insuranceCode is not null");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeEqualTo(String value) {
            addCriterion("insuranceCode =", value, "insurancecode");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeNotEqualTo(String value) {
            addCriterion("insuranceCode <>", value, "insurancecode");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeGreaterThan(String value) {
            addCriterion("insuranceCode >", value, "insurancecode");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeGreaterThanOrEqualTo(String value) {
            addCriterion("insuranceCode >=", value, "insurancecode");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeLessThan(String value) {
            addCriterion("insuranceCode <", value, "insurancecode");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeLessThanOrEqualTo(String value) {
            addCriterion("insuranceCode <=", value, "insurancecode");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeLike(String value) {
            addCriterion("insuranceCode like", value, "insurancecode");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeNotLike(String value) {
            addCriterion("insuranceCode not like", value, "insurancecode");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeIn(List<String> values) {
            addCriterion("insuranceCode in", values, "insurancecode");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeNotIn(List<String> values) {
            addCriterion("insuranceCode not in", values, "insurancecode");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeBetween(String value1, String value2) {
            addCriterion("insuranceCode between", value1, value2, "insurancecode");
            return (Criteria) this;
        }

        public Criteria andInsurancecodeNotBetween(String value1, String value2) {
            addCriterion("insuranceCode not between", value1, value2, "insurancecode");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanIsNull() {
            addCriterion("instancyLinkman is null");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanIsNotNull() {
            addCriterion("instancyLinkman is not null");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanEqualTo(String value) {
            addCriterion("instancyLinkman =", value, "instancylinkman");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanNotEqualTo(String value) {
            addCriterion("instancyLinkman <>", value, "instancylinkman");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanGreaterThan(String value) {
            addCriterion("instancyLinkman >", value, "instancylinkman");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("instancyLinkman >=", value, "instancylinkman");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanLessThan(String value) {
            addCriterion("instancyLinkman <", value, "instancylinkman");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanLessThanOrEqualTo(String value) {
            addCriterion("instancyLinkman <=", value, "instancylinkman");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanLike(String value) {
            addCriterion("instancyLinkman like", value, "instancylinkman");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanNotLike(String value) {
            addCriterion("instancyLinkman not like", value, "instancylinkman");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanIn(List<String> values) {
            addCriterion("instancyLinkman in", values, "instancylinkman");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanNotIn(List<String> values) {
            addCriterion("instancyLinkman not in", values, "instancylinkman");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanBetween(String value1, String value2) {
            addCriterion("instancyLinkman between", value1, value2, "instancylinkman");
            return (Criteria) this;
        }

        public Criteria andInstancylinkmanNotBetween(String value1, String value2) {
            addCriterion("instancyLinkman not between", value1, value2, "instancylinkman");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneIsNull() {
            addCriterion("instancytelePhone is null");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneIsNotNull() {
            addCriterion("instancytelePhone is not null");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneEqualTo(String value) {
            addCriterion("instancytelePhone =", value, "instancytelephone");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneNotEqualTo(String value) {
            addCriterion("instancytelePhone <>", value, "instancytelephone");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneGreaterThan(String value) {
            addCriterion("instancytelePhone >", value, "instancytelephone");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("instancytelePhone >=", value, "instancytelephone");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneLessThan(String value) {
            addCriterion("instancytelePhone <", value, "instancytelephone");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneLessThanOrEqualTo(String value) {
            addCriterion("instancytelePhone <=", value, "instancytelephone");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneLike(String value) {
            addCriterion("instancytelePhone like", value, "instancytelephone");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneNotLike(String value) {
            addCriterion("instancytelePhone not like", value, "instancytelephone");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneIn(List<String> values) {
            addCriterion("instancytelePhone in", values, "instancytelephone");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneNotIn(List<String> values) {
            addCriterion("instancytelePhone not in", values, "instancytelephone");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneBetween(String value1, String value2) {
            addCriterion("instancytelePhone between", value1, value2, "instancytelephone");
            return (Criteria) this;
        }

        public Criteria andInstancytelephoneNotBetween(String value1, String value2) {
            addCriterion("instancytelePhone not between", value1, value2, "instancytelephone");
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

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeIsNull() {
            addCriterion("personnelType is null");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeIsNotNull() {
            addCriterion("personnelType is not null");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeEqualTo(String value) {
            addCriterion("personnelType =", value, "personneltype");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeNotEqualTo(String value) {
            addCriterion("personnelType <>", value, "personneltype");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeGreaterThan(String value) {
            addCriterion("personnelType >", value, "personneltype");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeGreaterThanOrEqualTo(String value) {
            addCriterion("personnelType >=", value, "personneltype");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeLessThan(String value) {
            addCriterion("personnelType <", value, "personneltype");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeLessThanOrEqualTo(String value) {
            addCriterion("personnelType <=", value, "personneltype");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeLike(String value) {
            addCriterion("personnelType like", value, "personneltype");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeNotLike(String value) {
            addCriterion("personnelType not like", value, "personneltype");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeIn(List<String> values) {
            addCriterion("personnelType in", values, "personneltype");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeNotIn(List<String> values) {
            addCriterion("personnelType not in", values, "personneltype");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeBetween(String value1, String value2) {
            addCriterion("personnelType between", value1, value2, "personneltype");
            return (Criteria) this;
        }

        public Criteria andPersonneltypeNotBetween(String value1, String value2) {
            addCriterion("personnelType not between", value1, value2, "personneltype");
            return (Criteria) this;
        }

        public Criteria andDutyIsNull() {
            addCriterion("duty is null");
            return (Criteria) this;
        }

        public Criteria andDutyIsNotNull() {
            addCriterion("duty is not null");
            return (Criteria) this;
        }

        public Criteria andDutyEqualTo(String value) {
            addCriterion("duty =", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotEqualTo(String value) {
            addCriterion("duty <>", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThan(String value) {
            addCriterion("duty >", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThanOrEqualTo(String value) {
            addCriterion("duty >=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThan(String value) {
            addCriterion("duty <", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThanOrEqualTo(String value) {
            addCriterion("duty <=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLike(String value) {
            addCriterion("duty like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotLike(String value) {
            addCriterion("duty not like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyIn(List<String> values) {
            addCriterion("duty in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotIn(List<String> values) {
            addCriterion("duty not in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyBetween(String value1, String value2) {
            addCriterion("duty between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotBetween(String value1, String value2) {
            addCriterion("duty not between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andWorkdateIsNull() {
            addCriterion("workDate is null");
            return (Criteria) this;
        }

        public Criteria andWorkdateIsNotNull() {
            addCriterion("workDate is not null");
            return (Criteria) this;
        }

        public Criteria andWorkdateEqualTo(Date value) {
            addCriterionForJDBCDate("workDate =", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("workDate <>", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateGreaterThan(Date value) {
            addCriterionForJDBCDate("workDate >", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("workDate >=", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateLessThan(Date value) {
            addCriterionForJDBCDate("workDate <", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("workDate <=", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateIn(List<Date> values) {
            addCriterionForJDBCDate("workDate in", values, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("workDate not in", values, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("workDate between", value1, value2, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("workDate not between", value1, value2, "workdate");
            return (Criteria) this;
        }

        public Criteria andHighschoolIsNull() {
            addCriterion("highSchool is null");
            return (Criteria) this;
        }

        public Criteria andHighschoolIsNotNull() {
            addCriterion("highSchool is not null");
            return (Criteria) this;
        }

        public Criteria andHighschoolEqualTo(String value) {
            addCriterion("highSchool =", value, "highschool");
            return (Criteria) this;
        }

        public Criteria andHighschoolNotEqualTo(String value) {
            addCriterion("highSchool <>", value, "highschool");
            return (Criteria) this;
        }

        public Criteria andHighschoolGreaterThan(String value) {
            addCriterion("highSchool >", value, "highschool");
            return (Criteria) this;
        }

        public Criteria andHighschoolGreaterThanOrEqualTo(String value) {
            addCriterion("highSchool >=", value, "highschool");
            return (Criteria) this;
        }

        public Criteria andHighschoolLessThan(String value) {
            addCriterion("highSchool <", value, "highschool");
            return (Criteria) this;
        }

        public Criteria andHighschoolLessThanOrEqualTo(String value) {
            addCriterion("highSchool <=", value, "highschool");
            return (Criteria) this;
        }

        public Criteria andHighschoolLike(String value) {
            addCriterion("highSchool like", value, "highschool");
            return (Criteria) this;
        }

        public Criteria andHighschoolNotLike(String value) {
            addCriterion("highSchool not like", value, "highschool");
            return (Criteria) this;
        }

        public Criteria andHighschoolIn(List<String> values) {
            addCriterion("highSchool in", values, "highschool");
            return (Criteria) this;
        }

        public Criteria andHighschoolNotIn(List<String> values) {
            addCriterion("highSchool not in", values, "highschool");
            return (Criteria) this;
        }

        public Criteria andHighschoolBetween(String value1, String value2) {
            addCriterion("highSchool between", value1, value2, "highschool");
            return (Criteria) this;
        }

        public Criteria andHighschoolNotBetween(String value1, String value2) {
            addCriterion("highSchool not between", value1, value2, "highschool");
            return (Criteria) this;
        }

        public Criteria andFinishschoolIsNull() {
            addCriterion("finishSchool is null");
            return (Criteria) this;
        }

        public Criteria andFinishschoolIsNotNull() {
            addCriterion("finishSchool is not null");
            return (Criteria) this;
        }

        public Criteria andFinishschoolEqualTo(String value) {
            addCriterion("finishSchool =", value, "finishschool");
            return (Criteria) this;
        }

        public Criteria andFinishschoolNotEqualTo(String value) {
            addCriterion("finishSchool <>", value, "finishschool");
            return (Criteria) this;
        }

        public Criteria andFinishschoolGreaterThan(String value) {
            addCriterion("finishSchool >", value, "finishschool");
            return (Criteria) this;
        }

        public Criteria andFinishschoolGreaterThanOrEqualTo(String value) {
            addCriterion("finishSchool >=", value, "finishschool");
            return (Criteria) this;
        }

        public Criteria andFinishschoolLessThan(String value) {
            addCriterion("finishSchool <", value, "finishschool");
            return (Criteria) this;
        }

        public Criteria andFinishschoolLessThanOrEqualTo(String value) {
            addCriterion("finishSchool <=", value, "finishschool");
            return (Criteria) this;
        }

        public Criteria andFinishschoolLike(String value) {
            addCriterion("finishSchool like", value, "finishschool");
            return (Criteria) this;
        }

        public Criteria andFinishschoolNotLike(String value) {
            addCriterion("finishSchool not like", value, "finishschool");
            return (Criteria) this;
        }

        public Criteria andFinishschoolIn(List<String> values) {
            addCriterion("finishSchool in", values, "finishschool");
            return (Criteria) this;
        }

        public Criteria andFinishschoolNotIn(List<String> values) {
            addCriterion("finishSchool not in", values, "finishschool");
            return (Criteria) this;
        }

        public Criteria andFinishschoolBetween(String value1, String value2) {
            addCriterion("finishSchool between", value1, value2, "finishschool");
            return (Criteria) this;
        }

        public Criteria andFinishschoolNotBetween(String value1, String value2) {
            addCriterion("finishSchool not between", value1, value2, "finishschool");
            return (Criteria) this;
        }

        public Criteria andFinishschooldateIsNull() {
            addCriterion("finishSchoolDate is null");
            return (Criteria) this;
        }

        public Criteria andFinishschooldateIsNotNull() {
            addCriterion("finishSchoolDate is not null");
            return (Criteria) this;
        }

        public Criteria andFinishschooldateEqualTo(Date value) {
            addCriterionForJDBCDate("finishSchoolDate =", value, "finishschooldate");
            return (Criteria) this;
        }

        public Criteria andFinishschooldateNotEqualTo(Date value) {
            addCriterionForJDBCDate("finishSchoolDate <>", value, "finishschooldate");
            return (Criteria) this;
        }

        public Criteria andFinishschooldateGreaterThan(Date value) {
            addCriterionForJDBCDate("finishSchoolDate >", value, "finishschooldate");
            return (Criteria) this;
        }

        public Criteria andFinishschooldateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("finishSchoolDate >=", value, "finishschooldate");
            return (Criteria) this;
        }

        public Criteria andFinishschooldateLessThan(Date value) {
            addCriterionForJDBCDate("finishSchoolDate <", value, "finishschooldate");
            return (Criteria) this;
        }

        public Criteria andFinishschooldateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("finishSchoolDate <=", value, "finishschooldate");
            return (Criteria) this;
        }

        public Criteria andFinishschooldateIn(List<Date> values) {
            addCriterionForJDBCDate("finishSchoolDate in", values, "finishschooldate");
            return (Criteria) this;
        }

        public Criteria andFinishschooldateNotIn(List<Date> values) {
            addCriterionForJDBCDate("finishSchoolDate not in", values, "finishschooldate");
            return (Criteria) this;
        }

        public Criteria andFinishschooldateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("finishSchoolDate between", value1, value2, "finishschooldate");
            return (Criteria) this;
        }

        public Criteria andFinishschooldateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("finishSchoolDate not between", value1, value2, "finishschooldate");
            return (Criteria) this;
        }

        public Criteria andConsortnameIsNull() {
            addCriterion("consortName is null");
            return (Criteria) this;
        }

        public Criteria andConsortnameIsNotNull() {
            addCriterion("consortName is not null");
            return (Criteria) this;
        }

        public Criteria andConsortnameEqualTo(String value) {
            addCriterion("consortName =", value, "consortname");
            return (Criteria) this;
        }

        public Criteria andConsortnameNotEqualTo(String value) {
            addCriterion("consortName <>", value, "consortname");
            return (Criteria) this;
        }

        public Criteria andConsortnameGreaterThan(String value) {
            addCriterion("consortName >", value, "consortname");
            return (Criteria) this;
        }

        public Criteria andConsortnameGreaterThanOrEqualTo(String value) {
            addCriterion("consortName >=", value, "consortname");
            return (Criteria) this;
        }

        public Criteria andConsortnameLessThan(String value) {
            addCriterion("consortName <", value, "consortname");
            return (Criteria) this;
        }

        public Criteria andConsortnameLessThanOrEqualTo(String value) {
            addCriterion("consortName <=", value, "consortname");
            return (Criteria) this;
        }

        public Criteria andConsortnameLike(String value) {
            addCriterion("consortName like", value, "consortname");
            return (Criteria) this;
        }

        public Criteria andConsortnameNotLike(String value) {
            addCriterion("consortName not like", value, "consortname");
            return (Criteria) this;
        }

        public Criteria andConsortnameIn(List<String> values) {
            addCriterion("consortName in", values, "consortname");
            return (Criteria) this;
        }

        public Criteria andConsortnameNotIn(List<String> values) {
            addCriterion("consortName not in", values, "consortname");
            return (Criteria) this;
        }

        public Criteria andConsortnameBetween(String value1, String value2) {
            addCriterion("consortName between", value1, value2, "consortname");
            return (Criteria) this;
        }

        public Criteria andConsortnameNotBetween(String value1, String value2) {
            addCriterion("consortName not between", value1, value2, "consortname");
            return (Criteria) this;
        }

        public Criteria andYoungonenameIsNull() {
            addCriterion("youngoneName is null");
            return (Criteria) this;
        }

        public Criteria andYoungonenameIsNotNull() {
            addCriterion("youngoneName is not null");
            return (Criteria) this;
        }

        public Criteria andYoungonenameEqualTo(String value) {
            addCriterion("youngoneName =", value, "youngonename");
            return (Criteria) this;
        }

        public Criteria andYoungonenameNotEqualTo(String value) {
            addCriterion("youngoneName <>", value, "youngonename");
            return (Criteria) this;
        }

        public Criteria andYoungonenameGreaterThan(String value) {
            addCriterion("youngoneName >", value, "youngonename");
            return (Criteria) this;
        }

        public Criteria andYoungonenameGreaterThanOrEqualTo(String value) {
            addCriterion("youngoneName >=", value, "youngonename");
            return (Criteria) this;
        }

        public Criteria andYoungonenameLessThan(String value) {
            addCriterion("youngoneName <", value, "youngonename");
            return (Criteria) this;
        }

        public Criteria andYoungonenameLessThanOrEqualTo(String value) {
            addCriterion("youngoneName <=", value, "youngonename");
            return (Criteria) this;
        }

        public Criteria andYoungonenameLike(String value) {
            addCriterion("youngoneName like", value, "youngonename");
            return (Criteria) this;
        }

        public Criteria andYoungonenameNotLike(String value) {
            addCriterion("youngoneName not like", value, "youngonename");
            return (Criteria) this;
        }

        public Criteria andYoungonenameIn(List<String> values) {
            addCriterion("youngoneName in", values, "youngonename");
            return (Criteria) this;
        }

        public Criteria andYoungonenameNotIn(List<String> values) {
            addCriterion("youngoneName not in", values, "youngonename");
            return (Criteria) this;
        }

        public Criteria andYoungonenameBetween(String value1, String value2) {
            addCriterion("youngoneName between", value1, value2, "youngonename");
            return (Criteria) this;
        }

        public Criteria andYoungonenameNotBetween(String value1, String value2) {
            addCriterion("youngoneName not between", value1, value2, "youngonename");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneIsNull() {
            addCriterion("officetelePhone is null");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneIsNotNull() {
            addCriterion("officetelePhone is not null");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneEqualTo(String value) {
            addCriterion("officetelePhone =", value, "officetelephone");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneNotEqualTo(String value) {
            addCriterion("officetelePhone <>", value, "officetelephone");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneGreaterThan(String value) {
            addCriterion("officetelePhone >", value, "officetelephone");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("officetelePhone >=", value, "officetelephone");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneLessThan(String value) {
            addCriterion("officetelePhone <", value, "officetelephone");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneLessThanOrEqualTo(String value) {
            addCriterion("officetelePhone <=", value, "officetelephone");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneLike(String value) {
            addCriterion("officetelePhone like", value, "officetelephone");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneNotLike(String value) {
            addCriterion("officetelePhone not like", value, "officetelephone");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneIn(List<String> values) {
            addCriterion("officetelePhone in", values, "officetelephone");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneNotIn(List<String> values) {
            addCriterion("officetelePhone not in", values, "officetelephone");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneBetween(String value1, String value2) {
            addCriterion("officetelePhone between", value1, value2, "officetelephone");
            return (Criteria) this;
        }

        public Criteria andOfficetelephoneNotBetween(String value1, String value2) {
            addCriterion("officetelePhone not between", value1, value2, "officetelephone");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneIsNull() {
            addCriterion("consorttelePhone is null");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneIsNotNull() {
            addCriterion("consorttelePhone is not null");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneEqualTo(String value) {
            addCriterion("consorttelePhone =", value, "consorttelephone");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneNotEqualTo(String value) {
            addCriterion("consorttelePhone <>", value, "consorttelephone");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneGreaterThan(String value) {
            addCriterion("consorttelePhone >", value, "consorttelephone");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("consorttelePhone >=", value, "consorttelephone");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneLessThan(String value) {
            addCriterion("consorttelePhone <", value, "consorttelephone");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneLessThanOrEqualTo(String value) {
            addCriterion("consorttelePhone <=", value, "consorttelephone");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneLike(String value) {
            addCriterion("consorttelePhone like", value, "consorttelephone");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneNotLike(String value) {
            addCriterion("consorttelePhone not like", value, "consorttelephone");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneIn(List<String> values) {
            addCriterion("consorttelePhone in", values, "consorttelephone");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneNotIn(List<String> values) {
            addCriterion("consorttelePhone not in", values, "consorttelephone");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneBetween(String value1, String value2) {
            addCriterion("consorttelePhone between", value1, value2, "consorttelephone");
            return (Criteria) this;
        }

        public Criteria andConsorttelephoneNotBetween(String value1, String value2) {
            addCriterion("consorttelePhone not between", value1, value2, "consorttelephone");
            return (Criteria) this;
        }

        public Criteria andAvocationIsNull() {
            addCriterion("avocation is null");
            return (Criteria) this;
        }

        public Criteria andAvocationIsNotNull() {
            addCriterion("avocation is not null");
            return (Criteria) this;
        }

        public Criteria andAvocationEqualTo(String value) {
            addCriterion("avocation =", value, "avocation");
            return (Criteria) this;
        }

        public Criteria andAvocationNotEqualTo(String value) {
            addCriterion("avocation <>", value, "avocation");
            return (Criteria) this;
        }

        public Criteria andAvocationGreaterThan(String value) {
            addCriterion("avocation >", value, "avocation");
            return (Criteria) this;
        }

        public Criteria andAvocationGreaterThanOrEqualTo(String value) {
            addCriterion("avocation >=", value, "avocation");
            return (Criteria) this;
        }

        public Criteria andAvocationLessThan(String value) {
            addCriterion("avocation <", value, "avocation");
            return (Criteria) this;
        }

        public Criteria andAvocationLessThanOrEqualTo(String value) {
            addCriterion("avocation <=", value, "avocation");
            return (Criteria) this;
        }

        public Criteria andAvocationLike(String value) {
            addCriterion("avocation like", value, "avocation");
            return (Criteria) this;
        }

        public Criteria andAvocationNotLike(String value) {
            addCriterion("avocation not like", value, "avocation");
            return (Criteria) this;
        }

        public Criteria andAvocationIn(List<String> values) {
            addCriterion("avocation in", values, "avocation");
            return (Criteria) this;
        }

        public Criteria andAvocationNotIn(List<String> values) {
            addCriterion("avocation not in", values, "avocation");
            return (Criteria) this;
        }

        public Criteria andAvocationBetween(String value1, String value2) {
            addCriterion("avocation between", value1, value2, "avocation");
            return (Criteria) this;
        }

        public Criteria andAvocationNotBetween(String value1, String value2) {
            addCriterion("avocation not between", value1, value2, "avocation");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyIsNull() {
            addCriterion("consortCompany is null");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyIsNotNull() {
            addCriterion("consortCompany is not null");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyEqualTo(String value) {
            addCriterion("consortCompany =", value, "consortcompany");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyNotEqualTo(String value) {
            addCriterion("consortCompany <>", value, "consortcompany");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyGreaterThan(String value) {
            addCriterion("consortCompany >", value, "consortcompany");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyGreaterThanOrEqualTo(String value) {
            addCriterion("consortCompany >=", value, "consortcompany");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyLessThan(String value) {
            addCriterion("consortCompany <", value, "consortcompany");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyLessThanOrEqualTo(String value) {
            addCriterion("consortCompany <=", value, "consortcompany");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyLike(String value) {
            addCriterion("consortCompany like", value, "consortcompany");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyNotLike(String value) {
            addCriterion("consortCompany not like", value, "consortcompany");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyIn(List<String> values) {
            addCriterion("consortCompany in", values, "consortcompany");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyNotIn(List<String> values) {
            addCriterion("consortCompany not in", values, "consortcompany");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyBetween(String value1, String value2) {
            addCriterion("consortCompany between", value1, value2, "consortcompany");
            return (Criteria) this;
        }

        public Criteria andConsortcompanyNotBetween(String value1, String value2) {
            addCriterion("consortCompany not between", value1, value2, "consortcompany");
            return (Criteria) this;
        }

        public Criteria andStrongsuitIsNull() {
            addCriterion("strongSuit is null");
            return (Criteria) this;
        }

        public Criteria andStrongsuitIsNotNull() {
            addCriterion("strongSuit is not null");
            return (Criteria) this;
        }

        public Criteria andStrongsuitEqualTo(String value) {
            addCriterion("strongSuit =", value, "strongsuit");
            return (Criteria) this;
        }

        public Criteria andStrongsuitNotEqualTo(String value) {
            addCriterion("strongSuit <>", value, "strongsuit");
            return (Criteria) this;
        }

        public Criteria andStrongsuitGreaterThan(String value) {
            addCriterion("strongSuit >", value, "strongsuit");
            return (Criteria) this;
        }

        public Criteria andStrongsuitGreaterThanOrEqualTo(String value) {
            addCriterion("strongSuit >=", value, "strongsuit");
            return (Criteria) this;
        }

        public Criteria andStrongsuitLessThan(String value) {
            addCriterion("strongSuit <", value, "strongsuit");
            return (Criteria) this;
        }

        public Criteria andStrongsuitLessThanOrEqualTo(String value) {
            addCriterion("strongSuit <=", value, "strongsuit");
            return (Criteria) this;
        }

        public Criteria andStrongsuitLike(String value) {
            addCriterion("strongSuit like", value, "strongsuit");
            return (Criteria) this;
        }

        public Criteria andStrongsuitNotLike(String value) {
            addCriterion("strongSuit not like", value, "strongsuit");
            return (Criteria) this;
        }

        public Criteria andStrongsuitIn(List<String> values) {
            addCriterion("strongSuit in", values, "strongsuit");
            return (Criteria) this;
        }

        public Criteria andStrongsuitNotIn(List<String> values) {
            addCriterion("strongSuit not in", values, "strongsuit");
            return (Criteria) this;
        }

        public Criteria andStrongsuitBetween(String value1, String value2) {
            addCriterion("strongSuit between", value1, value2, "strongsuit");
            return (Criteria) this;
        }

        public Criteria andStrongsuitNotBetween(String value1, String value2) {
            addCriterion("strongSuit not between", value1, value2, "strongsuit");
            return (Criteria) this;
        }

        public Criteria andCommunicateIsNull() {
            addCriterion("commUniCate is null");
            return (Criteria) this;
        }

        public Criteria andCommunicateIsNotNull() {
            addCriterion("commUniCate is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicateEqualTo(String value) {
            addCriterion("commUniCate =", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateNotEqualTo(String value) {
            addCriterion("commUniCate <>", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateGreaterThan(String value) {
            addCriterion("commUniCate >", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateGreaterThanOrEqualTo(String value) {
            addCriterion("commUniCate >=", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateLessThan(String value) {
            addCriterion("commUniCate <", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateLessThanOrEqualTo(String value) {
            addCriterion("commUniCate <=", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateLike(String value) {
            addCriterion("commUniCate like", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateNotLike(String value) {
            addCriterion("commUniCate not like", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateIn(List<String> values) {
            addCriterion("commUniCate in", values, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateNotIn(List<String> values) {
            addCriterion("commUniCate not in", values, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateBetween(String value1, String value2) {
            addCriterion("commUniCate between", value1, value2, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateNotBetween(String value1, String value2) {
            addCriterion("commUniCate not between", value1, value2, "communicate");
            return (Criteria) this;
        }

        public Criteria andBringupIsNull() {
            addCriterion("bringup is null");
            return (Criteria) this;
        }

        public Criteria andBringupIsNotNull() {
            addCriterion("bringup is not null");
            return (Criteria) this;
        }

        public Criteria andBringupEqualTo(String value) {
            addCriterion("bringup =", value, "bringup");
            return (Criteria) this;
        }

        public Criteria andBringupNotEqualTo(String value) {
            addCriterion("bringup <>", value, "bringup");
            return (Criteria) this;
        }

        public Criteria andBringupGreaterThan(String value) {
            addCriterion("bringup >", value, "bringup");
            return (Criteria) this;
        }

        public Criteria andBringupGreaterThanOrEqualTo(String value) {
            addCriterion("bringup >=", value, "bringup");
            return (Criteria) this;
        }

        public Criteria andBringupLessThan(String value) {
            addCriterion("bringup <", value, "bringup");
            return (Criteria) this;
        }

        public Criteria andBringupLessThanOrEqualTo(String value) {
            addCriterion("bringup <=", value, "bringup");
            return (Criteria) this;
        }

        public Criteria andBringupLike(String value) {
            addCriterion("bringup like", value, "bringup");
            return (Criteria) this;
        }

        public Criteria andBringupNotLike(String value) {
            addCriterion("bringup not like", value, "bringup");
            return (Criteria) this;
        }

        public Criteria andBringupIn(List<String> values) {
            addCriterion("bringup in", values, "bringup");
            return (Criteria) this;
        }

        public Criteria andBringupNotIn(List<String> values) {
            addCriterion("bringup not in", values, "bringup");
            return (Criteria) this;
        }

        public Criteria andBringupBetween(String value1, String value2) {
            addCriterion("bringup between", value1, value2, "bringup");
            return (Criteria) this;
        }

        public Criteria andBringupNotBetween(String value1, String value2) {
            addCriterion("bringup not between", value1, value2, "bringup");
            return (Criteria) this;
        }

        public Criteria andOrganiseIsNull() {
            addCriterion("organise is null");
            return (Criteria) this;
        }

        public Criteria andOrganiseIsNotNull() {
            addCriterion("organise is not null");
            return (Criteria) this;
        }

        public Criteria andOrganiseEqualTo(String value) {
            addCriterion("organise =", value, "organise");
            return (Criteria) this;
        }

        public Criteria andOrganiseNotEqualTo(String value) {
            addCriterion("organise <>", value, "organise");
            return (Criteria) this;
        }

        public Criteria andOrganiseGreaterThan(String value) {
            addCriterion("organise >", value, "organise");
            return (Criteria) this;
        }

        public Criteria andOrganiseGreaterThanOrEqualTo(String value) {
            addCriterion("organise >=", value, "organise");
            return (Criteria) this;
        }

        public Criteria andOrganiseLessThan(String value) {
            addCriterion("organise <", value, "organise");
            return (Criteria) this;
        }

        public Criteria andOrganiseLessThanOrEqualTo(String value) {
            addCriterion("organise <=", value, "organise");
            return (Criteria) this;
        }

        public Criteria andOrganiseLike(String value) {
            addCriterion("organise like", value, "organise");
            return (Criteria) this;
        }

        public Criteria andOrganiseNotLike(String value) {
            addCriterion("organise not like", value, "organise");
            return (Criteria) this;
        }

        public Criteria andOrganiseIn(List<String> values) {
            addCriterion("organise in", values, "organise");
            return (Criteria) this;
        }

        public Criteria andOrganiseNotIn(List<String> values) {
            addCriterion("organise not in", values, "organise");
            return (Criteria) this;
        }

        public Criteria andOrganiseBetween(String value1, String value2) {
            addCriterion("organise between", value1, value2, "organise");
            return (Criteria) this;
        }

        public Criteria andOrganiseNotBetween(String value1, String value2) {
            addCriterion("organise not between", value1, value2, "organise");
            return (Criteria) this;
        }

        public Criteria andAnalyseIsNull() {
            addCriterion("analyse is null");
            return (Criteria) this;
        }

        public Criteria andAnalyseIsNotNull() {
            addCriterion("analyse is not null");
            return (Criteria) this;
        }

        public Criteria andAnalyseEqualTo(String value) {
            addCriterion("analyse =", value, "analyse");
            return (Criteria) this;
        }

        public Criteria andAnalyseNotEqualTo(String value) {
            addCriterion("analyse <>", value, "analyse");
            return (Criteria) this;
        }

        public Criteria andAnalyseGreaterThan(String value) {
            addCriterion("analyse >", value, "analyse");
            return (Criteria) this;
        }

        public Criteria andAnalyseGreaterThanOrEqualTo(String value) {
            addCriterion("analyse >=", value, "analyse");
            return (Criteria) this;
        }

        public Criteria andAnalyseLessThan(String value) {
            addCriterion("analyse <", value, "analyse");
            return (Criteria) this;
        }

        public Criteria andAnalyseLessThanOrEqualTo(String value) {
            addCriterion("analyse <=", value, "analyse");
            return (Criteria) this;
        }

        public Criteria andAnalyseLike(String value) {
            addCriterion("analyse like", value, "analyse");
            return (Criteria) this;
        }

        public Criteria andAnalyseNotLike(String value) {
            addCriterion("analyse not like", value, "analyse");
            return (Criteria) this;
        }

        public Criteria andAnalyseIn(List<String> values) {
            addCriterion("analyse in", values, "analyse");
            return (Criteria) this;
        }

        public Criteria andAnalyseNotIn(List<String> values) {
            addCriterion("analyse not in", values, "analyse");
            return (Criteria) this;
        }

        public Criteria andAnalyseBetween(String value1, String value2) {
            addCriterion("analyse between", value1, value2, "analyse");
            return (Criteria) this;
        }

        public Criteria andAnalyseNotBetween(String value1, String value2) {
            addCriterion("analyse not between", value1, value2, "analyse");
            return (Criteria) this;
        }

        public Criteria andPlaningIsNull() {
            addCriterion("planing is null");
            return (Criteria) this;
        }

        public Criteria andPlaningIsNotNull() {
            addCriterion("planing is not null");
            return (Criteria) this;
        }

        public Criteria andPlaningEqualTo(String value) {
            addCriterion("planing =", value, "planing");
            return (Criteria) this;
        }

        public Criteria andPlaningNotEqualTo(String value) {
            addCriterion("planing <>", value, "planing");
            return (Criteria) this;
        }

        public Criteria andPlaningGreaterThan(String value) {
            addCriterion("planing >", value, "planing");
            return (Criteria) this;
        }

        public Criteria andPlaningGreaterThanOrEqualTo(String value) {
            addCriterion("planing >=", value, "planing");
            return (Criteria) this;
        }

        public Criteria andPlaningLessThan(String value) {
            addCriterion("planing <", value, "planing");
            return (Criteria) this;
        }

        public Criteria andPlaningLessThanOrEqualTo(String value) {
            addCriterion("planing <=", value, "planing");
            return (Criteria) this;
        }

        public Criteria andPlaningLike(String value) {
            addCriterion("planing like", value, "planing");
            return (Criteria) this;
        }

        public Criteria andPlaningNotLike(String value) {
            addCriterion("planing not like", value, "planing");
            return (Criteria) this;
        }

        public Criteria andPlaningIn(List<String> values) {
            addCriterion("planing in", values, "planing");
            return (Criteria) this;
        }

        public Criteria andPlaningNotIn(List<String> values) {
            addCriterion("planing not in", values, "planing");
            return (Criteria) this;
        }

        public Criteria andPlaningBetween(String value1, String value2) {
            addCriterion("planing between", value1, value2, "planing");
            return (Criteria) this;
        }

        public Criteria andPlaningNotBetween(String value1, String value2) {
            addCriterion("planing not between", value1, value2, "planing");
            return (Criteria) this;
        }

        public Criteria andEmpolderIsNull() {
            addCriterion("empolder is null");
            return (Criteria) this;
        }

        public Criteria andEmpolderIsNotNull() {
            addCriterion("empolder is not null");
            return (Criteria) this;
        }

        public Criteria andEmpolderEqualTo(String value) {
            addCriterion("empolder =", value, "empolder");
            return (Criteria) this;
        }

        public Criteria andEmpolderNotEqualTo(String value) {
            addCriterion("empolder <>", value, "empolder");
            return (Criteria) this;
        }

        public Criteria andEmpolderGreaterThan(String value) {
            addCriterion("empolder >", value, "empolder");
            return (Criteria) this;
        }

        public Criteria andEmpolderGreaterThanOrEqualTo(String value) {
            addCriterion("empolder >=", value, "empolder");
            return (Criteria) this;
        }

        public Criteria andEmpolderLessThan(String value) {
            addCriterion("empolder <", value, "empolder");
            return (Criteria) this;
        }

        public Criteria andEmpolderLessThanOrEqualTo(String value) {
            addCriterion("empolder <=", value, "empolder");
            return (Criteria) this;
        }

        public Criteria andEmpolderLike(String value) {
            addCriterion("empolder like", value, "empolder");
            return (Criteria) this;
        }

        public Criteria andEmpolderNotLike(String value) {
            addCriterion("empolder not like", value, "empolder");
            return (Criteria) this;
        }

        public Criteria andEmpolderIn(List<String> values) {
            addCriterion("empolder in", values, "empolder");
            return (Criteria) this;
        }

        public Criteria andEmpolderNotIn(List<String> values) {
            addCriterion("empolder not in", values, "empolder");
            return (Criteria) this;
        }

        public Criteria andEmpolderBetween(String value1, String value2) {
            addCriterion("empolder between", value1, value2, "empolder");
            return (Criteria) this;
        }

        public Criteria andEmpolderNotBetween(String value1, String value2) {
            addCriterion("empolder not between", value1, value2, "empolder");
            return (Criteria) this;
        }

        public Criteria andRelationIsNull() {
            addCriterion("relation is null");
            return (Criteria) this;
        }

        public Criteria andRelationIsNotNull() {
            addCriterion("relation is not null");
            return (Criteria) this;
        }

        public Criteria andRelationEqualTo(String value) {
            addCriterion("relation =", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotEqualTo(String value) {
            addCriterion("relation <>", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThan(String value) {
            addCriterion("relation >", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThanOrEqualTo(String value) {
            addCriterion("relation >=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThan(String value) {
            addCriterion("relation <", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThanOrEqualTo(String value) {
            addCriterion("relation <=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLike(String value) {
            addCriterion("relation like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotLike(String value) {
            addCriterion("relation not like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationIn(List<String> values) {
            addCriterion("relation in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotIn(List<String> values) {
            addCriterion("relation not in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationBetween(String value1, String value2) {
            addCriterion("relation between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotBetween(String value1, String value2) {
            addCriterion("relation not between", value1, value2, "relation");
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