package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    void testValidEmail() {
        String email = "test@example.com";
        boolean isValid = Validador.validarEmail(email);
        Assertions.assertTrue(isValid);
    }

    @Test
    void testInvalidEmail() {
        String email = "invalid email";
        boolean isValid = Validador.validarEmail(email);
        Assertions.assertFalse(isValid);
    }
}
