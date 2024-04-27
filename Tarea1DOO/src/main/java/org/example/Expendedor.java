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

    /**
     * Realiza la compra de un producto utilizando una moneda dada y especificaciones del producto.
     *
     * @param m               La moneda utilizada para la compra.
     * @param cualProducto    Las características del producto que se desea comprar.
     * @return El producto comprado, si la transacción es exitosa.
     * @throws PagoIncorrectoException    Si la moneda pasada como parámetro es nula.
     * @throws NoHayProductoException     Si las características del producto son nulas o el producto deseado no está disponible.
     * @throws PagoInsuficienteException  Si la moneda pasada como parámetro no tiene un valor suficiente para comprar el producto.
     */
    public Producto comprarProducto(Moneda m, CaracteristicasProducto cualProducto) throws PagoIncorrectoException,NoHayProductoException,PagoInsuficienteException{

        //Excepcion moneda es null
        if (m==null) {
            throw new PagoIncorrectoException();
        }

        //Excepcion cualProducto es null.
        if ( cualProducto==null ) {
            monedero.addObject(m);
            throw new NoHayProductoException();
        }

        Producto p;

        // Comprobar si el precio del producto es mayor que el valor de la moneda
        if (m.compareTo(cualProducto.getPrecio()) < 0) {
            //En caso que la moneda no alcance para comprar el producto, se le devuelve la misma
            monedero.addObject(m);
            // Lanzar excepción si el valor de la moneda es insuficiente
            throw new PagoInsuficienteException();

        } else {
            // Obtener el índice del producto
            int indiceProducto = cualProducto.getIndex();

            // Obtener el producto correspondiente según el índice
            switch (indiceProducto) {
                case 1:
                    p = sprite.getObject();
                    break;
                case 2:
                    p = coca.getObject();
                    break;
                case 3:
                    p = fanta.getObject();
                    break;
                case 4:
                    p = super8.getObject();
                    break;
                case 5:
                    p = snickers.getObject();
                    break;
                default:
                    monedero.addObject(m);
                    throw new NoHayProductoException();

            }

            // Si se encuentra el producto en el depósito, agregar monedas de 100 hasta alcanzar el vuelto correspondiente
            if (p!=null) {
                for (int i = 0; i < m.compareTo(cualProducto.getPrecio()); i += 100) {
                    monedero.addObject(new Moneda100());
                }
            } else {
                monedero.addObject(m);
                throw new NoHayProductoException();
            }
        }
        return null;
    }


    public Moneda getVuelto(){
        return monedero.getObject();
    }
}
