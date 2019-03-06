//package com.inventory.config;
//
//import org.springframework.inventory.autoconfigure.flyway.FlywayDataSource;
//import org.springframework.inventory.context.properties.ConfigurationProperties;
//import org.springframework.inventory.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class PresistenceConfiguration {
//    @Bean
//    @ConfigurationProperties(prefix = "spring-datasource")
//    @Primary
//    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @ConfigurationProperties(prefix = "datasource-flyway")
//    @FlywayDataSource
//    public DataSource flywayDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//}
//
//spring.datasource.url = jdbc:h2:file:~/dasboot
//        spring.datasource.username=sa
//        spring.datasource.password=
//        spring.datasource.driver-class-name=org.h2.Driver
