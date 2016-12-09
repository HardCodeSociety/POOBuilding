package aplicacion;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.io.*;

public class Edificio implements Serializable{
  private ArrayList <Obstaculo> obstaculos;
  private ArrayList<Heroe> heroes;
  private ArrayList<ArrayList<Ventana>> ventanas;
  private int cantVentanas;
  private int cantPisos;
  private static Edificio edificio=null;
  private Edificio(int cantPisos, int cantVentanas){
    this.cantVentanas=cantVentanas;
    this.cantPisos=cantPisos;
    obstaculos=new  ArrayList<Obstaculo>();
    heroes=new ArrayList<Heroe>();
    ventanas=new ArrayList<ArrayList<Ventana>>();
    inicio();
  }
  public static Edificio demeEdificio(int cantPisos,int cantVentanas){
    if (edificio==null){
        edificio=new Edificio(cantPisos,cantVentanas);
    }
    return edificio;
  }
  public void inicio(){
    for(int i=0; i<cantPisos;i++){
      ArrayList<Ventana> ventanasPiso=new ArrayList<Ventana>();
      for(int j=0;j<cantVentanas;j++){
         ventanasPiso.add(new Ventana());
      }
      ventanas.add(ventanasPiso);
    }
    heroes.add(new Heroe());
    Heroe heroe=new Heroe();
    heroe.setPosY(4);
    heroes.add(heroe);
  }
  public ArrayList<Obstaculo> getObstaculos(){
    return obstaculos;
  }
  public void setObstaculos(Obstaculo o){
    obstaculos.add(o);
  }
  public Heroe tomarHeroe(int numero){
    return heroes.get(numero-1);
  }
  public void moverHeroe(int numero,int x,int y){
   heroes.get(numero-1).mover(x,y);
   if(numero==1){
       heroes.get(numero).seTocan(heroes.get(numero-1));
   }
   else if(numero==2){
      heroes.get(numero-2).seTocan(heroes.get(numero-1));
   }
  }
  public int energiaHeroe(int numero){
    return heroes.get(numero-1).getEnergia();
  }
  public int puntajeHeroe(int numero){
     return heroes.get(numero-1).getPuntaje();
  }
  public int vidasHeroe(int numero){
    return heroes.get(numero-1).getVidas();
  }
  public ArrayList<String> poderesHeroe(int numero){
    return heroes.get(numero-1).getBonificaciones();
  }
  public int[] posicionHeroe(int numero){
    int[] posicion = heroes.get(numero-1).getPosicion();
    return  posicion;
  } 
  public int getCantVentanas(){
    return cantVentanas;
  }
  public int getCantPisos(){
    return cantPisos;
  }
   public boolean estaCastigado(int numero){
    return heroes.get(numero-1).getCastigado();
  } 

  public void repara(int numero){
    System.out.println("repara");
    int[] posicion = heroes.get(numero-1).getPosicion();
    if(posicion[0]!=0){
      heroes.get(numero-1).reparar(ventanas.get(posicion[0]-1).get(posicion[1]));
       System.out.println("repara");
      System.out.println(posicion[0]-1);
     System.out.println(posicion[1]);

    }
  }
  public int vidriosSinReparar(int i,int j){
        System.out.println("reparaCon");    
    System.out.println(i);
 System.out.println(j);   
       return ventanas.get(i).get(j).vidriosReparar();
  }
}

