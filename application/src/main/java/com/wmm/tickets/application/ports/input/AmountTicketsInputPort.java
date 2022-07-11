package com.wmm.tickets.application.ports.input;

import com.wmm.domain.vo.MovementType;
import com.wmm.tickets.application.ports.output.AmountTicketOutputPort;
import com.wmm.tickets.application.usecases.TicketsUseCase;
import com.wmm.tickets.domain.entities.Ticket;
import com.wmm.tickets.domain.entities.businessrules.TicketRequestValidation;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class AmountTicketsInputPort implements TicketsUseCase {

    private final AmountTicketOutputPort amountTicketOutputPort;

    @Override
    public Ticket incomes(Ticket ticket) {
        TicketRequestValidation.validate(ticket);
        return Ticket.builder()
                .userId(ticket.getUserId())
                .amount(amountTicketOutputPort.sumAmountByUserIdAndMovementTypeAndDateGreaterThanAndDateLessThan(ticket.getUserId(),
                        MovementType.CREDIT, ticket.getStartDate(), ticket.getEndDate())).build();
    }

    @Override
    public Ticket outcomes(Ticket ticket) {
        TicketRequestValidation.validate(ticket);
        return Ticket.builder()
                .userId(ticket.getUserId())
                .amount(amountTicketOutputPort.sumAmountByUserIdAndMovementTypeAndDateGreaterThanAndDateLessThan(ticket.getUserId(), MovementType.DEBIT, ticket.getStartDate(), ticket.getEndDate()))
                .build();
    }
}
