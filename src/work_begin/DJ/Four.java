package work_begin.DJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by leo on 2018/7/8.
 */
public class Four {
    private static int FIRE_TIME_DUR = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int aniCount = scanner.nextInt();
        FIRE_TIME_DUR = scanner.nextInt();
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        int endX = scanner.nextInt();
        int endY = scanner.nextInt();
        List<Animal> animals = new ArrayList<>();
        for (int i = 0 ;i < aniCount ; i++) {
            Animal animal = new Animal();
            animal.fireDirect = scanner.nextInt();
            animal.x = scanner.nextInt();
            animal.y = scanner.nextInt();
            animals.add(animal);
        }
        int timeConsume = 0;
        boolean isRight = (endX - startX) > 0;
        boolean isUp = (endY - startY) > 0;
//        while (startX != endX || startY != endY) {
//            System.out.println(startX+"  "+startY);
//            if (!haveFireRight(startX,startY,isRight,animals,timeConsume)) {
//                if (isRight) {
//                    startX += 1;
//                }else {
//                    startX -= 1;
//                }
//            }
//            if (!haveFireUp(startX, startY, isUp, animals ,timeConsume)) {
//                if (isUp) {
//                    startY += 1;
//                }else {
//                    startY -= 1;
//                }
//            }
//            timeConsume++;
//        }
//        System.out.println(timeConsume);
        System.out.println((endX-startX)+(endY-startY));

    }

    private static boolean haveFireUp(int startX, int startY, boolean isUp, List<Animal> animals, int timeConsume) {
        if (isUp) {
            startY += 1;
        }else {
            startY -= 1;
        }
        // (1, 2, 3, 4)，即方向（上、下、左、右）
        for (Animal animal : animals) {
            int animalX = animal.x;
            int animalY = animal.y;
            if (animal.fireDirect == 1) {
                animalY += (timeConsume % FIRE_TIME_DUR + 1);
            }else if (animal.fireDirect == 2) {
                animalY -= (timeConsume % FIRE_TIME_DUR + 1);
            }else if (animal.fireDirect == 3) {
                animalX -= (timeConsume % FIRE_TIME_DUR + 1);
            }else {
                animalX += (timeConsume % FIRE_TIME_DUR + 1);
            }
            if (animalX == startX && animalY == startY) {
                return true;
            }
        }
        return false;
    }

    private static boolean haveFireRight(int startX, int startY, boolean isRight, List<Animal> animals, int timeConsume) {
        if (isRight) {
            startX += 1;
        }else {
            startX -= 1;
        }
        // (1, 2, 3, 4)，即方向（上、下、左、右）
        for (Animal animal : animals) {
            int animalX = animal.x;
            int animalY = animal.y;
            if (animal.fireDirect == 1) {
                animalY += (timeConsume % FIRE_TIME_DUR + 1);
            }else if (animal.fireDirect == 2) {
                animalY -= (timeConsume % FIRE_TIME_DUR + 1);
            }else if (animal.fireDirect == 3) {
                animalX -= (timeConsume % FIRE_TIME_DUR + 1);
            }else {
                animalX += (timeConsume % FIRE_TIME_DUR + 1);
            }
            if (animalX == startX && animalY == startY) {
                return true;
            }
        }
        return false;
    }

    static class Animal{
        int x;
        int y;
        int fireDirect;
    }
}
