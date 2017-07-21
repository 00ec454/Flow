package com.vistrav.flow;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
