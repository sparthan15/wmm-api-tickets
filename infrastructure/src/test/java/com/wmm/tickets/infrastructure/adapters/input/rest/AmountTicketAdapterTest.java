package com.wmm.tickets.infrastructure.adapters.input.rest;

import com.wmm.domain.IncompleteRequestDataException;
import com.wmm.tickets.application.usecases.TicketsUseCase;
import com.wmm.tickets.domain.entities.Ticket;
import com.wmm.tickets.infrastructure.adapter.input.rest.AmountTicketInputAdapter;
import com.wmm.tickets.infrastructure.adapter.input.rest.model.response.TicketResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.TestUtil.*;

@ExtendWith(MockitoExtension.class)
public class AmountTicketAdapterTest {

    private AmountTicketInputAdapter amountTicketAdapter;

    @Mock
    private TicketsUseCase amountTicketsUseCase;

    private void setUp(TicketsUseCase amountTicketsUseCase){
        amountTicketAdapter = new AmountTicketInputAdapter(amountTicketsUseCase);
    }

    @Test
    public void adapterReturnAnResponseObjectToBeAbleToShareComplexDataWithClients(){
        Mockito.when(amountTicketsUseCase.incomes(USER_ID_TEST, START_DATE, END_DATE)).thenReturn(new Ticket(USER_ID_TEST,CREDIT_AMOUNT, START_DATE, END_DATE
        ));
        setUp(amountTicketsUseCase);
        TicketResponse response = amountTicketAdapter.incomes(TICKET_REQUEST);
        assertThat(response.getAmount()).isEqualTo(CREDIT_AMOUNT.toString());
    }

    @Test
    public void adapterNeedForAUserCaseToImplementOperations(){
        Mockito.when(amountTicketsUseCase.incomes(USER_ID_TEST, START_DATE, END_DATE)).thenReturn(new Ticket(USER_ID_TEST,CREDIT_AMOUNT, START_DATE, END_DATE));
        setUp(amountTicketsUseCase);
        TicketResponse response = amountTicketAdapter.incomes(TICKET_REQUEST);
        assertThat(response.getAmount()).isEqualTo(CREDIT_AMOUNT.toString());
    }

    @Test
    public void givenABadTicketRequestThenAnExceptionisThrown(){
        assertThatThrownBy(()->{
            TicketResponse response = amountTicketAdapter.incomes(BAD_TICKET_REQUEST);
        }).isInstanceOf(IncompleteRequestDataException.class);

    }

}
