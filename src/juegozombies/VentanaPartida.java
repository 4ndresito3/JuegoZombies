/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package juegozombies;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author andre
 */
public class VentanaPartida extends javax.swing.JFrame {

    int [] listaNumeros = {1,2,3,4};
    /**
     * Creates new form ventanaPartida
     */
    public VentanaPartida() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloNP = new javax.swing.JPanel();
        nuevaPartida = new javax.swing.JLabel();
        cuerpoNP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        seleccionarNumero = new javax.swing.JButton();
        hueco1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hueco2 = new javax.swing.JTextField();
        hueco3 = new javax.swing.JTextField();
        hueco4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nuevaPartida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nuevaPartida.setText("Nueva Partida");

        javax.swing.GroupLayout tituloNPLayout = new javax.swing.GroupLayout(tituloNP);
        tituloNP.setLayout(tituloNPLayout);
        tituloNPLayout.setHorizontalGroup(
            tituloNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloNPLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(nuevaPartida, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(279, 279, 279))
        );
        tituloNPLayout.setVerticalGroup(
            tituloNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloNPLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(nuevaPartida, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre Superviviente 1");

        seleccionarNumero.setText("Seleccionar numero supervivientes");
        seleccionarNumero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarNumeroMouseClicked(evt);
            }
        });
        seleccionarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarNumeroActionPerformed(evt);
            }
        });

        hueco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hueco1ActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre Superviviente 2");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre Superviviente 3");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nombre Superviviente 4");

        hueco2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hueco2ActionPerformed(evt);
            }
        });

        hueco3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hueco3ActionPerformed(evt);
            }
        });

        hueco4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hueco4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cuerpoNPLayout = new javax.swing.GroupLayout(cuerpoNP);
        cuerpoNP.setLayout(cuerpoNPLayout);
        cuerpoNPLayout.setHorizontalGroup(
            cuerpoNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuerpoNPLayout.createSequentialGroup()
                .addGroup(cuerpoNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cuerpoNPLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(cuerpoNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(cuerpoNPLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(hueco4))
                            .addGroup(cuerpoNPLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(hueco1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cuerpoNPLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(hueco2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cuerpoNPLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(hueco3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(cuerpoNPLayout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(seleccionarNumero)))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        cuerpoNPLayout.setVerticalGroup(
            cuerpoNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuerpoNPLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(cuerpoNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hueco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cuerpoNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hueco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(cuerpoNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hueco3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cuerpoNPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hueco4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(seleccionarNumero)
                .addContainerGap(392, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloNP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cuerpoNP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tituloNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cuerpoNP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    private void seleccionarNumeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarNumeroMouseClicked
        String nombre1 = hueco1.getText();
        String nombre2 = hueco2.getText();
        String nombre3= hueco3.getText();
        String nombre4 = hueco4.getText();
        String[] nombres = {nombre1,nombre2,nombre3,nombre4};
        int cont = 0;
        for(int i = 0; i < 4 ; i++){
            if(nombres[i].equals("")){
                cont ++;
            }
        }
        if (cont == 4){
            JOptionPane.showMessageDialog(null, "Che pa, te faltá al menos un usuario", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE);
        } else{
            Juego partida = new Juego();
            partida.generarSupervivientes(nombres);
            partida.generarZombies(false);
            this.setVisible(false);
            ventanaJuego = new VentanaJuego();
            
        } 
  
    }//GEN-LAST:event_seleccionarNumeroMouseClicked

    private void seleccionarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionarNumeroActionPerformed

    private void hueco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hueco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hueco1ActionPerformed

    private void hueco2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hueco2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hueco2ActionPerformed

    private void hueco3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hueco3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hueco3ActionPerformed

    private void hueco4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hueco4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hueco4ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cuerpoNP;
    private javax.swing.JTextField hueco1;
    private javax.swing.JTextField hueco2;
    private javax.swing.JTextField hueco3;
    private javax.swing.JTextField hueco4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel nuevaPartida;
    private javax.swing.JButton seleccionarNumero;
    private javax.swing.JPanel tituloNP;
    // End of variables declaration//GEN-END:variables
    private VentanaJuego ventanaJuego;
}
