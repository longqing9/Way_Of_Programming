package cn.nyist.springmvc.po;

import java.util.ArrayList;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTnoIsNull() {
            addCriterion("Tno is null");
            return (Criteria) this;
        }

        public Criteria andTnoIsNotNull() {
            addCriterion("Tno is not null");
            return (Criteria) this;
        }

        public Criteria andTnoEqualTo(Long value) {
            addCriterion("Tno =", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotEqualTo(Long value) {
            addCriterion("Tno <>", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThan(Long value) {
            addCriterion("Tno >", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThanOrEqualTo(Long value) {
            addCriterion("Tno >=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThan(Long value) {
            addCriterion("Tno <", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThanOrEqualTo(Long value) {
            addCriterion("Tno <=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoIn(List<Long> values) {
            addCriterion("Tno in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotIn(List<Long> values) {
            addCriterion("Tno not in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoBetween(Long value1, Long value2) {
            addCriterion("Tno between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotBetween(Long value1, Long value2) {
            addCriterion("Tno not between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andTnameIsNull() {
            addCriterion("Tname is null");
            return (Criteria) this;
        }

        public Criteria andTnameIsNotNull() {
            addCriterion("Tname is not null");
            return (Criteria) this;
        }

        public Criteria andTnameEqualTo(String value) {
            addCriterion("Tname =", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotEqualTo(String value) {
            addCriterion("Tname <>", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThan(String value) {
            addCriterion("Tname >", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThanOrEqualTo(String value) {
            addCriterion("Tname >=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThan(String value) {
            addCriterion("Tname <", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThanOrEqualTo(String value) {
            addCriterion("Tname <=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLike(String value) {
            addCriterion("Tname like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotLike(String value) {
            addCriterion("Tname not like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameIn(List<String> values) {
            addCriterion("Tname in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotIn(List<String> values) {
            addCriterion("Tname not in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameBetween(String value1, String value2) {
            addCriterion("Tname between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotBetween(String value1, String value2) {
            addCriterion("Tname not between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTsexIsNull() {
            addCriterion("Tsex is null");
            return (Criteria) this;
        }

        public Criteria andTsexIsNotNull() {
            addCriterion("Tsex is not null");
            return (Criteria) this;
        }

        public Criteria andTsexEqualTo(String value) {
            addCriterion("Tsex =", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexNotEqualTo(String value) {
            addCriterion("Tsex <>", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexGreaterThan(String value) {
            addCriterion("Tsex >", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexGreaterThanOrEqualTo(String value) {
            addCriterion("Tsex >=", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexLessThan(String value) {
            addCriterion("Tsex <", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexLessThanOrEqualTo(String value) {
            addCriterion("Tsex <=", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexLike(String value) {
            addCriterion("Tsex like", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexNotLike(String value) {
            addCriterion("Tsex not like", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexIn(List<String> values) {
            addCriterion("Tsex in", values, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexNotIn(List<String> values) {
            addCriterion("Tsex not in", values, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexBetween(String value1, String value2) {
            addCriterion("Tsex between", value1, value2, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexNotBetween(String value1, String value2) {
            addCriterion("Tsex not between", value1, value2, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsubjectIsNull() {
            addCriterion("Tsubject is null");
            return (Criteria) this;
        }

        public Criteria andTsubjectIsNotNull() {
            addCriterion("Tsubject is not null");
            return (Criteria) this;
        }

        public Criteria andTsubjectEqualTo(String value) {
            addCriterion("Tsubject =", value, "tsubject");
            return (Criteria) this;
        }

        public Criteria andTsubjectNotEqualTo(String value) {
            addCriterion("Tsubject <>", value, "tsubject");
            return (Criteria) this;
        }

        public Criteria andTsubjectGreaterThan(String value) {
            addCriterion("Tsubject >", value, "tsubject");
            return (Criteria) this;
        }

        public Criteria andTsubjectGreaterThanOrEqualTo(String value) {
            addCriterion("Tsubject >=", value, "tsubject");
            return (Criteria) this;
        }

        public Criteria andTsubjectLessThan(String value) {
            addCriterion("Tsubject <", value, "tsubject");
            return (Criteria) this;
        }

        public Criteria andTsubjectLessThanOrEqualTo(String value) {
            addCriterion("Tsubject <=", value, "tsubject");
            return (Criteria) this;
        }

        public Criteria andTsubjectLike(String value) {
            addCriterion("Tsubject like", value, "tsubject");
            return (Criteria) this;
        }

        public Criteria andTsubjectNotLike(String value) {
            addCriterion("Tsubject not like", value, "tsubject");
            return (Criteria) this;
        }

        public Criteria andTsubjectIn(List<String> values) {
            addCriterion("Tsubject in", values, "tsubject");
            return (Criteria) this;
        }

        public Criteria andTsubjectNotIn(List<String> values) {
            addCriterion("Tsubject not in", values, "tsubject");
            return (Criteria) this;
        }

        public Criteria andTsubjectBetween(String value1, String value2) {
            addCriterion("Tsubject between", value1, value2, "tsubject");
            return (Criteria) this;
        }

        public Criteria andTsubjectNotBetween(String value1, String value2) {
            addCriterion("Tsubject not between", value1, value2, "tsubject");
            return (Criteria) this;
        }

        public Criteria andTtelIsNull() {
            addCriterion("Ttel is null");
            return (Criteria) this;
        }

        public Criteria andTtelIsNotNull() {
            addCriterion("Ttel is not null");
            return (Criteria) this;
        }

        public Criteria andTtelEqualTo(String value) {
            addCriterion("Ttel =", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelNotEqualTo(String value) {
            addCriterion("Ttel <>", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelGreaterThan(String value) {
            addCriterion("Ttel >", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelGreaterThanOrEqualTo(String value) {
            addCriterion("Ttel >=", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelLessThan(String value) {
            addCriterion("Ttel <", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelLessThanOrEqualTo(String value) {
            addCriterion("Ttel <=", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelLike(String value) {
            addCriterion("Ttel like", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelNotLike(String value) {
            addCriterion("Ttel not like", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelIn(List<String> values) {
            addCriterion("Ttel in", values, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelNotIn(List<String> values) {
            addCriterion("Ttel not in", values, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelBetween(String value1, String value2) {
            addCriterion("Ttel between", value1, value2, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelNotBetween(String value1, String value2) {
            addCriterion("Ttel not between", value1, value2, "ttel");
            return (Criteria) this;
        }

        public Criteria andTpicIsNull() {
            addCriterion("Tpic is null");
            return (Criteria) this;
        }

        public Criteria andTpicIsNotNull() {
            addCriterion("Tpic is not null");
            return (Criteria) this;
        }

        public Criteria andTpicEqualTo(String value) {
            addCriterion("Tpic =", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicNotEqualTo(String value) {
            addCriterion("Tpic <>", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicGreaterThan(String value) {
            addCriterion("Tpic >", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicGreaterThanOrEqualTo(String value) {
            addCriterion("Tpic >=", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicLessThan(String value) {
            addCriterion("Tpic <", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicLessThanOrEqualTo(String value) {
            addCriterion("Tpic <=", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicLike(String value) {
            addCriterion("Tpic like", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicNotLike(String value) {
            addCriterion("Tpic not like", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicIn(List<String> values) {
            addCriterion("Tpic in", values, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicNotIn(List<String> values) {
            addCriterion("Tpic not in", values, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicBetween(String value1, String value2) {
            addCriterion("Tpic between", value1, value2, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicNotBetween(String value1, String value2) {
            addCriterion("Tpic not between", value1, value2, "tpic");
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