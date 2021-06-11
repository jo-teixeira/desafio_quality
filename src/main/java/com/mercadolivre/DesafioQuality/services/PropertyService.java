package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.requests.PropertyRequest;
import com.mercadolivre.DesafioQuality.responses.PropertyResponse;
import com.mercadolivre.DesafioQuality.responses.RoomResponse;

import java.util.List;

public interface PropertyService {
    PropertyResponse getPropertyInfo(PropertyRequest propertyRequest);

    /* estes metodos deveriam ser privados, mas para testa-los, setei como publico */
    Double getPropertyValue(PropertyRequest propertyRequest, Double propSize);
    RoomResponse getMaxRoomProperty(PropertyRequest propertyRequest);
    List<RoomResponse> getRoomsResponseProperty(PropertyRequest propertyRequest);
    Double getPropertySize(PropertyRequest propertyRequest);
}
