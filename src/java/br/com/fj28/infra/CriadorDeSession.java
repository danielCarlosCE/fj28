/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fj28.infra;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author danielcarlos
 */
@Component
public class CriadorDeSession implements ComponentFactory<Session> {
    
    private final SessionFactory factory;
    private Session session;

    public CriadorDeSession(SessionFactory factory) {
        this.factory = factory;
    }    
    
    @PostConstruct
    public void abre(){
        this.session = factory.openSession();
      
    }
    
    @Override
    public Session getInstance() {
        return session;
    }
    
    @PreDestroy
    public void fecha(){
        session.close();
      
    }
}
