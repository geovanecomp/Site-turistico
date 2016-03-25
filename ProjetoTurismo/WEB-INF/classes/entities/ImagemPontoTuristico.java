package entities;

public class ImagemPontoTuristico {
	private int idImagemPontoTuristico;
	private int idPontoTuristico;
	private String imagem;
	
	public ImagemPontoTuristico(int idImagemPontoTuristico,
			int idPontoTuristico, String imagem) {
		this.idImagemPontoTuristico = idImagemPontoTuristico;
		this.idPontoTuristico = idPontoTuristico;
		this.imagem = imagem;
	}

	public ImagemPontoTuristico(){
		
	}
	
	public int getIdImagemPontoTuristico() {
		return idImagemPontoTuristico;
	}
	public void setIdImagemPontoTuristico(int idImagemPontoTuristico) {
		this.idImagemPontoTuristico = idImagemPontoTuristico;
	}
	public int getIdPontoTuristico() {
		return idPontoTuristico;
	}
	public void setIdPontoTuristico(int idPontoTuristico) {
		this.idPontoTuristico = idPontoTuristico;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
}
