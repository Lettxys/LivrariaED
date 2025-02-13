package Livraria.SV;

import Livraria.SE.Produto;

public class ItemPedido {
    private int quantidade;
    private Produto produto;
    private double subTotal;

    public ItemPedido(int quantidade, Produto produto){
        this.quantidade = quantidade;
        this.produto = produto;
        calcularSubTotal();
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public Produto getProduto(){
        return produto;
    }
  
    public void calcularSubTotal(){
        this.subTotal = this.quantidade * this.produto.getPreco();
    }

    public double getSubTotal(){
        return subTotal;
    }
}
