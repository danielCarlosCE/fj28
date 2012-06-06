<%-- 
    Document   : formulario
    Created on : 05/06/2012, 21:15:16
    Author     : danielcarlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Produto</title>
    </head>
    <body>
        <form action="adiciona">
            <fieldset>
                <legend> Adicionar Produto </legend>
               
                <label for="nome"> Nome: </label> <br />
                <input id="nome" type="text" name="produto.nome"/> <br />

                <label for="descricao">Descrição:</label> <br />
                <textarea id="descricao" name="produto.descricao"></textarea> <br />
                
                <label for="preco">Preço:</label> <br />
                <input id="preco" type="text" name="produto.preco"/> <br />


                <button type="submit">Enviar</button>
            </fieldset>
        </form>
    </body>
</html>
