/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

/**
 *
 * @author j.perezm.2022
 */
public class ZCorredorBerserker  extends ZCorredor{
    
    public ZCorredorBerserker() {
        super();
    }
    
    public ZCorredorBerserker(Punto posicion, boolean vivo) {
        super();
        this.setPosicion(posicion);
        this.setVivo(vivo);
    }
    @Override
    public void reaccion(Superviviente superviviente , EArmas arma){
        if (arma.getPotencia() >= this.getAguante() && arma.getAlcanceMax() == 0){
            this.morir();
            VentanaJuego.textoSeg.append(" " + this.obtenerTipo() + " ha muerto\n");
            superviviente.setExitos(superviviente.getExitos()-1);
        }
        else{
            VentanaJuego.textoSeg.append(" " + this.obtenerTipo2() + " sigue vivo\n");
            if(arma.getPotencia() < this.getAguante()){
                VentanaJuego.textoSeg.append(" tiene aguante " + this.getAguante() + "\n");
            }
            if(arma.getAlcanceMax()!=0){
                VentanaJuego.textoSeg.append(" Este zombie es inmune\n");
                VentanaJuego.textoSeg.append(" a ataques a distancia\n");
            }
        }
    }
    @Override
    public String obtenerTipo(){
        return "ZCorredorBerserker";
    }
    @Override
    public String obtenerTipo2(){
        return "ZCoBerserker";
    }
}