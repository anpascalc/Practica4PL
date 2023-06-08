package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Token {
    private Map<String, Integer> tokenMap;

    public Token() {
        this.tokenMap = new HashMap<String, Integer>();
    }

    public Token(String id, int lex) {
        this.tokenMap = new HashMap<String, Integer>();
        this.tokenMap.put(id,lex);
    }

    public String getId() {
        return this.tokenMap.keySet().toString();
    }

    public String getLexema() {
        return this.tokenMap.values().toString();
    }

    public String getValue(Integer i) {
        String s="";
        for(Entry<String, Integer> entry : this.tokenMap.entrySet()) {
            if(entry.getValue()==i) {
                s= entry.getKey();
                break;
            }
        }
        return s;
    }

    //Redefinicion del metodo toString
    public String toString() {
        String cadena = "";
        for(String s : tokenMap.keySet()) {
            s = "Id: " + s + " " + tokenMap.get(s) + "\n";
        }
        return cadena;
    }

    //Metodo que hace de "wrapper" del metodo put, para meter nuevos tokens
    public void addToken(String s, Integer i) {
        this.tokenMap.put(s,i);
    }
}