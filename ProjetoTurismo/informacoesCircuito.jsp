<%@page import="entities.Circuito"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file = "head.jsp" %>
<body>
<%@ include file = "header.jsp" %>
<script type = "text/javascript">
	function certezaEmpresa(idEmpresa){
		if(confirm("Deseja realmente deletar este trajeto?")){
			document.location.href = 'DeletarTrajetoController.do?idEmpresa='+idEmpresa;  
			return true;
		}
		return false;
	}
	
	function certezaPontoTuristico(idPontoTuristico){
		if(confirm("Deseja realmente deletar este trajeto?")){
			document.location.href = 'DeletarTrajetoController.do?idPontoTuristico='+idPontoTuristico;  
			return true;
		}
		return false;
	}
	
</script>
<div id="wrapper">
	<div id="page-wrapper">
		<div id="page">
			<div id="wide-content">
				<div>
					<c:choose>
						<c:when test="${not empty status}">
							<strong><font color = 'red'>${status}</font></strong>
						</c:when>
					</c:choose>
					<table>
						<tr><td align = 'center'><h3><strong>Informações do circuito selecionado:</strong></h3></td></tr>
						<tr><td><h4><label>Nome: </label>${circuito.nome}</h4></td></tr>
						<tr><td><h4><label>Data: </label><fmt:formatDate value="${circuito.data}" pattern="dd/MM/yyyy"/></h4></td></tr>
						<tr><td><h4><label>Descrição: </label>${circuito.descricao}</h4></td></tr>
					</table>
					<center><br /><h3><strong>Meus trajetos:</strong></h3><br /></center>
					<c:choose>
						<c:when test="${not empty listaTrajetosEmpresa}">
							<c:forEach var = "elementosTodosTrajetosEmpresa" items = "${listaTrajetosEmpresa}">
								<ul class="style3">							
									<li><center><a href = 'BuscarEmpresaPeloIdController.do?idEmpresa=${elementosTodosTrajetosEmpresa.idEmpresa}&verificador=1'><b><font color = 'black'> ${elementosTodosTrajetosEmpresa.nome}</font></b></a>
									<p></p><a href = '#' onclick='certezaEmpresa(${elementosTodosTrajetosEmpresa.idEmpresa})'><b><font color = 'black'>Deletar este trajeto</font></b></a></center></li>
								</ul>
							</c:forEach>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${not empty listaTrajetosPontoTuristico}">
							<c:forEach var = "elementosTodosTrajetosPontoTuristico" items = "${listaTrajetosPontoTuristico}">
								<ul class="style3">							
									<li><center><a href = 'BuscarPontoTuristicoPeloIdController.do?idPontoTuristico=${elementosTodosTrajetosPontoTuristico.idPontoTuristico}:&verificador=1'><b><font color = 'black'> ${elementosTodosTrajetosPontoTuristico.nome}</font></b></a>
									<p></p><a href = '#' onclick='certezaPontoTuristico(${elementosTodosTrajetosPontoTuristico.idPontoTuristico})'><b><font color = 'black'>Deletar este trajeto</font></b></a></center></li>
								</ul>
							</c:forEach>
						</c:when>
					</c:choose>
					<form action ='SelecionarCircuitoController.do' method ='post' name = 'selecionarCircuito' id = 'selecionarCircuito'>
						<input type = 'hidden' name = 'idCircuito' id = 'idCircuito' value ='${circuito.idCircuito}'/>
						<input type = 'submit' class="button-style" name = 'selecionarCircuito' id ='selecionarCircuito' value = 'Selecionar este circuito'/>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>