package aplicacion;

public class Kriptonita extends Sorpresa{
	public Kriptonita(Edificio edificio){
    super(edificio);
    nombre="Kriptonita";
  }
  public void realizaEfecto(Heroe jugador)throws PartidaException{
	  jugador.hacerInmune(nombre);
  }
}