package com.heroprocess.domain.entity;

import lombok.*;

@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
@Setter
public class Hero {
    String id;
    String name;
    Double height, weight;
}
