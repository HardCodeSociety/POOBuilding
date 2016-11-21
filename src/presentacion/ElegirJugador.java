package presentacion;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;
import java.lang.*;
public class ElegirJugador extends JDialog{
    JPanel panelImagenes;
    JPanel panelNombres;
    JPanel panelMaquina;
    JPanel panelOpciones;
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
    JColorChooser cambiarColor;
    Color color1=Color.RED;
    Color color2=Color.BLUE;
    public ElegirJugador(int tipoDeJuego){
        this.tipoDeJuego=tipoDeJuego;
        prepareElementos();
        prepareAcciones();
    }

    public void prepareElementos(){
        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(4*screen.width/6,4*screen.height/6);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        panelImagenes=new JPanel();
        panelImagenes.setSize(200,400); 
        panelImagenes.setLayout(new GridLayout(1,3,200,7));
        panelImagenes.setBackground(Color.BLACK);
        panelImagenes.setBorder(BorderFactory.createEmptyBorder(20,200,0,200));
        elementosPanelImagenes();
        panelNombres=new JPanel();
        panelNombres.setBackground(Color.BLACK);
        panelNombres.setLayout(new GridLayout(1,4,300,7));
        panelNombres.setBorder(BorderFactory.createEmptyBorder(0,0,400,200));
        elementosPanelNombres();
        panelMaquina=new JPanel();
        panelMaquina.setLayout(new GridLayout(1,4,300,7));
        panelMaquina.setBackground(Color.BLACK);
        //elementosPanelMaquina();
        add(panelImagenes,BorderLayout.NORTH);
        add(panelNombres,BorderLayout.CENTER);
        add(panelMaquina,BorderLayout.CENTER);
    }
    public void elementosPanelNombres(){
        indicador1=new JLabel("Jugador 1");
        indicador2=new JLabel("Jugador 2");
        indicador1.setForeground(Color.WHITE);
        indicador2.setForeground(Color.WHITE);
        indicador1.setBackground(Color.BLACK);
        indicador2.setBackground(Color.BLACK);
        indicador2.setBorder(BorderFactory.createEmptyBorder(0,0,200,0));
        cambiarJugador1=new JTextField(20);
        cambiarJugador2=new JTextField(20);
        panelNombres.add(indicador1);
        panelNombres.add(cambiarJugador1);
        panelNombres.add(indicador2);
        panelNombres.add(cambiarJugador2);
    }
    public void elementosPanelMaquina(){
        candy=new JRadioButton("CANDY");
        calhoun=new JRadioButton("CALHOUN");
        candy.setMnemonic(KeyEvent.VK_A);
        calhoun.setMnemonic(KeyEvent.VK_B);
        calhoun.setBackground(color2);
        candy2=new JRadioButton();
        calhoun2=new JRadioButton();

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
			if(JOptionPane.showConfirmDialog(null, "Estas seguro?")== JOptionPane.OK_OPTION){
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			}else{
				setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			}
	}
    public void elegirColor(int jugador){
        cambiarColor=new JColorChooser();
        Color color=cambiarColor.showDialog(null,"Seleccione un color",Color.GRAY);
        if(color!=null){
                if(jugador==1){
                    if ((!color.equals(color2))){
                        jugador1.setBackground(color);
                    }
                }else if(jugador==2){
                    if((!color.equals(color1))){
                        jugador2.setBackground(color);
                    }
                }
        }   
    }
}