<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file = "head.jsp" %>
<body>
<%@ include file = "header.jsp" %>
<script language="JavaScript" type="text/javascript">
function dateMask(inputData, e){
	if(document.all) // Internet Explorer
		var tecla = event.keyCode;
		else //Outros Browsers
		var tecla = e.which;

		if(tecla >= 47 && tecla < 58){ // numeros de 0 a 9 e "/"
			var data = inputData.value;
			if (data.length == 2 || data.length == 5){
			data += '/';
			inputData.value = data;
		}
	}
	else if(tecla == 8 || tecla == 0) //Backspace, Delete e setas direcionais(para mover o cursor, apenas para FF)
		return true;
	else
		return false;
	}
	
function validarTamanho(campo){
	var valor = document.getElementById(campo).value;
	if(valor.length==0){
		alert("Por favor, preencha corretamento o seguinte campo: "+campo);	
		return false;
	}
	else{return true;}
}
</script>
<div id="wrapper">
	<div id="page-wrapper">
		<div id="page">
			<div id="wide-content">
				<div>
					<c:choose>
						<c:when test = "${empty usuarioSessao}">
							<h4>Criar um circuito, é uma forma de organizar atrativos / trajetos que você deseja realizar em determinada data. Vamos lá, crie agora mesmo seu circuito e adicione os trajetos que queira realizar!</h4><br />
							<center><p class="button-style"><a href = 'cadastrarUsuario.jsp'>Cadastre-se agora</a></p> ou <p class="button-style"><a href = 'login.jsp'>realize seu login</a></p></center>
						</c:when>
						<c:when test = "${not empty circuitoSessao}">
							<b><font color = 'red'>Já existe um circuito em construção, se desejar criar outro, clique </font><a href = 'RemoverCircuitoController.do'>aqui</a>
							<font color = 'red'>,ou então para visualizar os circuito em construção clique </font><a href = 'BuscarCircuitoPeloIdController.do?idCircuito=${circuitoSessao.idCircuito}&verificador=1'>aqui</a>
							<font color = 'red'> para visualizar o circuito em construção. </font></b>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${not empty status}">
									<font color = 'red'>${status}</font>
								</c:when>
							</c:choose>
							<h4>Criar um circuito, é uma forma de organizar atrativos / trajetos que você deseja realizar em determinada data. Vamos lá, crie agora mesmo seu circuito e adicione os trajetos que queira realizar!</h4><br />
							<form action = 'CadastrarCircuitoController.do' method = 'post' name = 'criarCircuito' id = 'criarCircuito'>
								<center><h3><label>Nome: <input type = 'text' name = 'nome' id ='nome' maxlength ='100' size = '30' onblur="validarTamanho('nome')"/></label></h3></center>
								
								<br />
								<center><h3><label>Data de realização: <input type = 'text' name = 'data' id ='data' maxlength ='10' size = '11' onkeypress="dateMask(this, event);"/></label></h3></center>
								<br />
								<center><h3><label>Descrição:</label></h3></center>
								<center><textarea rows = '5' cols ='50' name = 'descricao' id = 'descricao' onblur="validarTamanho('descricao')"></textarea></center>
								<br />
								<input type = 'hidden' name ='idUsuario' id = 'idUsuario' value = '${usuarioSessao.idUsuario}'/>
								<center><input type = 'submit' class="button-style" name ='criar' id = 'criar' value = 'Criar'></center>
							</form>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</div>
	
 	<br /><a href = 'index.jsp'>Inicio</a>
</body>
</html>