package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordTest {

    @Test
    void testValidPassword() {
        String password = "MyPa$$word123";
        boolean isValid = Validador.validarContrasinal(password);
        Assertions.assertTrue(isValid);
    }

    @Test
    void testInvalidPassword1() {
        String password = "password";
        boolean isValid = Validador.validarContrasinal(password);
        Assertions.assertFalse(isValid);
    }

    @Test
    void testInvalidPassword2() {
        String password = "pass";
        boolean isValid = Validador.validarContrasinal(password);
        Assertions.assertFalse(isValid);
    }

    @Test
    void testInvalidPassword3() {
        String password = "passafdvdfvafvdfv12.";
        boolean isValid = Validador.validarContrasinal(password);
        Assertions.assertFalse(isValid);
    }

    @Test
    void testInvalidPassword4() {
        String password = "$$$,,,,//.";
        boolean isValid = Validador.validarContrasinal(password);
        Assertions.assertFalse(isValid);
    }
}
