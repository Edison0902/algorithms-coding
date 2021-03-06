package _2.linked;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//25. K 个一组翻转链表
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。（小于k个的不反转）
public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) { //将前k个加入栈中
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) { //如果剩余少于k个，退出循环
                p.next = head;
                break;
            }
            while (!stack.isEmpty()){//如果栈不为空，添加到p链表中
                p.next = stack.pop();
                p = p.next;
            }
            head = tmp; //更新head的位置
        }
        return dummy.next;
    }

    //变型：从尾部开始反转k组，剩余不足k个不反转

    //1.首先将这个整个链表进行首尾反转
    //2.k group反转
    //3.整个链表反转
}
