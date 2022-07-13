package util;

import com.wmm.tickets.infrastructure.adapter.input.rest.model.request.InputTicketRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

public class TestUtil {

    public static final String USER_ID_TEST = "123KSJ";
    public static final BigDecimal CREDIT_AMOUNT = BigDecimal.valueOf(12033.2);
    public static LocalDateTime START_DATE = LocalDateTime.of(2022, Month.JULY, 1, 0, 0, 0);
    public static LocalDateTime END_DATE = LocalDateTime.of(2022, Month.JULY, 31, 0, 0, 0);
    public static final InputTicketRequest TICKET_REQUEST = new InputTicketRequest(USER_ID_TEST, START_DATE, END_DATE);

}
