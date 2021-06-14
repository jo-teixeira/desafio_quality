package com.mercadolivre.DesafioQuality.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Data
@Repository
public class DistrictRepository {
    private final Map<String,Double> districts = Map.ofEntries(
            Map.entry("Bom Retiro", 40.0),
            Map.entry("Caravelas", 5.0),
            Map.entry("Cariru", 65.0),
            Map.entry("Castelo", 100.0),
            Map.entry("Imbaubas", 75.0)
    );

    public Optional<Double> findByName(String district){
        return Optional.ofNullable(this.getDistricts().get(district));
    }
}
