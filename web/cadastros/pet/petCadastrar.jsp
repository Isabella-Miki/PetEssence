<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="p-4 d-flex align-items-center justify-content-start flex-column"> 
    <form name="cadastrarpet" action="PetCadastrar" method="POST" class="flex-column">
        <h2 align="center">Cadastro do Pet</h2>
        <div class="form-group mt-3">
            <c:if test="${pet.idPet != 0}">

                <label for="idpet">ID: </label>
                <input type="text" name="idpet" id="idpet" value="${pet.idPet}" readonly="readonly" class="form-control" />
            </c:if>
            <c:if test="${pet.idPet == 0}">
                <input type="hidden" name="idpet" id="idpet" value="${pet.idPet}" readonly="readonly" class="form-control" />
            </c:if>
        </div>
        <div class="form-group">

            <label for="nomepet">Nome: </label>
            <input type="text" name="nomepet" id="nomepet" value="${pet.nomePet}" size="50" maxlength="50" class="form-control" required/>
        </div>
        
        <div class="form-group">
            <label for="idespecie">Espécie: </label>
            <select name="idespecie" id="idespecie" class="form-control" required>
                <option value="">Selecione</option>
                <c:forEach var="especie" items="${especies}">
                    <option value="${especie.idEspecie}" 
                        ${pet.especie.idEspecie == especie.idEspecie ? "selected" : ""}>
                        ${especie.nomeEspecie}
                    </option>
                </c:forEach>
            </select>
        </div>
        
        <div class="form-group">
            <label for="idraca">Raça: </label>
            <select name="idraca" id="idraca" class="form-control" required>
                <option value="">Selecione</option>
                <c:forEach var="raca" items="${racas}">
                    <option value="${raca.idRaca}" 
                        ${pet.raca.idRaca == raca.idRaca ? "selected" : ""}>
                        ${raca.nomeRaca}
                    </option>
                </c:forEach>
            </select>
        </div>
        
        <input type="hidden" name="situacao" id="situacao" value="${pet.situacao}" readonly="readonly" />
        
        <div class="d-flex justify-content-between"> 
            <a href="PetListar" class="btn btn-secondary">Voltar</a>
            <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar" class="btn btn-primary"/>
        </div>
    </form>
</div>

        