<form id="usuariosForm" action="<c:url value="/usuarios"/>" method="POST" >
    
    <fieldset>
        <legend> Cadastrar novo usuário </legend>
        
        <label for="nome">Nome: </label>
        <input id="nome" 
               class="required" 
               type="text" name="usuario.nome" value="${usuario.nome}" />
        <label for="login">Login: </label>
        <input id="login" 
               class="required" 
               type="text" name="usuario.login" value="${usuario.login}" />
        <label for="senha">Senha: </label>
        <input id="senha" 
               class="required" 
               type="password" name="usuario.senha" value="${usuario.senha}" />
        <label for="confirmacao">Confirmar senha: </label>
        <input id="confirmacao" equalTo="#senha" type="password" />
        <br />
        <button type="submit"> Enviar </button>
        
    </fieldset>
    
</form>
        
        <script type="text/javascript">$('#usuariosForm').validate();</script>
