/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

/**
 *
 * @author Andrés
 */
public abstract class Zombi extends EntidadActivable{
    private int aguante;
    private int numAcciones;
    
    @Override
    public void atacar(){
        
    }
    
    public abstract void reaccion(EArmas arma);
}
