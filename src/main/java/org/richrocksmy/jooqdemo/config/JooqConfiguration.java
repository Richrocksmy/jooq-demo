package org.richrocksmy.jooqdemo.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class JooqConfiguration {

  @Bean
  public DSLContext createDslContext(@Value("${spring.datasource.url}") String url,
                                     @Value("${spring.datasource.username}") String userName,
                                     @Value("${spring.datasource.password}") String password) throws Exception {
    Connection connection = DriverManager.getConnection(url, userName, password);
    return DSL.using(connection, SQLDialect.POSTGRES);
  }
}
