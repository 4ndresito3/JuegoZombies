/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author vaant
 */
public class VentanaJuego extends javax.swing.JFrame {

    JFrame frame = new JFrame();
    JPanel seguimiento = new JPanel();
    JPanel posiciones = new JPanel();
    JTextArea textoPosiciones = new JTextArea();
    JTextArea textoSeg = new JTextArea("TEXTO AQUI");
    JPanel tablero = new JPanel(new GridLayout(Juego.getTamanoCuadricula().getX(), Juego.getTamanoCuadricula().getY()));
    JPanel acciones = new JPanel(new GridLayout(2, 3));
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
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        //tablero
        for (int i=0; i<Juego.getTamanoCuadricula().getX()  ; i++){
            for(int j=0; j< Juego.getTamanoCuadricula().getY(); j++){
                celda[i][j] = new JButton("");
                for(int l = 0; l< Juego.getSupervivientes().size(); l++){
                    if(Juego.getSupervivientes().get(l).devolverCoordenada().getX() == i && Juego.getSupervivientes().get(l).devolverCoordenada().getY() == j ){                       
                           String texto = celda[i][j].getText();
                           String newTexto=Juego.getSupervivientes().get(l).getNombre();                          
                           StringBuilder textoBoton = new StringBuilder("<html>"+texto);
                           textoBoton.append("<br>" + newTexto);
                           celda[i][j].setText(textoBoton.toString());
                    }
                }
                for(int k = 0; k< Juego.getZombis().size(); k++){                            
                    if(Juego.getZombis().get(k).devolverCoordenada().getX() == i && Juego.getZombis().get(k).devolverCoordenada().getY() == j){
                        String texto2 = celda[i][j].getText();
                           String newTexto2=Juego.getZombis().get(k).obtenerTipo2();                          
                           StringBuilder textoBoton2 = new StringBuilder("<html>"+texto2);
                           textoBoton2.append("<br>" + newTexto2);
                           celda[i][j].setText(textoBoton2.toString());                    
                    }               
                }               
                tablero.add(celda[i][j]);
            }
        }
        
        //acciones
        JButton atacar = new JButton("ATACAR");
        JButton mover = new JButton("MOVER");
        JButton buscar = new JButton("BUSCAR");
        JButton noHacerNada = new JButton("NO HACER NADA");
        JButton inventario = new JButton("MOSTRAR INVENTARIO");
        JButton equipar = new JButton("EQUIPAR");
        acciones.add(atacar);
        acciones.add(mover);
        acciones.add(buscar);   
        acciones.add(noHacerNada);
        acciones.add(inventario);
        acciones.add(equipar);
        acciones.setPreferredSize(new Dimension(0, 50));  
        
        //mostrar seguimiento
        seguimiento.add(textoSeg);
        
        //mostrar posiciones
        textoPosiciones.append("SUPERVIVIENTES\n");
        for(int i = 0; i<Juego.getSupervivientes().size(); i++){           
            textoPosiciones.append("" + Juego.getSupervivientes().get(i).getNombre() + ": " 
                    + Juego.getSupervivientes().get(i).devolverCoordenada().getX() + ", " + Juego.getSupervivientes().get(i).devolverCoordenada().getY() + "\n");
        }
        textoPosiciones.append("\n");
        textoPosiciones.append("ZOMBIES\n");
        for(int i = 0; i<Juego.getZombis().size(); i++){
            textoPosiciones.append("" + Juego.getZombis().get(i).obtenerTipo() + ": " 
                    + Juego.getZombis().get(i).devolverCoordenada().getX() + ", " + Juego.getZombis().get(i).devolverCoordenada().getY() + "\n");         
        }
        posiciones.add(textoPosiciones);
        
        Font font = new Font("Serif", Font.ITALIC, 18); // Tipo de fuente, estilo y tamaño      
        textoSeg.setFont(font);
        textoSeg.setEditable(false);
        seguimiento.setPreferredSize(new Dimension(250, 0));      
        textoPosiciones.setEditable(false);
        textoPosiciones.setFont(font);
        posiciones.setPreferredSize(new Dimension(250, 0));
        frame.add(tablero, BorderLayout.CENTER);
        frame.add(acciones, BorderLayout.SOUTH);       
        frame.add(seguimiento, BorderLayout.EAST);
        frame.add(posiciones, BorderLayout.WEST);
        
        
        

        
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
        //jugar();
        }
        
         private void atacarActionPerformed(java.awt.event.ActionEvent evt){ 
                VentanaAtacarElegirArma ventana = new VentanaAtacarElegirArma();
                  /*Superviviente jugador = Juego.obtenerJugadorActual();
                  jugador.atacar();
                  if(jugador.getNumAcciones() == 0 && (Juego.getTurnoJugador() == Juego.getSupervivientes().size()-1 )){
                      Juego.turnoZombies();
                      Juego.pasarTurno();     
                  }else if(jugador.getNumAcciones() == 0 && (Juego.getTurnoJugador() != Juego.getSupervivientes().size()-1 )){
                      Juego.pasarTurno();
                  }else if(jugador.getNumAcciones() > 0){
                      
                  }*/
                  /*textoSeg.setText("" + Juego.getObjetivo().getX() + Juego.getObjetivo().getY());
                  textoSeg2.setText("" + Juego.getSupervivientes().get(0).devolverCoordenada().getX() + Juego.getSupervivientes().get(0).devolverCoordenada().getY());
                  textoSeg3.setText("" + Juego.getSupervivientes().get(1).devolverCoordenada().getX() + Juego.getSupervivientes().get(1).devolverCoordenada().getY());*/
         }
         private void moverActionPerformed(java.awt.event.ActionEvent evt){
                  VentanaMoverse ventanaMoverse = new VentanaMoverse();
                 
         }
         private void buscarActionPerformed(java.awt.event.ActionEvent evt){
                  Juego.obtenerJugadorActual().buscar();
                 
         }
}