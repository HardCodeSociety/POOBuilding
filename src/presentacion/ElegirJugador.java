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
    int tipoDeJuego;
    //Elementos panelImagenes
    JButton jugador1;
    JButton jugador2;
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
        panelImagenes.setSize(200,200); 
        panelImagenes.setLayout(new GridLayout(1,3,200,7));
        panelImagenes.setBackground(Color.BLACK);
        panelImagenes.setBorder(BorderFactory.createEmptyBorder(0,200,200,300));
        elementosPanelImagenes();
        panelNombres=new JPanel();
        panelNombres.setLayout(new GridLayout(3,2,200,7));
        add(panelImagenes,BorderLayout.CENTER);
    }
    public void elementosPanelImagenes(){
        ImageIcon icono=new ImageIcon("imagenes/felix.png");
        maquinas=new ButtonGroup();
        jugador1=new JButton();
        jugador1.setIcon(icono);
        jugador1.setBackground(color1);
        jugador1.setSize(236,236);
        jugador1.setBorderPainted(false);
        candy=new JRadioButton("CANDY");
        calhoun=new JRadioButton("CALHOUN");
        candy.setMnemonic(KeyEvent.VK_A);
        calhoun.setMnemonic(KeyEvent.VK_B);
        calhoun.setBackground(color2);
        jugador2=new JButton();
        jugador2.setIcon(icono);
        jugador2.setBackground(Color.BLUE);
        candy2=new JRadioButton();
        calhoun2=new JRadioButton();
        if(tipoDeJuego==1|tipoDeJuego==2){
            panelImagenes.add(jugador1);
        }if(tipoDeJuego==2|tipoDeJuego==3){
            panelImagenes.add(candy);
            panelImagenes.add(calhoun);
        } if (tipoDeJuego==1){
            panelImagenes.add(jugador2);
        } if (tipoDeJuego==3){
            panelImagenes.add(candy2);
            panelImagenes.add(calhoun2);
        }
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
                    elegirColor();
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
    public void elegirColor(){
        cambiarColor=new JColorChooser();
        color1=cambiarColor.showDialog(null,"Seleccione un color",Color.GRAY);
        if ((color1 != null)&&(!color1.equals(color2))){
            jugador1.setBackground(color1);;
        }
    }
}