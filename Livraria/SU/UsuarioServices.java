package Livraria.SU;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioServices {
  private static final String RepositorioUsuario = "usuarios.txt";

    public static void CriarUsuario(Usuario usuario) {     
      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(RepositorioUsuario, true));
        writer.write(usuario.getId() + ";" + usuario.getNome() + ";" + usuario.getEmail() + ";" + usuario.getSenha() + "\n");
        writer.close();
        System.out.println("Usuário criado com sucesso!");

      } catch (IOException e) {
        System.out.println("Erro ao salvar usuário: " + e.getMessage());;
      }
    }

    public static void RemoverUsuario(int idParaRemover) {
      List<String> linhas = new ArrayList<>();
      try (BufferedReader reader = new BufferedReader(new FileReader(RepositorioUsuario))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
          if (!linha.startsWith(idParaRemover + ";")) { linhas.add(linha); }
        }            
      } catch (IOException e) {
          System.out.println("Erro ao ler o arquivo: " + e.getMessage());
      }

      try (BufferedWriter writer = new BufferedWriter(new FileWriter(RepositorioUsuario))) {
        for (String linha : linhas) {
          writer.write(linha);
          writer.newLine();
        }
        writer.close();
        System.out.println("Usuário removido com sucesso!");
      } catch (IOException e) {
          System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
      }
    }

    public static void EditarUsuario(int id, String novoNome, String novoEmail, String novaSenha) {
      RemoverUsuario(id);
      Usuario usuarioEditado = new Usuario(id, novoNome, novoEmail, novaSenha);
      CriarUsuario(usuarioEditado);
      System.out.println("Usuário editado com sucesso!");
  }

  public static void ListarUsuarios() {
    File arquivo = new File(RepositorioUsuario);

    if (!arquivo.exists()) {
        System.out.println("Nenhum usuário cadastrado ainda.");
        return;
    }

    System.out.println("\n=== Lista de Usuários ===");

    try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length == 4) {
                System.out.println("ID: " + dados[0]);
                System.out.println("Nome: " + dados[1]);
                System.out.println("E-mail: " + dados[2]);
                System.out.println("--------------------------");
            }
        }
    } catch (IOException e) {
        System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }
}

public static boolean AutenticarUsuario(String email, String senha) {
  try (BufferedReader reader = new BufferedReader(new FileReader(RepositorioUsuario))) {
      String linha;
      while ((linha = reader.readLine()) != null) {
          String[] dados = linha.split(";");
          if (dados.length >= 4) { // Verifica se tem todos os campos (id, nome, email, senha)
              String emailSalvo = dados[2];
              String senhaSalva = dados[3];
              if (emailSalvo.equals(email) && senhaSalva.equals(senha)) {
                  System.out.println("Login bem-sucedido! Bem-vindo, " + dados[1] + "!");
                  return true;
              }
          }
      }
  } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo: " + e.getMessage());
  }
  System.out.println("E-mail ou senha incorretos.");
  return false;
}

}

