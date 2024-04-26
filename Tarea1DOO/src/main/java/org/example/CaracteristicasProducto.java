package org.example;

/**
 * Enumeración que representa diferentes productos con sus características asociadas.
 */
public enum CaracteristicasProducto {
    SPRITE(500, 1),
    COCACOLA(500, 2),
    FANTA(500, 3),
    SUPER8(1000, 4),
    SNICKERS(1000, 5);
    /**
     * Precio asociado al producto.
     */
    private final int precio;
    /**
     * Índice único asociado al producto.
     */
    private final int index;
    /**
     * Constructor privado para inicializar el precio y el índice del producto.
     * @param precio El precio del producto en centavos.
     * @param index El índice único del producto.
     */
    CaracteristicasProducto(int precio, int index) {
        this.precio = precio;
        this.index = index;
    }
    /**
     * Obtiene el precio del producto.
     * @return El precio del producto.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Obtiene el índice único asociado al producto.
     * @return El índice único del producto.
     */
    public int getIndex() {
        return index;
    }
}
