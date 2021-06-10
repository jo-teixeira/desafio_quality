package com.mercadolivre.DesafioQuality.controllers;

import com.mercadolivre.DesafioQuality.responses.PropertyMaxRoomResponse;
import com.mercadolivre.DesafioQuality.responses.PropertyRoomSizeResponse;
import com.mercadolivre.DesafioQuality.responses.PropertySizeResponse;
import com.mercadolivre.DesafioQuality.responses.PropertyValueResponse;
import com.mercadolivre.DesafioQuality.services.PropertyService;
import com.mercadolivre.DesafioQuality.requests.PropertyRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/property")
public class PropertyController {

    private final PropertyService propertyService;

    @GetMapping("/size")
    public ResponseEntity<PropertySizeResponse> getPropertySize(@RequestBody @Valid PropertyRequest propertyRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.getPropertySize(propertyRequest));
    }

    @GetMapping("/value")
    public ResponseEntity<PropertyValueResponse> getPropertyValue(@RequestBody @Valid PropertyRequest propertyRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.getPropertyValue(propertyRequest));
    }

    @GetMapping("/max_room")
    public ResponseEntity<PropertyMaxRoomResponse> getMaxRoomProperty(@RequestBody @Valid PropertyRequest propertyRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.getMaxRoomProperty(propertyRequest));
    }

    @GetMapping("/rooms_size")
    public ResponseEntity<PropertyRoomSizeResponse> getRoomsSizeProperty(@RequestBody @Valid PropertyRequest propertyRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.getRoomsSizeProperty(propertyRequest));
    }

}
