package work_begin.test;

import java.util.Scanner;

/**
 * Created by leo on 2018/8/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p1 = scanner.nextInt();
        int p2 = scanner.nextInt();
        int p3 = scanner.nextInt();
        int t1 = scanner.nextInt();
        int t2 = scanner.nextInt();
        Range[] arrToCal = new Range[n];
//        System.out.println(n+" "+p1+" "+p2+" "+p3+" "+t1+" "+t2);
        for (int i = 0 ; i < n ; i++) {
            arrToCal[i] = new Range();
            arrToCal[i].start = scanner.nextInt();
            arrToCal[i].end = scanner.nextInt();
//            System.out.println(arrToCal[i].toString());
        }

        int ret = 0;
        // 工作时间
        for (int i = 0 ; i < n ; i++) {
            int tempTime = arrToCal[i].end - arrToCal[i].start;
            if (tempTime <= 0) {
                continue;
            }
            ret += p1 * tempTime;
        }
        // 休眠时间
        int lastTime = arrToCal[0].end;
        for (int i = 1 ; i < n ;i++) {
            int sleepTime = arrToCal[i].start - lastTime;
            // 未进入第一段时间
            if (sleepTime >= t1) {
                ret += t1 * p1;
                sleepTime -= t1;
            }else {
                ret += sleepTime * p1;
                lastTime = arrToCal[i].end;
                continue;
            }
            // 进入第一段时间
            if (sleepTime >= t2 ) {
                ret += t2 * p2;
                sleepTime -= t2;
            }else {
                ret += sleepTime * p2;
                lastTime = arrToCal[i].end;
                continue;
            }

            // 进入第二段时间
            ret += sleepTime * p3;
            lastTime = arrToCal[i].end;
        }

        System.out.println(ret);
    }

    static class Range{
        public int start;
        public int end;

        @Override
        public String toString() {
            return "Range{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
