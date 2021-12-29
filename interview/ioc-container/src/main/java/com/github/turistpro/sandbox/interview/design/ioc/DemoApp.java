package com.github.turistpro.sandbox.interview.design.ioc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j
public class DemoApp {

    @RequiredArgsConstructor
    private static class ServiceA {
        private final List list;
    }

    private interface Service extends Runnable {
    }

    @RequiredArgsConstructor
    @Slf4j
    private static class ServiceB implements Service {
        private final ServiceA serviceA;

        @Override
        public void run() {
            log.info(this.serviceA.list.toString());
        }
    }

    public static void main(String[] args) {
        Container container = new ContainerImpl();
        container.addSingleton(ServiceA.class);
        container.addSingleton(Collections.singletonList("123"));
        container.addSingleton(ServiceB.class);

        container.getBean(Service.class).run();
    }
}
