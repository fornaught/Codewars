<<<<<<< HEAD
package com.company;

import java.util.*;
import java.util.stream.Collectors;

class Rectangle<Rectangle> {

    Integer minX;
    Integer maxX;
    Integer minY;
    Integer maxY;
    Integer rectangleSum;

    public Rectangle(int[] input) {

        this.minX = input[0];
        this.maxX = input[2];
        this.minY = input[1];
        this.maxY = input[3];
        this.rectangleSum = (input[2] - input[0]) * (input[3] - input[1]);
    }
}

class MaxXComp implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle r1, Rectangle r2) {
        return r1.maxX.compareTo(r2.maxX);
    }
}

class MaxYComp implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle r1, Rectangle r2) {
        return r1.maxY.compareTo(r2.maxY);
    }
}

class MinXComp implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle r1, Rectangle r2) {
        return r2.minX.compareTo(r1.minX);
    }
}

class MinYComp implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle r1, Rectangle r2) {
        return r2.minY.compareTo(r1.minY);
    }
}

public class RectanglesUnion {

//    private static final Comparator<Rectangle> maxXComperator = Comparator
//            .comparingInt((Rectangle p) -> p.maxX).thenComparing((Rectangle p) -> p.maxX);
//
//    public static final Comparator<Rectangle> maxYComperator
//            = new Comparator<Rectangle>() {
//
//        public int compare(Rectangle r1, Rectangle r2) {
//
//            //ascending order
//            return r1.maxY - r2.maxY;
//
//            //descending order
//            //return fruitName2.compareTo(fruitName1);
//        }
//
//        public int CompareMaxX(Rectangle r1, Rectangle r2) {
//            return r1.maxX - r2.maxX;
//        }

//    };


    static ArrayList<Rectangle> field2 = new ArrayList<>();
    //        @Override
//        public int compare(Integer o1, Integer o2) {
//            if (o1 < o2)
//                return -1;
//            if (o1 > o2)
//                return 1;
//            else
//                return 0;
//        }
//    });
    static HashSet<Rectangle> field4 = new HashSet<>();
    static int sum = 0;
    static int tempIndex = 0;


    public static int calculateSpace(int[][] rectangles) {
        sum = 0;
        tempIndex = 0;
        field2.clear();
        field4.clear();
        field4.add(new Rectangle(rectangles[0]));
        for (int i = 1; i < rectangles.length; i++) {
            checkOverlap(new Rectangle(rectangles[i]));
        }
        System.out.println(field4.size());
        for (Rectangle r : field4) {
            sum += r.rectangleSum;
        }
//        for (Map.Entry<Integer, Rectangle> entry : field3.entrySet()) {
//            Integer key = entry.getKey();
//            Rectangle value = entry.getValue();
//
//            System.out.println(key);
//        }
        System.out.println(sum);
        return sum;
    }

