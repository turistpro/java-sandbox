package com.github.turistpro.sandbox.interview.design.ioc;

import java.util.function.Supplier;

public interface Resolver<T> extends Supplier<T> {
    Class<T> type();
}
