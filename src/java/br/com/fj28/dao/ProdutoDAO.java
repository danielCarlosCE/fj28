package br.com.fj28.dao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fj28.modelo.Produto;
import br.com.fj28.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author danielcarlos
 */

@Component
public class ProdutoDAO {
    
    private final Session session;

    public ProdutoDAO() {
        this.session = HibernateUtil.getSession();
    }   
    public void salva(Produto p) {
        Transaction transaction = session.beginTransaction();
        session.save(p);
        transaction.commit();
    }
    public void edita(Produto p){
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
}
