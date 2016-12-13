package aplicacion;
import java.util.*;
import java.lang.*;

public class Candy extends Maquina{
  public Candy (Edificio edificio,Usuario jugador1){
	  super(edificio,jugador1);
  }
  public void analisis() throws PartidaException{
	  int[] posicionAseguir=jugador1.getPosicion();
	  if(posicionAseguir[0]>posI)mover('U');
	  else if(posicionAseguir[0]<posI)mover('D');
	  else if(posicionAseguir[1]>posJ)mover('R');
	  else mover('L');
  }
}
