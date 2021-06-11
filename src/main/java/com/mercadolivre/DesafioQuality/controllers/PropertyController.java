package com.mercadolivre.DesafioQuality.controllers;

import com.mercadolivre.DesafioQuality.responses.PropertyResponse;
import com.mercadolivre.DesafioQuality.services.PropertyService;
import com.mercadolivre.DesafioQuality.requests.PropertyRequest;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/property")
@Api(tags = "Gerenciador de casas",
        description = "Gerenciar casas e seus respectivos quartos.")
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping("/info")
    public ResponseEntity<PropertyResponse> getPropertyInfo(@RequestBody @Valid PropertyRequest propertyRequest){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getPropertyInfo(propertyRequest));
    }
}
