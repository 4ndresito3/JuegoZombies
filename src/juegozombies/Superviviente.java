/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

import java.util.ArrayList;
import javax.swing.JOptionPane;
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
        this.armasActivas = new ArrayList();
        this.inventario = new ArrayList();
        this.numAcciones = 3;
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
    public boolean casillaBuscada(Punto casilla){
        
        for(int i=0; i<Juego.getListaCasillasBuscadas().size(); i++){ /*comprueba que la casilla que se va a buscar no esta en la lista*/
            if(this.devolverCoordenada().equals(Juego.getListaCasillasBuscadas().get(i))){
                return true;
            }
        }
        return false;
    }
    public void buscar(){
        if(this.inventario.size()<5 || this.armasActivas.size()<2){
            if(!this.casillaBuscada(this.devolverCoordenada())){
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
                        if (this.armasActivas.size()<2){
                            this.armasActivas.add(arma);
                            this.numAcciones-=1;
                            VentanaJuego.textoSeg.append(" Se ha encontrado el arma:\n");
                            VentanaJuego.textoSeg.append(" " + arma.getNombre() + "\n");
                            VentanaJuego.textoSeg.append(" Añadido el arma a armas activas\n");
                            VentanaJuego.textoSeg.append(" Nummero de acciones: " + this.getNumAcciones() + "\n");
                        }
                        else{
                            this.inventario.add(arma);
                            this.numAcciones-=1;
                            VentanaJuego.textoSeg.append(" Se ha encontrado el arma:\n");
                            VentanaJuego.textoSeg.append(" " + arma.getNombre() + "\n");
                            VentanaJuego.textoSeg.append(" Añadido el arma al inventario \n");
                            VentanaJuego.textoSeg.append(" Nummero de acciones: " + this.getNumAcciones() + "\n");
                        }   
                    }
                    else if (probArmaEquipo>50){
                        if (probArmaEquipo>50 && probArmaEquipo<=70){
                            provision = new EProvisiones("Redbull",1000);
                        }
                        if (probArmaEquipo>70 && probArmaEquipo<=85){
                            provision = new EProvisiones("Lata de judías",300);
                        }
                        if (probArmaEquipo>85 && probArmaEquipo<=100){
                            provision = new EProvisiones("Golosinas",200);
                        }
                        if(this.inventario.size()<5){
                            this.inventario.add(provision);
                            this.numAcciones-=1;
                            VentanaJuego.textoSeg.append(" Se ha encontrado la provision\n " + provision.getNombre() + " " + provision.getValorEnergetico()+ " " + provision.getCaducidad() + "\n");
                            VentanaJuego.textoSeg.append(" Añadida la provision al inventario \n");
                            VentanaJuego.textoSeg.append(" Nummero de acciones: " + this.getNumAcciones() + "\n");
                            
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Hay una provisión, pero el inventario está lleno", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE); 
                        }
                    }
                   Juego.getListaCasillasBuscadas().add(this.devolverCoordenada().copia());
            }
            else{
                JOptionPane.showMessageDialog(null, "Ya se había buscado en esta casilla", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE); 

                /*ya se habia buscado antes en esta coordenada*/
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El superviviente no puede llevar nada más", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE); 
        }
        if(this.numAcciones == 0){
            VentanaJuego.pasarTurnoJugador();
         }
    }
    
    public void noHacerNada(){
        this.numAcciones-=1;
        VentanaJuego.textoSeg.append(this.getNombre() + ", no has hecho nada\n");
        VentanaJuego.textoSeg.append("Numero de acciones: " + this.getNumAcciones() + "\n");
        if (numAcciones == 0){
            VentanaJuego.pasarTurnoJugador();
        } 
    }
    
    public void setActivas(EArmas arma){
        
    }
    public EArmas elegirArma(int huecoArma){
        /*El usuario elige entre las armas disponibles para el superviviente*/
        return this.armasActivas.get(huecoArma);
    }
    public int obtenerArma(){
        int i=0;
        do{
            i=0;  /*Para obtener el argumento que recibe elegirArma desde la interfaz, posiblemente innecesario idk*/
        }while(i>5 || i<0);
        return i;
    }
    public Punto elegirCasillaObj(int x, int y){
        /*El usuario elige la casilla a la que va a atacar el superviviente, teniendo en cuenta el alcance*/
        Punto casillaObj = new Punto(x,y);
        return casillaObj;
    }
    public int obtenerCasillaObjX(int x){ /*argumento para elegirCasillaObj*/     
        return x;
    }
    public int obtenerCasillaObjY(int y){ /*argumento para elegirCasillaObj*/
        return y;
    }
    public int tirarDados(EArmas arma){
        int i;
        int exitos=0;
        for(i=0; i<arma.getNumDados(); i++){
            int numero = (int)Math.floor(Math.random()*6+1);
            if(numero>=arma.getValorExito()){
                exitos+=1;
            }
        }
        return exitos;
    }
    public boolean puedeMoverse(){ /*depende de si hay zombis*/
        int numZombies=0; /*Zombis en la misma casilla del survi*/
        for(int i=0; i<Juego.getZombis().size(); i++){
            if (this.devolverCoordenada().equals(Juego.getZombis().get(i).devolverCoordenada())){
                numZombies+=1;
            }          
        }
        // Devuelve true si se puede mover
        return this.numAcciones >= numZombies + 1;
    } 
    public void moverse(int direccion){
        boolean puedeMoverseDir = false; /*para comprobar si se puede mover en una determinada direccion*/
        if(this.puedeMoverse()){
            while (!puedeMoverseDir){
                switch (direccion){ /*1:derecha 2:izqda 3:arriba 4:abajo*/
                    case 1 ->{
                        if(this.devolverCoordenada().getY()+1<=Juego.getTamanoCuadricula().getY()){
                            VentanaJuego.borrarJugadoresAntiguos();
                            this.devolverCoordenada().setY(this.devolverCoordenada().getY()+1);
                            puedeMoverseDir=true;
                        }
                        else{ /*el survi no se puede mover en esta direccion*/
                            puedeMoverseDir=false;
                        }
                    }
                    case 2 ->{
                        if(this.devolverCoordenada().getY()-1>=0){
                            VentanaJuego.borrarJugadoresAntiguos();
                            this.devolverCoordenada().setY(this.devolverCoordenada().getY()-1);
                            puedeMoverseDir=true;
                        }
                        else{
                            puedeMoverseDir=false;
                        }
                    }
                    case 3 ->{
                        if(this.devolverCoordenada().getX()-1>=0){
                            VentanaJuego.borrarJugadoresAntiguos();
                            this.devolverCoordenada().setX(this.devolverCoordenada().getX()-1);
                            puedeMoverseDir=true;
                        }
                        else{
                            puedeMoverseDir=false;
                        }
                    }
                    case 4 ->{
                        if(this.devolverCoordenada().getX()+1<=Juego.getTamanoCuadricula().getX()){
                            VentanaJuego.borrarJugadoresAntiguos();
                            this.devolverCoordenada().setX(this.devolverCoordenada().getX()+1);
                            puedeMoverseDir=true;
                        }
                        else{
                            puedeMoverseDir=false;
                        }
                    }
                }
                if (puedeMoverseDir==false){
                    JOptionPane.showMessageDialog(null, "El superviviente no se puede mover en esta dirección", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE);
                }
                else{
                     this.numAcciones-=1;
                     if(this.numAcciones == 0){
                         VentanaJuego.pasarTurnoJugador();
                     }
                     VentanaJuego.textoSeg.append(this.getNombre() + " te moviste\n");
                     VentanaJuego.textoSeg.append("Numero de acciones: " + this.getNumAcciones() + "\n");
                     VentanaJuego.actualizarJugadores();
                     
                }       
            }
        }
        else{ /*no puede moverse por culpa de los zombis*/
            JOptionPane.showMessageDialog(null, "El superviviente no se puede mover porque está rodeado", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE); 
        }
    }
    public void atacar(int x, int y, EArmas arma){   
        boolean hayZombies=false;
        int exitos = this.tirarDados(arma);
        Punto casillaObj = new Punto(x, y);
        for(int i=0; i<Juego.getZombis().size(); i++){
            if (casillaObj.equals(Juego.getZombis().get(i).devolverCoordenada())){ 
                hayZombies=true;              
            }         
        }
        if(hayZombies){
            this.numAcciones-=1;
            for(int i=0; i<Juego.getZombis().size(); i++){
                if (casillaObj.equals(Juego.getZombis().get(i).devolverCoordenada()) && exitos>0){               
                    if(arma.getPotencia()>=Juego.getZombis().get(i).getAguante()){ /*comprueba si el arma mata el zombi*/
                        Juego.getZombis().get(i).morir();
                        exitos-=1;
                    }
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay zombies en esta casilla", "¡ADVERTENCIA!" , JOptionPane.WARNING_MESSAGE); 
        }
    }
    @Override
    public void morir(){
        Juego.getSupervivientes().remove(this);
    }  
}
