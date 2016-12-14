package aplicacion;
import java.util.*;
/**
*Clase Heroe
*@author Andrés Felipe Pardo Mesa
*@author David Felipe Vaca Santa
*@version (POOB2016-2)
**/
public abstract class Heroe {
    protected Edificio edificio;
    protected int energia;
    protected int vidas;
    protected int puntos;
    protected ArrayList<String>  bonificaciones;
    protected ArrayList<String> hacenRapido;
    protected ArrayList<String> hacenInmune;
    protected ArrayList<String> subenEnergia;
    protected int posI;
    protected int posJ;
    protected boolean esLento;
    protected boolean gameOver;
    protected boolean esRapido;
    protected boolean repara;
    protected boolean debeCaer;
    protected boolean esInmune;
    protected int contRepara=0;
    protected int contInmunidad=0;
    /**
     *Creador de la clase Heroe
     **/
    public  Heroe(Edificio edificio){
    	this.edificio=edificio;
        energia=100;
        vidas=3;
        puntos=0;
        posI=0;
        bonificaciones=new ArrayList<String>();
        hacenRapido=new ArrayList<String>();
        hacenInmune=new ArrayList<String>();
        subenEnergia=new ArrayList<String>();
        posJ=0;
        esLento=false;
        gameOver=false;
        repara=true;
        esRapido=false;
        debeCaer=false;
        esInmune=false;
    }
    public void mover(char direccion) throws PartidaException{
    	//debeCaer=false;
    	//esInmune();
    	//removerBonificaciones(subenEnergia);
    	boolean resp=true;
    			//puedeMoverse(direccion);
    	//System.out.println(direccion);
    	if(direccion=='U'){
    		if(posI+1>edificio.cantidades()[0])throw new PartidaException(PartidaException.IMPOSIBLEMOVER);
    		if(esRapido) {
    			esRapido=false;
    			removerBonificaciones(hacenRapido);
    		}
    		if(resp)mover(posI+1,posJ);
    	}else if(direccion=='D'){
    		if(posI-1<0)throw new PartidaException(PartidaException.IMPOSIBLEMOVER);
    		if(esRapido) {
    			esRapido=false;
    			removerBonificaciones(hacenRapido);
    		}
    		if(resp)mover(posI-1,posJ);
    	}else if(direccion=='L'){
    		if(posJ-1<0)throw new PartidaException(PartidaException.IMPOSIBLEMOVER);
    		if(resp)mover(posI,posJ-1);
    	}else if(direccion=='R'){
    		if(posJ+1>(edificio.cantidades()[1])-1)throw new PartidaException(PartidaException.IMPOSIBLEMOVER);
    		if(resp)mover(posI,posJ+1);
    	}else{
    		throw new PartidaException(PartidaException.NOEXISTEDIRECCION);
    	}
    }
    /**
     *Este metodo permite mover al heroe a una posicion X y Y dadas
     *@param int posX
     *@param int posY
     **/
    protected void removerBonificaciones(ArrayList<String> especificas){
    	for(String i:especificas){
    		bonificaciones.remove(i);
    	}
    }
    protected void mover(int posI,int posJ)throws PartidaException{
    //if(!gameOver){
    			System.out.println("enHeore");
    			System.out.println(posI);
    			System.out.println(posJ);
    			if(energia<50){
    				esLento=true;
    			}
    			this.posI=posI;
    			this.posJ=posJ;
    			System.out.println("DESPUES");
    			System.out.println(posI);
    			System.out.println(posJ);
    			setEnergia(energia-1);
    			debeMorir();
    			//automatico();
    	//}
   }
   protected boolean puedeMoverse(char direccion)throws PartidaException{
	   boolean resp=true;
	   /**if(posI>0){
		   Ventana ventana=edificio.ventana(posI-1, posJ);
		   Ventana ventana2;
		   if(direccion=='U'){
				ventana2=edificio.ventana(posI, posJ);
				resp=!(ventana2.barrera('H'));
   		   }else if(direccion=='D'){
   			    resp=!(ventana.barrera('H'));
   		   }else if(direccion=='L'){
   			   resp=!(ventana.barrera('V'));
   		   }else if(direccion=='R'){
   			   ventana2=edificio.ventana(posI, posJ+1);
   			   resp=!(ventana2.barrera('V'));
   		   }else{
   			   throw new PartidaException(PartidaException.NOEXISTEDIRECCION);
   		   }
	   }**/
	   return resp;
   }
   
