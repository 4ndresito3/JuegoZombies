/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
public class VentanaEquiparCambiar extends javax.swing.JFrame {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel panelBoton = new JPanel();
        Superviviente jugador = Juego.obtenerJugadorActual();
        JComboBox<String>armas;
        EArmas opciones[];
        JButton aceptar;
        Equipo arma;
    /**
     * Creates new form VentanaAtacarElegirArma
     */
    public VentanaEquiparCambiar(Equipo arma) {
        this.arma=arma;
        opciones = new EArmas[jugador.getArmasActivas().size()];
        for(int i=0; i<jugador.getArmasActivas().size(); i++){
        opciones[i] = jugador.getArmasActivas().get(i);
        }
        armas = new JComboBox<>();
        for(int i = 0; i < opciones.length ; i++){
            armas.addItem(opciones[i].getNombre());
        }
        frame.setTitle("Elige el arma");
        frame.setSize(400, 200);
        frame.setResizable(false);
        frame.setLocation(300,300);
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
        for(int i = 0; i < jugador.getArmasActivas().size(); i++){
            if(nombreArma.equals(jugador.getArmasActivas().get(i).getNombre())){ 
                jugador.getInventario().add(jugador.getArmasActivas().get(i)); //añade al inventario el arma activa
                for(int j=0; j<jugador.getInventario().size(); j++){ //borra del inventario el arma del inventario
                    if(jugador.getInventario().get(i).getNombre().equals(arma.getNombre())){
                        jugador.getInventario().remove(i);  
                    }
                }             
                jugador.getArmasActivas().remove(i); //borra de las armas activas el arma activa
                jugador.getArmasActivas().add((EArmas)arma); //añade a armas activas el arma del inventario
                
                if (jugador.getNumAcciones()==3){
                    VentanaJuego.textoSeg.setText("");
                }
                Juego.obtenerJugadorActual().setNumAcciones(Juego.obtenerJugadorActual().getNumAcciones()-1);
                VentanaJuego.textoSeg.append("Se han cambiado las armas\n");               
                if(Juego.obtenerJugadorActual().getNumAcciones()==0){
                    VentanaJuego.pasarTurnoJugador();
                }
                frame.dispose();
            }
        }
    }
}