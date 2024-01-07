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

public class VentanaEstadisticas {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextArea texto = new JTextArea();
    
    public VentanaEstadisticas(){
        frame.setTitle("ESTADÍSTICAS");
        frame.setSize(600, 600);
        frame.setLocation(400,75); 
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        texto.setEditable(false);
        
        int heridasTotal=0;
        for(int i=0; i<Juego.getSupervivientes().size();i++){
            texto.append("\n");
            texto.append(Juego.getSupervivientes().get(i).getNombre() + " ha eliminado " + Juego.getSupervivientes().get(i).getElimZombies() + " zombies\n");
            texto.append( "Tiene " + Juego.getSupervivientes().get(i).getHeridas() + " heridas");         
            if(Juego.getSupervivientes().get(i).getHeridas()>=2){
                texto.append(" y ha muerto");
            }
            heridasTotal+=Juego.getSupervivientes().get(i).getHeridas();
        }
        texto.append("\n");
        texto.append("\n");
        texto.append("Han mordido a los supervivientes " + heridasTotal + " veces\n");
          
        panel.add(texto);
        
        Font font = new Font("Serif", Font.ITALIC, 22); // Tipo de fuente, estilo y tamaño 
        texto.setFont(font); 
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
