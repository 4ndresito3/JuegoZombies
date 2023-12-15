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
    public void setPosicion(Punto posicion) {
        this.posicion = posicion;
    }
    public Punto devolverCoordenada(){
        return this.posicion;
    }
    public abstract void morir();
}
