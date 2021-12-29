package com.github.turistpro.sandbox.interview.design.ioc;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class MemoResolver<T> implements Resolver<T> {

    private final Resolver<T> resolver;
    private T result;

    @Override
    public T get() {
        if (result == null) {
            result = this.resolver.get();
        };
        return result;
    }

    @Override
    public Class<T> type() {
        return this.resolver.type();
    }
}
