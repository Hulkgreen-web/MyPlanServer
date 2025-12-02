package com.helha.myplanserver.application.utils;

public interface ICommandHandler<I,O> {
    O handle(I input);
}
