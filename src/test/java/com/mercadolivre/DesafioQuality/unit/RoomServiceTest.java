package com.mercadolivre.DesafioQuality.unit;

import com.mercadolivre.DesafioQuality.requests.RoomRequest;
import com.mercadolivre.DesafioQuality.responses.RoomResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mercadolivre.DesafioQuality.services.RoomService;
import com.mercadolivre.DesafioQuality.services.RoomServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

    private final RoomService roomService = new RoomServiceImpl();
    private final List<RoomRequest> roomsList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        this.roomsList.add(new RoomRequest("RoomA", 25.0, 2.0));
        this.roomsList.add(new RoomRequest("RoomB", 6.0, 10.0));
        this.roomsList.add(new RoomRequest("RoomC", 2.0, 2.0));
    }

    @Test
    void checkGetMaxRoomTest() {
        RoomResponse roomResponse = this.roomService.getMaxRoom(this.roomsList);

        assertEquals(60.0, roomResponse.getRoomSize());
    }

    @Test
    void checkAllRoomsSize() {
        List<RoomResponse> roomResponse = this.roomService.getAllRoomsResponse(this.roomsList);

        Double roomsSize = roomResponse.stream().map(RoomResponse::getRoomSize).reduce(0.0, Double::sum);

        assertEquals(114.0, roomsSize);
    }

}
