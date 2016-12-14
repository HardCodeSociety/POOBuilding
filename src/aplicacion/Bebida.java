package aplicacion;
/**
 * Clase Bebida
 */
public class Bebida extends Sorpresa{
	/**
	 * Constructor de la clase Bebida
	 * @param edificio edificio
	 */
	public Bebida(Edificio edificio){
    super(edificio);
    nombre="Bebida";
  }
	/**
	 *Metodo realizaEfecto, es el metodo el cual hace que la bebida se use en la mejor manera al tomarla
	 *@param jugador Heroe
	 */
  public void realizaEfecto(Heroe jugador)throws PartidaException{
	  jugador.ganaEnergia(nombre);
  }
}
