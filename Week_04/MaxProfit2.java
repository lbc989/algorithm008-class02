//122. 买卖股票的最佳时机 II
public class MaxProfit2 {
    // public int maxProfit(int[] prices) {
    //     int low = prices[0];
    //     int high = prices[0];
    //     int maxprofit = 0;
    //     int i = 0;
    //     while (i < prices.length - 1) {
    //         while (i < prices.length - 1 && prices[i] >= prices[i + 1])
    //             i++;
    //         low = prices[i];
    //         while (i < prices.length - 1 && prices[i] <= prices[i + 1])
    //             i++;
    //         high = prices[i];
    //         maxprofit += high - low;
    //     }
    //     return maxprofit;
    // }
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxprofit += prices[i + 1] - prices[i];
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxprofit = maxProfit2.maxProfit(prices);
        System.out.println(maxprofit);
    }
}
