package com.heroprocess.usecase;

import com.heroprocess.domain.entity.Hero;
import com.heroprocess.usecase.port.HeroRepositoryPort;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder(toBuilder = true)
@RequiredArgsConstructor
public class HeroGet {
    private final HeroRepositoryPort heroRepositoryPort;

    public Hero getHero(String id){
        return heroRepositoryPort.getHero(id);
    }
}
