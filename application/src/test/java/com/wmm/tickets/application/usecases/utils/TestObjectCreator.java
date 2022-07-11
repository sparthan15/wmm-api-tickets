package com.wmm.tickets.application.usecases.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;

public class TestObjectCreator {
    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-mm-ddTH:m:s");

    public static LocalDateTime START_DATE = LocalDateTime.of(2022, Month.JULY, 1, 0, 0);
    public static LocalDateTime END_DATE = LocalDateTime.of(2022, Month.JULY, 31, 0, 0);
}
