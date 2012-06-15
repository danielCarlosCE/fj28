package br.com.fj28.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danielcarlos
 */
@Component
@SessionScoped
public class Carrinho {
    private List<Item> itens = new ArrayList<Item>();
    private Double total = 0.0;

    public List<Item> getItens() {
        return itens;
    }
    
    
    
    
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void adiciona(Item item) {
        boolean naoEstaNoCarrinho = true;
        for(Item i:itens){
            if(i.getProduto().getId()==(item.getProduto().getId())){
                i.setQuantidade(item.getQuantidade()+i.getQuantidade());
                naoEstaNoCarrinho = false;
            }
        }
        if(naoEstaNoCarrinho)
            itens.add(item);
        
        total += item.getProduto().getPreco()*item.getQuantidade();
    }
    public Integer getTotalDeItens(){
        return this.itens.size();
                
    }

    public void remove(int indiceItem) {
        Item removido = itens.remove(indiceItem);
        total -= removido.getProduto().getPreco() * removido.getQuantidade();     
    }
    
    public boolean jaEstaNoCarrinho(Item item){
        
        
        return false;
    }
    
}
