package work_begin.test;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by leo on 2018/7/8.
 */
public class CollectionMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int firstCount = scanner.nextInt();
            int secondCount = scanner.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0 ; i < firstCount + secondCount ; i++) {
                set.add(scanner.nextInt());
            }
            for(Integer i:set){
                System.out.print(i+" ");
            }
        }
    }
}
