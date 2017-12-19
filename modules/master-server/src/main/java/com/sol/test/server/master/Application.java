package com.sol.test.server.master;

import com.sol.test.server.master.datasource.DataSourceFactory;
import com.sol.test.server.master.datasource.impl.DataSourceFactoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    DataSourceFactory dataSourceFactory() {
        return new DataSourceFactoryImpl();
    }
}
