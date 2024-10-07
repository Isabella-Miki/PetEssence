<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="container"> 
    <form name="cadastrarespecie" action="EspecieCadastrar" method="POST" class="flex-column">
        <h2 align="center">Cadastro de Espécie</h2>

        <div class="form-group mt-3">
            <label for="idespecie">ID: </label>
            <input type="text" name="idespecie" id="idespecie" value="${especie.idEspecie}" readonly="readonly" class="form-control" />
        </div>
        <div class="form-group">

            <label for="nomespecie">Nome: </label>
            <input type="text" name="nomeespecie" id="nomeespecie" value="${especie.nomeEspecie}" size="50" maxlength="50" class="form-control" required/>
        </div>

        <div class="d-flex justify-content-between"> 
            <a href="index.jsp" class="btn btn-secondary"> Voltar</a>
            <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar" class="btn btn-primary"/>
        </div>
    </form>
</div>