package com.wmm.tickets.infrastructure.adapter.input.rest;


import com.wmm.tickets.application.usecases.TicketsUseCase;
import com.wmm.tickets.infrastructure.adapter.input.rest.model.request.InputTicketRequest;
import com.wmm.tickets.infrastructure.adapter.input.rest.model.response.TicketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("tickets")
public class AmountTicketInputAdapter {

    private final TicketsUseCase amountTicketsUseCase;

    @PostMapping("incomes")
    public TicketResponse incomesAmount(@RequestBody InputTicketRequest inputTicketRequest) {
        String ticketAmount = amountTicketsUseCase
                .incomesAmount(inputTicketRequest.mapRequestToModel())
                .toString();

        return new TicketResponse(ticketAmount);
    }

    @PostMapping("outcomes")
    public TicketResponse outcomesAmount(@RequestBody InputTicketRequest inputTicketRequest) {
        String ticketAmount = amountTicketsUseCase
                .outcomesAmount(inputTicketRequest.mapRequestToModel())
                .toString();

        return new TicketResponse(ticketAmount);
    }
}
