package aplicacion;
import java.util.*;
import java.lang.*;

public class Usuario extends Heroe{
  public void mover(char direccion){
      if (!gameOver){
          int pasos;
          if (energia<50){
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
          }
          if (direccion=='U'){
              posY+=2;
              if (bonificaciones.contains("Pastel")){
                bonificaciones.remove("Pastel");
              }
          }else if (direccion=='D'){
              posY-=2;
              if (bonificaciones.contains("Pastel")){
                bonificaciones.remove("Pastel");
              }
          }else if (direccion=='L'){
              posX-=2;
          }else if(direccion=='R'){
              posX+=2;
          }
          energia-=1;
          if (energia==0){
             debeMorir();
          }
          tocandoObstaculo();
          tocandoSorpresa();
      }
  }

}
