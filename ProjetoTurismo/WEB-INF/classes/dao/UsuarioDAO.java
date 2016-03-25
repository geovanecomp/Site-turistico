package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Usuario;

public class UsuarioDAO {
	public void cadastrarUsuario(Usuario usuario){
		Connection conexao = null;
		String sql = "insert into tb_usuario(nome, login, senha, email, sexo, nascimento, cidade, estado, profissao, estadoCivil, escolaridade, administrador) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stm = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getLogin());
			stm.setString(3, usuario.getSenha());
			stm.setString(4, usuario.getEmail());
			stm.setString(5, usuario.getSexo());
			stm.setDate(6, usuario.getNascimento());
			stm.setString(7, usuario.getCidade());
			stm.setString(8, usuario.getEstado());
			stm.setString(9, usuario.getProfissao());
			stm.setString(10, usuario.getEstadoCivil());
			stm.setString(11, usuario.getEscolaridade());
			stm.setInt(12, usuario.getAdministrador());
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
	
	public Usuario buscarUsuarioPorLogin(String login){
		String sql = "select * from tb_usuario where login = ?";
		Connection conexao = null;
		Usuario usuario = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, login);
			 rs =  stm.executeQuery();
			while(rs.next()){
				int idUsuario = rs.getInt("id_usuario");
				String nome = rs.getString("nome");
				String login2 = rs.getString("login");
				String senha = rs.getString("senha");
				String sexo = rs.getString("sexo");
				String email = rs.getString("email");
				Date nascimento = rs.getDate("nascimento");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				String profissao = rs.getString("profissao");
				String estadoCivil = rs.getString("estadoCivil");
				String escolaridade = rs.getString("escolaridade");
				int administrador = rs.getInt("administrador");
				usuario = new Usuario(idUsuario, nome, login2, senha, email, sexo, nascimento, cidade, estado, profissao, estadoCivil, escolaridade, administrador);
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
		
		return usuario;
	}
	public Usuario buscarUsuarioPeloId(int id){
		PreparedStatement stm = null;
		Connection conexao = null;
		ResultSet rs = null;
		Usuario usuario = null;
		String sql = "select * from tb_usuario where id_usuario = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1,id);
			rs = stm.executeQuery();
			while(rs.next()){
				String nome = rs.getString("nome");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				String email = rs.getString("email");
				String sexo = rs.getString("sexo");
				Date nascimento = rs.getDate("nascimento");
				String cidade= rs.getString("cidade");
				String estado = rs.getString("estado");
				String profissao = rs.getString("profissao");
				String estadoCivil = rs.getString("estadoCivil");
				String escolaridade = rs.getString("escolaridade");
				int administrador = rs.getInt("administrador");
				usuario = new Usuario(id, nome, login, senha, email, sexo, nascimento, cidade, estado, profissao, estadoCivil, escolaridade,administrador);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null){
					rs.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
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
		return usuario;
	}
	public List<Usuario> buscarTodosUsuarios(){
		Connection conexao = null;
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		String sql = "select * from tb_usuario";
		PreparedStatement stm = null;
		ResultSet rs = null;
		Usuario usuario = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				int idUsuario = rs.getInt("id_usuario");
				String nome = rs.getString("nome");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				String email = rs.getString("email");
				String sexo = rs.getString("sexo");
				Date nascimento = rs.getDate("nascimento");
				String cidade= rs.getString("cidade");
				String estado = rs.getString("estado");
				String profissao = rs.getString("profissao");
				String estadoCivil = rs.getString("estadoCivil");
				String escolaridade = rs.getString("escolaridade");
				int administrador = rs.getInt("administrador");
				usuario = new Usuario(idUsuario, nome, login, senha, email, sexo, nascimento, cidade, estado, profissao, estadoCivil, escolaridade, administrador);
				listaUsuario.add(usuario);				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null){
					rs.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
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

		return listaUsuario;
	}
	public void deletarUsuarioPeloId(int idUsuario){
		Connection conexao =  null;
		PreparedStatement stm = null;
		String sql = "delete from tb_usuario where id_usuario = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1,idUsuario);
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
		
	public List<Usuario> buscarUsuarioPeloNome(String nome){
		Connection conexao = null;
		List<Usuario> listaUsuario =  new ArrayList<Usuario>();
		PreparedStatement stm = null;
		String sql = "select * from tb_usuario where nome = ?";
		ResultSet rs = null;
		Usuario usuario = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, nome);
			rs = stm.executeQuery();
			while(rs.next()){
				int idUsuario = rs.getInt("id_usuario");
				String nome2 = rs.getString("nome");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				String email = rs.getString("email");
				String sexo = rs.getString("sexo");
				Date nascimento = rs.getDate("nascimento");
				String cidade= rs.getString("cidade");
				String estado = rs.getString("estado");
				String profissao = rs.getString("profissao");
				String estadoCivil = rs.getString("estadoCivil");
				String escolaridade = rs.getString("escolaridade");
				int administrador = rs.getInt("administrador");
				usuario = new Usuario(idUsuario, nome2, login, senha, email, sexo, nascimento, cidade, estado, profissao, estadoCivil, escolaridade, administrador);
				listaUsuario.add(usuario);
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
			try{
				if(conexao!=null){
					conexao.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return listaUsuario;
	}
	
	public List<Usuario> buscarUsuarioPorParteDoNome(String nome){
		Connection conexao = null;
		List<Usuario> listaUsuario =  new ArrayList<Usuario>();
		PreparedStatement stm = null;
		String sql = "select * from tb_usuario where nome like ?"; //como pegar aqui o nascimento?
		ResultSet rs = null;
		Usuario usuario = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, nome+"%");
			rs = stm.executeQuery();
			while(rs.next()){
				int idUsuario = rs.getInt("id_usuario");
				String nome2 = rs.getString("nome");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				String email = rs.getString("email");
				String sexo = rs.getString("sexo");
				Date nascimento = rs.getDate("nascimento");
				String cidade= rs.getString("cidade");
				String estado = rs.getString("estado");
				String profissao = rs.getString("profissao");
				String estadoCivil = rs.getString("estadoCivil");
				String escolaridade = rs.getString("escolaridade");
				int administrador = rs.getInt("administrador");
				usuario = new Usuario(idUsuario, nome2, login, senha, email, sexo, nascimento, cidade, estado, profissao, estadoCivil, escolaridade, administrador);
				listaUsuario.add(usuario);
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
			try{
				if(conexao!=null){
					conexao.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return listaUsuario;
	}
	public void alterarDadosUsuario(Usuario usuario){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "update tb_usuario set nome = ?, login = ?, senha = ?, email = ?, sexo = ?, nascimento = ?, cidade = ?, estado = ?, profissao = ?, estadoCivil = ?, escolaridade = ?, administrador = ? where id_usuario = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getLogin());
			stm.setString(3, usuario.getSenha());
			stm.setString(4, usuario.getEmail());
			stm.setString(5, usuario.getSexo());
			stm.setDate(6, usuario.getNascimento());
			stm.setString(7, usuario.getCidade());
			stm.setString(8, usuario.getEstado());
			stm.setString(9, usuario.getProfissao());
			stm.setString(10, usuario.getEstadoCivil());
			stm.setString(11, usuario.getEscolaridade());
			stm.setInt(12, usuario.getAdministrador());
			stm.setInt(13, usuario.getIdUsuario());
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
