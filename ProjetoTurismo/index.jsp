<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Angled Theme 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20131104

-->
<html xmlns="http://www.w3.org/1999/xhtml">
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
					<h2>Bem vindo ao meu lazer.com!</h2>
					<p><img src="img/lazer.jpg" alt="" width="300" height="186" class="alignleft" />Cansado de ir encontrar os amigos sempre no mesmo lugar? Deseja mais contato com a natureza, no entanto não conhece os locais de nossa cidade? <strong>meu lazer.com</strong>, veio para solucioar todos estes problemas.</p>
					<p><strong>meu lazer.com</strong> é um site completamente gratuido cujo o principal objetivo é divulgar para a população todos os tipos de lazeres que a cidade oferece, tais comos atrativos naturais, eventos e etc.</p>
					<p class="button-style"><a href = 'cadastrarUsuario.jsp'>Cadastre-se agora</a></p>
				</div>
			</div>
		</div>
	</div>
	<div id="page" class="container">
		<div id="content">
			<div>
				<ul class="style1">
					<li class="first">
					<h3>Ultimos pontos pontos turísticos adicionados</h3>
						<c:forEach var = "elementosTodosPontosTuristicos" items = "${listaPontosTuristicos}">						
							<p class="button-style2"><a href = 'BuscarPontoTuristicoPeloIdController.do?idPontoTuristico=${elementosTodosPontosTuristicos.idPontoTuristico}&verificador=1'> ${elementosTodosPontosTuristicos.nome}</a></p><br />
						</c:forEach>
					</li>
				</ul>
			</div>
		</div>
		<div id="sidebar">
			<h2>Ultimas empresas adicionadas</h2>
			<ul class="style1">
				<li class="first">
					<c:forEach var = "elementosTodasEmpresas" items = "${listaEmpresas}">
						<p class="button-style2"><a href = 'BuscarEmpresaPeloIdController.do?idEmpresa=${elementosTodasEmpresas.idEmpresa}&verificador=1'> ${elementosTodasEmpresas.nome}</a></p><br />				
					</c:forEach>
				</li>
			</ul>
		</div>
	</div>
</div>
<div id="footer" class="container">
	<p>Copyright (c) 2013 meulazer.com. All rights reserved.</p>
</div>
</body>
</html>
