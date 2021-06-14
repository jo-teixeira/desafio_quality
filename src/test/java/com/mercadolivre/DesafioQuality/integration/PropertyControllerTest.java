package com.mercadolivre.DesafioQuality.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void checkAllCalculatedAttributesInResponse() throws Exception {
        String request = "{\n" +
                "    \"prop_name\": \"Casa do joao\",\n" +
                "    \"prop_district\": \"Caravelas\",\n" +
                "    \"rooms\": [\n" +
                "        {\n" +
                "            \"room_name\": \"Room1\",\n" +
                "            \"room_width\": 23,\n" +
                "            \"room_length\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_name\": \"Room2\",\n" +
                "            \"room_width\": 2,\n" +
                "            \"room_length\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_name\": \"Room3\",\n" +
                "            \"room_width\": 3,\n" +
                "            \"room_length\": 10\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        String responseExpected = "{\n" +
                "    \"prop_name\": \"Casa do joao\",\n" +
                "    \"rooms\": [\n" +
                "        {\n" +
                "            \"room_name\": \"Room1\",\n" +
                "            \"room_size\": 230.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_name\": \"Room2\",\n" +
                "            \"room_size\": 20.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_name\": \"Room3\",\n" +
                "            \"room_size\": 30.0\n" +
                "        }\n" +
                "    ],\n" +
                "    \"prop_district\": \"Caravelas\",\n" +
                "    \"district_value\": 5.0,\n" +
                "    \"prop_size\": 280.0,\n" +
                "    \"prop_value\": 1400.0,\n" +
                "    \"max_room_name\": \"Room1\",\n" +
                "    \"max_room_size\": 230.0\n" +
                "}";
        this.mockMvc.perform(
                post("/property/info")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(responseExpected));

    }

    @Test
    void shouldThrowAllValidationErrorsInResponse() throws Exception {
        String request = "{\n" +
                "    \"prop_name\": \"Propriedade com tamanho muito grandeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee\",\n" +
                "    \"prop_district\": \"Caravelas\",\n" +
                "    \"rooms\": [\n" +
                "        {\n" +
                "            \"room_name\": \"quarto com nome minusculo\",\n" +
                "            \"room_width\": 1,\n" +
                "            \"room_length\": 15\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_name\": \"Quarto tamanho muito grande\",\n" +
                "            \"room_width\": 100000000,\n" +
                "            \"room_length\": 25\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_name\": \"Quarto com tamanho nulo\",\n" +
                "            \"room_width\": null,\n" +
                "            \"room_length\": 10\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        String responseExpected = "{\n" +
                "    \"status\": 400,\n" +
                "    \"message\": \"Validation error\",\n" +
                "    \"path\": \"/property/info\",\n" +
                "    \"errors\": [\n" +
                "        {\n" +
                "            \"fieldName\": \"rooms[0].roomName\",\n" +
                "            \"message\": \"O nome do cômodo deve começar com uma letra maiúscula.\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldName\": \"rooms[1].roomWidth\",\n" +
                "            \"message\": \"A largura máxima permitida por cômodo é de 25 metros.\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldName\": \"propName\",\n" +
                "            \"message\": \"O comprimento do nome não pode exceder 30 caracteres.\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldName\": \"rooms[2].roomWidth\",\n" +
                "            \"message\": \"A largura do cômodo não pode estar vazia.\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        this.mockMvc.perform(
                post("/property/info")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().json(responseExpected));

    }

    @Test
    void shouldThrowDistrictNotFoundExceptionInResponse() throws Exception {
        String request = "{\n" +
                "    \"prop_name\": \"Casa do joao\",\n" +
                "    \"prop_district\": \"QUENAOEXISTE\",\n" +
                "    \"rooms\": [\n" +
                "        {\n" +
                "            \"room_name\": \"Room1\",\n" +
                "            \"room_width\": 22,\n" +
                "            \"room_length\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_name\": \"Room2\",\n" +
                "            \"room_width\": 2,\n" +
                "            \"room_length\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_name\": \"Rroom3\",\n" +
                "            \"room_width\": 3,\n" +
                "            \"room_length\": 10\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        String responseExpected = "{\n" +
                "    \"status\": 404,\n" +
                "    \"message\": \"Bairro QUENAOEXISTE não encontrado.\",\n" +
                "    \"path\": \"/property/info\",\n" +
                "    \"errors\": []\n" +
                "}";
        this.mockMvc.perform(
                post("/property/info")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().json(responseExpected));

    }
}
