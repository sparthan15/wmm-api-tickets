package com.wmm.tickets.infrastructure.adapters.input.rest;

import com.wmm.tickets.infrastructure.adapter.TicketsApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static util.TestUtil.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes =
        TicketsApplication.class)
@AutoConfigureMockMvc
public class TicketEndpointTest  {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private String apiUri = "/tickets";



    @Test
    void  incomesTicketWithWellFormedPayloaWorksGood() throws Exception {
         mockMvc.perform(post(apiUri+"/incomes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"userId\":1,\n" +
                                "    \"startDate\":\"2022-07-21T00:00\",\n" +
                                "    \"endDate\":\"2022-07-21T00:00:00\"\n" +
                                "}")
                ).andExpect(status().isOk()).andExpect(content()
                 .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void  incomesTicketRequestWithOutStartDateReturnBadRequest() throws Exception {
        mockMvc.perform(post(apiUri+"/incomes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"userId\":\""+ USER_ID_TEST +"\"\n" +
                        "    \"startDate\":\"asdasd\"\n" +
                        "    \"endDate\":\""+ END_DATE +"\"\n" +
                        "}")
        ).andExpect(status().isBadRequest());
    }

    @Test
    void  incomesTicketRequestWithOutEndDateReturnBadRequest() throws Exception {
        mockMvc.perform(post(apiUri+"/incomes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"userId\":\""+ USER_ID_TEST +"\"\n" +
                        "    \"startDate\":\""+START_DATE+"\"\n" +
                        "    \"endDate\":\"asdadas\"\n" +
                        "}")
        ).andExpect(status().isBadRequest());
    }

    @Test
    void  outcomesTicketWithWellFormedPayLoadWorksGood() throws Exception {
        mockMvc.perform(post(apiUri+"/outcomes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"userId\":1,\n" +
                        "    \"startDate\":\"2022-07-21T00:00\",\n" +
                        "    \"endDate\":\"2022-07-21T00:00:00\"\n" +
                        "}")
        ).andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }


    @Test
    void  outcomesTicketRequestWithOutStartDateReturnBadRequest() throws Exception {
        mockMvc.perform(post(apiUri+"/incomes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"userId\":\""+ USER_ID_TEST +"\"\n" +
                        "    \"startDate\":\"asdasd\"\n" +
                        "    \"endDate\":\""+ END_DATE +"\"\n" +
                        "}")
        ).andExpect(status().isBadRequest());
    }

    @Test
    void  outcomesTicketRequestWithOutEndDateReturnBadRequest() throws Exception {
        mockMvc.perform(post(apiUri+"/incomes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"userId\":\""+ USER_ID_TEST +"\"\n" +
                        "    \"startDate\":\""+START_DATE+"\"\n" +
                        "    \"endDate\":\"asdadas\"\n" +
                        "}")
        ).andExpect(status().isBadRequest());
    }

}
