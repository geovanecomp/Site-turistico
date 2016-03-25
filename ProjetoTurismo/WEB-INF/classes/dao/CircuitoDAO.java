package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import entities.Circuito;
import entities.Empresa;

public class CircuitoDAO {
	
	public void cadastrarCircuito(Circuito circuito){
		Connection conexao = null;
		String sql = "insert into tb_circuito(nome, data, dataCriacao, descricao, id_usuario) values (?, ?, ?, ?, ?)";
		PreparedStatement stm = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, circuito.getNome());
			stm.setDate(2, circuito.getData());
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			stm.setTimestamp(3, ts);
			stm.setString(4, circuito.getDescricao());
			stm.setInt(5, circuito.getIdUsuario());
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
	public List<Circuito> buscarTodosCircuitos(){
		List<Circuito> listaCircuitos = new ArrayList<Circuito>();
		String sql = "select * from tb_circuito";
		Connection conexao = null;
		Circuito circuito = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			 rs =  stm.executeQuery();
			while(rs.next()){
				int idCircuito = rs.getInt("id_circuito");
				String nome = rs.getString("nome");
				Date data = rs.getDate("data");
				String descricao = rs.getString("descricao");
				int idUsuario = rs.getInt("id_usuario");
				circuito = new Circuito(idCircuito, nome, data, descricao, idUsuario);
				listaCircuitos.add(circuito);
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
		return listaCircuitos;
	}
	
	public Circuito buscarCircuitoPeloId(int idCircuito){
		String sql = "select * from tb_circuito where id_circuito = ?";
		Connection conexao = null;
		Circuito circuito = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idCircuito);
			rs =  stm.executeQuery();
			while(rs.next()){
				int idCircuito2 = rs.getInt("id_circuito");
				String nome = rs.getString("nome");
				Date data = rs.getDate("data");
				String descricao = rs.getString("descricao");
				int idUsuario = rs.getInt("id_usuario");
				circuito = new Circuito(idCircuito2, nome, data, descricao, idUsuario);
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
		return circuito;
	}
	public void deletarCircuitoPeloId(int idCircuito){
		Connection conexao =  null;
		PreparedStatement stm = null;
		String sql = "delete from tb_circuito where id_circuito = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1,idCircuito);
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
			try{
				if(conexao!=null){
					conexao.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void alterarDadosCircuito(Circuito circuito){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "update tb_circuito set nome = ?, data = ?, dataCriacao = ?, descricao = ?, id_usuario = ? where id_circuito = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, circuito.getNome());
			stm.setDate(2, circuito.getData());
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			stm.setTimestamp(3, ts);
			stm.setString(4, circuito.getDescricao());
			stm.setInt(5, circuito.getIdUsuario());
			stm.setInt(6, circuito.getIdCircuito());
			
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
			try{
				if(conexao!=null){
					conexao.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
		}
	}
	
	public List<Circuito> buscarCircuitosPeloIdUsuario(int idUsuario){
		String sql = "select * from tb_circuito where id_usuario = ?";
		Connection conexao = null;
		Circuito circuito = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Circuito> listaCircuitos = new ArrayList<Circuito>();
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idUsuario);
			rs =  stm.executeQuery();
			while(rs.next()){
				int idCircuito = rs.getInt("id_circuito");
				String nome = rs.getString("nome");
				Date data = rs.getDate("data");
				String descricao = rs.getString("descricao");
				int idUsuario2 = rs.getInt("id_usuario");
				circuito = new Circuito(idCircuito, nome, data, descricao, idUsuario2);
				listaCircuitos.add(circuito);
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
		return listaCircuitos;
	}
	
}
