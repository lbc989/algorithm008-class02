// 70. 爬楼梯
public class ClimbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int ans = climbStairs.climbStairs(5);
        System.out.println(ans);
    }
}
