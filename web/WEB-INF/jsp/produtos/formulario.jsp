<%@include file="../cabecalho.jsp" %>
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
