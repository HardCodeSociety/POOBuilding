package aplicacion;
import java.util.*;
/**
 * Clase Clahoun
 */
public class Calhoun extends Maquina{
	/**
	 * Constructor de clase calhoun
	 * @param edificio Edificio
	 * @param jugador1 USUARIO
	 */
	public Calhoun (Edificio edificio,Usuario jugador1){
		  super(edificio,jugador1);
	  }
		/**
		*Metodo analisis
		*/
	  public void analisis() throws PartidaException{
		  Random random=new Random();
		  int opcion=(int) (random.nextDouble() * 4 + 1);
		  if(opcion==1)mover('U');
		  else if(opcion==2)mover('D');
		  else if(opcion==3)mover('R');
		  else mover('L');
	  }
}
