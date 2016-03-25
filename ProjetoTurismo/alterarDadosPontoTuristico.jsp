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
        $("input.taxaCobrada").priceFormat({
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
	 
 </script>
<div id="wrapper">
	<div id="page-wrapper">
		<div id="page">
			<div id="wide-content">
				<div>
					<center><h2>Atualização de Ponto Turistico</h2></center>
    				<c:choose>
						<c:when test="${not empty status}">
							<font color = 'red'>${status}</font>
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
					<form action = AlterarDadosPontoTuristicoController.do method = 'post' id = 'atualizarPontoTuristico' name = 'atualizarPontoTuristico'>
						<input type = "hidden" name = 'idPontoTuristico' id = 'idPontoTuristico' value = '${pontoTuristico.idPontoTuristico }'/>
						<table>
							<tr><td><h4><label>Nome:</label></h4>
							<input type='text' size = '90' maxlength='100' name = 'nome' id = 'nome' value = '${pontoTuristico.nome}' onblur="validarTamanho('nome')"/><br/><br/></td>
							<tr><td><h4><label>Categoria</label></h4>
							<select name =  'categoria' id ='categoria' onblur="validarTamanho('categoria')">
								<option value = ''>Selecione</option>
								<option value = 'Atrativos Naturais'>Atrativos Naturais</option>
								<option value = 'Atrativos Culturais'>Atrativos Culturais</option>
								<option value = 'Atividades ECONOMICAS'>Atividades ECONOMICAS</option>
								<option value = 'REALIZACOES TECNICAS, CIENTIFICAS ou ARTISTICAS'>REALIZACOES TECNICAS, CIENTIFICAS ou ARTISTICAS</option>
								<option value = 'Eventos'>Eventos</option>
								<option value = 'Lazer e Entretenimento'>Lazer e Entretenimento</option>
								<option value = 'Eventos Permanentes'>Eventos Permanentes</option>
								<option selected='${pontoTuristico.categoria}'>${pontoTuristico.categoria}</option>
							</select></td></tr>
							<tr><td><h4><label>Descrição</label></h4></td></tr>
							<tr><td><textarea rows = '5' cols ='50' name = 'descricao' id = 'descricao' onblur="validarTamanho('descricao')">${pontoTuristico.descricao}</textarea></td></tr>
							<tr><td><h4><label>Estado:</label></h4> 
							<select name =  'estado' id ='estado' onblur="validarTamanho('estado')">
								<option value = ''>Selecione</option>
								<option value = 'RJ'>RJ</option>
								<option value = 'SP'>SP</option>
								<option value = 'MG'>MG</option>
								<option value = 'ES'>ES</option>
								<option value = 'DF'>DF</option>
								<option value = 'BA'>BA</option>
								<option value = 'outros'>Outros</option>
								<option selected='${pontoTuristico.estado}'>${pontoTuristico.estado}</option>
							</select>
							<tr><td><h4><label>Cidade:</label></h4>
							<input type = 'text' size = '90' maxlength = '100' name = 'cidade' id = 'cidade' value = '${pontoTuristico.cidade}' onblur="validarTamanho('cidade')"/><br/><br/></td></tr>
							<tr><td><h4><label>Distrito:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' name = 'distrito' id = 'distrito' value = '${pontoTuristico.distrito}' onblur="validarTamanho('distrito')"/></td></tr>
							<tr><td><h4><label>Endereco:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' name = 'endereco' id = 'endereco' value = '${pontoTuristico.endereco}' onblur="validarTamanho('endereco')"/></td></tr>
							<tr><td><h4><label for ='cep'>CEP:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' class="cep" name = 'cep' id = 'cep' value = '${pontoTuristico.cep}' onblur="validarTamanhoMascara('cep')"/></td></tr>
							<tr><td><h4><label>Horário:</label></h4></td></tr>
							<tr><td><h4><label>Inicio:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' class = 'hora' name = 'horarioInicio' id = 'horarioInicio' value = '${pontoTuristico.horarioInicio}' onblur="validarTamanhoMascara('horarioInicio')"/></td>
							<td><h4><label>Fim:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' class = 'hora' name = 'horarioFim' id = 'horarioFim' value = '${pontoTuristico.horarioFim}' onblur="validarTamanhoMascara('horarioFim')"/></td></tr>
							<tr><td><h4><label>Dias de funcionamento:</label></h4></td></tr>
							<tr><td><h4><label>Dia inicio:</label></h4>
							<select name =  'diaInicio' id = 'diaInicio' onblur="validarTamanho('diaInicio')">
								<option value = ''>Selecione</option>
								<option value = 'Domingo'>Domingo</option>
								<option value = 'Segunda'>Segunda</option>
								<option value = 'Terça'>Terça</option>
								<option value = 'Quarta'>Quarta</option>
								<option value = 'Quinta'>Quinta</option>
								<option value = 'Sexta'>Sexta</option>
								<option value = 'Sábado'>Sábado</option>
								<option selected='${pontoTuristico.diaInicio}'>${pontoTuristico.diaInicio}</option>
							</select>
							<td><h4><label>Dia fim:</label></h4>
							<select name =  'diaFim' id = 'diaFim' onblur="validarTamanho('diaFim')">
								<option value = ''>Selecione</option>
								<option value = 'Domingo'>Domingo</option>
								<option value = 'Segunda'>Segunda</option>
								<option value = 'Terça'>Terça</option>
								<option value = 'Quarta'>Quarta</option>
								<option value = 'Quinta'>Quinta</option>
								<option value = 'Sexta'>Sexta</option>
								<option value = 'Sábado'>Sábado</option>
								<option selected='${pontoTuristico.diaFim}'>${pontoTuristico.diaFim}</option>
							</select>
							<tr><td><h4><label>Taxa Cobrada:</label></h4>
							<input type = 'text' size = '60' maxlength = '60' class = 'taxaCobrada' name = 'taxaCobrada' id = 'taxaCobrada' value = '${pontoTuristico.taxaCobrada}'/></td></tr>
							<tr><td><h4><label>Imagens:</label></h4></td></tr>
							<tr><td>
									<c:forEach var = "elementosImagens" items = "${listaImagens}">
										<img src='img/${elementosImagens}' width='100' height='70' onclick="zoomToggle('100px','70px','500px','350px',this);" alt = 'Imagem não encontrada'>
									</c:forEach>
								</td></tr>
							<tr><td><center><input type = 'submit' class="button-style" name ='atualizarPontoTuristico' id = 'atualizarPontoTuristico' value='Atualizar'/><br/></center></td></tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</div> 
</body>
</html>