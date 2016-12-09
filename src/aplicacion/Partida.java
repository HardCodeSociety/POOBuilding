package aplicacion;
import java.util.*;
import java.lang.*;

public class Partida{
  private Edificio edificio;
  private boolean soloUsuarios;
  private Usuario jugador1;
  private Heroe maq;
  public Partida(boolean soloUsuarios, int nMaquina){
    this.soloUsuarios=soloUsuarios;
    edificio = new Edificio(3,4);
    prepareUsuarios(soloUsuarios,  nMaquina);
  }
  public void prepareUsuarios(boolean soloUsuarios, int nMaquina){
    if(soloUsuarios){
      Usuario jugador1 = new Usuario();
      Usuario jugador2 = new Usuario();
      edificio.setHeroes(jugador2);
    }else if(nMaquina==1){
      Usuario jugador1 = new Usuario();
      Calhoun maq= new Calhoun();
    }else if(nMaquina==2){
      Usuario jugador1= new Usuario();
      Candy maq= new Candy();
    }
    edificio.setHeroes(jugador1);
    edificio.setHeroes(maq);
  }
  public void crearObstaculo(Obstaculo o){
    edificio.setObstaculos(o);
  }
  public void crearSorpresa(Sorpresa s){
    edificio.setSorpresas(s);
  }
}
