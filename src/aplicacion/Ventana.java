package aplicacion;
/**
*Clase Ventana
*@autor Andres Felipe Pardo Mesa
*@autor David Felipe Vaca Santa
**/
public class Ventana {
	private boolean reparada;
	private int numVidrios;
	private int vidriosReparados;
	private boolean esPuerta;
	private boolean conSorpresa;
	private boolean esCentral;
	private int posI;
	private int posJ;
	private boolean barreraVertical;
	private boolean barreraHorizontal;
	/**
	 * Creador de la clase Ventana
	 */
	public Ventana(int numVidrios,int posI,int posJ){
		this.posI=posI;
		this.posJ=posJ;
		reparada=false;
		this.numVidrios= numVidrios;
		vidriosReparados=0;
		esPuerta=false;
		conSorpresa=false;
		esCentral=false;
		barreraVertical=false;
		barreraHorizontal=false;
		}
	/**
	 * Nos permite saber la cantidad de vidrios por reparar.
	 * @return int vidriosRepar
	 */
	public int vidriosReparar(){
		return numVidrios-vidriosReparados;
	}
	/**
	 *Este metodo nos permite cambiar el estado de una ventana a reparada
	 */
	public void reparar(){
		vidriosReparados+=1;
		if (vidriosReparar()==0)
			reparada=true;
	}
	public void romper(){
		if(reparada){
			vidriosReparados=0;
			reparada=false;
		}
	}
	public void reparaRapido(){
		reparada=true;
	}
	public void esPuerta(boolean resp){
		esPuerta=resp;
	}

	public boolean estaReparada(){
		return reparada;
	}
	public void esCentral(boolean resp){
		esCentral=resp;
	}
	public void conBarrera(char sentido,boolean resp)throws PartidaException{
		if(sentido=='H')barreraHorizontal=resp;
		else if(sentido=='V')barreraVertical=resp;
		else
			throw new PartidaException(PartidaException.NOEXISTEDIRECCION);
	}
	public boolean puerta(){
		return  esPuerta;
	}
	public boolean central(){
		return esCentral;
	}
	public void conSorpresa(boolean resp){
		conSorpresa=resp;
	}
	public boolean  sorpresa(){
		return conSorpresa;
	}
	public boolean barrera(char sentido)throws PartidaException{
		boolean resp=false;
		if(sentido=='H')resp=barreraHorizontal;
		else if(sentido=='V')resp=barreraVertical;
		else
			throw new PartidaException(PartidaException.NOEXISTEDIRECCION);
		return resp;
	}
	public void setPosJ(int nPosJ){
	     posJ=nPosJ;
	}
	public void setPosI(int nPosI){
		posI=nPosI;
	}
	public int[] getPosicion(){
	    int [] coordenadas = new int[2];
	  	coordenadas[0]=posI;
	  	coordenadas[1]=posJ;
	  	return coordenadas;
	}
}
