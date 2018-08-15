package twopointers;

/**
 */
public class RotateList {
    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode l1 = rotateList.new ListNode(1);
        ListNode l2 = rotateList.new ListNode(2);
        ListNode l3 = rotateList.new ListNode(3);
        ListNode l4 = rotateList.new ListNode(4);
        ListNode l5 = rotateList.new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode res = rotateList.rotateRightV2(l1, 2);
        System.out.println(res.val);
    }

    /**
     * 效率太低
     */
    public ListNode rotateRight(ListNode head, int k) {
        ListNode fast = head, slow = head;
        if (head == null) return null;
        if (k == 0 || head.next == null) return head;
        int len = 0;
        while (fast != null) {
            len++;
            fast = fast.next;
        }
        fast = head;
        int temp = k % len;
        if (temp == 0) return head;
        while (temp > 0) {
            temp--;
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    /**
     * 计算长度的同时计算end指针
     */
    public ListNode rotateRightV2(ListNode head, int k) {
        int len = 0;
        ListNode cur = head, end = null;
        if (head == null) return null;
        while (cur != null) {
            end = cur;
            cur = cur.next;
            len++;
        }
        cur = head;
        k = k % len;
        if (k == 0 || head.next == null) return head;
        int temp = len - k - 1;
        while (temp > 0) {
            cur = cur.next;
            temp--;
        }
        end.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }


    public class ListNode {
        ListNode next;
        int val;
        ListNode(int x) { val = x; }
    }

}
