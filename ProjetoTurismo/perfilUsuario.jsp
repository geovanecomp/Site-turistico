<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file = "head.jsp" %>
<body>
<%@ include file = "header.jsp" %>
<script type = "text/javascript">
	function certeza(idUsuario){
		if(confirm("Desaja realmente deletar sua conta?")){
			document.location.href = 'DeletarUsuarioController.do?idUsuario='+idUsuario;  
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
						<c:when test="${not empty usuarioSessao}">
							<table>
								<tr><td><h2><font color = 'black'><label>Olá ${usuarioSessao.nome}, o que deseja fazer?</label></font></h2></td></tr>
							</table>
							<ul class="style2">
								<li><h3><a href = 'index.jsp'>Inicio</a></h3><br /></li>
								<li><h3><a href = 'BuscarUsuarioPeloIdController.do?idUsuario=${usuarioSessao.idUsuario}'> Minhas informações</a></h3><br /></li>
								<li><h3><a href = '#' onclick='certeza(${usuarioSessao.idUsuario})'>Deletar Usuário</a></h3><br /></li>
								<li><h3><a href = 'alterarDadosUsuario.jsp'>Atualizar meus dados</a></h3><br /></li>
								<li><h3><a href = 'BuscarTodosCircuitosController.do'>Meus Circuitos</a></h3></li>
							</ul>
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>