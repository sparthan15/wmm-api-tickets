package com.wmm.tickets.domain.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
@Getter
public class TicketRequest {

    private final String userId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
}
