package com.wmm.tickets.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Builder
@ToString
public class Ticket {
    private final String userId;
    private final BigDecimal amount;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
}
