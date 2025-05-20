import java.util.Scanner;

public class cal_Dis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                /*        Калькулятор корней квадратного уравнения
Ввод:

три числа: a, b, c

Реши уравнение:

ax^2 + bx + c = 0
Условие:

если дискриминант D < 0 → "NO ROOTS"

D == 0 → "ONE ROOT"

D > 0 → "TWO ROOTS"         */

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // Вычисляем дискриминант по формуле D = b^2 - 4ac
        int discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("NO ROOTS");
        } else if (discriminant == 0) {
            System.out.println("ONE ROOT");
        } else {
            System.out.println("TWO ROOTS");
        }
    }
}
