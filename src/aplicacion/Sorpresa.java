package aplicacion;
import java.util.*;
import java.lang.*;

public abstract class Sorpresa{
  protected int posX;
  protected int posY;
  protected Edificio edificio;
  public Sorpresa(){
    Random rand= new Random();
    posX=(int)(rand.nextInt()*3+0);
    posY=(int)(rand.nextInt()*4+0);
  }
  public Sorpresa(int posX, int posY){
    if (posX > 4 && posY > 5){
      this.posX=1;
      this.posY=1;
    }
    this.posX=posX;
    this.posY=posY;
  }
  abstract public void efecto(Heroe h);
  abstract public String getNombre();
  public int[] coordenadas(){
		int [] coordenadas = new int[2];
		coordenadas[0]=posX;
		coordenadas[1]=posY;
		return coordenadas;
	}
}
