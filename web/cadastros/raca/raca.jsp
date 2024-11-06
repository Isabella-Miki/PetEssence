<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="main-wrapper p-5">
    <h2>Ra�a</h2>
    <div class="d-flex flex-row-reverse bd-highlight mb-3">
        <a href="${pageContext.request.contextPath}/RacaNovo" class="btn btn-primary my-3">Cadastrar Ra�a</a>
    </div>

    <table class="table" id="datatable">
        <thead class="thead-light">
            <tr>
                <th scope="col" class="w-25 text-center">ID</th>
                <th scope="col" class="w-50 text-center">Nome</th>
                <th scope="col" class="w-25 text-center">A��es</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="raca" items="${raca}">
                <tr>
                    <td class="text-center align-middle">${raca.idRaca}</td>
                    <td class="text-center align-middle">${raca.nomeRaca}</td>
                    <td class="text-center align-middle">
                        <div class="btn-group">
                            <button type="button" class="btn btn-secondary rounded" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-three-dots-vertical" viewBox="0 0 16 16">
                                  <path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0m0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0m0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0"/>
                                </svg>                   
                            </button>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/RacaCarregar?idRaca=${raca.idRaca}">Alterar</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/RacaExcluir?idRaca=${raca.idRaca}">Deletar</a>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>    
        </tbody>
    </table>
    
</div>

<script>
    $(document).ready(function () {
        $('#datatable').DataTable({
            "oLanguage": {
                "sSearch": "Buscar: ",
                "sProcessing": "Processando...",
                "sLengthMenu": "Mostrar _MENU_ registros",
                "sZeroRecords": "Nenhum registro encontrado.",
                "sInfo": "Mostrando de _START_ at� _END_ de _TOTAL_ registros",
                "sInfoEmpty": "Mostrado de 0 at� 0 de 0 registros",
                "sInfoFiltred": "",
                "sInfoPostFix": "",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "Primeiro",
                    "sPrevious": "Anterior",
                    "sNext": "Seguinte",
                    "sLast": "�ltimo"
                }
            }
        });
    });

</script>

<%@ include file="/footer.jsp" %>