package com.heroprocess.routes;

import com.heroprocess.handler.ErrorHandler;
import com.heroprocess.handler.HeroHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.accept;

@Configuration
public class  HeroRoute {
    @Bean
    public RouterFunction<ServerResponse> route (HeroHandler handler, ErrorHandler errorHandler) {

        return RouterFunctions.route()
                //.onError(errorHandler::handleError)
                .GET("/heroes", accept(MediaType.APPLICATION_JSON), req -> ServerResponse.ok().body(handler.allHeroes(req)))
                .PATCH("/hero/update",accept(MediaType.APPLICATION_JSON),req -> ServerResponse.accepted().body(handler.update(req)))
                .GET("/hero/{*id}", accept(MediaType.APPLICATION_JSON),req -> ServerResponse.ok().body(handler.get(req)))
                .DELETE("/hero/{*id}", accept(MediaType.APPLICATION_JSON),req -> ServerResponse.status(HttpStatus.NO_CONTENT).body(handler.delete(req)))
                .build();
    }
}


