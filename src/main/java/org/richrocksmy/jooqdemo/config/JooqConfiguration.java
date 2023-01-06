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
  public DSLContext createDslContext(@Value("${spring.flyway.url}") String url,
                                     @Value("${spring.flyway.user}") String userName,
                                     @Value("${spring.flyway.password}") String password) throws Exception {
    Connection connection = DriverManager.getConnection(url, userName, password);
    return DSL.using(connection, SQLDialect.POSTGRES);
  }
}
