package aplicacion;
import java.util.*;

/**
*Clase Heroe 
*@autor Andres Felipe Pardo Mesa
*@autor David Felipe Vaca Santa 
**/
public abstract class Heroe {
    protected int energia;
    protected int vidas;
    protected int puntos;
    protected ArrayList<String>  proteccion;
    protected int posX;
    protected int posY;
    protected boolean esLento;
    protected boolean gameOver;
    protected boolean repara;
    protected Edificio edificio;
/**
*Creador de la clase Heroe
**/
    public heroe(){
        energia=100;
        vidas=3;
        puntos=0;
        proteccion=new ArrayList<String>();
        x=0;
        y=0;
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
                esLento=true;
                pasos=1;
            }else {
                pasos=5;
            }
            if (direccion=='U'){
                y+=pasos;
            }else if (direccion=='D'){
                y-=pasos;
            }else if (direccion=='L'){
                x-=pasos;
            }else (direccion=='R'){
                x+=pasos;
            }   
            energia-=1;
            if (energia==0){
            }        } 
                debeMorir();
    }
/**
*Este metodo permite a el Heroe reparar una ventana
*@param Ventana ventana
**/
    public void reparar(Ventana ventana){
        if(!gameOver){
            if (energia<25){
                repara=false;   
            }else if(repara){
                int cantidad = ventana.vidriosReparar()
                if (cantidad>0){
                    ventana.reparar();
                    energia-=3;
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
            gameOver=True;
        }
    }
/**
*Este metodo permite saber si el Heroe esta tocando algun obstaculo
**/
        
    public void tocandoObstaculo(){
        ArrayList<Obstaculo> obstaculos =edifico.getObstaculos();
        for(Obstaculo i:obstaculos){
            if(i instanceof Ladrillo ){
               if(i.coordenadas().equals coordenadas()){
                   
               }
            }
        }
    }