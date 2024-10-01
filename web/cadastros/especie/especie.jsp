<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="main-wrapper p-5">
    <h2 class="text-center">Espécie</h2>
    <div class="d-flex flex-row-reverse bd-highlight mb-3">
        <a href="${pageContext.request.contextPath}/EspecieNovo" class="btn btn-primary my-3"> Cadastrar Espécie</a>
    </div>

    <table class="table" id="datatable">
        <thead class="thead-light">
            <tr>
                <th scope="col" class="w-25">ID</th>
                <th scope="col" class="w-50">Nome</th>
                <th scope="col" class="w-25 text-center">Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="especie" items="${especie}">
                <tr>
                    <td align="left">${especie.idEspecie}</td>
                    <td align="left">${especie.nomeEspecie}</td>
                    <td align="center">
                        <div class="btn-group">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                
                            </button>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/EspecieCarregar?idEspecie=${especie.idEspecie}">Alterar</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/EspecieExcluir?idEspecie=${especie.idEspecie}">Deletar</a>
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
                "sProcessing": "Processando...",
                "sLengthMenu": "Mostrar_MENU_registros",
                "sZeroRecords": "Nenhum registro encontrado.",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                "sInfoEmpty": "Mostrado de 0 até 0 de 0 registros",
                "sInfoFiltred": "",
                "sInfoPostFix": "",
                "sSearch": "Buscar: ",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "Primeiro",
                    "sPrevious": "Anterior",
                    "sNext": "Seguinte",
                    "sLast": "Último"
                }
            }
        });
    });

</script>

<%@ include file="/footer.jsp" %>