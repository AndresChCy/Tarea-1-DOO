package org.example;

/**
 * Superclase abstracta que representa una moneda.
 */
abstract class Moneda implements Comparable<Integer>{
    /**
     * Constructor por defecto de la clase Moneda.
     */
    public Moneda(){}
    /**
     * Método para obtener la serie de la moneda.
     * @return La instancia actual de la moneda.
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
     * Método para comparar el valor de la moneda con un precio dado.
     * @param valor El precio a comparar.
     * @return Un valor negativo si el valor de la moneda es menor que el precio,
     *         cero si son iguales, o un valor positivo si el valor de la moneda es mayor.
     */
    public int compareTo(int valor) {
        return Integer.compare(this.getValor(), valor);
    }
}
