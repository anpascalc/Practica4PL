package org.example;

public class AutomataFinitoMatriz extends AutomataFinito{
    private int [] [] matriz;

    public AutomataFinitoMatriz(int num, int alfabeto) {
        super(num, alfabeto);
    }
    public AutomataFinitoMatriz(int num, int alfabeto, boolean [] finales) {
        super(num, alfabeto, finales);
    }
    public AutomataFinitoMatriz(int num, int alfabeto,int[][] matriz, boolean[] finales) {
        super(num, alfabeto, finales);
        this.matriz=matriz;
    }

    @Override
    public int transicion(int estado, int letra) {
        int transition = this.matriz[estado][letra];
        if(transition == -1) {
            return 0;
        } else {
            return transition;
        }
    }

    public int transicionActual(int row, int col) {
        return this.matriz[row][col];
    }

    @Override
    public int cierreTransicion(int estado, int[] cad) {
        int res = -1;
        if(cad.length>0) {
            res = transicion(estado, cad[0]);
            for(int i = 1; i < cad.length; i++) {
                res = transicion(estado, cad[i]);
            }
        }
        return res;
    }

    @Override
    public boolean perteneceLenguaje(int[] cad) {
        int n = cierreTransicion(0,cad);
        if(n != -1) {
            return super.getFinales()[n];
        } else {
            return false;
        }
    }

    @Override
    public int[] ultimoFinal(int[] cad) {
        int posicionUltimoFinal = -1;
        int estado = 0;
        int res = -1;

        for (int i = 0; i < cad.length; i++) {
            estado = transicionActual(estado, cad[i]);

            if (estado != -1) {
                if (esEstadoFinal(estado)) {
                    res = estado;
                    posicionUltimoFinal = i;
                }
            } else {
                break;
            }
        }
        int[] ultFinalPos = { res, posicionUltimoFinal };
        return ultFinalPos;
    }

    @Override
    public String getMatriz() {
        String s = "";
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                s +=this.matriz[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }
}
