package com.heroprocess.usecase.port;

import com.heroprocess.domain.entity.Hero;


public interface HeroRepositoryPort {
    Iterable<Hero> getAllHeroes();
    Hero getHero(String id);
    void deleteHero(String id);
    Hero update(Hero hero);

}
