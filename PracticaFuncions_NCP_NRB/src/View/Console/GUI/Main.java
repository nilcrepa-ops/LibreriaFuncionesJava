
package View.Console.GUI;

import Model.Validations.UserDataValidations;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        boolean funcionando = true;
        int answer = 0;
        int tipoDoc = 0;
        while (funcionando) {
            System.out.println("Biblioteca de funciones de Nil Creus y Nil Rivera. Cargando...");
            Thread.sleep(2000);
            UserDataValidations.mostrarOpciones();
            System.out.print("Elige una opcion: ");
            answer = sc.nextInt();
            sc.nextLine();//Vaciar buffer por si acaso. En case 8 se buguea si lo quito

            switch (answer) {
                case 1: //HECHO
                    System.out.println("1- DNI");
                    System.out.println("2- En proceso");
                    System.out.print("Introduce el tipo de documentacion a verificar: ");
                    tipoDoc = sc.nextInt();
                    switch (tipoDoc) {
                        case 1:
                            System.out.print("Introduce tu DNI: ");
                            String id = sc.next().toUpperCase();
                            boolean esCorrecto = UserDataValidations.checkId(id); //True si DNI es correcto, false si no lo es
                            if (esCorrecto) {
                                System.out.println("DNI correcto");
                            } else {
                                System.out.println("DNI incorrecto");
                            }
                            break;
                        default:
                            throw new AssertionError();
                    }

                    break;
                case 2: //HECHO.
                    System.out.print("Introduce una fecha (DD/MM/AAAA): ");
                    String fecha = sc.next();
                    boolean esCorrecto = UserDataValidations.checkFormatDate(fecha);
                    if (esCorrecto) {
                        System.out.println("Fecha correcta");
                    } else {
                        System.out.println("Fecha incorrecta");
                    }

                    break;
                /*case 3: //medio HECHO. Calcular edad. Version sin validar formato de fecha
                    System.out.print("Introduce tu fecha de nacimiento (DD/MM/AAAA): ");
                    String nac = sc.next();
                    int edad = calculateAge(nac);
                    System.out.println(edad);
                    break;*/
                case 3: //HECHO. Calcular edad con fecha de nacimiento
                    String nac;
                    do {
                        System.out.print("Introduce tu fecha de nacimiento (DD/MM/AAAA): ");
                        nac = sc.next();
                    } while (!UserDataValidations.checkFormatDate(nac));
                    int edad = UserDataValidations.calculateAge(nac);
                    System.out.println("Tu edad es " + edad);
                    break;
                case 4: //HECHO. Verificar codigo postal
                    System.out.print("Introduce tu codigo postal: ");
                    String postal = sc.next();
                    esCorrecto = UserDataValidations.checkPostalCode(postal);
                    if (esCorrecto) {
                        System.out.println("Codigo postal correcto");
                    } else {
                        System.out.println("Codigo postal incorrecto");
                    }
                    break;
                case 5: //HECHO. Verificar solo numeros
                    System.out.print("Introduce un numero: ");
                    String num = sc.next();
                    esCorrecto = UserDataValidations.isNumeric(num);
                    if (esCorrecto) {
                        System.out.println("Input verificado con exito");
                    } else {
                        System.out.println("Texto introducido no valido, introduce solo numeros");
                    }
                    break;
                case 6: //HECHO. Verificar solo letras
                    System.out.print("Introduce letras: ");
                    String letras = sc.next();
                    esCorrecto = UserDataValidations.isAlphabetic(letras);
                    if (esCorrecto) {
                        System.out.println("Input verificado con exito");
                    } else {
                        System.out.println("Texto introducido no valido, introduce solo letras");
                    }
                    break;
                case 7: //HECHO. Verificar email
                    System.out.print("Escribe tu mejor correo electronico: ");
                    String mail = sc.next();
                    esCorrecto = UserDataValidations.checkEmail(mail);
                    if (esCorrecto) {
                        System.out.println("Mail verificado con exito");
                    } else {
                        System.out.println("Formato de mail incorrecto.");
                    }
                    break;
                case 8: //HECHO. Verificar nombre
                    System.out.print("Escribe tu nombre: ");
                    String nombre = sc.nextLine();
                    esCorrecto = UserDataValidations.checkName(nombre);
                    if (esCorrecto) {
                        System.out.println("Nombre verificado con exito");
                    } else {
                        System.out.println("Nombre no valido");
                    }
                    break;
                case 9: //Salir del programa
                    System.out.println("Cerrando programa...");
                    Thread.sleep(1000);
                    funcionando = false;
                    break;
                default:
                    System.err.println("Respuesta incorrecta. Elige entre 1 y 9 porfavor.");
            }
        }

    }
}
