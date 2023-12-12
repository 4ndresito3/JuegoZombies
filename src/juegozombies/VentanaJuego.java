/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vaant
 */
public class VentanaJuego extends javax.swing.JFrame {

    JFrame frame = new JFrame();
    JPanel seguimiento = new JPanel();
    JLabel textoSeg = new JLabel("texto aqui");
    JLabel textoSeg2 = new JLabel("texto aqui 2");
    JLabel textoSeg3 = new JLabel("texto aqui 3");
    JPanel tablero = new JPanel(new GridLayout(Juego.getTamanoCuadricula().getX(), Juego.getTamanoCuadricula().getY()));
    JPanel acciones = new JPanel(new GridLayout(1, 3));
    JButton celda[][] = new JButton[Juego.getTamanoCuadricula().getX()] [Juego.getTamanoCuadricula().getY() ];
    /**
     * Creates new form JFrame
     */
        public static void turnoJugador(Superviviente jugador){
        
    }
     private void jugar(){
        boolean todosMuertos = false;
        boolean todosObjetivo = false;
        int cont = 0;
        while(!todosMuertos && !todosObjetivo){
             for(int i = 0; i < Juego.getSupervivientes().size(); i++){
                  while(Juego.getSupervivientes().get(i).getNumAcciones() > 0){
                        turnoJugador(Juego.getSupervivientes().get(i));
                  }
             }
            
            
            
            for(int i = 0; i < Juego.getSupervivientes().size(); i++){
                if(Juego.getSupervivientes().get(i).devolverCoordenada().equals(Juego.getObjetivo())){
                    cont ++;
                }
            }
            todosMuertos = Juego.getSupervivientes().isEmpty();
            todosObjetivo = cont == Juego.getSupervivientes().size();
        }
    }
    public VentanaJuego() {
        frame.setTitle("VentanaJuego");
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        for (int i=0; i<Juego.getTamanoCuadricula().getX()  ; i++){
            for(int j=0; j< Juego.getTamanoCuadricula().getY(); j++){
                celda[i][j] = new JButton("");
                for(int l = 0; l< Juego.getSupervivientes().size(); l++){
                    if(Juego.getSupervivientes().get(l).devolverCoordenada().getX() == i && Juego.getSupervivientes().get(l).devolverCoordenada().getY() == j ){                       
                           String texto = celda[i][j].getText();
                           String newTexto=  texto + Juego.getSupervivientes().get(l).getNombre() + ", ";
                           celda[i][j].setText(newTexto);
                    }
                }
                for(int k = 0; k< Juego.getZombis().size(); k++){                            
                    if(Juego.getZombis().get(k).devolverCoordenada().getX() == i && Juego.getZombis().get(k).devolverCoordenada().getY() == j){
                        celda[i][j].setText("Zombi");
                    }               
                }               
                tablero.add(celda[i][j]);
            }
        }
        JButton atacar = new JButton("ATACAR");
        JButton mover = new JButton("MOVER");
        JButton buscar = new JButton("BUSCAR");
        acciones.add(atacar);
        acciones.add(mover);
        acciones.add(buscar);
        seguimiento.setLayout(new BoxLayout(seguimiento, BoxLayout.Y_AXIS));
        textoSeg.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoSeg2.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoSeg3.setAlignmentX(Component.CENTER_ALIGNMENT);
        Font font = new Font("Serif", Font.ITALIC, 20); // Tipo de fuente, estilo y tamaño
        textoSeg.setFont(font);
        textoSeg2.setFont(font);
        textoSeg3.setFont(font);
        seguimiento.add(textoSeg);
        seguimiento.add(textoSeg2);
        seguimiento.add(textoSeg3);
        frame.add(tablero, BorderLayout.CENTER);
        frame.add(acciones, BorderLayout.SOUTH);       
        frame.add(seguimiento, BorderLayout.EAST);
        seguimiento.setPreferredSize(new Dimension(300, 0));
        atacar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atacarActionPerformed(evt);
            }
        });
         mover.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverActionPerformed(evt);
            }
        });
        frame.setVisible(true);
        jugar();
        }
        
         private void atacarActionPerformed(java.awt.event.ActionEvent evt){
                  Superviviente jugador = Juego.obtenerJugadorActual();
                  jugador.atacar();
                  if(jugador.getNumAcciones() == 0 && (Juego.getTurnoJugador() == Juego.getSupervivientes().size()-1 )){
                      turnoZombies();
                      Juego.pasarTurno();     
                  }else if(jugador.getNumAcciones() == 0 && (Juego.getTurnoJugador() != Juego.getSupervivientes().size()-1 )){
                      Juego.pasarTurno();
                  }else if(jugador.getNumAcciones() > 0){
                      
                  }
                  /*textoSeg.setText("" + Juego.getObjetivo().getX() + Juego.getObjetivo().getY());
                  textoSeg2.setText("" + Juego.getSupervivientes().get(0).devolverCoordenada().getX() + Juego.getSupervivientes().get(0).devolverCoordenada().getY());
                  textoSeg3.setText("" + Juego.getSupervivientes().get(1).devolverCoordenada().getX() + Juego.getSupervivientes().get(1).devolverCoordenada().getY());*/
         }
         private void moverActionPerformed(java.awt.event.ActionEvent evt){
                  celda[2][2].setText("adadad");
                  textoSeg.setText("" + Juego.getZombis().get(0).devolverCoordenada().getX() + Juego.getZombis().get(0).devolverCoordenada().getY());
                  textoSeg2.setText("" + Juego.getZombis().get(1).devolverCoordenada().getX() + Juego.getZombis().get(1).devolverCoordenada().getY());
                  textoSeg3.setText("" + Juego.getZombis().get(2).devolverCoordenada().getX() + Juego.getZombis().get(2).devolverCoordenada().getY());
         }
}