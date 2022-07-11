package com.wmm.tickets.infrastructure.adapter.input.rest.model.request;
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


}
