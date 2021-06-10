package com.mercadolivre.DesafioQuality.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Data
public class PropertyRoomSizeResponse {
    @JsonProperty(value = "prop_name")
    private String propName;
    @JsonProperty(value = "rooms")
    private List<RoomSizeResponse> rooms;
}
