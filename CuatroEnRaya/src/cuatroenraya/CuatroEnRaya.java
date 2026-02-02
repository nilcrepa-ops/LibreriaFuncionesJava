//TODO:
//Crear repo en github y subirlo
//Logica del juego
package cuatroenraya;

import java.util.Scanner;

public class CuatroEnRaya {

    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        boolean jugando = true;
        char[][] tablero = new char[6][7];

        while (jugando) {
            mostrarIntro();
            
            imprimirTablero(tablero);
            
            
            
            //Esta SIEMPRE al final
            jugando = menuSalida();

        }
    }
    //FUNCIONES

    //Introduccion al juego
    public static void mostrarIntro() throws InterruptedException {
        String[] intro = {"CUATRO EN RAYA por NIL CREUS",
            "Para empezar, busca un amigo (si lo tienes)",
            "Trata de alinear CUATRO piezas en el tablero",
            "Puede ser de forma vertical u horizontal.",
            "Jugador 1 usa la ficha '1'. Jugador 2 usa la ficha '2'",
            "Estais preparados? Que entre el tablero!"};
        for (int i = 0; i < intro.length; i++) {
            System.out.println(intro[i]);
            Thread.sleep(1500);
        }
    }

    //Crear tablero de juego
    public static void imprimirTablero(char tablero[][]) {
        //Creamos, rellenamos y mostramos el tablero de juego
        int rows = 6;
        int cols = 7;
        tablero = new char[rows][cols];

        for (int i = 0; i < cols; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < tablero.length; i++) {

            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = 'O';
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    //Pedir jugada al jugador 1
//    public static int pedirJugada1(){
//        
//    }
    
    
    //Pedir jugada al jugador 2
    

    //Para detener el bucle principal
    public static boolean menuSalida() {
        boolean bool = true;
        System.out.print("Otra ronda? (S/N): ");
        char resp = sc.next().toLowerCase().charAt(0);

        if (resp == 'n') {
            return false;
        } else if (resp != 's') {
            System.out.println("Respuesta incorrecta, pulsa S/N.");
        }
        return true;
    }

}
