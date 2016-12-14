package aplicacion;
import java.io.*;
import java.util.*;
import java.awt.*;

public class POOBArchivos{
	public static void guarde(File f, Partida d) throws PartidaException {
		try{
	    	ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(d);
			out.close();
		}catch(IOException e){
			throw new PartidaException(PartidaException.ERROR_IO);  
		}
	}

public static Partida abra(File f) throws PartidaException{
		try{
			ObjectInputStream in =new ObjectInputStream(new FileInputStream(f));
			Partida partidaGuardada=(Partida) in.readObject();
			in.close();
			return partidaGuardada;
		}catch(IOException e){
			throw new  PartidaException(PartidaException.ERROR_IO); 
		}catch(ClassNotFoundException e){
			throw new  PartidaException(PartidaException.ERROR_CLASE); 
		}
	}
}