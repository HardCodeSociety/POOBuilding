package aplicacion;

public class Bebida extends Sorpresa{
	public Bebida(Edificio edificio){
    super(edificio);
    nombre="Bebida";
  }
  public void realizaEfecto(Heroe jugador)throws PartidaException{
	  jugador.ganaEnergia(nombre);
  }
}