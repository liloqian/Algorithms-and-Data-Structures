package work_begin.DJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by leo on 2018/7/8.
 */
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        int initWeight = scanner.nextInt();
        List<Num> lists = new ArrayList<>();
        while (--days >= 0) {
            int add = scanner.nextInt();
            int remove = scanner.nextInt();
            int upDig = scanner.nextInt();
            int downDig = scanner.nextInt();
            Num num = new Num();
            num.up = (downDig - upDig) * remove - add * upDig;
            num.down = downDig;
            lists.add(num);
        }
        int downMax = 1;
        for (Num n : lists) {
            downMax *= n.down;
        }
        int upMax = 0;
        for (Num n : lists) {
            upMax += (downMax / n.down) * n.up;
        }
        int intNum = upMax / downMax;
        int removeNum = upMax - downMax * intNum;
        if (removeNum == 0) {
            System.out.println(initWeight+intNum);
            return;
        }
        int commonNum = getCommonNum(downMax,removeNum);
        removeNum /= commonNum;
        downMax /= commonNum;
        System.out.println((initWeight+intNum)+"+"+removeNum+"/"+downMax);
    }

    private static int getCommonNum(int down, int up) {
        if (up == 0) {
            return down;
        }else {
            return getCommonNum(up, down % up);
        }
    }

    static class Num{
        public int up;
        public int down;

        @Override
        public String toString() {
            return "Num{" +
                    "up=" + up +
                    ", down=" + down +
                    '}';
        }
    }
}