   protected void automatico()throws PartidaException{}
  /**
  *Este metodo permite a el Heroe reparar una ventana
  *@param Ventana ventana
  **/
   public void reparar(Ventana ventana)throws PartidaException{
	   if(!gameOver){
		   if (energia<25){
				if (contRepara<2){
					contRepara+=1;
					repara=false;
				}else if(contRepara==2){
					contRepara=0;
					repara=true;
				}
		    }
		   if(repara){
			   int cantidad = ventana.vidriosReparar();
	    		if (cantidad>0){
	    			if(esRapido){
	    				ventana.reparaRapido();
	    			}else{
	    				ventana.reparar();
	    			}
	    			setEnergia(energia-5);
	    			debeMorir();
	    			setPuntaje(puntos+1);
	    		}
	    	}
	    }
   }
   public void hacerRapido(String sorpresa)throws PartidaException{
	   esRapido=true;
	   if(bonificaciones.contains(sorpresa))throw new PartidaException(PartidaException.ERRORSORPRESA);
	   bonificaciones.add(sorpresa);
	   hacenRapido.add(sorpresa);
   }
   public void hacerInmune(String sorpresa)throws PartidaException{
	   contInmunidad=0;
	   esInmune=true;
	   if(bonificaciones.contains(sorpresa))throw new PartidaException(PartidaException.ERRORSORPRESA);
	   bonificaciones.add(sorpresa);
	   hacenInmune.add(sorpresa);
   }
  

   public void debeMorir() throws PartidaException{
      if(!esInmune){
        setVidas(vidas-1);
        if (vidas==0){
            gameOver=true;
   			setEnergia(100);
        }
      }
    }

    public void setEnergia(int energia)throws PartidaException {
      if (energia>100||energia<0)throw new PartidaException(PartidaException.ATRIBUTOSFUERADERANGO);
      this.energia=energia;
    }
    public void setPuntaje(int puntaje)throws PartidaException{
    	if(puntaje<0)throw new PartidaException(PartidaException.ATRIBUTOSFUERADERANGO);
    	this.puntos=puntaje;
    }
    public void setVidas(int vidas)throws PartidaException{
    	if(vidas>3||vidas<0)throw new PartidaException(PartidaException.ATRIBUTOSFUERADERANGO);
    	this.vidas=vidas;
    }
    public void esInmune(){
    	if(esInmune){
    		if(contInmunidad<2&&esInmune){
    			contInmunidad+=1;
    		}else{
    			esInmune=false;
    			removerBonificaciones(hacenInmune);
    		}
    	}
    }
    public void ganaEnergia(String sorpresa)throws PartidaException {
    	if(bonificaciones.contains(sorpresa))throw new PartidaException(PartidaException.ERRORSORPRESA);
    	if(energia<50)setEnergia(2*energia);
    	bonificaciones.add(sorpresa);
    	subenEnergia.add(sorpresa);
    }
    public void seTocan(Heroe heroe2)throws PartidaException{
    	if(!gameOver){  
    		int[] posicion1 = this.getPosicion();
    		int[] posicion2 = heroe2.getPosicion();
    		if(posicion1[0]==posicion2[0] && posicion1[1]==posicion2[1]){
    			debeCaer=true;
    			debeCaer();
    			debeMorir();
    		}
    	}
    }	 
    public void debeCaer()throws PartidaException{
    	if(debeCaer){
    		if(posI==0 && posJ>0)
    			posJ-=1;  
    	    else if (posI==0 && posJ==0)
    	    	posJ+=1;
    	    else
    	    	posI=0;
    		if(energia-posI<0)
    			setEnergia(0);
    		else
    			setEnergia(energia-posI);
    	}
    }
    public void seGolpea(Obstaculo causa)throws PartidaException{
    	if(causa instanceof Pato)debeCaer();
    	else if(causa instanceof Ladrillo)setEnergia(energia-((edificio.cantidades()[0]+1)-posI));
    	else if(causa instanceof Ciguena){
    		esInmune();
    		removerBonificaciones(subenEnergia);
    		setPosI(edificio.cantidades()[0]);
    	}
    }
    protected void ejecuta()throws PartidaException{}
    public boolean estaMuerto(){
    	return gameOver;
    }    
    public boolean seMueveLento(){
        return esLento;
    }
    public int getPuntaje(){
        return puntos;
     }
     public int getVidas(){
        return vidas;
     }
     public boolean caer(){
    	 return debeCaer;
     }
     public void setPosJ(int nPosJ){
       posJ=nPosJ;
     }
     public void setPosI(int nPosI){
       posI=nPosI;
     }
     public ArrayList<String> getBonificaciones(){
         return bonificaciones;
      }
     public int[] getPosicion(){
         int [] coordenadas = new int[2];
         	System.out.println("posicion");
         	System.out.println(this.posI);
         	System.out.println(this.posJ);
     		coordenadas[0]=this.posI;
     		coordenadas[1]=this.posJ;
     		return coordenadas;
     }
     public int getEnergia(){
         return energia;
     }
}
