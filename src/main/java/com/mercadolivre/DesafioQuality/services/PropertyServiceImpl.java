package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.requests.PropertyRequest;
import com.mercadolivre.DesafioQuality.requests.RoomRequest;
import com.mercadolivre.DesafioQuality.responses.PropertyResponse;
import com.mercadolivre.DesafioQuality.responses.RoomResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final RoomService roomService;
    private final DistrictService districtService;

    @Override
    public PropertyResponse getPropertyInfo(PropertyRequest propertyRequest) {
        List<RoomRequest> rooms = propertyRequest.getRooms();
        Double propSize = this.getPropertySize(rooms);
        Double districtValue = this.districtService.findByDistrictName(propertyRequest.getPropDistrict());
        return new PropertyResponse(propertyRequest,
                                    this.roomService.getAllRoomsResponse(rooms),
                                    districtValue,
                                    propSize,
                                    this.getPropertyValue(districtValue, propSize),
                                    this.roomService.getMaxRoom(rooms));
    }

    @Override
    public Double getPropertyValue(Double districtValue, Double propSize) { return districtValue * propSize; }

    @Override
    public Double getPropertySize(List<RoomRequest> rooms) {
        return this.roomService.getAllRoomsResponse(rooms).stream().map(RoomResponse::getRoomSize)
                                                                   .reduce(0.0, Double::sum);
    }
}
