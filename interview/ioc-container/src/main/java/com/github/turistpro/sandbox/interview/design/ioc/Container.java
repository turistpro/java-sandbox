package com.github.turistpro.sandbox.interview.design.ioc;

import java.util.function.Function;

public interface Container {

    <T> void addSingleton(Class<T> type, Function<Container, T> builder);
    <T> void addSingleton(T obj);
    <T> void addSingleton(Class<T> type);
    <T> void addPrototype(Class<T> type);
    <T> void addPrototype(Class<T> type, Function<Container, T> builder);
    <T> T getBean(Class<T> type);
}
