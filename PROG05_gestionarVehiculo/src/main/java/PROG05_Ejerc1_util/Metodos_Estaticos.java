package PROG05_Ejerc1_util;

/**
 * esta clase contén os métodos estáticos para a validación do dni
 * @author alba_
 */
public class Metodos_Estaticos {

    //creamos o método lanzando unha excepción cando o dni non sexa correcto
    /**
     * 
     * @param dni é un String co valor do dni dunha persoa
     * 
     * @throws java.lang.Exception
     * @throws Exception, cando o dni non sexa correcto
     */
    public static void validar(String dni) throws Exception {
        //declaramos un String con todas as posibles letras do dni;
        String dniLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
        // comprobamos que a lonxitude do dni sexa a correcta
        if (dni.length() != 9) {
            throw new Exception ("O DNI é inválido porque non ten 9 caracteres: " + dni);  
        }
        // dividimos o dni en números e letra
        String numDNI = dni.substring(0, 8);
        String ltraDNI = dni.substring(8).toUpperCase();
        // verificamos se son números os 8 primeiros díxitos do dni
        if (!numDNI.matches("[0-9]*")) {
            throw new Exception ("O DNI é inválido porque os 8 primeiros díxitos non son números: " + dni);
        }
        //Verificamos se o último caracter é unha letra
        if (!ltraDNI.matches("[A-Z]")) {
            throw new Exception ("O DNI é inválido porque o noveno caracter non é unha letra: " + dni);
        }
        /*
        if (!numDNI.matches("[0-9]{8}[A-Z]{1}")) {
            
            return true;throw new Exception ("O DNI é inválido: " + dni);
        }retun false
        */
        //obtemos a posición da letra de dniLetras
        int numVer = Integer.parseInt(numDNI) % 23;
        // verificamos se a letra coincide coa letra do dni
        if (!ltraDNI.equals(dniLetras.substring(numVer, numVer + 1))) {
            throw new Exception ("O DNI é inválido porque a letra non é a correcta: " + dni);
        }
        
    }
}
