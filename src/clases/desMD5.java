/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Godie007
 */
public class desMD5 implements Runnable {

    private static int digit = -1;
    private static int digit2 = -1;
    private static int digit3 = -1;
    private static int digit4 = -1;
    private static int digit5 = -1;
    private static int digit6 = -1;
    private String palabra;

    public desMD5(String palabra) {
        this.palabra = palabra;
    }
    private static String posibles[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "w", "x", "y", "z",
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "W", "X", "Y", "Z"};
    private static final char[] CONSTS_HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String encriptaEnMD5(String stringAEncriptar) {
        try {
            MessageDigest msgd = MessageDigest.getInstance("MD5");
            byte[] bytes = msgd.digest(stringAEncriptar.getBytes());
            StringBuilder strbCadenaMD5 = new StringBuilder(2 * bytes.length);
            for (int i = 0; i < bytes.length; i++) {
                int bajo = (int) (bytes[i] & 0x0f);
                int alto = (int) ((bytes[i] & 0xf0) >> 4);
                strbCadenaMD5.append(CONSTS_HEX[alto]);
                strbCadenaMD5.append(CONSTS_HEX[bajo]);
            }
            return strbCadenaMD5.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String mostrarPosibles() {
        digit += 1;
        if (digit < posibles.length) {
        } else {
            digit = 0;
        }
        return posibles[digit];
    }

    public static String mostrarPosibles2() {
        digit2 += 1;
        if (digit2 < posibles.length) {
        } else {
            digit2 = 0;
        }
        return posibles[digit2];
    }

    public static String mostrarPosibles3() {
        digit3 += 1;
        if (digit3 < posibles.length) {
        } else {
            digit3 = 0;
        }
        return posibles[digit3];
    }

    public static String mostrarPosibles4() {
        digit4 += 1;
        if (digit4 < posibles.length) {
        } else {
            digit4 = 0;
        }
        return posibles[digit4];
    }

    public static String mostrarPosibles5() {
        digit5 += 1;
        if (digit5 < posibles.length) {
        } else {
            digit5 = 0;
        }
        return posibles[digit5];
    }

    public static String mostrarPosibles6() {
        digit6 += 1;
        if (digit6 < posibles.length) {
        } else {
            digit6 = 0;
        }
        return posibles[digit6];
    }
int contador =0;
    @Override
    public void run() {
        String[] caracteres = new String[8];
        for (int i = 0; i < caracteres.length; i++) {
            caracteres[i] = "";

        }
        for (int f = 0; f < posibles.length; f++) {
            for (int e = 0; e < posibles.length; e++) {
                for (int d = 0; d < posibles.length; d++) {
                    for (int c = 0; c < posibles.length; c++) {
                        for (int b = 0; b < posibles.length; b++) {
                            for (int a = 0; a < posibles.length; a++) {
                                String var = 
                                          caracteres[0]
                                        + caracteres[1]
                                        + caracteres[2]
                                        + caracteres[3]
                                        + caracteres[4]
                                        + caracteres[5];
                                caracteres[0] = mostrarPosibles();

                                if (encriptaEnMD5(var).equals(palabra) == true) {
                                    System.out.println(var);
                                    f = e = d = c = b = a = posibles.length - 1;
                                }
                            }
                            caracteres[1] = mostrarPosibles2();
                        }
                        caracteres[2] = mostrarPosibles3();
                    }
                    caracteres[3] = mostrarPosibles4();
                }
                caracteres[4] = mostrarPosibles5();
            }
            caracteres[5] = mostrarPosibles6();
        }
    }
}
