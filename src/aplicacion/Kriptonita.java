package aplicacion;
import java.util.*;
import java.lang.*;

public class Kriptonita extends Sorpresa{
  private int posX;
  private int posY;
  private ArrayList<Heroe> heroes = new ArrayList<Heroe>();
  public Kriptonita(int posX, int posY){
    super(posX,posY);
  }
  public void efecto(Heroe h){
    //Regular tiempo del heroe
    }
  public String getNombre(){
    return "Kriptonita";
  }
}
