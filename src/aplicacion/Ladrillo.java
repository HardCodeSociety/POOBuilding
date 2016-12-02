package aplicacion;
import java.util.*;
import java.lang.*;


public class Ladrillo extends Obstaculo {
	public Ladrillo(int posX, int posY){
		super(posX,posY);
	}
	public void muevase(){
		posY-=1;
		heroes= new Arraylist<>();
		heroes= super.getHeroes();
		for(Heroe h: heroes){
			if (h.getPosicion().equals(this.coordenadas())){
					this.reaccion(h);
			}
		}
	}
	public void reaccion(Heroe h){
			h.agredir();
	}
}
