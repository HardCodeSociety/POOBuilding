package aplicacion;
import java.util.*;
import java.lang.*;

public class Ciguena extends Obstaculo{
  private int cantVentanas;
  private int cantPisos;
  private int posX;
  private int posY;
  private boolean sentidoDer= true;
  private ArrayList <Heroe> heroes= new ArrayList<Heroe>();
  public Ciguena(int posX, int posY){
    super(posX,posY);

  }
  public void muevase(){
    cantVentanas=15;
    cantPisos=5;
  	heroes= super.getHeroes();
  	if((posX<cantVentanas) && sentidoDer==true){
      posX+=1;
      if(posX==cantVentanas){
        sentidoDer=false;
      }
    }else if(posX==cantVentanas && sentidoDer==true){
      posX-=1;
      sentidoDer=false;
    } else if(posX < cantVentanas && sentidoDer==false){
      posX-=1;
    }else if(posX==0 && sentidoDer==false){
      posX+=1;
      sentidoDer=true;
    }
  	for(Heroe her: heroes){
  		if ((her.getPosicion()).equals(this.coordenadas())){
  				this.reaccion(her);
  			}
  	}
  }
  public void setPosY(int newPosY){
    posY= newPosY;
  }

  public void ascender(int cantPisos){
    for (int i=posY; i<=cantPisos; i++){
      this.setPosY(i);
    }
  }
  public void reaccion(Heroe h){
    h.ascender(cantPisos);
    this.ascender(cantPisos);
  }
}
