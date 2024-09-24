<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div align="center" class="container">
    <h2>Especie</h2>

<a href="${pageContext.request.contextPath}/EspecieNovo" align="center"> Cadastrar Especie</a>

<table id="datatable" class="display">
    <thead>
        <tr>
            <th align="left">ID</th>
            <th align="left">Nome</th>
            <th align="right"></th>
            <th align="right"></th>
        </tr>    
    </thead>
    <tbody>
        <c:forEach var="especie" items="${especie}">
            <tr>
                <td align="left">${especie.idEspecie}</td>
                <td align="left">${especie.nomeEspecie}</td>
                <td align="center">
                    <a href="${pageContext.request.contextPath}/EspecieExcluir?idEspecie=${especie.idEspecie}">
                        Excluir
                    </a>
                </td>
                <td align="center">
                    <a href="${pageContext.request.contextPath}/EspecieCarregar?idEspecie=${especie.idEspecie}">
                        Alterar 
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>

</table>
<div align="center">
    <a href="index.jsp">Voltar à página inicial </a>
</div>
</div>




<script>
    $(document).ready(function () {
        console.log('entrei ready');
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