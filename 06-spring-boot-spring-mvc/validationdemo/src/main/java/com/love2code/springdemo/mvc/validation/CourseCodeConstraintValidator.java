package com.love2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.thymeleaf.util.StringUtils;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;
    @Override
    public void initialize(CourseCode pConstraintAnnotation) {
        coursePrefix = pConstraintAnnotation.value();
    }

    @Override
    public boolean isValid(String pCode, ConstraintValidatorContext pConstraintValidatorContext) {

        boolean result = (!StringUtils.isEmptyOrWhitespace(pCode))?pCode.startsWith(coursePrefix):true;
        return result;
    }
}
