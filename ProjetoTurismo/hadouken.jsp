<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file = "head.jsp" %>
<body>
<%@ include file = "header.jsp" %>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jquery.maskedinput.js"></script> 
 <script type="text/javascript">
	 $(document).ready(function(){
 		$("input.hora").mask("99:99");
		$("input.data").mask("99/99/9999");
        $("input.telefone").mask("(99) 9999-9999");
        $("input.cep").mask("99.999-999");
        $("input.cnpj").mask("99.999.999/9999-99");
        $("input.gastoMedio").mask("R$99,99");
	});
	  
 </script>  
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
						<label>Voc� precisa </label><a href = login.jsp>conectar-se</a><label> para pesquisar os atrativos, ou ent�o </label><a href ='cadastrarUsuario.jsp' >cadastre-se</a>
					</c:when>
					<c:otherwise>
						<h2>Abaixo est�o dispostas as diversas formas para melhor manuten��o do site:</h2>
						<ul class="style1">
							<li class="first">
								<h3>Usu�rios</h3>
								<p>Est� op��o ir� fornecer v�rios m�todos de manuten��o para usuarios</p>
								<p><a href="BuscarTodosUsuariosController.do" class="button-style">Buscar todos</a></p>
								<form action = 'BuscarUsuarioPorParteDoNome.do' method = 'post' name = 'buscarUsuarioPorParteDoNome' id = 'buscarUsuarioPorParteDoNome'>
									<table>
										<tr><td><input type = 'text' name = 'nome' id = 'nome'/></td>
										<td><input type = 'submit' class = "button-style" name ='buscarUsuarioPorParteDoNome' id = 'buscarUsuarioPorParteDoNome' value='Buscar pelo nome'/></td></tr>
								</form>
									<form action = 'BuscarUsuarioPelaIdadeController.do' method = 'post' name = 'buscarUsuarioPelaIdade' id = 'buscarUsuarioPelaIdade'>
										<table>
											<tr><td><input type = 'text' name = 'idade' id = 'idade'/></td>
											<td><input type = 'submit' class = "button-style" name = 'buscarUsuarioPelaIdade' id = 'buscarUsuarioPelaIdade' value ='Buscar pela idade m�nima'/></td></tr>
										</table>
									</form>
							</li>
							<li>
								<h3>Empresas</h3>
								<p>Est� op��o ir� fornecer v�rios m�todos de manuten��o para empresas</p>
								<form action = 'BuscarEmpresaPeloCnpj.do' method = 'post' name = 'buscarEmpresaPeloCnpj' id = 'buscarEmpresaPeloCnpj'>
									<table>
										<tr><td><input type = 'text' class = 'cnpj' name = 'cnpj' id = 'cnpj'/></td>
										<td><input type = 'submit' class = "button-style" name = 'buscarEmpresaPeloCnpj' id = 'buscarEmpresaPeloCnpj' value = 'Buscar pelo CNPJ'/></td></tr>
									</table>
								</form>
							</li>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

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
				<center><h4>Ponto tur�sticos:</h4></center>
					<c:forEach var = "elementosTodosPontosTuristicos" items = "${listaPontosTuristicos}">						
						<center><p class="button-style2"><a href = 'BuscarPontoTuristicoPeloIdController.do?idPontoTuristico=${elementosTodosPontosTuristicos.idPontoTuristico}&verificador=1'> ${elementosTodosPontosTuristicos.nome}</a></p><br /></center>
					</c:forEach>
				</li>
			</ul>
		</div>

	</div>
</div>
</body>
</html>