package com.leo.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qian
 * @Description: Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * @Date: Created in 11:28 2018/4/1
 **/
public class Problem03 {
    public int maxPoints(Point[] points) {
        int n = points.length;
        if (n < 2) {
            return n;
        }

        int ret = 0;
        for (int i = 0 ; i < n ; i++) {
            int dup = 1, vlt = 0;
            Map<Float, Integer> map = new HashMap<>();
            Point a = points[i];

            for (int j = 0 ; j < n ; j++) {
                if (j == i) {
                    continue;
                }
                Point b = points[j];
                if (a.x == b.x) {
                    if (a.y == b.y) {
                        dup++;
                    }else {
                        vlt++;
                    }
                }else {
                    float k = (float) (a.y - b.y) / (a.x - b.x);
                    if (map.get(k) == null) {
                        map.put(k,1);
                    }else {
                        map.put(k,map.get(k)+1);
                    }
                }
            }
            int max = vlt;
            for (float k : map.keySet()) {
                max = Math.max(max, map.get(k));
            }
            ret = Math.max(ret, max + dup);
        }

        return ret;

    }


}

class Point {
    int x;
    int y;

    public Point(){
        this(0,0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
