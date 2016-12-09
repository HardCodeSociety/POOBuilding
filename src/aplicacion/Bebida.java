package aplicacion;
import java.util.*;
import java.lang.*;

public class Bebida extends Sorpresa{
  private int posX;
  private int posY;
  private ArrayList<Heroe> heroes = new ArrayList<Heroe>();
  public Bebida(int posX, int posY){
    super(posX,posY);
  }
  public void efecto(Heroe h){
    int ener = h.getEnergia();
    if (ener< 50){
      h.setBonificaciones("Bebida");
      h.setEnergia(ener*2);
    }
  }
  public String getNombre(){
    return "Bebida";
  }
}
