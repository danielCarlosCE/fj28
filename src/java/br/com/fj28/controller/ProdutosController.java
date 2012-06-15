package br.com.fj28.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import br.com.fj28.autenticar.Restrito;
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
    private final Validator validator;

    public ProdutosController(ProdutoDAO dao, Result result, Validator validator) {
        this.dao = dao;
        this.result = result;
        this.validator = validator;
    }

    @Get @Path("/produtos")
    public List<Produto> lista() {
        return dao.listaTudo();
    }

    @Post @Path("/produtos")
    @Restrito
    public void adiciona(final Produto produto) {

        validarProduto(produto);

        dao.salva(produto);
        result.redirectTo(this).lista();
    }

    

    @Get @Path("/produtos/{id}")
    @Restrito
    public Produto edita(Long id) {
        return dao.carrega(id);
    }

    @Put @Path("/produtos/{produto.id}")
    @Restrito
    public void altera(Produto produto) {
        validarProduto(produto);
        dao.atualiza(produto);
        result.redirectTo(this).lista();
    }
    
    @Delete @Path("/produtos/{id}")
    @Restrito
    public void remove(Long id) {
        Produto p = dao.carrega(id);
        dao.exclui(p);
        result.redirectTo(this).lista();
    }
    
    @Get @Path("/produtos/novo")
    @Restrito
    public void formulario() {
    }
    
    public List<Produto> busca(String nome){
        result.include("nome",nome);
        return dao.busca(nome);
    }
    
    @Get @Path("/produtos/busca.json")
    public void buscaJson(String q){
        result.use(Results.json())
                .withoutRoot()
                .from(dao.busca(q))
                .exclude("id","descricao")
                .serialize();
    }
    
    //validação server-side
    private void validarProduto(Produto produto) {
        if (produto.getNome() == null || produto.getNome().length() < 3) {
            validator.add(new ValidationMessage("Nomé é obrigatório e precisa ter mais de 3 letras", "Campo nome"));
        }

        if (produto.getDescricao() == null || produto.getDescricao().length() < 40) {
            validator.add(new ValidationMessage("Descrição é obrigatória e precisa ter mais de 40 letras", "Campo descricao"));
        }

        if (produto.getPreco() == null || produto.getPreco() <= 0) {
            validator.add(new ValidationMessage("Preço precisa ser positivo", "Campo preco"));
        }

        validator.onErrorUsePageOf(this).formulario();
    }
}
