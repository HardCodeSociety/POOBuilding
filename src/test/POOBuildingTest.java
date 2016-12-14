package test;
import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
public class POOBuildingTest {

	 
//Test obstaculos 
	@Test
	public void deberiaPermitirCrearUnaPartida() {
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		assertNotEquals(edi,null);
	}
	@Test
	public void deberiaCrearHeroes1vs1(){
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		assertTrue((edi.tomarHeroe(2) instanceof Usuario) );
	}
	//@Test
	//public void deberiaCrearHeroes1vsCandy(){
		//int[] tipo= {2,1};
		//Partida partida=Partida.demePartida(4,4,tipo);
		//Edificio edi =partida.getEdificio();
		//assertTrue((edi.tomarHeroe(2) instanceof Candy));
	//}
	//@Test
		//public void deberiaCrearHeroes1vsCandy(){
			//int[] tipo= {2,2};
			//Partida partida=Partida.demePartida(4,4,tipo);
			//Edificio edi =partida.getEdificio();
			//assertTrue((edi.tomarHeroe(2) instanceof Calhoun));
		//
	@Test
	public void deberiaPermitirSaberLasVidasDeUnJugador(){
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		int[] estado= partida.estadoJugador(1);
		assertEquals(estado[2],edi.tomarHeroe(1).getVidas());
	}
	@Test
	public void deberiaPermitirSaberLaEnergiaDeUnJugador(){
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		int[] estado= partida.estadoJugador(1);
		assertEquals(estado[0],edi.tomarHeroe(1).getEnergia());
	}
	@Test
	public void deberiaPermitirSaberElPuntajeDeUnJugador(){
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		int[] estado= partida.estadoJugador(1);
		assertEquals(estado[1],edi.tomarHeroe(1).getPuntaje());
	}
	@Test
	public void deberiaPoderSaberLasBonificacionesDelHeroe() throws PartidaException{
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		edi.tomarHeroe(1).hacerInmune("Kriptonita");
		String bonif= partida.estadoPoder(1);
		assertEquals(bonif,"0.0.1.");
	}
	@Test
	public void deberiaPoderDarElEstadoDeUnaVentanaCorrectamente(){
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		Ventana vent= edi.ventana(1, 1);
		vent.reparaRapido();
		assertEquals((partida.estadoVentanas(1, 1)),"1.0.0.0.0.0.");
	}
	@Test
	public void deberiaMoverElHeroe(){
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		int[] posicion=edi.tomarHeroe(1).getPosicion();
		partida.moverHeroe(1,'U');
		int val=(((edi.tomarHeroe(1)).getPosicion())[1]);
		assertEquals(posicion[0],val);
	}
	@Test
	public void deberiaCrearCorrectamenteUnHeroe(){
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		Heroe hero= edi.tomarHeroe(1);
		assertTrue((hero.getEnergia()==99) && (hero.getVidas()==2) && (hero.getPuntaje()==0));
	}
	@Test
	public void deberiaPermitirAgregarBonificaciones() throws PartidaException{
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		(edi.tomarHeroe(1)).hacerInmune("Sorpresa");
		ArrayList<String> boni= edi.tomarHeroe(1).getBonificaciones();
		assertTrue(boni.contains("Sorpresa"));
	}
	@Test
	public void deberiaPermitirRepararUnaVentana() throws PartidaException{
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		int[] posi = edi.tomarHeroe(1).getPosicion();
		Ventana vent=edi.ventana(posi[0], posi[1]);
		vent.reparaRapido();
		assertEquals(vent.estaReparada(),true);
	}
	@Test
	public void deberiaTenerEfectoConObstaculos() throws PartidaException{
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		Obstaculo obs= edi.obstaculo(1);
		int[] posi= edi.tomarHeroe(1).getPosicion();
		obs.tocandoHeroe(edi.tomarHeroe(1));
		if(obs.getPosicion()==(posi)){
			assertNotEquals(obs.getPosicion(), posi);
		assertNotEquals(obs.getPosicion(),null);
		}
	}
}


