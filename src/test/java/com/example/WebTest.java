package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WebTest {

    @Test
    void testValidWebsite() {
        String website = "https://example.com";
        boolean isValid = Validador.validarWeb(website);
        Assertions.assertTrue(isValid);
    }

    @Test
    void testInvalidWebsite1() {
        String website = "example";
        boolean isValid = Validador.validarWeb(website);
        Assertions.assertFalse(isValid);
    }

    @Test
    void testInvalidWebsite2() {
        String website = "https:\\example.com";
        boolean isValid = Validador.validarWeb(website);
        Assertions.assertFalse(isValid);
    }

    @Test
    void testInvalidWebsite3() {
        String website = "ftsa://example.com";
        boolean isValid = Validador.validarWeb(website);
        Assertions.assertFalse(isValid);
    }

    @Test
    void testInvalidWebsite4() {
        String website = "https:\\example";
        boolean isValid = Validador.validarWeb(website);
        Assertions.assertFalse(isValid);
    }
}
