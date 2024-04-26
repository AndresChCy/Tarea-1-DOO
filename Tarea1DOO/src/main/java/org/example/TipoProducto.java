package org.example;
/**
 * Enumeración que representa los diferentes productos con sus respectivos números asociados.
 */
public enum TipoProducto {
    SPRITE(1), COCACOLA(2), FANTA(3), SUPER8(4), SNICKERS(5);
    /**
     * Número asociado al producto.
     */
    private final int número;
    /**
     * Constructor privado para asociar un número a cada producto.
     * @param número El número asociado al producto.
     */
    TipoProducto(int número) {
        this.número = número;
    }
    /**
     * Obtiene el número asociado al producto.
     * @return el número asociado al producto.
     */
    public int getNúmero() {
        return número;
    }
}