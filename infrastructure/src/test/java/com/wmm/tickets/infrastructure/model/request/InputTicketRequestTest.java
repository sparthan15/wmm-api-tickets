package com.wmm.tickets.infrastructure.model.request;

import com.wmm.tickets.domain.exception.IncompleteRequestDataException;
import com.wmm.tickets.domain.request.TicketRequest;
import com.wmm.tickets.infrastructure.adapter.input.rest.model.request.InputTicketRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static util.TestUtil.*;

public class InputTicketRequestTest {

    @Test
    public void whatIAmInsterestedForIsToObtainAModelRequestFromARequest() {
        InputTicketRequest ticketRequest = new InputTicketRequest(USER_ID_TEST, START_DATE, END_DATE);
        assertThat(ticketRequest.mapRequestToModel().getEndDate()).isEqualTo(END_DATE);
        assertThat(ticketRequest.mapRequestToModel().getStartDate()).isNotNull().isEqualTo(START_DATE);;
        assertThat(ticketRequest.mapRequestToModel().getUserId()).isEqualTo(USER_ID_TEST);
    }

    @Test
    public void ticketRequestCanBeConvertedToModel() {
        InputTicketRequest ticketRequest = new InputTicketRequest("123KASD", START_DATE, END_DATE);
        TicketRequest domainTicketRequest = ticketRequest.mapRequestToModel();
        assertThat(domainTicketRequest.getUserId()).isNotNull();
        assertThat(domainTicketRequest.getEndDate()).isNotNull();
        assertThat(domainTicketRequest.getStartDate()).isNotNull();
    }


    @Test
    public void givenATicketRequestHasNoStartDateThenAnsExceptionIsThrown() {
        Assertions.assertThatThrownBy(() -> {
            new InputTicketRequest(USER_ID_TEST, null,
                    LocalDateTime.now());
        }).isInstanceOf(IncompleteRequestDataException.class);
    }

    @Test
    public void givenATicketRequestIsInitializedWithNoEndDateThenAnsExceptionIsThrown() {
        Assertions.assertThatThrownBy(() -> {
            new InputTicketRequest(USER_ID_TEST, LocalDateTime.now(), null);
        }).isInstanceOf(IncompleteRequestDataException.class);
    }

    @Test
    public void givenATicketRequestHasNoUseridThenAnsExceptionIsThrown() {
        Assertions.assertThatThrownBy(() -> {
            new InputTicketRequest(null, LocalDateTime.now(),
                    LocalDateTime.now());
        }).isInstanceOf(IncompleteRequestDataException.class);
    }


    @Test
    public void givenTheRequestCanBeBeAssembledWitoutConstructurThenWeNeedEnsureThatModelIsGenerated(){
        InputTicketRequest inputTicketRequest = InputTicketRequest.builder()
                .userId(USER_ID_TEST)
                .startDate(START_DATE)
                .endDate(END_DATE)
                .build();
        assertThat(inputTicketRequest.mapRequestToModel()).isNotNull();
    }

}
