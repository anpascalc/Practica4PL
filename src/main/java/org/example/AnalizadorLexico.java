package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AnalizadorLexico {

    private Token tokens;
    private List<Token> historico;
    private AutomataFinito automata;
    private int[] cadenaParaAnalizar;
    private int posActual;

    public AnalizadorLexico(AutomataFinito auto, int[] cad, Token tokenMap) {
        this.posActual 				= 0;
        this.automata				= auto;
        this.cadenaParaAnalizar		= cad;
        this.tokens					= tokenMap;
        this.historico				= new ArrayList<Token>();
    }

    public boolean hasMoreTokens() {
        return (this.automata.getNumEstados()>this.historico.size());
    }

    public List<Token> getHistorico(){
        return this.historico;
    }
    public void reset() {
        this.posActual=0;
        this.historico.clear();
    }
    public void resetAnalisis(int[] newCadena) {
        this.posActual=-1;
        this.historico=null;
        this.cadenaParaAnalizar = newCadena;
    }
    public void analisis() {
        boolean t = true;
        while (t) {
            t = nextToken();
        }

    }
    public void nuevaCadena(int[] cadenaNueva) {
        this.cadenaParaAnalizar = cadenaNueva;
        reset();
    }

    public boolean nextToken(){

        if (posActual >= cadenaParaAnalizar.length) {
            return false;
        } else {
            int[] arrayAux = Arrays.copyOfRange(cadenaParaAnalizar, posActual, cadenaParaAnalizar.length);
            int[] arrayAux2 = automata.ultimoFinal(arrayAux);

            if (arrayAux2[0] == -1 && arrayAux2[1] == -1) {
                return false;
            } else {
                int finalState = arrayAux2[0];
                posActual += arrayAux2[1];
                String value = tokens.getValue(finalState);
                historico.add(new Token(value, finalState));
                return true;
            }
        }


        }
    }

