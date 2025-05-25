package CO;

import java.util.Scanner;

public class target {
    public static void main(String[] args) {
        /*        2. Симулятор выстрела по цели
Ввод:

x, y — координаты выстрела (int)

Цель:

находится в радиусе r = 10 от центра (0, 0)

Условие:

если x^2 + y^2 < 100 → "HIT"

если x^2 + y^2 == 100 → "EDGE"

иначе → "MISS"         */
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int rSquared = 100; //10^2
        int distance = x * x + y * y;

        if (distance < rSquared){
            System.out.println("HIT");
        } else if (distance == rSquared) {
            System.out.println("EDGE");
        }else {
            System.out.println("MISS");

        }


    }
}
