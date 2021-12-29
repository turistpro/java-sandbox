package com.github.turistpro.sandbox.interview.hibernate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.schema.Action;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.github.turistpro.sandbox.interview.hibernate.model.User;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
public class HibernateTest {

    private DataSource dataSource;

    private StandardServiceRegistry registry;

    private SessionFactory sessionFactory;

    private void setUpDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        this.dataSource = new HikariDataSource(config);
    }

    @Before
    public void setUp() {
        this.setUpDataSource();
        final Configuration configuration = new Configuration()
                .addAnnotatedClass(User.class);
        this.registry = new StandardServiceRegistryBuilder()
                .applySetting(Environment.DATASOURCE, this.dataSource)
                .applySetting(Environment.SHOW_SQL, true)
                .applySetting(Environment.HBM2DDL_AUTO, Action.CREATE_DROP)
                .build();

        this.sessionFactory = configuration.buildSessionFactory(this.registry);
    }

    @After
    public void clean() {
        StandardServiceRegistryBuilder.destroy(this.registry);
    }

    @Test
    public void setUpTest() {
        assertNotNull(this.sessionFactory);
    }

    @Test
    public void addTest() {
        final User user = new User();
        user.setName("test");
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
        assertNotNull(user.getId());
        final Long id = user.getId();
        try (Session session = this.sessionFactory.openSession()) {
            assertEquals(user, session.find(User.class, id));
        }
    }


}
