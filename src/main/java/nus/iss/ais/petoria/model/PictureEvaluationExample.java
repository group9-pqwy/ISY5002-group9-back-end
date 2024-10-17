package nus.iss.ais.petoria.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PictureEvaluationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PictureEvaluationExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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
            List<java.sql.Date> dateList = new ArrayList<>();
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

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Date value) {
            addCriterionForJDBCDate("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Date value) {
            addCriterionForJDBCDate("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Date> values) {
            addCriterionForJDBCDate("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultIsNull() {
            addCriterion("breed_recognition_result is null");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultIsNotNull() {
            addCriterion("breed_recognition_result is not null");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultEqualTo(String value) {
            addCriterion("breed_recognition_result =", value, "breedRecognitionResult");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultNotEqualTo(String value) {
            addCriterion("breed_recognition_result <>", value, "breedRecognitionResult");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultGreaterThan(String value) {
            addCriterion("breed_recognition_result >", value, "breedRecognitionResult");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultGreaterThanOrEqualTo(String value) {
            addCriterion("breed_recognition_result >=", value, "breedRecognitionResult");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultLessThan(String value) {
            addCriterion("breed_recognition_result <", value, "breedRecognitionResult");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultLessThanOrEqualTo(String value) {
            addCriterion("breed_recognition_result <=", value, "breedRecognitionResult");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultLike(String value) {
            addCriterion("breed_recognition_result like", value, "breedRecognitionResult");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultNotLike(String value) {
            addCriterion("breed_recognition_result not like", value, "breedRecognitionResult");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultIn(List<String> values) {
            addCriterion("breed_recognition_result in", values, "breedRecognitionResult");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultNotIn(List<String> values) {
            addCriterion("breed_recognition_result not in", values, "breedRecognitionResult");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultBetween(String value1, String value2) {
            addCriterion("breed_recognition_result between", value1, value2, "breedRecognitionResult");
            return (Criteria) this;
        }

        public Criteria andBreedRecognitionResultNotBetween(String value1, String value2) {
            addCriterion("breed_recognition_result not between", value1, value2, "breedRecognitionResult");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIsNull() {
            addCriterion("user_feedback is null");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIsNotNull() {
            addCriterion("user_feedback is not null");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackEqualTo(Integer value) {
            addCriterion("user_feedback =", value, "userFeedback");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNotEqualTo(Integer value) {
            addCriterion("user_feedback <>", value, "userFeedback");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackGreaterThan(Integer value) {
            addCriterion("user_feedback >", value, "userFeedback");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_feedback >=", value, "userFeedback");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackLessThan(Integer value) {
            addCriterion("user_feedback <", value, "userFeedback");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackLessThanOrEqualTo(Integer value) {
            addCriterion("user_feedback <=", value, "userFeedback");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIn(List<Integer> values) {
            addCriterion("user_feedback in", values, "userFeedback");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNotIn(List<Integer> values) {
            addCriterion("user_feedback not in", values, "userFeedback");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackBetween(Integer value1, Integer value2) {
            addCriterion("user_feedback between", value1, value2, "userFeedback");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNotBetween(Integer value1, Integer value2) {
            addCriterion("user_feedback not between", value1, value2, "userFeedback");
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