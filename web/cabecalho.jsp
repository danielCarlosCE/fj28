<%-- 
    Document   : cabecalho
    Created on : 06/06/2012, 11:41:58
    Author     : danielcarlos
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<c:url value="/css/base.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/css/menu.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/js/jquery/jquery.autocomplete.css" />" />
        <script type="text/javascript" src="<c:url value="/js/jquery/jquery-1.3.2.min.js"/>" > </script>
        <script type="text/javascript" src="<c:url value="/js/jquery/jquery.validate.min.js"/>" > </script>
        <script type="text/javascript" src="<c:url value="/js/jquery/jquery.autocomplete.js"/>" > </script>
        <script type="text/javascript" src="<c:url value="/js/jquery/jquery.autocomplete.min.js"/>" > </script>
        <script type="text/javascript" src="<c:url value="/js/jquery/jquery.puts.js"/>" > </script>


        <title>FJ28</title>
    </head>
    <body>
        <div id="header">

            <!--      MENU        -->
            <div class='cssmenu'>
                <ul>
                    <li class='active '><a href='/fj28'><span>Home</span></a></li>
                    <li><a href="<c:url value="/produtos"/>" ><span>Lista de Produtos</span></a></li>
                    <c:if test="${usuarioWeb.logado}" >
                        <li><a href="<c:url value="/produtos/novo"/>"><span>Novo Produto</span></a></li>
                    </c:if>
                    <li><a href='<c:url value="/contato.jsp"/>'><span>Contato</span></a></li>
                </ul>
            </div>
            <!--       ERRO         -->
            <div id="erros">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error.category } - ${error.message }</li>
                    </c:forEach>
                </ul>
            </div>

            <div id="usuario">
                <c:if test="${usuarioWeb.logado}" >
                    Olá ${usuarioWeb.nome}! <a href="<c:url value="/logout"/>">Logout</a>
                </c:if>
                <c:if test="${empty usuarioWeb or not usuarioWeb.logado}" >    
                    Você não está logado. <a href="<c:url value="/login"/>">Login</a>
                    <a href="<c:url value="/usuarios/novo"/>">Cadastre-se</a>
                </c:if>
            </div>


            <div id="buscaCarrinho">
                <!--       BUSCA         -->
                <form action="<c:url value="/produtos/busca" />" > 
                    <input id="busca" name="nome" /> 
                </form>

                <!--  CARRINHO      -->

                <div id="carrinho">
                    <a href="<c:url value="/carrinho"/>"><img src="<c:url value="/images/shoppingcart.png"/>" />
                        <c:if test="${empty carrinho or carrinho.totalDeItens eq 0 }">
                            <ul>
                                <li><strong>Itens:</strong> 0</li>
                                <li><strong>Total:</strong> 
                                    <fmt:formatNumber type="currency" value="0"/>
                                </li>

                            </ul>
                        </c:if>
                        <c:if test="${carrinho.totalDeItens > 0}" >
                            <ul>
                                <li><strong>Itens:</strong> ${carrinho.totalDeItens}</li>
                                <li><strong>Total:</strong> 
                                    <fmt:formatNumber type="currency" value="${carrinho.total}"/>
                                </li>

                            </ul>
                        </c:if>
                    </a>
                </div>
                <div id="clear"></div>
            </div> <!-- buscaCarrinho-->

        </div> <!-- HEADER -->

        <!--      SCRIPTS      -->
        <script type="text/javascript" >
            $("#busca").puts("Busca produtos por nome");
            
            $("#busca").autocomplete('/fj28/produtos/busca.json', {
                dataType: "json",
                parse: function(produtos) {
                    return $.map(produtos, function(produto) {
                        return {
                            data: produto,
                            value: produto.nome,
                            result: produto.nome
                        };
                    });
                },
                formatItem: function(produto) {
                    return produto.nome + "(" + produto.preco + ")";
                }
            });
        </script>
