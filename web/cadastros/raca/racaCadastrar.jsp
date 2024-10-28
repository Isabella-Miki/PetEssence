<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="p-4 d-flex align-items-center justify-content-start flex-column"> 
    <form name="cadastrarraca" action="RacaCadastrar" method="POST" class="flex-column">
        <h2 align="center">Cadastro de Raça</h2>
        <div class="form-group mt-3">
            <c:if test="${raca.idRaca != 0}">

                <label for="ideraca">ID: </label>
                <input type="text" name="idraca" id="idraca" value="${raca.idRaca}" readonly="readonly" class="form-control" />
            </c:if>
            <c:if test="${raca.idRaca == 0}">
                <input type="hidden" name="idraca" id="idraca" value="${raca.idRaca}" readonly="readonly" class="form-control" />
            </c:if>
        </div>
        <div class="form-group">

            <label for="nomeraca">Nome: </label>
            <input type="text" name="nomeraca" id="nomeraca" value="${raca.nomeRaca}" size="50" maxlength="50" class="form-control" required/>
        </div>

        <div class="d-flex justify-content-between"> 
            <a href="EspecieListar" class="btn btn-secondary">Voltar</a>
            <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar" class="btn btn-primary"/>
        </div>
    </form>
</div>

        