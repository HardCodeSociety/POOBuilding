package presentacion;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.border.*;
public class ElegirJugador extends JDialog{
    JPanel panelImagenes;
    JPanel panelNombres;
    JPanel panelMaquina;
    JPanel panelOpciones;
    JPanel panelJugar;
    int tipoDeJuego;
    //Elementos panelImagenes
    JButton jugador1;
    JButton jugador2;
    //Elementos panelNombres
    JLabel indicador1;
    JLabel indicador2;
    JTextField cambiarJugador1;
    JTextField cambiarJugador2;
    String nombreJugador1;
    String nombreJugador2;
    //Elementos panelMaquina
    JRadioButton candy;
    JRadioButton calhoun;
    JRadioButton candy2;
    JRadioButton calhoun2;
    ButtonGroup maquinas;
    ButtonGroup maquinas2;
    JColorChooser cambiarColor;
    Color color1=Color.RED;
    Color color2=Color.BLUE;
    //Elementos panelOpciones
    JButton jugar;
    JButton volver;
    public ElegirJugador(int tipoDeJuego){
        this.tipoDeJuego=tipoDeJuego;
        prepareElementos();
        prepareAcciones();
    }

    public void prepareElementos(){
        setTitle("CONFIGURACION DE JUGADORES");
		setSize(1366,710);
        setResizable(false);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        panelImagenes=new JPanel();
        panelImagenes.setSize(200,400); 
        panelImagenes.setLayout(new GridLayout(1,3,200,7));
        panelImagenes.setBackground(Color.BLACK);
        panelImagenes.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(100,200,50,200),(new TitledBorder("Colores"))));
        panelImagenes.setForeground(Color.RED);
        elementosPanelImagenes();
        panelNombres=new JPanel();
        panelNombres.setBackground(Color.BLACK);
        panelNombres.setLayout(new GridLayout(1,4,40,7));
        panelNombres.setBorder(BorderFactory.createEmptyBorder(70,30,0,30));
        elementosPanelNombres();
        panelOpciones=new JPanel();
        panelOpciones.setLayout(new GridLayout(1,2,20,7));
        panelOpciones.setBackground(Color.BLACK);
        elementosPanelOpciones();
        add(panelNombres,BorderLayout.NORTH);
        add(panelImagenes,BorderLayout.CENTER);
        add(panelOpciones,BorderLayout.SOUTH);
    }
    public void elementosPanelNombres(){
        indicador1=new JLabel("Nombre Jugador 1");
        indicador2=new JLabel("Nombre Jugador 2");
        indicador1.setForeground(Color.WHITE);
        indicador2.setForeground(Color.WHITE);
        indicador1.setBackground(Color.BLACK);
        indicador2.setBackground(Color.BLACK);
        cambiarJugador1=new JTextField(20);
        cambiarJugador2=new JTextField(20);
        panelNombres.add(indicador1);
        panelNombres.add(cambiarJugador1);
        panelNombres.add(indicador2);
        panelNombres.add(cambiarJugador2);
    }
    public void elementosPanelMaquina(){
        panelMaquina=new JPanel();
        panelMaquina.setBorder(BorderFactory.createEmptyBorder(0,300,300,0));
        panelMaquina.setLayout(new GridLayout(2,1,10,6));
        panelMaquina.setBackground(Color.BLACK);
        maquinas=new ButtonGroup();
        candy=new JRadioButton("CANDY");
        candy.setBackground(Color.BLACK);
        candy.setForeground(Color.WHITE);
        calhoun=new JRadioButton("CALHOUN"); 
        calhoun.setBackground(Color.BLACK);
        calhoun.setForeground(Color.WHITE);       
        maquinas.add(candy);
        maquinas.add(calhoun);
        if(tipoDeJuego==2){
            panelMaquina.add(candy);
            panelMaquina.add(calhoun);
        }
    }
    public void elementosPanelImagenes(){
        ImageIcon icono=new ImageIcon("imagenes/felix.png");
        maquinas=new ButtonGroup();
        jugador1=new JButton();
        jugador1.setIcon(icono);
        jugador1.setBackground(color1);
        jugador1.setBorderPainted(false);
        jugador2=new JButton();
        jugador2.setIcon(icono);
        jugador2.setBackground(color2);
        jugador2.setBorderPainted(false);
        panelImagenes.add(jugador1);
        panelImagenes.add(jugador2);
    }
    public void elementosPanelJugar(){
        panelJugar=new JPanel();
        panelJugar.setLayout(new GridLayout(1,2,20,7));
        panelJugar.setBackground(Color.BLACK);
        jugar=new JButton();
        volver=new JButton();
        ImageIcon icono=new  ImageIcon("imagenes/volver.png");
        volver.setBorderPainted(false);
        volver.setBackground(Color.BLACK);
        volver.setIcon(icono);
        volver.setBorder(BorderFactory.createEmptyBorder(200,200,0,0));
        icono=new ImageIcon("imagenes/jugar.png");
        jugar.setBorderPainted(false);
        jugar.setBackground(Color.BLACK);
        jugar.setIcon(icono);
        jugar.setBorder(BorderFactory.createEmptyBorder(200,0,20,0));
        panelJugar.add(volver);
        panelJugar.add(jugar);
    }
    public void elementosPanelOpciones(){
        elementosPanelMaquina();
        elementosPanelJugar();
        panelOpciones.add(panelMaquina);
        panelOpciones.add(panelJugar);
    }

    public void prepareAcciones(){
        addWindowListener (
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					cerrarVentana();
				}
			}
		);

        jugador1.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegirColor(1);
                }
            }
        );
        jugador2.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegirColor(2);
                }
            }
        );
        
    }
    public void cerrarVentana(){
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
    public void elegirColor(int jugador){
        cambiarColor=new JColorChooser();
        Color color=cambiarColor.showDialog(null,"Seleccione un color",Color.GRAY);
        if(color!=null){
                if(jugador==1){
                    if ((!color.equals(color2))){
                        jugador1.setBackground(color);
                        color1=color;
                    }else{
                      JOptionPane.showMessageDialog(null, "El jugador 2 ya esta usando ese color");
                    }
                }else if(jugador==2){
                    if((!color.equals(color1))){
                        jugador2.setBackground(color);
                        color2=color;
                    }else{
                      JOptionPane.showMessageDialog(null, "El jugador 1 ya esta usando ese color");
                    }
                }
        }
    }
}
