<%@include file="../cabecalho.jsp" %>
<form action="<c:url value="/produtos/${produto.id}"/>" method="POST">
            <fieldset>
                <legend> Editar Produto </legend>
                
                <label for="nome"> Nome: </label> <br />
                <input id="nome" type="text" name="produto.nome" value="${produto.nome}"/> <br />

                <label for="descricao">Descrição:</label> <br />
                <textarea id="descricao" name="produto.descricao">${produto.descricao}</textarea> <br />
                
                <label for="preco">Preço:</label> <br />
                <input id="preco" type="text" name="produto.preco" value="${produto.preco}"/> <br />


                <button type="submit" name="_method" value="PUT">Enviar</button>
            </fieldset>
        </form>
 <%@include file="../rodape.jsp" %>
