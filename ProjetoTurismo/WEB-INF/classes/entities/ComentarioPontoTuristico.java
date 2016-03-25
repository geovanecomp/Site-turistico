package entities;
public class ComentarioPontoTuristico {
	private int idComentarioPontoTuristico;
	private String data;
	private String texto;
	private int idUsuario;
	private int idPontoTuristico;
	private Usuario usuario;
	


	public ComentarioPontoTuristico(){
		
	}
	
	public ComentarioPontoTuristico(String data, String texto,
			int idUsuario, int idPontoTuristico) {
		this.data = data;
		this.texto = texto;
		this.idUsuario = idUsuario;
		this.idPontoTuristico = idPontoTuristico;
	}
	
	public ComentarioPontoTuristico(int idComentarioPontoTuristico, String data,
			String texto, int idUsuario, int idPontoTuristico, Usuario usuario) {
		this.idComentarioPontoTuristico = idComentarioPontoTuristico;
		this.data = data;
		this.texto = texto;
		this.idUsuario = idUsuario;
		this.idPontoTuristico = idPontoTuristico;
		this.usuario = usuario;
	}
	public int getIdComentarioPontoTuristico() {
		return idComentarioPontoTuristico;
	}
	public void setIdComentarioPontoTuristico(int idComentarioPontoTuristico) {
		this.idComentarioPontoTuristico = idComentarioPontoTuristico;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdPontoTuristico() {
		return idPontoTuristico;
	}
	public void setIdPontoTuristico(int idPontoTuristico) {
		this.idPontoTuristico = idPontoTuristico;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
