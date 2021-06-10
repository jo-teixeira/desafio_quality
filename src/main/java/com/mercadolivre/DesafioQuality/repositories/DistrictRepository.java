package com.mercadolivre.DesafioQuality.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Data
public class DistrictRepository {
    public static final Map<String, Double> DISTRICT_VALUES;
    static {
        DISTRICT_VALUES = new HashMap<>();
        DISTRICT_VALUES.put("Bom Retiro", 40.0);
        DISTRICT_VALUES.put("Caravelas", 5.0);
        DISTRICT_VALUES.put("Cariru", 65.0);
        DISTRICT_VALUES.put("Castelo", 100.0);
        DISTRICT_VALUES.put("Imbaubas", 75.0);
    }
}
