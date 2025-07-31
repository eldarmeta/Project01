
import java.util.*;

public class LotteryProbabilitySimulator {

    static final int NUMBERS_ON_TICKET = 6;
    static final int MAX_NUMBER = 49;

    static final int JACKPOT_MATCH = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🎟️ Сколько билетов вы хотите купить?");
        int ticketCount = scanner.nextInt();

        List<Set<Integer>> userTickets = generateTickets(ticketCount);
        Set<Integer> winningNumbers = generateWinningNumbers();

        System.out.println("\n🏆 Выигрышная комбинация: " + winningNumbers);

        int bestMatch = 0;
        for (Set<Integer> ticket : userTickets) {
            int matches = countMatches(ticket, winningNumbers);
            if (matches > bestMatch) bestMatch = matches;

            System.out.println("Ваш билет: " + ticket + " → Совпадения: " + matches);
        }

        showResult(bestMatch, ticketCount);
    }

    // Генерация билетов
    static List<Set<Integer>> generateTickets(int count) {
        List<Set<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(generateRandomSet(NUMBERS_ON_TICKET));
        }
        return tickets;
    }

    // Генерация победных чисел
    static Set<Integer> generateWinningNumbers() {
        return generateRandomSet(NUMBERS_ON_TICKET);
    }

    // Генерация случайного набора уникальных чисел
    static Set<Integer> generateRandomSet(int size) {
        Random rand = new Random();
        Set<Integer> set = new TreeSet<>();
        while (set.size() < size) {
            set.add(rand.nextInt(MAX_NUMBER) + 1);
        }
        return set;
    }

    // Подсчёт совпадений
    static int countMatches(Set<Integer> ticket, Set<Integer> winning) {
        Set<Integer> intersection = new HashSet<>(ticket);
        intersection.retainAll(winning);
        return intersection.size();
    }

    // Итог и вероятность
    static void showResult(int bestMatch, int ticketCount) {
        System.out.println("\n🎰 Лучший результат: " + bestMatch + " совпадений");

        switch (bestMatch) {
            case 6:
                System.out.println("🎉 Джекпот! Вы могли бы выиграть $1,000,000");
                break;
            case 5:
                System.out.println("🥈 Отлично! ~ $10,000");
                break;
            case 4:
                System.out.println("🥉 Хорошо! ~ $500");
                break;
            case 3:
                System.out.println("💵 Маленький выигрыш ~ $50");
                break;
            default:
                System.out.println("🙁 Увы, ничего. Попробуйте снова.");
        }

        double totalCombos = combination(MAX_NUMBER, NUMBERS_ON_TICKET);
        double yourChance = (double) ticketCount / totalCombos;

        System.out.printf("📊 Шанс выиграть джекпот с %d билетом(ами): %.12f%%\n",
                ticketCount, yourChance * 100);
    }

    // Комбинаторика: C(n, k)
    static long combination(int n, int k) {
        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }
}
