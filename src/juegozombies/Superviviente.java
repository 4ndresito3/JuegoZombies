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
        int probArmaEquipo = (int) (Math.random()*100+1); /*prob arma o equipo*/       
        EArmas arma = new EArmas("",0,0,0,0);
        EProvisiones provision = new EProvisiones("",0);
            if (probArmaEquipo<=50){
                if (probArmaEquipo>0 && probArmaEquipo<=10){
                    arma = new EArmas("Bazooka", 3, 5, 5, 2);
                }
                if (probArmaEquipo>10 && probArmaEquipo<=20){
                    arma = new EArmas("Uzi", 1, 3, 10, 4);
                }
                if (probArmaEquipo>20 && probArmaEquipo<=30){
                    arma = new EArmas("Raygun", 3, 2, 2, 2);
                }
                if (probArmaEquipo>30 && probArmaEquipo<=40){
                    arma = new EArmas("Bate con pinchos", 2, 1, 3, 3);
                }
                if (probArmaEquipo>40 && probArmaEquipo<=50){
                    arma = new EArmas("Ballesta", 2, 4, 3, 4);
                }
                this.armasActivas.add(arma);
            }else if (probArmaEquipo>50){
                if (probArmaEquipo>50 && probArmaEquipo<=70){
                    provision = new EProvisiones("Redbull",1000);
                }
                if (probArmaEquipo>70 && probArmaEquipo<=85){
                    provision = new EProvisiones("Lata de judías",300);
                }
                if (probArmaEquipo>85 && probArmaEquipo<=100){
                    provision = new EProvisiones("Golosinas",200);
                }
                this.inventario.add(provision);
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
    public int obtenerArma(){
        /*Para obtener el argumento que recibe elegirArma desde la interfaz, posiblemente innecesario idk*/
        int i=0;
        return i;
    }
    public Punto elegirCasillaObj(int x, int y){
        /*El usuario elige la casilla a la que va a atacar el superviviente, teniendo en cuenta el alcance*/
        Punto casillaObj = new Punto(x,y);
        return casillaObj;
    }
    public int obtenerCasillaObjX(EArmas arma){ /*argumento para elegirCasillaObj*/
        int x=0;
        do{
            x=0; /*este valor se elige desde la interfaz grafica*/
        }
        while((x>Juego.getTamanoCuadricula().getX() || x<0) && (x-this.devolverCoordenada().getX()>arma.getAlcanceMax()));          
        return x;
    }
    public int obtenerCasillaObjY(EArmas arma){ /*argumento para elegirCasillaObj*/
        int y=0;
        do{
            y=0; /*este valor se elige desde la interfaz grafica*/
        }
        while((y>Juego.getTamanoCuadricula().getY() || y<0) && (y-this.devolverCoordenada().getY()>arma.getAlcanceMax()));
        return y;
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
    public boolean puedeMoverse(){ /*depende de si hay zombis*/
        int i;
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
                if (this.numAcciones>=2){
                    this.numAcciones-=2;
                    return true;
                }
                else{
                    return false;
                }                   
            }
            case 2 ->{ 
                if (this.numAcciones==3){
                    this.numAcciones-=3;
                    return true;
                }
                else{
                    return false;
                }
            }
            default ->{
                return false;                
            }
        }
    }
    @Override   
    public void moverse(){
        boolean puedeMoverseDir = false; /*para comprobar si se puede mover en una determinada direccion*/
        if(this.puedeMoverse()==true){
            int direccion=0; /*desde la interfaz*/
            while (puedeMoverseDir==false){
                switch (direccion){ /*1:arriba 2:abajo 3:izquierda 4:derecha*/
                    case 1 ->{
                        if(this.devolverCoordenada().getY()+1<=Juego.getTamanoCuadricula().getY()){
                            this.devolverCoordenada().setY(this.devolverCoordenada().getY()+1);
                            puedeMoverseDir=true;
                        }
                        else{ /*el survi no se puede mover en esta direccion*/
                            puedeMoverseDir=false;
                        }
                    }
                    case 2 ->{
                        if(this.devolverCoordenada().getY()-1>=0){
                            this.devolverCoordenada().setY(this.devolverCoordenada().getY()-1);
                            puedeMoverseDir=true;
                        }
                        else{
                            puedeMoverseDir=false;
                        }
                    }
                    case 3 ->{
                        if(this.devolverCoordenada().getX()-1>=0){
                            this.devolverCoordenada().setX(this.devolverCoordenada().getX()-1);
                            puedeMoverseDir=true;
                        }
                        else{
                            puedeMoverseDir=false;
                        }
                    }
                    case 4 ->{
                        if(this.devolverCoordenada().getX()+1<=Juego.getTamanoCuadricula().getX()){
                            this.devolverCoordenada().setX(this.devolverCoordenada().getX()+1);
                            puedeMoverseDir=true;
                        }
                        else{
                            puedeMoverseDir=false;
                        }
                    }
                }
            }
        }
        else{ /*no puede moverse por culpa de los zombis*/
            this.noHacerNada();
        }
    }
    @Override
    public void atacar(){
        int i;
        this.numAcciones-=1;        
        EArmas arma= this.elegirArma(this.obtenerArma()); /*se elige arma*/
        int x = this.obtenerCasillaObjX(arma);
        int y = this.obtenerCasillaObjY(arma);
        Punto casillaObj = this.elegirCasillaObj(x, y); /*se elige casilla objetivo*/
        int exitos = this.tirarDados(arma);
        for(i=0; i>Juego.getZombis().size(); i++){
            if (casillaObj.equals(Juego.getZombis().get(i).devolverCoordenada()) && exitos>0){               
                if(arma.getPotencia()>=Juego.getZombis().get(i).getAguante()){ /*comprueba si el arma mata el zombi*/
                    Juego.getZombis().get(i).morir();
                    exitos-=1;
                }
            }
        }
    }
    @Override
    public void morir(){
        Juego.getSupervivientes().remove(this);
    }  
}
