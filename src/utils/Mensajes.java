package utils;

import java.util.Scanner;

public class Mensajes {
    public static void delay(String mensaje) {
        System.out.print("\n" + mensaje);
        for (int i = 0; i < 4; i++) {
            System.out.print(".");
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

    public static void pausa (String mensaje) {
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.print(mensaje);
        String pausa = s.nextLine();
    }

}
