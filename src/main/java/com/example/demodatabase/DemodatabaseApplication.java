package com.example.demodatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemodatabaseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemodatabaseApplication.class, args);
        checkDatabaseConnection(context);
    }

    private static void checkDatabaseConnection(ConfigurableApplicationContext context) {
        try {
            JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
        } catch (Exception e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
    }
}
