package service;

import java.util.List;

import dao.ImagemEmpresaDAO;
import entities.ImagemEmpresa;

public class ImagemEmpresaService {
	ImagemEmpresaDAO iedao = new ImagemEmpresaDAO();
	public void cadastarImagemEmpresa(List<String> listaImagens, int idEmpresa){
		iedao.cadastarImagemEmpresa(listaImagens, idEmpresa);
	}
	public List<ImagemEmpresa> buscarImagensPeloIdEmpresa (int idEmpresa){
		return iedao.buscarImagensPeloIdEmpresa(idEmpresa);
	}
	public void alterarImagemEmpresa(List<String> listaImagens, int idEmpresa){
		iedao.alterarImagemEmpresa(listaImagens, idEmpresa);
	}
}
