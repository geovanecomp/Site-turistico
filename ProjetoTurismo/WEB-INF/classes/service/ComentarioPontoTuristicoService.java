package service;

import java.util.List;

import dao.ComentarioPontoTuristicoDAO;
import entities.ComentarioPontoTuristico;

public class ComentarioPontoTuristicoService {
	ComentarioPontoTuristicoDAO cptdao = new ComentarioPontoTuristicoDAO();
	public void cadastrarComentarioPontoTuristico(ComentarioPontoTuristico comentarioPontoTuristico){
		cptdao.cadastrarComentarioPontoTuristico(comentarioPontoTuristico);
	}
	public List<ComentarioPontoTuristico> buscarTodosComentariosPontoTuristico (int idPontoTuristico){
		return cptdao.buscarTodosComentariosPontoTuristico(idPontoTuristico);
	}
	public void deletarComentarioPontoTuristicoPeloId(int idComentarioPontoTuristico){
		cptdao.deletarComentarioPontoTuristicoPeloId(idComentarioPontoTuristico);
	}
	public void alterarComentarioPontoTuristico(String texto, int idComentarioPontoTuristico, String data){
		cptdao.alterarComentarioPontoTuristico(texto, idComentarioPontoTuristico, data);
	}
}
