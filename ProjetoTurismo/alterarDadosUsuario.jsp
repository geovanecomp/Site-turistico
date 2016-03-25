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
	else if(tecla == 8 || tecla == 0) // Backspace, Delete e setas direcionais(para mover o cursor, apenas para FF)
		return true;
	else
		return false;
	}
	
</script>

<div id="wrapper">
	<div id="page-wrapper">
		<div id="page">
			<div id="wide-content">
				<div>
					<center><h2>Atualizar dados usuário:</h2></center>
					<c:choose>
						<c:when test="${not empty status}">
							<font color = 'red'>${status}</font>
						</c:when>
					</c:choose>
					<form action = AlterarDadosUsuarioController.do method = 'post' id = 'alterarDadosUsuario' name = 'alterarDadosUsuario'>
						<input type = 'hidden' name = 'idUsuario' id = 'idUsuario' value = '${usuarioSessao.idUsuario}'/>
						<table>
							<tr><td><h4><label>Nome:</label></h4>
							<input type='text' size = '90' maxlength='100' name = 'nome' id = 'nome' value = '${usuarioSessao.nome}'/><br/><br/></td>
							<td><c:choose>
								<c:when test="${usuarioSessao.administrador == 1}">
									<td><label>Tornar este usuário um Administrador?</label></td>
									<td><input type = 'radio' name = 'administrador' id = 'administrador' value = '1'/> <label>Sim</label></td>
									<td><input type = 'radio' name = 'administrador' id = 'administrador' value = '0'/><label>Não</label></td>
								</c:when>
							</c:choose></td></tr>
							<tr><td><h4><label>Login:</label></h4>
							<input type = 'text' size = '51' maxlength = '50' name = 'login' id = 'login'value = '${usuarioSessao.login}' /><br/><br/></td></tr>
							<tr><td><h4><label>Senha:</label></h4>
							<input type = 'password' size ='51' maxlength = '50' name = 'senha' id ='senha' value = '${usuarioSessao.senha}' /><br/><br/></td></tr>
							<tr><td><h4><label>Email:</label></h4>
							<input type = 'text' size = '90' maxlength = '100' name = 'email' id = 'email' value = '${usuarioSessao.email}'/><br/><br/></td></tr>
							<tr><td><h4><label>Sexo:</label></h4>
							<c:choose>
								<c:when test="${usuarioSessao.sexo eq 'Masculino'}">
									<tr><td><input type = 'radio' name = 'sexo' id = 'sexo' value = 'Masculino'  checked="checked"/> <label>Masculino</label></td></tr>
									<tr><td><input type = 'radio' name = 'sexo' id = 'sexo' value = 'Feminino'/><label>Feminino</label></td></tr>
								</c:when>
								<c:when test="${usuarioSessao.sexo eq 'Feminino'}">
									<tr><td><input type = 'radio' name = 'sexo' id = 'sexo' value = 'Masculino'/> <label>Masculino</label></td></tr>
									<tr><td><input type = 'radio' name = 'sexo' id = 'sexo' value = 'Feminino' checked="checked"/><label> Feminino</label></td></tr>	
								</c:when>
								<c:otherwise>
									<tr><td><input type = 'radio' name = 'sexo' id = 'sexo' value = 'Masculino'/> <label>Masculino</label></td></tr>
									<tr><td><input type = 'radio' name = 'sexo' id = 'sexo' value = 'Feminino'/><label>Feminino</label></td></tr>	
								</c:otherwise>
							</c:choose>
							
							<tr><td><h4><label>Nascimento:</label></h4>
							<input type="text" name="nascimento" id="nascimento" maxlength="10" onkeypress="dateMask(this, event);" value = '${nascimentoUsuarioSessao}' />
							
							<tr><td><h4><label>Cidade:</label></h4>
							<input type = 'text' size = '90' maxlength = '100' name = 'cidade' id = 'cidade' value = '${usuarioSessao.cidade}'/><br/><br/></td></tr>
							<tr><td><h4><label>Estado:</label></h4> 
									<select name =  'estado'>
										<option value = 'RJ'>RJ</option>
										<option value = 'SP'>SP</option>
										<option value = 'MG'>MG</option>
										<option value = 'ES'>ES</option>
										<option value = 'DF'>DF</option>
										<option value = 'BA'>BA</option>
										<option value = 'outros'>Outros</option>
										<option selected='${usuarioSessao.estado}'>${usuarioSessao.estado}</option>
									</select>
							<tr><td><h4><label>Profissão:</label></h4>
							<tr><td><input type = 'text' size='51' maxlength = '50' name = 'profissao' id = 'profissao' value = '${usuarioSessao.profissao}' /><br/><br/></td></tr>
							<tr><td><h4><label>Estado civil:</label></h4>
							<input type = 'text' size = '90' maxlength = '100' name = 'estadoCivil' id = 'estadoCivil' value = '${usuarioSessao.estadoCivil}'/><br/><br/></td></tr>
							<tr><td><h4><label>Escolaridade:</label></h4>
							<input type = 'text' size = '90' maxlength = '100' name = 'escolaridade' id = 'escolaridade' value = '${usuarioSessao.escolaridade}'/><br/><br/></td></tr>
							<tr><td><center><input type = 'submit' class="button-style"name ='atualizarUsuario' id = 'atualizarUsuario' value='Atualizar'/><br/></center></td></tr>
						</table> 
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
    
</body>
</html>