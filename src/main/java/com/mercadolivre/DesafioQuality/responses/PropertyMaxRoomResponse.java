package com.mercadolivre.DesafioQuality.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@AllArgsConstructor
@Data
public class PropertyMaxRoomResponse {
    @JsonProperty(value = "prop_name")
    private String propName;
    @JsonProperty(value = "room_name")
    private String roomName;
    @JsonProperty(value = "room_size")
    private Double roomSize;

    public static Comparator<PropertyMaxRoomResponse> PostInfoResponseNameComparator = new Comparator<PropertyMaxRoomResponse>() {
        public int compare(PropertyMaxRoomResponse roomA, PropertyMaxRoomResponse roomB) {
            return roomA.getRoomSize().compareTo(roomB.getRoomSize());
        }
    };
}