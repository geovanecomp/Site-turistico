package service;

import java.util.List;

import dao.ComentarioEmpresaDAO;
import entities.ComentarioEmpresa;

public class ComentarioEmpresaService {
	ComentarioEmpresaDAO ced = new ComentarioEmpresaDAO();
	public void cadastrarComentarioEmpresa(ComentarioEmpresa comentarioEmpresa){
		ced.cadastrarComentarioEmpresa(comentarioEmpresa);
	}
	public List<ComentarioEmpresa> buscarTodosComentariosEmpresa (int idEmpresa){
		return ced.buscarTodosComentariosEmpresa(idEmpresa);
	}
	public void deletarComentarioEmpresaPeloId(int idComentarioEmpresa){
		ced.deletarComentarioEmpresaPeloId(idComentarioEmpresa);
	}
	public void alterarComentarioEmpresa(String texto, int idComentarioEmpresa, String Data){
		ced.alterarComentarioEmpresa(texto, idComentarioEmpresa, Data);
	}
}
