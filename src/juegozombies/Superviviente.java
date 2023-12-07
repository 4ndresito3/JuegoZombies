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
        int numero = (int)Math.floor(Math.random()*2+1); /*prob arma o equipo*/
        switch(numero){
            case 1 ->{               
                /*this.inventario.add(); falta crear las posibles piezas de equipo*/
            }
            case 2 ->{
                /*this.armasActivas.add();*/
            }      
        }
    }
    
    public void noHacerNada(){
        this.numAcciones-=1;
    }
    
    public void setActivas(EArmas arma){
        
    }
    public EArmas elegirArma(int huecoArma){
        /*El usuario elige entre las armas disponibles para el superviviente*/
        return this.armasActivas.get(huecoArma);
    }
    public Punto elegirCasillaObj(int x, int y){
        /*El usuario elige la casilla a la que va a atacar el superviviente*/
        Punto casillaObj = new Punto(x,y);
        return casillaObj;
    }
    public int tirarDados(EArmas arma){
        int i;
        int exitos=0;
        for(i=0; i>arma.getNumDados(); i++){
            int numero = (int)Math.floor(Math.random()*6+1);
            if(numero>=arma.getValorExito()){
                exitos+=1;
            }
        }
        return exitos;
    }
    public boolean puedeMoverse(){
        int i=0;
        int numZombies=0; /*Zombis en la misma casilla del survi*/
        for(i=0; i>Juego.getZombis().size(); i++){
            if (this.devolverCoordenada()==Juego.getZombis().get(i).devolverCoordenada()){
                numZombies+=1;
            }          
        }
        switch (numZombies){
            case 0 ->{
                this.numAcciones-=1;  
                return true;
            }
            case 1 ->{ 
                if (this.numAcciones>=2)
                this.numAcciones-=2;
                return true;
            }
            case 2 ->{ 
                if (this.numAcciones==3)
                    this.numAcciones-=3;
                return true;
            }
            default ->{
                return false;
                /*desde la interfaz grafica no te dejaria hacerlo*/
            }
        }
    }
    @Override   
    public void moverse(){
        
    }
    @Override
    public void atacar(){
        int i=0, x=0, y=0;    
        this.numAcciones-=1;
        Punto casillaObj = this.elegirCasillaObj(x, y);
        int exitos = this.tirarDados(this.elegirArma(i));
        for(i=0; i>Juego.getZombis().size(); i++){
            if (casillaObj.equals(Juego.getZombis().get(i).devolverCoordenada()) && exitos>0){
                exitos-=1;
                Juego.getZombis().get(i).setAguante(Juego.getZombis().get(i).getAguante()-1);
                if(Juego.getZombis().get(i).getAguante()<=0){
                    Juego.getZombis().get(i).morir();                 
                }
            }
        }
    }
    @Override
    public void morir(){
        Juego.getSupervivientes().remove(this);
    }
    
    
    
}
