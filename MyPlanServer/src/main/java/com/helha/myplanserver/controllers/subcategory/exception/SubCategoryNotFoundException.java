package com.helha.myplanserver.controllers.subcategory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

public class SubCategoryNotFoundException extends ErrorResponseException {
    public SubCategoryNotFoundException(long id , long category_id) {
        super(HttpStatus.NOT_FOUND, ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                "Subcategory not found with id " + id + "in the category " + category_id),null);
    }
}
