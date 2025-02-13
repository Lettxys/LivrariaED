package Livraria.SV;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Livraria.SE.Produto;

public class Pedido {
     private int id;
     private Cliente cliente;
     private List<ItemPedido> itens = new ArrayList<>();
     private double valorTotal;
     private LocalDate dataPedido;
     private boolean finalizado;

    public Pedido(int id, Cliente cliente){
        this.id = id;
        this.cliente = cliente;
        this.dataPedido = LocalDate.now(); // Data atual
        this.finalizado = false;
    }
    
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public boolean isFinalizado() {
        return finalizado;
    }
    
    public void adicionarItens(Produto produto, int quantidade){
       if (finalizado) {
         throw new IllegalStateException("Pedido finalizado, não é possível adicionar itens.");
       }
       if(quantidade <= 0){
         throw new IllegalArgumentException("Quantidade inválida, deve ser maior que 0!");
       }

       ItemPedido item = new ItemPedido(quantidade, produto);
       itens.add(item);
       calcularValorTotal();
    }

    public void removerItem(int idProduto){
        if (finalizado) {
         throw new IllegalStateException("Pedido finalizado, não é possível remover itens.");
       }
       itens.removeIf(item -> item.getProduto().getId() == idProduto);
       calcularValorTotal();
    }

    public void calcularValorTotal(){
        valorTotal = 0;
        for (ItemPedido item : itens) {
            valorTotal += item.getSubTotal();
        }
    }

    public void finalizarPedido(){
        if (finalizado) {
            throw new IllegalStateException("Este pedido já foi finalizado!");
          }
        if (itens.isEmpty()) {
                throw new IllegalStateException("Pedido não pode ser finalizado sem itens.");
         }
            finalizado = true;
            System.out.println("Pedido #" + id + " finalizado com sucesso!");

            for (ItemPedido item : itens) {
                RelatorioVendas.gerarRelatorio(
                    item.getProduto().getNome(),
                    item.getQuantidade(),
                    item.getSubTotal()
                );
            }
    }

    public void exibirDetalhes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("=== Detalhes do Pedido ===");
        System.out.println("ID: " + getId());
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Data: " + dataPedido.format(formatter));
        System.out.println("Itens:");

        for (ItemPedido item : itens) {
            System.out.println("- " + item.getProduto().getNome() + 
                " x" + item.getQuantidade() + 
                " (Subtotal: R$ " + String.format("%.2f", item.getSubTotal()) + ")");
        }

        System.out.println("Valor Total: R$ " + String.format("%.2f", valorTotal));
        System.out.println("Status: " + (finalizado ? "Finalizado" : "Em aberto"));
    }

}
