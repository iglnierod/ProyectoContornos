package com.example;

import org.junit.jupiter.api.*;
import java.util.*;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private App app;
    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @BeforeEach
    public void setup() {
        app = new App();
        outputStream = new ByteArrayOutputStream();
    }

    @AfterEach
    public void tearDown() {
        outputStream.reset();
    }

    @Test
    public void testRegistroUsuarioExitoso() {
        String input = "test@example.com\npassword123.\nhttps://example.com\n1990-01-01";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        app.rexistrarUsuario(new Scanner(System.in));

        assertTrue(outputStream.toString().contains("Usuario rexistrado con éxito."));
        assertEquals(1, app.usuarios.size());
        assertEquals("test@example.com", app.usuarios.get(0).getEmail());
    }

    @Test
    public void testRegistroUsuarioExistente() throws IllegalArgumentException, NoSuchAlgorithmException, ParseException {
        app.usuarios.add(new Usuario("existing@example.com", "password123.", "http://example.com", "1990-01-01"));

        String input = "existing@example.com\npassword123.\nexample.com\n1990-01-01";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        app.rexistrarUsuario(new Scanner(System.in));

        assertTrue(outputStream.toString().contains("Ya existe un usuario con ese email."));
        assertEquals(1, app.usuarios.size());
    }

    @Test
    public void testRegistroUsuarioInvalido() {
        String input = "invalidemail\n\npassword123.\nexample.com\n1990-01-01";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        app.rexistrarUsuario(new Scanner(System.in));

        assertTrue(outputStream.toString().contains("Erro: "));
        assertEquals(0, app.usuarios.size());
    }

    @Test
    public void testComprobacionDatosUsuarioExistente() throws IllegalArgumentException, NoSuchAlgorithmException, ParseException {
        app.usuarios.add(new Usuario("test@example.com", "password123.", "https://example.com", "1990-01-01"));

        String input = "test@example.com\npassword123";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        app.comprobarDatos();

        assertTrue(outputStream.toString().contains("Datos del usuario:"));
        assertTrue(outputStream.toString().contains("Email: test@example.com"));
    }
    @Test
    public void testComprobacionDatosUsuarioNoExistente() throws IllegalArgumentException, NoSuchAlgorithmException, ParseException {
        app.usuarios.add(new Usuario("test@example.com", "password123.", "https://example.com", "1990-01-01"));

        String input = "nonexistent@example.com\npassword123.";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        app.comprobarDatos();

        assertTrue(outputStream.toString().contains("Email o contrasinal incorrectos."));
    }
    
    @Test
    public void testBorrarUsuarioExistente() throws IllegalArgumentException, NoSuchAlgorithmException, ParseException {
        app.usuarios.add(new Usuario("test@example.com", "password123.", "https://example.com", "1990-01-01"));

        String input = "test@example.com\npassword123.";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        app.borrarUsuario(new Scanner(System.in));

        assertTrue(outputStream.toString().contains("Usuario borrado con éxito."));
        assertEquals(0, app.usuarios.size());
    }
    @Test
    public void testBuscarUsuariosPorRangoFechas() throws IllegalArgumentException, NoSuchAlgorithmException, ParseException {
    app.usuarios.add(new Usuario("user1@example.com", "password123.", "https://example.com", "1990-01-01"));
    
    app.usuarios.add(new Usuario("user3@example.com", "password123.", "https://example.com", "1988-11-30"));

    String input = "1989-01-01\n1991-12-31";
    inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    System.setOut(new PrintStream(outputStream));

    app.buscarUsuarios(new Scanner(System.in));

    assertTrue(outputStream.toString().contains("Email: user1@example.com"));
    assertTrue(outputStream.toString().contains("Data de nacemento: 1990-01-01"));
    assertFalse(outputStream.toString().contains("Email: user2@example.com"));

}


}