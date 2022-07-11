package com.wmm.tickets.application.usecases;

import com.wmm.tickets.domain.entities.Ticket;

import java.time.LocalDateTime;

public interface TicketsUseCase {
    Ticket incomes(Ticket ticket);

    Ticket outcomes(Ticket ticket);
}
