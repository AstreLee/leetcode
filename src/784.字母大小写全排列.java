import java.util.*;
/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 */

// @lc code=start
class Solution {
    public List<String> letterCasePermutation(String s) {
        // // 好吧还是看答案。。。。。。
        // // 呜呜呜是真的想不到
        // // 注意到答案的方法中采用了append方法，由于字符串是不可变的数据类型
        // // 所以用StringBuilder类型
        // List<StringBuilder> list1 = new ArrayList<>();
        // list1.add(new StringBuilder());

        // for (char c : s.toCharArray()) {
        //     // 获取list1中所有的元素个数
        //     int n = list1.size();
        //     if (Character.isLetter(c)) {
        //         // 将前面的1 ~ n的所有的数字全部复制一份，第i个字符串append小写字母
        //         // n + i个字符串append大写字母
        //         for (int i = 0; i < n; ++i) {
        //             // 首先将第i个字符复制一份
        //             list1.add(new StringBuilder(list1.get(i)));
        //             // 然后前面的字符加上小写，复制的字符串就机加上大写
        //             list1.get(i).append(Character.toLowerCase(c));
        //             list1.get(n + i).append(Character.toUpperCase(c));
        //         }
        //     } else {
        //         // 如果是数字的话直接添加
        //         for (int i = 0; i < n; ++i) list1.get(i).append(c);
        //     }
        // }

        // // 最后再将StringBuilder转换为String
        // List<String> list2 = new ArrayList<>();
        // for (StringBuilder item : list1) {
        //     list2.add(new String(item));
        // }
        // return list2;


        // -------------------------- 分割线 ------------------------------
        // 实际上可以使用回溯法，对于每一个字符，只需要处理数字，小写和大写字母两种情况就行
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        DFS(list, sb, s, 0);
        return list;
    }

    // 使用回溯法解决是真的妙哇，pos这个是必需的，它标志着递归的结束
    // 注意这里使用的是StringBuilder引用类型的参数，回溯的过程中操作的始终是这一个path
    // 所以不能用append方法，那样的话上一个DFS回溯的结果就会对下一个DFS传入的path产生影响
    public void DFS(List<String> list, StringBuilder path, String s, int pos) {
        // if (pos == s.length()) {
        //     list.add(new String(path));
        //     return;
        // }
        // if (Character.isDigit(s.charAt(pos))) {
        //     // 如果是数字的话直接替换pos位置处的元素就行
        //     path.setCharAt(pos, s.charAt(pos));
        //     // 然后递归
        //     DFS(list, path, s, pos + 1);
        // } else if (Character.isLowerCase(s.charAt(pos))) {
        //     // 如果是小写字母的话
        //     // 1. 首先添加小写字母再回溯
        //     path.setCharAt(pos, s.charAt(pos));
        //     DFS(list, path, s, pos + 1);
        //     // 2. 再添加大写字母再回溯
        //     path.setCharAt(pos, Character.toUpperCase(s.charAt(pos)));
        //     DFS(list, path, s, pos + 1);
        // } else {
        //     // 如果是大写字母的话
        //     // 1. 首先添加大写字母然后回溯
        //     path.setCharAt(pos, s.charAt(pos));
        //     DFS(list, path, s, pos + 1);
        //     // 2. 再次添加小写字母然后回溯
        //     path.setCharAt(pos, Character.toLowerCase(s.charAt(pos)));
        //     DFS(list, path, s, pos + 1);
        // }

        // -------------------------------- 分割线 -----------------------------------
        // 下面这种回溯的方式注意是需要处理回溯后的结果
        // 上面那种直接覆盖的方式显然更容易一点
        // if (pos == s.length()) {
        //     list.add(new String(path));
        //     return;
        // }
        // if (Character.isDigit(s.charAt(pos))) {
        //     // 如果是数字的话直接替换pos位置处的元素就行
        //     path.append(s.charAt(pos));
        //     // 然后递归
        //     DFS(list, path, s, pos + 1);
        //     path.deleteCharAt(pos);
        // } else if (Character.isLowerCase(s.charAt(pos))) {
        //     // 如果是小写字母的话
        //     // 1. 首先添加小写字母再回溯
        //     path.append( s.charAt(pos));
        //     DFS(list, path, s, pos + 1);
        //     path.deleteCharAt(pos);
        //     // 2. 再添加大写字母再回溯
        //     path.append(Character.toUpperCase(s.charAt(pos)));
        //     DFS(list, path, s, pos + 1);
        //     path.deleteCharAt(pos);
        // } else {
        //     // 如果是大写字母的话
        //     // 1. 首先添加大写字母然后回溯
        //     path.append(s.charAt(pos));
        //     DFS(list, path, s, pos + 1);
        //     path.deleteCharAt(pos);
        //     // 2. 再次添加小写字母然后回溯
        //     path.append(Character.toLowerCase(s.charAt(pos)));
        //     DFS(list, path, s, pos + 1);
        //     path.deleteCharAt(pos);
        // }

        // 覆盖问题和增减问题
    }
}
// @lc code=end
