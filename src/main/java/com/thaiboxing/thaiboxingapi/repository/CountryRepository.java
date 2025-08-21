package com.thaiboxing.thaiboxingapi.repository;

import com.thaiboxing.thaiboxingapi.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
