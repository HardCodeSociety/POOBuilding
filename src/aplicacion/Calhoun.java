package aplicacion;
import java.util.*;
import java.lang.*;

public class Calhoun extends Heroe{
  private Edificio edificio;
  private int energia;
  private int vidas;
  private int puntos;
  private ArrayList<String>  bonificaciones;
  private int posX;
  private int posY;
  private boolean esLento;
  private int puntaje;
  private boolean gameOver;
  private boolean repara;
  ArrayList <Heroe> heroes= new ArrayList<Heroe>();
  public Calhoun(){
    energia=100;
    vidas=3;
    puntos=0;
    posX=0;
    bonificaciones=new ArrayList<String>();
    posY=0;
    esLento=false;
    gameOver=false;
    repara=true;
    puntaje=0;
  }
  public void mover(char direccion){
    char[] cad = {'U','D','L','R'};
    char mov = cad[(int)(Math.random()*3)];
    if(mov=='u'){
      posY+=2;
    }else if(mov=='D'){
      posY-=2;
    }else if(mov=='L'){
      posX-=2;
    }else{
      posX+=2;
    }
  }
}
