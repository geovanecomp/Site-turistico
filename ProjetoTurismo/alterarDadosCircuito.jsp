<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file = "head.jsp" %>
<body>
<%@ include file = "header.jsp" %>
<div id="wrapper">
	<div id="page-wrapper">
		<div id="page">
			<div id="wide-content">
				<div>
					<center><h2>Alteração de circuito:</h2></center>
					<c:choose>
						<c:when test="${not empty status}">
							<font color = 'red'>${status}</font>
						</c:when>
					</c:choose>
					<form action = 'AlterarDadosCircuitoController.do' method = 'post' name = 'alterarCircuito' id = 'alterarCircuito'>
						<table align = "center">
						<tr><td><h4><label>Nome: </label></h4>
						<input type = 'text' name = 'nome' id ='nome' maxlength ='100' size = '30' onblur="validarTamanho('nome')"value = '${circuito.nome}'/></td></tr>
						<tr><td><h4><label>Data de realização: </label></h4>
						<input type = 'text' name = 'data' id ='data' maxlength ='10' size = '11' onkeypress="dateMask(this, event);" value = '<fmt:formatDate value="${circuito.data}" pattern="dd/MM/yyyy"/>'/></td></tr>
						<tr><td><h4><label>Descrição:</label></h4>
						<textarea rows = '5' cols ='50' name = 'descricao' id = 'descricao' onblur="validarTamanho('descricao')">${circuito.descricao}</textarea></td></tr>
						<tr><td><input type = 'hidden' name ='idUsuario' id = 'idUsuario' value = '${usuarioSessao.idUsuario}'/></td>
						<td><input type = 'hidden' name ='idCircuito' id = 'idCircuito' value = '${circuito.idCircuito}'/></td>
						<tr><td><center><input type = 'submit' class="button-style" name ='alterar' id = 'alterar' value = 'Alterar'></center></td></tr>
						</table>
						
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>