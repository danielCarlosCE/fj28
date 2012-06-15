/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fj28.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 *
 * @author danielcarlos
 */
@SessionScoped
@Component
public class UsuarioWeb {
    private Usuario logado;
    
    public void login(Usuario usuario){
        this.logado = usuario;
    }
    
    public String getNome(){
        return logado.getNome();
    }
    public boolean isLogado(){
        return logado != null;
    }

    public void logout() {
        logado = null;
    }
}
