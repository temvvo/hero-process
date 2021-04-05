package com.heroprocess.usecase;

import com.heroprocess.domain.entity.Hero;
import com.heroprocess.usecase.port.HeroRepositoryPort;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder(toBuilder = true)
@RequiredArgsConstructor
public class HeroUpdate {
    private final HeroRepositoryPort heroRepositoryPort;

    public Hero update(Hero hero){
        return heroRepositoryPort.update(hero);
    }
}
