package com.helha.myplanserver.application.utils;

public interface IQueryWithInputHandler<I,O> {
    O handle(I input);
}
