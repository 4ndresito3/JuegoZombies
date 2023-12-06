/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

import java.util.ArrayList;

/**
 *
 * @author Andrés
 */
public class Superviviente extends EntidadActivable{
    private String nombre;
    private boolean estado;
    private int numAcciones;
    private int elimZombies;
    private int heridas;
    ArrayList<Equipo>inventario;
    ArrayList<EArmas>armasActivas;
    
    
    public Superviviente (String nombre, Punto posicion){
        this.nombre = nombre;
        this.setPosicion(posicion);
        this.heridas = 0;
        this.elimZombies = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public Punto getPosicion() {
        return posicion;
    }

    public void setPosicion(Punto posicion) {
        this.posicion = posicion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNumAcciones() {
        return numAcciones;
    }

    public void setNumAcciones(int numAcciones) {
        this.numAcciones = numAcciones;
    }

    public int getElimZombies() {
        return elimZombies;
    }

    public void setElimZombies(int elimZombies) {
        this.elimZombies = elimZombies;
    }

    public int getHeridas() {
        return heridas;
    }

    public void setHeridas(int heridas) {
        this.heridas = heridas;
    }

    public ArrayList<Equipo> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Equipo> inventario) {
        this.inventario = inventario;
    }

    public ArrayList<EArmas> getArmasActivas() {
        return armasActivas;
    }

    public void setArmasActivas(ArrayList<EArmas> armasActivas) {
        this.armasActivas = armasActivas;
    }
    
    public void buscar(){
        
    }
    
    public void noHacerNada(){
        
    }
    
    public void setActivas(EArmas arma){
        
    }
    
    
    
    public void moverse(){
        
    }
    
    public void atacar(){
        
    }
    
    
    
    
}
