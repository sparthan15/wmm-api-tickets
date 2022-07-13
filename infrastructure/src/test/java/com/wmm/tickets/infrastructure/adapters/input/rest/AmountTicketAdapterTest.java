package com.wmm.tickets.infrastructure.adapters.input.rest;

import com.wmm.tickets.domain.exception.IncompleteRequestDataException;
import com.wmm.tickets.application.usecases.TicketsUseCase;
import com.wmm.tickets.domain.request.TicketRequest;
import com.wmm.tickets.infrastructure.adapter.input.rest.AmountTicketInputAdapter;
import com.wmm.tickets.infrastructure.adapter.input.rest.model.request.InputTicketRequest;
import com.wmm.tickets.infrastructure.adapter.input.rest.model.response.TicketResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static util.TestUtil.*;

@ExtendWith(MockitoExtension.class)
public class AmountTicketAdapterTest {

    @Mock
    private TicketsUseCase amountTicketsUseCase;
    private AmountTicketInputAdapter amountTicketAdapter;
    private TicketRequest ticketRequest = TICKET_REQUEST.mapRequestToModel();

    private void setUp() {
        amountTicketAdapter = new AmountTicketInputAdapter(amountTicketsUseCase);
    }

    @Test
    public void incomesByUserAndDatesTest() {
        InputTicketRequest inputTicketRequest = new InputTicketRequest(ticketRequest.getUserId(),
                ticketRequest.getStartDate(), ticketRequest.getEndDate());
        when(amountTicketsUseCase.incomesAmount(inputTicketRequest.mapRequestToModel())).thenReturn(BigDecimal.TEN);
        setUp();
        TicketResponse response = amountTicketAdapter.incomesAmount(inputTicketRequest);
        assertThat(response.getAmount()).isEqualTo(BigDecimal.TEN.toString());
    }

    @Test
    public void givenABadTicketRequestThenAnExceptionIsThrown() {
        assertThatThrownBy(() -> {
            setUp();
            TicketResponse response = amountTicketAdapter.incomesAmount(new InputTicketRequest(null,
                    LocalDateTime.now(), LocalDateTime.now()));
        }).isInstanceOf(IncompleteRequestDataException.class);

    }

    @Test
    public void outcomesByUserAndDatesTest() {
        InputTicketRequest inputTicketRequest = new InputTicketRequest(ticketRequest.getUserId(),
                ticketRequest.getStartDate(), ticketRequest.getEndDate());
        when(amountTicketsUseCase.outcomesAmount(inputTicketRequest.mapRequestToModel())).thenReturn(BigDecimal.TEN);
        setUp();
        TicketResponse response = amountTicketAdapter.outcomesAmount(inputTicketRequest);
        assertThat(response.getAmount()).isEqualTo(BigDecimal.TEN.toString());
    }

}
