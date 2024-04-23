package org.example;

abstract class Bebida {
    private int serie;

    public Bebida(int a){
        serie = a;
    }
    public int getSerie(){
        return serie;
    }
    public abstract String beber();
}

