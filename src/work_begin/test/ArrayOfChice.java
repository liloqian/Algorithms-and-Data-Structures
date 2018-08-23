package work_begin.test;

import java.util.*;

/**
 * Created by leo on 2018/7/22.
 */
public class ArrayOfChice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> dataList = new ArrayList<>();

        int count = scanner.nextInt();
        for (int i = 0 ; i < count ; i++) {
            dataList.add(scanner.nextInt());
        }

        Collections.sort(dataList);
        int size = dataList.size();
        if (dataList.get(size - 1) < 0) {
            System.out.println((long)dataList.get(size - 1) * dataList.get(size - 2) * dataList.get(size - 3));
        }else if (dataList.get(size - 1) == 0){
            System.out.println(0);
        }else {
            long temp = dataList.get(size-1);
            long twoNegative = dataList.get(0) * dataList.get(1);
            long twoPositive = dataList.get(size-2) * dataList.get(size-3);
            System.out.println(twoNegative > twoPositive ? temp * twoNegative : temp * twoPositive);
        }
    }
}
