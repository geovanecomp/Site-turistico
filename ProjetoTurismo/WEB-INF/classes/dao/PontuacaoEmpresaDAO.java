package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.PontuacaoEmpresa;

public class PontuacaoEmpresaDAO {
	public void cadastrarPontuacaoEmpresa(PontuacaoEmpresa pontuacaoEmpresa){
		Connection conexao = null;
		String sql = "insert into tb_pontuacao_empresa(id_empresa, id_usuario, pontuacao) values (?, ?, ?)";
		PreparedStatement stm = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, pontuacaoEmpresa.getIdEmpresa());
			stm.setInt(2, pontuacaoEmpresa.getIdUsuario());
			stm.setInt(3, pontuacaoEmpresa.getPontuacao());
			
			
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
	public List<PontuacaoEmpresa> buscarPontuacaoEmpresaPeloIdEmpresa(int idEmpresa){
		String sql = "select * from tb_pontuacao_empresa where id_empresa = ?";
		Connection conexao = null;
		PontuacaoEmpresa pontuacaoEmpresa = null;
		List<PontuacaoEmpresa> listaPontuacaoEmpresa = new ArrayList<PontuacaoEmpresa>();
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idEmpresa);
			 rs =  stm.executeQuery();
			while(rs.next()){
				int idPontuacaoEmpresa = rs.getInt("id_pontuacao_empresa");
				int idEmpresa2 = rs.getInt("id_empresa");
				int idUsuario = rs.getInt("id_usuario");
				int pontuacao = rs.getInt("pontuacao");
				pontuacaoEmpresa = new PontuacaoEmpresa(idPontuacaoEmpresa, idEmpresa2, idUsuario, pontuacao);
				listaPontuacaoEmpresa.add(pontuacaoEmpresa);
				
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
		return listaPontuacaoEmpresa;
	}
	public List<PontuacaoEmpresa> buscarPontuacaoEmpresaPeloIdEmpresaUsuario(int idEmpresa, int idUsuario){
		String sql = "select * from tb_pontuacao_empresa where id_empresa = ? and id_usuario = ?";
		Connection conexao = null;
		PontuacaoEmpresa pontuacaoEmpresa = null;
		List<PontuacaoEmpresa> listaPontuacaoEmpresa = new ArrayList<PontuacaoEmpresa>();
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idEmpresa);
			stm.setInt(2, idUsuario);
			 rs =  stm.executeQuery();
			while(rs.next()){
				int idPontuacaoEmpresa = rs.getInt("id_pontuacao_empresa");
				int idEmpresa2 = rs.getInt("id_empresa");
				int idUsuario2 = rs.getInt("id_usuario");
				int pontuacao = rs.getInt("pontuacao");
				pontuacaoEmpresa = new PontuacaoEmpresa(idPontuacaoEmpresa, idEmpresa2, idUsuario2, pontuacao);
				listaPontuacaoEmpresa.add(pontuacaoEmpresa);
				
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
		return listaPontuacaoEmpresa;
	}
}
