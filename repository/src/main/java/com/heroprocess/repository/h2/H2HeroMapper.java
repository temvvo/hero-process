package com.heroprocess.repository.h2;

import com.heroprocess.domain.entity.Hero;
import com.heroprocess.repository.h2.dto.H2Hero;
import org.mapstruct.Mapper;

@Mapper
public interface H2HeroMapper {
    Hero from(H2Hero h2Hero);
    Iterable<Hero> from(Iterable<H2Hero> heroes);
}
