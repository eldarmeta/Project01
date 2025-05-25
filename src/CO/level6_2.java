package CO;

import java.util.Scanner;

public class level6_2 {
    public static void main(String[] args) {
        /*        6. Символ активации
Введи символ (char).
Если это 'A', 'B', 'C' (заглавные) — выведи "ALPHA CODE"
Если 'a', 'b', 'c' — выведи "beta code"
Иначе — "unknown"         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the char: ");
        char ch = scanner.next().charAt(0);
        if (ch >= 'A' && ch <= 'Z'){
            System.out.println("ALPHA CODE");
        }else if (ch >= 'a' && ch <= 'z'){
            System.out.println("beta code");
        }else {
            System.out.println("unknown");
        }
    }
}
