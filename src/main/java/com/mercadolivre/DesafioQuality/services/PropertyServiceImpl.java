package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.exceptions.StandardError;
import com.mercadolivre.DesafioQuality.exceptions.ValidationError;
import com.mercadolivre.DesafioQuality.repositories.DistrictRepository;
import com.mercadolivre.DesafioQuality.requests.PropertyRequest;
import com.mercadolivre.DesafioQuality.requests.RoomRequest;
import com.mercadolivre.DesafioQuality.responses.PropertyMaxRoomResponse;
import com.mercadolivre.DesafioQuality.responses.PropertyRoomSizeResponse;
import com.mercadolivre.DesafioQuality.responses.PropertySizeResponse;
import com.mercadolivre.DesafioQuality.responses.PropertyValueResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final RoomService roomService;

    @Override
    public PropertySizeResponse getPropertySize(PropertyRequest propertyRequest){
        validateDistrict(propertyRequest.getPropDistrict());
        return new PropertySizeResponse(propertyRequest.getPropName(),
                                        this.calculatePropSize(propertyRequest.getRooms()));
    }

    @Override
    public PropertyValueResponse getPropertyValue(PropertyRequest propertyRequest) {
        validateDistrict(propertyRequest.getPropDistrict());
        Double prop_size = this.calculatePropSize(propertyRequest.getRooms());
        String district_name = propertyRequest.getPropDistrict();
        Double district_value = DistrictRepository.DISTRICT_VALUES.get(district_name);
        return new PropertyValueResponse(propertyRequest.getPropName(), district_name, district_value,
                                         prop_size, prop_size * district_value);
    }

    @Override
    public PropertyMaxRoomResponse getMaxRoomProperty(PropertyRequest propertyRequest){
        validateDistrict(propertyRequest.getPropDistrict());
        RoomRequest maxRoom = Collections.max(propertyRequest.getRooms(),
                Comparator.comparing(this.roomService::getRoomSize));
        return new PropertyMaxRoomResponse(propertyRequest.getPropName(),
                maxRoom.getRoomName(), this.roomService.getRoomSize(maxRoom));
    }

    @Override
    public PropertyRoomSizeResponse getRoomsSizeProperty(PropertyRequest propertyRequest){
        validateDistrict(propertyRequest.getPropDistrict());
        return new PropertyRoomSizeResponse(propertyRequest.getPropName(),
                                            this.roomService.getAllRoomsSize(propertyRequest.getRooms()));
    }

    private Double calculatePropSize(List<RoomRequest> roomList){
        return roomList.stream().map(this.roomService::getRoomSize).mapToDouble(Double::doubleValue).sum();
    }

    private void validateDistrict(String district){
        if(DistrictRepository.DISTRICT_VALUES.containsKey(district)){
            throw new StandardError(404, "erro", System.currentTimeMillis(), "");
        }
    }
}
