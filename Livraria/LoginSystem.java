package Livraria;

import java.util.Scanner;
import Livraria.SU.Gerente;
import Livraria.SU.UsuarioServices;

public class LoginSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static int iniciar() {
        System.out.println("Bem-vindo ao sistema de login e registro da Livraria!");

        while (true) {
            System.out.println("\nDigite: \n1 - Login \n2 - Registrar:");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite 1 para Login ou 2 para Registrar.");
                continue;
            }

            if (opcao == 1) {
                int userId = fazerLogin();
                if (userId != -1) {
                    return userId;
                }
            } else if (opcao == 2) {
                registrarUsuario();
            } else {
                System.out.println("Opção inválida! Escolha 1 para Login ou 2 para Registrar.");
            }
        }
    }

    private static int fazerLogin() {
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        String user = UsuarioServices.AutenticarUsuario(email, senha);
        int userId = Integer.valueOf(user);

        if (userId != -1) {
            System.out.println("Login realizado com sucesso! Seu ID: " + userId);
            return userId; 
        } else {
            System.out.println("Email ou senha incorretos. Tente novamente.");
            return -1;
        }
    }

    private static void registrarUsuario() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Gerente usuario = new Gerente(nome, email, senha);
        UsuarioServices.CriarUsuario(usuario);

        System.out.println("Registro realizado com sucesso! Agora, faça login.");
    }
}
