import java.util.Scanner;

public class access {
    public static void main(String[] args) {
        /*        1. Система доступа по зонам и паролю
Ввод:

строка role (admin, engineer, guest)

строка password

Условие:

если role == admin и пароль "root123" → "Full Access"

если role == engineer и пароль длиной ≥ 6 → "Partial Access"

если role == guest → "View Only"

иначе → "Access Denied"         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your role (admin, engineer, guest): ");
        String role = scanner.nextLine().trim();
        System.out.print("password: ");
        String password = scanner.nextLine().trim();

        if (role.equalsIgnoreCase("admin") && (password.equals("root123"))){
            System.out.println("Full Access");

        } else if (role.equalsIgnoreCase("engineer") && password.length() >= 6) {
            System.out.println("Partial Access");

        }else if (role.equalsIgnoreCase("guest")){
            System.out.println("View Only");

        }else{
            System.out.println("Access Denied");
        }

    }
}
