/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

/**
 *
 * @author Andrés
 */
public abstract class ZAbominacion extends Zombi{
    
    public ZAbominacion (){
        super(3,1);
    }
    @Override
    public abstract String obtenerTipo();
}
