package org.example;
import java.util.ArrayList;

class Deposito {
    private ArrayList<Bebida> al;
    public Deposito(){
        al = new ArrayList();
    }
    public void addBebida(Bebida b){
        al.add(b);
    }
    public Bebida getBebida(){
        if (al.size() != 0) {
            Bebida b = al.remove(0);
            return b;
        }
        return null;
    }
}
