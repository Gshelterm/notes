package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 *  Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 */
public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        /**
         * 栈用来存储递减序列的下标，即一遍遍历完之后的下标
         */
        Deque<Integer> stack = new ArrayDeque<>();
        int len  = nums.length;

        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * len; i++) {
            // 遍历两遍，第二遍对未找NGE的元素
            int num = nums[(i+len) % len];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            // 第二遍遍历，不需要再push, 没push进去则表示已处理完
            if (i < len) stack.push(i);
            if (stack.isEmpty()) break;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,2,1};
        Arrays.stream(nextGreaterElements(test)).forEach(System.out::println);
    }
}
