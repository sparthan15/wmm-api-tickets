package com.wmm.tickets.domain;

import com.wmm.tickets.domain.entities.Ticket;
import org.assertj.core.api.BigDecimalAssert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketModelTest {

    private static final String USER_ID = "123KL";
    private static final BigDecimal DEBIT_AMOUNT = new BigDecimal(1222.23);

    @Test
    public void test() {
        Ticket ticket = new Ticket(USER_ID, DEBIT_AMOUNT,  LocalDateTime.now(),
                LocalDateTime.now());
        assertThat(ticket).isNotNull();
        assertThat(ticket.getUserId()).isEqualTo(USER_ID);
        assertThat(ticket.getAmount()).isEqualTo(DEBIT_AMOUNT);
        assertThat(ticket.getStartDate()).isNotNull();
        assertThat(ticket.getEndDate()).isNotNull();
    }

}
