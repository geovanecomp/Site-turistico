package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.TrajetoDAO;
import entities.Empresa;
import entities.PontoTuristico;
import entities.Trajeto;

public class TrajetoService {
	TrajetoDAO tdao = new TrajetoDAO();
	public void cadastrarTrajeto(Trajeto trajeto){
		tdao.cadastrarTrajeto(trajeto);
	}
	public Trajeto buscarUltimoTrajeto(){
		return tdao.buscarUltimoTrajeto();
	}
	public List<Trajeto> buscarTrajetoPeloIdCircuito(int idCircuito){
		return tdao.buscarTrajetoPeloIdCircuito(idCircuito);
	}
	
	public void deletarTrajetoPeloId(int idTrajeto){
		tdao.deletarTrajetoPeloId(idTrajeto);
	}
	
	public void deletarTrajetoPeloIdEmpresa(int idEmpresa){
		tdao.deletarTrajetoPeloIdEmpresa(idEmpresa);
	}
	
	public void deletarTrajetoPeloIdPontoTuristico(int idPontoTuristico){
		tdao.deletarTrajetoPeloIdPontoTuristico(idPontoTuristico);
	}
	
	public List<Empresa> retornaEmpresa(List<Trajeto> listaTrajetos){
		Iterator<Trajeto> elementos = listaTrajetos.iterator();
		List<Empresa> listaEmpresas = new ArrayList<Empresa>();
		EmpresaService es = new EmpresaService();
		while(elementos.hasNext()){
			int idEmpresa = elementos.next().getIdEmpresa();
			if(idEmpresa>0){
				listaEmpresas.add(es.buscarEmpresaPeloId(idEmpresa));	
			}
		}
		return listaEmpresas;
	}
	
	public List<PontoTuristico> retornaPontoTuristico(List<Trajeto> listaTrajetos){
		Iterator<Trajeto> elementos = listaTrajetos.iterator();
		List<PontoTuristico> listaPontoTuristicos = new ArrayList<PontoTuristico>();
		PontoTuristicoService pts = new PontoTuristicoService();
		while(elementos.hasNext()){
			int idPontoTuristico = elementos.next().getIdPontoTuristico();
			if(idPontoTuristico>0){
				listaPontoTuristicos.add(pts.buscarPontoTuristicoPeloId(idPontoTuristico));	
			}
		}
		return listaPontoTuristicos;
	}
	
}
