package org.example;

class Comprador {
    private String sonido;
    private int vuelto;
    private Producto producto;

    public Comprador(Moneda m, CaracteristicasProducto CualProducto, Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        vuelto = 0;
        sonido = null;

        try {
            producto = exp.comprarProducto(m, CualProducto);
            sonido = producto.consumirlo();
            //AQUÍ SE DEBE IMPLEMENTAR CODIGO PARA OBTENER EL VUELTO (vaciar monedero).
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            throw e;
        }
    }

    public int cuantoVuelto(){
        return vuelto;
    }

    public String queBebiste(){
        return sonido;
    }
}
