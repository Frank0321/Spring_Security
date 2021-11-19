package com.example.Spring_Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * FileName : PersistenceConfig
 * CreatTime : 2021/11/19
 * Author : Frank.Chang
 * Description :
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PersistenceConfig {

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
}
