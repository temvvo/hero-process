package com.heroprocess.repository.h2;

import com.heroprocess.repository.h2.dto.H2Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2HeroRepository extends CrudRepository<H2Hero, String> {
    //H2Hero findByCode(String code);
}
