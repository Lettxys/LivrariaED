package Livraria.SV;

public class Cliente {
        public int id;
        public String nome;
        public String contato;
        public String endereco;
    
        public Cliente(int id, String nome, String contato, String endereco) {
            this.id = id;
            this.nome = nome;
            this.contato = contato;
            this.endereco = endereco;
        }
    
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public String getContato() {
            return contato;
        }
    
        public void setContato(String contato) {
            this.contato = contato;
        }
    
        public String getEndereco() {
            return endereco;
        }
    
        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }
    
        public void imprimir() {
            System.out.println("ID: " + id);
            System.out.println("Nome: " + nome);
            System.out.println("Contato: " + contato);
            System.out.println("Endereço: " + endereco);
        }
    }
    

