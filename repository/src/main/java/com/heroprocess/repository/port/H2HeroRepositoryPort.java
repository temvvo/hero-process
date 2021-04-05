package com.heroprocess.repository.port;

import com.heroprocess.domain.entity.Hero;
import com.heroprocess.repository.h2.H2HeroMapper;
import com.heroprocess.repository.h2.H2HeroRepository;
import com.heroprocess.repository.h2.dto.H2Hero;
import com.heroprocess.usecase.port.HeroRepositoryPort;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class H2HeroRepositoryPort implements HeroRepositoryPort {

    private final H2HeroRepository repository;
    private final H2HeroMapper h2HeroMapper;

    @Override
    public Iterable<Hero> getAllHeroes() {
        Iterable<H2Hero> result = repository.findAll();
        result.forEach(h2Hero -> log.info(h2Hero.getName()));
        return h2HeroMapper.from(repository.findAll());
    }

    @Override
    public Hero getHero(String id) {
        Optional<H2Hero> result = repository.findById(id);
        if (result.isEmpty())
            throw new NoSuchElementException("Hero with id: "+ id +" does not exists");
        return h2HeroMapper.from(result.get());

    }

    @Override
    public void deleteHero(String id) {
        repository.deleteById(id);
    }

    @Override
    public Hero update(Hero hero) {
        Optional<H2Hero> optional = repository.findById(hero.getId());
        if (optional.isEmpty())
            throw new NoSuchElementException("Hero with id: "+ hero.getId() +" does not exists");
        H2Hero repoHero = optional.get();
        if(hero.getHeight() != null)
            repoHero.setHeight(hero.getHeight());
        if(hero.getWeight() != null)
            repoHero.setWeight(hero.getWeight());

        return h2HeroMapper.from(repository.save(repoHero));

    }
}
