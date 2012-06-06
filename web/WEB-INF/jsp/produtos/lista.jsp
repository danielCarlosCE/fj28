<%-- 
    Document   : produtos
    Created on : 05/06/2012, 19:33:23
    Author     : danielcarlos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <style type="text/css">
            table { border-collapse: collapse;  margin: auto;}
            td    { border: 1px solid black; padding: 10px;}
            thead { background: burlywood; color: black;font-weight: bold}
            #conteudo{margin: auto; width: 600px;}
        </style>
        
        <title>Produtos</title>
        <!--        <link href="../../css/base.css" rel="stylesheet" type="text/css" />-->
    </head>
    <body>
        <div id="conteudo">
            <table>
                <thead>
                    <tr>
                        <td>Nome</td>
                        <td>Descrição</td>
                        <td>Preço</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${produtoList}" var="produto">
                        <tr>
                            <td>${produto.nome}</td>
                            <td>${produto.descricao}</td>
                            <td>${produto.preco}</td>
                        </tr>    
                       
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </body>
</html>
