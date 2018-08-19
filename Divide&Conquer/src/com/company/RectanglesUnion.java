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
    static TreeMap<Integer, Rectangle> field3 = new TreeMap<>();
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
    HashSet<Rectangle> field4 = new HashSet<>();
    static int sum = 0;
    static int tempIndex = 0;


    public static int calculateSpace(int[][] rectangles) {
        sum = 0;
        tempIndex = 0;
        field2.clear();
        field3.clear();
        field3.put(0, new Rectangle(rectangles[0]));
        for (int i = 1; i < rectangles.length; i++) {
            checkOverlap(new Rectangle(rectangles[i]), i);
        }
        System.out.println(field3.size());
        for (int i = 0; i < field3.size(); i++) {
            sum += field3.get(i).rectangleSum;
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

    public static void checkOverlap(Rectangle rectangle, int Index) {
        //tempIndex = 0;
//        Rectangle bob = Collections.max(field3.values(), new MaxXComp());
//        System.out.println("bob = " + bob.maxX);

        //partialtop
        Rectangle fr = field3.values().stream().filter(r -> rectangle.minY < r.maxY && r.maxY < rectangle.maxY && r.minX > rectangle.minX && r.maxX < rectangle.maxX).max(new MaxYComp()).orElse(null);
        if (fr != null)
        {
            System.out.println("partialtop");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX,rectangle.minY,fr.minX,rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.minX,fr.maxY,fr.maxX,rectangle.maxY}));
            field3.put(tempIndex + 3, new Rectangle(new int[]{fr.maxX,rectangle.minY,rectangle.maxX,rectangle.maxY}));
            tempIndex += 3;
            return;
        }

//        partialbottom
        fr = field3.values().stream().filter(r -> rectangle.maxY < r.minY && r.minY > rectangle.minY && r.minX > rectangle.minX && r.maxX < rectangle.maxX).max(new MaxYComp()).orElse(null);
        if (fr != null)
        {
            System.out.println("partialtop");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX,rectangle.minY,fr.minX,rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.minX,rectangle.minY,fr.maxX,fr.minY}));
            field3.put(tempIndex + 3, new Rectangle(new int[]{fr.maxX,rectangle.minY,rectangle.maxX,rectangle.maxY}));
            tempIndex += 3;
            return;
        }

        //partialleft
        fr = field3.values().stream().filter(r -> rectangle.maxX < r.minX && r.minX > rectangle.minX && r.minY > rectangle.minY && r.maxY < rectangle.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null)
        {
            System.out.println("partialtop");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX,rectangle.minY,rectangle.maxX, fr.minY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{rectangle.minX,fr.minY,fr.minX,fr.maxY}));
            field3.put(tempIndex + 3, new Rectangle(new int[]{rectangle.minX,fr.maxY,rectangle.maxX,rectangle.maxY}));
            tempIndex += 3;
            return;
        }

        //partialright
        fr = field3.values().stream().filter(r -> r.maxX > rectangle.minX && r.maxX < rectangle.maxX && r.minY > rectangle.minY && r.maxY < rectangle.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null)
        {
            System.out.println("partialright");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX,rectangle.minY,rectangle.maxX, fr.minY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.maxX,fr.minY,rectangle.maxX,fr.maxY}));
            field3.put(tempIndex + 3, new Rectangle(new int[]{rectangle.minX,fr.maxY,rectangle.maxX,rectangle.maxY}));
            tempIndex += 3;
            return;
        }

//       for (Integer i = 0; i < field3.size(); i++) {
//            //toprightoverlap
//            if (rectangle.minX < r.maxX && rectangle.minY < r.maxY
//                    && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY) {
        fr = field3.values().stream().filter(r -> rectangle.minX < r.maxX && rectangle.minY < r.maxY
                && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY).max(new MaxYComp()).orElse(null);


        if (fr != null) {
//                    && rectangle.minX >= r.minX && rectangle.minY >= r.minY) {

            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, fr.maxY, rectangle.maxX, rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.maxX, rectangle.minY, rectangle.maxX, fr.maxY}));
            tempIndex += 2;

            System.out.println("toprightoverlap");

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

        //bottomleftoverlap
