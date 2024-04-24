package org.example;

abstract class Bebida extends Producto {
    private int serie;

    public Bebida(int a){
        serie = a;
    }
    public int getSerie(){
        return serie;
    }
    public abstract String beber();
}

