package aplicacion;
import java.util.*;
import java.lang.*;
/**
*Clase Heroe
*@autor Andres Felipe Pardo Mesa
*@autor David Felipe Vaca Santa
**/
public abstract class Heroe {
    protected Edificio edificio;
    protected int energia;
    protected int vidas;
    protected int puntos;
    protected ArrayList<String>  bonificaciones;
    protected int posX;
    protected int posY;
    protected boolean esLento;
    protected boolean gameOver;
    protected boolean repara;
    //protected Edificio edificio;
    /**
     *Creador de la clase Heroe
     **/
    public void heroe(){
        energia=100;
        vidas=3;
        puntos=0;
        bonificaciones=new ArrayList<String>();
        posX=0;
        posY=0;
        esLento=false;
        gameOver=false;
        repara=true;
    }
    /**
     *Este metodo permite mover en cuatro direcciones posibles dado un caracter /n este caracter puede ser: /n U : arriba /n D : abajo /n L: Izquierda /n R: Derecha
     *@param char direccion
     **/
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
            }else if (direccion=='D'){
                posY-=2;
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
            //tocandoSorpresa();
        }
    }
    /**
     * [agredir description]
     */
    public void agredir(){
      if (!bonificaciones.contains("Kriptonita")){
       this.debeMorir();
     }
   }
   public void setPosX(int newPosX){
     posX= newPosX;
   }
   public void setPosY(int newPosY){
     posY= newPosY;
   }
   public void ascender(int pisos){
     for (int i=posY; i<=pisos; i++){
       this.setPosY(i);
     }
   }
    /**
     *Este metodo permite a el Heroe reparar una ventana
     *@param Ventana ventana
     **/
    public void reparar(Ventana ventana){
        if(!gameOver){
            }else if(repara){
                int cantidad = ventana.vidriosReparar();
                if (cantidad>0){
                    ventana.reparar();
                    energia-=10;
                }
                if (energia<25){
                repara=false;
                }

    	}
    }
    /**
     *Este metodo permite quitar vidas a un Heroe cuando se le acaba la energia
     **/
    public void debeMorir(){
        vidas-=1;
        if (vidas==0){
            gameOver=true;
        }
    }
    public int[] getPosicion(){
      int [] coordenadas = new int[2];
  		coordenadas[0]=posX;
  		coordenadas[1]=posY;
  		return coordenadas;
    }
    /**
     *Este metodo permite saber si el Heroe esta tocando algun obstaculo
     **/

    public void tocandoObstaculo(){
        ArrayList<Obstaculo> obstaculos =edificio.getObstaculos();
        for(Obstaculo i:obstaculos){
          if(i.coordenadas().equals(this.getPosicion())){
            if(i instanceof Ladrillo ){
                 this.agredir();
            }else if (i instanceof Pato){
                i.reaccion(this);
            }else if (i instanceof Ciguena){
                i.reaccion(this);
            }
          }
        }
    }
}
