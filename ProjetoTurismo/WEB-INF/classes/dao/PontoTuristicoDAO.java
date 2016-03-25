package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.PontoTuristico;

public class PontoTuristicoDAO {
	public void cadastrarPontoTuristico(PontoTuristico pontoTuristico){
		Connection conexao = null;
		String sql = "insert into tb_ponto_turistico (nome, categoria, descricao, estado, cidade, distrito, endereco, cep, horarioInicio, horarioFim, diaInicio, diaFim, pontuacao, taxaCobrada) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stm = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, pontoTuristico.getNome());
			stm.setString(2, pontoTuristico.getCategoria());
			stm.setString(3, pontoTuristico.getDescricao());
			stm.setString(4, pontoTuristico.getEstado());
			stm.setString(5, pontoTuristico.getCidade());
			stm.setString(6, pontoTuristico.getDistrito());
			stm.setString(7, pontoTuristico.getEndereco());
			stm.setString(8, pontoTuristico.getCep());
			stm.setString(9, pontoTuristico.getHorarioInicio());
			stm.setString(10, pontoTuristico.getHorarioFim());
			stm.setString(11, pontoTuristico.getDiaInicio());
			stm.setString(12, pontoTuristico.getDiaFim());
			stm.setInt(13, pontoTuristico.getPontuacao());
			stm.setString(14, pontoTuristico.getTaxaCobrada());
			
			
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
	public PontoTuristico buscarUltimoPontoTuristico(){
		String sql = "select * from tb_ponto_turistico order by id_ponto_turistico DESC  ";
		Connection conexao = null;
		PontoTuristico pontoTuristico = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			 rs =  stm.executeQuery();
			while(rs.next()){
				int idPontoTuristico = rs.getInt("id_ponto_turistico");
				String nome = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String distrito = rs.getString("distrito");
				String endereco = rs.getString("endereco");
				String cep = rs.getString("cep");
				String horarioInicio = rs.getString("horarioInicio");
				String horarioFim = rs.getString("horarioFim");
				String diaInicio = rs.getString("diaInicio");
				String diaFim = rs.getString("diaFim");
				int pontuacao = rs.getInt("pontuacao");
				String taxaCobrada = rs.getString("taxaCobrada");
				pontoTuristico = new PontoTuristico(idPontoTuristico, nome, categoria, descricao, estado, cidade, distrito, endereco, cep, horarioInicio, horarioFim, diaInicio, diaFim, pontuacao, taxaCobrada);
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
		return pontoTuristico;
		
	}
	
	public List<PontoTuristico> buscarCincoUltimosPontoTuristicos(){
		List<PontoTuristico> listaPontosTuristicos = new ArrayList<PontoTuristico>();
		String sql = "select * from tb_ponto_turistico order by id_ponto_turistico DESC  ";
		Connection conexao = null;
		PontoTuristico pontoTuristico = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		int contador = 0;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			 rs =  stm.executeQuery();
			while(rs.next() && contador<5){
				int idPontoTuristico = rs.getInt("id_ponto_turistico");
				String nome = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String distrito = rs.getString("distrito");
				String endereco = rs.getString("endereco");
				String cep = rs.getString("cep");
				String horarioInicio = rs.getString("horarioInicio");
				String horarioFim = rs.getString("horarioFim");
				String diaInicio = rs.getString("diaInicio");
				String diaFim = rs.getString("diaFim");
				int pontuacao = rs.getInt("pontuacao");
				String taxaCobrada = rs.getString("taxaCobrada");
				pontoTuristico = new PontoTuristico(idPontoTuristico, nome, categoria, descricao, estado, cidade, distrito, endereco, cep, horarioInicio, horarioFim, diaInicio, diaFim, pontuacao, taxaCobrada);
				listaPontosTuristicos.add(pontoTuristico);
				contador = contador +1;
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
		return listaPontosTuristicos;
		
	}
	
	public List<PontoTuristico> buscarDoisUltimosPontoTuristicos(){
		List<PontoTuristico> listaPontosTuristicos = new ArrayList<PontoTuristico>();
		String sql = "select * from tb_ponto_turistico order by id_ponto_turistico DESC  ";
		Connection conexao = null;
		PontoTuristico pontoTuristico = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		int contador = 0;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			 rs =  stm.executeQuery();
			while(rs.next() && contador<2){
				int idPontoTuristico = rs.getInt("id_ponto_turistico");
				String nome = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String distrito = rs.getString("distrito");
				String endereco = rs.getString("endereco");
				String cep = rs.getString("cep");
				String horarioInicio = rs.getString("horarioInicio");
				String horarioFim = rs.getString("horarioFim");
				String diaInicio = rs.getString("diaInicio");
				String diaFim = rs.getString("diaFim");
				int pontuacao = rs.getInt("pontuacao");
				String taxaCobrada = rs.getString("taxaCobrada");
				pontoTuristico = new PontoTuristico(idPontoTuristico, nome, categoria, descricao, estado, cidade, distrito, endereco, cep, horarioInicio, horarioFim, diaInicio, diaFim, pontuacao, taxaCobrada);
				listaPontosTuristicos.add(pontoTuristico);
				contador = contador +1;
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
		return listaPontosTuristicos;
		
	}
	
	public List<PontoTuristico> buscarPontoTuristicoPeloNome(String nome){
		Connection conexao = null;
		List<PontoTuristico> listaPontosTuristicos =  new ArrayList<PontoTuristico>();
		PreparedStatement stm = null;
		String sql = "select * from tb_ponto_turistico where nome = ?";
		ResultSet rs = null;
		PontoTuristico pontoTuristico = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, nome);
			rs = stm.executeQuery();
			while(rs.next()){
				int idPontoTuristico = rs.getInt("id_ponto_turistico");
				String nome2 = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String distrito = rs.getString("distrito");
				String endereco = rs.getString("endereco");
				String cep = rs.getString("cep");
				String horarioInicio = rs.getString("horarioInicio");
				String horarioFim = rs.getString("horarioFim");
				String diaInicio = rs.getString("diaInicio");
				String diaFim = rs.getString("diaFim");
				int pontuacao = rs.getInt("pontuacao");
				String taxaCobrada = rs.getString("taxaCobrada");
				pontoTuristico = new PontoTuristico(idPontoTuristico, nome2, categoria, descricao, estado, cidade, distrito, endereco, cep, horarioInicio, horarioFim, diaInicio, diaFim, pontuacao, taxaCobrada);
				listaPontosTuristicos.add(pontoTuristico);
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
		return listaPontosTuristicos;
	}
	public PontoTuristico buscarPontoTuristicoPeloId(int idPontoTuristico){
		String sql = "select * from tb_ponto_turistico where id_ponto_turistico = ?";
		Connection conexao = null;
		PontoTuristico pontoTuristico = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idPontoTuristico);
			 rs =  stm.executeQuery();
			while(rs.next()){
				int idPontoTuristico2 = rs.getInt("id_ponto_turistico");
				String nome2 = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String distrito = rs.getString("distrito");
				String endereco = rs.getString("endereco");
				String cep = rs.getString("cep");
				String horarioInicio = rs.getString("horarioInicio");
				String horarioFim = rs.getString("horarioFim");
				String diaInicio = rs.getString("diaInicio");
				String diaFim = rs.getString("diaFim");
				int pontuacao = rs.getInt("pontuacao");
				String taxaCobrada = rs.getString("taxaCobrada");
				pontoTuristico = new PontoTuristico(idPontoTuristico2, nome2, categoria, descricao, estado, cidade, distrito, endereco, cep, horarioInicio, horarioFim, diaInicio, diaFim, pontuacao, taxaCobrada);
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
		return pontoTuristico;
	}
	public List<PontoTuristico> buscarTodosPontosTuristicos(){
		List<PontoTuristico> listaPontosTuristicos = new ArrayList<PontoTuristico>();
		String sql = "select * from tb_ponto_turistico";
		Connection conexao = null;
		PontoTuristico pontoTuristico = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			 rs =  stm.executeQuery();
			while(rs.next()){
				int idPontoTuristico = rs.getInt("id_ponto_turistico");
				String nome2 = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String distrito = rs.getString("distrito");
				String endereco = rs.getString("endereco");
				String cep = rs.getString("cep");
				String horarioInicio = rs.getString("horarioInicio");
				String horarioFim = rs.getString("horarioFim");
				String diaInicio = rs.getString("diaInicio");
				String diaFim = rs.getString("diaFim");
				int pontuacao = rs.getInt("pontuacao");
				String taxaCobrada = rs.getString("taxaCobrada");
				pontoTuristico = new PontoTuristico(idPontoTuristico, nome2, categoria, descricao, estado, cidade, distrito, endereco, cep, horarioInicio, horarioFim, diaInicio, diaFim, pontuacao, taxaCobrada);
				listaPontosTuristicos.add(pontoTuristico);
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
		return listaPontosTuristicos;
	}
	
	public void deletarPontoTuristicoPeloId(int idPontoTuristico){
		Connection conexao =  null;
		PreparedStatement stm = null;
		String sql = "delete from tb_ponto_turistico where id_ponto_turistico = ?";
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
	
	public void alterarDadosPontoTuristico(PontoTuristico pontoTuristico){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "update tb_ponto_turistico set nome = ?, categoria = ?, descricao = ?, estado = ?, cidade = ?, distrito = ?, endereco = ?, cep = ?, horarioInicio = ?, horarioFim = ?, diaInicio = ?, diaFim = ?, pontuacao = ?, taxaCobrada = ?  where id_ponto_turistico = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, pontoTuristico.getNome());
			stm.setString(2, pontoTuristico.getCategoria());
			stm.setString(3, pontoTuristico.getDescricao());
			stm.setString(4, pontoTuristico.getEstado());
			stm.setString(5, pontoTuristico.getCidade());
			stm.setString(6, pontoTuristico.getDistrito());
			stm.setString(7, pontoTuristico.getEndereco());
			stm.setString(8, pontoTuristico.getCep());
			stm.setString(9, pontoTuristico.getHorarioInicio());
			stm.setString(10, pontoTuristico.getHorarioFim());
			stm.setString(11, pontoTuristico.getDiaInicio());
			stm.setString(12, pontoTuristico.getDiaFim());
			stm.setInt(13, pontoTuristico.getPontuacao());
			stm.setString(14, pontoTuristico.getTaxaCobrada());
			stm.setInt(15, pontoTuristico.getIdPontoTuristico());
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
	public void alterarPontuacaoEmpresa(int idPontoTuristico, int pontuacao){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "update tb_ponto_turistico set pontuacao = ? where id_ponto_turistico = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, pontuacao);
			stm.setInt(2,idPontoTuristico);
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
	public List<PontoTuristico> buscarPontoTuristicoPorParteDoNome(String nome){
		Connection conexao = null;
		List<PontoTuristico> listaPontoTuristico =  new ArrayList<PontoTuristico>();
		PreparedStatement stm = null;
		String sql = "select * from tb_ponto_turistico where nome like ?";
		ResultSet rs = null;
		PontoTuristico pontoTuristico = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, nome+"%");
			rs = stm.executeQuery();
			while(rs.next()){
				int idPontoTuristico = rs.getInt("id_ponto_turistico");
				String nome2 = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String distrito = rs.getString("distrito");
				String endereco = rs.getString("endereco");
				String cep = rs.getString("cep");
				String horarioInicio = rs.getString("horarioInicio");
				String horarioFim = rs.getString("horarioFim");
				String diaInicio = rs.getString("diaInicio");
				String diaFim = rs.getString("diaFim");
				int pontuacao = rs.getInt("pontuacao");
				String taxaCobrada = rs.getString("taxaCobrada");
				pontoTuristico = new PontoTuristico(idPontoTuristico, nome2, categoria, descricao, estado, cidade, distrito, endereco, cep, horarioInicio, horarioFim, diaInicio, diaFim, pontuacao, taxaCobrada);
				
				listaPontoTuristico.add(pontoTuristico);
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
		return listaPontoTuristico;
	}
	public List<PontoTuristico> buscarPontoTuristicoPeloDistrito(String distrito){
		Connection conexao = null;
		List<PontoTuristico> listaPontosTuristicos =  new ArrayList<PontoTuristico>();
		PreparedStatement stm = null;
		String sql = "select * from tb_ponto_turistico where distrito = ?";
		ResultSet rs = null;
		PontoTuristico pontoTuristico = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, distrito);
			rs = stm.executeQuery();
			while(rs.next()){
				int idPontoTuristico = rs.getInt("id_ponto_turistico");
				String nome = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String distrito2 = rs.getString("distrito");
				String endereco = rs.getString("endereco");
				String cep = rs.getString("cep");
				String horarioInicio = rs.getString("horarioInicio");
				String horarioFim = rs.getString("horarioFim");
				String diaInicio = rs.getString("diaInicio");
				String diaFim = rs.getString("diaFim");
				int pontuacao = rs.getInt("pontuacao");
				String taxaCobrada = rs.getString("taxaCobrada");
				pontoTuristico = new PontoTuristico(idPontoTuristico, nome, categoria, descricao, estado, cidade, distrito2, endereco, cep, horarioInicio, horarioFim, diaInicio, diaFim, pontuacao, taxaCobrada);
				listaPontosTuristicos.add(pontoTuristico);
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
		return listaPontosTuristicos;
	}
}
