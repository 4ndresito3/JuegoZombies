/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author vaant
 */
public class VentanaJuego extends javax.swing.JFrame {

    JFrame frame = new JFrame();
    JPanel tablero = new JPanel(new GridLayout(Juego.getTamanoCuadricula().getX(), Juego.getTamanoCuadricula().getY()));
    JPanel acciones = new JPanel(new GridLayout(1, 3));
    JButton celda[][] = new JButton[Juego.getTamanoCuadricula().getX()] [Juego.getTamanoCuadricula().getY() ];
    /**
     * Creates new form JFrame
     */
    public VentanaJuego() {
        frame.setTitle("HOLA");
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        for (int i=0; i<Juego.getTamanoCuadricula().getX()  ; i++){
            for(int j = 0; j< Juego.getTamanoCuadricula().getX(); j++){
                celda[i][j] = new JButton(String.valueOf(i+1));
                tablero.add(celda[i][j]);
            }

        }
        JButton atacar = new JButton("ATACAR");
        JButton mover = new JButton("MOVER");
        JButton buscar = new JButton("BUSCAR");
        acciones.add(atacar);
        acciones.add(mover);
        acciones.add(buscar);       
        frame.add(tablero, BorderLayout.CENTER);
        frame.add(acciones, BorderLayout.SOUTH);
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