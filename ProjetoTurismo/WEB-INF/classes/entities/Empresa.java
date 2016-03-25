package entities;

public class Empresa {//atualizar com as informações propostas por Marcelo
	private int idEmpresa;
	private String nome;
	private String categoria;
	private String descricao;
	private String email;
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
	private String gastoMedio;
	private String cnpj;
	private Trajeto trajeto;

	public Empresa(){
		
	}

	public Empresa(String nome, String categoria, String descricao,
			String email, String estado, String cidade, String distrito,
			String endereco, String cep, String horarioInicio,
			String horarioFim, String diaInicio, String diaFim, int pontuacao,
			String gastoMedio, String cnpj) {
		this.nome = nome;
		this.categoria = categoria;
		this.descricao = descricao;
		this.email = email;
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
		this.gastoMedio = gastoMedio;
		this.cnpj = cnpj;
	}
	
	public Empresa(int idEmpresa, String nome, String categoria, String descricao,
			String email, String estado, String cidade, String distrito,
			String endereco, String cep, String horarioInicio,
			String horarioFim, String diaInicio, String diaFim, int pontuacao,
			String gastoMedio, String cnpj) {
		this.idEmpresa = idEmpresa;
		this.nome = nome;
		this.categoria = categoria;
		this.descricao = descricao;
		this.email = email;
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
		this.gastoMedio = gastoMedio;
		this.cnpj = cnpj;
	}

	public int getidEmpresa() {
		return idEmpresa;
	}

	public void setidEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getGastoMedio() {
		return gastoMedio;
	}

	public void setGastoMedio(String gastoMedio) {
		this.gastoMedio = gastoMedio;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public void setTrajeto(Trajeto trajeto){
		this.trajeto = trajeto;
	}
	public Trajeto getTrajeto(){
		return trajeto;
	}
}
