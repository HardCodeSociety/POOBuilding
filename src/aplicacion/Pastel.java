package aplicacion;
import java.util.*;
import java.lang.*;

public class Pastel extends Sorpresa{
  private int posX;
  private int posY;
  private ArrayList<Heroe> heroes = new ArrayList<Heroe>();
  public Pastel(int posX, int posY){
    super(posX,posY);
  }
  public void efecto(Heroe h){
    h.setBonificaciones("Pastel");
  }
  public String getNombre(){
    return "Pastel";
  }
}
