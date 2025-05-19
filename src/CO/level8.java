import java.util.Scanner;

public class level8 {
    public static void main(String[] args) {
        /*        💀 Уровень 3 (потяжелее)

8. Трёхуровневый пропуск
Введи возраст и специальность.
Если возраст > 25 и специальность — "engineer" → "FULL ACCESS"
Если только возраст > 25 → "LIMITED ACCESS"
Иначе → "DENIED"         */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your profession: ");
        String prof = scanner.nextLine();


        if (age > 25 && prof.equals("engineer")){
            System.out.println("FULL ACCESS");
        } else if (age > 25) {
            System.out.println("LIMITED ACCESS");
        } else if (prof.equals("engineer")) {
            System.out.println("LIMITED ACCESS");
        }else {
            System.out.println("DENIED");
        }

    }
}
