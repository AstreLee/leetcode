import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    // 首先我们来捋一捋思路
    // 最常规的方式就是使用三层for循环，去遍历所有的可能，这样的话时间
    // 复杂度是O(N ^ 3)，然后再使用set进行去重处理，但是这样的话如果遇到
    // 最极端的情况：长度为1000的全部是0的数组，这样的话不论是时间复杂度
    // 还是存储到集合中的空间复杂度都是巨大的
    // 我们实际上可以考虑优化这三层for循环
    // 就是为了重复计算，保证a < b < c，这样就避免了重复计算相同的内容,但时间复杂度还是O(N^3)
    // 注意这种避免重复只是说满足条件的三元组的下标都是不一样的，当然最后还有可能元素重复
    // 我们可以进一步想一下a + b + c = 0; 在数组有序的情况下, 当我们固定了a的话，从大于a的位置开始依次往后遍历
    // b不断增大，那么想让结果为0，c就必须变小，当然循环要求b < c
    // 为了避免下标重复，使得a < b < c，为了避免元素重复，a, b, c每次移动的时候都要和上次的元素大小不一致
    // 这个实际上就将我们的O(N^3)的时间复杂度成功的降低到了O(N^2)
    // 实际上还是排序+双指针的做法
    public List<List<Integer>> threeSum(int[] nums) {
        // 记住双指针针对的是有序数组，一定要先排序
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ++i) {  // i只用遍历到倒数第三个数就行
            // 如果从第一个数开始就是大于0，后面也就没必要看了
            if (nums[i] > 0)  break; 
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;  // 注意这三个数的必须是不同下标
            int k = nums.length - 1;  // 从最后一个位置开始
            while (j < k) {
                // 如果nums[j] + nums[k] = -nums[i]，则j继续右移动，k继续左移动
                if (nums[j] + nums[k] + nums[i] == 0) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    ++j; --k;
                    // 注意[-2, -1, -1, -1, 3, 3, 3]这种情况, 如果j=1,k=n-1结束后只是单纯的左右移动的话就会出现重复的
                    // 所以我们的j和k要移动到和之前不重复为止，i也是同样的道理
                    while (j < k && nums[j] == nums[j - 1])  ++j;
                    while (j < k && nums[k] == nums[k + 1])  --k;
                } else if (nums[j] + nums[k] + nums[i] < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return list;
    }
}
// @lc code=end

