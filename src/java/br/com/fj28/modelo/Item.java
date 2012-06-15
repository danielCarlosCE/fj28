/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fj28.modelo;

/**
 *
 * @author danielcarlos
 */
public class Item {

    private Produto produto;
    private Integer quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
