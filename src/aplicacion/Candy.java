package aplicacion;
import java.util.*;
import java.lang.*;

public class Candy extends Heroe{
  private Edificio edificio;
  private int energia;
  private int vidas;
  private int puntos;
  private ArrayList<String>  bonificaciones;
  private int posX;
  private int posY;
  private boolean esLento;
  private boolean gameOver;
  private boolean repara;
  private int[] posi;
  ArrayList <Heroe> heroes= new ArrayList<Heroe>();
  public Candy(){
    energia=100;
    vidas=3;
    puntos=0;
    posX=0;
    bonificaciones=new ArrayList<String>();
    posY=0;
    esLento=false;
    gameOver=false;
    repara=true;
  }
  public void mover(char direccion){
    for(Heroe her: heroes){
      if(!(her.getPosicion().equals(this.getPosicion()))){
        posi= her.getPosicion();
      }
    }
    if(posX<posi[0]){
      posX+=1;
      if(posY<posi[0]){
        posY+=1;
      }else if(posY>posi[0]){
        posY-=1;
      }
    }else if (posX>posi[0]){
      posX-=1;
      if(posY<posi[0]){
        posY+=1;
      }else if(posY>posi[0]){
        posY-=1;
    }
  }
}
}
