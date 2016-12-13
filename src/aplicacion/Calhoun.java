package aplicacion;
import java.util.*;
<<<<<<< HEAD

public class Calhoun extends Maquina{
	public Calhoun (Edificio edificio,Usuario jugador1){
		  super(edificio,jugador1);
	  }
	  public void analisis() throws PartidaException{
		  Random random=new Random();
		  int opcion=(int) (random.nextDouble() * 4 + 1);
		  if(opcion==1)mover('U');
		  else if(opcion==2)mover('D');
		  else if(opcion==3)mover('R');
		  else mover('L');
	  }
=======
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
>>>>>>> origin/master
}
