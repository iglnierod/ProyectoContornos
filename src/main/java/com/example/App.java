package com.example;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class App {
    private List<Usuario> usuarios;

    public App() {
        this.usuarios = new ArrayList<>();
    }

    public static void main(String[] args) {
        App app = new App();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n********** Menú **********");
            System.out.println("1. Rexistrar usuario");
            System.out.println("2. Datos de usuario");
            System.out.println("3. Borrar usuario");
            System.out.println("4. Buscar usuario");
            System.out.println("5. Saír");
            System.out.print("Escolle unha opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    app.rexistrarUsuario(scanner);
                    break;
                case 2:
                    app.comprobarDatos();
                    break;
                case 3:
                    app.borrarUsuario(scanner);
                    break;
                case 4:
                    app.buscarUsuarios(scanner);
                    break;
                case 5:
                    System.out.println("Saíndo do programa...");
                    break;
                default:
                    System.out.println("Opción non válida.");
                    break;
            }

        } while (opcion != 5);

        scanner.close();
    }

    public void rexistrarUsuario(Scanner scanner) {
        try {
            System.out.print("\nEmail: ");
            String email = scanner.next();

            System.out.print("Contrasinal: ");
            String contrasinal = scanner.next();

            System.out.print("Web: ");
            String web = scanner.next();

            System.out.print("Data de nacemento (yyyy-MM-dd): ");
            String nacemento = scanner.next();

            Usuario usuario = new Usuario(email, contrasinal, web, nacemento);
            usuarios.add(usuario);

            System.out.println("\nUsuario rexistrado con éxito.");
        } catch (IllegalArgumentException | NoSuchAlgorithmException | ParseException e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    public void comprobarDatos() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("\nEmail: ");
        String email = scanner.next();
    
        System.out.print("Contrasinal: ");
        String contrasinal = scanner.next();
    
        boolean usuarioEncontrado = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) || usuario.getContrasinal().equals(contrasinal)) {
                usuarioEncontrado = true;
                System.out.println("\nDatos del usuario:");
                System.out.println("Email: " + usuario.getEmail());
                System.out.println("Web: " + usuario.getWeb());
                System.out.println("Data de nacemento: " + usuario.getNacemento());
                break;
            }
        }
        
        if (!usuarioEncontrado) {
            System.out.println("\nEmail o contrasinal incorrectos.");
        }
        
    }
    
    public void borrarUsuario(Scanner scanner) {
        System.out.print("\nEmail: ");
        String email = scanner.next();
    
        System.out.print("Contrasinal: ");
        String contrasinal = scanner.next();
    
        boolean usuarioEncontrado = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) || usuario.getContrasinal().equals(contrasinal)) {
                usuarios.remove(usuario);
                usuarioEncontrado = true;
                System.out.println("Usuario borrado con éxito.");
                break;
            }
        }
        if (!usuarioEncontrado) {
            System.out.println("No se encontró el usuario con el email y contraseña proporcionados.");
        }
    }
    
    public void buscarUsuarios(Scanner scanner) {
        System.out.print("Introduce a primeira data (yyyy-MM-dd): ");
        String dataInicioStr = scanner.next();
    
        System.out.print("Introduce a segunda data (yyyy-MM-dd): ");
        String dataFinStr = scanner.next();
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
        try {
            LocalDate dataInicio = LocalDate.parse(dataInicioStr, formatter);
            LocalDate dataFin = LocalDate.parse(dataFinStr, formatter);
    
            boolean usuariosEncontrados = false;
            for (Usuario usuario : usuarios) {
                String fechaNacimientoStr = dateFormatter.format(usuario.getNacemento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    
                LocalDate dataNacemento = LocalDate.parse(fechaNacimientoStr, formatter);
                if (dataNacemento.isAfter(dataInicio) || dataNacemento.isBefore(dataFin)) {
                    System.out.println("Email: " + usuario.getEmail());
                    System.out.println("Data de nacemento: " + fechaNacimientoStr);
                    usuariosEncontrados = true;
                }
            }
    
            if (!usuariosEncontrados) {
                System.out.println("Non hai usuarios con data de nacemento entre " + dataInicioStr + " e " + dataFinStr);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data incorrecto. O formato debe ser yyyy-MM-dd");
        }
    }
    
}

