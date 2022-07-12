package com.wmm.tickets.infrastructure.adapter.input.rest.model.request;

import com.wmm.domain.IncompleteRequestDataException;
import com.wmm.tickets.domain.entities.Ticket;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class TicketRequest {
    private String userId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    public Ticket toModel() {
        validateUserIdIsNotNull();

        return Ticket.builder()
                .userId(userId)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

    private void validateUserIdIsNotNull() {
        if(userId==null)
            throw new IncompleteRequestDataException("User id must not be null");
    }
}