    public static void checkOverlap(Rectangle rectangle) {
        //tempIndex = 0;
//        Rectangle bob = Collections.max(field3.values(), new MaxXComp());
//        System.out.println("bob = " + bob.maxX);

//       for (Integer i = 0; i < field3.size(); i++) {
//            //toprightoverlap
//            if (rectangle.minX < r.maxX && rectangle.minY < r.maxY
//                    && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY) {
        Rectangle fr = field4.stream().filter(r -> rectangle.minX < r.maxX && rectangle.minY < r.maxY
                && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY).max(new MaxYComp()).orElse(null);


        if (fr != null) {
//                    && rectangle.minX >= r.minX && rectangle.minY >= r.minY) {

//                System.out.println("hoi1 " + field3.size());
//                System.out.println("yes " + tempIndex);
            field4.add(new Rectangle(new int[]{rectangle.minX, fr.maxY, rectangle.maxX, rectangle.maxY}));
            field4.add(new Rectangle(new int[]{fr.maxX, rectangle.minY, rectangle.maxX, fr.maxY}));


//                        field2.add(new Rectangle(new int[] {r.maxX, r.maxY, rectangle.maxX, rectangle.maxY}));
//                        field2.add(new Rectangle(new int[] {r.maxX, rectangle.minY, rectangle.maxX, r.maxY}));
//                        break;
            //System.out.println("{"+ rectangle.minX + ", " + rectangle.maxX + ", " + rectangle.maxX + ", " + rectangle.maxY + "},");
//                sum += (r.maxX - rectangle.minX) * (rectangle.maxY - r.maxY);
            //System.out.println((r.maxX - rectangle.minX) + " " + (rectangle.maxY - r.maxY));
//                sum += (rectangle.maxX - r.maxX) * (rectangle.maxY - rectangle.minY);
            //System.out.println((rectangle.maxX - r.maxX)+ " " + (rectangle.maxY - rectangle.minY));

            //overlaps.add(new Rectangle(new int[] {rectangle.minX, rectangle.minY, r.maxX, r.maxY}));
            return;
        }

        //bottomleftoverlap                 TO DO: deze if condities in filters implementeren en kijken of onderstaande rectangles wel kloppen... voor de zoveelste keer
//        if (rectangle.maxX > r.maxX && rectangle.maxY > r.minY
//                && rectangle.minX < r.minX && rectangle.minY < r.minY) {
        fr = field4.stream().filter(r -> rectangle.maxX < r.maxX && rectangle.maxY > r.minY
                && rectangle.minX < r.minX && rectangle.minY < r.minY).max(new MinXComp()).orElse(null);
        if (fr != null) {
//            Rectangle a = new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY});
//            System.out.println("a: " + a.rectangleSum);
//            Rectangle b = new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, fr.minY});
//            System.out.println("b: " + b.rectangleSum);
            field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY}));
            field4.add(new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, rectangle.maxY}));

            return;
        }
//        //after this point overlaps are old if conditions not new values, and are yet to be replaced. have fun.
//        //topleft
        fr = field4.stream().filter(r -> rectangle.maxX >r.minX &&rectangle.minY<r.maxY
                &&rectangle.minX<r.minX &&rectangle.maxY >r.maxY).max(new MinXComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY}));
            field4.add(new Rectangle(new int[]{fr.minX, fr.maxY, rectangle.maxX, rectangle.maxY}));
            return;
        }
//
//        //bottomright
        fr = field4.stream().filter(r -> rectangle.minX<r.maxX &&rectangle.maxY >r.minY
                &&rectangle.maxX >r.maxX &&rectangle.minY<r.minY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, fr.maxY}));
            field4.add(new Rectangle(new int[]{fr.maxX, fr.minY, rectangle.maxX, rectangle.maxY}));
            return;
        }

        //horizontaloverlap           //comperators from this point on can be messed up
        fr = field4.stream().filter(r -> rectangle.minX<r.maxX && rectangle.maxX > r.maxX && rectangle.minY >= r.minY && rectangle.maxY <= r.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, rectangle.maxY}));
            field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.maxX, rectangle.maxY}));
            return;
        }

        //verticaloverlap
        fr = field4.stream().filter(r -> rectangle.minY < r.maxY && rectangle.maxY > r.maxY && rectangle.minX >= r.minX && rectangle.maxX <= r.maxX).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{rectangle.minX, fr.minY, rectangle.maxX, rectangle.maxY}));
            field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, fr.maxY}));
            return;
        }

        //rightextension
        fr = field4.stream().filter(r -> rectangle.maxX > r.maxX && rectangle.minY >= r.minY && rectangle.maxY <= r.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, rectangle.maxY}));
            return;
        }

        //leftextension
        fr = field4.stream().filter(r -> rectangle.minX < r.minX && rectangle.minY >= r.minY && rectangle.maxY <= r.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.maxX, rectangle.maxY}));
            return;
        }

        //topextension
        fr = field4.stream().filter(r -> rectangle.maxY > r.maxY && rectangle.minX >= r.minX && rectangle.maxX <= r.maxX).max(new MinYComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{rectangle.minX, fr.minY, rectangle.maxX, rectangle.maxY}));
            return;
        }

//         //bottomextension
         fr = field4.stream().filter(r -> rectangle.minY < r.minY && rectangle.minX >= r.minX && rectangle.maxX <= r.maxX).max(new MaxYComp()).orElse(null);
         if (fr != null) {
             field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, fr.maxY}));
             return;
         }
          else {
              field4.add(rectangle);
          }
    }
=======
package com.company;

import java.util.*;
import java.util.stream.Collectors;

