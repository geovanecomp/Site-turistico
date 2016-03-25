package entities;

public class PontuacaoEmpresa {
	private int idPontuacaoEmpresa;
	private int idEmpresa;
	private int idUsuario;
	private int pontuacao;
	
	public PontuacaoEmpresa(){
		
	}
	
	public PontuacaoEmpresa(int idPontuacaoEmpresa, int idEmpresa,
			int idUsuario, int pontuacao) {
		this.idPontuacaoEmpresa = idPontuacaoEmpresa;
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
		this.pontuacao = pontuacao;
	}
	
	public PontuacaoEmpresa(int idEmpresa,
			int idUsuario, int pontuacao) {
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
		this.pontuacao = pontuacao;
	}
	
	public int getIdPontuacaoEmpresa() {
		return idPontuacaoEmpresa;
	}
	public void setIdPontuacaoEmpresa(int idPontuacaoEmpresa) {
		this.idPontuacaoEmpresa = idPontuacaoEmpresa;
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
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
}
