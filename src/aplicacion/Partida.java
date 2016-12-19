package aplicacion;
import java.io.File;
import java.io.Serializable;
import java.util.*;


public class Partida implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Edificio edificio; 
	private static Partida partida;
	
	private Partida(int cantPisos, int cantVentanas,int[] tiposPartida){
		    edificio=Edificio.demeEdificio(cantPisos, cantVentanas, tiposPartida);
		  }
	public static Partida demePartida(int cantPisos, int cantVentanas,int[] tiposPartida){
		if (partida==null){
	        partida=new Partida(cantPisos,cantVentanas,tiposPartida);
	    }
		return partida;
	}
	public int[] estadoJugador(int jugador){
		int[] estado=new int[5];
		estado[0]=edificio.tomarHeroe(jugador).getEnergia();
		estado[1]=edificio.tomarHeroe(jugador).getPuntaje();
		estado[2]=edificio.tomarHeroe(jugador).getVidas();
		if(edificio.tomarHeroe(jugador).seMueveLento())estado[3]=1;
		else estado[3]=0;
		if(edificio.tomarHeroe(jugador).caer())estado[4]=1;
		else estado[4]=0;
		return estado;
	}
	public String estadoPoder(int jugador){
		String resp="";
		ArrayList<String> poder=edificio.tomarHeroe(jugador).getBonificaciones();
		if(poder.contains("Bebida"))resp=resp+"1.";
		else resp=resp+"0.";
		if(poder.contains("Pastel"))resp=resp+"1.";
		else resp=resp+"0.";
		if(poder.contains("Kriptonita"))resp=resp+"1.";
		else resp=resp+"0.";
		return resp;
		
	}
	public int[] posicionJugador(int jugador){
		return edificio.tomarHeroe(jugador).getPosicion();
	}
	public String estadoVentanas(int i,int j){
		boolean reparada=edificio.ventana(i,j).estaReparada();
		int cantReparar=edificio.ventana(i, j).vidriosReparar();
		boolean puerta=edificio.ventana(i, j).puerta();
		boolean centro=edificio.ventana(i,j).central();
		boolean barreraH=false;
		boolean barreraV=false;
		boolean tieneSorpresa=edificio.ventana(i, j).sorpresa();
		try{
			barreraH=edificio.ventana(i, j).barrera('H');
			barreraV=edificio.ventana(i, j).barrera('V');
		}catch(PartidaException e){}
		String estado="";
		if(reparada)estado=estado+"1.";
		else estado=estado+"0.";
		if(cantReparar==1)estado=estado+"1.";
		else estado=estado+"0.";
		if(puerta)estado=estado+"1.";
		else if (centro)estado=estado+"2.";
		else estado=estado+"0.";
		if(barreraH)estado=estado+"1.";
		else estado=estado+"0.";
		if(barreraV)estado=estado+"1.";
		else estado=estado+"0.";
		if(tieneSorpresa)estado=estado+"1.";
		else estado=estado+"0.";
	    return estado;
	}
	public int[] posicionObstaculo(int numObstaculo){
		int[] posicion=edificio.obstaculo(numObstaculo).getPosicion();
		return posicion;
	}
	public int[] posicionSorpresa(int numSorpresa){
		int[] posicion=edificio.sorpresa(numSorpresa).ventana.getPosicion();
		return posicion;
	} 
	public boolean estadoObstaculo(int obstaculo){
		edificio.cargarSorpresas();
		return edificio.obstaculo(obstaculo).visible();
	}
	public boolean estadoSorpresa(int sorpresa){
		edificio.cargarObstaculos();
		return edificio.sorpresa(sorpresa).visible();
	}
	public boolean finalizar(){
		edificio.aumentarNivel();
		edificio.cargargameOver();
		return edificio.gameOver();
	}
	public void moverHeroe(int numero,char direccion){
		edificio.moverHeroe(numero, direccion);
	}
    public void repara(int numero){
    	edificio.repara(numero);
    }
    public Edificio getEdificio(){
    	return edificio;
    }
    public int vidriosSinReparar(int i,int j){
        return edificio.vidriosSinReparar(i, j);
   }
    public void guarde(File f, Partida d) throws PartidaException {
  	  POOBArchivos.guarde(f, d);
    }
    public Partida abra(File f) throws PartidaException{
  	  return POOBArchivos.abra(f);
    }
    public static void cambiePartida(Partida npartida){
  	  partida=npartida;
    }
}
