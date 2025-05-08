package com.example.BasicToAdvance.configuration.Auditable;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(
        basePackages = "com.example.BasicToAdvance",// eta avabe use korte hoiche karon user package er bahire user kora hoiche tai
        repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class
)
@EntityScan(basePackages = "com.example.BasicToAdvance") // eta avabe use korte hoiche karon user package er bahire user kora hoiche tai
@EnableEnversRepositories
public class EnversConfig implements AuditorAware<String> {
    @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of("system");
        }
        return Optional.of(authentication.getName());
    }

}