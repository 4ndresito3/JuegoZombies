/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

/**
 *
 * @author j.perezm.2022
 */
public class ZAbominacionToxico extends ZAbominacion{
    
    public ZAbominacionToxico() {
        super();
    }
    
    public ZAbominacionToxico(Punto posicion, boolean vivo) {
        super();
        this.setPosicion(posicion);
        this.setVivo(vivo);
    }
    
    @Override
    public void reaccion(Superviviente superviviente , EArmas arma){
        if (arma.getPotencia() >= this.getAguante()){
            for(int i=0; i<Juego.getSupervivientes().size(); i++){
                if(Juego.getSupervivientes().get(i).devolverCoordenada().equals(this.devolverCoordenada()) && Juego.getSupervivientes().get(i).isVivo()){
                    Juego.getSupervivientes().get(i).setHeridas(Juego.getSupervivientes().get(i).getHeridas()+1);
                    VentanaJuego.textoSeg.append(Juego.getSupervivientes().get(i).getNombre() + " tiene " + Juego.getSupervivientes().get(i).getHeridas() + " heridas\n");
                } 
               if(Juego.getSupervivientes().get(i).getHeridas() == 2 && Juego.getSupervivientes().get(i).isVivo()){
                    Juego.getSupervivientes().get(i).morir();
                    if(Juego.getSupervivientes().get(i).equals(Juego.obtenerJugadorActual()) && Juego.obtenerJugadorActual().getNumAcciones()>0){
                        VentanaJuego.pasarTurnoJugador();
                    }  
                    
                    VentanaJuego.textoSeg.append(Juego.getSupervivientes().get(i).getNombre() + " ha muerto\n");
                }
            }       
            this.morir();
            VentanaJuego.textoSeg.append(" " + this.obtenerTipo() + " ha muerto\n");
            superviviente.setExitos(superviviente.getExitos()-1);
        }else{
            VentanaJuego.textoSeg.append(" " + this.obtenerTipo2() + " sigue vivo\n");
            VentanaJuego.textoSeg.append(" tiene aguante " + this.getAguante() + "\n");
        }
    }
    @Override
    public String obtenerTipo(){
        return "ZAbominacionToxico";
    }
    @Override
    public String obtenerTipo2(){
        return "ZAbToxico";
    }
}
