<%-- 
    Document   : cabecalho
    Created on : 06/06/2012, 11:41:58
    Author     : danielcarlos
--%>

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
        <div id="header"></div>

        <div class='cssmenu'>
            <ul>
                <li class='active '><a href='/fj28'><span>Home</span></a></li>
                <li><a href="<c:url value="/produtos"/>" ><span>Lista de Produtos</span></a></li>
                <li><a href="<c:url value="/produtos/novo"/>"><span>Novo Produto</span></a></li>
                <li><a href='#'><span>Contato</span></a></li>
            </ul>
        </div>

        <div id="erros">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error.category } - ${error.message }</li>
                </c:forEach>
            </ul>
        </div>

        <form action="<c:url value="/produtos/busca" />" > 
            <input id="busca" name="nome" /> 
        </form>

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
