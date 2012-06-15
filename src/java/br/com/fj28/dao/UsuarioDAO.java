package br.com.fj28.dao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fj28.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author danielcarlos
 */
@Component
public class UsuarioDAO {
    private Session session;

    public UsuarioDAO(Session session) {
        this.session = session;
    }

    public boolean existeUsuario(Usuario usuario) {
        Usuario encontrado = (Usuario)session.createCriteria(Usuario.class)
                .add(Restrictions.eq("login",usuario.getLogin()))
                .uniqueResult();
        return encontrado != null;
    }

    public void adiciona(Usuario usuario) {
        Transaction tx  = this.session.beginTransaction();
        this.session.save(usuario);
        tx.commit();
    }

    public Usuario carrega(Usuario usuario) {
        return (Usuario) session.createCriteria(Usuario.class)
                .add(Restrictions.eq("login",usuario.getLogin()))
                .add(Restrictions.eq("senha",usuario.getSenha()))
                .uniqueResult();
    }
    
    
}
