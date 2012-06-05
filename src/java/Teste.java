


import br.com.fj28.dao.ProdutoDAO;
import br.com.fj28.modelo.Produto;
import br.com.fj28.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author danielcarlos
 */
public class Teste {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        
        Produto p = criaProduto();
        
        new ProdutoDAO().salva(p);
    }

   

    public static Produto criaProduto() {
        Produto p = new Produto();
        p.setNome("Cadeira");
        p.setDescricao("Cadeira Confortável");
        p.setPreco(70.0);
        return p;
    }

   
}
