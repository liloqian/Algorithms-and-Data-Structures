package work_begin.test;

import java.util.*;

/**
 * Created by leo on 2018/7/8.
 */
public class MarketBuy {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int goodCount = scanner.nextInt();
            int buyCount = scanner.nextInt();
            // 商品价格
            List<Integer> goodValueList = new ArrayList<>();
            while (--goodCount >= 0) {
                goodValueList.add(scanner.nextInt());
            }
            // 购买货物数量
            Map<String, Integer> map = new HashMap<>();
            while (--buyCount >= 0) {
                String goodName = scanner.next();
                if (map.get(goodName) != null) {
                    map.put(goodName, map.get(goodName) + 1);
                }else {
                    map.put(goodName, 1);
                }
            }

            List<Integer> goodNumList = new ArrayList<>();
            for (String str : map.keySet()) {
                goodNumList.add(map.get(str));
            }
            Collections.sort(goodNumList);
            Collections.reverse(goodNumList);
            // mim
            Collections.sort(goodValueList);
            int min = 0;
            for (int i = 0 ; i < goodNumList.size() ; i++) {
                min += goodNumList.get(i) * goodValueList.get(i);
            }
            // max
            Collections.reverse(goodValueList);
            int max = 0;
            for (int i = 0 ; i < goodNumList.size() ; i++) {
                max += goodNumList.get(i) * goodValueList.get(i);
            }
            System.out.println(min+" "+max);
        }
    }
}
