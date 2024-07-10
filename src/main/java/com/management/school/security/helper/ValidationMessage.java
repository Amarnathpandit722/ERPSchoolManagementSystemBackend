package com.management.school.security.helper;

public class ValidationMessage {

	  public static class General {
	        public static final String PHONE_REGEX = "^[09]{2}[0-9]{9}$";
	        public static final String NATIONAL_ID_REGEX = "^[1-9]{1}[0-9]{10}$";
	    }

	    public static class Address {
	        public static final String ADDRESS_STREET_NOT_EMPTY = "Address street can not be empty";
	        public static final String ADDRESS_STREET_NOT_NULL = "Address street can not be null";
	        public static final String ADDRESS_CITY_NOT_EMPTY = "Address city can not be empty";
	        public static final String ADDRESS_CITY_NOT_NULL = "Address city can not be null";
	        public static final String ADDRESS_STATE_NOT_EMPTY = "Address state can not be empty";
	        public static final String ADDRESS_STATE_NOT_NULL = "Address state can not be null";
	        public static final String ADDRESS_ZIPCODE_NOT_EMPTY = "Address zip code can not be empty";
	        public static final String ADDRESS_ZIPCODE_NOT_NULL = "Address zip code can not be null";
	        public static final String ADDRESS_STUDENT_ID_NOT_EMPTY = "Address student id can not be empty";
	        public static final String ADDRESS_STUDENT_ID_NOT_NULL = "Address student id can not be null";

	    }

	    public static class Classroom {
	        public static final String CLASSROOM_DESCRIPTION_NOT_EMPTY = "Classroom description can not be empty";
	        public static final String CLASSROOM_DESCRIPTION_NOT_NULL = "Classroom description can not be null";
	        public static final String CLASSROOM_NAME_NOT_EMPTY = "Classroom name can not be empty";
	        public static final String CLASSROOM_NAME_NOT_NULL = "Classroom name can not be null";
	        public static final String CLASSROOM_TEACHER_ID_NOT_EMPTY = "Classroom teacher id can not be empty";
	        public static final String CLASSROOM_TEACHER_ID_NOT_NULL = "Classroom teacher id can not be null";
			

	    }

	    public static class Student {
	        public static final String STUDENT_FIRST_NAME_NOT_EMPTY = "Student first name can not be empty";
	        public static final String STUDENT_FIRST_NAME_NOT_NULL = "Student first name can not be null";
	        public static final String STUDENT_LAST_NAME_NOT_EMPTY = "Student last name can not be empty";
	        public static final String STUDENT_LAST_NAME_NOT_NULL = "Student last name can not be null";
	        public static final String STUDENT_NATIONAL_ID_NOT_EMPTY = "Student national id can not be empty";
	        public static final String STUDENT_NATIONAL_ID_NOT_NULL = "Student national id can not be null";
	        public static final String STUDENT_NATIONAL_ID_NOT_VALID = "Student national id is not valid, it should be 11 digits";
	        public static final String STUDENT_FATHER_NAME_NOT_EMPTY = "Student father name can not be empty";
	        public static final String STUDENT_FATHER_NAME_NOT_NULL = "Student father name can not be null";
	        public static final String STUDENT_FATHER_PHONE_NOT_EMPTY = "Student father phone can not be empty";
	        public static final String STUDENT_FATHER_PHONE_NOT_NULL = "Student father phone can not be null";
	        public static final String STUDENT_FATHER_PHONE_NOT_VALID = "Student father phone is not valid";
	        public static final String STUDENT_MOTHER_NAME_NOT_EMPTY = "Student mother name can not be empty";
	        public static final String STUDENT_MOTHER_NAME_NOT_NULL = "Student mother name can not be null";
	        public static final String STUDENT_MOTHER_PHONE_NOT_EMPTY = "Student mother phone can not be empty";
	        public static final String STUDENT_MOTHER_PHONE_NOT_NULL = "Student mother phone can not be null";
	        public static final String STUDENT_MOTHER_PHONE_NOT_VALID = "Student mother phone is not valid";
	        public static final String STUDENT_CLASSROOM_ID_NOT_EMPTY = "Student classroom id can not be empty";
	    }

