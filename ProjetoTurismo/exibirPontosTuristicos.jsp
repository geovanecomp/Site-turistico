<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file = "head.jsp" %>
<body>
<%@ include file = "header.jsp" %>
<script type = "text/javascript">
	function certeza(idPontoTuristico){
		if(confirm("Desaja realmente deletar este Ponto Turistico?")){
			document.location.href = 'DeletarPontoTuristicoController.do?idPontoTuristico='+idPontoTuristico;  
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
						<c:when test="${not empty listaPontosTuristicos}">
						<center><h2>Pontos Turisticos cadastrados no sistema</h2></center>
							<c:forEach var = "elementosTodosPontosTuristicos" items = "${listaPontosTuristicos}">
								<ul class="style4">							
									<li><a class ="f1" href = 'BuscarPontoTuristicoPeloIdController.do?idPontoTuristico=${elementosTodosPontosTuristicos.idPontoTuristico}&verificador=1'><b><font color = 'blue'> ${elementosTodosPontosTuristicos.nome}</font></b><br /></a>
									<c:choose>
										<c:when test="${usuarioSessao.administrador == 1}">
											<a href = '#' onclick='certeza(${elementosTodosPontosTuristicos.idPontoTuristico})'><b><font color = 'black'>Deletar Ponto Turístico</font></b></a>
											<a href = 'BuscarPontoTuristicoPeloIdController.do?idPontoTuristico=${elementosTodosPontosTuristicos.idPontoTuristico}'><b><font color = 'black'> / Atualizar dados do Ponto Turistico</font></b></a></center></li>
											</c:when>
											<c:otherwise>
													</li>
											</c:otherwise>
									</c:choose>
								</ul>
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