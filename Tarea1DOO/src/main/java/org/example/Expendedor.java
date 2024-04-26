package org.example;
import javax.swing.plaf.ProgressBarUI;

/*Un expendedor al que le puedes comprar productos usando monedas*/
class Expendedor {

    /*Creamos un deposito para cada elemento necesario para el expendedor*/
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snickers;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monedero;

    /*Metodo constructor que rellena sus depositos para productos de forma magica*/
    public Expendedor(int NumProductos){
        monedero = new Deposito<>();
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snickers = new Deposito<>();
        super8 = new Deposito<>();
        for(int i=0 ; i<NumProductos;i++){
            coca.addObject(new CocaCola(100+i));
            sprite.addObject(new Sprite(200+i));
            fanta.addObject(new Fanta(300+i));
            snickers.addObject(new Snicker(400+i));
            super8.addObject(new Super8(500+i));
        }
    }

    /*Metodo para comprar productos
    Te devolvera el producto en caso de que pagues lo que corresponde
    Si pagas de mas creara magicamente monedas de 100 que despues te dara de vuelto
    Si pagas menos te devolvera la moneda que usaste
    Sino pagas entonces no ocurrira nada.
     */
    public Producto comprarProducto(Moneda m, Precio cualProducto) throws PagoIncorrectoException,NoHayProductoException,PagoInsuficienteException{

        //Excepcion moneda es null
        if (m==null) {
            throw new PagoIncorrectoException();
        }

        //Excepcion cualProducto es null.
        if ( cualProducto==null ) {
            throw new NoHayProductoException();
        }

        Producto p;
        Moneda m100;

        if (cualProducto.getPrecio() < m.getValor()) {
            //AQUÍ SE DEBE IMPLEMENTAR LLENAR EL MONEDERO, IGUAL AL VALOR DE LA MONEDA.
            //PARA DESPUÉS OBTENER EL VUELTO.
            throw new PagoInsuficienteException();
        } else {
            switch (cualProducto) {
                case COCACOLA:
                    p = coca.getObject();
                    break;
                case SPRITE:
                    p = sprite.getObject();
                    break;
                case FANTA:
                    p = fanta.getObject();
                    break;
                case SNICKERS:
                    p = snickers.getObject();
                    break;
                case SUPER8:
                    p = super8.getObject();
                    break;
                default:
                    throw new NoHayProductoException();

            }

            if (p!=null) {
                //AQUÍ SE DEBE IMPLEMENTAR LLENAR EL MONEDERO, IGUAL
                //A LA RESTA DEL VALOR DE LA MONEDA CON EL PRECIO DEL PRODUCTO.
            } else {
                throw new NoHayProductoException();
            }
        }
        return null;
    }


    public Moneda getVuelto(){
        return monedero.getObject();
    }
}
