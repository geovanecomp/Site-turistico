package service;

import java.util.Iterator;
import java.util.List;
import dao.PontuacaoPontoTuristicoDAO;
import entities.PontuacaoPontoTuristico;

public class PontuacaoPontoTuristicoService {
	PontuacaoPontoTuristicoDAO pptdao = new PontuacaoPontoTuristicoDAO();
	public void cadastrarPontuacaoPontuacaoPontoTuristico(PontuacaoPontoTuristico pontuacaoPontoTuristico){
		pptdao.cadastrarPontuacaoPontuacaoPontoTuristico(pontuacaoPontoTuristico);
	}
	public List<PontuacaoPontoTuristico> buscarPontuacaoPontoTuristicoPeloIdPontoTuristico(int idPontoTuristico){
		return pptdao.buscarPontuacaoPontoTuristicoPeloIdPontoTuristico(idPontoTuristico);
	}
	public List<PontuacaoPontoTuristico> buscarPontuacaoPontoTuristicoPeloIdPontoTuristicoUsuario(int idPontoTuristico, int idUsuario){
		return pptdao.buscarPontuacaoPontoTuristicoPeloIdPontoTuristicoUsuario(idPontoTuristico, idUsuario);
	}
	public int retornarMediaPontuacaoPontoTuristico(int idPontoTuristico){
		List<PontuacaoPontoTuristico> listaPontuacaoPontoTuristico = pptdao.buscarPontuacaoPontoTuristicoPeloIdPontoTuristico(idPontoTuristico);
		Iterator<PontuacaoPontoTuristico> elementos = listaPontuacaoPontoTuristico.iterator();
		PontuacaoPontoTuristico pontuacaoPontoTuristico = null;
		int pontuacao = 0;
		while(elementos.hasNext()){
			pontuacaoPontoTuristico = elementos.next();
			pontuacao = pontuacao+pontuacaoPontoTuristico.getPontuacao();			
		}
		pontuacao = pontuacao/listaPontuacaoPontoTuristico.size();
		return pontuacao;
	}
}
