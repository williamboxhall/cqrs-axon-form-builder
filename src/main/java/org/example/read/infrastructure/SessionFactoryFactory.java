package org.example.read.infrastructure;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

public class SessionFactoryFactory {
    public SessionFactory create() {
        return createSessionFactory();
    }

    private SessionFactory createSessionFactory() {
        AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
        sessionFactoryBean.setDataSource(createDataSource());
        sessionFactoryBean.setHibernateProperties(createHibernateConfiguration());
        sessionFactoryBean.setPackagesToScan(new String[]{"org.example"});
        callAfterPropertiesSet(sessionFactoryBean);
        return sessionFactoryBean.getObject();
    }

    private DriverManagerDataSource createDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.hsqldb.jdbcDriver");
        ds.setUrl("jdbc:hsqldb:mem:webapp-bootstrap");
        ds.setUsername("sa");
        return ds;
    }

    private Properties createHibernateConfiguration() {
        Properties config = new Properties();
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        config.setProperty("hibernate.connection.pool_size", "1");
        config.setProperty("hibernate.connection.autocommit", "true");
        config.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        config.setProperty("hibernate.show_sql", "true");
        return config;
    }

    private static void callAfterPropertiesSet(InitializingBean initializingBean) {
        try {
            initializingBean.afterPropertiesSet();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
