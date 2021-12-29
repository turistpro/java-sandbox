package com.github.turistpro.sandbox.interview.design.ioc;

import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class FunctionResolver<T> implements Resolver<T> {
    private final Container container;
    private final Class<T> type;
    private final Function<Container, T> builder;

    @Override
    public T get() {
        return this.builder.apply(container);
    }

    @Override
    public Class<T> type() {
        return this.type;
    }
}
