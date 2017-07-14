package com.vistrav.flow;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] ts;
    private int index = 0;

    ArrayIterator(T[] ts) {
        this.ts = ts;
    }

    @Override
    public boolean hasNext() {
        return index < ts.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return ts[index++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}
