package presentacion;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;
import java.lang.*;
public class ModoDeJuego extends JDialog{
    private JPanel botones;
    private JButton unoVsUno;
    private JButton unoVsMaquina;
    private JButton volver;
    private JPanel panelVolver;
    private JFrame principal;
    public ModoDeJuego(JFrame owner){
        super(owner);
        principal=owner;
        prepareElementos();
        prepareAcciones();
    }
    public void prepareElementos(){
        setTitle("MODO DE JUEGO");
		setSize(1366,710);
        setResizable(false);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        botones=new JPanel();
		botones.setLayout(new  GridLayout(4,1,20,20 ));
        botones.setBackground(Color.BLACK);
        botones.setBorder(BorderFactory.createEmptyBorder(200,100,-130,-100));
        elementosPanelBotones();
        panelVolver=new JPanel();
        panelVolver.setBackground(Color.BLACK);
        panelVolver.setBorder(BorderFactory.createEmptyBorder(600,100,0,30));
        elementosPanelVolver();
        add(botones,BorderLayout.CENTER);
        add(panelVolver,BorderLayout.EAST);
    }
    public void prepareAcciones(){
        addWindowListener (
			     new WindowAdapter(){
				         public void windowClosing(WindowEvent e){
					              cerrarVentana();
				          }
			    }
		    );
        volver.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                cerrar();
                }
            }
        );
        unoVsUno.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegirJugador(1);
                }
            }
        );
        unoVsMaquina.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegirJugador(2);
                }
            }
        );
    }
    public void cerrarVentana(){
                setVisible(false);
			if(JOptionPane.showConfirmDialog(null, "Estas seguro?")== JOptionPane.OK_OPTION){
                principal.setVisible(true);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			}else{
				setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			}
	}
    public void cerrar(){
            setVisible(false);
            principal.setVisible(true);
            dispose();
    }
    public void elegirJugador(int modo){
        ElegirJugador elegir=new ElegirJugador(principal,modo);
        setVisible(false);
        elegir.setVisible(true);
    }
    public void elementosPanelBotones(){
        unoVsUno=new JButton();
        unoVsUno.setBorderPainted(false);
        unoVsMaquina=new JButton();
        unoVsMaquina.setBorderPainted(false);
        unoVsUno.setBackground(Color.BLACK);
        unoVsMaquina.setBackground(Color.BLACK);
        ImageIcon icono=new ImageIcon("imagenes/1vsM.png");
        unoVsMaquina.setIcon(icono);
        icono=new ImageIcon("imagenes/1vs1.png");
        unoVsUno.setIcon(icono);
        botones.add(unoVsUno);
        botones.add(unoVsMaquina);
        }
    public void elementosPanelVolver(){
        volver=new JButton();
        ImageIcon icono=new  ImageIcon("imagenes/volver.png");
        volver.setBorderPainted(false);
        volver.setBackground(Color.BLACK);
        volver.setIcon(icono);
        panelVolver.add(volver);
    }

}
