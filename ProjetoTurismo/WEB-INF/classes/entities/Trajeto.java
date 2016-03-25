package entities;

import java.sql.Date;

public class Trajeto {
	private int idTrajeto;
	private Date data;
	private int idUsuario;
	private int idEmpresa;
	private int idPontoTuristico;
	private int idCircuito;

	public Trajeto (){
		
	}
	
	public Trajeto(Date data, int idUsuario, int idEmpresa,
			int idPontoTuristico, int idCircuito) {
		this.data = data;
		this.idUsuario = idUsuario;
		this.idEmpresa = idEmpresa;
		this.idPontoTuristico = idPontoTuristico;
		this.idCircuito = idCircuito;
	}
	
	public Trajeto(int idTrajeto, Date data, int idUsuario, int idEmpresa,
			int idPontoTuristico, int idCircuito) {
		this.idTrajeto = idTrajeto;
		this.data = data;
		this.idUsuario = idUsuario;
		this.idEmpresa = idEmpresa;
		this.idPontoTuristico = idPontoTuristico;
		this.idCircuito = idCircuito;
	}
	public int getIdTrajeto() {
		return idTrajeto;
	}
	public void setIdTrajeto(int idTrajeto) {
		this.idTrajeto = idTrajeto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public int getIdPontoTuristico() {
		return idPontoTuristico;
	}
	public void setIdPontoTuristico(int idPontoTuristico) {
		this.idPontoTuristico = idPontoTuristico;
	}
	
	public int getIdCircuito() {
		return idCircuito;
	}

	public void setIdCircuito(int idCircuito) {
		this.idCircuito = idCircuito;
	}
	
}
