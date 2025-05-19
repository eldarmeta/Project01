import java.util.Scanner;

public class level1 {
    public static void main(String[] args) {
        /*        👨‍🚀 Уровень 1 (легкий)

1. Открыть ли шлюз
У тебя есть температура скафандра (целое число).
Если она выше 20 градусов — напечатай "OPEN"
Иначе — напечатай "CLOSED"
         */
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input > 20){
            System.out.println("OPEN");
        }else {
            System.out.println("CLOSED");
        }
    }
}