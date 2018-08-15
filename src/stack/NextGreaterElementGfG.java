package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * Element        NGE
 *    13      -->    -1
 *    7       -->     12
 *    6       -->     12
 *    12     -->     -1
 */
public class NextGreaterElementGfG {
    public static int[] findNextGreaterElement(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len  = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(nums[i], -1);
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                map.put( stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        // 栈不为空的元素的NGE都是-1，已默认处理

        for (int i = 0; i < len; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[]= {13,7,6,12};
        Arrays.stream(findNextGreaterElement(arr)).forEach(System.out::println);
    }
}
