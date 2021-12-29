package com.github.turistpro.sandbox.interview.design.ioc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContainerImplTest {


    @Test
    public void testSingleton() {
        ArrayList<String> list = new ArrayList<>();
        Container container = new ContainerImpl();
        container.addSingleton(list);
        assertSame(list, container.getBean(List.class));
    }

    @Test
    public void testPrototype() {
        Container container = new ContainerImpl();
        container.addPrototype(ArrayList.class, c -> new ArrayList());
        assertEquals(container.getBean(List.class), container.getBean(List.class));
        assertNotSame(container.getBean(List.class), container.getBean(List.class));
    }
}