package com.wmm.tickets.application.usecases;

import com.wmm.domain.vo.MovementType;
import com.wmm.tickets.application.ports.input.AmountTicketsInputPort;
import com.wmm.tickets.application.ports.output.AmountTicketOutputPort;
import com.wmm.tickets.domain.request.TicketRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.ParseException;

import static com.wmm.tickets.application.usecases.utils.TestObjectCreator.END_DATE;
import static com.wmm.tickets.application.usecases.utils.TestObjectCreator.START_DATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class TicketAmountUseCaseTest {

    private TicketsUseCase amountTicketsUseCase;

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
        BigDecimal incomesAmount = amountTicketsUseCase.incomesAmount(new TicketRequest(USER_ID_TEST,
                START_DATE,
                END_DATE));
        assertThat(incomesAmount).isEqualTo(INCOMES_TOTAL_AMOUNT);
    }

    @Test
    public void incomesAmountTicketThrowsExceptionIfUserIdIsNull() throws ParseException {

        assertThatThrownBy(() -> {
            setUpUseCase(amountTicketOutputPort);
            BigDecimal incomesAmount = amountTicketsUseCase.incomesAmount(new TicketRequest(null,
                    START_DATE,
                    END_DATE));
            assertThat(incomesAmount).isEqualTo(INCOMES_TOTAL_AMOUNT);
        });

    }

    @Test
    public void incomesAmountTicketThrowsExceptionIfStartDateIsNull() throws ParseException {

        assertThatThrownBy(() -> {
            setUpUseCase(amountTicketOutputPort);
            BigDecimal incomesAmount = amountTicketsUseCase.incomesAmount(new TicketRequest(USER_ID_TEST,
                    null,
                    END_DATE));
            assertThat(incomesAmount).isEqualTo(INCOMES_TOTAL_AMOUNT);
        });

    }

    @Test
    public void incomesAmountThrowsExceptionIfTheRequestIsNull() throws ParseException {

        assertThatThrownBy(() -> {
            setUpUseCase(amountTicketOutputPort);
            BigDecimal incomesAmount = amountTicketsUseCase.incomesAmount(null);
            assertThat(incomesAmount).isEqualTo(INCOMES_TOTAL_AMOUNT);
        }).isNotExactlyInstanceOf(NullPointerException.class);

    }

    @Test
    public void incomesAmountTicketThrowsExceptionIfEndDateIsNull() throws ParseException {

        assertThatThrownBy(() -> {
            setUpUseCase(amountTicketOutputPort);
            BigDecimal incomesAmount = amountTicketsUseCase.incomesAmount(new TicketRequest(USER_ID_TEST,
                    START_DATE,
                    null));
            assertThat(incomesAmount).isEqualTo(INCOMES_TOTAL_AMOUNT);
        });

    }

    @Test
    public void getOutcomesAmountTicket() {
        Mockito.when(amountTicketOutputPort.sumAmountByUserIdAndMovementTypeAndDateGreaterThanAndDateLessThan(USER_ID_TEST,
                MovementType.DEBIT, START_DATE, END_DATE)).thenReturn(OUTCOMES_TOTAL_AMOUNT);
        setUpUseCase(amountTicketOutputPort);
        BigDecimal outcomesTotalAmount =
                amountTicketsUseCase.outcomesAmount(new TicketRequest(USER_ID_TEST,
                        START_DATE,
                        END_DATE));
        assertThat(outcomesTotalAmount).isEqualTo(OUTCOMES_TOTAL_AMOUNT);
    }


    private void setUpUseCase(AmountTicketOutputPort amountTicketOutputPort) {
        amountTicketsUseCase = new AmountTicketsInputPort(amountTicketOutputPort);
    }
}
