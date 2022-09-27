package com.bobocode.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UrlValidator implements ConstraintValidator<ValidUrl, String> {

  public boolean isValid(String url, ConstraintValidatorContext context) {
    String[] urlPrefixes = {"http", "https"};
    var urlValidator = new org.apache.commons.validator.routines.UrlValidator(
        urlPrefixes);
    return urlValidator.isValid(url);
  }
}