package com.leo.sword.problem.problem24;

/**
 * @Author: qian
 * @Description:
 * @Date: Created in 9:44 2018/3/21
 **/
public class RandomListClone {
    /**
     * 分为三步
     * 1.原始连接每个节点后插入赋值节点
     * 2.赋值随机节点
     * 3.拆分
     * */
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }

        addCopyNodeToAfter(pHead);

        randomCopyInit(pHead);



//        debug(pHead);

        return splitGetCopy(pHead);
    }

    private static void debug(RandomListNode pHead) {
        RandomListNode current = pHead;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }
        System.out.println(count);
    }

    private static RandomListNode splitGetCopy(RandomListNode pHead) {
        RandomListNode current = pHead;
        RandomListNode pCloneHead = pHead.next;
        RandomListNode tmp;
        current = pHead;
        while(current.next != null){
            tmp = current.next;
            current.next =tmp.next;
            current = tmp;
        }
        return pCloneHead;
    }

    private static void randomCopyInit(RandomListNode pHead) {
        if (pHead == null) {
            return;
        }
        RandomListNode originCurrent = pHead;
        while (originCurrent != null) {
            RandomListNode copyCurrent = originCurrent.next;
            if (originCurrent.random != null){
                copyCurrent.random = originCurrent.random.next;
            }
            originCurrent = copyCurrent.next;
        }

    }

    private static void addCopyNodeToAfter(RandomListNode pHead) {
        if (pHead == null) {
            return;
        }
        RandomListNode current = pHead;
        while (current != null) {
            RandomListNode copy = new RandomListNode(current.label);
            RandomListNode originNext = current.next;
            current.next = copy;
            copy.next = originNext;
            current = originNext;
        }
    }


    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(1);
        RandomListNode r3 = new RandomListNode(1);
        RandomListNode r4 = new RandomListNode(1);

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;

        System.out.println(new RandomListClone().Clone(r1));
    }
}
