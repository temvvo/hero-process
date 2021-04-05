package com.heroprocess.repository.h2.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class H2Hero {
    @Id
    String id;
    String name;
    Double height, weight;
}