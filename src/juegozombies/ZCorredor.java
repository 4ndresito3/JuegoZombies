/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

/**
 *
 * @author Andrés
 */
public abstract class ZCorredor extends Zombi{
    
    public ZCorredor (){
        super(1,2);
    }
    @Override
    public abstract String obtenerTipo();
    public abstract String obtenerTipo2();

}