//        if (rectangle.maxX > r.maxX && rectangle.maxY > r.minY
//                && rectangle.minX < r.minX && rectangle.minY < r.minY) {
        fr = field3.values().stream().filter(r -> rectangle.maxX < r.maxX && rectangle.maxY > r.minY
                && rectangle.minX < r.minX && rectangle.minY < r.minY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            System.out.println("bottomleftoverlap");
//            Rectangle a = new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY});
//            System.out.println("a: " + a.rectangleSum);
//            Rectangle b = new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, fr.minY});
//            System.out.println("b: " + b.rectangleSum);
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, fr.minY}));
            tempIndex += 2;
            return;
        }
//        //after this point overlaps are old if conditions not new values, and are yet to be replaced. have fun.
//        //topleft
        fr = field3.values().stream().filter(r -> rectangle.maxX >r.minX &&rectangle.minY<r.maxY
                &&rectangle.minX<r.minX &&rectangle.maxY >r.maxY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            System.out.println("topleftoverlap");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.minX, fr.maxY, rectangle.maxX, rectangle.maxY}));
            tempIndex += 2;
            return;
        }
//
//        //bottomright
        fr = field3.values().stream().filter(r -> rectangle.minX<r.maxX &&rectangle.maxY >r.minY
                &&rectangle.maxX >r.maxX &&rectangle.minY<r.minY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            System.out.println("bottomrightoverlap");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, fr.minY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.maxX, fr.minY, rectangle.maxX, rectangle.maxY}));
            tempIndex += 2;
            return;
        }

        //horizontaloverlap           //comperators from this point on can be messed up
        fr = field3.values().stream().filter(r -> rectangle.minX<r.minX && rectangle.maxX > r.maxX && rectangle.minY >= r.minY && rectangle.maxY <= r.maxY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            System.out.println("horizontaloverlap");
            field3.put(tempIndex + 1, new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY}));
            tempIndex++;
            return;
        }

        //verticaloverlap
        fr = field3.values().stream().filter(r -> rectangle.minY < r.minY && rectangle.maxY > r.maxY && rectangle.minX >= r.minX && rectangle.maxX <= r.maxX).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            System.out.println("verticaloverlap");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, fr.maxY, rectangle.maxX, rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, fr.minY}));
            tempIndex++;
            return;
        }

        //topextension
        fr = field3.values().stream().filter(r -> rectangle.maxY > r.maxY && rectangle.minX >= r.minX && rectangle.maxX <= r.maxX && rectangle.minY > r.minY
                && rectangle.minY < r.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            System.out.println("topextension");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, fr.maxY, rectangle.maxX, rectangle.maxY}));
            tempIndex++;
            return;
        }
