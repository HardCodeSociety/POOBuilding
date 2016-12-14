package aplicacion;

/**
 * @author Andrés Felipe Pardo Mesa
 * @author David Felipe Vaca Santa 
 * @version (POOB2016-2)
 **/
public class PartidaException extends Exception {
	
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
public static final String NO_CONSTRUIDO="Servicio no construido";
public static final String ERROR_IO="Error en la entrada o salida";
public static final String ERROR_CLASE="Clase no encontrada";
public static final String IMPOSIBLEMOVER="Posicion fuera de rango del Edificio";
public static final String NOEXISTEDIRECCION="La direccion no existe";
public static final String ERRORSORPRESA="La sorpresa ya existe";
public static final String ATRIBUTOSFUERADERANGO="Atributos fuera rango";


    public PartidaException(String message){
        super(message);
    }
}  

