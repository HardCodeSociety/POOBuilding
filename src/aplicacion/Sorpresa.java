package aplicacion;
import java.util.*;

public abstract class Sorpresa{
  protected boolean isVisible;
  protected Edificio edificio;
  protected Ventana ventana;
  protected boolean tocandoHeroe;
  protected String nombre;
  
  public Sorpresa(Edificio edificio){
	this.edificio=edificio;
	ventana=null;
    tocandoHeroe=false;
    isVisible=false;
    nombre=null;
  }
  public void makeVisible(){
	  Random rand= new Random();
	  int opcion=(int)(rand.nextInt()*4+1);
	  if(opcion==4){
		  if(!isVisible){		  
			  int posI=(int)(rand.nextInt()*(edificio.cantidades()[0]-1));
			  int posJ=(int)(rand.nextInt()*(edificio.cantidades()[1]-1));
			  ventana=edificio.ventana(posI, posJ);
			  isVisible=true;
		  }		  
	  }
  }
  public void makeInvisible(){
	  isVisible=false;
	  ventana=null;
  }
  public void tocandoHeroe(Heroe jugador)throws PartidaException{
	  if(isVisible){
		int[] posicion1 = jugador.getPosicion();
		int[] posicion2 = ventana.getPosicion();
		if(posicion1[0]==posicion2[0] && posicion1[1]==posicion2[1]){
			realizaEfecto(jugador);
			makeInvisible();
		}
	  }
  }
  public abstract void realizaEfecto(Heroe jugador)throws PartidaException;
  public void setNombre(String nombre){
	  this.nombre=nombre;
  }
  public String getNombre(){
	  return nombre;
  }
}
