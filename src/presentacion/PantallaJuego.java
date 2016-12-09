package presentacion;
import aplicacion.Edificio;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;

public class PantallaJuego extends JDialog {
    private JFrame pantallaPrincipal;
    private int tipoDeJuego;
    private String tipoMaquina;
    private JPanel panelJugadores;
    private PanelJuego panelJuego;
    private JPanel panelJugadores3;

    private JLabel nombreJugador1;
    private JProgressBar energia1;
    private JLabel vidas1;
    private JLabel poderes1;
    private Color color1;
    private String nombre1;
    private JLabel nombreJugador2;
    private JProgressBar energia2;
    private JLabel poderes2;
    private JLabel vidas2;
    private Color color2;
    private String nombre2;
    private JTextField puntaje1;
    private JTextField puntaje2;
    private ArrayList<ArrayList<JLabel>> ventanas;
    private JLabel ralph;
    private Timer tiempo ;
    private TimerTask task;
    private TimerTask task2;
    private int parar=0;
    private int principal=0;
    private JLabel jugador1;
    private JLabel jugador2;
    private int animacion;
    private boolean jugar=false;
    private String rutaColor1;
    private String rutaColor2;
    private Edificio edificio;
   

    public PantallaJuego(JFrame owner,int tipoDeJuego,ArrayList<String> nombres,ArrayList<Color> colores){
        super(owner);
        pantallaPrincipal=owner;
        this.tipoDeJuego=tipoDeJuego;
        nombre1=nombres.get(0);
        nombre2=nombres.get(1);
        color1=colores.get(0);
        color2=colores.get(1);
        if (tipoDeJuego==2)
            tipoMaquina=nombres.get(2);
        prepareElementos();
        prepareAcciones();
        edificio=Edificio.demeEdificio(3,5);
    }
    public void prepareElementos(){
        setTitle("PANTALLA DE JUEGO");
		setSize(1366,710);
        setResizable(false);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        panelJugadores=new JPanel();
        panelJugadores.setBackground(Color.BLACK);
        panelJuego=new PanelJuego();
        setFocusable(true);
        panelJuego.setLayout(null);
        panelJuego.setImagen("imagenes/edificio.jpg");
        elementosPanelJuego();
        panelJugadores.setLayout(new GridLayout(5,3,100,0));
        panelJugadores.setBorder(BorderFactory.createEmptyBorder(0,200,0,200));
        elementosPanelJugadores();
        panelJugadores3=new JPanel();
        panelJugadores3.setOpaque(true);
        add(panelJugadores,BorderLayout.NORTH);
        add(panelJuego,BorderLayout.CENTER);
    }
    private void elementosPanelJugadores(){
        Font fuente = new Font("SEGA LOGO FONventanaT",Font.TRUETYPE_FONT, 14);
        nombreJugador1=new JLabel(nombre1);
        nombreJugador2=new JLabel(nombre2);
        nombreJugador1.setFont(fuente);
        nombreJugador2.setFont(fuente);
		nombreJugador1.setForeground(color1);
        nombreJugador2.setForeground(color2);
        energia1=new JProgressBar(0,100);
        energia2=new JProgressBar(0,100);
        energia1.setValue(100);
        energia1.setOpaque(false);
        energia1.setForeground(color1);
        energia1.setStringPainted(true);
        energia2.setValue(100);
        energia2.setOpaque(false);
        energia2.setForeground(color2);
        energia2.setStringPainted(true);
        ImageIcon icono=new ImageIcon("imagenes/vidas.png");
        vidas1=new JLabel();
        vidas2=new JLabel();
        vidas1.setOpaque(true);
        vidas2.setOpaque(true);
        vidas1.setBackground(color1);
        vidas2.setBackground(color2);
        vidas1.setIcon(icono);
        vidas2.setIcon(icono);
        poderes1=new JLabel();
        poderes2=new JLabel();
        icono=new ImageIcon("imagenes/poderes.png");
        poderes1.setIcon(icono);
        poderes2.setIcon(icono);
        icono=new ImageIcon("imagenes/pausa.png");
        puntaje1=new JTextField("0");
        puntaje1.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
        puntaje1.setEditable(false);
        puntaje1.setBackground(Color.BLACK);
        puntaje1.setForeground(color1);
        puntaje2=new JTextField("0");
        puntaje2.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
        puntaje2.setEditable(false);
        puntaje2.setBackground(Color.BLACK);
        puntaje2.setForeground(color2);
        panelJugadores.add(nombreJugador1);
        panelJugadores.add(nombreJugador2);
        panelJugadores.add(puntaje1);
        panelJugadores.add(puntaje2);
        panelJugadores.add(energia1);
        panelJugadores.add(energia2);
        panelJugadores.add(vidas1);
        panelJugadores.add(vidas2);
        panelJugadores.add(poderes1);
        panelJugadores.add(poderes2);
    }
    private void elementosPanelJuego(){
        prepareJugador1();
        prepareJugador2();
        prepareRalph();
        prepareVentanas();
        animacionRalph();
    }
    private void romperVentanas(){
        for(int i=0;i<3;i++){
            for(int j=0;j<5;j++){
                if (i==0 && j==2){
                    ventanas.get(i).get(j).setIcon(new ImageIcon("imagenes/puertaRota.png"));
                }else if (i==1 && j==2){
                    ventanas.get(i).get(j).setIcon(new ImageIcon("imagenes/ventanaCentroRota.png"));
                }else{
                    ventanas.get(i).get(j).setIcon(new ImageIcon("imagenes/ventanaRota.png"));
                }
            }
        }
    }
    private void prepareJugador1(){
        if(color1.equals(Color.YELLOW))
            rutaColor1="imagenes/felix/felixAmarillo/";
        else if(color1.equals(Color.BLACK))
            rutaColor1="imagenes/felix/felixNegro/";
        else if(color1.equals(Color.BLUE))
            rutaColor1="imagenes/felix/felixAzul/";
        else if(color1.equals(new Color(127, 0, 255)))
            rutaColor1="imagenes/felix/felixMorado/";
        else if(color1.equals(Color.RED))
            rutaColor1="imagenes/felix/felixRojo/";
        else
            rutaColor1="imagenes/felix/felixVerde/";
        ImageIcon icono =new ImageIcon(rutaColor1+"1.png");
        jugador1=new JLabel();
        jugador1.setBackground(color1);
        jugador1.setIcon(icono);
        panelJuego.add(jugador1);
        jugador1.setBounds(536,420,83,150);
    }
    private void prepareJugador2(){
        if(color2.equals(Color.YELLOW))
            rutaColor2="imagenes/felix/felixAmarillo/";
        else if(color2.equals(Color.BLACK))
            rutaColor2="imagenes/felix/felixNegro/";
        else if(color2.equals(Color.BLUE))
            rutaColor2="imagenes/felix/felixAzul/";
        else if(color2.equals(new Color(127, 0, 255)))
            rutaColor2="imagenes/felix/felixMorado/";
        else if(color2.equals(Color.RED))
            rutaColor2="imagenes/felix/felixRojo/";
        else
            rutaColor2="imagenes/felix/felixVerde/";
        ImageIcon icono =new ImageIcon(rutaColor2+"1.png");
        jugador2=new JLabel();
        jugador2.setIcon(icono);
        panelJuego.add(jugador2);
        jugador2.setBounds(808,420,83,150);
    }
    private void prepareRalph(){
        ralph=new JLabel();
        ImageIcon icono=new ImageIcon("imagenes/ralph/1.png");
        ralph.setIcon(icono);
        panelJuego.add(ralph);
        ralph.setBounds(656,278,83,150);
    }
    private void prepareVentanas(){
        ImageIcon icono;
        ventanas=new ArrayList<ArrayList<JLabel>>();
        int factorY=367;
        int factorX;
        for (int i=0;i<4;i++){
            factorX=0;
            ArrayList<JLabel> ventanasDePiso =new ArrayList<JLabel>();
            for(int j=0;j<5;j++){
                JLabel ventana=new JLabel();
                if(i==0&&j==2)
                     icono=new ImageIcon("imagenes/puerta.png");
                else if(i==1&&j==2)
                     icono=new ImageIcon("imagenes/ventanaCentro.png");
                else
                     icono=new ImageIcon("imagenes/ventana.png");
                ventana.setIcon(icono);
                panelJuego.add(ventana);
                factorX=(68*j);
                ventana.setBounds(491+factorX,factorY,83,150);
                ventanasDePiso.add(ventana);
            }
            ventanas.add(ventanasDePiso);
            factorY=factorY-(95+(i*10));
        }
    }
    private void animacionRalph(){
        animacion=0;
        tiempo = new Timer();
        task = new TimerTask() {
               public void run() {
                   parar+=1;
                   principal+=1;
                   if (parar>1){
                        if(parar<=6){
                            animacionRalphLenvantaBrazos();
                        }else if(parar<=27){
                            animacionRalphSubeEdificio();
                        }else if(parar<=33){
                            animacionRalphLenvantaBrazos();
                            principal=4;
                        }else if(parar<=42){
                            animacionRalphDestruye();
                        }else{
                            romperVentanas();
                            ralph.setIcon(new ImageIcon("imagenes/ralph/1.png"));
                            jugar=true;
                            pararAnimacion(); 
                        }
                   }
               }
           };                                        
           tiempo.schedule(task,0,400); 
    }
    private void animacionRalphLenvantaBrazos(){
        ImageIcon icono1=new ImageIcon("imagenes/ralph/1.png");
        ImageIcon icono2=new ImageIcon("imagenes/ralph/2.png");
        if (principal==1){
            ralph.setIcon(icono2);
        }else{
            ralph.setIcon(icono1);
            principal=0;
        }
    }
    private void animacionRalphSubeEdificio(){
        animacion+=1;
         ImageIcon icono3=new ImageIcon("imagenes/ralph/3.png");
         ImageIcon icono4=new ImageIcon("imagenes/ralph/4.png");
         if (principal==1){
            ralph.setIcon(icono3);
            ralph.setBounds(656,278-(animacion*10),83,150);
         }else{
           ralph.setIcon(icono4);
           ralph.setBounds(656,278-(animacion*10),83,150);
           principal=0;
        }
    }
    private void animacionRalphDestruye(){
        ImageIcon icono1=new ImageIcon("imagenes/ralph/8.png");
        ImageIcon icono2=new ImageIcon("imagenes/ralph/9.png");
        if (principal<=8){
            ralph.setIcon(new ImageIcon("imagenes/ralph/"+Integer.toString(principal)+".png"));
        }else{
            principal=4;
        }
    }
     public void pararAnimacion() {
        tiempo.cancel();
            task.cancel();

    }
    public void prepareAcciones(){
         addWindowListener (
			     new WindowAdapter(){
                        @Override
				         public void windowClosing(WindowEvent e){
                                    System.out.println("entra");
					              cerrarVentana();
				          }
			    }
		);

        addKeyListener(
             new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if (e.getKeyCode()==KeyEvent.VK_P){
                        pausaJuego();
                    } 
                }
            }   

        );

        prepareAccionesJugador1();
        if (tipoDeJuego==1){
        prepareAccionesJugador2();
        }else{
            juegoMaquina(tipoMaquina);
        }
    }
    public void prepareAccionesJugador2(){
         addKeyListener(
            new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if(e.getKeyCode()==KeyEvent.VK_W){
                        moverArriba(2);
                    } 
                }
            }
        );
         addKeyListener(
             new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if (e.getKeyCode()==KeyEvent.VK_S){
                        moverAbajo(2);
                    } 
                }
            }   

        );
        addKeyListener(
             new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if (e.getKeyCode()==KeyEvent.VK_A){
                        moverIzquierda(2);
                    } 
                }
            }   

        );
         addKeyListener(
             new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if (e.getKeyCode()==KeyEvent.VK_D){
                        moverDerecha(2);
                    } 
                }
            }   
        );
         addKeyListener(
            new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if(e.getKeyCode()==KeyEvent.VK_SPACE){
                        reparar(2);
                    } 
                }
            }
        );
    }



    public void prepareAccionesJugador1(){
         addKeyListener(
             new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if (e.getKeyCode()==KeyEvent.VK_UP){
                        moverArriba(1);
                    } 
                }
            }   

        );
        addKeyListener(
             new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if (e.getKeyCode()==KeyEvent.VK_DOWN){
                        moverAbajo(1);
                    } 
                }
            }   

        );
        addKeyListener(
             new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if (e.getKeyCode()==KeyEvent.VK_LEFT){
                        moverIzquierda(1);
                    } 
                }
            }   

        );
         addKeyListener(
             new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                        moverDerecha(1);
                    } 
                }
            }   
        );
         addKeyListener(
            new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if(e.getKeyCode()==KeyEvent.VK_SHIFT){
                        reparar(1);
                    } 
                }
            }
        );
    }
    public void cerrarVentana(){
			if(JOptionPane.showConfirmDialog(null, "Estas seguro?")== JOptionPane.OK_OPTION){
                pantallaPrincipal.setVisible(true);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			}else{
				setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			}
	}
    public void moverArriba(int jugador){
        if(jugar){
            if(jugador==1){
                 int[] posicion=edificio.posicionHeroe(1);
                 if(posicion[0]<3){
                    edificio.moverHeroe(1,posicion[0]+1,posicion[1]);
                 }
            }else if (jugador==2){
                int[] posicion=edificio.posicionHeroe(2);
                if(posicion[0]<3){
                    edificio.moverHeroe(2,posicion[0]+1,posicion[1]);
                }
            }
            actualice();
        }

    }
    private void moverAbajo(int  jugador){
         if(jugar){
            if(jugador==1){
                 int[] posicion=edificio.posicionHeroe(1);
                 if(posicion[0]>0){
                    edificio.moverHeroe(1,posicion[0]-1,posicion[1]);
                 }
            }else if (jugador==2){
                int[] posicion=edificio.posicionHeroe(2);
                if(posicion[0]>0){
                    edificio.moverHeroe(2,posicion[0]-1,posicion[1]);
                }
            }
            actualice();
        }
    }
    private void moverIzquierda(int jugador){
        if(jugar){
            if(jugador==1){
                 int[] posicion=edificio.posicionHeroe(1);
                 if(posicion[1]>0){
                    edificio.moverHeroe(1,posicion[0],posicion[1]-1);
                 }
            }else if (jugador==2){
                int[] posicion=edificio.posicionHeroe(2);
                if(posicion[1]>0){
                    edificio.moverHeroe(2,posicion[0],posicion[1]-1);
                }
            }
            actualice();
        }
    }
    private  void moverDerecha(int jugador){
         if(jugar){
            if(jugador==1){
                 int[] posicion=edificio.posicionHeroe(1);
                 if(posicion[1]<4){
                    edificio.moverHeroe(1,posicion[0],posicion[1]+1);
                 }
            }else if (jugador==2){
                int[] posicion=edificio.posicionHeroe(2);
                if(posicion[1]<4){
                        edificio.moverHeroe(2,posicion[0],posicion[1]+1);
                }
            }
            actualice();
        }

    }
    private void pausaJuego(){

    }
    private void juegoMaquina(String tipoMaquina){

    }

    private void actualice(){
        actualizarPos(jugador1,rutaColor1);
        actualiceBarra(1);
        actualicePoder(1);
        actualiceVida(1);
        actualicePuntaje(1);
        actualizarPos(jugador2,rutaColor2);
        actualiceBarra(2);
        actualicePoder(2);
        actualiceVida(2);
        actualicePuntaje(2);
    }   
    private void reparar(int jugador){
        ImageIcon icono=null;
        int[] posicion=edificio.posicionHeroe(jugador);
         System.out.println("pantalla de juego");
        System.out.println(posicion[0]);
        System.out.println(posicion[1]);
        if (posicion[0]!=0){
            edificio.repara(jugador);
            int cantidadVidrios=edificio.vidriosSinReparar(posicion[0]-1,posicion[1]);
            System.out.println("VIDRIOS");
            System.out.println(cantidadVidrios);
             if (cantidadVidrios==1){
                icono=new ImageIcon("imagenes/ventanaRota2.png");        
            }else if(cantidadVidrios==0){
                icono=new ImageIcon("imagenes/ventana.png");
            }
        ventanas.get(posicion[0]-1).get(posicion[1]).setIcon(icono);    
        }
        if(jugador==1){
          jugador1.setIcon(new ImageIcon(rutaColor1+"3.png"));
        }else{
          jugador2.setIcon(new ImageIcon(rutaColor2+"3.png"));
        }
        actualice();
    }
    private void actualizarPos(JLabel jugador,String ruta){
        int[] pos;
        int numJugador;
        if(jugador.equals(jugador1)){
            pos=edificio.posicionHeroe(1);
             numJugador=1;
        }else{
             pos=edificio.posicionHeroe(2);
             numJugador=2;
        }
        if(pos[0]!=0){
            int x=ventanas.get(pos[0]-1).get(pos[1]).getX();
            int y=ventanas.get(pos[0]-1).get(pos[1]).getY();
            if (edificio.estaCastigado(numJugador)){
                jugador.setIcon(new ImageIcon(ruta+"3.png"));
            }else{
            jugador.setIcon(new ImageIcon(ruta+"2.png"));
            }
            jugador.setLocation(x+45,(y+7)-(pos[0]-1*2));
            jugador.setIcon(new ImageIcon(ruta+"1.png"));
        }else{
             int x=ventanas.get(pos[0]).get(pos[1]).getX();
            if (edificio.estaCastigado(numJugador)){
                jugador.setIcon(new ImageIcon(ruta+"3.png"));
            }else{
            jugador.setIcon(new ImageIcon(ruta+"2.png"));
            }
            jugador.setLocation(x+45,420);
            jugador.setIcon(new ImageIcon(ruta+"1.png"));
        }
    }
    private void actualiceBarra(int jugador){
        int nuevo= edificio.energiaHeroe(jugador);
        if (jugador==1){
            energia1.setValue(nuevo);
        }else{
            energia2.setValue(nuevo);
        }
    }
    private void actualicePoder(int jugador){

    }
    private void actualiceVida(int jugador){

    }
    private void actualicePuntaje(int jugador){
        int nuevo= edificio.puntajeHeroe(jugador);
        if (jugador==1){
            puntaje1.setText(Integer.toString(nuevo));
        }else{
            puntaje2.setText(Integer.toString(nuevo));
        }
    }

















    public class PanelJuego extends JPanel{
        private Image imagen;
        public PanelJuego(){
        }
        public void setImagen(String nombreImagen) {
            if (nombreImagen != null) {
                imagen = new ImageIcon(nombreImagen).getImage();
             } else {
                imagen = null;
            }

            repaint();
        }
        @Override
        public void paint(Graphics g) {
            if (imagen != null) {
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
                setOpaque(false);
            } else {
                setOpaque(true);
            }
            super.paint(g);
        }
    }

}
