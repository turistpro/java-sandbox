package com.github.turistpro.sandbox.interview.hibernate;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = App.class
)
@Slf4j()
public class AppTest extends TestCase {

    @Autowired
    private EntityManager entityManager;


    @Test
    public void testData() {
        assertNotNull(this.entityManager);
        log.info("entityManager className = {}", this.entityManager.getClass());
    }

}