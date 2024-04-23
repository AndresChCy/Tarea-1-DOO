package org.example;

class Comprador {
    private String sonido;
    private int vuelto  ;
    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        vuelto = 0;
        sonido = null;
        Moneda m2;
        Bebida b= exp.comprarBebida(m,cualBebida);
        if (b != null) sonido = b.beber() ;
        while(true){
            m2 = exp.getVuelto();
            if(m2 == null){
                break;
            }
            if (m2 != null ){
                vuelto = vuelto + m2.getValor();
            }
        }
    }
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
        return sonido;
    }
}
