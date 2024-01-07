/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;

/**
 *
 * @author s.anton.2022
 */
public class Punto {
    private int coordenadaX;
    private int coordenadaY;
    
    public Punto(){
        this.coordenadaX = 0;
        this.coordenadaY = 0;
    }
    public Punto(int x,int y){
       
        this.coordenadaX = x;
        this.coordenadaY = y;
        
    }
    
    public int getX(){
        return this.coordenadaX;
    }
    public int getY(){
        return this.coordenadaY;
    }
    public void setX(int x){
        this.coordenadaX = x;
    }
    public void setY(int y){
        this.coordenadaY = y;
    }
    @Override
    public String toString() {
        return this.coordenadaX + "," + this.coordenadaY;
    }
    
    public Punto parsePunto(String stringPunto) {
        String[] puntoString = stringPunto.split(",");
        //Punto punto = new Punto(Integer.parseInt(puntoString[0]), Integer.parseInt(puntoString[1]));
        this.coordenadaX = Integer.parseInt(puntoString[0]);
        this.coordenadaY = Integer.parseInt(puntoString[1]);
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.coordenadaX;
        hash = 17 * hash + this.coordenadaY;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Punto other = (Punto) obj;
        return this.coordenadaY == other.coordenadaY && this.coordenadaX == other.coordenadaX;
    }

    
    
    public Punto copia(){
        Punto puntito = new Punto(this.coordenadaX,this.coordenadaY);
        return puntito;
    }
}
