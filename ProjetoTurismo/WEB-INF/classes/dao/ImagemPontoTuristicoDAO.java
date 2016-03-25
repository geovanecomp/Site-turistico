package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import entities.ImagemPontoTuristico;

public class ImagemPontoTuristicoDAO {
	public void cadastarImagemPontoTuristicoDAO(List<String> listaImagens, int idPontoTuristico){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "insert into tb_imagem_ponto_turistico (id_ponto_turistico, imagem) values (?, ?)";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			Iterator<String> elementos = listaImagens.iterator();
			while(elementos.hasNext()){
				stm.setInt(1, idPontoTuristico);
				stm.setString(2, elementos.next());
				stm.execute();	
			}			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(stm!=null){
					stm.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
		}
	}
	public List<ImagemPontoTuristico> buscarImagensPeloIdPontoTuristico(int idPontoTuristico){
		List<ImagemPontoTuristico> listaImagensPontosTuristicos = new ArrayList<ImagemPontoTuristico>();
		String sql = "select * from tb_imagem_ponto_turistico where id_ponto_turistico = ?";
		Connection conexao = null;
		ImagemPontoTuristico imagemPontoTuristico = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idPontoTuristico);
			 rs =  stm.executeQuery();
			while(rs.next()){
				int idImagemPontoTuristico = rs.getInt("id_imagem_ponto_turistico");
				int idPontoTuristico2 = rs.getInt("id_ponto_turistico");
				String imagem = rs.getString("imagem");
				imagemPontoTuristico = new ImagemPontoTuristico(idImagemPontoTuristico, idPontoTuristico2, imagem);
				listaImagensPontosTuristicos.add(imagemPontoTuristico);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(stm!=null){
					stm.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			try{
				if(rs!=null){
					rs.close();
				}
			}
			catch(SQLException e){
					
			}
			try{
				if(conexao!=null){
					conexao.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		return listaImagensPontosTuristicos; 
	}
}
