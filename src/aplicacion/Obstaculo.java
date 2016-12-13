package aplicacion;

public abstract class Obstaculo {
	protected int posI;
	protected int posJ;
	protected boolean isVisible;
	protected Edificio edificio;
	/**
	*Creador de la clase Obstaculo
	**/
	public Obstaculo(Edificio edificio){
		this.edificio=edificio;
		posI=0;
		posJ=0;
		isVisible=false;
	}
	public abstract void makeVisible();
	public abstract void mover();
	public void makeInvisible(){
		isVisible=false;
		posI=0;
		posJ=0;
	}
	public abstract void tocandoHeroe(Heroe jugador)throws PartidaException;
	public int[] getPosicion(){
	      int [] coordenadas = new int[2];
	  		coordenadas[0]=posI;
	  		coordenadas[1]=posJ;
	  		return coordenadas;
	}
}
