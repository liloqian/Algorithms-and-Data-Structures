package work_begin.DJ;

import java.awt.print.Book;
import java.util.*;

/**
 * Created by leo on 2018/7/8.
 */
public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tCount = scanner.nextInt();
        List<Book> listBook = new ArrayList<>();
        while (--tCount >= 0) {
            listBook.clear();
            int nBook = scanner.nextInt();
            while (--nBook >= 0) {
                Book book = new Book();
                book.h = scanner.nextInt();
                book.w = scanner.nextInt();
                book.choiceFlag = 1.0 * book.w / book.h;
                listBook.add(book);
            }
            Collections.sort(listBook);
            int hMax = hMaxDeal(listBook);
            while (canDeal(hMax,listBook)){
                hMax = hMaxDeal(listBook);
            }
//            System.out.println(listBook);
            int retH = 0;
            for (Book book : listBook) {
                if (!book.isInHigh) {
                    retH += book.h;
                }
            }
            System.out.println("#Case "+(tCount+1)+": "+retH);
        }
    }

    private static boolean canDeal(int hMax, List<Book> listBook) {
        int wHave = 0;
        for (Book book : listBook) {
            if (book.isInHigh) {
                wHave += book.w;
            }
        }
        for (Book book : listBook) {
            if (!book.isInHigh) {
                hMax -= book.h;
                if (hMax >= (wHave + book.w)) {
                    book.isInHigh = true;
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    private static int hMaxDeal(List<Book> listBook) {
        int ret = 0;
        for (Book book : listBook) {
            if (!book.isInHigh){
                ret += book.h;
            }
        }
        return ret;
    }

    static class Book implements Comparable{
        public int h;
        public  int w;
        public boolean isInHigh = false;
        public Double choiceFlag;
        @Override
        public int compareTo(Object o) {
            Book another = (Book) o;
            return this.choiceFlag.compareTo(((Book) o).choiceFlag);
        }

        @Override
        public String toString() {
            return "Book{" +
                    "h=" + h +
                    ", w=" + w +
                    ", isInHigh=" + isInHigh +
                    ", choiceFlag=" + choiceFlag +
                    '}';
        }
    }
}
