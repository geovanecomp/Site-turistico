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
		if(confirm("Deseja realmente deletar esta conta?")){
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
					<center><h2>Usuários cadastrados no sistema</h2></center>
					<c:forEach var = "elementosTodosUsuarios" items = "${listaUsuarios}">
						<ul class="style4">							
							<li><a class ="f1" href = 'BuscarUsuarioPeloIdController.do?idUsuario=${elementosTodosUsuarios.idUsuario}'><b><font color = 'blue'> ${elementosTodosUsuarios.nome}</font></b><br /></a>
							<a href = '#' onclick='certeza(${elementosTodosUsuarios.idUsuario})'><b><font color = 'black'>Deletar Usuário</font></b></a>
							<a href = 'BuscarDadosUsuarioPeloAdministradorController.do?idUsuario=${elementosTodosUsuarios.idUsuario}'><b><font color = 'black'> / Atualizar dados</font></b></a></center></li>
						</ul>
						<br />
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>