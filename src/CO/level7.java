package CO;

import java.util.Scanner;

public class level7 {
    public static void main(String[] args) {
        /*        7. Кратность сигнала
Введи число n.
Если n делится и на 3, и на 5 → "ULTRA"
Если только на 3 → "TRI"
Если только на 5 → "PENTA"
Иначе — "NONE"         */
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if ((input % 3 == 0) && (input % 5 == 0)){
            System.out.println("ULTRA");
        }else if (input % 3 == 0){
            System.out.println("TRI");
        } else if (input % 5 == 0) {
            System.out.println("PENTA");
        }else {
            System.out.println("NONE");
        }
    }
}
