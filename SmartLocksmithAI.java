
import java.util.*;

public class SmartLocksmithAI {

    private static final int NUM_PINS = 5;
    private static final int POSITIONS_PER_PIN = 6;
    private static final int MAX_ATTEMPTS = 100000;

    private static int[] secretCombination;
    private static Map<Integer, Double>[] pinProbability; // вероятность каждого положения

    private static Random random = new Random();

    public static void main(String[] args) {
        secretCombination = generateSecretCombination();
        System.out.println("🔒 Секрет замка (скрыто): " + Arrays.toString(secretCombination));

        generatePinProbabilities();
        System.out.println("📊 Вероятности по пинам:");
        for (int i = 0; i < NUM_PINS; i++) {
            System.out.println("  Пин " + (i+1) + ": " + pinProbability[i]);
        }

        long start = System.currentTimeMillis();
        int attempts = smartUnlock();
        long end = System.currentTimeMillis();

        if (attempts >= 0) {
            System.out.println("✅ Замок открыт за " + attempts + " попыток");
        } else {
            System.out.println("❌ Не удалось открыть замок за отведённые попытки");
        }

        System.out.println("⏱ Время: " + (end - start) + " мс");
    }

    // Генерация секретной комбинации
    private static int[] generateSecretCombination() {
        int[] combo = new int[NUM_PINS];
        for (int i = 0; i < NUM_PINS; i++) {
            combo[i] = random.nextInt(POSITIONS_PER_PIN) + 1;
        }
        return combo;
    }

    // Инициализация вероятностей для каждого пина
    private static void generatePinProbabilities() {
        pinProbability = new Map[NUM_PINS];
        for (int i = 0; i < NUM_PINS; i++) {
            pinProbability[i] = new HashMap<>();
            double total = 0.0;

            for (int pos = 1; pos <= POSITIONS_PER_PIN; pos++) {
                double weight = random.nextDouble();
                pinProbability[i].put(pos, weight);
                total += weight;
            }

            // Нормализуем вероятности
            for (int pos = 1; pos <= POSITIONS_PER_PIN; pos++) {
                double normalized = pinProbability[i].get(pos) / total;
                pinProbability[i].put(pos, normalized);
            }
        }
    }

    // AI-подбор ключа на основе вероятностей (приоритетный перебор)
    private static int smartUnlock() {
        PriorityQueue<Combination> queue = new PriorityQueue<>();
        queue.offer(new Combination(new int[NUM_PINS], 0.0));

        int attempts = 0;

        while (!queue.isEmpty() && attempts < MAX_ATTEMPTS) {
            Combination current = queue.poll();
            if (current.key.length < NUM_PINS) {
                int pinIndex = current.key.length;
                for (int pos = 1; pos <= POSITIONS_PER_PIN; pos++) {
                    int[] newKey = Arrays.copyOf(current.key, pinIndex + 1);
                    newKey[pinIndex] = pos;
                    double prob = pinProbability[pinIndex].get(pos);
                    queue.offer(new Combination(newKey, current.probabilityScore + -Math.log(prob))); // log-преобразование
                }
            } else {
                attempts++;
                if (Arrays.equals(current.key, secretCombination)) {
                    System.out.println("🔓 Найден ключ: " + Arrays.toString(current.key));
                    return attempts;
                }
            }
        }
        return -1;
    }

    // Комбинация с приоритетом по вероятности
    static class Combination implements Comparable<Combination> {
        int[] key;
        double probabilityScore;

        Combination(int[] key, double probabilityScore) {
            this.key = key;
            this.probabilityScore = probabilityScore;
        }

        @Override
        public int compareTo(Combination other) {
            return Double.compare(this.probabilityScore, other.probabilityScore); // минимизируем
        }
    }
}
