package br.com.fj28.autenticar;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.fj28.controller.UsuariosController;
import br.com.fj28.modelo.UsuarioWeb;

/**
 *
 * @author danielcarlos
 */
@Intercepts
public class AutenticacaoInterceptor implements Interceptor {

    private final UsuarioWeb usuarioWeb;
    private final Result result;
    private final Validator validator;

    public AutenticacaoInterceptor(UsuarioWeb usuarioWeb, Result result, Validator validator) {
        this.usuarioWeb = usuarioWeb;
        this.result = result;
        this.validator = validator;
    }

    @Override
    public void intercept(InterceptorStack is, ResourceMethod rm, Object o) throws InterceptionException {
        validator.add(new ValidationMessage("Você não tem permissão. Faça o login primeiro!","Acesso Negado"));
        validator.onErrorUsePageOf(UsuariosController.class).loginForm();
//        result.redirectTo(UsuariosController.class).loginForm();
    }

    @Override
    public boolean accepts(ResourceMethod rm) {
       return !this.usuarioWeb.isLogado() && rm.containsAnnotation(Restrito.class);
       
    
    }
}
