package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.requests.RoomRequest;
import com.mercadolivre.DesafioQuality.responses.RoomResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService{
    @Override
    public Double getRoomSize(RoomRequest roomRequest) {
        return roomRequest.getRoomWidth() * roomRequest.getRoomLength();
    }

    @Override
    public List<RoomResponse> getAllRoomsResponse(List<RoomRequest> rooms) {
        return rooms.stream().map(room -> new RoomResponse(room.getRoomName(),
                                                           this.getRoomSize(room))).collect(Collectors.toList());
    }

    @Override
    public RoomResponse getMaxRoom(List<RoomRequest> rooms) {
        RoomRequest roomRequest = Collections.max(rooms, Comparator.comparing(this::getRoomSize));
        return new RoomResponse(roomRequest.getRoomName(), this.getRoomSize(roomRequest));
    }
}
