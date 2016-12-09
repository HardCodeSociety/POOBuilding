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
    protected int puntaje;
    /**
     *Creador de la clase Heroe
     **/
    public void heroe(){
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
    /**
     *Este metodo permite mover en cuatro direcciones posibles dado un caracter /n este caracter puede ser: /n U : arriba /n D : abajo /n L: Izquierda /n R: Derecha
     *@param char direccion
     **/
    abstract public void mover(char direccion);
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
   public void setBonificaciones(String nombre){
      if(bonificaciones.contains(nombre)){
        bonificaciones.remove(nombre);
      }else{
        bonificaciones.add(nombre);
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
                  if(bonificaciones.contains("Pastel")){
                    ventana.reparaRapido();
                  }else{
                    ventana.reparar();
                  }
                  energia-=10;
                  puntaje+=10;
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
    public int getEnergia(){
      return energia;
    }
    public void setEnergia(int newEner){
      this.energia=newEner;
    }
    /**
     *Este metodo permite saber si el Heroe esta tocando algun obstaculo
     **/
    public void tocandoSorpresa(){
      ArrayList<Sorpresa> sorpresas =edificio.getSorpresas();
      for (Sorpresa sor: sorpresas){
        if(sor.coordenadas().equals(this.getPosicion())){
          sor.efecto(this);
        }
      }
    }
    public void tocandoObstaculo(){
      ArrayList<Obstaculo> obstaculos =edificio.getObstaculos();
        for(Obstaculo i:obstaculos){
          if(i.coordenadas().equals(this.getPosicion())){
            if(i instanceof Ladrillo ){
                 this.agredir();
            }else{
                i.reaccion(this);
            }
          }
        }
    }
}
