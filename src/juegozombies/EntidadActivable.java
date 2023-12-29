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
    private boolean vivo;

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    
    public void setPosicion(Punto posicion) {
        this.posicion = posicion;
    }
    public Punto devolverCoordenada(){
        return this.posicion;
    }
    public  void morir(){
        this.setVivo(false);
    }
}
