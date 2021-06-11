package com.mercadolivre.DesafioQuality.integration;

import com.mercadolivre.DesafioQuality.controllers.PropertyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
    void checkIfPropertySizeIsCorrectTest() throws Exception {
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

//    @Test
//    void checkIfNameExistsTest() throws Exception {
//        String request = "{\n" +
//                "    \"prop_name\": \"Casa do joao\",\n" +
//                "    \"prop_district\": \"Caravelas\",\n" +
//                "    \"rooms\": [\n" +
//                "        {\n" +
//                "            \"room_name\": \"Room1\",\n" +
//                "            \"room_width\": 25,\n" +
//                "            \"room_length\": 2\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"room_name\": \"Room2\",\n" +
//                "            \"room_width\": 5,\n" +
//                "            \"room_length\": 10\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"room_name\": \"Room3\",\n" +
//                "            \"room_width\": 2,\n" +
//                "            \"room_length\": 2\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}" ;
//        this.mockMvc.perform(
//                post("/property/info")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(request))
//                .andDo(print()).andExpect(status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_name").exists());
//    }
}
