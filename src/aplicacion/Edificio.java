package aplicacion;
import java.util.*;
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
  private int nivel;
  
  private Edificio(int cantPisos, int cantVentanas,int[] tiposPartida){
    this.cantVentanas=cantVentanas;
    this.cantPisos=cantPisos;
    obstaculos=new  ArrayList<Obstaculo>();
    heroes=new ArrayList<Heroe>();
    sorpresas=new ArrayList<Sorpresa>();
    ventanas=new ArrayList<ArrayList<Ventana>>();
    nivel=1;
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
    ponerBarreras();
  }
  private void ponerBarreras(){
	  Random rand= new Random();
	  for(int i=0;i<(nivel*2);i++){
		  char sentido;
		  int posI=(int)(rand.nextInt()*(cantPisos-1));
		  int posJ=(int)(rand.nextInt()*(cantVentanas-1));
		  int opcion=(int)(rand.nextInt()*2+1);
		  if (opcion==1)sentido='H';
		  else sentido='V';
		  try{
			  ventanas.get(posI).get(posJ).conBarrera(sentido,true);			  
		  }catch(PartidaException e){}
	  }
  }
  public void moverHeroe(int numero,char direccion){
   try{
	  if(tiposPartida[0]==2){
		  heroes.get(0).mover(direccion);
		  heroes.get(0).seTocan(heroes.get(1));
		  if(heroes.get(1) instanceof Maquina){
			  heroes.get(1).ejecuta();
			  heroes.get(1).seTocan(heroes.get(0));
		  }
	  }else{
		  heroes.get(numero-1).mover(direccion);
	  	  if(numero==1) heroes.get(numero-1).seTocan(heroes.get(numero));	  		  
	  	  else heroes.get(numero-1).seTocan(heroes.get(numero-2));
   	  }
	  		  
   }catch(PartidaException e){}
  }
  public Heroe tomarHeroe(int numero){
	  return heroes.get(numero-1);
  }
  
  public void repara(int numero){
	 Ventana ventana;
	 try{
		 if(tiposPartida[0]==2){
			 int[] posicion=heroes.get(0).getPosicion();
			 if(posicion[0]>0){
				 ventana=ventana(posicion[0]-1,posicion[1]);
				 heroes.get(0).reparar(ventana);
			 }
			 if(heroes.get(1) instanceof Maquina)heroes.get(1).ejecuta();
		  }else{
			  int[] posicion=heroes.get(numero-1).getPosicion();
				 if(posicion[0]>0){
					 ventana=ventana(posicion[0]-1,posicion[1]);
					 heroes.get(numero-1).reparar(ventana);
				 }
	   	  }
		  		  
	  }catch(PartidaException e){}
  }
  public void cargarObstaculos(){
	  for(Obstaculo i:obstaculos){
		  i.makeVisible();
		  try{
			  i.tocandoHeroe(heroes.get(0));
			  i.tocandoHeroe(heroes.get(1));
		  }catch(PartidaException e){}
	  }
  }
  public void cargarSorpresa
  public Ventana ventana(int i,int j){
	  return ventanas.get(i).get(j);
  }

  public int[] cantidades(){
  	int[] cantidades={cantPisos,cantVentanas};
  	return cantidades;
  }
  public void aumentaNivel(){
	  nivel+=1;
  }
  public int nivelDificultad(){
	  return nivel;
  }
}


