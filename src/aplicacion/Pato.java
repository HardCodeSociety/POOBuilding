package aplicacion;
import java.util.*;
import java.lang.*;

public class Pato extends Obstaculo{
  private boolean sentidoDer=true;
  private ArrayList<Heroe> heroes= new ArrayList<Heroe>();
  public Pato(int posX, int posY){
    super(posX,posY);
  }
  public void muevase(){
    int c = super.getCantVentanas();
  	heroes= super.getHeroes();
  	if(posX < c && sentidoDer==true){
      posX+=1;
      if(posX==c){
        sentidoDer=false;
      }
    }else if((posX==c) && sentidoDer==true){
      posX-=1;
      sentidoDer=false;
    } else if(posX < c && sentidoDer==false){
      posX-=1;
    }else if(posX==0 && sentidoDer==false){
      posX+=1;
      sentidoDer=true;
    }
  	for(Heroe h: heroes){
  		if (h.getPosicion().equals(this.coordenadas())){
  				this.reaccion(h);
  			}
  		}
  }
  public void reaccion(Heroe h){
  		h.setPosX(0);
  }
}
