package org.example;

public abstract class AutomataFinito {
    private int numEstados;
    private boolean[] finales;
    private int tamAlfabeto;
    private int estActual;

    public AutomataFinito (int num, int alfabeto){
        this.numEstados = num;
        this.tamAlfabeto = alfabeto;

    }
    public AutomataFinito (int num, int alfabeto, boolean [] finales){
        this.numEstados = num;
        this.tamAlfabeto = alfabeto;
        this.finales = finales;
    }
    public void marcarFinal(int estado){
        this.finales[estado] = true;
    }
    public void setFinales(boolean[] estadosFinales){
        this.finales = estadosFinales;
    }
    public int getNumEstados(){
        return this.numEstados;
    }
    public boolean[] getFinales(){
        return this.finales;
    }
    //Método observador para determinar si un estado es final
    public boolean esEstadoFinal (int estado){
        return this.finales[estado];
    }
    /*Método de transición. Se puede pensar como método que informa del estado que se alcanza partiendo de un estado y recibiendo una entrada*/
    public abstract int transicion (int estado, int letra);

    //La extensión de la transición a cadenas. Posible versión void si transición modifica el estado
    public abstract int cierreTransicion (int estado, int[] cad);
    //Método que informa si una cadena pertenece al lenguaje definido por el autómata
    public abstract boolean perteneceLenguaje (int[] cad);
}
