import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 使用双层for循环的时间复杂度过高，原因在哪里？
        // 原因就是当每次i固定的时候,j往后遍历只能与i进行比较
        // 但是如果要找的两个数在倒数第一第二的位置呢？
        // i就要遍历整个数组才能找到这两个数，但是j已经经过了这两个数好几次了
        // 那么能不能在遍历到某个数的时候可以与前面的所有数进行比较呢？
        // 用哈希就可以很好的解决这个问题
        // 每次添加一个数字的时候看看前面是否存在target - nums[i]
        // 如果存在的话就返回对应下标
        // 如果不存在的话就添加进去
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            // 首先看看key是否存在
            if (map.containsKey(target - nums[i]))  {
                return new int[]{map.get(target - nums[i]), i};
            }
            // 如果不存在的话就添加进去就好了
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
// @lc code=end
