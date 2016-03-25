package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dao.UsuarioDAO;
import entities.Usuario;

public class UsuarioService {
	UsuarioDAO udao = new UsuarioDAO();
	public void cadastrarUsuario(Usuario usuario){
		udao.cadastrarUsuario(usuario);
	}
	public Usuario buscarUsuarioPorLogin(String login){
		return udao.buscarUsuarioPorLogin(login);
	}
	public Usuario buscarUsuarioPeloId(int id){
		return udao.buscarUsuarioPeloId(id);
	}
	public List<Usuario> buscarTodosUsuarios(){
		return udao.buscarTodosUsuarios();
	}
	public void deletarUsuarioPeloId(int idUsuario){
		udao.deletarUsuarioPeloId(idUsuario);
	}
	public List<Usuario> buscarUsuarioPeloNome(String nome){
		return udao.buscarUsuarioPeloNome(nome);
	}
	public List<Usuario> buscarUsuarioPorParteDoNome(String nome){
		return udao.buscarUsuarioPorParteDoNome(nome);
	}
	public void alterarDadosUsuario(Usuario usuario){
		udao.alterarDadosUsuario(usuario);
	}
	public List<Usuario> getIdade(List<Usuario> listaUsuarios, int idade){
		boolean resultado = false;
		List<Usuario> listaUsuariosIdade = new ArrayList<Usuario>();
		Iterator<Usuario> elementos = listaUsuarios.iterator();
		while(elementos.hasNext()){
			resultado = false;
			Usuario usuario = elementos.next();
			String data = usuario.getNascimento()+"";
			String strDia = "";
			String strMes = "";
			String strAno = "";
			for(int i = 0; i<10 ; i++){
				if(i<=3){
					strAno = strAno+data.charAt(i);
				}
				else if(i>=5 && i<=6){
					strMes = strMes+data.charAt(i);
				}
				else if(i>=8){
					strDia = strDia+data.charAt(i);
				}
			}
			int uAno = Integer.parseInt(strAno);
			int uMes = Integer.parseInt(strMes);
			int uDia = Integer.parseInt(strDia);
			Calendar cal = Calendar.getInstance();
			int ano = cal.get(Calendar.YEAR);
			int mes = cal.get(Calendar.MONTH)+1;
			int dia = cal.get(Calendar.DATE);
			if(ano-uAno>idade){
				resultado = true;
			}
			else{
				if(ano-uAno==idade){
					if(uMes==mes){
						if(uDia<=dia){
							resultado = true;
						}
					}
					else if(uMes<mes){
						resultado = true;
					}
				}
			}
			if(resultado==true){
				listaUsuariosIdade.add(usuario);
			}

		}
				
		return listaUsuariosIdade;
		
	}
	
	public boolean validarSeEhNumerosData(String data){
		boolean ehNumero=true;
		String strDia = "";
		String strMes = "";
		String strAno = "";
		if(data.length()>0){
			for(int i = 0; i<10 ; i++){
				if(data.charAt(i)=='1'||data.charAt(i)=='2'||data.charAt(i)=='3'||data.charAt(i)=='4'||data.charAt(i)=='5'||
						data.charAt(i)=='6'||data.charAt(i)=='7'||data.charAt(i)=='8'|| data.charAt(i)=='9'||data.charAt(i)=='0' || data.charAt(i) == '/'){
					if(i<2){
						strDia = strDia+data.charAt(i);
					}
					else if(i>2 && i<=4){
						strMes = strMes+data.charAt(i);
					}
					else if(i>5){
						strAno = strAno+data.charAt(i);
					}
				}
				else{
					ehNumero=false;
					break;
				}
			}
			data = strDia+strMes+strAno;
			Calendar cal = Calendar.getInstance();  
		    int anoAtual = cal.get(Calendar.YEAR);  
			if(anoAtual - Integer.parseInt(strAno)<0 || anoAtual - Integer.parseInt(strAno)>120 ){
				ehNumero=false;
			}

		}
		return ehNumero;
	}
	public boolean validarDataNascimento(String data){
		boolean numeroValido = true;
		boolean ehNumero=true;
		String strDia = "";
		String strMes = "";
		String strAno = "";
		if(data.length()>0){
			for(int i = 0; i<10 ; i++){
				if(data.charAt(i)=='1'||data.charAt(i)=='2'||data.charAt(i)=='3'||data.charAt(i)=='4'||data.charAt(i)=='5'||
						data.charAt(i)=='6'||data.charAt(i)=='7'||data.charAt(i)=='8'|| data.charAt(i)=='9'||data.charAt(i)=='0' || data.charAt(i) == '/'){
					if(i<2){
						strDia = strDia+data.charAt(i);
					}
					else if(i>2 && i<=4){
						strMes = strMes+data.charAt(i);
					}
					else if(i>5){
						strAno = strAno+data.charAt(i);
					}
				}
				else{
					ehNumero=false;
					break;
				}
			}
			
			if(ehNumero==true){
				int dia = Integer.parseInt(strDia);
				int mes = Integer.parseInt(strMes);
				if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
					if(dia<=0 || dia>31){
						numeroValido=false;
					}
				}
				else if(mes == 4 || mes == 6|| mes == 9 || mes == 11){
					if(dia<=0 || dia>30){
						numeroValido=false;
					}
				}
				else if(mes == 2){
					if(dia<=0 || dia>29){
						numeroValido=false;
					}
				}
				
				Calendar cal = Calendar.getInstance();  
			    int anoAtual = cal.get(Calendar.YEAR);  
				if(anoAtual - Integer.parseInt(strAno)<0 || anoAtual - Integer.parseInt(strAno)>120 ){
					numeroValido=false;
				}
			}
		}
		return numeroValido;
	}
	public String retornaNumerosData(String data){
		String strDia = "";
		String strMes = "";
		String strAno = "";
		if(data.length()>0){
			for(int i = 0; i<10 ; i++){
				if(data.charAt(i)=='1'||data.charAt(i)=='2'||data.charAt(i)=='3'||data.charAt(i)=='4'||data.charAt(i)=='5'||
						data.charAt(i)=='6'||data.charAt(i)=='7'||data.charAt(i)=='8'|| data.charAt(i)=='9'||data.charAt(i)=='0' || data.charAt(i) == '/'){
					if(i<2){
						strDia = strDia+data.charAt(i);
					}
					else if(i>2 && i<=4){
						strMes = strMes+data.charAt(i);
					}
					else if(i>5){
						strAno = strAno+data.charAt(i);
					}
				}
			}
		
		}	
		return strDia+strMes+strAno;
	}
}
