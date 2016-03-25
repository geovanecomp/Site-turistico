<%@page import="entities.ComentarioEmpresa"%>
<%@page import="java.util.List"%>
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
 
function envia(idEmpresa, pontuacao){
	document.location.href = 'CadastrarPontuacaoEmpresaController.do?idEmpresa='+idEmpresa+'&pontuacao='+pontuacao;
   	return true;
} 
function certeza(idComentarioEmpresa, idUsuario){
	if(confirm("Desaja realmente deletar este comentário?")){
		document.location.href = 'DeletarComentarioEmpresaController.do?idComentarioEmpresa='+idComentarioEmpresa+'&idUsuario='+idUsuario;  
		return true;
	}
	return false;
	
}
function confirmField(fieldId, button, i, idComentarioEmpresa) {
	var field = document.getElementById(fieldId);
	if (!field) {
		throw "Campo não encontrado!";
	}
	if (field.style.display == "none") {
		if(confirm("Desaja realmente alterar este comentário?")){
			document.location.href = 'AlterarComentarioEmpresaController.do?idComentarioEmpresa='+idComentarioEmpresa+'&textoTextArea='+document.getElementById("idTextArea").value;
			//document.getElementById('alterarComentarioEmpresa'+i).submit();
			 
   
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
		//textarea.attributes = field.innerHTML;
		textarea.appendChild(document.createTextNode(field.innerHTML.replace("Comentário: ","")));
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
						<c:when test="${not empty empresa}">
							<center><h2>Informações da Empresa</h2></center>
								<form action = 'CadastrarPontuacaoEmpresaController.do' method = 'post' name = 'cadastrarPontuacaoEmpresa' id ='cadastrarPontuacaoEmpresa'>
									<table align = 'center' width = '800'>
										<tr><td width = "50"><h4><label>Nome:</label> ${empresa.nome}</h4><br /></td>
										<td width = "50"><h4><label>Categoria:</label> ${empresa.categoria}</h4><br /></td>
										<td width = "50"><h4><label>Descrição:</label> ${empresa.descricao}</h4><br /></td></tr>
										<tr><td width = "50"><h4><label>Telefone(s):</label>
										<c:forEach var = "elementosTelefones" items = "${listaTelefones}">
											<label> ${elementosTelefones}</label></h4><br /></td>
										</c:forEach>
										<td width = "50"><h4><label>Email:</label> ${empresa.email}</h4><br /></td>
										<td width = "50"><h4><label>Estado:</label> ${empresa.estado}</h4><br /></td></tr>
										<tr><td width = "50"><h4><label>Cidade:</label> ${empresa.cidade}</h4><br /></td>
										<td width = "50"><h4><label>Distrito:</label> ${empresa.distrito}</h4><br /></td>
										<td width = "50"><h4><label>Endereço:</label> ${empresa.endereco}</h4><br /></td></tr>
										<tr><td width = "50"><h4><label>Cep:</label> ${empresa.cep}</h4><br /></td>
										<td width = "50"><h4><label>Funciona de:</label> ${empresa.diaInicio} a ${empresa.diaFim}</h4><br /></td>
										<td width = "50"><h4><label>No horario de:</label> ${empresa.horarioInicio} a(s) ${empresa.horarioFim}</h4><br /></td></tr>
										<tr><td width = "50"><h4><label>Pontuação:</label> ${empresa.pontuacao}</h4><br /></td>
										<td width = "50"><h4><label>Gasto Médio:</label> ${empresa.gastoMedio}</h4><br /></td>
										<td width = "50"><h4><label>Cnpj:</label> ${empresa.cnpj}</h4><br /></td></tr>
										<c:choose>
											<c:when test="${empty listaPontuacaoEmpresaUsuario}">
												<tr><td><select name =  'pontuacao'>
													<option value = ''>De sua nota</option>
													<option value = '1'>1</option>
													<option value = '2'>2</option>
													<option value = '3'>3</option>
													<option value = '4'>4</option>
													<option value = '5'>5</option>
												</select>
												<input type = 'hidden' name ='idEmpresa' id ='idEmpresa' value = '${empresa.idEmpresa}' />
												<input type = 'hidden' name ='idUsuario' id ='idUsuario' value = '${usuarioSessao.idUsuario}' />
												<input type = 'submit' class="button-style" name = 'btCadastrarPontuacaoEmpresa' id = 'btCadastrarPontuacaoEmpresa' value = 'Cadastrar Pontuação'></td></tr>
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
									src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=pt-BR&amp;geocode=&amp;q=${empresa.estado},${empresa.cidade},${empresa.distrito},${empresa.endereco};sll=37.0625,-95.677068&amp;
									sspn=${empresa.estado},${empresa.cidade},${empresa.distrito},${empresa.endereco}&amp;ie=UTF8&amp;hq=&amp;hnear=${empresa.estado},${empresa.cidade},${empresa.distrito},${empresa.endereco}&amp;ll=${empresa.estado},${empresa.cidade},${empresa.distrito},${empresa.endereco}&amp;spn=0.06421,0.102654&amp;
									z=15&amp;iwloc=A&amp;output=embed">
									
								</iframe>
								
								<form action = 'AdicionarTrajetoAoCircuitoController.do' method = 'post' name = 'adicionarTrajetoAoCircuito' id = 'adicionarTrajetoAoCircuito'>
								<table>
									<c:choose>
										<c:when test = "${not empty circuitoSessao }">
											<tr><td><h3><label>Deseja adicionar este trajeto, ao circuito selecionado?</label></h3><br /></td>
											<td><input type = 'hidden' name = 'idEmpresa' id = 'idEmpresa' value = '${empresa.idEmpresa}' /></td>
											<td><input type = 'hidden' name = 'idPontoTuristico' id = 'idPontoTuristico' value = '0' /></td>
											<td><input type = 'submit' class="button-style" name ='adicionarTrajetoAoCircuito' id = 'adicionarTrajetoAoCircuito' value ='Adicionar trajeto'/></td></tr>
										</c:when>
									</c:choose>
																	
									<c:choose>
										<c:when test="${not empty listaComentariosEmpresa}">
											<tr><td><h4><label><br />Comentários referente a esta empresa:</label></h4></td></tr>
										</c:when>
									</c:choose>
								</table>
								</form>
									<c:forEach var = "elementosComentariosEmpresa" items = "${listaComentariosEmpresa}">
									<%long time = System.nanoTime();%>
										<ul class="style1">
											<li>
												<h4><label>Nome: </label>${elementosComentariosEmpresa.usuario.login}</h4>
												<h4><label id = '${elementosComentariosEmpresa.texto}'>Comentário: ${elementosComentariosEmpresa.texto}</label></h4>
												<h5><label>Data: ${elementosComentariosEmpresa.data}</label></h5>
											<c:choose>
												<c:when test="${usuarioSessao.administrador == 1}">
													<form action = 'DeletarComentarioEmpresaController.do' method = 'post' name = 'deletarComentarioEmpresa' id ='deletarComentarioEmpresa'>
														<input type = 'hidden' name = 'idComentarioEmpresa' id = 'idComentarioEmpresa' value ='${elementosComentariosEmpresa.idComentarioEmpresa}'/>
														<input type = 'hidden' name = 'idUsuario' id = 'idUsuario' value ='${elementosComentariosEmpresa.idUsuario}'/>
														<input type = 'submit' class="button-style" name = 'deletarComentarioEmpresa' id = 'deletarComentarioEmpresa' value ='Deletar comentário'  onclick='certeza(${elementosComentariosEmpresa.idComentarioEmpresa}, ${elementosComentariosEmpresa.idUsuario})'>							
													</form>
												</c:when>
												
												<c:when test="${usuarioSessao.idUsuario eq elementosComentariosEmpresa.idUsuario}">
													<form action = 'AlterarComentarioEmpresaController.do' method = 'post' name = 'alterarComentarioEmpresa' id ='alterarComentarioEmpresa<%out.print(time);%>'>
															<input type = 'hidden' name = 'idComentarioEmpresa' id = 'idComentarioEmpresa' value ='${elementosComentariosEmpresa.idComentarioEmpresa}'/>
															<input type = 'hidden' name = 'idUsuario' id = 'idUsuario' value ='${elementosComentariosEmpresa.idUsuario}'/>
															<input type = 'button' class="button-style" name = 'deletarComentarioEmpresa' id = 'deletarComentarioEmpresa' value ='Deletar comentário'  onclick='certeza(${elementosComentariosEmpresa.idComentarioEmpresa}, ${elementosComentariosEmpresa.idUsuario})'>
															<input type = 'button' class="button-style" name = 'alterarComentarioEmpresaBt' id = 'alterarComentarioEmpresaBt' value ='Alterar comentário'  onclick="confirmField('${elementosComentariosEmpresa.texto}', this, <%out.print(time);%>, ${elementosComentariosEmpresa.idComentarioEmpresa});">
													</form>
												</c:when>
											</c:choose>
											</li>
										</ul>
									</c:forEach>
								<form action = 'CadastrarComentarioEmpresaController.do' method = 'post' name = 'cadastarComentarioEmpresa' id ='cadastarComentarioEmpresa'>
									<table>
										<tr><td><h4><label>Comente sobre esta empresa:</label></h4></td></tr>
										<tr><td><input type = 'hidden' name = 'idEmpresa' id = 'idEmpresa' value ='${empresa.idEmpresa}'/></td></tr>
										<tr><td><input type = 'hidden' name = 'idUsuario' id = 'idUsuario' value ='${usuarioSessao.idUsuario}'/></td></tr>
										<tr><td><textarea rows = '5' cols ='50' name = 'texto' id = 'texto'></textarea></td></tr>
										<tr><td><input type = 'submit' class="button-style" name ='cadastarComentarioEmpresa' id = 'cadastarComentarioEmpresa' value ='Cadastrar comentário'/></td></tr>
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