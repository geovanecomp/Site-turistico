<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file = "head.jsp" %>
<body>
<%@ include file = "header.jsp" %>
<script type='text/javascript'>
// C.2004 by CodeLifter.com
var nW,nH,oH,oW;
function zoomToggle(iWideSmall,iHighSmall,iWideLarge,iHighLarge,whichImage){
	oW=whichImage.style.width;oH=whichImage.style.height;
	if((oW==iWideLarge)||(oH==iHighLarge)){
		nW=iWideSmall;nH=iHighSmall;
	}
	else{
		nW=iWideLarge;nH=iHighLarge;
		}
	whichImage.style.width=nW;whichImage.style.height=nH;
}

function envia(pag){ 
   	document.formul.action= pag; 
   	document.formul.submit(); 
}
function certeza(idComentarioPontoTuristico, idUsuario){
	if(confirm("Desaja realmente deletar este comentário?")){
		document.location.href = 'DeletarComentarioPontoTuristicoController.do?idComentarioPontoTuristico='+idComentarioPontoTuristico+'&idUsuario='+idUsuario;  
		return true;
	}
	return false;
	
}
function confirmField(fieldId, button, i, idComentarioPontoTuristico) {
	var field = document.getElementById(fieldId);
	if (!field) {
		throw "Campo não encontrado!";
	}
	if (field.style.display == "none") {
		if(confirm("Desaja realmente alterar este comentário?")){
			document.location.href = 'AlterarComentarioPontoTuristicoController.do?idComentarioPontoTuristico='+idComentarioPontoTuristico+'&textoTextArea='+document.getElementById("idTextArea").value;
			//document.getElementById('alterarComentarioPontoTuristico'+i).submit();
			 
   
			return true;
		}
		return false;		
	}
	else {
		field.style.display = "none";
		button.value = "Alterar agora";
		var textarea = document.createElement("textarea");
		textarea.setAttribute("id", "idTextArea");
		textarea.setAttribute("name", "textoTextArea");
		textarea.setAttribute("cols", 50);
		textarea.setAttribute("rows", 5);
		textarea.attributes = field.innerHTML;
		textarea.appendChild(document.createTextNode(field.innerHTML));
		field.parentNode.insertBefore(textarea, field.nextSibling);
	}
}

