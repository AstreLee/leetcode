import java.util.*;
/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */
// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // Arrays.sort(nums);

        // ------------------- 分割线 ----------------
        // 可以使用单指针两次遍历，第一次将0全部交换到前面，第二次将1全部交换到0的后面，这样剩下的就全部是2
        // int p0 = 0;
        // for (int i = 0; i < nums.length; ++i) {
        //     if (nums[i] == 0)  {
        //         int temp = nums[i];
        //         nums[i] = nums[p0];
        //         nums[p0] = temp;
        //         ++p0;
        //     }
        // }
        // int p1 = p0;  // 注意1是紧跟在0的后面的
        // for (int i = p1; i < nums.length; ++i) {
        //     if (nums[i] == 1)  {
        //         int temp = nums[i];
        //         nums[i] = nums[p1];
        //         nums[p1] = temp;
        //         ++p1;
        //     }
        // }

        // ------------------ 分割线 -------------------------
        // 实际上还可以采用数组计数的方式
        // int count0 = 0;
        // int count1 = 0;
        // for (int i = 0; i < nums.length; ++i) {
        //     if (nums[i] == 0)  ++count0;
        //     else if (nums[i] == 1) ++count1;
        // }
        // for (int i = 0; i < nums.length; ++i) {
        //     if (i < count0)  nums[i] = 0;
        //     else if (i < count0 + count1)  nums[i] = 1;
        //     else nums[i] = 2;
        // }



        // ------------------ 分割线 --------------------------
        // 实际上还可以使用双指针
        // 具体的双指针也有两种思路
        // 思路一：使用p0记录0，p1记录1
        // 指针i遍历数组，如果是0的话则nums[p0]与nums[i]交换,同时p0和p1移动
        // 如果是1的话，则nums[p1]与nums[i]交换，同时p1移动到下一个位置
        // 但是注意到在第一次找到1的时候，p0和p1都是指向0的，这样在交换
        // 完成后就会出现p0指向1，p1指向p0的下一个位置，这样如果再次
        // 遇到0的话，nums[i]和nums[p0]交换就会将1交换出去，所以当p0 < p1的时候
        // 如果nums[i] == 0的话，要记得交换nums[p1]
        // int p0 = 0;
        // int p1 = 0;
        // for (int i = 0; i < nums.length; ++i) {
        //     if (nums[i] == 1) {
        //         int temp = nums[i];
        //         nums[i] = nums[p1];
        //         nums[p1] = temp;
        //         ++p1;
        //     } else if (nums[i] == 0) {
        //         int temp = nums[i];
        //         nums[i] = nums[p0];
        //         nums[p0] = temp;
        //         if (p0 < p1) {
        //             temp = nums[i];
        //             nums[i] = nums[p1];
        //             nums[p1] = temp;
        //         }
        //         ++p0;
        //         ++p1;
        //     }
        // }

        // ------------------ 分割线 -------------------
        // 第二种p0交换0，p2交换2
        // 这种的话当i遍历数组的时候如果没有超过p2的时候就继续
        // 当nums[i] == 0的时候，交换nums[i]和nums[p0]，并且p0++
        // 当nums[i] == 2的时候，交换nums[i]和nums[p2], 并且p2--
        // 这样真的就行了吗？注意到nums[p2]交换到nums[i]的位置的时候
        // 仍然有可能使得nums[i]为2，但是此时却处理nums[i + 1]位置元素
        // 所以我们交换后仍然需要判断是否为2
        // int p0 = 0;
        // int p2 = nums.length - 1;
        // for (int i = 0; i <= p2; ++i) {
        //     // 注意这个while循环应该放在上面，因为nums[i]!=2循环结束后
        //     // 仍然有可能出现nums[i]==0的情况，所以还需要继续处理
        //     while (i <= p2 && nums[i] == 2) {
        //         int temp = nums[i];
        //         nums[i] = nums[p2];
        //         nums[p2] = temp;
        //         --p2;
        //     }
        //     if (nums[i] == 0) {
        //         int temp = nums[i];
        //         nums[i] = nums[p0];
        //         nums[p0] = temp;
        //         ++p0;
        //     } 
        // }
    }   
}
// @lc code=end

