package com.wmm.tickets.infrastructure.adapter.input.rest.model.response;

import lombok.AllArgsConstructor;

import lombok.Getter;

@Getter
public class TicketResponse {
    private final String amount;
    private final String startDate;
    private final String endDate;

    public TicketResponse(String amount, String startDate, String endDate) {

        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
