package CO;

import java.util.Scanner;

public class level6_1 {
    public static void main(String[] args) {
        /*        6. Символ активации
Введи символ (char).
Если это 'A', 'B', 'C' (заглавные) — выведи "ALPHA CODE"
Если 'a', 'b', 'c' — выведи "beta code"
Иначе — "unknown"         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the char: ");
        char ch = scanner.next().charAt(0);

        switch (ch){
            case 'A':
            case 'B':
            case 'C':
                System.out.println("ALPHA CODE");
                break;
            case 'a':
            case 'b':
            case 'c':
                System.out.println("beta code");
                break;
            default:
                System.out.println("unknown");
        }
    }
}


