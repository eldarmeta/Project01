import java.util.Scanner;

public class twoSum {
    public static void main(String[] args) {
        /*        Задача: Two Sum
У тебя есть массив целых чисел nums и целое число target.
Нужно найти индексы двух чисел, сумма которых равна target.

Ввод:
nums = [2, 7, 11, 15, 17]
target = 9

Вывод:
[0, 1] // потому что nums[0] + nums[1] = 2 + 7 = 9         */
        int [] nums = {2, 7, 11, 15, 17};
        int target = 26;

        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    System.out.println("[" + i + ", " + j + "]");

                }
            }
        }
            }
}