class Rectangle<Rectangle> {

    Integer minX;
    Integer maxX;
    Integer minY;
    Integer maxY;
    Integer rectangleSum;

    public Rectangle(int[] input) {

        this.minX = input[0];
        this.maxX = input[2];
        this.minY = input[1];
        this.maxY = input[3];
        this.rectangleSum = (input[2] - input[0]) * (input[3] - input[1]);
    }
}

class MaxXComp implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle r1, Rectangle r2) {
        return r1.maxX.compareTo(r2.maxX);
    }
}

class MaxYComp implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle r1, Rectangle r2) {
        return r1.maxY.compareTo(r2.maxY);
    }
}

class MinXComp implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle r1, Rectangle r2) {
        return r2.minX.compareTo(r1.minX);
    }
}

class MinYComp implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle r1, Rectangle r2) {
        return r2.minY.compareTo(r1.minY);
    }
}

public class RectanglesUnion {

//    private static final Comparator<Rectangle> maxXComperator = Comparator
//            .comparingInt((Rectangle p) -> p.maxX).thenComparing((Rectangle p) -> p.maxX);
//
//    public static final Comparator<Rectangle> maxYComperator
//            = new Comparator<Rectangle>() {
//
//        public int compare(Rectangle r1, Rectangle r2) {
//
//            //ascending order
//            return r1.maxY - r2.maxY;
//
//            //descending order
//            //return fruitName2.compareTo(fruitName1);
//        }
//
//        public int CompareMaxX(Rectangle r1, Rectangle r2) {
//            return r1.maxX - r2.maxX;
//        }

//    };


    static ArrayList<Rectangle> field2 = new ArrayList<>();
    //        @Override
//        public int compare(Integer o1, Integer o2) {
//            if (o1 < o2)
//                return -1;
//            if (o1 > o2)
//                return 1;
//            else
//                return 0;
//        }
//    });
    static HashSet<Rectangle> field4 = new HashSet<>();
    static int sum = 0;
    static int tempIndex = 0;


    public static int calculateSpace(int[][] rectangles) {
        sum = 0;
        tempIndex = 0;
        field2.clear();
        field4.clear();
        field4.add(new Rectangle(rectangles[0]));
        for (int i = 1; i < rectangles.length; i++) {
            checkOverlap(new Rectangle(rectangles[i]));
        }
        System.out.println(field4.size());
        for (Rectangle r : field4) {
            sum += r.rectangleSum;
        }
//        for (Map.Entry<Integer, Rectangle> entry : field3.entrySet()) {
//            Integer key = entry.getKey();
//            Rectangle value = entry.getValue();
//
//            System.out.println(key);
//        }
        System.out.println(sum);
        return sum;
    }

    public static void checkOverlap(Rectangle rectangle) {
        //tempIndex = 0;
//        Rectangle bob = Collections.max(field3.values(), new MaxXComp());
//        System.out.println("bob = " + bob.maxX);

//       for (Integer i = 0; i < field3.size(); i++) {
//            //toprightoverlap
//            if (rectangle.minX < r.maxX && rectangle.minY < r.maxY
//                    && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY) {
        Rectangle fr = field4.stream().filter(r -> rectangle.minX < r.maxX && rectangle.minY < r.maxY
                && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY).max(new MaxYComp()).orElse(null);


        if (fr != null) {
//                    && rectangle.minX >= r.minX && rectangle.minY >= r.minY) {

//                System.out.println("hoi1 " + field3.size());
//                System.out.println("yes " + tempIndex);
            field4.add(new Rectangle(new int[]{rectangle.minX, fr.maxY, rectangle.maxX, rectangle.maxY}));
            field4.add(new Rectangle(new int[]{fr.maxX, rectangle.minY, rectangle.maxX, fr.maxY}));


//                        field2.add(new Rectangle(new int[] {r.maxX, r.maxY, rectangle.maxX, rectangle.maxY}));
//                        field2.add(new Rectangle(new int[] {r.maxX, rectangle.minY, rectangle.maxX, r.maxY}));
//                        break;
            //System.out.println("{"+ rectangle.minX + ", " + rectangle.maxX + ", " + rectangle.maxX + ", " + rectangle.maxY + "},");
//                sum += (r.maxX - rectangle.minX) * (rectangle.maxY - r.maxY);
            //System.out.println((r.maxX - rectangle.minX) + " " + (rectangle.maxY - r.maxY));
//                sum += (rectangle.maxX - r.maxX) * (rectangle.maxY - rectangle.minY);
            //System.out.println((rectangle.maxX - r.maxX)+ " " + (rectangle.maxY - rectangle.minY));

            //overlaps.add(new Rectangle(new int[] {rectangle.minX, rectangle.minY, r.maxX, r.maxY}));
            return;
        }

        //bottomleftoverlap                 TO DO: deze if condities in filters implementeren en kijken of onderstaande rectangles wel kloppen... voor de zoveelste keer
//        if (rectangle.maxX > r.maxX && rectangle.maxY > r.minY
//                && rectangle.minX < r.minX && rectangle.minY < r.minY) {
        fr = field4.stream().filter(r -> rectangle.maxX < r.maxX && rectangle.maxY > r.minY
                && rectangle.minX < r.minX && rectangle.minY < r.minY).max(new MinXComp()).orElse(null);
        if (fr != null) {
//            Rectangle a = new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY});
//            System.out.println("a: " + a.rectangleSum);
//            Rectangle b = new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, fr.minY});
//            System.out.println("b: " + b.rectangleSum);
            field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY}));
            field4.add(new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, rectangle.maxY}));

            return;
        }
