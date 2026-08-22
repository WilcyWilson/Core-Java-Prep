package leetcodeprep;

public class BestTimeToBuyAndSellStock {

    //TLE
    public int maxProfitLoops(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            for (int j = i + 1; j < prices.length; j++){
                if (prices[j] - prices[i] > 0){
                    profit = Math.max((prices[j] - prices[i]), profit);
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println( new BestTimeToBuyAndSellStock().maxProfitLoops(new int[]{7,1,5,3,6,4}));
    }
}
