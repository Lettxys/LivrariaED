package Livraria.SE;

import java.util.ArrayList;
import java.util.List;

class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public void registrarEntrada(int id, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.atualizarQuantidade(quantidade);
                System.out.println("Entrada registrada: " + quantidade + " unidades de " + produto.getNome());
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void registrarSaida(int id, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                if (produto.getQuantidade() >= quantidade) {
                    produto.atualizarQuantidade(-quantidade);
                    System.out.println("Saída registrada: " + quantidade + " unidades de " + produto.getNome());
                } else {
                    System.out.println("Estoque insuficiente.");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void verificarAlertasEstoqueMinimo() {
        for (Produto produto : produtos) {
            if (produto.verificarEstoqueMinimo()) {
                System.out.println("ALERTA: O produto " + produto.getNome() + " está abaixo do nível mínimo de estoque.");
            }
        }
    }

    public void gerarRelatorioMovimentacao() {
        System.out.println("Relatório de Produtos no Estoque:");
        for (Produto produto : produtos) {
            produto.exibirDetalhes();
            System.out.println("-------------------------");
        }
    }
}
