package com.mercadolivre.DesafioQuality.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Data
@Repository
public class DistrictRepository {
    public static final Map<String, Double> DISTRICT_VALUES = new HashMap<>();
    static {
        DISTRICT_VALUES.put("Bom Retiro", 40.0);
        DISTRICT_VALUES.put("Caravelas", 5.0);
        DISTRICT_VALUES.put("Cariru", 65.0);
        DISTRICT_VALUES.put("Castelo", 100.0);
        DISTRICT_VALUES.put("Imbaubas", 75.0);
    }

    public Optional<Double> findByName(String district){
        return Optional.of(DistrictRepository.DISTRICT_VALUES.get(district));
    }
}
