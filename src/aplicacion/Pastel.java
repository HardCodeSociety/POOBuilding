package aplicacion;


public class Pastel extends Sorpresa{
	public Pastel(Edificio edificio){
    super(edificio);
    nombre="Pastel";
  }
  public void realizaEfecto(Heroe jugador)throws PartidaException{
	  jugador.hacerRapido(nombre);
  }

}