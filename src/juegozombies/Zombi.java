/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

/**
 *
 * @author Andrés
 */

public abstract class Zombi extends EntidadActivable{
    private int aguante;
    private int numAcciones;
    
    public Zombi(int aguante, int numAcciones){
        this.aguante = aguante;
        this.numAcciones = numAcciones;
        this.setVivo(true);
    }
    
    public int getAguante() {
        return this.aguante;
    }

    public void setAguante(int aguante) {
        this.aguante = aguante;
    }
    
    public int getNumAcciones() {
        return this.numAcciones;
    }
    
    public void setNumAcciones(int numAcciones) {
        this.numAcciones = numAcciones;
    }
    
    public Punto supervivienteCercano(){
        /**
         * Calculo de que superviviente esta mas cerca y devuelve sus coordenadas
         */
        Punto cercano = Juego.getSupervivientes().get(0).devolverCoordenada();
        double distancia, auxDistancia;
        // calculo del modulo/hipotenusa del vector Zombi-Superviviente1 para posteriormente comparar
        /*int x0 = Juego.getSupervivientes().get(0).devolverCoordenada().getX() - this.devolverCoordenada().getX();
        int y0 = Juego.getSupervivientes().get(0).devolverCoordenada().getY() - this.devolverCoordenada().getY();
        distancia = Math.sqrt(x0^2 + y0^2);*/
        distancia = 1000000;
        for (int i = 0; i < Juego.getSupervivientes().size(); i++){
            // Posible mejora del rendimiento si se cambia i = 0 por i = 1
            int x = Juego.getSupervivientes().get(i).devolverCoordenada().getX() - this.devolverCoordenada().getX();
            int y = Juego.getSupervivientes().get(i).devolverCoordenada().getY() - this.devolverCoordenada().getY();
            auxDistancia = Math.sqrt(x^2 + y^2);
            if(distancia > auxDistancia && Juego.getSupervivientes().get(i).isVivo()){
                distancia = auxDistancia;
                cercano = Juego.getSupervivientes().get(i).devolverCoordenada();
            }
        }
        return cercano;
    }
    public void atacar(){
        /**
         * Ataca al superviviente, se debe comprobar antes de llamarse
         */
        int i = 0;
        boolean atacado = false;
        do{ 
            // bucle para sacar el superviviente al que hay que atacar
            if(this.devolverCoordenada().equals(Juego.getSupervivientes().get(i).devolverCoordenada()) && Juego.getSupervivientes().get(i).isVivo() ){
                atacado = true;
            }else{
                // Si no encuentra al superviviente avanza la posicion de la lista
                i++;
            }
        }while((i < Juego.getSupervivientes().size()) && !(atacado));
        if(i < Juego.getSupervivientes().size() && atacado && Juego.getSupervivientes().get(i).isVivo()){
            Juego.getSupervivientes().get(i).setHeridas(Juego.getSupervivientes().get(i).getHeridas()+ 1);
            VentanaJuego.textoSeg.append(Juego.getSupervivientes().get(i).getNombre() + " tiene " + Juego.getSupervivientes().get(i).getHeridas() + " heridas\n");
        }
        if(Juego.getSupervivientes().get(i).getHeridas() == 2){
            Juego.getSupervivientes().get(i).morir();
            VentanaJuego.textoSeg.append(Juego.getSupervivientes().get(i).getNombre() + " ha muerto\n");
        }
    }
    public void moverse(){
        /**
         * Movimiento del zombi, la idea es que persiga al jugador aka 0 neuronas
         */
        Punto superviviente = this.supervivienteCercano(); // obtenemos el punto mas cercano
        int x = superviviente.getX() - this.devolverCoordenada().getX();
        int y = superviviente.getY() - this.devolverCoordenada().getY();
        if(Math.abs(x) > Math.abs(y)){ // se va a mover en X
            //Ejes cartesianos
            if(x > 0){
                this.devolverCoordenada().setX(this.devolverCoordenada().getX()+1);
            }else{
                this.devolverCoordenada().setX(this.devolverCoordenada().getX()-1);
            }
        }else{ //se va a mover en Y
            if(y > 0){
                this.devolverCoordenada().setY(this.devolverCoordenada().getY()+1);
            }else{
                this.devolverCoordenada().setY(this.devolverCoordenada().getY()-1);
            }
        }
    }
    
    public abstract void reaccion(Superviviente superviviente , EArmas arma);
    public abstract String obtenerTipo();
    public abstract String obtenerTipo2();

        
}