//
//        //bottomextension
        fr = field3.values().stream().filter(r -> rectangle.minY < r.minY && rectangle.minX >= r.minX && rectangle.maxX <= r.maxX && rectangle.maxY < r.maxY
                && rectangle.maxY < r.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            System.out.println("bottomextension");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, fr.minY}));
            tempIndex++;
            return;
        }

        //rightextension
        fr = field3.values().stream().filter(r -> rectangle.maxX > r.maxX && rectangle.minY >= r.minY && rectangle.maxY <= r.maxY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            System.out.println("rightextension");
            field3.put(tempIndex + 1, new Rectangle(new int[]{fr.maxX, rectangle.minY, rectangle.maxX, rectangle.maxY}));
            tempIndex++;
            return;
        }

        //leftextension
        fr = field3.values().stream().filter(r -> rectangle.minX < r.minX && rectangle.minY >= r.minY && rectangle.maxY <= r.maxY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            System.out.println("leftextension");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY}));
            tempIndex++;
            return;
        }
        fr = field3.values().stream().filter(r -> rectangle.minY > r.maxY || rectangle.minX > r.maxX|| rectangle.maxY < r.minY || rectangle.maxX < r.minX).max(new MaxYComp()).orElse(null);
        if (fr == null) {
            System.out.println("no overlap");
            field3.put(tempIndex, rectangle);
            tempIndex++;
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
    static TreeMap<Integer, Rectangle> field3 = new TreeMap<>();
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
    HashSet<Rectangle> field4 = new HashSet<>();
    static int sum = 0;
    static int tempIndex = 0;


    public static int calculateSpace(int[][] rectangles) {
        sum = 0;
        tempIndex = 0;
        field2.clear();
        field3.clear();
        field3.put(0, new Rectangle(rectangles[0]));
        for (int i = 1; i < rectangles.length; i++) {
            checkOverlap(new Rectangle(rectangles[i]), i);
        }
        System.out.println(field3.size());
        for (int i = 0; i < field3.size(); i++) {
            sum += field3.get(i).rectangleSum;
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

    public static void checkOverlap(Rectangle rectangle, int Index) {
        //tempIndex = 0;
//        Rectangle bob = Collections.max(field3.values(), new MaxXComp());
//        System.out.println("bob = " + bob.maxX);

        //partialtop
        Rectangle fr = field3.values().stream().filter(r -> rectangle.minY < r.maxY && r.maxY < rectangle.maxY && r.minX > rectangle.minX && r.maxX < rectangle.maxX).max(new MaxYComp()).orElse(null);
        if (fr != null)
        {
            System.out.println("partialtop");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX,rectangle.minY,fr.minX,rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.minX,fr.maxY,fr.maxX,rectangle.maxY}));
            field3.put(tempIndex + 3, new Rectangle(new int[]{fr.maxX,rectangle.minY,rectangle.maxX,rectangle.maxY}));
            tempIndex += 3;
            return;
        }

//        partialbottom
        fr = field3.values().stream().filter(r -> rectangle.maxY < r.minY && r.minY > rectangle.minY && r.minX > rectangle.minX && r.maxX < rectangle.maxX).max(new MaxYComp()).orElse(null);
        if (fr != null)
        {
            System.out.println("partialtop");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX,rectangle.minY,fr.minX,rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.minX,rectangle.minY,fr.maxX,fr.minY}));
            field3.put(tempIndex + 3, new Rectangle(new int[]{fr.maxX,rectangle.minY,rectangle.maxX,rectangle.maxY}));
            tempIndex += 3;
            return;
        }

        //partialleft
        fr = field3.values().stream().filter(r -> rectangle.maxX < r.minX && r.minX > rectangle.minX && r.minY > rectangle.minY && r.maxY < rectangle.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null)
        {
            System.out.println("partialtop");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX,rectangle.minY,rectangle.maxX, fr.minY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{rectangle.minX,fr.minY,fr.minX,fr.maxY}));
            field3.put(tempIndex + 3, new Rectangle(new int[]{rectangle.minX,fr.maxY,rectangle.maxX,rectangle.maxY}));
            tempIndex += 3;
            return;
        }

        //partialright
        fr = field3.values().stream().filter(r -> r.maxX > rectangle.minX && r.maxX < rectangle.maxX && r.minY > rectangle.minY && r.maxY < rectangle.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null)
        {
            System.out.println("partialright");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX,rectangle.minY,rectangle.maxX, fr.minY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.maxX,fr.minY,rectangle.maxX,fr.maxY}));
            field3.put(tempIndex + 3, new Rectangle(new int[]{rectangle.minX,fr.maxY,rectangle.maxX,rectangle.maxY}));
            tempIndex += 3;
            return;
        }

//       for (Integer i = 0; i < field3.size(); i++) {
//            //toprightoverlap
//            if (rectangle.minX < r.maxX && rectangle.minY < r.maxY
//                    && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY) {
        fr = field3.values().stream().filter(r -> rectangle.minX < r.maxX && rectangle.minY < r.maxY
                && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY).max(new MaxYComp()).orElse(null);


        if (fr != null) {
//                    && rectangle.minX >= r.minX && rectangle.minY >= r.minY) {

            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, fr.maxY, rectangle.maxX, rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.maxX, rectangle.minY, rectangle.maxX, fr.maxY}));
            tempIndex += 2;

            System.out.println("toprightoverlap");

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

        //bottomleftoverlap
//        if (rectangle.maxX > r.maxX && rectangle.maxY > r.minY
//                && rectangle.minX < r.minX && rectangle.minY < r.minY) {
        fr = field3.values().stream().filter(r -> rectangle.maxX < r.maxX && rectangle.maxY > r.minY
                && rectangle.minX < r.minX && rectangle.minY < r.minY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            System.out.println("bottomleftoverlap");
//            Rectangle a = new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY});
//            System.out.println("a: " + a.rectangleSum);
//            Rectangle b = new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, fr.minY});
//            System.out.println("b: " + b.rectangleSum);
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, fr.minY}));
            tempIndex += 2;
            return;
        }
