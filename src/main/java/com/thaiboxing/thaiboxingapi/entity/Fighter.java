package com.thaiboxing.thaiboxingapi.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "fighter")

public record Fighter(
        @Id

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "fighter_id")
        Integer fighterId,

        @ManyToOne
        @JoinColumn(name = "club_id")
        ThaiboxingClub thaiboxingclub,

        @Column(name = "fighter_name")
        String fighterName,

        @Column(name = "fighter_style")
        String fighterStyle,

        @Column(name = "height_in_cm")
        Integer heightInCm,

        @Column(name = "weight_in_kg")
        Integer weightInKg,

        @Column(name = "birth_date")
        LocalDate birthDate,

        @ManyToOne
        @JoinColumn(name = "country_code")
        Country country,

        @Column(name = "wins")
        Integer wins,

        @Column(name = "losses")
        Integer losses

) {}