//        //after this point overlaps are old if conditions not new values, and are yet to be replaced. have fun.
//        //topleft
        fr = field4.stream().filter(r -> rectangle.maxX >r.minX &&rectangle.minY<r.maxY
                &&rectangle.minX<r.minX &&rectangle.maxY >r.maxY).max(new MinXComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY}));
            field4.add(new Rectangle(new int[]{fr.minX, fr.maxY, rectangle.maxX, rectangle.maxY}));
            return;
        }
//
//        //bottomright
        fr = field4.stream().filter(r -> rectangle.minX<r.maxX &&rectangle.maxY >r.minY
                &&rectangle.maxX >r.maxX &&rectangle.minY<r.minY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, fr.maxY}));
            field4.add(new Rectangle(new int[]{fr.maxX, fr.minY, rectangle.maxX, rectangle.maxY}));
            return;
        }

        //horizontaloverlap           //comperators from this point on can be messed up
        fr = field4.stream().filter(r -> rectangle.minX<r.maxX && rectangle.maxX > r.maxX && rectangle.minY >= r.minY && rectangle.maxY <= r.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, rectangle.maxY}));
            field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.maxX, rectangle.maxY}));
            return;
        }

        //verticaloverlap
        fr = field4.stream().filter(r -> rectangle.minY < r.maxY && rectangle.maxY > r.maxY && rectangle.minX >= r.minX && rectangle.maxX <= r.maxX).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{rectangle.minX, fr.minY, rectangle.maxX, rectangle.maxY}));
            field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, fr.maxY}));
            return;
        }

        //rightextension
        fr = field4.stream().filter(r -> rectangle.maxX > r.maxX && rectangle.minY >= r.minY && rectangle.maxY <= r.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, rectangle.maxY}));
            return;
        }

        //leftextension
        fr = field4.stream().filter(r -> rectangle.minX < r.minX && rectangle.minY >= r.minY && rectangle.maxY <= r.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.maxX, rectangle.maxY}));
            return;
        }

        //topextension
        fr = field4.stream().filter(r -> rectangle.maxY > r.maxY && rectangle.minX >= r.minX && rectangle.maxX <= r.maxX).max(new MinYComp()).orElse(null);
        if (fr != null) {
            field4.add(new Rectangle(new int[]{rectangle.minX, fr.minY, rectangle.maxX, rectangle.maxY}));
            return;
        }

//         //bottomextension
         fr = field4.stream().filter(r -> rectangle.minY < r.minY && rectangle.minX >= r.minX && rectangle.maxX <= r.maxX).max(new MaxYComp()).orElse(null);
         if (fr != null) {
             field4.add(new Rectangle(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, fr.maxY}));
             return;
         }
          else {
              field4.add(rectangle);
          }
    }
>>>>>>> cb881e417863984f2fdc738a364bbde6b5f3e18b
}