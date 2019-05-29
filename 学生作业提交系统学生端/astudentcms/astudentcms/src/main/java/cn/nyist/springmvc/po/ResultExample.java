package cn.nyist.springmvc.po;

import java.util.ArrayList;
import java.util.List;

public class ResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResultExample() {
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

        public Criteria andReidIsNull() {
            addCriterion("reid is null");
            return (Criteria) this;
        }

        public Criteria andReidIsNotNull() {
            addCriterion("reid is not null");
            return (Criteria) this;
        }

        public Criteria andReidEqualTo(String value) {
            addCriterion("reid =", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidNotEqualTo(String value) {
            addCriterion("reid <>", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidGreaterThan(String value) {
            addCriterion("reid >", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidGreaterThanOrEqualTo(String value) {
            addCriterion("reid >=", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidLessThan(String value) {
            addCriterion("reid <", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidLessThanOrEqualTo(String value) {
            addCriterion("reid <=", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidLike(String value) {
            addCriterion("reid like", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidNotLike(String value) {
            addCriterion("reid not like", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidIn(List<String> values) {
            addCriterion("reid in", values, "reid");
            return (Criteria) this;
        }

        public Criteria andReidNotIn(List<String> values) {
            addCriterion("reid not in", values, "reid");
            return (Criteria) this;
        }

        public Criteria andReidBetween(String value1, String value2) {
            addCriterion("reid between", value1, value2, "reid");
            return (Criteria) this;
        }

        public Criteria andReidNotBetween(String value1, String value2) {
            addCriterion("reid not between", value1, value2, "reid");
            return (Criteria) this;
        }

        public Criteria andRsnoIsNull() {
            addCriterion("rsno is null");
            return (Criteria) this;
        }

        public Criteria andRsnoIsNotNull() {
            addCriterion("rsno is not null");
            return (Criteria) this;
        }

        public Criteria andRsnoEqualTo(Long value) {
            addCriterion("rsno =", value, "rsno");
            return (Criteria) this;
        }

        public Criteria andRsnoNotEqualTo(Long value) {
            addCriterion("rsno <>", value, "rsno");
            return (Criteria) this;
        }

        public Criteria andRsnoGreaterThan(Long value) {
            addCriterion("rsno >", value, "rsno");
            return (Criteria) this;
        }

        public Criteria andRsnoGreaterThanOrEqualTo(Long value) {
            addCriterion("rsno >=", value, "rsno");
            return (Criteria) this;
        }

        public Criteria andRsnoLessThan(Long value) {
            addCriterion("rsno <", value, "rsno");
            return (Criteria) this;
        }

        public Criteria andRsnoLessThanOrEqualTo(Long value) {
            addCriterion("rsno <=", value, "rsno");
            return (Criteria) this;
        }

        public Criteria andRsnoIn(List<Long> values) {
            addCriterion("rsno in", values, "rsno");
            return (Criteria) this;
        }

        public Criteria andRsnoNotIn(List<Long> values) {
            addCriterion("rsno not in", values, "rsno");
            return (Criteria) this;
        }

        public Criteria andRsnoBetween(Long value1, Long value2) {
            addCriterion("rsno between", value1, value2, "rsno");
            return (Criteria) this;
        }

        public Criteria andRsnoNotBetween(Long value1, Long value2) {
            addCriterion("rsno not between", value1, value2, "rsno");
            return (Criteria) this;
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

        public Criteria andReurlIsNull() {
            addCriterion("reurl is null");
            return (Criteria) this;
        }

        public Criteria andReurlIsNotNull() {
            addCriterion("reurl is not null");
            return (Criteria) this;
        }

        public Criteria andReurlEqualTo(String value) {
            addCriterion("reurl =", value, "reurl");
            return (Criteria) this;
        }

        public Criteria andReurlNotEqualTo(String value) {
            addCriterion("reurl <>", value, "reurl");
            return (Criteria) this;
        }

        public Criteria andReurlGreaterThan(String value) {
            addCriterion("reurl >", value, "reurl");
            return (Criteria) this;
        }

        public Criteria andReurlGreaterThanOrEqualTo(String value) {
            addCriterion("reurl >=", value, "reurl");
            return (Criteria) this;
        }

        public Criteria andReurlLessThan(String value) {
            addCriterion("reurl <", value, "reurl");
            return (Criteria) this;
        }

        public Criteria andReurlLessThanOrEqualTo(String value) {
            addCriterion("reurl <=", value, "reurl");
            return (Criteria) this;
        }

        public Criteria andReurlLike(String value) {
            addCriterion("reurl like", value, "reurl");
            return (Criteria) this;
        }

        public Criteria andReurlNotLike(String value) {
            addCriterion("reurl not like", value, "reurl");
            return (Criteria) this;
        }

        public Criteria andReurlIn(List<String> values) {
            addCriterion("reurl in", values, "reurl");
            return (Criteria) this;
        }

        public Criteria andReurlNotIn(List<String> values) {
            addCriterion("reurl not in", values, "reurl");
            return (Criteria) this;
        }

        public Criteria andReurlBetween(String value1, String value2) {
            addCriterion("reurl between", value1, value2, "reurl");
            return (Criteria) this;
        }

        public Criteria andReurlNotBetween(String value1, String value2) {
            addCriterion("reurl not between", value1, value2, "reurl");
            return (Criteria) this;
        }

        public Criteria andRescoreIsNull() {
            addCriterion("rescore is null");
            return (Criteria) this;
        }

        public Criteria andRescoreIsNotNull() {
            addCriterion("rescore is not null");
            return (Criteria) this;
        }

        public Criteria andRescoreEqualTo(Integer value) {
            addCriterion("rescore =", value, "rescore");
            return (Criteria) this;
        }

        public Criteria andRescoreNotEqualTo(Integer value) {
            addCriterion("rescore <>", value, "rescore");
            return (Criteria) this;
        }

        public Criteria andRescoreGreaterThan(Integer value) {
            addCriterion("rescore >", value, "rescore");
            return (Criteria) this;
        }

        public Criteria andRescoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("rescore >=", value, "rescore");
            return (Criteria) this;
        }

        public Criteria andRescoreLessThan(Integer value) {
            addCriterion("rescore <", value, "rescore");
            return (Criteria) this;
        }

        public Criteria andRescoreLessThanOrEqualTo(Integer value) {
            addCriterion("rescore <=", value, "rescore");
            return (Criteria) this;
        }

        public Criteria andRescoreIn(List<Integer> values) {
            addCriterion("rescore in", values, "rescore");
            return (Criteria) this;
        }

        public Criteria andRescoreNotIn(List<Integer> values) {
            addCriterion("rescore not in", values, "rescore");
            return (Criteria) this;
        }

        public Criteria andRescoreBetween(Integer value1, Integer value2) {
            addCriterion("rescore between", value1, value2, "rescore");
            return (Criteria) this;
        }

        public Criteria andRescoreNotBetween(Integer value1, Integer value2) {
            addCriterion("rescore not between", value1, value2, "rescore");
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