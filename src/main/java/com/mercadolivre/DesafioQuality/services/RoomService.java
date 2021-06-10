package com.mercadolivre.DesafioQuality.services;

import com.mercadolivre.DesafioQuality.requests.RoomRequest;
import com.mercadolivre.DesafioQuality.responses.RoomSizeResponse;

import java.util.List;

public interface RoomService {
    Double getRoomSize(RoomRequest roomRequest);
    List<RoomSizeResponse> getAllRoomsSize(List<RoomRequest> rooms);
}
