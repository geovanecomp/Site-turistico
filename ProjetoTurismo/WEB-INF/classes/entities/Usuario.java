package entities;

import java.sql.Date;

public class Usuario{
	private int idUsuario;
	private String nome;
	private String login;
	private String senha;
	private String email;
	private String sexo;
	private Date nascimento;
	private String cidade;
	private String estado;
	private String profissao;
	private String estadoCivil;
	private String escolaridade;
	int intNascimento;
	private int administrador;

	public Usuario(){
		
	}
	
	public Usuario(String nome, String login, String senha,
			String email, String sexo, Date nascimento, String cidade,
			String estado, String profissao, String estadoCivil,
			String escolaridade, int administrador) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.profissao = profissao;
		this.estadoCivil = estadoCivil;
		this.escolaridade = escolaridade;
		this.administrador =  administrador;
	}
	
	public Usuario(int idUsuario, String nome, String login, String senha,
			String email, String sexo, Date nascimento, String cidade,
			String estado, String profissao, String estadoCivil,
			String escolaridade) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.profissao = profissao;
		this.estadoCivil = estadoCivil;
		this.escolaridade = escolaridade;
	}

	public Usuario(int idUsuario, String nome, String login, String senha,
			String email, String sexo, Date nascimento, String cidade,
			String estado, String profissao, String estadoCivil,
			String escolaridade, int administrador) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.profissao = profissao;
		this.estadoCivil = estadoCivil;
		this.escolaridade = escolaridade;
		this.administrador =  administrador;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public int getAdministrador() {
		return administrador;
	}
	
	public int getIntNascimento() {
		return intNascimento;
	}

	public void setIntNascimento(int intNascimento) {
		this.intNascimento = intNascimento;
	}

	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}
	
	public String getDataFormatada(){
		String strNascimento = nascimento+"";
		long longNascimento = 0;
		String aux ="";
		for(int i = 0; i<10;i++){
			if(strNascimento.charAt(i)!= '-'){
				aux = aux+strNascimento.charAt(i);
			}
		}
		String strDia = longNascimento%100+"";
		String strMes = (longNascimento/100)%100+"";
		String strAno = longNascimento/10000+"";
		strNascimento = strDia+"/"+strMes+"/"+strAno;
		return strNascimento;
	}
}
