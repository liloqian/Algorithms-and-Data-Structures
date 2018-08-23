package work_begin.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by leo on 2018/7/8.
 */
public class MoveRoad {
    private static final ArrayList<String> wayList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String start = scanner.next();
            String end = scanner.next();
            wayList.clear();
            deal(start,end);
            System.out.println(wayList.size());
            for (String str : wayList) {
                System.out.println(str);
            }
        }
    }

    private static void deal(String start, String end) {
        char startX = start.charAt(0);
        char startY = start.charAt(1);
        char endX = end.charAt(0);
        char endY = end.charAt(1);

        if (startY == endY) {
            int xDiff = endX - startX;
            boolean flag = xDiff > 0;
            xDiff = Math.abs(xDiff);
            for (; xDiff > 0 ; xDiff--) {
                if (flag) {
                    wayList.add("R");
                }else {
                    wayList.add("L");
                }
            }
            return;
        }
        if (startX == endX) {
            int yDiff = endY - startY;
            boolean flag = yDiff > 0;
            yDiff = Math.abs(yDiff);
            for ( ; yDiff > 0 ; yDiff--) {
                if (flag){
                    wayList.add("U");
                }else {
                    wayList.add("D");
                }
            }
            return;
        }

        int xDiff = endX - startX;
        int yDiff = endY - startY;
        if (xDiff > 0 && yDiff > 0) {
            wayList.add("RU");
            char tempX = (char)(startX + 1);
            char tempY = (char)(startY + 1);
            deal(""+tempX+tempY,end);
        }else if (xDiff > 0 && yDiff < 0) {
            wayList.add("RD");
            char tempX = (char)(startX + 1);
            char tempY = (char)(startY - 1);
            deal(""+tempX+tempY,end);
        }else if (yDiff > 0) {
            wayList.add("LU");
            char tempX = (char)(startX - 1);
            char tempY = (char)(startY + 1);
            deal(""+tempX+tempY,end);
        }else {
            wayList.add("LD");
            char tempX = (char)(startX - 1);
            char tempY = (char)(startY - 1);
            deal(""+tempX+tempY,end);
        }
    }
}
