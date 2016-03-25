<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<textarea name="ctl00$ctl00$cphMain$cphRight$GMapDragInstructions$txtAddress" rows="5" cols="20" id="ctl00_ctl00_cphMain_cphRight_GMapDragInstructions_txtAddress" style="width:250px;"></textarea>
<input type="button" name="ctl00$ctl00$cphMain$cphRight$GMapDragInstructions$butAddress" value="Localize o endereço" onclick="javascript:showAddress(document.getElementById('ctl00_ctl00_cphMain_cphRight_GMapDragInstructions_txtAddress').value);return false;__doPostBack('ctl00$ctl00$cphMain$cphRight$GMapDragInstructions$butAddress','')" id="ctl00_ctl00_cphMain_cphRight_GMapDragInstructions_butAddress" class="greenbutton">
	
	
	
	
	
	<!--<img src = 'http://maps.google.com/maps/api/staticmap?center=28633-540&zoom=16&size=512x512&maptype=satellite 
	&markers=color:blue%7Clabel:S%7C28633-540&markers=color:green%7Clabel:P%28633-540
	&markers=color:red%7Ccolor:red%7Clabel:C%7C28633-540&sensor=false'/>
	<p>pqp</p><br /> -->
	<!--  <table>
		<tr><td width = "300"><img src = 'http://maps.google.com/maps/api/staticmap?center=${pontoTuristico.cep}&zoom=15&size=450x300&maptype=satellite 
			&markers=color:blue%7Clabel:L%7C${pontoTuristico.cep}&sensor=false'/></td></tr><br />
	</table>-->
	<!-- <iframe class="map" width="600" height="500" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
		src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=pt-BR&amp;geocode=&amp;q=28633-540;sll=37.0625,-95.677068&amp;
		sspn=28633-540&amp;ie=UTF8&amp;hq=&amp;hnear=28633-540&amp;ll=28633-540&amp;spn=0.06421,0.102654&amp;
		z=15&amp;iwloc=A&amp;output=embed">
	</iframe> -->
	
	<iframe class="map" width="600" height="500" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
		src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=pt-BR&amp;geocode=&amp;saddr=Rua sebastiao pereira da silva, Conselheiro+Paulino,+Nova+Friburgo+-+Rio+de+Janeiro,+Rep%C3%BAblica+Federativa+do+Brasil&amp;
		daddr=Conselheiro+Paulino,+Nova+Friburgo+-+Rio+de+Janeiro,+Rep%C3%BAblica+Federativa+do+Brasil&amp;spn=0.06421,0.102654;
		q=15&amp;iwloc=A&amp;output=embed">
	</iframe>
	<iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps/ms?ctz=120&amp;ie=UTF8&amp;msa=0&amp;msid=213252036851565475069.0004b027e744fdb9e27f3&amp;t=m&amp;source=embed&amp;ll=-22.245569,-42.536488&amp;spn=0.079442,0.060081&amp;output=embed"></iframe><br /><small>Visualizar <a href="https://maps.google.com/maps/ms?ctz=120&amp;ie=UTF8&amp;msa=0&amp;msid=213252036851565475069.0004b027e744fdb9e27f3&amp;t=m&amp;source=embed&amp;ll=-22.245569,-42.536488&amp;spn=0.079442,0.060081" style="color:#0000FF;text-align:left">Defesa Civil de Nova Friburgo: Sirenes do Sistema de Alerta</a> em um mapa maior</small>

</body>
</html>