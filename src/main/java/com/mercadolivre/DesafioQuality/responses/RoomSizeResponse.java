package com.mercadolivre.DesafioQuality.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RoomSizeResponse {
    @JsonProperty(value = "room_name")
    private String roomName;
    @JsonProperty(value = "room_size")
    private Double roomSize;
}