//        //after this point overlaps are old if conditions not new values, and are yet to be replaced. have fun.
//        //topleft
        fr = field3.values().stream().filter(r -> rectangle.maxX >r.minX &&rectangle.minY<r.maxY
                &&rectangle.minX<r.minX &&rectangle.maxY >r.maxY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            System.out.println("topleftoverlap");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.minX, fr.maxY, rectangle.maxX, rectangle.maxY}));
            tempIndex += 2;
            return;
        }
//
//        //bottomright
        fr = field3.values().stream().filter(r -> rectangle.minX<r.maxX &&rectangle.maxY >r.minY
                &&rectangle.maxX >r.maxX &&rectangle.minY<r.minY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            System.out.println("bottomrightoverlap");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, fr.minY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{fr.maxX, fr.minY, rectangle.maxX, rectangle.maxY}));
            tempIndex += 2;
            return;
        }

        //horizontaloverlap           //comperators from this point on can be messed up
        fr = field3.values().stream().filter(r -> rectangle.minX<r.minX && rectangle.maxX > r.maxX && rectangle.minY >= r.minY && rectangle.maxY <= r.maxY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            System.out.println("horizontaloverlap");
            field3.put(tempIndex + 1, new Rectangle(new int[]{fr.minX, rectangle.minY, rectangle.maxX, rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY}));
            tempIndex++;
            return;
        }

        //verticaloverlap
        fr = field3.values().stream().filter(r -> rectangle.minY < r.minY && rectangle.maxY > r.maxY && rectangle.minX >= r.minX && rectangle.maxX <= r.maxX).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            System.out.println("verticaloverlap");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, fr.maxY, rectangle.maxX, rectangle.maxY}));
            field3.put(tempIndex + 2, new Rectangle(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, fr.minY}));
            tempIndex++;
            return;
        }

        //topextension
        fr = field3.values().stream().filter(r -> rectangle.maxY > r.maxY && rectangle.minX >= r.minX && rectangle.maxX <= r.maxX && rectangle.minY > r.minY
                && rectangle.minY < r.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            System.out.println("topextension");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, fr.maxY, rectangle.maxX, rectangle.maxY}));
            tempIndex++;
            return;
        }
//
//        //bottomextension
        fr = field3.values().stream().filter(r -> rectangle.minY < r.minY && rectangle.minX >= r.minX && rectangle.maxX <= r.maxX && rectangle.maxY < r.maxY
                && rectangle.maxY < r.maxY).max(new MaxYComp()).orElse(null);
        if (fr != null) {
            System.out.println("bottomextension");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, fr.minY}));
            tempIndex++;
            return;
        }

        //rightextension
        fr = field3.values().stream().filter(r -> rectangle.maxX > r.maxX && rectangle.minY >= r.minY && rectangle.maxY <= r.maxY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            System.out.println("rightextension");
            field3.put(tempIndex + 1, new Rectangle(new int[]{fr.maxX, rectangle.minY, rectangle.maxX, rectangle.maxY}));
            tempIndex++;
            return;
        }

        //leftextension
        fr = field3.values().stream().filter(r -> rectangle.minX < r.minX && rectangle.minY >= r.minY && rectangle.maxY <= r.maxY).max(new MaxXComp()).orElse(null);
        if (fr != null) {
            System.out.println("leftextension");
            field3.put(tempIndex + 1, new Rectangle(new int[]{rectangle.minX, rectangle.minY, fr.minX, rectangle.maxY}));
            tempIndex++;
            return;
        }
        fr = field3.values().stream().filter(r -> rectangle.minY > r.maxY || rectangle.minX > r.maxX|| rectangle.maxY < r.minY || rectangle.maxX < r.minX).max(new MaxYComp()).orElse(null);
        if (fr == null) {
            System.out.println("no overlap");
            field3.put(tempIndex, rectangle);
            tempIndex++;
        }
    }
>>>>>>> cb881e417863984f2fdc738a364bbde6b5f3e18b
}