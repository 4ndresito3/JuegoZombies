/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

/**
 *
 * @author Andrés
 */
public class EProvisiones extends Equipo {
    private int valorEnergetico;
    private String caducidad;

    public EProvisiones(String nombre, int valorEnergetico) {
        this.setNombre(nombre);
        this.valorEnergetico = valorEnergetico;
        this.calcularFecha();
    }
    
    public int getValorEnergetico() {
        return this.valorEnergetico;
    }

    public void setValorEnergetico(int valorEnergetico) {
        this.valorEnergetico = valorEnergetico;
    }

    public String getCaducidad() {
        return this.caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }
    private void calcularFecha(){
        int mes = (int) (Math.random()*12+1);
        int ano = (int) (Math.random()*50+2023);
        int dia = (int) (Math.random()*30+1);
        if (mes == 2 && (ano%4 ==0 && (ano%100 != 0||ano%400 == 0))){
            dia = (int) (Math.random()*29+1);
        }else if (mes == 2){
            dia = (int) (Math.random()*28+1);
        }
        this.caducidad = dia + " / "+ mes+" / "+ano;
    }
    
}