	    public static class Teacher {
	        public static final String TEACHER_FIRST_NAME_NOT_EMPTY = "Teacher first name can not be empty";
	        public static final String TEACHER_FIRST_NAME_NOT_NULL = "Teacher first name can not be null";
	        public static final String TEACHER_LAST_NAME_NOT_EMPTY = "Teacher last name can not be empty";
	        public static final String TEACHER_LAST_NAME_NOT_NULL = "Teacher last name can not be null";
	        public static final String TEACHER_NATIONAL_ID_NOT_EMPTY = "Teacher national id can not be empty";
	        public static final String TEACHER_NATIONAL_ID_NOT_NULL = "Teacher national id can not be null";
	        public static final String TEACHER_NATIONAL_ID_NOT_VALID = "Teacher national id is not valid, it should be 11 digits";
	        public static final String TEACHER_PHONE_NOT_EMPTY = "Teacher phone can not be empty";
	        public static final String TEACHER_PHONE_NOT_NULL = "Teacher phone can not be null";
	        public static final String TEACHER_PHONE_NOT_VALID = "Teacher phone is not valid";
	    }
	    
	    public static class Result {
	        public static final String RESULT_STUDENT_ID_NOT_EMPTY = "Result student id can not be empty";
	        public static final String RESULT_STUDENT_ID_NOT_NULL = "Result student id can not be null";
	        public static final String RESULT_SUBJECT_ID_NOT_EMPTY = "Result subject id can not be empty";
	        public static final String RESULT_SUBJECT_ID_NOT_NULL = "Result subject id can not be null";
	        public static final String RESULT_SCORE_NOT_NULL = "Result score can not be null";
	        public static final String RESULT_SCORE_MIN_VALUE = "Result score must be between 0 and 100";
	        public static final String RESULT_GRADE_NOT_EMPTY = "Result grade can not be empty";
	        public static final String RESULT_GRADE_NOT_NULL = "Result grade can not be null";
	        public static final String RESULT_REMARKS_NOT_NULL = "Result remarks can not be null";
	        public static final String RESULT_CLASSROOM_ID_NOT_NULL = "Result classroom id can not be null";
	        public static final String RESULT_CLASSROOM_ID_NOT_EMPTY = "Result classroom id can not be empty";
	        public static final String RESULT_TEACHER_ID_NOT_NULL = "Result teacher id can not be null";
	        public static final String RESULT_TEACHER_ID_NOT_EMPTY = "Result teacher id can not be empty";
			public static final String RESULT_REMARKS_NOT_EMPTY = "Result reamrks not empty";
			public static final String SUBJECT_RESULT_DTO_NOT_NULL = "Subject result dto must not null";
			public static final String SUBJECT_RSULT_DTO_NOT_EMPTY = "ubject result dto must not empty";
	        
	    }
	    public static class Subject {
	        public static final String SUBJECT_NAME_NOT_EMPTY = "Subject name can not be empty";
	        public static final String SUBJECT_NAME_NOT_NULL = "Subject name can not be null";
	        public static final String SUBJECT_DESCRIPTION_NOT_EMPTY = "Subject description can not be empty";
	        public static final String SUBJECT_DESCRIPTION_NOT_NULL = "Subject description can not be null";
	        public static final String SUBJECT_TEACHER_ID_NOT_EMPTY = "Subject teacher id can not be empty";
	        public static final String SUBJECT_TEACHER_ID_NOT_NULL = "Subject teacher id can not be null";
	        public static final String SUBJECT_CLASSROOM_ID_NOT_EMPTY = "Subject classroom id can not be empty";
	        public static final String SUBJECT_CLASSROOM_ID_NOT_NULL = "Subject classroom id can not be null";
	        public static final String SUBJECT_CODE_NOT_NULL = "Subject code can not be null";
	        public static final String SUBJECT_CODE_NOT_EMPTY = "Subject code can not be empty";
			public static final String SUBJECT_TEACHER_NOT_NULL = "Subject teacher can not be null";
			public static final String SUBJECT_TEACHER_NOT_EMPTY= "Subject teacher can not be empty";
			public static final String CLASSROOM_ID_NOT_NULL = "Classroom id can not be null";
			public static final String CLASSROOM_ID_NOT_EMPTY = "Classroom id can not be empty";
	    
	    }
	    public static class SubjectResult {
	        public static final String GRADE_MUST_NOT_NULL = "Grade must not be null";
	        public static final String GRADE_MUST_NOT_EMPTY = "Grade must not be empty";
	        public static final String REMARKS_MUST_NOT_NULL = "Remarks must not be null";
			public static final String REMARKS_MUST_NOT_EMPTY = "Remarks must not be empty";
	        public static final String SUBJECT_ID_MUST_NOT_NULL = "Subject ID must not be null";
	        public static final String SUBJECT_ID_MUST_NOT_EMPTY = "Subject ID must not be empty";
	        public static final String TEACHER_ID_MUST_NOT_NULL = "Teacher ID must not be null";
	        public static final String TEACHER_ID_MUST_NOT_EMPTY = "Teacher ID must not be empty";
	    }
}
