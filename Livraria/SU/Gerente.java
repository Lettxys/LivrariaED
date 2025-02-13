package Livraria.SU;

public class Gerente extends Usuario {
    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha);
    }
    public boolean ehGerente() { return true; }
}
