package service;

import java.util.List;

import dao.PontoTuristicoDAO;
import entities.PontoTuristico;

public class PontoTuristicoService {
	PontoTuristicoDAO ptdao = new PontoTuristicoDAO();
	public void cadastrarPontoTuristico(PontoTuristico pontoTuristico){
		ptdao.cadastrarPontoTuristico(pontoTuristico);
	}
	public PontoTuristico buscarUltimoPontoTuristico(){
		return ptdao.buscarUltimoPontoTuristico();
	}
	public List<PontoTuristico> buscarCincoUltimosPontoTuristicos(){
		return ptdao.buscarCincoUltimosPontoTuristicos();
	}
	public List<PontoTuristico> buscarDoisUltimosPontoTuristicos(){
		return ptdao.buscarDoisUltimosPontoTuristicos();
	}
	public List<PontoTuristico> buscarPontoTuristicoPeloNome(String nome){
		return ptdao.buscarPontoTuristicoPeloNome(nome);
	}
	public PontoTuristico buscarPontoTuristicoPeloId(int idPontoTuristico){
		return ptdao.buscarPontoTuristicoPeloId(idPontoTuristico);
	}
	public List<PontoTuristico> buscarTodosPontosTuristicos(){
		return ptdao.buscarTodosPontosTuristicos();
	}
	public void deletarPontoTuristicoPeloId(int idPontoTuristico){
		ptdao.deletarPontoTuristicoPeloId(idPontoTuristico);
	}
	public void alterarDadosPontoTuristico(PontoTuristico pontoTuristico){
		ptdao.alterarDadosPontoTuristico(pontoTuristico);
	}
	public void alterarPontuacaoEmpresa(int idPontoTuristico, int pontuacao){
		ptdao.alterarPontuacaoEmpresa(idPontoTuristico, pontuacao);
	}
	public List<PontoTuristico> buscarPontoTuristicoPorParteDoNome(String nome){
		return ptdao.buscarPontoTuristicoPorParteDoNome(nome);
	}
	public List<PontoTuristico> buscarPontoTuristicoPeloDistrito(String distrito){
		return ptdao.buscarPontoTuristicoPeloDistrito(distrito);
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
