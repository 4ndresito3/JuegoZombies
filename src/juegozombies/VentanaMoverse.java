/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package juegozombies;

import javax.swing.JOptionPane;

/**
 *
 * @author josem
 */
public class VentanaMoverse extends javax.swing.JFrame {

    /**
     * Creates new form VentanaMoverse
     */
    public VentanaMoverse() {
        initComponents();
        setVisible(true);
        this.setLocation(600, 600);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arriba = new javax.swing.JButton();
        abajo = new javax.swing.JButton();
        derecha = new javax.swing.JButton();
        izquierda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        arriba.setText("ARRIBA");
        arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arribaActionPerformed(evt);
            }
        });

        abajo.setText("ABAJO");
        abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abajoActionPerformed(evt);
            }
        });

        derecha.setText("DERECHA");
        derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derechaActionPerformed(evt);
            }
        });

        izquierda.setText("IZQUIERDA");
        izquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izquierdaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(izquierda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(arriba, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(abajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(derecha, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(arriba, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(abajo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(derecha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(izquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void arribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arribaActionPerformed
        // TODO add your handling code here:
        Superviviente jugador = Juego.obtenerJugadorActual();
        if(jugador.puedeMoverse() == 0){
            if(jugador.devolverCoordenada().getX()-1 >= 0){
                  jugador.moverse(3);
                  setVisible(false);
            }else{
                 JOptionPane.showMessageDialog(null, "El superviviente no se puede mover en esta dirección", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE);
            }

        }else if(jugador.puedeMoverse() == 1){
            JOptionPane.showMessageDialog(null, "El superviviente no se puede mover porque está rodeado", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE); 
        }
        
    }//GEN-LAST:event_arribaActionPerformed

    private void derechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derechaActionPerformed
        // TODO add your handling code here:
        Superviviente jugador = Juego.obtenerJugadorActual();
        if(jugador.puedeMoverse() == 0){
            if(jugador.devolverCoordenada().getY()+1 <= Juego.getTamanoCuadricula().getY() - 1){
                  jugador.moverse(1);
                  setVisible(false);
            }else{
                 JOptionPane.showMessageDialog(null, "El superviviente no se puede mover en esta dirección", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE);
            }

        }else if(jugador.puedeMoverse() == 1){
            JOptionPane.showMessageDialog(null, "El superviviente no se puede mover porque está rodeado", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_derechaActionPerformed

    private void abajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abajoActionPerformed
        // TODO add your handling code here:
        Superviviente jugador = Juego.obtenerJugadorActual();
         if(jugador.puedeMoverse() == 0){
            if(jugador.devolverCoordenada().getX()+1 <= Juego.getTamanoCuadricula().getX() - 1){
                  jugador.moverse(4);
                  setVisible(false);
            }else{
                 JOptionPane.showMessageDialog(null, "El superviviente no se puede mover en esta dirección", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE);
            }

        }else if(jugador.puedeMoverse() == 1){
            JOptionPane.showMessageDialog(null, "El superviviente no se puede mover porque está rodeado", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_abajoActionPerformed

    private void izquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izquierdaActionPerformed
        // TODO add your handling code here:
        Superviviente jugador = Juego.obtenerJugadorActual();
         if(jugador.puedeMoverse() == 0){
            if(jugador.devolverCoordenada().getY()-1 >= 0){
                  jugador.moverse(2);
                  setVisible(false);
            }else{
                 JOptionPane.showMessageDialog(null, "El superviviente no se puede mover en esta dirección", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE);
            }

        }else if(jugador.puedeMoverse() == 1){
            JOptionPane.showMessageDialog(null, "El superviviente no se puede mover porque está rodeado", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_izquierdaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abajo;
    private javax.swing.JButton arriba;
    private javax.swing.JButton derecha;
    private javax.swing.JButton izquierda;
    // End of variables declaration//GEN-END:variables
    
}
