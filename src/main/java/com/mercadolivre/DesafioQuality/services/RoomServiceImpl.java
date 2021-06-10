package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.requests.RoomRequest;
import com.mercadolivre.DesafioQuality.responses.RoomSizeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService{
    @Override
    public Double getRoomSize(RoomRequest roomRequest){
        return roomRequest.getRoomWidth() * roomRequest.getRoomLength();
    }

    @Override
    public List<RoomSizeResponse> getAllRoomsSize(List<RoomRequest> rooms){
        return rooms.stream().map(room -> new RoomSizeResponse(room.getRoomName(),
                                  this.getRoomSize(room))).collect(Collectors.toList());
    }
}
