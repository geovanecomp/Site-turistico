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
					 <c:choose>
						<c:when test="${empty circuito}">
							<font color = 'red'>Circuito ainda não criado</font>
						</c:when>
						<c:otherwise>
							<table>
								<tr><td align = 'center'><h3><strong>Informações do circuito selecionado:</strong></h3></td></tr>
								<tr><td><h4><label>Nome: </label>${circuito.nome}</h4></td></tr>
								<tr><td><h4><label>Data: </label><fmt:formatDate value="${circuito.data}" pattern="dd/MM/yyyy"/></h4></td></tr>
								<tr><td><h4><label>Descrição: </label>${circuito.descricao}</h4></td></tr>
							</table>
							<c:choose>
								<c:when test = "${empty listaTrajetosEmpresa and empty listaTrajetosPontoTuristico}">
									<center><strong>Não existe trajeto adicionado a este circuito.</strong></center>
								</c:when>
								<c:otherwise>
									<center><strong>Meus trajetos:</strong></center>
									<c:choose>
										<c:when test="${not empty listaTrajetosEmpresa}">
											<c:forEach var = "elementosTodosTrajetosEmpresa" items = "${listaTrajetosEmpresa}">
												<center><table border ='3' width="600" style="border-color:  #22AAFF">
													<tr>
														<td width = "200" align = 'center'><a href = 'BuscarEmpresaPeloIdController.do?idEmpresa=${elementosTodosTrajetosEmpresa.idEmpresa}&verificador=1'> ${elementosTodosTrajetosEmpresa.nome}<br /></a></td>
														<td width = "200" align = 'center'><a href = '#' onclick='certezaEmpresa(${elementosTodosTrajetosEmpresa.idEmpresa})'>Deletar esta empresa</a></td>
													</tr>
												</table></center>
												<br />
											</c:forEach>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${not empty listaTrajetosPontoTuristico}">
											<c:forEach var = "elementosTodosTrajetosPontoTuristico" items = "${listaTrajetosPontoTuristico}">
												<center><table border ='3' width="600" style="border-color:  #22AAFF">
													<tr>
														<td width = "200" align = 'center'><a href = 'BuscarPontoTuristicoPeloIdController.do?idPontoTuristico=${elementosTodosTrajetosPontoTuristico.idPontoTuristico}&verificador=1'> ${elementosTodosTrajetosPontoTuristico.nome}<br /></a></td>
														<td width = "200" align = 'center'><a href = '#' onclick='certezaPontoTuristico(${elementosTodosTrajetosPontoTuristico.idPontoTuristico})'>Deletar este Ponto Turístico</a></td>
													</tr>
												</table></center>
												<br />
											</c:forEach>
										</c:when>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>