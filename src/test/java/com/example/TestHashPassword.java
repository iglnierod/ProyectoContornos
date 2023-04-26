package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHashPassword {

    @Test
    public void TestValidHashPassword() {
    
        String contrasinalSinCifrar = "MiContrasinal";
        String expectedHash = "c4a2565f3db66f5a65864b418b7238a98d1a9801e524187d3cd09164ba729bd3";
        String contrasinalCifrado = Validador.hashearContrasinal(contrasinalSinCifrar);
        assertEquals(expectedHash, contrasinalCifrado);
    }
    
}
    

