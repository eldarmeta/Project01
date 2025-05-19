package CO;

import java.util.Scanner;

public class level11 {
    public static void main(String[] args) {
        /*        11. Множественный выбор
Введи число от 1 до 7.
Используй if / else if / else, чтобы вывести:

"MON" для 1, "TUE" для 2, ..., "SUN" для 7
Если вне диапазона → "INVALID"
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number between 1 - 7: ");
        int input = scanner.nextInt();

        if (input == 1) {
            System.out.println("MONDAY");
        } else if (input == 2){
            System.out.println("TUESDAY");

            } else if (input == 3) {
            System.out.println("WEDNESDAY");

        } else if (input == 4){
                System.out.println("THURSDAY");

        } else if (input == 5) {
            System.out.println("FRIDAY");

        }else if (input == 6) {
            System.out.println("SATURDAY");

        }else if (input == 7) {
            System.out.println("SUNDAY");

        }else{
            System.out.println("INVALID");
        }



    }
}
