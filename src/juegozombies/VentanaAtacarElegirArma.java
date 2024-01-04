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
public class VentanaAtacarElegirArma extends javax.swing.JFrame {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel panelBoton = new JPanel();
        Superviviente jugador = Juego.obtenerJugadorActual();
        JComboBox<String>armas;
        EArmas opciones[];
        JButton aceptar;
    /**
     * Creates new form VentanaAtacarElegirArma
     */
    public VentanaAtacarElegirArma() {
        if(jugador.getArmasActivas().size() == 0){
            JOptionPane.showMessageDialog(null, "El superviviente no tiene armas", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE); 
            frame.dispose();
        }else{
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
        frame.setLocation(600,600);
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
    }
 
    private void aceptarMouseClicked(java.awt.event.MouseEvent evt){
        String nombreArma = armas.getSelectedItem().toString();        
        for(int i = 0; i < jugador.getArmasActivas().size(); i++){
            if(nombreArma.equals(jugador.getArmasActivas().get(i).getNombre())){
                VentanaAtacarObjetivo ventana = new VentanaAtacarObjetivo(jugador.getArmasActivas().get(i));
                frame.dispose();
                break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
