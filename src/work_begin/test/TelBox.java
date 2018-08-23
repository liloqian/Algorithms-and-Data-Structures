package work_begin.test;

import java.util.Scanner;

/**
 * Created by leo on 2018/7/5.
 */
public class TelBox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        while (--count >= 0 ) {
            String input = scanner.next();
            if (isBoxToComm(input)) {
                int indexC = input.lastIndexOf("C");
                String row = input.substring(1,indexC);
                String col = input.substring(indexC+1,input.length());
                System.out.println(numToChar(col)+row);
            }else {
                int rowLen = rowLen(input);
                System.out.println("R"+input.substring(input.length() - rowLen , input.length())
                        + "C" + charToNum(input.substring(0,rowLen)));
            }
        }
    }

    private static String charToNum(String str) {
        int retInt = 0;
        for (int i = 0 ; i < str.length() ; i++) {
            retInt *= 26;
            retInt += (str.charAt(i) - 'A' + 1);
        }
        return String.valueOf(retInt);
    }

    private static int rowLen(String input) {
        int retLen = 0;
        for (int i = 0 ; i < input.length() ; i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9' ){
                retLen++;
            }else {
                break;
            }
        }
        return retLen;
    }

    private static String numToChar(String col) {
        int num = Integer.valueOf(col);
        String ret = "";
        int finalNum = num % 26;
        num = (num - finalNum) / 26;
        if (num != 0) {
            String numStr = String.valueOf(num);
            for (int i = 0 ; i < numStr.length() ; i++) {
                ret += (char)('A' + numStr.charAt(i) - '0' - 1);
            }
        }
        ret += (char)('A' + finalNum - 1);
        return ret;
    }

    private static boolean isBoxToComm(String input) {
        if (!input.contains("c") && !input.contains("C")) {
            return false;
        }
        int index = input.lastIndexOf("C");
        if (index <= 0) {
            return false;
        }
        return isNum(input.charAt(index - 1)) && isNum(input.charAt(index + 1));
    }
    private static boolean isNum(char c){
        if (c >= '0' && c <= '9') {
            return true;
        }else {
            return false;
        }
    }
}
