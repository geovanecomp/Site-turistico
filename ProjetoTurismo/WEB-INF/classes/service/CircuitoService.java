package service;

import java.util.Calendar;
import java.util.List;

import dao.CircuitoDAO;
import entities.Circuito;

public class CircuitoService {
	CircuitoDAO cdao = new CircuitoDAO();
	public void cadastrarCircuito(Circuito circuito){
		cdao.cadastrarCircuito(circuito);
	}
	public List<Circuito> buscarTodosCircuitos(){
		return cdao.buscarTodosCircuitos();
	}
	public Circuito buscarCircuitoPeloId(int idCircuito){
		return cdao.buscarCircuitoPeloId(idCircuito);
	}
	public void deletarCircuitoPeloId(int idCircuito){
		cdao.deletarCircuitoPeloId(idCircuito);
	}
	public void alterarDadosCircuito(Circuito circuito){
		cdao.alterarDadosCircuito(circuito);
	}
	
	public List<Circuito> buscarCircuitosPeloIdUsuario(int idUsuario){
		return cdao.buscarCircuitosPeloIdUsuario(idUsuario);
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
	
	public boolean validarData(String data){//valida se a data do circuito é valida e posterior a data atual
		boolean numeroValido = true;
		boolean ehNumero=true;
		String strDia = "";
		String strMes = "";
		String strAno = "";
		Calendar cal = Calendar.getInstance();  
	    int anoAtual = cal.get(Calendar.YEAR);  
	    int mesAtual = cal.get(Calendar.MONTH)+1;
	    int diaAtual = cal.get(Calendar.DATE);
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
				int ano = Integer.parseInt(strAno);
				if(ano - anoAtual <0){
					numeroValido=false;
				}
				else if(ano-anoAtual==0){
					if(mes - mesAtual < 0){
						numeroValido = false;
					}
					else if(mes - mesAtual==0){
						if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
							if((dia<=0 || dia>31) || (dia - diaAtual <0)){
								numeroValido=false;
							}
						}
						else if(mes == 4 || mes == 6|| mes == 9 || mes == 11){
							if((dia<=0 || dia>30) || (dia - diaAtual <0)){
								numeroValido=false;
							}
						}
						else if(mes == 2){
							if((dia<=0 || dia>29) || (dia - diaAtual <0)){
								numeroValido=false;
							}
						}
					}
				}
			}
		}
		return numeroValido;
	}
}
