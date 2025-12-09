package com.helha.myplanserver.application.utils;

public interface IQueryWithMultipleInputsHandler<I,O> {
    O handle(I input, I input2);
}
