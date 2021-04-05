package com.heroprocess.config;


import com.heroprocess.usecase.HeroDelete;
import com.heroprocess.usecase.HeroGet;
import com.heroprocess.usecase.HeroGetAll;
import com.heroprocess.usecase.HeroUpdate;
import com.heroprocess.usecase.port.HeroRepositoryPort;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan("com.loanprocess")
@ConfigurationPropertiesScan("com.loanprocess")
@Configuration
public class SpringConfiguration {

    private final HeroRepositoryPort heroRepositoryPort;


    public SpringConfiguration(HeroRepositoryPort heroRepositoryPort) {
        this.heroRepositoryPort = heroRepositoryPort;
    }

    @Bean
    HeroGetAll heroGetAll() {
        return HeroGetAll.builder().heroRepositoryPort(heroRepositoryPort).build();
    }

    @Bean
    HeroGet heroGet() {
        return HeroGet.builder().heroRepositoryPort(heroRepositoryPort).build();
    }

    @Bean
    HeroDelete heroDelete() {
        return HeroDelete.builder().heroRepositoryPort(heroRepositoryPort).build();
    }

    @Bean
    HeroUpdate heroUpdate() {
        return HeroUpdate.builder().heroRepositoryPort(heroRepositoryPort).build();
    }

}