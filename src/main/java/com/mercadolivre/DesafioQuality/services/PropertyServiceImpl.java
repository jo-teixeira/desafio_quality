package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.repositories.DistrictRepository;
import com.mercadolivre.DesafioQuality.requests.PropertyRequest;
import com.mercadolivre.DesafioQuality.responses.PropertyResponse;
import com.mercadolivre.DesafioQuality.responses.RoomResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final RoomService roomService;

    @Override
    public PropertyResponse getPropertyInfo(PropertyRequest propertyRequest) {
        RoomResponse maxRoom = this.getMaxRoomProperty(propertyRequest);
        return new PropertyResponse(propertyRequest.getPropName(),
                this.getRoomsResponseProperty(propertyRequest),
                propertyRequest.getPropDistrict(),
                DistrictRepository.DISTRICT_VALUES.get(propertyRequest.getPropDistrict()),
                this.getPropertySize(propertyRequest),
                this.getPropertyValue(propertyRequest, this.getPropertySize(propertyRequest)),
                maxRoom.getRoomName(),
                maxRoom.getRoomSize());
    }

    @Override
    public Double getPropertyValue(PropertyRequest propertyRequest, Double propSize) {
        return DistrictRepository.findById(propertyRequest.getPropDistrict()) * propSize;
    }

    @Override
    public RoomResponse getMaxRoomProperty(PropertyRequest propertyRequest) {
        return this.roomService.getMaxRoom(propertyRequest.getRooms());
    }

    @Override
    public List<RoomResponse> getRoomsResponseProperty(PropertyRequest propertyRequest) {
        return this.roomService.getAllRoomsResponse(propertyRequest.getRooms());
    }

    @Override
    public Double getPropertySize(PropertyRequest propertyRequest) {
        return this.roomService.getAllRoomsResponse(propertyRequest.getRooms()).stream()
                                                                               .map(RoomResponse::getRoomSize)
                                                                               .reduce(0.0, Double::sum);
    }
}
