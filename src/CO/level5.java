package CO;

import java.util.Scanner;

public class level5 {
    public static void main(String[] args) {
        /*5. Координатная зона
Пользователь вводит координаты x и y (целые числа).
Определи, в какой четверти находится точка:

I, II, III, IV или "ON AXIS" если хотя бы одно = 0      */
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if ((x == 0) || (y == 0)) {
            System.out.println("ON AXIS");
        }else if ((x > 0) && (y > 0)) {
            System.out.println("I");
        } else if ((x < 0) && (y > 0)) {
            System.out.println("II");
        }else if ((x < 0) && (y < 0)) {
            System.out.println("III");
        } else if ((x > 0) && (y < 0)) {
            System.out.println("IV");
        }
    }
}
