/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

/**
 *
 * @author Andrés
 */
public class EArmas extends Equipo {
    private int potencia;
    private int alcanceMax;
    private int numDados;
    private int valorExito;
    
    public EArmas (String nombre, int potencia, int alcance, int numDados, int valorExito){
        this.setNombre(nombre);
        this.potencia=potencia;
        this.alcanceMax=alcance;
        this.numDados=numDados;
        this.valorExito=valorExito;
    }
    

    public int getPotencia() {
        return potencia;
    }

    public int getAlcanceMax() {
        return alcanceMax;
    }

    public int getNumDados() {
        return numDados;
    }

    public int getValorExito() {
        return valorExito;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setAlcanceMax(int alcanceMax) {
        this.alcanceMax = alcanceMax;
    }

    public void setNumDados(int numDados) {
        this.numDados = numDados;
    }

    public void setValorExito(int valorExito) {
        this.valorExito = valorExito;
    }    
}
