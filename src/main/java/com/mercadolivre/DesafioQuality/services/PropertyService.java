package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.requests.PropertyRequest;
import com.mercadolivre.DesafioQuality.requests.RoomRequest;
import com.mercadolivre.DesafioQuality.responses.PropertyResponse;

import java.util.List;

public interface PropertyService {
    PropertyResponse getPropertyInfo(PropertyRequest propertyRequest);

    /* estes metodos deveriam ser privados, mas para testa-los, setei como publico */
    Double getPropertyValue(Double districtValue, Double propSize);
    Double getPropertySize(List<RoomRequest> rooms);
}
