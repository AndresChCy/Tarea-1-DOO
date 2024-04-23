package org.example;

class Expendedor {

    private int precio;
    private Deposito coca;
    private Deposito sprite;
    private DepositoM monedero;
    public static final int  COCA=1;
    public static final int  SPRITE=2;
    public Expendedor(int a, int precioBebidas){
        monedero = new DepositoM();
        coca = new Deposito();
        sprite = new Deposito();
        precio = precioBebidas;
        for(int i=0 ; i<a;i++){
            Bebida b = new CocaCola(100+i);
            Bebida b2 = new Sprite(200+i);
            coca.addBebida(b);
            sprite.addBebida(b2);
        }
    }
    public Bebida comprarBebida(Moneda m, int a){
        if(m != null) {
            Moneda m100;
            Bebida b;
            if (precio <= m.getValor()) {
                if (a == Expendedor.COCA) {
                    b = coca.getBebida();
                } else if (a == Expendedor.SPRITE) {
                    b = sprite.getBebida();
                } else {
                    for (int i = 0; i < m.getValor(); i = i + 100) {
                        m100 = new Moneda100();
                        monedero.addMoneda(m100);
                    }
                    return null;
                }
                if (b != null) {
                    for (int i = 0; i < m.getValor()-precio; i = i + 100) {
                        m100 = new Moneda100();
                        monedero.addMoneda(m100);
                    }
                    return b;
                }
                else {
                    for (int i = 0; i < m.getValor(); i = i + 100) {
                        m100 = new Moneda100();
                        monedero.addMoneda(m100);
                    }
                    return null;
                }
            }
            else {
                for (int i = 0; i < m.getValor(); i = i + 100) {
                    m100 = new Moneda100();
                    monedero.addMoneda(m100);
                }
            }
        }
        return null;
    }
    public Moneda getVuelto(){
        return monedero.getMoneda();
    }
}
