<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<%@ include file = "head.jsp" %>
<body>
<%@ include file = "header.jsp" %>
<div id="wrapper">
		<div id="page" class="container">
		<div id="content">
			<div>
				<c:choose>
					<c:when test="${not empty status}">
						<strong><font color = 'red'>${status}</font></strong>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${empty usuarioSessao}">
						<label>Você precisa </label><a href = login.jsp>conectar-se</a><label> para pesquisar os atrativos, ou então </label><a href ='cadastrarUsuario.jsp' >cadastre-se</a>
					</c:when>
					<c:otherwise>
						<h2>Abaixo estão dispostas as diversas formas de se encontrar o lazer que deseja:</h2>
						<p>Para melhor visualização, os atrativos estão separados em dois tipos, os eventos organizados por empresas, e os pontos turísticos da cidade.</p>
						<ul class="style1">
							<li class="first">
								<h3>Buscar todos os atrativos</h3>
								<p>Está opção irá buscar <strong>todos</strong> os atrativos da cidade.</p>
								<p><a href="BuscarTodosAtrativosController.do" class="button-style">Buscar todos</a></p>
							</li>
							<li>
								<h3>Buscar atrativos pela localidade</h3>
								<p>Está opção irá buscar todos os atravidos de determinada <strong>localidade</strong> escolhida.</p>
								<form action = 'BuscarAtrativoPeloDistritoController.do' method = 'post' name = 'buscarAtrativoPeloDistrito' id = 'buscarAtrativoPeloDistrito'>
									<input type = 'text' name = 'distrito' id = 'distrito'/>
									<input type = 'submit' class = "button-style" name ='buscarAtrativoPeloDistrito' id = 'buscarAtrativoPeloDistrito' value='Buscar pela localidade'/>
								</form>
							</li>
							<li>
								<h3>Buscar eventos</h3>
								<p>Está opção irá buscar todos os eventos organizados por uma determinada empresa <strong>Para isto, informe o nome ou parte do nome da empresa deseja</strong>.</p>
								<form action = 'BuscarEmpresaPorParteDoNome.do' method = 'post' name = 'buscarEmpresaPorParteDoNome' id = 'buscarEmpresaPorParteDoNome'>
									<input type = 'text' name = 'nome' id = 'nome'/>
									<input type = 'submit' class = "button-style" name = 'buscarEmpresaPorParteDoNome' id = 'buscarEmpresaPorParteDoNome' value = 'Buscar empresas pelo nome'/>
								</form>
							</li>
							<li>
								<h3>Buscar pontos turísticos</h3>
								<p>Está opção irá buscar todos os pontos turísticos<strong>Para isto, informe o nome ou parte do nome do ponto turísticos desejado.</strong>.</p>
								<form action = 'BuscarPontoTuristicoPorParteDoNome.do' method = 'post' name = 'buscarPontoTuristicoPorParteDoNome' id = 'buscarPontoTuristicoPorParteDoNome'>
									<input type = 'text' name = 'nome' id = 'nome'/>
									<input type = 'submit' class = "button-style" name = 'buscarPontoTuristicoPorParteDoNome' id = 'buscarPontoTuristicoPorParteDoNome' value = 'Buscar ponto turístico pelo nome'/>
								</form>
							</li>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<c:choose>
			<c:when test="${not empty usuarioSessao}">
				<div id="sidebar">
					<h2>Ultimos atrativos adicionados</h2>
					<ul class="style1">
						<li class="first">
						<center><h4>Empresas:</h4></center>
							<c:forEach var = "elementosTodasEmpresas" items = "${listaEmpresas}">
								<center><p class="button-style2"><a href = 'BuscarEmpresaPeloIdController.do?idEmpresa=${elementosTodasEmpresas.idEmpresa}&verificador=1'> ${elementosTodasEmpresas.nome}</a></p><br /></center>				
							</c:forEach>
						</li>
						<li>
						<center><h4>Ponto turísticos:</h4></center>
							<c:forEach var = "elementosTodosPontosTuristicos" items = "${listaPontosTuristicos}">						
								<center><p class="button-style2"><a href = 'BuscarPontoTuristicoPeloIdController.do?idPontoTuristico=${elementosTodosPontosTuristicos.idPontoTuristico}&verificador=1'> ${elementosTodosPontosTuristicos.nome}</a></p><br /></center>
							</c:forEach>
						</li>
					</ul>
				</div>
			</c:when>
		</c:choose>
	</div>
</div>
</body>
</html>