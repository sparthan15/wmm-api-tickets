package com.wmm.tickets.infrastructure.adapters.input.rest;

import com.wmm.tickets.infrastructure.adapter.TicketsApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import util.TestUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static util.TestUtil.USER_ID_TEST;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes =
        TicketsApplication.class)
@AutoConfigureMockMvc
public class TicketEndpointTest  {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private String apiUri = "/tickets";



    @Test
    void  incomesTicket() throws Exception {
         mockMvc.perform(post(apiUri+"/incomes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"userId\":\""+ USER_ID_TEST +"\"\n" +
                                "}")
                ).andExpect(status().isOk());
    }

    @Test
    void  incomesTicketRequestWithOutStartDateReturnBadRequest() throws Exception {
        mockMvc.perform(post(apiUri+"/incomes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"userId\":\""+ USER_ID_TEST +"\"\n" +
                        "}")
        ).andExpect(status().isBadRequest());
    }



}
