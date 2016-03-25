package entities;

import java.sql.Date;

public class Circuito {
	private int idCircuito;
	private String nome;
	private Date data;
	private String descricao;
	private int idUsuario;
	
	public Circuito(){
		
	}
	
	public Circuito(String nome, Date data, String descricao,int idUsuario){
		this.nome = nome;
		this.data = data;
		this.descricao = descricao;
		this.idUsuario = idUsuario;
	}
	
	public Circuito(String nome, Date data, String descricao,
			int idUsuario, int idTrajeto) {
		this.nome = nome;
		this.data = data;
		this.descricao = descricao;
		this.idUsuario = idUsuario;
	}
	
	public Circuito(int idCircuito, String nome, Date data, String descricao,
			int idUsuario) {
		this.idCircuito = idCircuito;
		this.nome = nome;
		this.data = data;
		this.descricao = descricao;
		this.idUsuario = idUsuario;
	}
	
	public int getIdCircuito() {
		return idCircuito;
	}
	public void setIdCircuito(int idCircuito) {
		this.idCircuito = idCircuito;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDataFormatada(){
		String strData = data+"";
		String aux ="";
		long longNascimento = 0;
		for(int i = 0; i<10;i++){
			if(strData.charAt(i)!= '-'){
				aux = aux+strData.charAt(i);
			}
		}
		longNascimento = Long.parseLong(aux);
		String strDia = longNascimento%100+"";
		String strMes = (longNascimento/100)%100+"";
		String strAno = longNascimento/10000+"";
		strData = strDia+"/"+strMes+"/"+strAno;
		return strData;
	}
	
}
