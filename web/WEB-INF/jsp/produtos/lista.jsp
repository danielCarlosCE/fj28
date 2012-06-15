<%--<%@include file="../cabecalho.jsp" %>--%>
<div id="conteudo">
    <c:if test="${not empty produtoList}">
    <h3>Lista de Produtos</h3>
    <table >
        <thead>
            <tr>
                <td>Nome</td>
                <td>Descrição</td>
                <td>Preço</td>
                <td class="compra">Comprar</td>
                <td colspan="2"></td>
            </tr>
        </thead>
        <tbody>
            <% int cont = 0;%>
            <c:forEach items="${produtoList}" var="produto">
                <tr class="<%=(cont % 2 == 0 ? "linhaEscura" : "linhaClara")%>" >
                    <td >${produto.nome}</td>
                    <td>${produto.descricao}</td>
                    <td>${produto.preco}</td>

                    <td class="compra">
                        <form action="<c:url value="/carrinho"/>" method="POST">
                            <input type="hidden" name="item.produto.id" 
                                   value="${produto.id}" />
                            <input class="qtde" name="item.quantidade" value="1"/>
                            <button class="link" type="submit">Comprar</button>
                        </form>
                    </td>
                    <c:if test="${usuarioWeb.logado}" >
                        <td><a class="botesTabela" href="<c:url value="/produtos/${produto.id}"/>">Editar</a></td>
                        <td>
                            <form action="<c:url value="/produtos/${produto.id}"/>" method="POST">
                                <button class="link" name="_method" value="DELETE">Remover</button>
                            </form>
                        </td>
                    </c:if>
                </tr>    
                <% cont++;%>
            </c:forEach>

        </tbody>
    </table>
    </c:if>
    <c:if test="${ empty produtoList}">
        <h3> Nenhum produto cadastrado </h3>
    </c:if>
</div>
<%--<%@include file="../rodape.jsp" %>--%>

