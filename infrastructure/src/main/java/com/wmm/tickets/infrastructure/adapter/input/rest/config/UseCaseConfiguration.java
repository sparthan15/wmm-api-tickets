package com.wmm.tickets.infrastructure.adapter.input.rest.config;

import com.wmm.tickets.application.ports.input.AmountTicketsInputPort;
import com.wmm.tickets.application.ports.output.AmountTicketOutputPort;
import com.wmm.tickets.application.usecases.TicketsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public TicketsUseCase amountTicketsUseCase(AmountTicketOutputPort amountTicketOutputPort){
        return new AmountTicketsInputPort(amountTicketOutputPort);
    }

}
