package aplicacion;
/**
 * Clase Candy
 */
public class Candy extends Maquina{
  /**
   * Constructor de la clase Candy
   * @param edificio edificio
   * @param jugador1 Usuario
   */
  public Candy (Edificio edificio,Usuario jugador1){
	  super(edificio,jugador1);
  }
  /**
   * Metodo analisis
   */
  public void analisis() throws PartidaException{
	  int[] posicionAseguir=jugador1.getPosicion();
	  if(posicionAseguir[0]>posI)mover('U');
	  else if(posicionAseguir[0]<posI)mover('D');
	  else if(posicionAseguir[1]>posJ)mover('R');
	  else mover('L');
  }
}
