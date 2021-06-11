package com.mercadolivre.DesafioQuality.unit;

import com.mercadolivre.DesafioQuality.exceptions.DistrictNotFoundException;
import com.mercadolivre.DesafioQuality.repositories.DistrictRepository;
import com.mercadolivre.DesafioQuality.requests.PropertyRequest;
import com.mercadolivre.DesafioQuality.requests.RoomRequest;
import com.mercadolivre.DesafioQuality.responses.RoomResponse;
import com.mercadolivre.DesafioQuality.services.DistrictService;
import com.mercadolivre.DesafioQuality.services.DistrictServiceImpl;
import com.mercadolivre.DesafioQuality.services.PropertyServiceImpl;
import com.mercadolivre.DesafioQuality.services.RoomServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    private RoomServiceImpl roomService;
    @InjectMocks
    private PropertyServiceImpl propertyService;
    private final PropertyRequest propertyRequest = new PropertyRequest();

    @BeforeEach
    void setUp() {
        propertyRequest.setPropDistrict("Caravelas");
        propertyRequest.setPropName("Casa do Joao");
        propertyRequest.setRooms(Arrays.asList(new RoomRequest("RoomA", 25.0, 2.0),
                                               new RoomRequest("RoomB", 5.0, 10.0),
                                               new RoomRequest("RoomC", 2.0, 2.0)));
    }

    @Test
    void checkIfPropertySizeIsCorrectTest(){
        List<RoomResponse> roomsList = Arrays.asList(new RoomResponse("RoomA", 20.0),
                                                     new RoomResponse("roomB", 60.0),
                                                     new RoomResponse("roomC", 35.0));
        when(this.roomService.getAllRoomsResponse(any())).thenReturn(roomsList);

        Double valueToTest = this.propertyService.getPropertySize(this.propertyRequest.getRooms());

        assertEquals(115.0, valueToTest);
    }
}
