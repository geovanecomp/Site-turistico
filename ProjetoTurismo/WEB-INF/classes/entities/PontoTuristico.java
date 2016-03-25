package entities;

public class PontoTuristico {
	private int idPontoTuristico;
	private String nome;
	private String categoria;
	private String descricao;
	private String estado;
	private String cidade;
	private String distrito;
	private String endereco;
	private String cep;
	private String horarioInicio;
	private String horarioFim;
	private String diaInicio;
	private String diaFim;
	private int pontuacao;
	private String taxaCobrada;
	private Trajeto trajeto;
	
	public PontoTuristico(){
		
	}
	
	public PontoTuristico(String nome, String categoria,
			String descricao, String estado, String cidade, String distrito,
			String endereco, String cep, String horarioInicio,
			String horarioFim, String diaInicio, String diaFim, int pontuacao,
			String taxaCobrada) {
		this.nome = nome;
		this.categoria = categoria;
		this.descricao = descricao;
		this.estado = estado;
		this.cidade = cidade;
		this.distrito = distrito;
		this.endereco = endereco;
		this.cep = cep;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.diaInicio = diaInicio;
		this.diaFim = diaFim;
		this.pontuacao = pontuacao;
		this.taxaCobrada = taxaCobrada;
	}
	
	public PontoTuristico(int idPontoTuristico, String nome, String categoria,
			String descricao, String estado, String cidade, String distrito,
			String endereco, String cep, String horarioInicio,
			String horarioFim, String diaInicio, String diaFim, int pontuacao,
			String taxaCobrada) {
		this.idPontoTuristico = idPontoTuristico;
		this.nome = nome;
		this.categoria = categoria;
		this.descricao = descricao;
		this.estado = estado;
		this.cidade = cidade;
		this.distrito = distrito;
		this.endereco = endereco;
		this.cep = cep;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.diaInicio = diaInicio;
		this.diaFim = diaFim;
		this.pontuacao = pontuacao;
		this.taxaCobrada = taxaCobrada;
	}
	
	public int getIdPontoTuristico() {
		return idPontoTuristico;
	}

	public void setIdPontoTuristico(int idPontoTuristico) {
		this.idPontoTuristico = idPontoTuristico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}

	public String getDiaInicio() {
		return diaInicio;
	}

	public void setDiaInicio(String diaInicio) {
		this.diaInicio = diaInicio;
	}

	public String getDiaFim() {
		return diaFim;
	}

	public void setDiaFim(String diaFim) {
		this.diaFim = diaFim;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getTaxaCobrada() {
		return taxaCobrada;
	}

	public void setTaxaCobrada(String taxaCobrada) {
		this.taxaCobrada = taxaCobrada;
	}
	public void setTrajeto(Trajeto trajeto){
		this.trajeto = trajeto;
	}
	public Trajeto getTrajeto(){
		return trajeto;
	}
}
