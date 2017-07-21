package com.vistrav.flow;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T value);
}
