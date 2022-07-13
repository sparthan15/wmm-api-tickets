package com.wmm.tickets.application.ports.input;

import com.wmm.domain.vo.MovementType;
import com.wmm.tickets.application.ports.output.AmountTicketOutputPort;
import com.wmm.tickets.application.usecases.TicketsUseCase;
import com.wmm.tickets.domain.entities.Ticket;
import com.wmm.tickets.domain.businessrules.TicketRequestValidation;
import com.wmm.tickets.domain.request.TicketRequest;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class AmountTicketsInputPort implements TicketsUseCase {

    private final AmountTicketOutputPort amountTicketOutputPort;

    @Override
    public BigDecimal incomesAmount(TicketRequest ticketRequest) {
        TicketRequestValidation.validate(ticketRequest);
        return amountTicketOutputPort.sumAmountByUserIdAndMovementTypeAndDateGreaterThanAndDateLessThan(ticketRequest.getUserId(),
                MovementType.CREDIT,
                ticketRequest.getStartDate(),
                ticketRequest.getEndDate());
    }

    @Override
    public BigDecimal outcomesAmount(TicketRequest ticketRequest) {
        TicketRequestValidation.validate(ticketRequest);
        return amountTicketOutputPort.sumAmountByUserIdAndMovementTypeAndDateGreaterThanAndDateLessThan(ticketRequest.getUserId(),
                MovementType.DEBIT,
                ticketRequest.getStartDate(),
                ticketRequest.getEndDate()
        );

    }
}
