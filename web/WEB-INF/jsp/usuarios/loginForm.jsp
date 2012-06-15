<form id="formLogin" action="<c:url value="/login"/>" method="POST">
    <fieldset>
        <legend>Efetue o login</legend>
        <label for="login">Login:</label>
        <input id="login" class="required" type="text" name="usuario.login"/>
        <label for="senha">Senha:</label>
        <input id="senha" class="required" type="password" name="usuario.senha"/>
        <br />
        <button type="submit">Login</button>
    </fieldset>
</form>
    
    <script type="text/javascript">
        $('#formLogin').validate();
    </script>