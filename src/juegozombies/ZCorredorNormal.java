/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

/**
 *
 * @author j.perezm.2022
 */
public class ZCorredorNormal extends ZCorredor{
    
    public ZCorredorNormal() {
        super();
    }
    
    public ZCorredorNormal(Punto posicion, boolean vivo) {
        super();
        this.setPosicion(posicion);
        this.setVivo(vivo);
    }
    
    @Override
    public void reaccion(Superviviente superviviente , EArmas arma){
        if (arma.getPotencia() >= this.getAguante()){
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
        return "ZCorredorNormal";
    }
    @Override
    public String obtenerTipo2(){
        return "ZCoNormal";
    }
}
