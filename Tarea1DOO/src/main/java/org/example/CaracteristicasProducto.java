package org.example;

/**
 * Enumeración que representa diferentes productos con sus características asociadas.
 */
public enum CaracteristicasProducto {
    SPRITE(400),
    COCACOLA(450),
    FANTA(500),
    SUPER8(800),
    SNICKERS(1000);
    /**
     * Precio asociado al producto.
     */
    private final int precio;

    /**
     * Constructor privado para inicializar el precio y el índice del producto.
     * @param precio El precio del producto en centavos.
     */
    CaracteristicasProducto(int precio) {
        this.precio = precio;
    }
    /**
     * Obtiene el precio del producto.
     * @return El precio del producto.
     */
    public int getPrecio() {
        return precio;
    }

}
