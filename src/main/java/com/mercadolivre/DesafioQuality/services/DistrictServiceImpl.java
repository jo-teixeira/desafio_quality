package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.exceptions.DistrictNotFoundException;
import com.mercadolivre.DesafioQuality.repositories.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DistrictServiceImpl implements DistrictService{

    private final DistrictRepository districtRepository;

    @Override
    public Double findByDistrictName(String districtName){
        return this.districtRepository.findByName(districtName)
                .orElseThrow(() -> new DistrictNotFoundException("Bairro " + districtName + " não encontrado."));
    }
}
