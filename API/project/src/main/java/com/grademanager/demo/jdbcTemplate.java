package com.grademanager.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class jdbcTemplate {
    
    /** 
     * @param dataSource
     * @return JdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
