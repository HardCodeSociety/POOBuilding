package aplicacion;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.io.*;

public class Edificio implements Serializable{
  
  private static final long serialVersionUID = 1L;
  private ArrayList<Sorpresa> sorpresas;
  private ArrayList<Obstaculo> obstaculos;
  private ArrayList<Heroe> heroes;
  private ArrayList<ArrayList<Ventana>> ventanas;
  private int cantVentanas;
  private int cantPisos;
  private int[] tiposPartida;
  private static Edificio edificio=null;
  private Edificio(int cantPisos, int cantVentanas,int[] tiposPartida){
    this.cantVentanas=cantVentanas;
    this.cantPisos=cantPisos;
    obstaculos=new  ArrayList<Obstaculo>();
    heroes=new ArrayList<Heroe>();
    sorpresas=new ArrayList<Sorpresa>();
    ventanas=new ArrayList<ArrayList<Ventana>>();
    this.tiposPartida=tiposPartida;
    inicio();
  }
  public static Edificio demeEdificio(int cantPisos,int cantVentanas,int[] tiposPartida){
    if (edificio==null){
        edificio=new Edificio(cantPisos,cantVentanas,tiposPartida);
    }
    return edificio;
  }
  public void inicio(){
    for(int i=0; i<cantPisos;i++){
      ArrayList<Ventana> ventanasPiso=new ArrayList<Ventana>();
      for(int j=0;j<cantVentanas;j++){
         ventanasPiso.add(new Ventana(2,i,j));
      }
      ventanas.add(ventanasPiso);
    }
    Usuario heroe=new Usuario(this);
    heroes.add(heroe);
    if(tiposPartida[0]==1)heroes.add(new Usuario(this));
    else if (tiposPartida[1]==1)heroes.add(new Candy(this,heroe));
    else heroes.add(new Calhoun(this,heroe));
    obstaculos.add(new Ciguena(this));
    obstaculos.add(new Pato(this));
    obstaculos.add(new Ladrillo(this));
    obstaculos.add(new Ladrillo(this));
    obstaculos.add(new Ladrillo(this));
    sorpresas.add(new Pastel(this));
    sorpresas.add(new Kriptonita(this));
    sorpresas.add(new Bebida(this));
  }
  public Heroe tomarHeroe(int numero){
    return heroes.get(numero-1);
  }
  public void moverHeroe(int numero,char direccion){
	   try{
		  heroes.get(numero-1).mover(direccion);
		  if(numero==1){
			  heroes.get(numero).seTocan(heroes.get(numero-1));
		  }
		  else if(numero==2){
			  heroes.get(numero-2).seTocan(heroes.get(numero-1));
		  }
	   }catch(PartidaException e){}
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
<<<<<<< HEAD
  public int vidriosSinReparar(int i,int j){   
       return ventanas.get(i).get(j).vidriosReparar();
  }
  public Ventana ventana(int i,int j){
	  return ventanas.get(i).get(j);
  }
  
  public int[] cantidades(){
  	int[] cantidades={cantPisos+1,cantVentanas};
  	return cantidades;
  }
}


=======
  public int vidriosSinReparar(int i,int j){
        System.out.println("reparaCon");    
    System.out.println(i);
 System.out.println(j);   
       return ventanas.get(i).get(j).vidriosReparar();
  }
}

>>>>>>> origin/master
