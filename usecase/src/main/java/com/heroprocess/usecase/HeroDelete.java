package com.heroprocess.usecase;

import com.heroprocess.usecase.port.HeroRepositoryPort;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder(toBuilder = true)
@RequiredArgsConstructor
public class HeroDelete {
    private final HeroRepositoryPort heroRepositoryPort;

    public void deleteHero(String id){
        heroRepositoryPort.deleteHero(id);
    }
}
