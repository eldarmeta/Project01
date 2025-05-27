public class StockOnePass {
    public static void main(String [] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int [] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) { // ➤ for-each: перебираем все цены
            if (price < minPrice) {
                minPrice = price; // ➤ нашли новую минимальную цену — обновили
            } else {
                // ➤ цена выше минимума — можно продать
                int profit = price - minPrice; // ➤ считаем прибыль
                maxProfit = Math.max(maxProfit, profit); // ➤ обновляем максимум
            }
        }

        return maxProfit; // ➤ возвращаем лучшую возможную прибыль
    }
}




    }
}
