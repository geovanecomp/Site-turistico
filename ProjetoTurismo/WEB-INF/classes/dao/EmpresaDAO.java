package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Empresa;

public class EmpresaDAO {
	public void cadastrarEmpresa(Empresa empresa){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "insert into tb_empresa (nome, categoria, descricao, email, estado, cidade, distrito, endereco, cep, horarioInicio, horarioFim, diaInicio, diaFim, pontuacao, gastoMedio, cnpj) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, empresa.getNome());
			stm.setString(2, empresa.getCategoria());
			stm.setString(3, empresa.getDescricao());
			stm.setString(4, empresa.getEmail());
			stm.setString(5, empresa.getEstado());
			stm.setString(6, empresa.getCidade());
			stm.setString(7, empresa.getDistrito());
			stm.setString(8, empresa.getEndereco());
			stm.setString(9, empresa.getCep());
			stm.setString(10, empresa.getHorarioInicio());
			stm.setString(11, empresa.getHorarioFim());
			stm.setString(12, empresa.getDiaInicio());
			stm.setString(13, empresa.getDiaFim());
			stm.setInt(14, empresa.getPontuacao());
			stm.setString(15, empresa.getGastoMedio());
			stm.setString(16, empresa.getCnpj());
			
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

	
	public Empresa buscarEmpresaPeloCnpj(String cnpj){
		String sql = "select * from tb_empresa where cnpj = ?";
		Connection conexao = null;
		Empresa empresa = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, cnpj);
			rs =  stm.executeQuery();
			while(rs.next()){
				int idEmpresa = rs.getInt("id_empresa");
				String nome = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String email = rs.getString("email");
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
				String gastoMedio = rs.getString("gastoMedio");
				String cnpj2 = rs.getString("cnpj");
				empresa = new  Empresa(idEmpresa, nome, categoria, descricao, email, estado, cidade, distrito, endereco, cep, horarioInicio,
						 horarioFim, diaInicio, diaFim, pontuacao, gastoMedio, cnpj2);
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
		return empresa;
		
	}
	public Empresa buscarUltimaEmpresa(){
		String sql = "select * from tb_empresa order by id_empresa DESC  ";
		Connection conexao = null;
		Empresa empresa = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			rs =  stm.executeQuery();
			while(rs.next()){
				int idEmpresa = rs.getInt("id_empresa");
				String nome = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String email = rs.getString("email");
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
				String gastoMedio = rs.getString("gastoMedio");
				String cnpj = rs.getString("cnpj");
				empresa = new  Empresa(idEmpresa, nome, categoria, descricao, email, estado, cidade, distrito, endereco, cep, horarioInicio,
						 horarioFim, diaInicio, diaFim, pontuacao, gastoMedio, cnpj);
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
		return empresa;
		
	}
	
	public List<Empresa> buscarCincoUltimasEmpresas(){
		List<Empresa> listaEmpresas = new ArrayList<Empresa>();
		String sql = "select * from tb_empresa order by id_empresa DESC  ";
		Connection conexao = null;
		Empresa empresa = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		int contador  = 0;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			rs =  stm.executeQuery();
			while(rs.next() && contador<5){
				int idEmpresa = rs.getInt("id_empresa");
				String nome = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String email = rs.getString("email");
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
				String gastoMedio = rs.getString("gastoMedio");
				String cnpj = rs.getString("cnpj");
				empresa = new  Empresa(idEmpresa, nome, categoria, descricao, email, estado, cidade, distrito, endereco, cep, horarioInicio,
						 horarioFim, diaInicio, diaFim, pontuacao, gastoMedio, cnpj);
				listaEmpresas.add(empresa);
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
		return listaEmpresas;
		
	}
	
	public List<Empresa> buscarDuasUltimasEmpresas(){
		List<Empresa> listaEmpresas = new ArrayList<Empresa>();
		String sql = "select * from tb_empresa order by id_empresa DESC  ";
		Connection conexao = null;
		Empresa empresa = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		int contador  = 0;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			rs =  stm.executeQuery();
			while(rs.next() && contador<2){
				int idEmpresa = rs.getInt("id_empresa");
				String nome = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String email = rs.getString("email");
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
				String gastoMedio = rs.getString("gastoMedio");
				String cnpj = rs.getString("cnpj");
				empresa = new  Empresa(idEmpresa, nome, categoria, descricao, email, estado, cidade, distrito, endereco, cep, horarioInicio,
						 horarioFim, diaInicio, diaFim, pontuacao, gastoMedio, cnpj);
				listaEmpresas.add(empresa);
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
		return listaEmpresas;
		
	}
	
	public List<Empresa> buscarTodasEmpresas(){
		List<Empresa> listaEmpresas = new ArrayList<Empresa>();
		String sql = "select * from tb_empresa";
		Connection conexao = null;
		Empresa empresa = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			rs =  stm.executeQuery();
			while(rs.next()){
				int idEmpresa = rs.getInt("id_empresa");
				String nome = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String email = rs.getString("email");
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
				String gastoMedio = rs.getString("gastoMedio");
				String cnpj = rs.getString("cnpj");
				empresa = new  Empresa(idEmpresa, nome, categoria, descricao, email, estado, cidade, distrito, endereco, cep, horarioInicio,
						 horarioFim, diaInicio, diaFim, pontuacao, gastoMedio, cnpj);
				listaEmpresas.add(empresa);
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
		return listaEmpresas;
	}
	public Empresa buscarEmpresaPeloId(int idEmpresa){
		String sql = "select * from tb_empresa where id_empresa = ?";
		Connection conexao = null;
		Empresa empresa = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idEmpresa);
			rs =  stm.executeQuery();
			while(rs.next()){
				int idEmpresa2 = rs.getInt("id_empresa");
				String nome = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String email = rs.getString("email");
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
				String gastoMedio = rs.getString("gastoMedio");
				String cnpj = rs.getString("cnpj");
				empresa = new  Empresa(idEmpresa2, nome, categoria, descricao, email, estado, cidade, distrito, endereco, cep, horarioInicio,
						 horarioFim, diaInicio, diaFim, pontuacao, gastoMedio, cnpj);
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
		return empresa;
	}
	public void deletarEmpresaPeloId(int idEmpresa){
		Connection conexao =  null;
		PreparedStatement stm = null;
		String sql = "delete from tb_empresa where id_empresa = ?";
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
	public void alterarDadosEmpresa(Empresa empresa){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "update tb_empresa set nome = ?, categoria = ?, descricao = ?, email = ?, estado = ?, cidade = ?, distrito = ?, endereco = ?, cep = ?, horarioInicio = ?, horarioFim = ?, diaInicio = ?, diaFim = ?, pontuacao = ?, gastoMedio = ?, cnpj = ?  where id_empresa = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, empresa.getNome());
			stm.setString(2, empresa.getCategoria());
			stm.setString(3, empresa.getDescricao());
			stm.setString(4, empresa.getEmail());
			stm.setString(5, empresa.getEstado());
			stm.setString(6, empresa.getCidade());
			stm.setString(7, empresa.getDistrito());
			stm.setString(8, empresa.getEndereco());
			stm.setString(9, empresa.getCep());
			stm.setString(10, empresa.getHorarioInicio());
			stm.setString(11, empresa.getHorarioFim());
			stm.setString(12, empresa.getDiaInicio());
			stm.setString(13, empresa.getDiaFim());
			stm.setInt(14, empresa.getPontuacao());
			stm.setString(15, empresa.getGastoMedio());
			stm.setString(16, empresa.getCnpj());
			stm.setInt(17, empresa.getidEmpresa());
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
	public void alterarPontuacaoEmpresa(int idEmpresa, int pontuacao){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "update tb_empresa set pontuacao = ? where id_empresa = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, pontuacao);
			stm.setInt(2,idEmpresa);
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
	public List<Empresa> buscarEmpresaPeloNome(String nome){
		Connection conexao = null;
		List<Empresa> listaEmpresa =  new ArrayList<Empresa>();
		PreparedStatement stm = null;
		String sql = "select * from tb_empresa where nome = ?";
		ResultSet rs = null;
		Empresa empresa = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, nome);
			rs = stm.executeQuery();
			while(rs.next()){
				int idEmpresa = rs.getInt("id_empresa");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String email = rs.getString("email");
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
				String gastoMedio = rs.getString("gastoMedio");
				String cnpj = rs.getString("cnpj");
				empresa = new  Empresa(idEmpresa, nome, categoria, descricao, email, estado, cidade, distrito, endereco, cep, horarioInicio,
						 horarioFim, diaInicio, diaFim, pontuacao, gastoMedio, cnpj);
				listaEmpresa.add(empresa);
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
		return listaEmpresa;
	}
	public List<Empresa> buscarEmpresaPorParteDoNome(String nome){
		Connection conexao = null;
		List<Empresa> listaEmpresa =  new ArrayList<Empresa>();
		PreparedStatement stm = null;
		String sql = "select * from tb_empresa where nome like ?";
		ResultSet rs = null;
		Empresa empresa = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, nome+"%");
			rs = stm.executeQuery();
			while(rs.next()){
				int idEmpresa = rs.getInt("id_empresa");
				String nome2 = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String email = rs.getString("email");
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
				String gastoMedio = rs.getString("gastoMedio");
				String cnpj = rs.getString("cnpj");
				empresa = new  Empresa(idEmpresa, nome2, categoria, descricao, email, estado, cidade, distrito, endereco, cep, horarioInicio,
						 horarioFim, diaInicio, diaFim, pontuacao, gastoMedio, cnpj);
				listaEmpresa.add(empresa);
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
		return listaEmpresa;
	}
	public List<Empresa> buscarEmpresaPeloDistrito(String distrito){
		Connection conexao = null;
		List<Empresa> listaEmpresa =  new ArrayList<Empresa>();
		PreparedStatement stm = null;
		String sql = "select * from tb_empresa where distrito = ?";
		ResultSet rs = null;
		Empresa empresa = null;
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setString(1, distrito);
			rs = stm.executeQuery();
			while(rs.next()){
				int idEmpresa = rs.getInt("id_empresa");
				String nome = rs.getString("nome");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				String email = rs.getString("email");
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
				String gastoMedio = rs.getString("gastoMedio");
				String cnpj = rs.getString("cnpj");
				empresa = new  Empresa(idEmpresa, nome, categoria, descricao, email, estado, cidade, distrito2, endereco, cep, horarioInicio,
						 horarioFim, diaInicio, diaFim, pontuacao, gastoMedio, cnpj);
				listaEmpresa.add(empresa);
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
		return listaEmpresa;
	}
}
