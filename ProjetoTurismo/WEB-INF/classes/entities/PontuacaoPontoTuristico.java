package entities;

public class PontuacaoPontoTuristico {
	private int idPontuacaoPontoTuristico;
	private int idPontoTuristico;
	private int idUsuario;
	private int pontuacao;
	
	public PontuacaoPontoTuristico(){
		
	}
	
	public PontuacaoPontoTuristico(
			int idPontoTuristico, int idUsuario, int pontuacao) {
		this.idPontoTuristico = idPontoTuristico;
		this.idUsuario = idUsuario;
		this.pontuacao = pontuacao;
	}
	
	public PontuacaoPontoTuristico(int idPontuacaoPontoTuristico,
			int idPontoTuristico, int idUsuario, int pontuacao) {
		this.idPontuacaoPontoTuristico = idPontuacaoPontoTuristico;
		this.idPontoTuristico = idPontoTuristico;
		this.idUsuario = idUsuario;
		this.pontuacao = pontuacao;
	}
	public int getIdPontuacaoPontoTuristico() {
		return idPontuacaoPontoTuristico;
	}
	public void setIdPontuacaoPontoTuristico(int idPontuacaoPontoTuristico) {
		this.idPontuacaoPontoTuristico = idPontuacaoPontoTuristico;
	}
	public int getIdPontoTuristico() {
		return idPontoTuristico;
	}
	public void setIdPontoTuristico(int idPontoTuristico) {
		this.idPontoTuristico = idPontoTuristico;
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
