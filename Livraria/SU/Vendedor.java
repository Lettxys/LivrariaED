package Livraria.SU;

public class Vendedor extends Usuario {
    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);
    }
    public boolean ehVendedor() { return true; }
}