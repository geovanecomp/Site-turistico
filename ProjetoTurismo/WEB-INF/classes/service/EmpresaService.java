package service;

import java.util.List;

import dao.EmpresaDAO;
import entities.Empresa;

public class EmpresaService {
	EmpresaDAO edao = new EmpresaDAO();
	public void cadastrarEmpresa(Empresa empresa){
		edao.cadastrarEmpresa(empresa);
	}
	public Empresa buscarEmpresaPeloCnpj(String cnpj){
		return edao.buscarEmpresaPeloCnpj(cnpj);
	}
	public Empresa buscarUltimaEmpresa(){
		return edao.buscarUltimaEmpresa();
	}
	public List<Empresa> buscarCincoUltimasEmpresas(){
		return edao.buscarCincoUltimasEmpresas();
	}
	public List<Empresa> buscarDuasUltimasEmpresas(){
		return edao.buscarDuasUltimasEmpresas();
	}
	public List<Empresa> buscarTodasEmpresas(){
		return edao.buscarTodasEmpresas();
	}
	public Empresa buscarEmpresaPeloId(int idEmpresa){
		return edao.buscarEmpresaPeloId(idEmpresa);
	}
	public void deletarEmpresaPeloId(int idEmpresa){
		edao.deletarEmpresaPeloId(idEmpresa);
	}
	public void alterarDadosEmpresa(Empresa empresa){
		edao.alterarDadosEmpresa(empresa);
	}
	public void alterarPontuacaoEmpresa(int idEmpresa, int pontuacao){
		edao.alterarPontuacaoEmpresa(idEmpresa, pontuacao);
	}
	public List<Empresa> buscarEmpresaPeloNome(String nome){
		return edao.buscarEmpresaPeloNome(nome);
	}
	public List<Empresa> buscarEmpresaPorParteDoNome(String nome){
		return edao.buscarEmpresaPorParteDoNome(nome);
	}
	public List<Empresa> buscarEmpresaPeloDistrito(String distrito){
		return edao.buscarEmpresaPeloDistrito(distrito);
	}
	public boolean validarCnpj(String cnpj){
		boolean aprovado = false;
		int cont = 0;
		String strCnpj = "";
		int[] vetor1 = new int[12];
		int[] vetor2 = new int[13];
		for(int i = 0;i<cnpj.length();i++){
			if(cnpj.charAt(i) !='.' && cnpj.charAt(i) !='/' && cnpj.charAt(i) !='-'){
				strCnpj=strCnpj+cnpj.charAt(i);
				if(i<cnpj.length()-3){
					vetor1[cont] = Integer.parseInt(cnpj.charAt(i)+"");
					vetor2[cont] = vetor1[cont];
					cont=cont+1;
				}
			}
		}
		long digitoVerificador = Long.parseLong(strCnpj)%100;

		int aux =2;
		for(int i = vetor1.length-1 ; i>=4 ; i--){
			vetor1[i]=vetor1[i]*aux;
			aux=aux+1;
		}
		aux =5;
		for(int i=0 ; i<=4; i++){
			vetor1[i] = vetor1[i]*aux;
			aux = aux-1;
		}
		
		int resultado1 = 0;
		for(int i = 0; i<vetor1.length;i++){
			resultado1 = resultado1+vetor1[i];
		}
		
		resultado1 = resultado1%11;
		if(resultado1<2){
			resultado1 = 0;
		}
		else{
			resultado1 = 11-resultado1;
		}
		vetor2[12] = resultado1;
		
		//--------------------------------------------------------
		
		aux =2;
		for(int i = vetor2.length-1 ; i>4 ; i--){
			vetor2[i]=vetor2[i]*aux;
			aux=aux+1;
		}
		aux =6;
		for(int i=0 ; i<=4; i++){
			vetor2[i] = vetor2[i]*aux;
			aux = aux-1;
		}

		int resultado2 = 0;
		for(int i = 0; i<vetor2.length;i++){
			resultado2 = resultado2+vetor2[i];
		}
		
		resultado2 = resultado2%11;
		if(resultado2<2){
			resultado2 = 0;
		}
		else{
			resultado2 = 11-resultado2;
		}
		int resultado = Integer.parseInt(resultado1+""+resultado2);
		if(resultado==digitoVerificador){
			aprovado = true;
		}
		return aprovado;
	}
	
	public boolean validarHora(String horarioInicio, String horarioFim){//considerando hora como no seguinte formato: "00:00"
		boolean horarioValido = true;
		if(horarioInicio.length()>0 && horarioFim.length()>0){
			if(Integer.parseInt(horarioInicio.charAt(0)+"")>2 || Integer.parseInt(horarioFim.charAt(0)+"")>2){
				horarioValido = false;
			}
			else if((Integer.parseInt(horarioInicio.charAt(0)+"")==2  && Integer.parseInt(horarioInicio.charAt(1)+"")>4) || 
					(Integer.parseInt(horarioFim.charAt(0)+"")==2 && Integer.parseInt(horarioFim.charAt(1)+"")>4)){
				horarioValido = false;
			}
			else if((Integer.parseInt(horarioInicio.charAt(0)+"")==2  && Integer.parseInt(horarioInicio.charAt(1)+"")==4 &&
					(Integer.parseInt(horarioInicio.charAt(3)+"")>0 || Integer.parseInt(horarioInicio.charAt(4)+"")>0)) || 
					(Integer.parseInt(horarioFim.charAt(0)+"")==2 && Integer.parseInt(horarioFim.charAt(1)+"")==4 &&
					(Integer.parseInt(horarioFim.charAt(3)+"")>0 || Integer.parseInt(horarioFim.charAt(4)+"")>0))){
				horarioValido = false;
			}
			else if(Integer.parseInt(horarioInicio.charAt(3)+"")>6 || Integer.parseInt(horarioFim.charAt(3)+"")>6){
				horarioValido = false;
			}
		}
		else{
			horarioValido=false;
		}
				
		return horarioValido;
	}
}
