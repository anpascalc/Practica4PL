package org.example;

public class AutomataFinitoMatriz extends AutomataFinito{
    private int [] [] matriz;

    public AutomataFinitoMatriz(int num, int alfabeto) {
        super(num, alfabeto);
    }
    public AutomataFinitoMatriz(int num, int alfabeto, boolean [] finales) {
        super(num, alfabeto, finales);
    }

    @Override
    public int transicion(int estado, int letra) {
        return this.matriz[estado][letra];
    }

    @Override
    public int cierreTransicion(int estado, int[] cad) {
        return 0;
    }

    @Override
    public boolean perteneceLenguaje(int[] cad) {
        return false;
    }
}
