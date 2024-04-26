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
            Producto b4 = new Snicker(400+i);
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
    public Producto comprarProducto(Moneda m, Precio cualProducto){
        Producto p ;
        Moneda m100 ;
        if(m != null) {
            if(cualProducto != null){
                if(cualProducto.getPrecio() < m.getValor()){
                    //Exception pago insuficiente
                    //meter en el monedero la moneda con que se pago
                }
                else{
                    switch (cualProducto){
                        case COCACOLA :
                            p = coca.getObject();
                            break;
                        case SPRITE:
                            p = sprite.getObject();
                            break;
                        case FANTA :
                            p = fanta.getObject();
                            break;
                        case SNICKERS:
                            p = snickers.getObject();
                            break;
                        case SUPER8:
                            p = super8.getObject();
                            break;
                        default:
                            //Excepcion no hay producto
                            break;

                    }
                    if (p!=null){
                        //sacar el vuelto aqui y meterla en monedero
                        //m = null
                    }
                    else{
                        //Excepcion no quedan productos de ese tipo.
                    }
                }
            }
            else{ /*excepcion aca (no se escogio un product que exista) (no hay proucto*/}
        }
        else {
            //Aca una excepcion por no entregar moneda
        }

    }
    /*Metodo para devolver el vuelto guardado*/
    public Moneda getVuelto(){
        return monedero.getObject();
    }
}
