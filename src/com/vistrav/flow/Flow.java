package com.vistrav.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Flow<T> {

    private final Iterator<? extends T> iterator;

    private Flow(Iterator<? extends T> iterator) {
        this.iterator = iterator;
    }

    public static <T> Flow<T> empty() {
        return of(Collections.<T>emptyList());
    }

    public static <T> Flow<T> of(Iterator<? extends T> iterator) {
        //Objects.requireNonNull(iterator);
        if (iterator == null) {
            return Flow.<T>empty();
        }
        return new Flow<T>(iterator);
    }

    public static <T> Flow<T> of(Iterable<? extends T> iterable) {
        //Objects.requireNonNull(iterable);
        if (iterable == null) {
            return Flow.<T>empty();
        }
        return new Flow<T>(iterable.iterator());
    }

    public static <T> Flow<T> of(final T... elements) {
        Objects.requireNonNull(elements);
        if (elements.length == 0) {
            return Flow.<T>empty();
        }
        return new Flow<T>(new ArrayIterator<>(elements));
    }

    public Flow<T> filter(final Predicate<? super T> predicate) {
        return new Flow<T>(new FilterIterator<T>(iterator, predicate));
    }

    public void forEach(final Consumer<? super T> action) {
        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }

    public <R> R reduce(R identity, BiFunction<? super R, ? super T, ? extends R> accumulator) {
        R result = identity;
        while (iterator.hasNext()) {
            final T value = iterator.next();
            result = accumulator.apply(result, value);
        }
        return result;
    }

    public T reduce(BiFunction<T, T, T> accumulator) {
        boolean foundAny = false;
        T result = null;
        while (iterator.hasNext()) {
            final T value = iterator.next();
            if (!foundAny) {
                foundAny = true;
                result = value;
            }
            else {
                result = accumulator.apply(result, value);
            }
        }
        return result;
    }

    public boolean anyMatch(Predicate<? super T> predicate) {
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (predicate.test(next)) {
                return true;
            }
        }
        return false;
    }

    public List<T> toList() {
        final List<T> result = new ArrayList<T>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

}
