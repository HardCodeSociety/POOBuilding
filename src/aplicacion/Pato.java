package aplicacion;
import java.util.*;

public class Pato extends Obstaculo{
	private boolean esteOeste;
	private boolean contacto;
	public Pato(Edificio edificio){
	super(edificio);
	esteOeste=false;
	contacto=false;
	}
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
