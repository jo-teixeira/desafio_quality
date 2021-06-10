package com.mercadolivre.DesafioQuality.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PropertyRequest {
    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @Pattern(regexp = "^\\p{Lu}.*$", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    @JsonProperty(value = "prop_name")
    private String propName;

    @NotBlank(message = "O bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    @JsonProperty(value = "prop_district")
    private String propDistrict;

    @Valid
    private List<RoomRequest> rooms;
}
