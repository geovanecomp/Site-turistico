<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div id="header-wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">meu lazer.com</a></h1>
			<c:choose>
				<c:when test="${not empty circuitoSessao}">
					<strong><font color = 'white'>Circuito: ${circuitoSessao.nome} selecionado</font></strong>
				</c:when>
			</c:choose>
		</div>
		<div id="menu">
			<ul>
				<li><a href="BuscarNovosAtrativosController.do?verificador=2" accesskey="1" title="">Inicio</a></li>
				<c:choose>
					<c:when test="${not empty usuarioSessao}">
						<li><a href = "perfilUsuario.jsp" accesskey="2">Perfil</a></li>
						<li><a href="BuscarNovosAtrativosController.do" accesskey="3" title="">Conhecer novos lugares</a></li>
						<li><a href="criarCircuito.jsp" accesskey="4" title="">Circuitos</a></li>
						<li><a href="LogoutUsuarioController.do" accesskey="5" title="">Logout</a></li>
					</c:when>
					<c:otherwise>
						<li><a href = "cadastrarUsuario.jsp" accesskey="2">Cadastre-se</a></li>
						<li><a href="conhecerNovosLugares.jsp" accesskey="3" title="">Conhecer novos lugares</a></li>
						<li><a href="criarCircuito.jsp" accesskey="4" title="">Circuitos</a></li>
						<li><a href="login.jsp" accesskey="5" title="">Login</a></li>	
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${usuarioSessao.administrador == 1}">
						<li><a href="BuscarNovosAtrativosController.do?verificador=1" accesskey="6" title="">Opções avançadas</a></li>	
					</c:when>
				</c:choose>
			</ul>
		</div>
	</div>
</div>
</body>
</html>