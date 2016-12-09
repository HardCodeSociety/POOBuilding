package aplicacion;
import java.util.*;
import java.lang.*;
/**
*Clase Heroe
*@autor Andres Felipe Pardo Mesa
*@autor David Felipe Vaca Santa
**/
public class Heroe {
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
    protected boolean castigado;

    protected int puntaje;
    /**
     *Creador de la clase Heroe
     **/
    public  Heroe(){
        energia=100;
        vidas=3;
        puntos=0;
        posX=0;
        bonificaciones=new ArrayList<String>();
        posY=0;
        esLento=false;
        gameOver=false;
        repara=true;
        castigado=false;
    }
    /**
     *Este metodo permite mover en cuatro direcciones posibles dado un caracter /n este caracter puede ser: /n U : arriba /n D : abajo /n L: Izquierda /n R: Derecha
     *@param char direccion
     **/
   public void mover(int posX,int posY){
     if(!gameOver){
     this.posX=posX;
     this.posY=posY;
     energia-=1;
     if (energia==0){
       debeMorir();
       energia=100;
     }
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
   public int getPuntaje(){
      return puntos;
   }
   public int getVidas(){
      return vidas;
   }
   public void setPosY(int nPosY){
     posY=nPosY;
   }
   public void setPosX(int nPosX){
     posX=nPosX;
   }
   public ArrayList<String> getBonificaciones(){
      return bonificaciones;
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
             if(repara){
              int cantidad = ventana.vidriosReparar();
                if (cantidad>0){
                  if(bonificaciones.contains("Pastel")){
                    ventana.reparaRapido();
                  }else{
                    ventana.reparar();
                  }
<<<<<<< HEAD
                  energia-=5;
                  puntos+=1;
=======
                  energia-=10;
                  puntaje+=10;
>>>>>>> origin/master
                }
                if (energia<25){
                repara=false;
                }

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
    //public void tocandoSorpresa(){
      //for (Sorpresa sor: sorpresas){
        //if(sor.coordenadas().equals(this.getPosicion())){
          //sor.efecto(this);
        //}
      //}
    //}
    public void seTocan(Heroe heroe2){
      if(!gameOver){
      int[] posicion1 = this.getPosicion();
      int[] posicion2 = heroe2.getPosicion();
    if(posicion1[0]==posicion2[0] && posicion1[1]==posicion2[1]){
        castigado=true;
         energia-=posX;
         if (energia==0){
         debeMorir();
        energia=100;
        }
        if(posX==0 && posY>0){
          posY-=1;  
        }else if (posY==0 && posX==0){
          heroe2.setPosY(1);
        }
        posX=0;
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
  public boolean getCastigado(){
    return castigado;
  }

}