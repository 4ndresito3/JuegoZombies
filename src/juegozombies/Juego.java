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
    
    private static ArrayList<Superviviente> listaSupervivientes;
    private static ArrayList<Zombi> listaZombies;
    private static ArrayList<Equipo> listaEquipo;
    
    private Punto objetivo;
    private static Punto tamanoCuadricula;
    
    public static ArrayList<Zombi> getZombis (){
        return listaZombies;
    }
    public static ArrayList<Superviviente> getSupervivientes (){
        return listaSupervivientes;
    }

    public static Punto getTamanoCuadricula() {
        return tamanoCuadricula;
    }
    
    public void generarSupervivientes(int numeroSupervivientes){
        Scanner scan = new Scanner(System.in);
        this.tamanoCuadricula = new Punto(numeroSupervivientes + 6, numeroSupervivientes + 6);
        Punto posicion = new Punto();
        int random = (int)(Math.random()*4)+1;
        switch(random){
            case 1->{
                posicion.setX(0);
                posicion.setY(0);
            }
            case 2->{
                posicion.setX(this.tamanoCuadricula.getX());
                posicion.setY(this.tamanoCuadricula.getY());
            }
            case 3->{
                posicion.setX(0);
                posicion.setY(this.tamanoCuadricula.getY());
            }
            case 4->{
                posicion.setX(this.tamanoCuadricula.getX());
                posicion.setY(0);
            }
        }
        this.generarObjetivo(random);
        for(int i = 0; i < numeroSupervivientes ; i++){
            //System.out.println("introduce el nombre");
            String nombre = scan.nextLine();
            Juego.listaSupervivientes.add(new Superviviente(nombre, posicion));
        }
        /*switch(numeroSupervivientes){
            case 1 ->{
                Superviviente super1 = new Superviviente();
                this.listaSupervivientes.add(super1);
            }
            case 2 ->{
                Superviviente super1 = new Superviviente();
                Superviviente super2 = new Superviviente();
                this.listaSupervivientes.add(super1);
                this.listaSupervivientes.add(super2);
            }
            case 3 ->{
                Superviviente super1 = new Superviviente();
                Superviviente super2 = new Superviviente();
                Superviviente super3 = new Superviviente();
                this.listaSupervivientes.add(super1);
            }
            case 4 ->{
                Superviviente super1 = new Superviviente();
                Superviviente super2 = new Superviviente();
                Superviviente super3 = new Superviviente();
                Superviviente super4 = new Superviviente();

            }
            
        }*/
    }
    
    public void generarZombie(boolean opcion){
        // Opcion es para decidir si los zombies se generan por primera vez o a lo largo del juego
        int numSupers = Juego.listaSupervivientes.size();
        boolean repetir = false;
        // Zombi no se inicializa, habria que tener en cuenta algun tipo de zombi inicial para que no salte el error de que puede que no se haga
        Zombi zombi = new ZCaminanteNormal();
        if(!opcion){
            for(int i = 0; i < 3*numSupers ; i++){
                do{
                    // Generacion de punto aleatorio del zombi
                    int random1 = (int) (Math.random()*this.tamanoCuadricula.getX());
                    int random2 = (int) (Math.random()*this.tamanoCuadricula.getY());
                    Punto puntito = new Punto(random1,random2);
                    for(int j = 0; j < numSupers ; i++){
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
                Juego.listaZombies.add(zombi);
       
            }
        } else{
            for(int i = 0; i < numSupers ; i++){
                do{
                    int random1 = (int) (Math.random()*this.tamanoCuadricula.getX());
                    int random2 = (int) (Math.random()*this.tamanoCuadricula.getY());
                    Punto puntito = new Punto(random1,random2);
                    for(int j = 0; j < numSupers ; i++){
                        Punto position = this.listaSupervivientes.get(j).devolverCoordenada(); /*cambiado de getposicion*/
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
                Juego.listaZombies.add(zombi);
            }
        }

        
    }
    
    
    
    private void generarObjetivo(int genSupervivientes){
        switch(genSupervivientes){
            case 1->{
                this.objetivo = new Punto (this.tamanoCuadricula.getX(),this.tamanoCuadricula.getY());
            }
            case 2->{
                this.objetivo = new Punto ();
            }
            case 3->{
                this.objetivo = new Punto (this.tamanoCuadricula.getX(),0);
            }
            case 4->{
                this.objetivo = new Punto (0,this.tamanoCuadricula.getY());
            }
        }
    }
    
    
    
    
}
