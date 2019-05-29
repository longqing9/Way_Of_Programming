package cn.nyist.springmvc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OperationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperationExample() {
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

        public Criteria andOpidIsNull() {
            addCriterion("opid is null");
            return (Criteria) this;
        }

        public Criteria andOpidIsNotNull() {
            addCriterion("opid is not null");
            return (Criteria) this;
        }

        public Criteria andOpidEqualTo(String value) {
            addCriterion("opid =", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidNotEqualTo(String value) {
            addCriterion("opid <>", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidGreaterThan(String value) {
            addCriterion("opid >", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidGreaterThanOrEqualTo(String value) {
            addCriterion("opid >=", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidLessThan(String value) {
            addCriterion("opid <", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidLessThanOrEqualTo(String value) {
            addCriterion("opid <=", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidLike(String value) {
            addCriterion("opid like", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidNotLike(String value) {
            addCriterion("opid not like", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidIn(List<String> values) {
            addCriterion("opid in", values, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidNotIn(List<String> values) {
            addCriterion("opid not in", values, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidBetween(String value1, String value2) {
            addCriterion("opid between", value1, value2, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidNotBetween(String value1, String value2) {
            addCriterion("opid not between", value1, value2, "opid");
            return (Criteria) this;
        }

        public Criteria andOptopIsNull() {
            addCriterion("optop is null");
            return (Criteria) this;
        }

        public Criteria andOptopIsNotNull() {
            addCriterion("optop is not null");
            return (Criteria) this;
        }

        public Criteria andOptopEqualTo(String value) {
            addCriterion("optop =", value, "optop");
            return (Criteria) this;
        }

        public Criteria andOptopNotEqualTo(String value) {
            addCriterion("optop <>", value, "optop");
            return (Criteria) this;
        }

        public Criteria andOptopGreaterThan(String value) {
            addCriterion("optop >", value, "optop");
            return (Criteria) this;
        }

        public Criteria andOptopGreaterThanOrEqualTo(String value) {
            addCriterion("optop >=", value, "optop");
            return (Criteria) this;
        }

        public Criteria andOptopLessThan(String value) {
            addCriterion("optop <", value, "optop");
            return (Criteria) this;
        }

        public Criteria andOptopLessThanOrEqualTo(String value) {
            addCriterion("optop <=", value, "optop");
            return (Criteria) this;
        }

        public Criteria andOptopLike(String value) {
            addCriterion("optop like", value, "optop");
            return (Criteria) this;
        }

        public Criteria andOptopNotLike(String value) {
            addCriterion("optop not like", value, "optop");
            return (Criteria) this;
        }

        public Criteria andOptopIn(List<String> values) {
            addCriterion("optop in", values, "optop");
            return (Criteria) this;
        }

        public Criteria andOptopNotIn(List<String> values) {
            addCriterion("optop not in", values, "optop");
            return (Criteria) this;
        }

        public Criteria andOptopBetween(String value1, String value2) {
            addCriterion("optop between", value1, value2, "optop");
            return (Criteria) this;
        }

        public Criteria andOptopNotBetween(String value1, String value2) {
            addCriterion("optop not between", value1, value2, "optop");
            return (Criteria) this;
        }

        public Criteria andOpsubidIsNull() {
            addCriterion("opsubid is null");
            return (Criteria) this;
        }

        public Criteria andOpsubidIsNotNull() {
            addCriterion("opsubid is not null");
            return (Criteria) this;
        }

        public Criteria andOpsubidEqualTo(String value) {
            addCriterion("opsubid =", value, "opsubid");
            return (Criteria) this;
        }

        public Criteria andOpsubidNotEqualTo(String value) {
            addCriterion("opsubid <>", value, "opsubid");
            return (Criteria) this;
        }

        public Criteria andOpsubidGreaterThan(String value) {
            addCriterion("opsubid >", value, "opsubid");
            return (Criteria) this;
        }

        public Criteria andOpsubidGreaterThanOrEqualTo(String value) {
            addCriterion("opsubid >=", value, "opsubid");
            return (Criteria) this;
        }

        public Criteria andOpsubidLessThan(String value) {
            addCriterion("opsubid <", value, "opsubid");
            return (Criteria) this;
        }

        public Criteria andOpsubidLessThanOrEqualTo(String value) {
            addCriterion("opsubid <=", value, "opsubid");
            return (Criteria) this;
        }

        public Criteria andOpsubidLike(String value) {
            addCriterion("opsubid like", value, "opsubid");
            return (Criteria) this;
        }

        public Criteria andOpsubidNotLike(String value) {
            addCriterion("opsubid not like", value, "opsubid");
            return (Criteria) this;
        }

        public Criteria andOpsubidIn(List<String> values) {
            addCriterion("opsubid in", values, "opsubid");
            return (Criteria) this;
        }

        public Criteria andOpsubidNotIn(List<String> values) {
            addCriterion("opsubid not in", values, "opsubid");
            return (Criteria) this;
        }

        public Criteria andOpsubidBetween(String value1, String value2) {
            addCriterion("opsubid between", value1, value2, "opsubid");
            return (Criteria) this;
        }

        public Criteria andOpsubidNotBetween(String value1, String value2) {
            addCriterion("opsubid not between", value1, value2, "opsubid");
            return (Criteria) this;
        }

        public Criteria andOpstoptimeIsNull() {
            addCriterion("opstoptime is null");
            return (Criteria) this;
        }

        public Criteria andOpstoptimeIsNotNull() {
            addCriterion("opstoptime is not null");
            return (Criteria) this;
        }

        public Criteria andOpstoptimeEqualTo(Date value) {
            addCriterionForJDBCDate("opstoptime =", value, "opstoptime");
            return (Criteria) this;
        }

        public Criteria andOpstoptimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("opstoptime <>", value, "opstoptime");
            return (Criteria) this;
        }

        public Criteria andOpstoptimeGreaterThan(Date value) {
            addCriterionForJDBCDate("opstoptime >", value, "opstoptime");
            return (Criteria) this;
        }

        public Criteria andOpstoptimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("opstoptime >=", value, "opstoptime");
            return (Criteria) this;
        }

        public Criteria andOpstoptimeLessThan(Date value) {
            addCriterionForJDBCDate("opstoptime <", value, "opstoptime");
            return (Criteria) this;
        }

        public Criteria andOpstoptimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("opstoptime <=", value, "opstoptime");
            return (Criteria) this;
        }

        public Criteria andOpstoptimeIn(List<Date> values) {
            addCriterionForJDBCDate("opstoptime in", values, "opstoptime");
            return (Criteria) this;
        }

        public Criteria andOpstoptimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("opstoptime not in", values, "opstoptime");
            return (Criteria) this;
        }

        public Criteria andOpstoptimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("opstoptime between", value1, value2, "opstoptime");
            return (Criteria) this;
        }

        public Criteria andOpstoptimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("opstoptime not between", value1, value2, "opstoptime");
            return (Criteria) this;
        }

        public Criteria andVideourlIsNull() {
            addCriterion("videourl is null");
            return (Criteria) this;
        }

        public Criteria andVideourlIsNotNull() {
            addCriterion("videourl is not null");
            return (Criteria) this;
        }

        public Criteria andVideourlEqualTo(String value) {
            addCriterion("videourl =", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotEqualTo(String value) {
            addCriterion("videourl <>", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlGreaterThan(String value) {
            addCriterion("videourl >", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlGreaterThanOrEqualTo(String value) {
            addCriterion("videourl >=", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLessThan(String value) {
            addCriterion("videourl <", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLessThanOrEqualTo(String value) {
            addCriterion("videourl <=", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLike(String value) {
            addCriterion("videourl like", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotLike(String value) {
            addCriterion("videourl not like", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlIn(List<String> values) {
            addCriterion("videourl in", values, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotIn(List<String> values) {
            addCriterion("videourl not in", values, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlBetween(String value1, String value2) {
            addCriterion("videourl between", value1, value2, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotBetween(String value1, String value2) {
            addCriterion("videourl not between", value1, value2, "videourl");
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