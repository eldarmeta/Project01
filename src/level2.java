import java.util.Scanner;

public class level2 {
    public static void main(String[] args) {
        /*        2. Стартовая проверка
Введи два числа: заряд батареи (в %) и уровень кислорода (в %).
Если оба больше или равны 50 — выведи "SYSTEM READY"
Иначе — "CHECK FAILED"         */
        Scanner scanner = new Scanner(System.in);
        int batteryLevel = scanner.nextInt();
        int oxygenLevel = scanner.nextInt();

        if ((batteryLevel >= 50) && (oxygenLevel >= 50)){
            System.out.println("SYSTEM READY");
        }else {
            System.out.println("CHECK FAILED");
        }

    }
}