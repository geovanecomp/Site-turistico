<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center><h2>Bem vindo!</h2></center>
	<c:choose>
			<c:when test="${not empty status}">
				<font color = 'red'>${status}</font>
			</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty usuarioSessao}">
			<p>Olá ${usuarioSessao.nome}</p><br />
			<p>USUÁRIO (Normal):</p>
			<ul><li><a href = 'LogoutUsuarioController.do'>Logout</a><br /></li></ul>
			<ul><li><a href = 'perfilUsuario.jsp'>Perfil</a><br /></li></ul>
			<ul><li><a href = 'buscarEmpresaPeloNome.jsp'>Buscar empresa pelo nome</a><br /></li></ul>
			<ul><li><a href = 'buscarEmpresaPorParteDoNome.jsp'>Buscar empresa por parte do nome</a><br /></li></ul>
			<ul><li><a href = 'BuscarTodasEmpresasController.do'>Buscar todas as Empresas</a><br /></li></ul>
			<ul><li><a href = 'buscarPontoTuristicoPeloNome.jsp'>Buscar Ponto Turistico pelo nome</a><br /></li></ul>
			<ul><li><a href = 'buscarPontoTuristicoPorParteDoNome.jsp'>Buscar Ponto Turistico por parte do nome</a><br /></li></ul>
			<ul><li><a href = 'BuscarTodosPontosTuristicosController.do'>Buscar todos Pontos Turisticos</a><br /></li></ul>
			<ul><li><a href = 'buscarAtrativoPeloDistrito.jsp'>Buscar atrativo pelo distrito</a></li></ul>
			<ul><li><a href = 'BuscarNovosAtrativosController.do'>O que há de novo?</a></li></ul>
			<ul><li><a href = 'criarCircuito.jsp'>Criar Circuito</a></li></ul>
			<ul><li><a href = 'BuscarTodosCircuitosController.do'>Meus Circuitos</a></li></ul>
			<c:choose>
				<c:when test = "${not empty circuito}">
				<ul><li><a href = 'informacoesCircuitoEmConstrucao.jsp'>Informações do circuito em construção</a></li></ul>
			</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${usuarioSessao.administrador == 1}">
				<br /><p>USUÁRIO (Administrador):</p>
					<ul><li><a href = 'buscarUsuarioPeloNome.jsp'>Buscar usuários pelo nome</a><br /></li></ul>
					<ul><li><a href = 'buscarUsuarioPorParteDoNome.jsp'>Buscar usuários por parte do nome</a><br /></li></ul>
					<ul><li><a href = 'buscarUsuarioPelaIdade.jsp'>Buscar usuários pela idade</a><br /></li></ul>
					<ul><li><a href = 'BuscarTodosUsuariosController.do'>Buscar todos os usuários</a><br /></li></ul>
					<ul><li><a href = 'buscarEmpresaPeloCnpj.jsp'>Buscar Empresa pelo Cnpj</a><br /></li></ul>
					<ul><li><a href = 'cadastrarEmpresa.jsp'>Cadastrar Empresa</a><br /></li></ul>
					<ul><li><a href = 'cadastrarPontoTuristico.jsp'>Cadastrar Ponto Turistico</a><br /></li></ul>
				</c:when>
			</c:choose>		
		</c:when>
		
		<c:otherwise>
			<ul><li><a href = 'login.jsp'><br />Login</a><br /></li></ul>
		</c:otherwise>
	</c:choose>
	<ul><li><a href = 'cadastrarUsuario.jsp'>Cadastrar Usuário</a><br /></li></ul>
	<ul><li><a href = 'teste.jsp'>teste</a><br /></li></ul>
	<ul><li><a href = 'mapa.jsp'>Mapa</a><br /></li></ul>
</body>
</html>