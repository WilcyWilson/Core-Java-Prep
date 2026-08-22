package leetcodeprep;

public class BestTimeToBuyAndSellStock {

    //TLE
    public int maxProfitLoops(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > 0) {
                    profit = Math.max((prices[j] - prices[i]), profit);
                }
            }
        }
        return profit;
    }

    public int maxProfitLoop2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfitLoop2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTimeToBuyAndSellStock().maxProfitLoop2(new int[]{7, 6, 4, 3, 7}));
        System.out.println(new BestTimeToBuyAndSellStock().maxProfitLoop2(new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(new BestTimeToBuyAndSellStock().maxProfitLoop2(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new BestTimeToBuyAndSellStock().maxProfitLoop2(new int[]{2, 1, 2, 0, 1}));
        System.out.println(new BestTimeToBuyAndSellStock().maxProfitLoop2(new int[]{2, 4, 1}));
        System.out.println(new BestTimeToBuyAndSellStock().maxProfitLoops(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
