<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarespecie" action="EspecieCadastrar" method="POST">
    <table algin="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">Cadastro de Especie</th>
            </tr>
            <tr>
                <th colspan="2" align="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ID: </td>
                <td><input type="text" name="idespecie" id="idespecie" value="${especie.idEspecie}" readonly="readonly" /> </td>
            </tr>

            <tr>
                <td>Nome: </td>
                <td><input type="text" name="nomeespecie" id="nomeespecie" value="${especie.nomeEspecie}" size="50" maxlength="50" /> </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar"/>
                    <input type="reset" name="limpar" id="limpar" value="Limpar" />
                    
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                            <h5><a href="index.jsp">
                        Voltar a home
                        </a></h5>
                </td>
            </tr>
            
        </tbody>
    </table>
</form>

<%@ include file="/footer.jsp" %>