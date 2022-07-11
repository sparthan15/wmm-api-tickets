package com.wmm.tickets.application.usecases;

import com.wmm.domain.vo.MovementType;
import com.wmm.tickets.application.ports.input.AmountTicketsInputPort;
import com.wmm.tickets.application.ports.output.AmountTicketOutputPort;
import com.wmm.tickets.domain.entities.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.ParseException;

import static com.wmm.tickets.application.usecases.utils.TestDescription.USER_ID_NEEDED;
import static com.wmm.tickets.application.usecases.utils.TestObjectCreator.END_DATE;
import static com.wmm.tickets.application.usecases.utils.TestObjectCreator.START_DATE;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AmountTicketAmountUseCaseTest {

    private TicketsUseCase amountTickestUseCase;

    @Mock
    private AmountTicketOutputPort amountTicketOutputPort;
    private final BigDecimal INCOMES_TOTAL_AMOUNT = new BigDecimal(150000.22);
    private final BigDecimal OUTCOMES_TOTAL_AMOUNT = new BigDecimal(25000.22);
    private final String USER_ID_TEST = "123KKA";

    @Test
    public void incomesAmountTicketCanBeFetchByStartDateAndEndDate() throws ParseException {
        Mockito.when(amountTicketOutputPort.sumAmountByUserIdAndMovementTypeAndDateGreaterThanAndDateLessThan(USER_ID_TEST,
                MovementType.CREDIT, START_DATE, END_DATE)).thenReturn(INCOMES_TOTAL_AMOUNT);
        setUpUseCase(amountTicketOutputPort);
        Ticket ticket = amountTickestUseCase.incomes(new Ticket(USER_ID_TEST, null, START_DATE,
                END_DATE));
        assertThat(ticket.getAmount()).isEqualTo(INCOMES_TOTAL_AMOUNT);
        assertThat(ticket.getUserId())
                .as(USER_ID_NEEDED)
                .isEqualTo(USER_ID_TEST);
    }

    @Test
    public void getOutcomesAmountTicket() {
        Mockito.when(amountTicketOutputPort.sumAmountByUserIdAndMovementTypeAndDateGreaterThanAndDateLessThan(USER_ID_TEST,
                MovementType.DEBIT, START_DATE, END_DATE)).thenReturn(OUTCOMES_TOTAL_AMOUNT);
        setUpUseCase(amountTicketOutputPort);
        Ticket ticket = amountTickestUseCase.outcomes(new Ticket(USER_ID_TEST, null, START_DATE,
                END_DATE));
        assertThat(ticket.getAmount()).isEqualTo(OUTCOMES_TOTAL_AMOUNT);
        assertThat(ticket.getUserId())
                .as(USER_ID_NEEDED)
                .isEqualTo(USER_ID_TEST);
    }


    private void setUpUseCase(AmountTicketOutputPort amountTicketOutputPort) {
        amountTickestUseCase = new AmountTicketsInputPort(amountTicketOutputPort);
    }
}
