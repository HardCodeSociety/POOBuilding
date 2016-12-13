	package aplicacion;
import java.util.*;
/**
*Clase Ventana
*@autor Andres Felipe Pardo Mesa
*@autor David Felipe Vaca Santa
**/
public class Ventana {
	private boolean reparada;
	private int numVidrios;
	private int vidriosReparados;
	private boolean tieneVecino;
	private boolean tieneSorpresa;
	private boolean esPuerta;
	private boolean conSorpresa;
	/**
	 * Creador de la clase Ventana
	 */
	public Ventana(){
		reparada=false;
		numVidrios= 2;
		vidriosReparados=0;
		esPuerta=false;
		}
	/**
	 * Nos permite saber la cantidad de vidrios por reparar.
	 * @return int vidriosRepar
	 */
	public int vidriosReparar(){
		return numVidrios-vidriosReparados;
	}
	/**
	 *Este metodo nos permite cambiar el estado de una ventana a reparada
	 */
	public void reparar(){
		vidriosReparados+=1;
		if (vidriosReparar()==0)
			reparada=true;
	}
	public void reparaRapido(){
		reparada=true;
	}
	public void esPuerta(boolean resp){
		esPuerta=resp;
	}
	public boolean estaReparada(){
		return reparada;
	}

}
