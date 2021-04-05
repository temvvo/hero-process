package com.heroprocess.handler;

import com.heroprocess.domain.entity.Hero;
import com.heroprocess.handler.dto.HeroSubmitted;
import com.heroprocess.usecase.HeroDelete;
import com.heroprocess.usecase.HeroGet;
import com.heroprocess.usecase.HeroGetAll;
import com.heroprocess.usecase.HeroUpdate;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;

import javax.servlet.ServletException;
import java.io.IOException;

@Slf4j
@Component
@Data
public class HeroHandler {


    private final HeroGetAll heroGetAll;
    private final HeroGet heroGet;
    private final HeroDelete heroDelete;
    private final HeroUpdate heroUpdate;

    @Autowired
    public HeroHandler(HeroGetAll heroGetAll, HeroGet heroGet, HeroDelete heroDelete, HeroUpdate heroUpdate) {
        this.heroGetAll = heroGetAll;
        this.heroGet = heroGet;
        this.heroDelete = heroDelete;
        this.heroUpdate = heroUpdate;
    }

    public Iterable<Hero> allHeroes(ServerRequest serverRequest) throws ServletException, IOException {
        return heroGetAll.getAllHeroes();
    }

    public Hero get(ServerRequest serverRequest) throws ServletException, IOException {
        String id = serverRequest.pathVariable("id");
        id = id.replaceFirst("/","");
        return heroGet.getHero(id);
    }

    public String delete(ServerRequest serverRequest) throws ServletException, IOException {
        String id = serverRequest.pathVariable("id");
        id = id.replaceFirst("/","");
        heroDelete.deleteHero(id);
        return "Deleted";
    }

    public Hero update(ServerRequest req) throws ServletException, IOException {
        final HeroSubmitted heroSubmitted = req.body(HeroSubmitted.class);
        return heroUpdate.update(
                Hero.builder()
                        .id(heroSubmitted.getId())
                        .height(heroSubmitted.getHeight())
                        .weight(heroSubmitted.getWeight()).build());
    }
}
