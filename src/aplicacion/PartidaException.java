package aplicacion;
import java.util.*;
/**
 * @author Andrés Felipe Pardo Mesa
 * @author David Felipe Vaca Santa 
 * @version (POOB2016-2)
 **/
public class PartidaException extends Exception {
	
public static final String IMPOSIBLEMOVER="Posicion fuera de rango del Edificio";
public static final String NOEXISTEDIRECCION="La direccion no existe";
public static final String ERRORSORPRESA="La sorpresa ya existe";
public static final String ATRIBUTOSFUERADERANGO="Atributos fuera rango";


    public PartidaException(String message){
        super(message);
    }
}  
