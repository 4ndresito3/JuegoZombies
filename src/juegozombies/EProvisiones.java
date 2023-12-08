/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

/**
 *
 * @author Andrés
 */
public class EProvisiones extends Equipo {
    private int valorEnergetico;
    private int caducidad;

    public EProvisiones(String nombre, int valorEnergetico, int caducidad) {
        this.setNombre(nombre);
        this.valorEnergetico = valorEnergetico;
        this.caducidad = caducidad;
    }
    
    public int getValorEnergetico() {
        return this.valorEnergetico;
    }

    public void setValorEnergetico(int valorEnergetico) {
        this.valorEnergetico = valorEnergetico;
    }

    public int getCaducidad() {
        return this.caducidad;
    }

    public void setCaducidad(int caducidad) {
        this.caducidad = caducidad;
    }
    
    
}
