package com.wmm.tickets.infrastructure.model.request.response;

import com.wmm.tickets.infrastructure.adapter.input.rest.model.response.TicketResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketResponseTesst {

    @Test
    public void test() {
        TicketResponse ticketResponse = new TicketResponse("20.2");
        Assertions.assertThat(ticketResponse).isNotNull();
    }
}
