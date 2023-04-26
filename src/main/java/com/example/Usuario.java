package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {
    private String email;
    private String contrasinal;
    private String web;
    private Date nacemento;

    public Usuario(String email, String contrasinal, String web, String nacemento) 
            throws IllegalArgumentException, NoSuchAlgorithmException, ParseException {
        setEmail(email);
        setContrasinal(contrasinal);
        setWeb(web);
        setNacemento(nacemento);
    }

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new IllegalArgumentException("O email non ten un formato válido.");
        }
        this.email = email;
    }

    public String getContrasinal() {
        return contrasinal;
    }

    public void setContrasinal(String contrasinal) throws NoSuchAlgorithmException {
        if (contrasinal.length() < 8) {
            throw new IllegalArgumentException("O contrasinal debe ter como mínimo 8 caracteres.");
        }
        if (!contrasinal.matches(".*\\d.*")) {
            throw new IllegalArgumentException("O contrasinal debe conter como mínimo un número.");
        }
        if (!contrasinal.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("O contrasinal debe conter como mínimo unha letra.");
        }
        if (!contrasinal.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            throw new IllegalArgumentException("O contrasinal debe conter como mínimo un carácter especial.");
        }
        this.contrasinal = hashContrasinal(contrasinal);
    }

    private String hashContrasinal(String contrasinal) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(contrasinal.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) throws IllegalArgumentException {
        if (!web.matches("(http|https)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/.*)?")) {
            throw new IllegalArgumentException("A dirección web non ten un formato válido.");
        }
        this.web = web;
    }

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(String nacemento) throws IllegalArgumentException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date data = sdf.parse(nacemento);
        Date dataAtual = new Date();
        if (data.after(dataAtual)) {
            throw new IllegalArgumentException("A data de nacemento debe ser anterior á data actual.");
        }
        this.nacemento = data;
    }
}

