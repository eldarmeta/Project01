public class MoveZeroesBrute {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};              // ➊ массив чисел

        moveZeroes(nums);                           // ➋ вызываем метод, чтобы обработать массив

        for (int n : nums) {                        // ➌ цикл по всем числам массива
            System.out.print(n + " ");              // ➍ печатаем результат в консоль
        }
    }

    public static void moveZeroes(int[] nums) {
        int[] result = new int[nums.length];        // ➎ создаём новый массив такого же размера
        int index = 0;                              // ➏ это позиция, куда вставлять ненули

        for (int num : nums) {                      // ➐ цикл: берём каждый элемент из nums
            if (num != 0) {                         // ➑ если элемент НЕ ноль
                result[index] = num;                // ➒ сохраняем его в result
                index++;                            // 🔟 сдвигаем позицию вперёд
            }
        }

        for (int i = 0; i < nums.length; i++) {     // ⓫ копируем результат обратно в nums
            nums[i] = result[i];
        }
    }
}
