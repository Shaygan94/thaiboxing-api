package com.thaiboxing.thaiboxingapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "thaiboxing_club")

public record ThaiboxingClub(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "club_id")
        Integer clubId,

        @Column(name= "club_name")
        String clubName,

        @Column(name= "address")
        String address,

        @Column(name= "email")
        String email,

        @Column(name= "phone")
        String phone,

        @Column(name= "established_year")
        Integer establishedYear,

        @Column(name= "owner")
        String owner
) {}
