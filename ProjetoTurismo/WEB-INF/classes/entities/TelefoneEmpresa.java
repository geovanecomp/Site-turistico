package entities;

public class TelefoneEmpresa {
	private int idTelefoneEmpresa;
	private int idEmpresa;
	private String telefone;
	
	public TelefoneEmpresa(){
		
	}
	public TelefoneEmpresa(int idEmpresa, String telefone) {
		this.idEmpresa = idEmpresa;
		this.telefone = telefone;
	}
	public TelefoneEmpresa(int idTelefoneEmpresa, int idEmpresa, String telefone) {
		this.idTelefoneEmpresa = idTelefoneEmpresa;
		this.idEmpresa = idEmpresa;
		this.telefone = telefone;
	}
	
	public int getIdTelefoneEmpresa() {
		return idTelefoneEmpresa;
	}
	public void setIdTelefoneEmpresa(int idTelefoneEmpresa) {
		this.idTelefoneEmpresa = idTelefoneEmpresa;
	}
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
