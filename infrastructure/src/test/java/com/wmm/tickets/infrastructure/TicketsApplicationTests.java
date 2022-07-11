package com.wmm.tickets.infrastructure;

import com.wmm.tickets.infrastructure.adapter.TicketsApplication;
import com.wmm.tickets.infrastructure.adapter.output.mongodb.repository.MovementRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TicketsApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TicketsApplicationTests {


}
