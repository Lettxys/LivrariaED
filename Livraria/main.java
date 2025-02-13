package Livraria;

import Livraria.SU.Usuario;
import Livraria.SU.UsuarioServices;

public class Main {
    public static void main(String args[]) {
        int id = LoginSystem.iniciar();
        Usuario User = UsuarioServices.BuscarUsuarioPorId(id);
        System.out.println("Bem vindo, " + User.getNome());
    }
}