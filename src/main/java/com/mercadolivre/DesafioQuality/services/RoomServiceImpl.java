package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.requests.RoomRequest;
import com.mercadolivre.DesafioQuality.responses.RoomSizeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Override
    public Double getRoomSize(RoomRequest roomRequest){
        return roomRequest.getRoomWidth() * roomRequest.getRoomLength();
    }

    @Override
    public List<RoomSizeResponse> getAllRoomsSize(List<RoomRequest> rooms){
        List<RoomSizeResponse> roomsList = new ArrayList<>();
        for (RoomRequest room: rooms) {
            roomsList.add(new RoomSizeResponse(room.getRoomName(), this.getRoomSize(room)));
        }
        return roomsList;
    }
}
