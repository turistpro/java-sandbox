package com.github.turistpro.sandbox.interview.design.ioc;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConstantResolver<T> implements Resolver<T> {

    private final T obj;

    @Override
    public T get() {
        return this.obj;
    }

    @Override
    public Class<T> type() {
        return (Class<T>) this.obj.getClass();
    }
}
