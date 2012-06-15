/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fj28.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.fj28.dao.UsuarioDAO;
import br.com.fj28.modelo.Usuario;
import br.com.fj28.modelo.UsuarioWeb;

/**
 *
 * @author danielcarlos
 */
@Resource
public class UsuariosController {

    private UsuarioDAO dao;
    private Result result;
    private Validator validator;
    private UsuarioWeb usuarioWeb;

    public UsuariosController(UsuarioDAO dao, Result result, Validator validator, UsuarioWeb usuarioWeb) {
        this.dao = dao;
        this.result = result;
        this.validator = validator;
        this.usuarioWeb = usuarioWeb;
    }

    @Post
    @Path("/usuarios")
    public void adiciona(Usuario usuario) {

        if (dao.existeUsuario(usuario)) {
            validator.add(new ValidationMessage("Login já existe", "Erro"));
        }
        validator.onErrorUsePageOf(this).novo();

        dao.adiciona(usuario);
        usuarioWeb.login(usuario);

        result.redirectTo(ProdutosController.class).lista();
    }

    public void novo() {
    }

    @Get
    @Path("/login")
    public void loginForm() {
    }

    @Post
    @Path("/login")
    public void login(Usuario usuario) {
        Usuario carregado = dao.carrega(usuario);
        if (carregado == null) {
            validator.add(new ValidationMessage("Login e/ou senha inválidos", "Erro"));
        }
        validator.onErrorUsePageOf(this).loginForm();

        usuarioWeb.login(carregado);

        result.redirectTo(ProdutosController.class).lista();
    }

    @Path("/logout")
    public void logout() {
        usuarioWeb.logout();
        result.redirectTo(ProdutosController.class).lista();
    }
}
