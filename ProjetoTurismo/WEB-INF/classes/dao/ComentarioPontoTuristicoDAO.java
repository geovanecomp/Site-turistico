package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.ComentarioPontoTuristico;
import entities.Usuario;

public class ComentarioPontoTuristicoDAO {
	public void cadastrarComentarioPontoTuristico(ComentarioPontoTuristico comentarioPontoTuristico){
		Connection conexao = null;
		String sql = "insert into tb_comentario_ponto_turistico(data, texto, id_usuario, id_ponto_turistico) values (?, ?, ?, ?)";
		PreparedStatement stm = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, comentarioPontoTuristico.getData());
			stm.setString(2, comentarioPontoTuristico.getTexto());
			stm.setInt(3, comentarioPontoTuristico.getIdUsuario());
			stm.setInt(4, comentarioPontoTuristico.getIdPontoTuristico());
			
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
	public List<ComentarioPontoTuristico> buscarTodosComentariosPontoTuristico (int idPontoTuristico){
		String sql = "select * from tb_comentario_ponto_turistico where id_ponto_turistico = ?";
		Connection conexao = null;
		ComentarioPontoTuristico comentarioPontoTuristico = null;
		List<ComentarioPontoTuristico> listaComentarioPontoTuristico = new ArrayList<ComentarioPontoTuristico>();
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idPontoTuristico);
			 rs =  stm.executeQuery();
			 UsuarioDAO udao = new UsuarioDAO();
			 Usuario usuario = null;
			while(rs.next()){
				int idComentarioPontoTuristico = rs.getInt("id_comentario_ponto_turistico");
				String data = rs.getString("data");
				String texto = rs.getString("texto");
				int idUsuario = rs.getInt("id_usuario");
				usuario = udao.buscarUsuarioPeloId(idUsuario);
				comentarioPontoTuristico = new ComentarioPontoTuristico(idComentarioPontoTuristico, data, texto, idUsuario, idPontoTuristico, usuario);
				listaComentarioPontoTuristico.add(comentarioPontoTuristico);
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
		
		return listaComentarioPontoTuristico;
	}
	public void deletarComentarioPontoTuristicoPeloId(int idComentarioPontoTuristico){
		Connection conexao =  null;
		PreparedStatement stm = null;
		String sql = "delete from tb_comentario_ponto_turistico where id_comentario_ponto_turistico = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1,idComentarioPontoTuristico);
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
	
	public void alterarComentarioPontoTuristico(String texto, int idComentarioPontoTuristico, String data){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "update tb_comentario_ponto_turistico set data = ?, texto = ? where id_comentario_ponto_turistico = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, data);
			stm.setString(2, texto);
			stm.setInt(3, idComentarioPontoTuristico);
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
