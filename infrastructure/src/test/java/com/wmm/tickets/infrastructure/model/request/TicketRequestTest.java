package com.wmm.tickets.infrastructure.model.request;

import com.wmm.domain.IncompleteRequestDataException;
import com.wmm.tickets.domain.entities.Ticket;
import com.wmm.tickets.infrastructure.adapter.input.rest.model.request.TicketRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static util.TestUtil.*;

public class TicketRequestTest {

    @Test
    public void test() {
        TicketRequest ticketRequest = new TicketRequest("123KASD", START_DATE, END_DATE);
        Assertions.assertThat(ticketRequest.getUserId()).isNotNull();
    }

    @Test
    public void ticketRequestCanBeConvertedToModel() {
        TicketRequest ticketRequest = new TicketRequest("123KASD", START_DATE, END_DATE);
        Ticket ticket = ticketRequest.toModel();
        Assertions.assertThat(ticketRequest.toModel().getUserId()).isNotNull();
    }


    @Test
    public void givenATicketRequestHasNoStartDateThenAnsExceptionIsThrwn() {
        Assertions.assertThatThrownBy(() -> {
            new TicketRequest(USER_ID_TEST, null,
                    LocalDateTime.now());
        }).isInstanceOf(IncompleteRequestDataException.class);
    }

    @Test
    public void givenATicketRequestHasNoEndDateThenAnsExceptionIsThrwn() {
        Assertions.assertThatThrownBy(() -> {
            new TicketRequest(USER_ID_TEST, LocalDateTime.now(), null);
        }).isInstanceOf(IncompleteRequestDataException.class);
    }

    @Test
    public void givenATicketRequestHasNoUseridThenAnsExceptionIsThrwn() {
        Assertions.assertThatThrownBy(() -> {
            new TicketRequest(null, LocalDateTime.now(),
                    LocalDateTime.now());
        }).isInstanceOf(IncompleteRequestDataException.class);
    }
}
