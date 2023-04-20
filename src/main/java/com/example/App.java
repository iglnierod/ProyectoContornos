package com.example;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("2. Ver usuarios rexistrados");
            System.out.println("3. Saír");
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
                    app.;
                    break;
                case 4:
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
                System.out.println("Email: " + usuario.getContrasinal());
                System.out.println("Web: " + usuario.getWeb());
                System.out.println("Data de nacemento: " + usuario.getNacemento());
                break;
            }
        }
        if (!usuarioEncontrado) {
            System.out.println("\nEmail o contrasinal incorrectos.");
        }
    }
    
    public void borrarUsuario(){
        
    }
}

