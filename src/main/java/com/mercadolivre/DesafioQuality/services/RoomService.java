package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.requests.RoomRequest;
import com.mercadolivre.DesafioQuality.responses.RoomResponse;

import java.util.List;

public interface RoomService {
    Double getRoomSize(RoomRequest roomRequest);
    List<RoomResponse> getAllRoomsResponse(List<RoomRequest> rooms);
    RoomResponse getMaxRoom(List<RoomRequest> rooms);
}
