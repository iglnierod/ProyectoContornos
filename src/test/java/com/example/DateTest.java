package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class DateTest {

    @Test
    void testValidDate() {
        LocalDate date = LocalDate.of(1990, 1, 1);
        boolean isValid = Validador.validarNacemento(date);
        Assertions.assertTrue(isValid);
    }

    @Test
    void testInvalidDate1() {
        LocalDate date = LocalDate.of(2025, 1, 1);
        boolean isValid = Validador.validarNacemento(date);
        Assertions.assertFalse(isValid);
    }
    
}

