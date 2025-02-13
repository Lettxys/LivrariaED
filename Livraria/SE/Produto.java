package Livraria.SE;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private int quantidade;
    private  double preco;
    private int nivelMinimo;

    public Produto(int id, String nome, String descricao, int quantidade, double preco, int nivelMinimo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.nivelMinimo = nivelMinimo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public int getNivelMinimo() {
        return nivelMinimo;
    }

    

    public void atualizarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public boolean verificarEstoqueMinimo() {
        return this.quantidade < this.nivelMinimo;
    }

    public void exibirDetalhes() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Nível Mínimo: " + nivelMinimo);
    }
}

