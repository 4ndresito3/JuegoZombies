/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author josem
 */
public class VentanaEquiparArma extends javax.swing.JFrame {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel panelBoton = new JPanel();
        Superviviente jugador = Juego.obtenerJugadorActual();
        JComboBox<String>armas;
        Equipo opciones[];
        JButton aceptar;
 
    public VentanaEquiparArma() {
        int cont=0; //para inicializar el array
        int tope=0;
        for(int i=0; i<jugador.getInventario().size(); i++){
            if(jugador.getInventario().get(i) instanceof EArmas){
                cont+=1;
            }
        }
        opciones = new EArmas[cont]; 
        for(int i=0; i<jugador.getInventario().size(); i++){
            if(jugador.getInventario().get(i) instanceof EArmas){
                opciones[tope] = jugador.getInventario().get(i);
                tope+=1;
            }
        }    
        armas = new JComboBox<>();
        for(int i = 0; i < opciones.length ; i++){
            armas.addItem(opciones[i].getNombre());
        }
        frame.setTitle("Elige el arma");
        frame.setSize(400, 200);
        frame.setResizable(false);
        frame.setLocation(600,50);
        aceptar  = new JButton("Aceptar");
        panelBoton.add(aceptar);
        frame.add(panelBoton, BorderLayout.SOUTH);
        panel.add(armas);
        frame.add(panel, BorderLayout.CENTER);
        aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptarMouseClicked(evt);
            }
        });
        frame.setVisible(true);
        }
    
 
    private void aceptarMouseClicked(java.awt.event.MouseEvent evt){
        String nombreArma = armas.getSelectedItem().toString();        
        for(int i = 0; i < jugador.getInventario().size(); i++){
            if(nombreArma.equals(jugador.getInventario().get(i).getNombre())){
                VentanaEquiparCambiar ventanaEquiparCambiar = new VentanaEquiparCambiar(jugador.getInventario().get(i));
                frame.dispose();
                break;
            }
        }
    }
}
