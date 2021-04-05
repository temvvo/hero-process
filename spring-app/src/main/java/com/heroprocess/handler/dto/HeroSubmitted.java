package com.heroprocess.handler.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class HeroSubmitted {
    String id;
    Double height, weight;
}
