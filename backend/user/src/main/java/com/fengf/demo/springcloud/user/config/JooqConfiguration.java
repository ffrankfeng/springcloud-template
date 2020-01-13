package com.fengf.demo.springcloud.user.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class JooqConfiguration {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Bean
    @LoadBalanced
    public DSLContext getDSLContext() {
        try {
            Class.forName(driver).newInstance();
            //url, user, password替换
            Connection connection =
                    DriverManager.getConnection(url, user,password);
            System.out.println("connection : "+connection);
            return DSL.using(connection, SQLDialect.MYSQL);
        } catch (Exception e) {
            System.out.println("connection failed");
            e.printStackTrace();
        }
        return null;
    }
}
