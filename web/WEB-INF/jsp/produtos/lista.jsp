<%--<%@include file="../cabecalho.jsp" %>--%>
<div id="conteudo">
    <table >
        <thead>
            <tr>
                <td>Nome</td>
                <td>Descrição</td>
                <td>Preço</td>
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
                    <td><a class="botesTabela" href="<c:url value="/produtos/${produto.id}"/>">Editar</a></td>
                    <td>
                        <form action="<c:url value="/produtos/${produto.id}"/>" method="POST">
                            <button class="link" name="_method" value="DELETE">Remover</button>
                        </form>
                    </td>
                </tr>    
                <% cont++;%>
            </c:forEach>

        </tbody>
    </table>
</div>
<%--<%@include file="../rodape.jsp" %>--%>

