package com.thaiboxing.thaiboxingapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clubs_in_cities")

public record ClubsInCities(
        @EmbeddedId //sammensatt nøkkel
        ClubCityId id,

        @ManyToOne
        @MapsId("cityCode") //cityCode-delen av primary key kommer fra city-objektet
        @JoinColumn(name = "city_code")
        City city,

        @ManyToOne
        @MapsId("clubId") //clubID-delen av primary key kommer fra club-objektet
        @JoinColumn(name = "club_id")
        ThaiboxingClub thaiboxingClub

        ) {}
