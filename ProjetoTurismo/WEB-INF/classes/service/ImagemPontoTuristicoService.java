package service;

import java.util.List;

import dao.ImagemPontoTuristicoDAO;
import entities.ImagemPontoTuristico;

public class ImagemPontoTuristicoService {

	ImagemPontoTuristicoDAO iptd = new ImagemPontoTuristicoDAO();
	public void cadastarImagemPontoTuristicoDAO(List<String> listaImagens, int idPontoTuristico){
		iptd.cadastarImagemPontoTuristicoDAO(listaImagens, idPontoTuristico);
	}
	public List<ImagemPontoTuristico> buscarImagensPeloIdPontoTuristico(int idPontoTuristico){
		return iptd.buscarImagensPeloIdPontoTuristico(idPontoTuristico);
	}
}