</script>
<div id="wrapper">
	<div id="page-wrapper">
		<div id="page">
			<div id="wide-content">
				<div>
					<c:choose>
						<c:when test="${not empty status}">
							<strong><font color = 'red'>${status}</font></strong>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${not empty pontoTuristico}">
							<center><h2>Informações do Ponto Turístico</h2></center>
							<form action = 'CadastrarPontuacaoPontoTuristicoController.do' method = 'post' name = 'cadastrarPontuacaoPontoTuristico' id ='cadastrarPontuacaoPontoTuristico'>
								<table align = 'center' width = '800'>
									<tr><td width = "50"><h4><label>Nome:</label> ${pontoTuristico.nome}</h4><br /></td>
									<td width = "50"><h4><label>Categoria:</label> ${pontoTuristico.categoria}</h4><br /></td>
									<td width = "50"><h4><label>Descrição:</label> ${pontoTuristico.descricao}</h4><br /></td></tr>
									<tr><td width = "50"><h4><label>Estado:</label> ${pontoTuristico.estado}</h4><br /></td>
									<td width = "50"><h4><label>Cidade:</label> ${pontoTuristico.cidade}</h4><br /></td>
									<td width = "50"><h4><label>Distrito:</label>${pontoTuristico.distrito}</h4><br /></td></tr>
									<tr><td width = "50"><h4><label>Endereço:</label> ${pontoTuristico.endereco}</h4><br /></td>
									<td width = "50"><h4><label>Cep:</label> ${pontoTuristico.cep}</h4><br /></td>
									<td width = "50"><h4><label>Funciona de: ${pontoTuristico.diaInicio} a ${pontoTuristico.diaFim}</label></h4><br /></td></tr>
									<tr><td width = "50"><h4><label>No horario de: ${pontoTuristico.horarioInicio} a(s) ${pontoTuristico.horarioFim}</label></h4><br /></td>
									<td width = "50"><h4><label>Pontuação:</label> ${pontoTuristico.pontuacao}</h4><br /></td>
									<td width = "50"><h4><label>Taxa cobrada:</label> ${pontoTuristico.taxaCobrada}</h4><br /></td></tr>
									<c:choose>
										<c:when test="${empty listaPontuacaoPontoTuristicoUsuario}">
											<tr><td><select name =  'pontuacao'>
												<option value = ''>De sua nota</option>
												<option value = '1'>1</option>
												<option value = '2'>2</option>
												<option value = '3'>3</option>
												<option value = '4'>4</option>
												<option value = '5'>5</option>
											</select>
											<input type = 'hidden' name ='idPontoTuristico' id ='idPontoTuristico' value = '${pontoTuristico.idPontoTuristico}' />
											<input type = 'hidden' name ='idUsuario' id ='idUsuario' value = '${usuarioSessao.idUsuario}' />
											<input type = 'submit' class="button-style" name = 'btCadastrarPontuacaoPontoTuristico' id = 'btCadastrarPontuacaoPontoTuristico' value = 'Cadastrar Pontuação'></td></tr>
										</c:when>
									</c:choose>
									<tr><td width = "50"><h4><label>Imagens:</label></h4></td></tr>
									<tr><td>
										<c:forEach var = "elementosImagens" items = "${listaImagens}">
											<img src='img/${elementosImagens}' width='100' height='70' onclick="zoomToggle('100px','70px','500px','350px',this);" alt = 'Imagem não encontrada'>
										</c:forEach>
									</td></tr>
									
								</table>
							</form>
							<iframe class="map" width="600" height="500" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
								src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=pt-BR&amp;geocode=&amp;q=${pontoTuristico.estado},${pontoTuristico.cidade},${pontoTuristico.distrito},${pontoTuristico.endereco};sll=37.0625,-95.677068&amp;
								sspn=${pontoTuristico.estado},${pontoTuristico.cidade},${pontoTuristico.distrito},${pontoTuristico.endereco}&amp;ie=UTF8&amp;hq=&amp;hnear=${pontoTuristico.estado},${pontoTuristico.cidade},${pontoTuristico.distrito},${pontoTuristico.endereco}&amp;ll=${pontoTuristico.estado},${pontoTuristico.cidade},${pontoTuristico.distrito},${pontoTuristico.endereco}&amp;spn=0.06421,0.102654&amp;
								z=15&amp;iwloc=A&amp;output=embed">
							</iframe>
							<form action = 'AdicionarTrajetoAoCircuitoController.do' method = 'post' name = 'adicionarTrajetoAoCircuito' id = 'adicionarTrajetoAoCircuito'>
								<table>
									<tr><td><h3><label>Deseja adicionar este trajeto, ao circuito selecionado?</label></h3><br />
									<td><input type = 'hidden' name = 'idEmpresa' id = 'idEmpresa' value = '0' /></td>
									<td><input type = 'hidden' name = 'idPontoTuristico' id = 'idPontoTuristico' value = '${pontoTuristico.idPontoTuristico}' /></td>
									<td><input type = 'submit' class="button-style" name ='adicionarTrajetoAoCircuito' id = 'adicionarTrajetoAoCircuito' value ='Adicionar trajeto'/></td></tr>
								</table>
							</form>
							<table>
								<c:choose>
									<c:when test="${not empty listaComentariosPontoTuristico}">
										<tr><td><h4><label>Comentários referente a este ponto turistico:</label></h4></td></tr>
									</c:when>
								</c:choose>
							</table>
							<c:forEach var = "elementosComentariosPontoTuristico" items = "${listaComentariosPontoTuristico}">
								<ul class="style1">
									<li>
										<h4><label>Nome: ${elementosComentariosPontoTuristico.usuario.login}</label></h4>
										<h4><label id = '${elementosComentariosPontoTuristico.texto}'>Comentário: ${elementosComentariosPontoTuristico.texto}</label></h4>
										<h5><label>Data: ${elementosComentariosPontoTuristico.data}</label></h5>
										<c:choose>
											<c:when test="${usuarioSessao.administrador == 1}">
												<form action = 'DeletarComentarioPontoTuristicoController.do' method = 'post' name = 'deletarComentarioPontoTuristico' id ='deletarComentarioPontoTuristico'>
														<input type = 'hidden' name = 'idComentarioPontoTuristico' id = 'idComentarioPontoTuristico' value ='${elementosComentariosPontoTuristico.idComentarioPontoTuristico}'/>
														<input type = 'hidden' name = 'idUsuario' id = 'idUsuario' value ='${elementosComentariosPontoTuristico.idUsuario}'/>
														<input type = 'submit' class="button-style" name = 'deletarComentarioPontoTuristico' id = 'deletarComentarioPontoTuristico' value ='Deletar'  onclick='certeza(${elementosComentariosPontoTuristico.idComentarioPontoTuristico}, ${elementosComentariosPontoTuristico.idUsuario})'>
												</form>
											</c:when>
											<c:when test="${usuarioSessao.idUsuario eq elementosComentariosPontoTuristico.idUsuario}">	
												<%long time = System.nanoTime();%>
												<form action = 'AlterarComentarioPontoTuristicoController.do' method = 'post' name = 'alterarComentarioPontoTuristico' id ='alterarComentarioPontoTuristico<%out.print(time);%>'>
														<input type = 'hidden' name = 'idComentarioPontoTuristico' id = 'idComentarioPontoTuristico' value ='${elementosComentariosPontoTuristico.idComentarioPontoTuristico}'/>
														<input type = 'hidden' name = 'idUsuario' id = 'idUsuario' value ='${elementosComentariosPontoTuristico.idUsuario}'/></td>
														<input type = 'button' class="button-style" name = 'deletarComentarioPontoTuristico' id = 'deletarComentarioPontoTuristico' value ='Deletar'  onclick='certeza(${elementosComentariosPontoTuristico.idComentarioPontoTuristico}, ${elementosComentariosPontoTuristico.idUsuario})'>
														<input type = 'button' class="button-style" name = 'alterarComentarioPontoTuristicoBt' id = 'alterarComentarioPontoTuristicoBt' value ='Alterar'  onclick="confirmField('${elementosComentariosPontoTuristico.texto}', this, <%out.print(time);%>, ${elementosComentariosPontoTuristico.idComentarioPontoTuristico});">
												</form>
											</c:when>
										</c:choose>
									</li>
								</ul>
							</c:forEach>
							<br />
							<form action = 'CadastrarComentarioPontoTuristicoController.do' method = 'post' name = 'cadastarComentarioPontoTuristico' id ='cadastarComentarioPontoTuristico'>
								<table>
									<tr><td><h4><label>Comente sobre este Ponto Turistico:</label></h4></td></tr>
									<tr><td><input type = 'hidden' name = 'idPontoTuristico' id = 'idPontoTuristico' value ='${pontoTuristico.idPontoTuristico}'/></td></tr>
									<tr><td><input type = 'hidden' name = 'idUsuario' id = 'idUsuario' value ='${usuarioSessao.idUsuario}'/></td></tr>
									<tr><td><textarea rows = '5' cols ='50' name = 'texto' id = 'texto'></textarea></td></tr>
									<tr><td><input type = 'submit' class="button-style" name ='cadastarComentarioPontoTuristico' id = 'cadastarComentarioPontoTuristico' value ='Cadastrar'/></td></tr>
								</table>
							</form>		
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</div>

  
</body>
</html>