package CO;

import java.util.Scanner;

public class level3 {
    public static void main(String[] args) {
        /*        3. Гравитационный фильтр
Пользователь вводит силу притяжения (тип double).
Если меньше 3.7 — это Луна, выведи "Lunar"
Если больше 3.7 и до 10 — "Earth-like"
Если больше 10 — "Gas Giant"         */
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();

        if (input < 3.7){
            System.out.println("Lunar");
        }else if ((input > 3.7) && (input < 10)) {
            System.out.println("Earth-Like");
        }else{
            System.out.println("Gas Giant");
        }
    }
}