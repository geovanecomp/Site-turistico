package entities;
public class ComentarioEmpresa {
	private int idComentarioEmpresa;
	private String data;
	private String texto;
	private int idUsuario;
	private int idEmpresa;
	private Usuario usuario;

	public ComentarioEmpresa(){
		
	}

	public ComentarioEmpresa(String data, String texto,
			int idUsuario, int idEmpresa) {
		this.data = data;
		this.texto = texto;
		this.idUsuario = idUsuario;
		this.idEmpresa = idEmpresa;
	}

	public ComentarioEmpresa(int idComentarioEmpresa, String data, String texto,
			 int idUsuario, int idEmpresa, Usuario usuario) {
		this.idComentarioEmpresa = idComentarioEmpresa;
		this.data = data;
		this.texto = texto;
		this.idUsuario = idUsuario;
		this.idEmpresa = idEmpresa;
		this.usuario = usuario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getIdComentarioEmpresa() {
		return idComentarioEmpresa;
	}

	public void setIdComentarioEmpresa(int idComentarioEmpresa) {
		this.idComentarioEmpresa = idComentarioEmpresa;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
