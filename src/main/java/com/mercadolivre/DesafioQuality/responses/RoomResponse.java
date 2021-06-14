package com.mercadolivre.DesafioQuality.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RoomResponse {
    @JsonProperty(value = "room_name")
    private String roomName;
    @JsonProperty(value = "room_size")
    private Double roomSize;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomResponse)) return false;
        RoomResponse that = (RoomResponse) o;
        return roomName.equals(that.roomName) && roomSize.equals(that.roomSize);
    }
}
