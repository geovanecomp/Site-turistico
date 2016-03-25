package entities;

public class ImagemEmpresa {
	private int idImagemEmpresa;
	private int idEmpresa;
	private String imagem;
	
	public ImagemEmpresa(){
		
	}
	
	public ImagemEmpresa(int idEmpresa, String imagem) {
		this.idEmpresa = idEmpresa;
		this.imagem = imagem;
	}
	
	public ImagemEmpresa(int idImagemEmpresa, int idEmpresa, String imagem) {
		this.idImagemEmpresa = idImagemEmpresa;
		this.idEmpresa = idEmpresa;
		this.imagem = imagem;
	}
	public int getIdImagemEmpresa() {
		return idImagemEmpresa;
	}
	public void setIdImagemEmpresa(int idImagemEmpresa) {
		this.idImagemEmpresa = idImagemEmpresa;
	}
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
}
