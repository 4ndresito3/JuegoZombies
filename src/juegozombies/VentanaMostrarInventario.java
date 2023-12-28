/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VentanaMostrarInventario {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextArea texto = new JTextArea();
    
    public VentanaMostrarInventario(){
        frame.setTitle("INVENTARIO");
        frame.setSize(400, 600);
        frame.setLocation(300,300); 
        frame.setResizable(true);
        texto.setEditable(false);
        texto.append("Armas activas:\n");
        for(int i=0; i<Juego.obtenerJugadorActual().getArmasActivas().size();i++){
            texto.append(i+1 + ".-" + Juego.obtenerJugadorActual().getArmasActivas().get(i).getNombre() + "\n");
            texto.append(" -Alcance: " + Juego.obtenerJugadorActual().getArmasActivas().get(i).getAlcanceMax() + "\n");
            texto.append(" -Potencia: " + Juego.obtenerJugadorActual().getArmasActivas().get(i).getPotencia() + "\n");
            texto.append(" -Dados: " + Juego.obtenerJugadorActual().getArmasActivas().get(i).getNumDados() + "\n");
            texto.append(" -Valor de exito: " + Juego.obtenerJugadorActual().getArmasActivas().get(i).getValorExito() + "\n");           
        }
        texto.append("\n");
        texto.append("Inventario:\n");
        for(int i=0; i<Juego.obtenerJugadorActual().getInventario().size();i++){
            texto.append(i+1 + ".-" + Juego.obtenerJugadorActual().getInventario().get(i).getNombre() + "\n");
            if(Juego.obtenerJugadorActual().getInventario().get(i) instanceof EArmas){
                EArmas arma = (EArmas) Juego.obtenerJugadorActual().getInventario().get(i);
                texto.append(" -Alcance: " + arma.getAlcanceMax() + "\n");
                texto.append(" -Potencia: " + arma.getPotencia() + "\n");
                texto.append(" -Dados: " + arma.getNumDados() + "\n");
                texto.append(" -Valor de exito: " + arma.getValorExito() + "\n");
            }
        }
        
        panel.add(texto);
        
        Font font = new Font("Serif", Font.ITALIC, 18); // Tipo de fuente, estilo y tamaño 
        texto.setFont(font); 
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}


