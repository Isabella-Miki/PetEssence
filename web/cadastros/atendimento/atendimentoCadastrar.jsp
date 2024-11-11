<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="p-4 d-flex align-items-center justify-content-start flex-column"> 
    <form name="cadastraratendimento" action="AtendimentoCadastrar" method="POST" class="flex-column">
        <h2 align="center">Cadastro de Atendimento</h2>
        <div class="form-group mt-3">
            <c:if test="${atendimento.idAtendimento != 0}">
                <label for="idatendimento">ID: </label>
                <input type="text" name="idatendimento" id="idatendimento" value="${atendimento.idAtendimento}" readonly="readonly" class="form-control" />
            </c:if>
            <c:if test="${atendimento.idAtendimento == 0}">
                <input type="hidden" name="idatendimento" id="idatendimento" value="${atendimento.idAtendimento}" readonly="readonly" class="form-control" />
            </c:if>
        </div>
        <div class="form-group">
            <label for="descricao">Descrição: </label>
            <input type="text" name="descricao" id="descricao" value="${atendimento.descricao}" size="200" maxlength="200" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="nomeveterinario">Nome do Veterinário: </label>
            <input type="text" name="nomeveterinario" id="nomeveterinario" value="${atendimento.nomeVeterinario}" size="100" maxlength="100" class="form-control" required/>
        </div>

        <div class="form-group">
            <label for="dataatendimento">Data do atendimento:</label>
            <input type="date" name="dataatendimento" id="dataatendimento" value="${atendimento.dataAtendimento}" class="form-control" required/>
        </div>

        <div class="form-group">
            <label for="horario">Horário do atendimento:</label>
            <input type="time" name="horario" id="horario" value="${atendimento.horario}" class="form-control" required/>
        </div>


        <div class="form-group">
            <label for="duracao">Duração do atendimento:</label>
            <input type="time" name="duracao" id="duracao" value="${atendimento.duracao}" class="form-control" required/>
        </div>

        <div class="form-group">
            <label for="valor">Valor atendimento:</label>
            <input type="text" name="valor" id="valor" value="${atendimento.valor}" class="form-control" required/>
        </div>


        <div class="form-group">
            <label for="idpet">Pet: </label>
            <select name="idpet" id="idpet" class="form-control" required>
                <option value="">Selecione</option>
                <c:forEach var="pet" items="${pets}">
                    <option value="${pet.idPet}" 
                            ${atendimento.pet.idPet == pet.idPet? "selected" : ""}>
                        ${pet.nomePet}
                    </option>
                </c:forEach>
            </select>
        </div>
        
        <div class="d-flex justify-content-between"> 
            <a href="AtendimentoListar" class="btn btn-secondary">Voltar</a>
            <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar" class="btn btn-primary"/>
        </div>
    </form>
</div>

