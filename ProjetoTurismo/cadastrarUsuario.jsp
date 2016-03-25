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

function isEmail(){
	var email = document.getElementById('email').value;
    var exclude=/[^@\-\.\w]|^[_@\.\-]|[\._\-]{2}|[@\.]{2}|(@)[^@]*\1/;
    var check=/@[\w\-]+\./;
    var checkend=/\.[a-zA-Z]{2,3}$/;
    if(((email.search(exclude) != -1)||(email.search(check)) == -1)||(email.search(checkend) == -1)){
    	alert("Por favor, informe um email válido.");	
    	return false;
    }
    else {
    	return true;
    }
}
    </script>
    
<div id="wrapper">
	<div id="page-wrapper">
		<div id="page">
			<div id="wide-content">
				<div>
					<center><h2>Cadastro de usuários</h2></center>
					<h3>Cadastre-se para ter acesso completo ao site.</h3>
				    <c:choose>
						<c:when test="${not empty status}">
							<font color = 'red'>${status}</font>
						</c:when>
					</c:choose>
					<form action = CadastrarUsuarioController.do method = 'post' id = 'cadastrarUsuario' name = 'cadastrarUsuario'>
						<table>
							<tr><td><h4><label>Nome:</label></h4>
							<input type='text' size = '90' maxlength='100' name = 'nome' id = 'nome' value = '${arrayDadosUsuario[0]}' onblur="validarTamanho('nome')"/><br/><br/></td>
							<td><c:choose>
								<c:when test="${usuarioSessao.administrador == 1}">
									<td><label>O usuário será um Administrador?</label></td>
									<td><input type = 'radio' name = 'administrador' id = 'administrador' value = '1'/> <label>Sim</label></td>
									<td><input type = 'radio' name = 'administrador' id = 'administrador' value = '0'/><label>Não</label></td>
								</c:when>
							</c:choose></td></tr>
							<tr><td><h4><label>Login:</label></h4>
							<input type = 'text' size = '51' maxlength = '50' name = 'login' id = 'login'value = '${arrayDadosUsuario[1]}' onblur="validarTamanho('login')"/><br/><br/></td></tr>
							<tr><td><h4><label>Senha:</label></h4>
							<input type = 'password' size ='51' maxlength = '50' name = 'senha' id ='senha' value = '${arrayDadosUsuario[2]}'onblur="validarTamanho('senha')" /><br/><br/></td></tr>
							<tr><td><h4><label>Email:</label></h4>
							<input type = 'text' size = '90' maxlength = '100' name = 'email' id = 'email' value = '${arrayDadosUsuario[3]}' onblur="isEmail()"/><br/><br/></td></tr>
							<tr><td><h4><label>Sexo:</label></h4>
							<c:choose>
								<c:when test="${arrayDadosUsuario[4] eq 'Masculino'}">
									<tr><td><input type = 'radio' name = 'sexo' id = 'sexo' value = 'Masculino'  checked="checked"/> <label>Masculino</label></td></tr>
									<tr><td><input type = 'radio' name = 'sexo' id = 'sexo' value = 'Feminino'/><label>Feminino</label></td></tr>
								</c:when>
								<c:when test="${arrayDadosUsuario[4] eq 'Feminino'}">
									<tr><td><input type = 'radio' name = 'sexo' id = 'sexo' value = 'Masculino'/> <label>Masculino</label></td></tr>
									<tr><td><input type = 'radio' name = 'sexo' id = 'sexo' value = 'Feminino' checked="checked"/><label> Feminino</label></td></tr>	
								</c:when>
								<c:otherwise>
									<tr><td><input type = 'radio' name = 'sexo' id = 'sexo' value = 'Masculino'/> <label>Masculino</label></td></tr>
									<tr><td><input type = 'radio' name = 'sexo' id = 'sexo' value = 'Feminino'/><label>Feminino</label></td></tr>	
								</c:otherwise>
							</c:choose>
							
							<tr><td><h4><label>Nascimento:</label></h4>
							<input type="text" name="nascimento" id="nascimento" maxlength="10" onkeypress="dateMask(this, event);" value = '${arrayDadosUsuario[5]}' onblur="validarTamanho('nascimento')"/>
							
							<tr><td><h4><label>Cidade:</label></h4>
							<input type = 'text' size = '90' maxlength = '100' name = 'cidade' id = 'cidade' value = '${arrayDadosUsuario[6]}' onblur="validarTamanho('cidade')"/><br/><br/></td></tr>
							<tr><td><h4><label>Estado:</label></h4> 
								<select name =  'estado' id = 'estado' onblur="validarTamanho('estado')">
								<c:choose>
									<c:when test="${empty status}">
										<option value = ''>Selecione</option>
									</c:when>
									<c:otherwise>
										<option value = '${arrayDadosUsuario[7]}'>${arrayDadosUsuario[7]}</option>
									</c:otherwise>
								</c:choose>
									<option value = 'RJ'>RJ</option>
									<option value = 'SP'>SP</option>
									<option value = 'MG'>MG</option>
									<option value = 'ES'>ES</option>
									<option value = 'DF'>DF</option>
									<option value = 'BA'>BA</option>
									<option value = 'outros'>Outros</option>
								</select>
							<tr><td><h4><label>Profissão:</label></h4>
							<tr><td><input type = 'text' size='51' maxlength = '50' name = 'profissao' id = 'profissao' value = '${arrayDadosUsuario[8]}' onblur="validarTamanho('profissao')"/><br/><br/></td></tr>
							<tr><td><h4><label>Estado civil:</label></h4>
							<input type = 'text' size = '90' maxlength = '100' name = 'estadoCivil' id = 'estadoCivil' value = '${arrayDadosUsuario[9]}' onblur="validarTamanho('estadoCivil')"/><br/><br/></td></tr>
							<tr><td><h4><label>Escolaridade:</label></h4>
							<input type = 'text' size = '90' maxlength = '100' name = 'escolaridade' id = 'escolaridade' value = '${arrayDadosUsuario[10]}'onblur="validarTamanho('escolaridade')"/><br/><br/></td></tr>
							<tr><td><center><input type = 'submit' class = "button-style" name ='cadastrarUsuario' id = 'cadastrarUsuario' value='Cadastrar'/><br/></center></td></tr>
							</table> 
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>