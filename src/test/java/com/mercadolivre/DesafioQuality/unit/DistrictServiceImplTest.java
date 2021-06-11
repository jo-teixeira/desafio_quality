package com.mercadolivre.DesafioQuality.unit;

import com.mercadolivre.DesafioQuality.exceptions.DistrictNotFoundException;
import com.mercadolivre.DesafioQuality.repositories.DistrictRepository;
import com.mercadolivre.DesafioQuality.services.DistrictServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DistrictServiceImplTest {
    @Mock
    private DistrictRepository districtRepository;
    @InjectMocks
    private DistrictServiceImpl districtService;

    @Test
    void checkIfDistrictNotExistsTest() {
        when(this.districtRepository.findByName(anyString())).thenReturn(Optional.empty());

        assertThrows(DistrictNotFoundException.class, () -> this.districtService.findByDistrictName("Nao existe"));
    }

    @Test
    void checkIfDistrictExistsTest() {
        when(this.districtRepository.findByName(anyString())).thenReturn(java.util.Optional.of(5.0));

        assertEquals(5.0, this.districtService.findByDistrictName("Caravelas"));
    }

}