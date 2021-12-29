package com.github.turistpro.sandbox.interview.design.ioc;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

public class ContainerImpl implements Container {

    private List<Resolver> resolvers = new CopyOnWriteArrayList<>();

    public <T> void addSingleton(Class<T> tClass, Function<Container, T> builder) {
        Objects.requireNonNull(tClass);
        Objects.requireNonNull(builder);
        this.resolvers.add(new MemoResolver(new FunctionResolver(this, tClass, builder)));
    }

    @Override
    public <T> void addPrototype(Class<T> type, Function<Container, T> builder) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(builder);
        this.resolvers.add(new FunctionResolver(this, type, builder));
    }

    @Override
    public <T> void addSingleton(T obj) {
        Objects.requireNonNull(obj);
        this.resolvers.add(new ConstantResolver(obj));
    }

    public <T> T getBean(Class<T> tClass) {
        Objects.requireNonNull(tClass);
        return (T) this.resolvers.stream()
                .filter(resolver -> tClass.isAssignableFrom(resolver.type()))
                .findFirst()
                .map(Resolver::get)
                .orElseThrow(() -> new IllegalArgumentException("no bean found"));
    }

    @Override
    public <T> void addPrototype(Class<T> type) {
        Objects.requireNonNull(type);
        this.resolvers.add(new ReflectionResolver(this, type));
    }

    @Override
    public <T> void addSingleton(Class<T> type) {
        Objects.requireNonNull(type);
        this.resolvers.add(new MemoResolver(new ReflectionResolver(this, type)));
    }
}
