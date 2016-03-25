<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file = "head.jsp" %>
<body>
<%@ include file = "header.jsp" %>
<script type = "text/javascript">
	function certeza(idCircuito){
		if(confirm("Desaja realmente deletar este Circuito?")){
			document.location.href = 'DeletarCircuitoController.do?idCircuito='+idCircuito;  
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
						<c:when test="${not empty listaCircuitos}">
						<center><h2>Meus Circuitos criados</h2></center>
							<c:forEach var = "elementosTodosCircuitos" items = "${listaCircuitos}">
								<ul class="style4">							
									<li><a class ="f1" href = 'BuscarCircuitoPeloIdController.do?idCircuito=${elementosTodosCircuitos.idCircuito}&verificador=1'> <b><font color = 'blue'>${elementosTodosCircuitos.nome}</font></b><br /></a>
										<a href = '#' onclick='certeza(${elementosTodosCircuitos.idCircuito})'><b><font color = 'black'>Deletar Circuito</font></b></a>
										<a href = 'BuscarCircuitoPeloIdController.do?idCircuito=${elementosTodosCircuitos.idCircuito}'><b><font color = 'black'> / Atualizar Circuito</font></b></a></center></li>
								</ul>
								<br />
							</c:forEach>
						</c:when>
						<c:otherwise>
							<label>Nenhum circuito criado, você pode criar um circuito clicando </label><a href = criarCircuito.jsp>aqui</a><label> .</label>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>