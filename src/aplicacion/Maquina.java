package aplicacion;

public abstract class Maquina extends Heroe {
	protected Usuario jugador1;
	public Maquina(Edificio edificio,Usuario jugador1){
		super(edificio);
		this.jugador1=jugador1;
	}
	protected abstract void analisis()throws PartidaException;
	protected void automatico() throws PartidaException{
		Ventana ventana=edificio.ventana(posI, posJ);
		while(!ventana.estaReparada())
			reparar(ventana);
	}
	public void ejecuta()throws PartidaException{
		analisis();
	}
}
