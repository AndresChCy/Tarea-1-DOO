package org.example;

/**
 * Subclase de Bebida que representa una Sprite.
 */
class Sprite extends Bebida {

    /**
     * Método constructor de Sprite que permite asignarle un número de serie.
     * @param numSerie Número que representa la serie del producto.
     */
    public Sprite(int numSerie) {
        super(numSerie);
    }

    /**
     * Método que es para representarse a sí mismo al consumirse.
     * @return String que dice que corresponde a una Sprite.
     */
    public String consumirlo(){
        return "Sprite";
    }
}
