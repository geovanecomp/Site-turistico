<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
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
 
function validarTamanhoMascara(campo){
	 var valor = document.getElementById(campo).value;
	 alert("Entrou");
	 if(valor.charAt(0)==''||valor.charAt(0)=='_'){
		 alert("Entrou if");
		 alert("Por favor, preencha corretamento o seguinte campo: "+campo);
		 return false;
	 }
	 else{alert("Entrou else");return true;}
}

</script>
 
</head>
<body>
<label for ='cep'>CEP:</label>
	<input type = 'text' size = '60' maxlength = '60' class="cep" name = 'cep' id = 'cep' value = '${arraydadosPontoTuristico[7]}' onblur="validarTamanhoMascara('cep')"/>
	<label>Horário:</label>
	<label>Inicio:</label>
	<input type = 'text' size = '60' maxlength = '60' class = 'hora' name = 'horarioInicio' id = 'horarioInicio' value = '${arraydadosPontoTuristico[8]}' onblur="validarTamanhoMascara('horarioInicio')"/>
	<label>Taxa Cobrada:</label>
	<input type = 'text' size = '10' maxlength = '10' class = 'taxaCobrada' name = 'taxaCobrada' id = 'taxaCobrada' value = '${arraydadosPontoTuristico[12]}' onblur="validarTamanhoMascara('taxaCobrada')"/>
</body>
</html>