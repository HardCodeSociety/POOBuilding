package aplicacion;
import java.util.*;
import java.lang.*;

public class Edificio {
  private boolean arreglado;
  private ArrayList <Obstaculo> obstaculos = new ArrayList<Obstaculo>();
  private ArrayList<Heroe> heroes = new ArrayList<Heroe>();
  private ArrayList<Sorpresa> sorpresas = new ArrayList<Sorpresa>();
  private int cantVentanas;
  private int cantPisos;
  public Edificio(){
    arreglado=false;
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
