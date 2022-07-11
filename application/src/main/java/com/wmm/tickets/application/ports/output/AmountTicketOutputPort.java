package com.wmm.tickets.application.ports.output;


import com.wmm.domain.vo.MovementType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface AmountTicketOutputPort {

    BigDecimal sumAmountByUserIdAndMovementTypeAndDateGreaterThanAndDateLessThan(String userIdTest, MovementType credit, LocalDateTime startDate, LocalDateTime endDate);
}
