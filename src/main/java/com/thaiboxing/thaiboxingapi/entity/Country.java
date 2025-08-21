package com.thaiboxing.thaiboxingapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public record Country(
    @Id
    @Column(name = "country_code")
    String countryCode,

    @Column(name = "country_name")
    String countryName,

    @Column(name = "country_population")
    Long countryPopulation,

    @Column(name = "country_surface_area")
    Long countrySurfaceArea
)
{
    public Country() {
        this(null, null, null, null);
    }
}
