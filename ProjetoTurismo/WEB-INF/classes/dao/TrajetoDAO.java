	package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Trajeto;

public class TrajetoDAO {
	public void cadastrarTrajeto(Trajeto trajeto){
		Connection conexao = null;
		String sql = "insert into tb_trajeto(id_trajeto, data, id_usuario, id_empresa, id_ponto_turistico, id_circuito) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement stm = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, trajeto.getIdTrajeto());
			stm.setDate(2, trajeto.getData());
			stm.setInt(3, trajeto.getIdUsuario());
			stm.setInt(4, trajeto.getIdEmpresa());
			stm.setInt(5, trajeto.getIdPontoTuristico());
			stm.setInt(6, trajeto.getIdCircuito());
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
	public Trajeto buscarUltimoTrajeto(){
		String sql = "select * from tb_trajeto order by id_trajeto DESC  ";
		Connection conexao = null;
		Trajeto  trajeto  = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			rs =  stm.executeQuery();
			while(rs.next()){
				int idTrajeto = rs.getInt("id_trajeto");
				Date data = rs.getDate("data");
				int idUsuario = rs.getInt("id_usuario");
				int idEmpresa = rs.getInt("id_empresa");
				int idPontoTuristico = rs.getInt("id_ponto_turistico");
				int idCircuito = rs.getInt("id_circuito");
				trajeto = new Trajeto(idTrajeto, data, idUsuario, idEmpresa, idPontoTuristico, idCircuito);
				break;
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
		return trajeto;
		
	}
	public List<Trajeto> buscarTrajetoPeloIdCircuito(int idCircuito){
		String sql = "select * from tb_trajeto where id_circuito = ?";
		Connection conexao = null;
		List<Trajeto> listaTrajetos = new ArrayList<Trajeto>();
		Trajeto  trajeto  = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idCircuito);
			rs =  stm.executeQuery();
			while(rs.next()){
				int idTrajeto = rs.getInt("id_trajeto");
				Date data = rs.getDate("data");
				int idUsuario = rs.getInt("id_usuario");
				int idEmpresa = rs.getInt("id_empresa");
				int idPontoTuristico = rs.getInt("id_ponto_turistico");
				int idCircuito2 = rs.getInt("id_circuito");
				trajeto = new Trajeto(idTrajeto, data, idUsuario, idEmpresa, idPontoTuristico, idCircuito2);
				listaTrajetos.add(trajeto);
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
		return listaTrajetos;
		
	}
	
	public void deletarTrajetoPeloId(int idTrajeto){
		Connection conexao =  null;
		PreparedStatement stm = null;
		String sql = "delete from tb_trajeto where id_trajeto = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1,idTrajeto);
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
	
	public void deletarTrajetoPeloIdEmpresa(int idEmpresa){
		Connection conexao =  null;
		PreparedStatement stm = null;
		String sql = "delete from tb_trajeto where id_empresa = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1,idEmpresa);
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
	
	public void deletarTrajetoPeloIdPontoTuristico(int idPontoTuristico){
		Connection conexao =  null;
		PreparedStatement stm = null;
		String sql = "delete from tb_trajeto where id_ponto_turistico = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1,idPontoTuristico);
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
}
