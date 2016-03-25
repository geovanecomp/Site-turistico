<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file = "head.jsp" %>
<body>
<%@ include file = "header.jsp" %>
<script type = "text/javascript">
	function certeza(idEmpresa){
		if(confirm("Desaja realmente deletar esta empresa?")){
			document.location.href = 'DeletarEmpresaController.do?idEmpresa='+idEmpresa;  
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
						<c:when test="${not empty listaEmpresas}">
						<center><h2>Empresas cadastradas no sistema</h2></center>
							<c:forEach var = "elementosTodasEmpresas" items = "${listaEmpresas}">
								<ul class="style4">							
									<li><a class ="f1" href = 'BuscarEmpresaPeloIdController.do?idEmpresa=${elementosTodasEmpresas.idEmpresa}&verificador=1'><b><font color = 'blue'> ${elementosTodasEmpresas.nome}</font></b><br /></a>
										<c:choose>
											<c:when test="${usuarioSessao.administrador == 1}">
												<a href = '#' onclick='certeza(${elementosTodasEmpresas.idEmpresa})'><b><font color = 'black'>Deletar Empresa</font></b></a>
												<a href = 'BuscarEmpresaPeloIdController.do?idEmpresa=${elementosTodasEmpresas.idEmpresa}'><b><font color = 'black'>Atualizar dados da Empresa</font></b></a></li>
											</c:when>
											<c:otherwise>
												</li>
											</c:otherwise>
										</c:choose>
								<br />
							</c:forEach>
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>