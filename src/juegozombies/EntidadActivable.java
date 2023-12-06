/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package juegozombies;

/**
 *
 * @author Andrés
 */
public abstract class EntidadActivable {
    
    private Punto posicion;

    public Punto getPosicion() {
        return posicion;
    }

    public void setPosicion(Punto posicion) {
        this.posicion = posicion;
    }
    
    
    public  void activarse(){
        
    }
    
    public Punto devolverCoordenada(){
    
    }
    
    public abstract void moverse();
    
    public abstract void atacar();
    
    
}
