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
    @Override
    public void reaccion(Superviviente superviviente , EArmas arma){
        if (arma.getPotencia() >= this.getAguante() && arma.getAlcanceMax() == 0){
            this.morir();
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