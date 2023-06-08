package org.example;

public class Main {

    public static void main(String[] args) {
        //Crear la matriz (Matriz es la que usas para crear el AutomataFinito)
        int[][] matrix = new int[9][3];

        matrix[0][0]=1;
        matrix[0][1]=2;
        matrix[0][2]=3;

        matrix[1][0]=4;
        matrix[1][1]=5;
        matrix[1][2]=-1;

        matrix[2][0]=-1;
        matrix[2][1]=5;
        matrix[2][2]=-1;

        matrix[3][0]=-1;
        matrix[3][1]=-1;
        matrix[3][2]=3;

        matrix[4][0]=6;
        matrix[4][1]=7;
        matrix[4][2]=-1;

        matrix[5][0]=-1;
        matrix[5][1]=5;
        matrix[5][2]=-1;

        matrix[6][0]=6;
        matrix[6][1]=5;
        matrix[6][2]=-1;

        matrix[7][0]=-1;
        matrix[7][1]=8;
        matrix[7][2]=-1;

        matrix[8][0]=-1;
        matrix[8][1]=5;
        matrix[8][2]=-1;

        //Crear la tabla (Map que es la tabla que defines y le pasas al analizador lexico)
        Token table = new Token();
        table.addToken("CERO", 1);		//B
        table.addToken("UNO", 2);		//C
        table.addToken("CUATRO", 3);	//D
        table.addToken("TRES", 5);		//F
        table.addToken("TRES", 7);		//H
        table.addToken("DOS", 8);		//I

        //Ahora indicamos que estados son los finales
        boolean[] estadosFinales = new boolean[9];
        //No finales segun el automata convertido a determinista son B,C,D,F,H e I
        estadosFinales[0]=false;	//A
        estadosFinales[1]=true;		//B
        estadosFinales[2]=true; 	//C
        estadosFinales[3]=true; 	//D
        estadosFinales[4]=false; 	//E
        estadosFinales[5]=true; 	//F
        estadosFinales[6]=false; 	//G
        estadosFinales[7]=true; 	//H
        estadosFinales[8]=true; 	//I

        //Creamos el automata usando la matriz, la tabla y los finales que acabamos de definir
        //9 es el numero de estados
        AutomataFinito auto = new AutomataFinitoMatriz(9, 3, matrix, estadosFinales);
        //Check1
        //System.out.println("Llego check 1 "+"\n" + auto.getMatriz());

        System.out.println("Analisis de la cadena acbaabbc");
        int[] cadena = {0,2,1,0,0,1,1,2};

        //Creamos el Analizador Lexico
        AnalizadorLexico analizador = new AnalizadorLexico(auto, cadena, table);

        //Hacemos el analisis
        analizador.analisis();

        //Sacamos por pantalla el resultado, que seria el historico del analisis
        String historico = "[" + "\n";
        for(Token t : analizador.getHistorico()) {
            if(t != null) {
                historico += t.getId() + "\n";
            }
        }
        historico += " ]";
        System.out.println(historico);
        //Por ultimo reseteamos el analizador
        analizador.reset();

    }
    public String toString(int[] vectorInts) {
        //Tiene que traducir el vector de enteros a un String
        String cadena = "";
        for(int i : vectorInts) {
            cadena += i;
        }
        return cadena;
    }
}