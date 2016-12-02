package aplicacion;

public class Edificio {
  private boolean arreglado;
  private ArrayList <Obstaculo> obstaculos;
  private ArrayList<Heroe> herores;
  private ArrayList<Sorpresa> sorpresas;
  private int cantVentanas;
  private int cantPisos;
  public Edificio(){
    arreglado=false;
    obstaculos= new ArrayList<Obstaculo>():
    heroes = new ArrayList<Heroe>();
    sorpresas= new Arraylist<Sorpresa>();
    cantVentanas=8;
    cantPisos=8;
  }
  public ArrayList<Obstaculo> getObstaculos(){
    return obstaculos;
  }
  public ArrayList<Heroe> getHeroes(){
    return heroes;
  }
  public int getCantVentanas(){
    return cantVentanas;
  }
  public int getCantPisos(){
    return cantPisos;
  }



}
