package com.heroprocess.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeroTest {

    private final Hero hero = Hero.builder().id("1").name("manolito").weight(70d).weight(80d).build();

    @Test
    void builder() {

        Assertions.assertEquals(hero.getName(),"manolito");
    }
}