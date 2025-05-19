
import java.util.Scanner;

public class level10 {
    public static void main(String[] args) {
        /*        10. Числовой треугольник
Введи 3 числа.
Определи:

Если все равны → "EQUILATERAL"

Если два равны → "ISOSCELES"

Если все разные → "SCALENE"
         */
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a == b && b == c){
            System.out.println("EQUILATERAL");
        } else if (a == b || a == c || b == c){
            System.out.println("ISOSCELES");
        }else{
            System.out.println("SCALENE");
        }


    }
}
