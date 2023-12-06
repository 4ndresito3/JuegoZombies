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
    
    public Punto supervivienteCercano(){
        Punto cercano = new Punto();
        double distancia;
        int x0 = Juego.getSupervivientes().get(0).devolverCoordenada().getX() - this.devolverCoordenada().getX();
        int y0 = Juego.getSupervivientes().get(0).devolverCoordenada().getY() - this.devolverCoordenada().getY();
        distancia = Math.sqrt(x0^2 + y0^2);
        for (int i = 0; i < Juego.getSupervivientes().size(); i++){
            int x = Juego.getSupervivientes().get(i).devolverCoordenada().getX() - this.devolverCoordenada().getX();
            int y = Juego.getSupervivientes().get(i).devolverCoordenada().getY() - this.devolverCoordenada().getY();
            double auxDistancia = Math.sqrt(x^2 + y^2);
            if(distancia > auxDistancia){
                distancia = auxDistancia;
                cercano = Juego.getSupervivientes().get(i).devolverCoordenada();
            }

        }
        return cercano;
    }

    @Override
    public void atacar(){
        int i = 0;
        do{ // bucle para sacar el superviviente al que hay que atacar

        }while(i < Juego.getSupervivientes().size());
    }
    @Override 
    public void morir(){
        Juego.getZombis().remove(this);
    }

    @Override
    public void moverse(){
        Punto superviviente = this.supervivienteCercano(); // obtenemos el punto mas cercano
        int x = superviviente.getX() - this.devolverCoordenada().getX();
        int y = superviviente.getY() - this.devolverCoordenada().getY();
        if(Math.abs(x) > Math.abs(y)){ // se va a mover en X
            if(x > 0){
                this.devolverCoordenada().setX(this.devolverCoordenada().getX()-1);
            }else{
                this.devolverCoordenada().setX(this.devolverCoordenada().getX()+1);
            }
        }else{ //se va a mover en Y
            if(y > 0){
                this.devolverCoordenada().setY(this.devolverCoordenada().getY()-1);
            }else{
                this.devolverCoordenada().setY(this.devolverCoordenada().getY()+1);
            }
        }
    }
    
    public abstract void reaccion(EArmas arma);
}
