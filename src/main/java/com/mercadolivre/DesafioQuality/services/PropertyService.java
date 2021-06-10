package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.requests.PropertyRequest;
import com.mercadolivre.DesafioQuality.responses.PropertyMaxRoomResponse;
import com.mercadolivre.DesafioQuality.responses.PropertyRoomSizeResponse;
import com.mercadolivre.DesafioQuality.responses.PropertySizeResponse;
import com.mercadolivre.DesafioQuality.responses.PropertyValueResponse;

public interface PropertyService {
    PropertySizeResponse getPropertySize(PropertyRequest propertyRequest);
    PropertyValueResponse getPropertyValue(PropertyRequest propertyRequest);
    PropertyMaxRoomResponse getMaxRoomProperty(PropertyRequest propertyRequest);
    PropertyRoomSizeResponse getRoomsSizeProperty(PropertyRequest propertyRequest);
}
