package com.wmm.tickets.application.usecases;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    @Test
    void testingContextLoads() {
        BigDecimal numero = new BigDecimal("7.3333");
        System.out.println("El número original: " + numero.toString());
        // Establecer su escala y su forma de redondeo; al llamar
        // a setScale se redondea
        BigDecimal bdHalfUp = numero.setScale(3, RoundingMode.HALF_UP);
        System.out.println("El número con RoundingMode.HALF_UP: " + bdHalfUp.toString());
        BigDecimal bdCeiling = numero.setScale(3, RoundingMode.CEILING);
        System.out.println("El número con RoundingMode.CEILING: " + bdCeiling.toString());
        BigDecimal bdUp = numero.setScale(3, RoundingMode.UP);
        System.out.println("El número con RoundingMode.UP: " + bdUp.toString());
        BigDecimal bdFloor = numero.setScale(3, RoundingMode.FLOOR);
    }

    @Test
    public void testSumBigDecimal(){
        BigDecimal number1 = BigDecimal.valueOf(1000.2);
        BigDecimal number2 = BigDecimal.valueOf(1000.3);

        System.out.println(number1.add(number2));
    }
}
