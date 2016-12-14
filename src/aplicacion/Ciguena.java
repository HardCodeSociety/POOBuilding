package aplicacion;
import java.util.*;
/**
 *Clase Ciguena
 */
public class Ciguena extends Obstaculo{
	//Atributos
	private boolean esteOeste;
	private boolean contacto;
	/**
	 * Constructor de la clase Ciguena
	 * @param edificio Edificio
	 */
	public Ciguena(Edificio edificio){
	super(edificio);
	esteOeste=false;
	contacto=false;
	}
	/**
	 * makeVisible, Es un metodo que se encarga de hacer visibles a las cigueñas
	 */
	public void makeVisible(){
		if(isVisible)mover();
		if(contacto){
			contacto=false;
			makeInvisible();
		}
		Random rand= new Random();
		int opcion=(int)(rand.nextDouble()*4+1);
		if(opcion==4){
			if(!isVisible){
				  posI=(int)(rand.nextDouble()*(edificio.cantidades()[0]+1)+1);
				  opcion=(int)(rand.nextDouble()*2+1);
				  if(opcion==1){
					  posJ=(edificio.cantidades()[1])-1;
					  esteOeste=true;
				  }else{
					  posJ=0;
					  esteOeste=false;
				  }
				  isVisible=true;
			  }
		  }
	}
	/**
	 * mover, es un metodo encargado del movimiento especial que tienen los pajaro*
	 */
	public void mover(){
		  if(isVisible){
			  if (!(posJ-1<0)&&esteOeste)
				  posJ-=1;
			  else if(posJ+1>(edificio.cantidades()[1])-1&&!esteOeste)
				  posJ+=1;
			  else
				  makeInvisible();
		  }
	}
	/**
	 * sube, hace que la ciguena suba para llegar a la penuloma
	 *
	 */
	public void sube(){
		posI=edificio.cantidades()[0]+1;
	}
	/**
	 * tocandoHeroe, este metodo sirve para saber si hay algun tipo de col
	 *@param jugador, Heore
	 *
	 */
	public void tocandoHeroe(Heroe jugador)throws PartidaException{
		  if(isVisible){
			int[] posicion1 = jugador.getPosicion();
			if(posicion1[0]==posI && posicion1[1]==posJ){
				contacto=true;
				sube();
				jugador.seGolpea(this);
			}
		  }
	}
}
