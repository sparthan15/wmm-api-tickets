package com.wmm.tickets.infrastructure.adapter.input.rest.model.request;


import com.wmm.tickets.domain.exception.IncompleteRequestDataException;
import com.wmm.tickets.domain.request.TicketRequest;
import lombok.*;


import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Builder
public class InputTicketRequest {
    private String userId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private TicketRequest ticketRequestModel;

    public InputTicketRequest(String userId, LocalDateTime startDate, LocalDateTime endDate) {
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        validateIncompleteRequest();
        this.ticketRequestModel = TicketRequest.builder()
                .userId(userId)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

    public TicketRequest mapRequestToModel() {
        if (ticketRequestModel != null)
            return ticketRequestModel;
        validateIncompleteRequest();
        ticketRequestModel = TicketRequest.builder()
                .userId(userId)
                .startDate(startDate)
                .endDate(endDate)
                .build();

        return ticketRequestModel;
    }

    private void validateIncompleteRequest() {
        if (userId == null)
            throw new IncompleteRequestDataException("User id must not be null");
        if (startDate == null)
            throw new IncompleteRequestDataException("Start date must not be null");
        if (endDate == null)
            throw new IncompleteRequestDataException("End date must not be null");

    }
}
