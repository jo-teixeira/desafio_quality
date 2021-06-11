package com.mercadolivre.DesafioQuality.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolivre.DesafioQuality.requests.PropertyRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Data
public class PropertyResponse {
    @JsonProperty(value = "prop_name")
    private String propName;
    @JsonProperty(value = "rooms")
    private List<RoomResponse> rooms;
    @JsonProperty(value = "prop_district")
    private String propDistrict;
    @JsonProperty(value = "district_value")
    private Double districtValue;
    @JsonProperty(value = "prop_size")
    private Double propSize;
    @JsonProperty(value = "prop_value")
    private Double propValue;
    @JsonProperty(value = "max_room_name")
    private String maxRoomName;
    @JsonProperty(value = "max_room_size")
    private Double maxRoomSize;

    public PropertyResponse(PropertyRequest propertyRequest, List<RoomResponse> roomResponse, Double districtValue,
                            Double propSize, Double propValue, RoomResponse maxRoomResponse) {
        this.propName = propertyRequest.getPropName();
        this.rooms = roomResponse;
        this.propDistrict = propertyRequest.getPropDistrict();
        this.districtValue = districtValue;
        this.propSize = propSize;
        this.propValue = propValue;
        this.maxRoomName = maxRoomResponse.getRoomName();
        this.maxRoomSize = maxRoomResponse.getRoomSize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropertyResponse)) return false;
        PropertyResponse that = (PropertyResponse) o;
        return propName.equals(that.propName) && rooms.equals(that.rooms) && propDistrict.equals(that.propDistrict)
                && districtValue.equals(that.districtValue) && propSize.equals(that.propSize)
                && propValue.equals(that.propValue) && maxRoomName.equals(that.maxRoomName)
                && maxRoomSize.equals(that.maxRoomSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propName, rooms, propDistrict, districtValue, propSize, propValue, maxRoomName, maxRoomSize);
    }
}