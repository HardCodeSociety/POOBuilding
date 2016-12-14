package test;
import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.Test;
public class POOBuildingTest {

	 
//Test obstaculos 
	@Test
	public void deberiaPermitirCrearUnaPartida() {
		int[] tipo= {1,0};
		Partida partida=Partida.demePartida(4,4,tipo);
		Edificio edi =partida.getEdificio();
		assertNotEquals(edi,null);
	}

}
