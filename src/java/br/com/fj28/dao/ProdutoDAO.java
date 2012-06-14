package br.com.fj28.dao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fj28.modelo.Produto;
import br.com.fj28.infra.CriadorDeSession;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author danielcarlos
 */

@Component
public class ProdutoDAO {
    
    private final Session session;

    public ProdutoDAO(Session session) {
        this.session = session;
    }   
    public void salva(Produto p) {
        Transaction transaction = session.beginTransaction();
        session.save(p);
        transaction.commit();
    }
    public void atualiza(Produto p){
        Transaction transaction = session.beginTransaction();
        session.update(p);
        transaction.commit();
    }
    public void exclui(Produto p){
        Transaction transaction = session.beginTransaction();
        session.delete(p);
        transaction.commit();
    }
    public List<Produto> listaTudo(){
        return this.session.createCriteria(Produto.class).list();
    }

    public Produto carrega(Long id) {
        return (Produto) this.session.load(Produto.class, id);
    }

    public List<Produto> busca(String nome) {
        return this.session.createCriteria(Produto.class)
                .add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
                .list();
    }
}
