package com.heroprocess.repository.config;

import com.heroprocess.repository.h2.H2HeroMapper;
import com.heroprocess.repository.h2.H2HeroRepository;
import com.heroprocess.repository.port.H2HeroRepositoryPort;
import com.heroprocess.usecase.port.HeroRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PortsConfiguration {

    private final H2HeroRepository repository;
    private final H2HeroMapper mapper;

    @Bean
    public HeroRepositoryPort heroRepositoryPort() {
        return new H2HeroRepositoryPort(repository, mapper) {
        };
    }

}
