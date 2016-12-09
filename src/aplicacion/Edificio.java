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
  public Edificio(int cantPisos, int cantVentanas){
    arreglado=false;
    this.cantVentanas=cantVentanas;
    this.cantPisos=cantPisos;
  }
  public ArrayList<Obstaculo> getObstaculos(){
    return obstaculos;
  }
  public void setObstaculos(Obstaculo o){
    obstaculos.add(o);
  }
  public void setHeroes(Heroe h){
    heroes.add(h);
  }
  public void setSorpresas(Sorpresa s){
    sorpresas.add(s);
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
  public ArrayList<Sorpresa> getSorpresas(){
    return sorpresas;
  }
}
