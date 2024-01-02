/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author vaant
 */
public class VentanaJuego extends javax.swing.JFrame {
    public static boolean victoria=false;
    public static JFrame frame = new JFrame();
    JPanel seguimiento = new JPanel();
    JPanel posiciones = new JPanel();
    public static JTextArea textoPosiciones = new JTextArea();
    public static JTextArea textoSeg = new JTextArea();
    public static JPanel tablero = new JPanel(new GridLayout(Juego.getTamanoCuadricula().getX(), Juego.getTamanoCuadricula().getY()));
    JPanel acciones = new JPanel(new GridLayout(2, 3));
    public static JButton celda[][] = new JButton[Juego.getTamanoCuadricula().getX()] [Juego.getTamanoCuadricula().getY() ];
    /**
     * Creates new form JFrame
     */
    /*public static void turnoJugador(Superviviente jugador){
        
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
    }*/
    public static void actualizarTodo(){
        for (int i=0; i<Juego.getTamanoCuadricula().getX()  ; i++){
            for(int j=0; j< Juego.getTamanoCuadricula().getY(); j++){
                celda[i][j].setText("");
                for(int l = 0; l< Juego.getSupervivientes().size(); l++){
                    if(Juego.getSupervivientes().get(l).devolverCoordenada().getX() == i && Juego.getSupervivientes().get(l).devolverCoordenada().getY() == j && Juego.getSupervivientes().get(l).isVivo()){                       
                           String texto = celda[i][j].getText();
                           String newTexto=Juego.getSupervivientes().get(l).getNombre();                          
                           StringBuilder textoBoton = new StringBuilder("<html>"+texto);
                           textoBoton.append("<br>" + newTexto);
                           celda[i][j].setText(textoBoton.toString());
                    }
                }
                for(int k = 0; k< Juego.getZombis().size(); k++){                            
                    if(Juego.getZombis().get(k).devolverCoordenada().getX() == i && Juego.getZombis().get(k).devolverCoordenada().getY() == j && Juego.getZombis().get(k).isVivo()){
                        String texto2 = celda[i][j].getText();
                           String newTexto2=Juego.getZombis().get(k).obtenerTipo2();                          
                           StringBuilder textoBoton2 = new StringBuilder("<html>"+texto2);
                           textoBoton2.append("<br>" + newTexto2);
                           celda[i][j].setText(textoBoton2.toString());                    
                    }               
                }               
            }
        }
        textoPosiciones.setText("");
        textoPosiciones.append("SUPERVIVIENTES\n");
        for(int i = 0; i<Juego.getSupervivientes().size(); i++){           
            if(Juego.getSupervivientes().get(i).isVivo()){
                  textoPosiciones.append("" + Juego.getSupervivientes().get(i).getNombre() + ": " 
                    + Juego.getSupervivientes().get(i).devolverCoordenada().getX() + ", " + Juego.getSupervivientes().get(i).devolverCoordenada().getY() + "\n");
            }
            
        }
        textoPosiciones.append("\n");
        textoPosiciones.append("ZOMBIES\n");
        for(int i = 0; i<Juego.getZombis().size(); i++){
            if(Juego.getZombis().get(i).isVivo()){
                textoPosiciones.append("" + Juego.getZombis().get(i).obtenerTipo() + ": " 
                    + Juego.getZombis().get(i).devolverCoordenada().getX() + ", " + Juego.getZombis().get(i).devolverCoordenada().getY() + "\n");         
            }
            
        }
        if(VentanaJuego.llegarObjetivoProvisiones() && Juego.jugadoresVivos()){
            JOptionPane.showMessageDialog(null, "Fin partida", "Has ganado" , JOptionPane.WARNING_MESSAGE);
            for(int i=0; i<Juego.getSupervivientes().size(); i++){
                Juego.getSupervivientes().get(i).morir();
            }
            victoria=true;
            textoSeg.setText("");
            textoSeg.append("PARTIDA FINALIZADA:\n");
            textoSeg.append("VICTORIA\n");
        }
        if(!Juego.jugadoresVivos() && !victoria){
            JOptionPane.showMessageDialog(null, "Todos los supervivientes han muerto", "¡Perdiste!" , JOptionPane.WARNING_MESSAGE);
            textoSeg.setText("");
            textoSeg.append("PARTIDA FINALIZADA:\n");
            textoSeg.append("DERROTA\n");
        }
    }
    /*public static void actualizarJugadores(){
        
        // Actualizacion de casillas
        for (int i=0; i<Juego.getTamanoCuadricula().getX()  ; i++){
            for(int j=0; j< Juego.getTamanoCuadricula().getY(); j++){
                for(int l = 0; l< Juego.getSupervivientes().size(); l++){
                    if(Juego.getSupervivientes().get(l).devolverCoordenada().getX() == i && Juego.getSupervivientes().get(l).devolverCoordenada().getY() == j ){                       
                           String texto = celda[i][j].getText();
                           String newTexto=Juego.getSupervivientes().get(l).getNombre();                          
                           StringBuilder textoBoton = new StringBuilder("<html>"+texto);
                           textoBoton.append("<br>" + newTexto);
                           celda[i][j].setText(textoBoton.toString());
                    }
                }              
            }
        }
         
        if(VentanaJuego.llegarObjetivoProvisiones()){
            JOptionPane.showMessageDialog(null, "Fin partida", "Has ganado" , JOptionPane.WARNING_MESSAGE);
        }                                    
    }
        public static void borrarJugadoresAntiguos(){
         for (int i=0; i<Juego.getTamanoCuadricula().getX()  ; i++){
            for(int j=0; j< Juego.getTamanoCuadricula().getY(); j++){
                for(int l = 0; l< Juego.getSupervivientes().size(); l++){
                    if(Juego.getSupervivientes().get(l).devolverCoordenada().getX() == i && Juego.getSupervivientes().get(l).devolverCoordenada().getY() == j ){                       
                           celda[i][j].setText("");
                    }
                }              
            }
        }
    }
    public static void borrarZombiesAntiguos(){
        for (int i=0; i<Juego.getTamanoCuadricula().getX()  ; i++){
            for(int j=0; j< Juego.getTamanoCuadricula().getY(); j++){
                for(int k = 0; k< Juego.getZombis().size(); k++){                            
                    if(Juego.getZombis().get(k).devolverCoordenada().getX() == i && Juego.getZombis().get(k).devolverCoordenada().getY() == j){
                        celda[i][j].setText("");                
                    }               
                }               
            }
        }
    }
    public static void actualizarZombies(){
        for (int i=0; i<Juego.getTamanoCuadricula().getX()  ; i++){
            for(int j=0; j< Juego.getTamanoCuadricula().getY(); j++){
                for(int k = 0; k< Juego.getZombis().size(); k++){                            
                    if(Juego.getZombis().get(k).devolverCoordenada().getX() == i && Juego.getZombis().get(k).devolverCoordenada().getY() == j){
                        String texto2 = celda[i][j].getText();
                           String newTexto2=Juego.getZombis().get(k).obtenerTipo2();                          
                           StringBuilder textoBoton2 = new StringBuilder("<html>"+texto2);
                           textoBoton2.append("<br>" + newTexto2);
                           celda[i][j].setText(textoBoton2.toString());                    
                    }               
                }               
            }
        }
        if(VentanaJuego.jugadoresVivos()){
                JOptionPane.showMessageDialog(null, "Todos los supervivientes han muerto", "¡Perdiste!" , JOptionPane.WARNING_MESSAGE);
            }
    }*/
    public static boolean llegarObjetivoProvisiones(){
        /*
        * Comprueba si los supervivientes estan en la casilla objetivo con provisiones
         
         */
        int cont = 0;
        for(int i = 0;i<Juego.getSupervivientes().size();i++){ //contamos cuantos supervivientes vivos estan en el objetivo
            if(Juego.getSupervivientes().get(i).devolverCoordenada().equals(Juego.getObjetivo()) && Juego.getSupervivientes().get(i).isVivo()){
                cont++;
            }
        }
        int cont2 = 0;
        for(int i = 0;i<Juego.getSupervivientes().size();i++){ // contamos el numero de provisiones que llevan los supervivientes
            for(int j= 0; j < Juego.getSupervivientes().get(i).getInventario().size();j++){
                if(Juego.getSupervivientes().get(i).getInventario().get(j) instanceof EProvisiones && Juego.getSupervivientes().get(i).isVivo()){
                    cont2++;
                }
            }
        }
        int cont3 = 0;
        for(int i = 0;i<Juego.getSupervivientes().size();i++){//contamos todos los jugadores vivos
            if(Juego.getSupervivientes().get(i).isVivo()){
                cont3++;
            }
        }
        return cont == cont3 && cont2 >= cont; //si los jugadores en el objetivo son iguales a los jugadores vivos, y ademas hay proviviones para todos es true
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
                if(Juego.getObjetivo().getX()==i && Juego.getObjetivo().getY()==j){
                    celda[i][j].setBackground(Color.red);
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
        
        Font font = new Font("Serif", Font.ITALIC, 17); // Tipo de fuente, estilo y tamaño 
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
        noHacerNada.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noHacerNadaMouseClicked(evt);
            }
        });
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });
        inventario.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioActionPerformed(evt);
            }
        });
        equipar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equiparActionPerformed(evt);
            }
        });
        frame.setVisible(true);
        //jugar();
        }
        
        public static void pasarTurnoJugador(){
            Superviviente jugador = Juego.obtenerJugadorActual();            
            if((Juego.getTurnoJugador() == Juego.getSupervivientes().size()-1 )){
                  jugador.setNumAcciones(3);
                  Juego.turnoZombies();
                  Juego.pasarTurno();     
                 }else{
                     jugador.setNumAcciones(3);                    
                     Juego.pasarTurno();
                    }
        }
    
         private void atacarActionPerformed(java.awt.event.ActionEvent evt){ 
             if(Juego.jugadoresVivos()){
                VentanaAtacarElegirArma ventana = new VentanaAtacarElegirArma();
             }
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
                if(Juego.jugadoresVivos()){
                    VentanaMoverse ventanaMoverse = new VentanaMoverse();
                }
                 
         }
         private void noHacerNadaMouseClicked(java.awt.event.MouseEvent evt){
                if(Juego.jugadoresVivos()){
                    Juego.obtenerJugadorActual().noHacerNada(); 
                }
         }
         private void buscarMouseClicked(java.awt.event.MouseEvent evt){
                if(Juego.jugadoresVivos()){
                    Juego.obtenerJugadorActual().buscar();
                }
                 
         }
         private void inventarioActionPerformed(java.awt.event.ActionEvent evt){
            if(Juego.jugadoresVivos()){
                if((Juego.obtenerJugadorActual().getInventario().size()!=0) || (Juego.obtenerJugadorActual().getArmasActivas().size()!=0)){
                     VentanaMostrarInventario ventanaInventario = new VentanaMostrarInventario();
                }
                else{
                    JOptionPane.showMessageDialog(null, "El superviviente no tiene nada", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE);
                }
            }
         }
         private void equiparActionPerformed(java.awt.event.ActionEvent evt){
            if(Juego.jugadoresVivos()){
                boolean tieneArmasInv=false;
                for(int i=0;i<Juego.obtenerJugadorActual().getInventario().size();i++){
                    if(Juego.obtenerJugadorActual().getInventario().get(i) instanceof EArmas){
                        tieneArmasInv=true;
                    }
                }
                if(!tieneArmasInv){
                   JOptionPane.showMessageDialog(null, "El superviviente no tiene armas en el inventario", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE);                
                }
                else{
                    VentanaEquiparArma ventanaEquiparArma = new VentanaEquiparArma();
                }   
            }
         }
}