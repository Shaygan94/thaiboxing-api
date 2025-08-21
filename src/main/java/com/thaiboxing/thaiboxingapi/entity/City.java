package com.thaiboxing.thaiboxingapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "city")

public record City(
      @Id
      @Column(name = "city_code")
      String cityCode,

      @Column(name = "city_name")
      String cityName,

      @Column(name = "city_population")
      Long cityPopulation,

      @Column(name = "city_surface_area")
      Long citySurfaceArea,

      @ManyToOne
      @JoinColumn(name = "country_code")
      Country country
) {}
