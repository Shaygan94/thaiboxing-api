package com.thaiboxing.thaiboxingapi.entity;

import jakarta.persistence.Embeddable;

@Embeddable //sammensatt primærnmøkkel
public record ClubCityId(
                String cityCode,
                Integer clubId
){}

