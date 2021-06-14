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
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

    private final RoomService roomService = new RoomServiceImpl();
    private final List<RoomRequest> roomsRequestList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        this.roomsRequestList.add(new RoomRequest("RoomA", 25.0, 2.0));
        this.roomsRequestList.add(new RoomRequest("RoomB", 6.0, 10.0));
        this.roomsRequestList.add(new RoomRequest("RoomC", 2.0, 2.0));
    }

    @Test
    void shouldReturnTheMaxRoomSizeInRoomsSizeList() {
         RoomResponse roomResponse = this.roomService.getMaxRoom(roomsRequestList);

        assertEquals(60.0, roomResponse.getRoomSize());
    }

    @Test
    void shouldReturnTheSumOfRoomsSizeList() {
        List<RoomResponse> roomsResponseListExpected = Arrays.asList(new RoomResponse("RoomA", 50.0),
                                                                     new RoomResponse("RoomB", 60.0),
                                                                     new RoomResponse("RoomC", 4.0));

        List<RoomResponse> responseListToTest = this.roomService.getAllRoomsResponse(this.roomsRequestList);

        assertEquals(roomsResponseListExpected, responseListToTest);
    }

}
