package com.leo.sword.problem.problem17;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qian
 * @Description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 * @Date: Created in 15:24 2018/2/6
 **/
public class MergeListNode {

    /**
     * 暴力解法，两个首节点比较，小的加入
     * 运行时间：25ms
     * 占用内存：8780k
     * */
    public ListNode MergeOne(ListNode list1,ListNode list2) {
        {
            List<Integer> list = new ArrayList<>();
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    list.add(list1.val);
                    list1 = list1.next;
                }else {
                    list.add(list2.val);
                    list2 = list2.next;
                }
            }
            if (list1 != null){
                while (list1 != null){
                    list.add(list1.val);
                    list1 = list1.next;
                }
            }
            if (list2 != null){
                while (list2 != null){
                    list.add(list2.val);
                    list2 = list2.next;
                }
            }

            if (list.size() > 0) {
                ListNode ret = new ListNode(list.get(0)) ;
                ListNode move = ret;
                for (int i = 1 ; i < list.size() ;i++) {
                    ListNode temp = new ListNode(list.get(i));
                    move.next = temp;
                    move = temp;
                }
                return ret;
            }else {
                return null;
            }
        }
    }


    /**
     * 思想，递归实现
     * 运行时间：26ms
     * 占用内存：10564k
     * */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }else if (list2 == null) {
            return list1;
        }

        ListNode ret  = null;
        if (list1.val < list2.val) {
            ret = list1;
            ret.next = Merge(list1.next, list2);
        }else {
            ret = list2;
            ret.next = Merge(list1, list2.next);
        }
        return ret;
    }
}
