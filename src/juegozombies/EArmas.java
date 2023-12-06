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
    private boolean armaActiva;

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

    public boolean isArmaActiva() {
        return armaActiva;
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

    public void setArmaActiva(boolean armaActiva) {
        this.armaActiva = armaActiva;
    }
    
}
