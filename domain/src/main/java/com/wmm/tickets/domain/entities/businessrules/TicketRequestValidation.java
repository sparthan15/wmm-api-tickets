package com.wmm.tickets.domain.entities.businessrules;

import com.wmm.tickets.domain.entities.Ticket;
import com.wmm.tickets.domain.entities.exception.IncompleteRequestDataException;

public class TicketRequestValidation {
    public static void validate(Ticket ticketRequest){
        System.out.println(ticketRequest);
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
