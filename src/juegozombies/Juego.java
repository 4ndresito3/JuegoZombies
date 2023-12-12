/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Andrés
 */
public class Juego {
    
    private static int turnoJugador;
    private static ArrayList<Superviviente> listaSupervivientes;
    private static ArrayList<Zombi> listaZombies;
    private static ArrayList<Equipo> listaEquipo;
    
    private static Punto objetivo;
    private static Punto tamanoCuadricula;
    private static ArrayList<Punto> listaCasillasBuscadas;
    
    public static ArrayList<Zombi> getZombis (){
        return listaZombies;
    }
    public static ArrayList<Superviviente> getSupervivientes (){
        return listaSupervivientes;
    }
    public static Punto getTamanoCuadricula() {
        return tamanoCuadricula;
    }

    public static ArrayList<Punto> getListaCasillasBuscadas() {
        return listaCasillasBuscadas;
    }

    public static Punto getObjetivo() {
        return objetivo;
    }
    
    
    public Juego(){
        turnoJugador = 0;
        listaSupervivientes = new ArrayList<>();
        listaZombies = new ArrayList<>();
        listaEquipo = new ArrayList<>();
        listaCasillasBuscadas = new ArrayList<>();
    }
    
    public void generarSupervivientes(String[] listaNombres){
        int numeroSupervivientes = 0;
        for(int i = 0; i < 4; i++){
            if(!listaNombres[i].equals("")){
                numeroSupervivientes ++;
            }
        }
        Juego.tamanoCuadricula = new Punto(numeroSupervivientes + 6, numeroSupervivientes + 6);
        
        int random1 = (int)Math.round(Math.random())*(numeroSupervivientes+5);
        int random2 = (int)Math.round(Math.random())*(numeroSupervivientes+5);
        Punto posicion = new Punto(random1,random2);
        //int random = (int)((Math.random()*4)+1);
        //posicion.setX(Math.round(Math.random())*(numeroSupervivientes+6)
        /*switch(random){
            case 1->{
                posicion.setX(0);
                posicion.setY(0);
            }
            case 2->{
                posicion.setX(numeroSupervivientes + 5);
                posicion.setY(numeroSupervivientes + 5);
            }
            case 3->{
                posicion.setX(0);
                posicion.setY(numeroSupervivientes + 5);
            }
            case 4->{
                posicion.setX(numeroSupervivientes + 5);
                posicion.setY(0);
            }
        }*/
        this.generarObjetivo(random1,random2);
        for(int i = 0; i < numeroSupervivientes ; i++){
            Juego.listaSupervivientes.add(new Superviviente(listaNombres[i], posicion));
            System.out.println(listaSupervivientes.get(i).devolverCoordenada().getX() + "," + listaSupervivientes.get(i).devolverCoordenada().getY());
        }
       
    }
    
