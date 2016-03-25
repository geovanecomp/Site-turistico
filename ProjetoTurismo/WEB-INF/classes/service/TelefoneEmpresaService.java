package service;

import java.util.List;

import dao.TelefoneEmpresaDAO;
import entities.TelefoneEmpresa;

public class TelefoneEmpresaService {
	TelefoneEmpresaDAO tedao = new TelefoneEmpresaDAO();
	public void cadastrarTelefoneEmpresa(List<String> listaTelefones, int idEmpresa){
		tedao.cadastrarTelefoneEmpresa(listaTelefones, idEmpresa);
	}
	public List<TelefoneEmpresa> buscarTelefonesPeloIdEmpresa (int idEmpresa){
		return tedao.buscarTelefonesPeloIdEmpresa(idEmpresa);
	}
	public void alterarTelefoneEmpresa(List<String> listaTelefones, int idEmpresa){
		tedao.alterarTelefoneEmpresa(listaTelefones, idEmpresa);
	}
	public void deletarTelefoneEmpresa(int idEmpresa){
		tedao.deletarTelefoneEmpresa(idEmpresa);
	}
}
