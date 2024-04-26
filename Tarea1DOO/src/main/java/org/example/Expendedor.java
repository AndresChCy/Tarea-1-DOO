package org.example;

import javax.swing.plaf.ProgressBarUI;

/*Un expendedor al que le puedes comprar productos usando monedas*/
class Expendedor {

    private int precio;
    /*Creamos un deposito para cada elemento necesario para el expendedor*/
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snickers;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monedero;
    public static final int  COCA=1;
    public static final int  SPRITE=2;
    /*Metodo constructor que rellena sus depositos para productos de forma magica*/
    public Expendedor(int a, int precioBebidas){
        monedero = new Deposito<>();
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snickers = new Deposito<>();
        super8 = new Deposito<>();
        precio = precioBebidas;
        for(int i=0 ; i<a;i++){
            Producto b = new CocaCola(100+i);
            Producto b2 = new Sprite(200+i);
            Producto b3 = new Fanta(300+i);
            Producto b4 = new Snickers(400+i);
            Producto b5 = new Super8(500+i);
            coca.addObject(b);
            sprite.addObject(b2);
            fanta.addObject(b3);
            snickers.addObject(b4);
            super8.addObject(b5);
        }
    }
    /*Metodo para comprar productos
    Te devolvera el producto en caso de que pagues lo que corresponde
    Si pagas de mas creara magicamente monedas de 100 que despues te dara de vuelto
    Si pagas menos te devolvera la moneda que usaste
    Sino pagas entonces no ocurrira nada.
     */
    public Bebida comprarBebida(Moneda m, int a){
        if(m != null) {
            Moneda m100;
            Bebida b;
            if (precio <= m.getValor()) {
                if (a == Expendedor.COCA) {
                    b = coca.getObject();
                } else if (a == Expendedor.SPRITE) {
                    b = sprite.getObject();
                } else {
                    for (int i = 0; i < m.getValor(); i = i + 100) {
                        m100 = new Moneda100();
                        monedero.addObject(m100);
                    }
                    return null;
                }
                if (b != null) {
                    for (int i = 0; i < m.getValor()-precio; i = i + 100) {
                        m100 = new Moneda100();
                        monedero.addObject(m100);
                    }
                    return b;
                }
                else {
                    for (int i = 0; i < m.getValor(); i = i + 100) {
                        m100 = new Moneda100();
                        monedero.addObject(m100);
                    }
                    return null;
                }
            }
            else {
                for (int i = 0; i < m.getValor(); i = i + 100) {
                    m100 = new Moneda100();
                    monedero.addObject(m100);
                }
            }
        }
        return null;
    }
    /*Metodo para devolver el vuelto guardado*/
    public Moneda getVuelto(){
        return monedero.getObject();
    }
}
