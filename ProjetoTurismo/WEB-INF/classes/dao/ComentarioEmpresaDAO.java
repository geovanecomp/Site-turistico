package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.ComentarioEmpresa;
import entities.Usuario;

public class ComentarioEmpresaDAO {
	public void cadastrarComentarioEmpresa(ComentarioEmpresa comentarioEmpresa){
		Connection conexao = null;
		String sql = "insert into tb_comentario_empresa(data, texto, id_usuario, id_empresa) values (?, ?, ?, ?)";
		PreparedStatement stm = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, comentarioEmpresa.getData());
			stm.setString(2, comentarioEmpresa.getTexto());
			stm.setInt(3, comentarioEmpresa.getIdUsuario());
			stm.setInt(4, comentarioEmpresa.getIdEmpresa());
			
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
	public List<ComentarioEmpresa> buscarTodosComentariosEmpresa (int idEmpresa){
		String sql = "select * from tb_comentario_empresa where id_empresa = ?";
		Connection conexao = null;
		ComentarioEmpresa comentarioEmpresa = null;
		List<ComentarioEmpresa> listaComentarioEmpresa = new ArrayList<ComentarioEmpresa>();
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idEmpresa);
			 rs =  stm.executeQuery();
			 UsuarioDAO udao = new UsuarioDAO();
			 Usuario usuario = null;
			while(rs.next()){
				int idComentarioEmpresa = rs.getInt("id_comentario_empresa");
				String data = rs.getString("data");
				String texto = rs.getString("texto");
				int idUsuario = rs.getInt("id_usuario");
				usuario = udao.buscarUsuarioPeloId(idUsuario);
				comentarioEmpresa = new ComentarioEmpresa(idComentarioEmpresa, data, texto, idUsuario, idEmpresa, usuario);
				listaComentarioEmpresa.add(comentarioEmpresa);
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
		
		return listaComentarioEmpresa;
	}
	public void deletarComentarioEmpresaPeloId(int idComentarioEmpresa){
		Connection conexao =  null;
		PreparedStatement stm = null;
		String sql = "delete from tb_comentario_empresa where id_comentario_empresa = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1,idComentarioEmpresa);
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
	
	public void alterarComentarioEmpresa(String texto, int idComentarioEmpresa, String data){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "update tb_comentario_empresa set data = ?, texto = ? where id_comentario_empresa = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, data);
			stm.setString(2, texto);
			stm.setInt(3, idComentarioEmpresa);
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
