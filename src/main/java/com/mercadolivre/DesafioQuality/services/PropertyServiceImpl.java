package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.repositories.DistrictRepository;
import com.mercadolivre.DesafioQuality.requests.PropertyRequest;
import com.mercadolivre.DesafioQuality.requests.RoomRequest;
import com.mercadolivre.DesafioQuality.responses.PropertyMaxRoomResponse;
import com.mercadolivre.DesafioQuality.responses.PropertyRoomSizeResponse;
import com.mercadolivre.DesafioQuality.responses.PropertySizeResponse;
import com.mercadolivre.DesafioQuality.responses.PropertyValueResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final RoomService roomService;

    @Override
    public PropertySizeResponse getPropertySize(PropertyRequest propertyRequest){
        return new PropertySizeResponse(propertyRequest.getPropName(),
                                        this.calculatePropSize(propertyRequest.getRooms()));
    }

    @Override
    public PropertyValueResponse getPropertyValue(PropertyRequest propertyRequest) {
        DistrictRepository.findById(propertyRequest.getPropDistrict());
        Double propSize = this.calculatePropSize(propertyRequest.getRooms());
        String districtName = propertyRequest.getPropDistrict();
        Double districtValue = DistrictRepository.DISTRICT_VALUES.get(districtName);
        return new PropertyValueResponse(propertyRequest.getPropName(), districtName, districtValue,
                propSize, propSize * districtValue);
    }

    @Override
    public PropertyMaxRoomResponse getMaxRoomProperty(PropertyRequest propertyRequest){
        RoomRequest maxRoom = Collections.max(propertyRequest.getRooms(),
                Comparator.comparing(this.roomService::getRoomSize));
        return new PropertyMaxRoomResponse(propertyRequest.getPropName(),
                maxRoom.getRoomName(), this.roomService.getRoomSize(maxRoom));
    }

    @Override
    public PropertyRoomSizeResponse getRoomsSizeProperty(PropertyRequest propertyRequest){
        return new PropertyRoomSizeResponse(propertyRequest.getPropName(),
                                            this.roomService.getAllRoomsSize(propertyRequest.getRooms()));
    }

    private Double calculatePropSize(List<RoomRequest> roomList){
        return roomList.stream().map(this.roomService::getRoomSize).mapToDouble(Double::doubleValue).sum();
    }
}
