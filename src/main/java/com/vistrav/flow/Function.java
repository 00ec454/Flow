package com.vistrav.flow;

@FunctionalInterface
public interface Function<T, R> {

    R apply(T value1);
}