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
<script type="text/javascript" src="jquery.price_format.js"></script>  
 <script type="text/javascript">
	 $(document).ready(function(){
 		$('input.hora').mask('99:99');
		$("input.data").mask("99/99/9999");
        $("input.telefone").mask("(99) 9999-9999");
        $("input.cep").mask("99999-999");
        $("input.cnpj").mask("99.999.999/9999-99");
        $("input.gastoMedio").priceFormat({
   		 prefix: 'R$ ',
   		 centsSeparator: ',',
   		 thousandsSeparator: '.'
   	 });	
	});
	 function validarTamanho(campo){
		var valor = document.getElementById(campo).value;
		if(valor.length==0){
			if(campo=="diaInicio" || campo=="diaFim"){
				alert("Por favor, preencha corretamento o seguinte campo: dia");
			}
			else{
				alert("Por favor, preencha corretamente o seguinte campo: "+campo);	
			}
			
			return false;
		}
		else{return true;}
	}
	 
	 function validarTamanhoMascara(campo){
		 var valor = document.getElementById(campo).value;
		 if(valor.charAt(0)==''||valor.charAt(0)=='_' || valor.charAt(1)=='_'){
			 alert("Por favor, preencha corretamente o seguinte campo: "+campo);
			 return false;
		 }
		 else{return true;}
	}
	 //------------------------
	  function validarTamanho2(){//verificar qual o melhor jeito de fazer, uma fun para tudo, ou separado.
		var nome = document.getElementById('nome').value;
		var categoria = document.getElementById('categoria').value;
		var descricao = document.getElementById('descricao').value;
		var estado = document.getElementById('estado').value;
		var cidade = document.getElementById('cidade').value;
		var distrito = document.getElementById('distrito').value;
		var endereco = document.getElementById('endereco').value;
		var cep = document.getElementById('cep').value;
		var horarioInicio = document.getElementById('horarioInicio').value;
		var horarioFim = document.getElementById('horarioFim').value;
		var diaInicio = document.getElementById('diaInicio').value;
		var diaFim = document.getElementById('diaFim').value;
		var gastoMedio = document.getElementById('gastoMedio').value;
		var telefone = document.getElementById('telefone').value;
		//var email = document.getElementById('email').value;
		var cnpj = document.getElementById('cnpj').value;
		if(nome.length==0){
			alert("Por favor, informe um nome");
			return false;
		}
		else if(categoria.length==0){
			alert("Por favor, informe uma categoria");
			return false;
		}
		else if(descricao.length==0){
			alert("Por favor, informe uma descrição");
			return false;
		}
		else if(estado.length==0){
			alert("Por favor, informe um estado");
			return false;
		}
		else if(cidade.length==0){
			alert("Por favor, informe uma cidade");
			return false;
		}
		else if(distrito.length==0){
			alert("Por favor, informe um distrito");
			return false;
		}
		else if(endereco.length==0){
			alert("Por favor, informe um endereco");
			return false;
		}
		else if(cep.length==0){
			alert("Por favor, informe um cep");
			return false;
		}
		else if(horarioInicio.length==0){
			alert("Por favor, informe um horario inicio");
			return false;
		}
		else if(horarioFim.length==0){
			alert("Por favor, informe um horario fim");
			return false;
		}
		else if(diaInicio.length==0){
			alert("Por favor, informe um dia inicio");
			return false;
		}
		else if(diaFim.length==0){
			alert("Por favor, informe um dia fim");
			return false;
		}
		else if(gastoMedio.length==0){
			alert("Por favor, informe um gasto médio");
			return false;
		}
		else if(telefone.length==0){
			alert("Por favor, informe um telefone");
			return false;
		}
		else if(cnpj.length==0){
			alert("Por favor, informe um CNPJ");
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
				 	<center><h2>Cadastro de empresas</h2></center>
				    <c:choose>
						<c:when test="${not empty status}">
							<font color = 'red'>${status}</font><br />
						</c:when>
					</c:choose>
					<h4><label>Adicionar foto:</label></h4>
							<div style="padding-left:10px;padding-top:15px">	
								<form action="UploadFileController.do" method="post" enctype="multipart/form-data" name="productForm" id="productForm" style="border:0px;padding:0px;margin:0px">
							
									<div style="width:300px; float:left;text-align:left">
										<span style=""><input class="required-field" type="file" name="file" id="file" onchange="document.getElementById('message').style.display='none';document.getElementById('wait').style.display='inline';submit()"></span>
									</div>
									<div style="width:270px; text-align:center;height:40px;float:left;text-align:left;">
										<%--<input id="botaosubmeter" type="button" name="Submit" value="Submeter foto" class="required-field" onclick="if (document.getElementById('file').value.length > 0) { document.getElementById('wait').style.display='inline';submit() }  else {alert('Você precisa selecionar o arquivo.')}">--%>
										<div id="wait" style="padding-bottom:10px;display:none;text-align:left;width:300px">
											<span style="color:red;font-size:9px">Aguarde...</span><img title="Aguarde...">
										</div>
										<div id="message" style="text-align:left;width:300px;color:red;font-size:10px;padding-top:5px">
										<c:choose>
											<c:when test="${not empty mensagem}">
												${mensagem}
											</c:when>
										</c:choose>
										</div>
									</div>
								</form>
							</div>
								
					<form action = CadastrarEmpresaController.do method = 'post' id = 'cadastrarEmpresa' name = 'cadastrarEmpresa'>
						<table>
							<tr><td><h4><label>Nome:</label></h4>
							<input type='text' size = '90' maxlength='100' name = 'nome' id = 'nome' value = '${arrayDadosEmpresa[0]}' onblur="validarTamanho('nome')"/><br/><br/></td></tr>
							<tr><td><h4><label>Categoria</label></h4>
							<select name =  'categoria' id = 'categoria' onblur = "validarTamanho('categoria')">
							<c:choose>
								<c:when test="${empty status}">
									<option value = ''>Selecione</option>
								</c:when>
								<c:otherwise>
									<option value = '${arrayDadosEmpresa[1]}'>${arrayDadosEmpresa[1]}</option>
								</c:otherwise>
							</c:choose>
								<option value = 'Hospedagem'>Hospedagem</option>
								<option value = 'Gastronomia'>Gastronomia</option>
								<option value = 'Agenciamento'>Agenciamento</option>
								<option value = 'Transporte'>Transporte</option>
								<option value = 'Eventos'>Eventos</option>
								<option value = 'Lazer e Entretenimento'>Lazer e Entretenimento</option>
								<option value = 'Outros Serviços e Equipamentos Turísticos'>Outros Serviços e Equipamentos Turísticos</option>
							</select></td></tr>
							<tr><td><h4><label>Descrição</label></h4></td></tr>
							<tr><td><textarea rows = '5' cols ='50' name = 'descricao' id = 'descricao' onblur="validarTamanho('descricao')">${arrayDadosEmpresa[2]}</textarea></td></tr>
							<tr><td><h4><label>Estado:</label></h4> 
							<select name =  'estado' id = 'estado' onblur="validarTamanho('estado')">
							<c:choose>
								<c:when test="${empty status}">
									<option value = ''>Selecione</option>
								</c:when>
								<c:otherwise>
									<option value = '${arrayDadosEmpresa[3]}'>${arrayDadosEmpresa[3]}</option>
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
							<tr><td><h4><label>Cidade:</label></h4>
							<input type = 'text' size = '90' maxlength = '100' name = 'cidade' id = 'cidade' value = '${arrayDadosEmpresa[4]}' onblur="validarTamanho('cidade')"/><br/><br/></td></tr>
							<tr><td><h4><label>Distrito:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' name = 'distrito' id = 'distrito' value = '${arrayDadosEmpresa[5]}' onblur="validarTamanho('distrito')"/></td></tr>
							<tr><td><h4><label>Endereco:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' name = 'endereco' id = 'endereco' value = '${arrayDadosEmpresa[6]}' onblur="validarTamanho('endereco')"/></td></tr>
							<tr><td><h4><label for ='cep'>CEP:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' class="cep" name = 'cep' id = 'cep' value = '${arrayDadosEmpresa[7]}' onblur="validarTamanhoMascara('cep')"/></td></tr>
							<tr><td><h4><label>Horário:</label></h4></td></tr>
							<tr><td><h4><label>Inicio:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' class = 'hora' name = 'horarioInicio' id = 'horarioInicio' value = '${arrayDadosEmpresa[8]}' onblur="validarTamanhoMascara('horarioInicio')"/></td>
							<td><h4><label>Fim:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' class = 'hora' name = 'horarioFim' id = 'horarioFim' value = '${arrayDadosEmpresa[9]}' onblur="validarTamanhoMascara('horarioFim')"/></td></tr>
							<tr><td><h4><label>Dias de funcionamento:</label></h4></td></tr>
							<tr><td><h4><label>Dia inicio:</label></h4>
							<select name =  'diaInicio' id = 'diaInicio' onblur="validarTamanho('diaInicio')">
								<c:choose>
								<c:when test="${empty status}">
									<option value = ''>Selecione</option>
								</c:when>
								<c:otherwise>
									<option value = '${arrayDadosEmpresa[10]}'>${arrayDadosEmpresa[10]}</option>
								</c:otherwise>
							</c:choose>
								<option value = 'Domingo'>Domingo</option>
								<option value = 'Segunda'>Segunda</option>
								<option value = 'Terça'>Terça</option>
								<option value = 'Quarta'>Quarta</option>
								<option value = 'Quinta'>Quinta</option>
								<option value = 'Sexta'>Sexta</option>
								<option value = 'Sábado'>Sábado</option>
							</select>
							<td><h4><label>Dia fim:</label></h4>
							<select name =  'diaFim' id = 'diaFim' onblur="validarTamanho('diaFim')">
								<c:choose>
								<c:when test="${empty status}">
									<option value = ''>Selecione</option>
								</c:when>
								<c:otherwise>
									<option value = '${arrayDadosEmpresa[11]}'>${arrayDadosEmpresa[11]}</option>
								</c:otherwise>
							</c:choose>
								<option value = 'Domingo'>Domingo</option>
								<option value = 'Segunda'>Segunda</option>
								<option value = 'Terça'>Terça</option>
								<option value = 'Quarta'>Quarta</option>
								<option value = 'Quinta'>Quinta</option>
								<option value = 'Sexta'>Sexta</option>
								<option value = 'Sábado'>Sábado</option>
							</select>
							<tr><td><h4><label>Gasto médio:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' class = 'gastoMedio' name = 'gastoMedio' id = 'gastoMedio' value = '${arrayDadosEmpresa[12]}' onblur="validarTamanho('gastoMedio')"/></td></tr>
							<tr><td><h4><label>Telefone:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' class = 'telefone' name = 'telefone' id = 'telefone' value = '${arrayDadosEmpresa[13]}' onblur="validarTamanho('telefone')"/></td></tr>
							<tr><td><h4><label>Email:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' name = 'email' id = 'email' value = '${arrayDadosEmpresa[14]}' onblur="isEmail()"/></td></tr>
							<tr><td><h4><label for = 'cnpj'>CNPJ:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' class="cnpj" name = 'cnpj' id = 'cnpj' value = '${arrayDadosEmpresa[15]}' onblur="validarTamanhoMascara('cnpj')"/></td></tr>
				
							<tr><td><center><input type = 'submit' class="button-style" name ='cadastrarEmpresa' id = 'cadastrarEmpresa' value='Cadastrar'/><br/></center></td></tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>