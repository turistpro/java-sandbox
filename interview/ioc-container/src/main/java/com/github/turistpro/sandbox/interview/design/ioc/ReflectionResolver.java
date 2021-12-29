package com.github.turistpro.sandbox.interview.design.ioc;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public class ReflectionResolver<T> implements Resolver<T> {

    private final Container container;
    private final Class<T> type;

    @Override
    public T get() {
        return (T) Arrays.stream(type.getConstructors()).findFirst().map(constructor -> {
                    try {
                        return constructor.newInstance(
                                Arrays.stream(constructor.getParameterTypes())
                                        .map(container::getBean)
                                        .toArray()
                        );
                    } catch (Exception e) {
                        throw new RuntimeException("Error during bean creation", e);
                    }
                })

                .orElseThrow(() -> new IllegalArgumentException("No suitable constructors"));
    }

    @Override
    public Class<T> type() {
        return this.type;
    }
}
