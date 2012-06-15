package br.com.fj28.controller;

import br.com.caelum.vraptor.*;
import br.com.fj28.dao.ProdutoDAO;
import br.com.fj28.modelo.Carrinho;
import br.com.fj28.modelo.Item;

/**
 *
 * @author danielcarlos
 */
@Resource
public class CarrinhoController {
    private Carrinho carrinho;
    private ProdutoDAO dao;
    private Result result;
    
    
    public CarrinhoController(Carrinho carrinho, ProdutoDAO dao, Result result) {
        this.carrinho = carrinho;
        this.dao = dao;
        this.result = result;
    }
    
    @Post @Path("/carrinho")
    public void adiciona(Item item){
        dao.recarrega(item.getProduto());
        carrinho.adiciona(item);
        
        result.redirectTo(this).visualiza();
    }
    
    @Get @Path("/carrinho")
    public void visualiza(){
        
    }
    
    @Delete @Path("/carrinho/{indiceItem}")
    public void remove(int indiceItem){
        carrinho.remove(indiceItem);
        result.redirectTo(this).visualiza();
    }
}
