package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class UserTest {

    @Test
    void testConstructor() throws NoSuchAlgorithmException, ParseException {
        // Datos de prueba
        String email = "correo@example.com";
        String contrasinal = "Abc123!@#";
        String web = "https://www.example.com/";
        String nacemento = "1990-01-01";
    
        // Crear instancia de Usuario utilizando el constructor
        Usuario usuario = new Usuario(email, contrasinal, web, nacemento);
    
        // Verificar que los valores se hayan establecido correctamente
        assertEquals(email, usuario.getEmail());
        assertNotNull(usuario.getContrasinal());
        assertEquals(web, usuario.getWeb());
        assertNotNull(usuario.getNacemento());
    }
    

    @Test
void testSetEmail() {
    Usuario usuario = new Usuario();
    usuario.setEmail("correo@example.com");
    assertEquals("correo@example.com", usuario.getEmail());
}


@Test
void testSetEmailInvalido() {
    Usuario usuario = new Usuario();
    assertThrows(IllegalArgumentException.class, () -> usuario.setEmail("correoexample.com"));
}

@Test
void testSetContrasinal() throws NoSuchAlgorithmException {
    Usuario usuario = new Usuario();
    usuario.setContrasinal("Abc123!@#");
    assertNotNull(usuario.getContrasinal());
}

@Test
void testSetContrasinalInvalido1() {
    Usuario usuario = new Usuario();
    assertThrows(IllegalArgumentException.class, () -> usuario.setContrasinal("contrasinal"));
}

@Test
void testSetContrasinalInvalido2() {
    Usuario usuario = new Usuario();
    assertThrows(IllegalArgumentException.class, () -> usuario.setContrasinal("contra"));
}

@Test
void testSetContrasinalInvalido3() {
    Usuario usuario = new Usuario();
    assertThrows(IllegalArgumentException.class, () -> usuario.setContrasinal("cont."));
}

@Test
void testSetContrasinalInvalido4() {
    Usuario usuario = new Usuario();
    assertThrows(IllegalArgumentException.class, () -> usuario.setContrasinal("12334567."));
}

@Test
void testSetContrasinalInvalido5() {
    Usuario usuario = new Usuario();
    assertThrows(IllegalArgumentException.class, () -> usuario.setContrasinal("contraseña1"));
}

@Test
void testSetWeb() {
    Usuario usuario = new Usuario();
    usuario.setWeb("https://www.example.com/");
    assertEquals("https://www.example.com/", usuario.getWeb());
}

@Test
void testSetWebInvalido() {
    Usuario usuario = new Usuario();
    assertThrows(IllegalArgumentException.class, () -> usuario.setWeb("example.com"));
}

@Test
void testSetNacemento() throws IllegalArgumentException, ParseException {
    Usuario usuario = new Usuario();
    usuario.setNacemento("1990-01-01");
    assertNotNull(usuario.getNacemento());
}

@Test
void testSetNacementoInvalido() {
    Usuario usuario = new Usuario();
    assertThrows(IllegalArgumentException.class, () -> usuario.setNacemento("2050-01-01"));
}

}