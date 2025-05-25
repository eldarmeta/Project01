package CO;

import java.util.Scanner;

public class level9 {
    public static void main(String[] args) {
/*
9. Доступ по паролю
Введи два значения:
inputPassword и confirmPassword.
Если они одинаковы и длина не меньше 6 символов → "ACCESS GRANTED"
Если разные → "WRONG"
Если слишком короткий → "TOO SHORT"
 */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String inputPassword = scanner.nextLine();

        System.out.print("Confirm the password: ");
        String confirmPassword = scanner.nextLine();

        if (inputPassword.length() < 6) {
            System.out.println("TOO SHORT");
        }else if((inputPassword.length() >= 6) &&
                (inputPassword.equals(confirmPassword))){
            System.out.println("ACCESS GRANTED");

        } else // (!inputPassword.equals(confirmPassword)) {
        {  System.out.println("WRONG");
        }


    }
}

