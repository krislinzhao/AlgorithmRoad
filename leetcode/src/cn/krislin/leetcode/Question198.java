package cn.krislin.leetcode;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 * @author: krislin
 * @date: 2021/05/19 11:57 AM
 **/
public class Question198 {

    /**
     * dp[i] 代表前 i 个房子在满足条件下的能偷窃到的最高金额
     *
     * 最终的转移方程： dp[i] = max(dp[i-1], dp[i-2]+nums[i-1])
     *               （前一个房间的最大偷窃金额数） 和 （前2个房间的最大偷窃金额数+当前房间的金额数）的最大值
     *
     * 时间复杂度： O(n)
     * 空间复杂度: O(n)
     */
    private static int rob1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        //dp数组
        int[] dp = new int[len + 1];
        //初始化
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        return dp[len];
    }

    /**
     * dp[n] 只与 dp[n-1] 和 dp[n-2] 有关系，因此我们可以设两个变量 cur和 pre 交替记录，将空间复杂度降到 O(1)
     *
     * 时间复杂度： O(n)
     * 空间复杂度: O(1)
     *
     */
    public static int rob2(int[] nums) {
        int cur = 0, pre = 0, tmp;

        for (int num : nums) {
            tmp = cur;
            cur = Math.max(cur, pre+num);
            pre = tmp;
        }

        return cur;
    }
}
