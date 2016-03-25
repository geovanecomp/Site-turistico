package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import entities.TelefoneEmpresa;

public class TelefoneEmpresaDAO {
	public void cadastrarTelefoneEmpresa(List<String> listaTelefones, int idEmpresa){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "insert into tb_telefone_empresa (id_empresa, telefone) values (?, ?)";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			Iterator<String> elementos = listaTelefones.iterator();
			while(elementos.hasNext()){
				stm.setInt(1, idEmpresa);
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
	public List<TelefoneEmpresa> buscarTelefonesPeloIdEmpresa (int idEmpresa){
		List<TelefoneEmpresa> listaTelefonesEmpresa = new ArrayList<TelefoneEmpresa>();
		String sql = "select * from tb_telefone_empresa where id_Empresa = ?";
		Connection conexao = null;
		TelefoneEmpresa telefoneEmpresa = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idEmpresa);
			 rs =  stm.executeQuery();
			while(rs.next()){
				int idTelefoneEmpresa = rs.getInt("id_telefone_empresa");
				int idEmpresa2 = rs.getInt("id_empresa");
				String telefone = rs.getString("telefone");
				telefoneEmpresa = new TelefoneEmpresa(idTelefoneEmpresa, idEmpresa2, telefone);
				listaTelefonesEmpresa.add(telefoneEmpresa);
				
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
		return listaTelefonesEmpresa; 
	}
	
	public void deletarTelefoneEmpresa(int idEmpresa){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "delete from tb_telefone_empresa where id_empresa = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idEmpresa);
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
	
	public void alterarTelefoneEmpresa(List<String> listaTelefones, int idEmpresa){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "update tb_telefone_empresa set telefone = ? where id_empresa = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			Iterator<String> elementos = listaTelefones.iterator();
			while(elementos.hasNext()){
				stm.setString(1, elementos.next());
				stm.setInt(2, idEmpresa);
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
}
