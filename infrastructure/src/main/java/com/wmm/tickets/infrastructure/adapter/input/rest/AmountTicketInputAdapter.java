package com.wmm.tickets.infrastructure.adapter.input.rest;


import com.wmm.tickets.application.usecases.TicketsUseCase;
import com.wmm.tickets.infrastructure.adapter.input.rest.model.request.TicketRequest;
import com.wmm.tickets.infrastructure.adapter.input.rest.model.response.TicketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("tickets")
public class AmountTicketInputAdapter {

    private final TicketsUseCase amountTicketsUseCase;

    @PostMapping("incomes")
    public TicketResponse incomes(@RequestBody TicketRequest ticketRequest) {
        String ticketAmount = amountTicketsUseCase
                .incomes(ticketRequest.toModel()).getAmount().toString();

        return new TicketResponse(ticketAmount,
                ticketRequest.getStartDate().toString(),
                ticketRequest.getEndDate().toString());
    }
}
