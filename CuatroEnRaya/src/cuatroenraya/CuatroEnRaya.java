//TODO:
//Crear repo en github y subirlo
//Logica del juego

package cuatroenraya;

import java.util.Scanner;

public class CuatroEnRaya {

    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean jugando = true;
        char resp = ' ';
        
        while (jugando) {
            System.out.println("CAUTRO EN RAYA por NIL CREUS");
            
            //Creamos, rellenamos y mostramos el tablero de juego
            int rows = 6;
            int cols = 7;
            char[][] tablero = new char[rows][cols];
            
            System.out.print("  ");
            for (int i = 0; i < cols; i++) {
                System.out.print((char) ('a' + i) + " ");
            }
            System.out.println();
            
            for (int i = 0; i < tablero.length; i++) {
                System.out.print((i +1) + " ");
                for (int j = 0; j < tablero[i].length; j++) {
                    tablero[i][j] = 'o';
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }
            
            //Esta SIEMPRE al final
            jugando = menuSalida();

        }
    }
    //FUNCIONES
    
    //Para detener el bucle principal
    public static boolean menuSalida() {
        boolean bool = true;
        System.out.print("Otra ronda? (S/N): ");
        char resp = sc.next().toLowerCase().charAt(0);
        
        if (resp == 'n') {
            return false;
        } else if (resp!= 's'){
            System.out.println("Respuesta incorrecta, pulsa S/N.");
        }
        return true;
    }
        
}
