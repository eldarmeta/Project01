package CO;

import java.util.Scanner;

public class level12 {
    public static void main(String[] args) {
        /*        Точка на грани
Введи координаты x и y.
Если точка лежит внутри круга радиусом 5 и не на границе → "IN"
Если ровно на границе круга → "ON"
Если снаружи → "OUT"

Формула круга: x^2 + y^2 == r^2         */
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int rSquared = 25; //5^2
        int distance = x * x + y * y;

        if (distance < rSquared){
            System.out.println("IN");
        } else if (distance == rSquared) {
            System.out.println("ON");
        }else {
            System.out.println("OUT");
        }
    }
}
