package aplicacion;
import java.util.*;
import java.lang.*;


public abstract class Obstaculo {
	protected int posX;
	protected int posY;
	protected boolean contacto;
	protected Edificio edificio;
	protected ArrayList<Heroe> heroes;
	/**
	*Creador de la clase Obstaculo
	**/
	public Obstaculo(){
		posX=0;
		posY=0;
	}
	public Obstaculo(int posX, int posY){
		this.posX=posX;
		this.posY=posY;
	}
	public int getCantVentanas(){
		return 15;
	}
	public int getCantPisos(){
		return 5;
	}
  abstract public void muevase();
	abstract public void reaccion(Heroe h);
	public int[] coordenadas(){
		int [] coordenadas = new int[2];
		coordenadas[0]=posX;
		coordenadas[1]=posY;
		return coordenadas;
	}
}
