package CO;

import java.util.Scanner;

public class level4 {
    public static void main(String[] args) {
        /* Уровень 2 (средняя сложность)

4. Приоритет миссии
Введи строку — название миссии.
Если оно начинается с "X-" и длина больше 5 символов — выведи "PRIORITY"
Иначе — "STANDARD"

(Подумай: как проверить начало строки и длину)         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your input: ");
        String input = scanner.nextLine();

        if (input.length() > 5 && input.charAt(0) == 'X'){
            System.out.println("PRIORITY");
        }else {
            System.out.println("STANDARD");
        }
    }
}