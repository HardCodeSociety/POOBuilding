//package aplicacion;
import java.util.*;
/**
*Clase Ventana 
*@autor Andres Felipe Pardo Mesa
*@autor David Felipe Vaca Santa 
**/
public class Ventana {
	private boolean reparada;
	private int numVidrios;
	private int vidriosRepar;
	private boolean tieneVecino;
	private boolean tieneSorpresa;
	//private Arraylist<Pared> paredes;
	/**
	 * Creador de la clase Ventana
	 */
	public void ventana(){
		reparada=false;
		numVidrios= 3;
		vidriosRepar=1;
		Random rand = new Random();
		tieneVecino= rand.nextBoolean();	
	}
	/**
	 * Nos permite saber la cantidad de vidrios por reparar.
	 * @return int vidriosRepar 
	 */
	public int vidriosReparar(){
		return vidriosRepar;
	}
	/**
	 *Este metodo nos permite cambiar el estado de una ventana a reparada 
	 */
	public void reparar(){
		vidriosRepar-=1;
		if (vidriosRepar==0)
			reparada=true;
	}
	/**
	 * Este metodo nos permite saber si la ventana de algun piso tiene un vecino
	 * @return boolean tieneVecino
	 */
	public boolean tieneVecino(){
		return tieneVecino;
	}
	//public Pared getParedes(){
		//return paredes;
	//}
}
