package aplicacion;
import java.util.*;

public class Ladrillo extends Obstaculo{
	private boolean contacto;
	public Ladrillo(Edificio edificio){
	super(edificio);
	contacto=false;
	}
	public void makeVisible(){
		if(isVisible)mover();
		if(contacto){
			contacto=false;
			makeInvisible();
		}
		Random rand= new Random();
		int opcion=(int)(rand.nextInt()*4+1);
		if(opcion==4){
			if(!isVisible){	  
				  posJ=(int)(rand.nextInt()*(edificio.cantidades()[1]-1));
				  posI=(edificio.cantidades()[0]+1);
				  isVisible=true;
			  }		  
		  }
	}
	protected  void mover(){
		Random rand= new Random();
		posJ=(int)(rand.nextInt()*(edificio.cantidades()[1]-1));
	}
	public void tocandoHeroe(Heroe jugador)throws PartidaException{
		  if(isVisible){
			int[] posicion1 = jugador.getPosicion();
			if(posicion1[0]==posI && posicion1[1]==posJ){
				contacto=true;
				jugador.seGolpea(this);
			}
		  }
	}
}

