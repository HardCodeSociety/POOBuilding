public abstract class Obstaculo {
	protected int posX;
	protected int posY;
	protected boolean contacto;
	/**
	*Creador de la clase Obstaculo
	**/
	public Obstaculo(){
		posX=0;
		posY=0;
		contacto=false;
	}
	public void muevase(){
		posX+=5;
		posY+=5;
		//getPosicionHeroes;
		//if.....
	}
	public boolean enContacto(){
		return contacto;
	}
	public void reaccion(){
		//sf(contacto)
			//....
	}
}
