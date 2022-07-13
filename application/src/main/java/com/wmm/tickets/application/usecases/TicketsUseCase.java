package com.wmm.tickets.application.usecases;

import com.wmm.tickets.domain.entities.Ticket;
import com.wmm.tickets.domain.request.TicketRequest;

import java.math.BigDecimal;

public interface TicketsUseCase {
    BigDecimal incomesAmount(TicketRequest ticket);

    BigDecimal outcomesAmount(TicketRequest ticket);
}
