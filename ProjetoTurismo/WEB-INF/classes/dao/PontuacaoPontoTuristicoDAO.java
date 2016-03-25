package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.PontuacaoPontoTuristico;

public class PontuacaoPontoTuristicoDAO {
	public void cadastrarPontuacaoPontuacaoPontoTuristico(PontuacaoPontoTuristico pontoTuristico){
		Connection conexao = null;
		String sql = "insert into tb_pontuacao_ponto_turistico(id_ponto_turistico, id_usuario, pontuacao) values (?, ?, ?)";
		PreparedStatement stm = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, pontoTuristico.getIdPontoTuristico());
			stm.setInt(2, pontoTuristico.getIdUsuario());
			stm.setInt(3, pontoTuristico.getPontuacao());
			
			
			stm.execute();
			
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
	public List<PontuacaoPontoTuristico> buscarPontuacaoPontoTuristicoPeloIdPontoTuristico(int idPontoTuristico){
		String sql = "select * from tb_pontuacao_ponto_turistico where id_ponto_turistico = ?";
		Connection conexao = null;
		PontuacaoPontoTuristico pontuacaoPontoTuristico = null;
		List<PontuacaoPontoTuristico> listaPontuacaoPontoTuristico = new ArrayList<PontuacaoPontoTuristico>();
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idPontoTuristico);
			 rs =  stm.executeQuery();
			while(rs.next()){
				int idPontuacaoPontoTuristico = rs.getInt("id_pontuacao_ponto_turistico");
				int idPontoTuristico2 = rs.getInt("id_ponto_turistico");
				int idUsuario = rs.getInt("id_usuario");
				int pontuacao = rs.getInt("pontuacao");
				pontuacaoPontoTuristico = new PontuacaoPontoTuristico(idPontuacaoPontoTuristico, idPontoTuristico2, idUsuario, pontuacao);
				listaPontuacaoPontoTuristico.add(pontuacaoPontoTuristico);
				
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
		return listaPontuacaoPontoTuristico;
	}
	public List<PontuacaoPontoTuristico> buscarPontuacaoPontoTuristicoPeloIdPontoTuristicoUsuario(int idPontoTuristico, int idUsuario){
		String sql = "select * from tb_pontuacao_ponto_turistico where id_ponto_turistico = ? and id_usuario = ?";
		Connection conexao = null;
		PontuacaoPontoTuristico pontuacaoPontoTuristico = null;
		List<PontuacaoPontoTuristico> listaPontuacaoPontoTuristico = new ArrayList<PontuacaoPontoTuristico>();
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idPontoTuristico);
			stm.setInt(2, idUsuario);
			 rs =  stm.executeQuery();
			while(rs.next()){
				int idPontuacaoPontoTuristico = rs.getInt("id_pontuacao_ponto_turistico");
				int idPontoTuristico2 = rs.getInt("id_ponto_turistico");
				int idUsuario2 = rs.getInt("id_usuario");
				int pontuacao = rs.getInt("pontuacao");
				pontuacaoPontoTuristico = new PontuacaoPontoTuristico(idPontuacaoPontoTuristico, idPontoTuristico2, idUsuario2, pontuacao);
				listaPontuacaoPontoTuristico.add(pontuacaoPontoTuristico);
				
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
		return listaPontuacaoPontoTuristico;
	}
}
