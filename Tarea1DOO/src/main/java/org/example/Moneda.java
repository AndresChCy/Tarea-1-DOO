package org.example;

/**
 * La clase abstracta Moneda representa una moneda genérica.
 */
abstract class Moneda {
    /**
     * Constructor vacío de la clase Moneda.
     */
    public Moneda(){}
    /**
     * Método para obtener el número de serie de la moneda.
     * @return La serie de la moneda.
     */
    public Moneda getSerie(){
        return this ;
    }
    /**
     * Método abstracto para obtener el valor de la moneda.
     * @return El valor de la moneda.
     */
    public abstract int getValor();
    /**
     * Compara la moneda con un valor dado.
     * @param precio El precio a comparar.
     * @return Un entero que indica la diferencia entre el valor de la moneda y el precio dado.
     */
    public int comparaMoneda(int precio) {
        return this.getValor() - precio;
    }
}