package com.wmm.tickets.domain.businessrules;

import com.wmm.tickets.domain.exception.IncompleteRequestDataException;
import com.wmm.tickets.domain.request.TicketRequest;

public class TicketRequestValidation {
    public static void validate(TicketRequest ticketRequest){
        if(ticketRequest==null){
            throw new IncompleteRequestDataException("Bad request, Ticket request is null");
        }
        if(ticketRequest.getStartDate()==null){
            throw new IncompleteRequestDataException("Start date is not present in the request.");
        }
        if(ticketRequest.getEndDate()==null){
            throw new IncompleteRequestDataException("End date is not present in the request.");
        }

        if(ticketRequest.getUserId()==null){
            throw new IncompleteRequestDataException("UserId is not present in the request.");
        }
    }
}
