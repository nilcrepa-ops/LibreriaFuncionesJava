//TODO:
//Acabar de afinar todas las funciones relacionadas con el fakin tablero
package cuatroenraya;

import java.util.Scanner;

public class CuatroEnRaya {

    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        boolean jugando = true;
        char ficha = ' ';
        int rows = 6;
        int cols = 7;
        char[][] tablero = new char[rows][cols];
        int jugada = 0;
        while (jugando) {
            mostrarIntro();

            imprimirTablero(tablero);
            System.out.println("Turno de Jugador 1");
            //Llamar a pedirJugada
            jugada = pedirJugada();
            //Mostrar jugada
            actualizarTablero(tablero, jugada, '1');

            System.out.println("Turno de Jugador 2");
            //Llamar a pedirJugada
            jugada = pedirJugada();
            //Mostrar jugada
            actualizarTablero(tablero, jugada, '2');
            
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
    public static void imprimirTablero(char tablero[][]) { //SOLO muestra el tablero al principio
        char elemento = 'O';
        for (int i = 0; i <= tablero.length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < tablero.length; i++) {

            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(elemento + " ");
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Pedir jugada al jugador
    public static int pedirJugada() {
        int jugada = 0;
        while (jugada < 1 || jugada > 7) {
            System.out.print("Elige donde tirar la ficha (1-7): ");
            jugada = sc.nextInt();
            if (jugada < 1 || jugada > 7) {
                System.out.println("Esa columna no existe genio");
            }
        }
        return jugada;
    }
    //Meter jugada en el tablero
    public static void actualizarTablero(char tablero[][], int jugada, char ficha) {
        int columna = jugada -1;
        char fichaJug = ficha; //Puede ser '1' o '2', lo establezco por parametro
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[columna].length; j++) {
                if (tablero[i][columna] == 'O') {
                    tablero[i][columna] = fichaJug;
                }
            }
        }
    }
    
    //Mostrar la jugada
    public static void mostrarTablero(char tablero[][], char ficha){
        char fichaJugador = ficha; //Puede ser '1' o '2', lo establezco por parametro
        for (int i = 0; i < tablero.length; i++) {
            
        }
    }

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
