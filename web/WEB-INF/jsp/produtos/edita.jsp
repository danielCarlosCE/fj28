<%@include file="../cabecalho.jsp" %>
       <form action="altera">
            <fieldset>
                <legend> Editar Produto </legend>
               
                <input type="hidden" name="produto.id" value="${produto.id}" />
                
                <label for="nome"> Nome: </label> <br />
                <input id="nome" type="text" name="produto.nome" value="${produto.nome}"/> <br />

                <label for="descricao">Descri��o:</label> <br />
                <textarea id="descricao" name="produto.descricao">${produto.descricao}</textarea> <br />
                
                <label for="preco">Pre�o:</label> <br />
                <input id="preco" type="text" name="produto.preco" value="${produto.preco}"/> <br />


                <button type="submit">Enviar</button>
            </fieldset>
        </form>
    </body>
</html>
