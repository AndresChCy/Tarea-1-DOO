package org.example;
/**
 * Enumeración que representa diferentes productos con su precio asociado.
 */
public enum Precio {
    SPRITE(500), COCACOLA(500), FANTA(500), SUPER8(1000), SNICKERS(1000);
    /**
     * Precio asociado al producto.
     */
    private int precio;
    /**
     * Constructor privado para inicializar los valores del producto.
     * @param precio El precio del producto.
     */
    private Precio(int precio) {
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