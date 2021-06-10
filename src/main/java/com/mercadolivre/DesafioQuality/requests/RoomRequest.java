package com.mercadolivre.DesafioQuality.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@AllArgsConstructor
@Data
public class RoomRequest {
    @NotBlank(message = "O campo não pode estar vazio.")
    @Pattern(regexp = "^\\p{Lu}.*$", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    @JsonProperty(value = "room_name")
    private String roomName;

    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @DecimalMax(value = "25.0", message = "A largura máxima permitida por cômodo é de 25 metros.")
    @DecimalMin(value = "1", message = "A largura mínima permitida por cômodo é de 1 metro.")
    @JsonProperty(value = "room_width")
    private Double roomWidth;

    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @DecimalMax(value = "33", message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    @DecimalMin(value = "1", message = "O comprimento mínimo permitido por cômodo é de 1 metro.")
    @JsonProperty(value = "room_length")
    private Double roomLength;
}
