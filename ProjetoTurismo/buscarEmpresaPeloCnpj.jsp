<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jquery.maskedinput.js"></script> 
 <script type="text/javascript">
	 $(document).ready(function(){
 		$("input.hora").mask("99:99");
		$("input.data").mask("99/99/9999");
        $("input.telefone").mask("(99) 9999-9999");
        $("input.cep").mask("99.999-999");
        $("input.cnpj").mask("99.999.999/9999-99");
        $("input.gastoMedio").mask("R$99,99");
	});
	  
 </script>  
    <c:choose>
		<c:when test="${not empty status}">
			<font color = 'red'>${status}</font>
		</c:when>
	</c:choose>
	<form action = 'BuscarEmpresaPeloCnpj.do' method = 'post' name = 'buscarEmpresaPeloCnpj' id = 'buscarEmpresaPeloCnpj'>
		<table>
			<tr><td><label>Cnpj:</label></td></tr>
			<tr><td><input type = 'text' class = 'cnpj' name = 'cnpj' id = 'cnpj'/></td></tr>
			<tr><td><input type = 'submit' name = 'buscarEmpresaPeloCnpj' id = 'buscarEmpresaPeloCnpj'/></td></tr>
		</table>
	</form>
</body>
</html>