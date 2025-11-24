package com.helha.myplanserver.controllers.category.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

public class CategorynotFoundException extends ErrorResponseException {
    public CategorynotFoundException(long id) {
        super(HttpStatus.NOT_FOUND, ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                "Category not found with id " + id),null);
    }
}
