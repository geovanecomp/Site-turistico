package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import entities.ImagemEmpresa;

public class ImagemEmpresaDAO {
	public void cadastarImagemEmpresa(List<String> listaImagens, int idEmpresa){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "insert into tb_imagem_empresa (id_empresa, imagem) values (?, ?)";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			Iterator<String> elementos = listaImagens.iterator();
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
	public List<ImagemEmpresa> buscarImagensPeloIdEmpresa (int idEmpresa){
		List<ImagemEmpresa> listaImagensEmpresa = new ArrayList<ImagemEmpresa>();
		String sql = "select * from tb_imagem_empresa where id_Empresa = ?";
		Connection conexao = null;
		ImagemEmpresa imagemEmpresa = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, idEmpresa);
			 rs =  stm.executeQuery();
			while(rs.next()){
				int idImagemEmpresa = rs.getInt("id_imagem_empresa");
				int idEmpresa2 = rs.getInt("id_empresa");
				String imagem = rs.getString("imagem");
				imagemEmpresa = new ImagemEmpresa(idImagemEmpresa, idEmpresa2, imagem);
				listaImagensEmpresa.add(imagemEmpresa);
				
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
		return listaImagensEmpresa; 
	}
	public void alterarImagemEmpresa(List<String> listaImagens, int idEmpresa){
		Connection conexao = null;
		PreparedStatement stm = null;
		String sql = "update tb_imagem_empresa set imagem = ? where id_empresa = ?";
		try{
			conexao = new ConnectionFactory().getConnection();
			stm = conexao.prepareStatement(sql);
			Iterator<String> elementos = listaImagens.iterator();
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
