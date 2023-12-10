/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
    JPanel tablero = new JPanel(new GridLayout(Juego.getTamanoCuadricula().getX(), Juego.getTamanoCuadricula().getY()));
    JPanel acciones = new JPanel(new GridLayout(1, 3));
    JButton celda[][] = new JButton[Juego.getTamanoCuadricula().getX()] [Juego.getTamanoCuadricula().getY() ];
    /**
     * Creates new form JFrame
     */
    public VentanaJuego() {
        frame.setTitle("HOLA");
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        for (int i=0; i<Juego.getTamanoCuadricula().getX()  ; i++){
            for(int j = 0; j< Juego.getTamanoCuadricula().getY(); j++){
                celda[i][j] = new JButton((String.valueOf(i*Juego.getTamanoCuadricula().getY()+j)));
                if(Juego.getSupervivientes().get(0).devolverCoordenada().getX() == i && Juego.getSupervivientes().get(0).devolverCoordenada().getY() == i ){
                    for(int l = 0; l< Juego.getSupervivientes().size(); l++){
                        celda[i][j].setText(Juego.getSupervivientes().get(l).getNombre() + " , ");
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
        JLabel texto = new JLabel("texto aqui");
        seguimiento.add(texto);
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
        }
         private void atacarActionPerformed(java.awt.event.ActionEvent evt){
                  celda[2][2].setText("adadad");
         }
         private void moverActionPerformed(java.awt.event.ActionEvent evt){
                  celda[2][2].setText("adadad");
         }
}