    public void generarZombies(boolean opcion){
        // Opcion es para decidir si los zombies se generan por primera vez o a lo largo del juego
        int numSupers = Juego.listaSupervivientes.size();
        boolean repetir = false;
        // Zombi no se inicializa, habria que tener en cuenta algun tipo de zombi inicial para que no salte el error de que puede que no se haga
        Zombi zombi = new ZCaminanteNormal();
        Punto puntito;
        if(!opcion){
            for(int i = 0; i < 3*numSupers ; i++){
                do{
                    // Generacion de punto aleatorio del zombi
                    int random1 = (int) (Math.random()*Juego.tamanoCuadricula.getX()-1);
                    int random2 = (int) (Math.random()*Juego.tamanoCuadricula.getY()-1);
                    puntito = new Punto(random1,random2);
                    for(int j = 0; j < numSupers ; j++){
                        //Comprobacion de que no sea en la casilla del superviviente
                        Punto position = Juego.listaSupervivientes.get(j).devolverCoordenada(); /*cambiado de getposicion*/
                        repetir = position.equals(puntito);
                    }
                } while(repetir);
                int probabilidad = (int) (Math.random()*100 +1);
                int probabilidad2 = (int) (Math.random()*3 +1);
                if( probabilidad <= 60){
                    switch(probabilidad2){
                        case 1->{
                            zombi = new ZCaminanteNormal();
                        }
                        case 2->{
                            zombi = new ZCaminanteToxico();
                        }
                        case 3->{
                            zombi = new ZCaminanteBerserker();
                        }
                    }
                }else if(probabilidad <= 90){
                    switch(probabilidad2){
                        case 1->{
                            zombi = new ZCorredorNormal();
                        }
                        case 2->{
                            zombi = new ZCorredorToxico();
                        }
                        case 3->{
                            zombi = new ZCorredorBerserker();
                        }
                    }
                }else{
                    switch(probabilidad2){
                        case 1->{
                            zombi = new ZAbominacionNormal();
                        }
                        case 2->{
                            zombi = new ZAbominacionToxico();
                        }
                        case 3->{
                            zombi = new ZAbominacionBerserker();
                        }
                    }
                }
                zombi.setPosicion(puntito);
                Juego.listaZombies.add(zombi);      
            }
        } else{
            for(int i = 0; i < numSupers ; i++){
                do{
                    int random1 = (int) (Math.random()*Juego.tamanoCuadricula.getX()-1);
                    int random2 = (int) (Math.random()*Juego.tamanoCuadricula.getY()-1);
                    puntito = new Punto(random1,random2);
                    for(int j = 0; j < numSupers ; j++){
                        Punto position = Juego.listaSupervivientes.get(j).devolverCoordenada(); /*cambiado de getposicion*/
                        repetir = position.equals(puntito);
                    }
                } while(repetir);
                int probabilidad = (int) (Math.random()*100 +1);
                int probabilidad2 = (int) (Math.random()*3 +1);
                if( probabilidad <= 60){
                    switch(probabilidad2){
                        case 1->{
                            zombi = new ZCaminanteNormal();
                        }
                        case 2->{
                            zombi = new ZCaminanteToxico();
                        }
                        case 3->{
                            zombi = new ZCaminanteBerserker();
                        }
                    }
                }else if(probabilidad <= 90){
                    switch(probabilidad2){
                        case 1->{
                            zombi = new ZCorredorNormal();
                        }
                        case 2->{
                            zombi = new ZCorredorToxico();
                        }
                        case 3->{
                            zombi = new ZCorredorBerserker();
                        }
                    }
                }else{
                    switch(probabilidad2){
                        case 1->{
                            zombi = new ZAbominacionNormal();
                        }
                        case 2->{
                            zombi = new ZAbominacionToxico();
                        }
                        case 3->{
                            zombi = new ZAbominacionBerserker();
                        }
                    }
                }
                zombi.setPosicion(puntito);
                Juego.listaZombies.add(zombi);
            }
        }
    }
    private void generarObjetivo(int genSupervivientes,int genSupervivientes2){
        /*switch(genSupervivientes){
            case 1->{
                this.objetivo = new Punto (Juego.tamanoCuadricula.getX()-1,Juego.tamanoCuadricula.getY()-1);
            }
            case 2->{
                this.objetivo = new Punto ();
            }
            case 3->{
                this.objetivo = new Punto (Juego.tamanoCuadricula.getX()-1,0);
            }
            case 4->{
                this.objetivo = new Punto (0,Juego.tamanoCuadricula.getY()-1);
            }*/
            this.objetivo = new Punto (Math.abs(genSupervivientes-(tamanoCuadricula.getX()-1)),Math.abs(genSupervivientes2-(tamanoCuadricula.getY()-1)));
        }

        public static int getTurnoJugador() {
            return turnoJugador;
        }
        
        public static Superviviente obtenerJugadorActual(){
            return listaSupervivientes.get(turnoJugador);
        }
        public static void pasarTurno(){
            turnoJugador = (turnoJugador + 1) % listaSupervivientes.size();
        }
    }