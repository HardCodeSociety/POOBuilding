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
  private boolean gameOver;
  
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
    gameOver=false;
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
    	 Ventana ventana=new Ventana(2,i,j);
         ventanasPiso.add(ventana);
         if(i==0&&j==2)ventana.esPuerta(true);
         if(i==1&&j==2)ventana.esCentral(true);
      }
      ventanas.add(ventanasPiso);
    }
    Usuario heroe=new Usuario(this);
    heroes.add(heroe);
    if(tiposPartida[0]==1){
    	heroes.add(new Usuario(this));
    }
    else if (tiposPartida[1]==1)heroes.add(new Candy(this,heroe));
    else heroes.add(new Calhoun(this,heroe));
    heroes.get(1).setPosJ(cantVentanas-1);
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
		  int posI=(int)(rand.nextDouble()*(cantPisos-1));
		  int posJ=(int)(rand.nextDouble()*(cantVentanas-1));
		  int opcion=(int)(rand.nextDouble()*2+1);
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
		  if(numero==1){
		       heroes.get(numero).seTocan(heroes.get(numero-1));
		   }
		   else if(numero==2){
		      heroes.get(numero-2).seTocan(heroes.get(numero-1));
		   }
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
  public void cargarSorpresas(){
	  for(Sorpresa i:sorpresas){
		  i.makeVisible();
		  try{
			  i.tocandoHeroe(heroes.get(0));
			  i.tocandoHeroe(heroes.get(1));
		  }catch(PartidaException e){}
	  }
  }
  public void romperVentanas(){
	  for(ArrayList<Ventana> i:ventanas)
		  for(Ventana j:i)
			  j.romper();
  }
  private boolean verificaVentanas(){
	  int i=0;
	  int j=0;
	  boolean resp=false;
	  while(i<cantPisos&&!resp){
		  while(j<cantVentanas&&!resp){
			  resp=ventanas.get(i).get(j).estaReparada();
			  j+=1;
		  }
		  i+=1;
	  }
	  return resp;
  }
  public boolean gameOver(){
	  return gameOver;
  }
  public void aumentarNivel(){
	  if(verificaVentanas())
		  if(nivel==3) gameOver=true;
		  else nivel+=1;
	  
  }
  public void cargargameOver(){
	  int i=0;
	  while(i<2&&!gameOver)
		  gameOver=heroes.get(i).estaMuerto();
	  	  i+=1;
  }
  public Ventana ventana(int i,int j){
	  return ventanas.get(i).get(j);
  }

  public int[] cantidades(){
  	int[] cantidades={cantPisos,cantVentanas};
  	return cantidades;
  }
  public int nivelDificultad(){
	  return nivel;
  }
  public Obstaculo obstaculo(int obstaculo){
	  return obstaculos.get(obstaculo-1);
  }
  public Sorpresa sorpresa(int sorpresa){
	  return sorpresas.get(sorpresa-1);
  }
}


