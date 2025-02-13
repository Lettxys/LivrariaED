package Livraria.SE;

class Livro extends Produto {
    private String autor;
    private String editora;
    private int numeroPaginas;

    public Livro(int id, String nome, String descricao, int quantidade, double preco, int nivelMinimo, String autor, String editora, int numeroPaginas) {
        super(id, nome, descricao, quantidade, preco, nivelMinimo);
        this.autor = autor;
        this.editora = editora;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Autor: " + autor);
        System.out.println("Editora: " + editora);
        System.out.println("Número de Páginas: " + numeroPaginas);
    }
}
