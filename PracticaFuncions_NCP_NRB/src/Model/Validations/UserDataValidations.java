
package Model.Validations;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserDataValidations {
    
    /**
     * Muestra las opciones a elegir
     */
    public static void mostrarOpciones() {
        System.out.println("1- CheckId - Verificar que un DNI sea correcto.");
        System.out.println("2- checkFormatDate - Verificar que una fecha sea correcta.");
        System.out.println("3- calculateAge - Calcular edad segun fecha de nacimiento.");
        System.out.println("4- checkPostalCode - Verificar que el codigo postal sea correcto.");
        System.out.println("5- isNumeric - Verifica que un String sea unicamente numeros");
        System.out.println("6- isAlphabetic - Verifica que un String sea unicamente letras");
        System.out.println("7- checkEmail - Verificar que el email introducido sea valido");
        System.out.println("8- checkName - Verificar que un nombre sea valido (se siente X AE A-12).");
        System.out.println("9- Cerrar programa.");
    }

    /**
     *
     * //@param typeDoc
     *Valida que el DNI introducido sea válido
     * @param id
     * @return true si DNI es valido, false si no lo es
     */
    public static boolean checkId(/*int typeDoc,*/String id) {
        //Primera parte. Verifica que lo que introduce el usuario es coherente
        //id es el DNI que ha introducido el usuario
        if (id.length() != 9) {
            return false;
        }
        char letra = id.charAt(id.length() - 1); //Almacenar en 'letra' la letra del DNI
        String numeros = id.substring(0, id.length() - 1); //Almacenar en 'numeros' los nums del DNI
        int numsDNI = Integer.parseInt(numeros); //Convertimos el String numeros a int

        //Segunda parte. Verificar con algoritmo si el DNI es verdadero
        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        
        int resto = numsDNI % 23;

        if (caracteres.charAt(resto) == letra) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Valida que el formato de fecha sea válido (DD/MM/AAAA)
     * @param date
     * @return true si el formato de fecha es valido, false si no lo es
     */
    public static boolean checkFormatDate(String date) {
        String[] sep = date.split("\\/");
        int diasMax = 0;
        if (sep.length != 3) { //Si la longitud del array es mayor que 3, se ha introducido una fecha rara
            return false;
        }
        //Conversion a int para verificar que dia mes y año sean coherentes
        int diaNum = Integer.parseInt(sep[0]);
        int mesNum = Integer.parseInt(sep[1]);
        int anyoNum = Integer.parseInt(sep[2]);

        switch (mesNum) {
            case 1, 3, 5, 7, 8, 10, 12: //Meses con 31 dias
                diasMax = 31;
                break;
            case 4, 6, 9, 11: //Meses con 30 dias
                diasMax = 30;
                break;
            case 2: //Febrero bisiesto y no bisiesto
                if ((anyoNum % 4 == 0 && anyoNum % 100 != 0) || (anyoNum % 400 == 0)) {
                    diasMax = 29;
                } else {
                    diasMax = 28;
                }
                break;
            default:
                System.err.println("Fecha erronea");
        }

        if ((diaNum < 1 || diaNum > diasMax) || (mesNum < 1 || mesNum > 12) || (anyoNum < 1920 || anyoNum > 2026)) {
            return false;
        }

        return sep[0].length() == 2 && sep[1].length() == 2 && sep[2].length() == 4;
    }
    
    /**
     * Calcula la edad en años en base a tu fecha de nacimiento
     * @param birthDateStr
     * @return edad en años
     */
    public static int calculateAge(String birthDateStr) { 

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");//Dar formato a la fecha
        LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(birthDate, fechaActual);
        int edad = periodo.getYears();
        return edad;
    }
    
    /**
     * Valida si el código postal es valido
     * @param zip
     * @return true si el código postal es válido (Territorio español)
     */
    public static boolean checkPostalCode(String zip) {
        //Acabar cuadno este hecha la funcion de solo numeros
        //Comprobar que la longitud es exactamente 5
        if (zip.length() != 5) {
            return false;
        }

        if (!isNumeric(zip)) {
            return false;
        }
        int zipInt = Integer.parseInt(zip);

        if (zipInt < 1001 || zipInt > 52999) {
            return false;
        }
        return true;
    }
    
    /**
     * Valida que el input sea sólo números
     * @param str
     * @return true si el input es solo numeros
     */
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * @param str
     * @return true si el input es sólo letras (pueden haber espacios)
     */
    public static boolean isAlphabetic(String str) {
        str = str.trim();
        if (str.isBlank()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i)) && str.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Valida que el email introducido sea válido 
     * @param email
     * @return true si el input es un formato de correo electrónico
     */
    public static boolean checkEmail(String email) { //Acabar de checkear que haya algo entre el @ y la terminacion
        String[] terminaciones = {".com", ".es", ".net"};
        //Comprobar espacios
        if (email.contains(" ")) {
            return false;
        }
        //Comprobar si contiene @
        if (!email.contains("@")) {
            return false;
        }
        //Comprobar que no empiece con @
        if (email.indexOf("@") == 0) {
            return false;
        }
        //Comprobar que termine con una de las terminaciones establecidas. Se pueden añadir en el array
        boolean terminaBien = false;
        for (int i = 0; i < terminaciones.length; i++) {
            if (email.endsWith(terminaciones[i])) {
                terminaBien = true;
                break;
            }
        }
        if (!terminaBien) {
            return false;
        }
        return true;
    }
    
    /**
     * Valida que el nombre introducido es válido
     * @param name
     * @return true si el nombre es coherente (no apto para el retoño de tito Musk)
     */
    public static boolean checkName(String name) {
        if (name.length() > 20) {
            return false;
        }
        if (!isAlphabetic(name)) {
            return false;
        }

        return true;
    }
}