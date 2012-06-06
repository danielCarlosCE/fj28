package br.com.fj28.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fj28.dao.ProdutoDAO;
import br.com.fj28.modelo.Produto;
import java.util.List;

/**
 *
 * @author danielcarlos
 */

@Resource
public class ProdutosController {
    
    private final ProdutoDAO dao;
    private final Result result;

    public ProdutosController(ProdutoDAO dao, Result result) {
        this.dao = dao;
        this.result = result;
    }      
    
    public List<Produto> lista(){
        return dao.listaTudo();
    }
    
    public void adiciona(Produto produto){
        dao.salva(produto);
        result.redirectTo(this).lista();
    }
    public void formulario(){}
  
}
