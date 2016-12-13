package aplicacion;

import java.util.ArrayList;

public class Partida {
	s
	private Edificio edificio;
	private static Partida partida;
	
	private Partida(int cantPisos, int cantVentanas,int[] tiposPartida){
		    edificio=Edificio.demeEdificio(cantPisos, cantVentanas, tiposPartida);
		  }
	public void demePartida(int cantPisos, int cantVentanas,int[] tiposPartida){
		if (partida==null){
	        partida=new Partida(cantPisos,cantVentanas,tiposPartida);
	    }
	}
	public estadoJugador1(){
		
	}
}
