package Livraria;

import java.util.Scanner;
import Livraria.SU.Gerente;
import Livraria.SU.UsuarioServices;

public class LoginSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void iniciar() {
        boolean logado = false;
        System.out.println("Bem-vindo ao sistema de login e registro da Livraria!");

        while (!logado) {
            System.out.println("\nDigite: \n1 - Login \n2 - Registrar:");
            
            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite 1 para Login ou 2 para Registrar.");
                continue;
            }

            switch (opcao) {
                case 1:
                    logado = fazerLogin();
                    break;
                case 2:
                    registrarUsuario();
                    break;
                default:
                    System.out.println("Opção inválida! Escolha 1 para Login ou 2 para Registrar.");
            }
        }

        System.out.println("Sistema iniciado com sucesso! (Usuário logado)");
    }

    private static boolean fazerLogin() {
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        String user = UsuarioServices.AutenticarUsuario(email, senha);

        if (user != null) {
            System.out.println("Login realizado com sucesso! Bem-vindo, " + user + "!");
            return true;
        } else {
            System.out.println("Email ou senha incorretos. Tente novamente.");
            return false;
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