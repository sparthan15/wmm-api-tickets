package com.wmm.tickets.domain;

import com.wmm.tickets.domain.request.TicketRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketRequestTest {

    @Test
    public void test(){
        TicketRequest ticketRequest = TicketRequest.builder()
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .userId("123FFF")
                .build();
        assertThat(ticketRequest.getUserId()).isNotNull();
        assertThat(ticketRequest.getStartDate()).isNotNull();
        assertThat(ticketRequest.getEndDate()).isNotNull();
    }
}
