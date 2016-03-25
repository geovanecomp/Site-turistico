package service;

import java.util.Iterator;
import java.util.List;
import dao.PontuacaoEmpresaDAO;
import entities.PontuacaoEmpresa;

public class PontuacaoEmpresaService {
	PontuacaoEmpresaDAO pedao = new PontuacaoEmpresaDAO();
	public void cadastrarPontuacaoEmpresa(PontuacaoEmpresa pontuacaoEmpresa){
		pedao.cadastrarPontuacaoEmpresa(pontuacaoEmpresa);
	}
	public List<PontuacaoEmpresa> buscarPontuacaoEmpresaPeloIdEmpresa(int idEmpresa){
		return pedao.buscarPontuacaoEmpresaPeloIdEmpresa(idEmpresa);
	}
	public List<PontuacaoEmpresa> buscarPontuacaoEmpresaPeloIdEmpresaUsuario(int idEmpresa, int idUsuario){
		return pedao.buscarPontuacaoEmpresaPeloIdEmpresaUsuario(idEmpresa, idUsuario);
	}
	public int retornarMediaPontuacaoEmpresa(int idEmpresa){
		List<PontuacaoEmpresa> listaPontuacaoEmpresa = pedao.buscarPontuacaoEmpresaPeloIdEmpresa(idEmpresa);
		Iterator<PontuacaoEmpresa> elementos = listaPontuacaoEmpresa.iterator();
		PontuacaoEmpresa pontuacaoEmpresa = null;
		int pontuacao = 0;
		while(elementos.hasNext()){
			pontuacaoEmpresa = elementos.next();
			pontuacao = pontuacao+pontuacaoEmpresa.getPontuacao();			
		}
		pontuacao = pontuacao/listaPontuacaoEmpresa.size();
		return pontuacao;
	}
}
