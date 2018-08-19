<<<<<<< HEAD
package com.company;

import java.util.*;

class Rectangle {


    Integer minX;
    Integer maxX;
    Integer minY;
    Integer maxY;
    int rectangleSum;

    public Rectangle(int[] input){

        this.minX = input[0];
        this.maxX = input[2];
        this.minY = input[1];
        this.maxY = input[3];
        this.rectangleSum = (input[2] - input[0]) * (input[3] - input[1]);
    }
}

public class RectanglesUnion {

    static ArrayList<Rectangle> field2 = new ArrayList<>();
    static int overlapcounter = 0;
    static TreeMap<int[], int[]> field3 = new TreeMap<int[], int[]>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] < o2[0])
                return -1;
            if (o1[0] > o2[0])
                return 1;
            else
                return 0;
        }
    });
    HashSet<Rectangle> field4 = new HashSet<>();
    static int sum = 0;
    static int tempIndex = 0;


    public static int calculateSpace(int[][] rectangles) {
        sum = 0;
        tempIndex = 0;
        field2.clear();
        field3.clear();
        for (int[] rectangle :rectangles) {
//            checkOverlap(new Rectangle(rectangles[i]), i );
//            System.out.println("hoi " + field3.keySet().stream().filter(x -> x[0] <= rectangle[2] && x[1] <= rectangle[3]).count()
//            );
//            if (field3.keySet().stream().filter(x -> x[0] >= rectangle[0] && x[0] <= rectangle[2] && x[1] == rectangle[1]).count() > 0
//                    && field3.values().stream().filter(x -> x[0] > rectangle[2]).count() > 0) {
//                if (field3.entrySet().stream().filter(x -> x.getKey()[0] >= rectangle[0] && x.getKey()[0] <= rectangle[2] && x.getKey()[1] == rectangle[1]
//                && x.getValue()[0] == rectangle[2] && x.getValue()[1] == rectangle[3]).count() > 0)

            if (field3.entrySet().stream().filter(x -> x.getKey()[0] <= rectangle[2] && x.getKey()[1] == rectangle[1] && x.getValue()[0] < rectangle[2]).count() > 0) {
                overlapcounter++;
            }
            //if erboven
            //if eronder
//            else {
//                for (int j = rectangle[0]; j <= rectangle[2]; j++) {
//                    field3.put(new int[]{j, rectangle[1]}, new int[]{j, rectangle[3]});
//                }
//            }
            else {
                for (int j = rectangle[1]; j <= rectangle[3]; j++) {
                    System.out.println(j);
                    field3.put(new int[]{j, rectangle[0]}, new int[]{j, rectangle[2],});
                }
            }
        }
        for (Map.Entry<int[], int[]> entry : field3.entrySet()) {
            int[] key = entry.getKey();
            int[] value = entry.getValue();

            System.out.println("key: "+ key[0] +" "+ key[1] + " values: " + value[0] + " " + value[1]);
        }
        System.out.println(overlapcounter);
        System.out.println(field3.size());
        return sum;
    }
}

//    public static void checkOverlap (Rectangle rectangle, int Index){
//        for (Integer i = tempIndex; i < field3.size(); i++) {
//            //Rectangle r = field3.get(i);
//            //toprightoverlap
//            if (rectangle.minX < r.maxX && rectangle.minY < r.maxY
//                    && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY) {
////                    && rectangle.minX >= r.minX && rectangle.minY >= r.minY) {
//
//                System.out.println("hoi1 " + field3.size());
//                System.out.println("yes " + tempIndex);
//                field3.put(tempIndex + 1, new Rectangle(new int[] {r.maxX, r.maxY, rectangle.maxX, rectangle.maxY}));
//                System.out.println("hoi2 " + field3.size());
//                field3.put(tempIndex + 2, new Rectangle(new int[] {r.maxX, rectangle.minY, rectangle.maxX, r.maxY}));
//                System.out.println("hoi3 " + field3.size());
//                tempIndex += 2;
//
//                if (field3.keySet().stream().filter(x -> x >= rectangle.minX && x <= rectangle.maxX).count() > 0) {
////                        field2.add(new Rectangle(new int[] {r.maxX, r.maxY, rectangle.maxX, rectangle.maxY}));
////                        field2.add(new Rectangle(new int[] {r.maxX, rectangle.minY, rectangle.maxX, r.maxY}));
////                        break;
//                //System.out.println("{"+ rectangle.minX + ", " + rectangle.maxX + ", " + rectangle.maxX + ", " + rectangle.maxY + "},");
////                sum += (r.maxX - rectangle.minX) * (rectangle.maxY - r.maxY);
//                //System.out.println((r.maxX - rectangle.minX) + " " + (rectangle.maxY - r.maxY));
////                sum += (rectangle.maxX - r.maxX) * (rectangle.maxY - rectangle.minY);
//                //System.out.println((rectangle.maxX - r.maxX)+ " " + (rectangle.maxY - rectangle.minY));
//
//                //overlaps.add(new Rectangle(new int[] {rectangle.minX, rectangle.minY, r.maxX, r.maxY}));
//            }
//            //bottomleftoverlap
//            if (rectangle.maxX > r.maxX && rectangle.maxY > r.minY
//                    && rectangle.minX < r.minX && rectangle.minY < r.minY) {
//
//
////                sum += (rectangle.maxX - r.minX) * (r.minY - rectangle.minY);
////                sum += (r.minX - rectangle.minY) * (rectangle.maxY - rectangle.minY);
//            }
//            //topleftoverlap
//            if (rectangle.maxX > r.minX && rectangle.minY < r.maxY
//                    && rectangle.minX < r.minX && rectangle.maxY > r.maxY) {
////                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - rectangle.minY);
////                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - r.maxY);
//            }
//            //bottomrightoverlap
//            if (rectangle.minX < r.maxX && rectangle.maxY > r.minY
//                    && rectangle.maxX > r.maxX && rectangle.minY < r.minY) {
////                sum += (r.minX - rectangle.minX) * (rectangle.maxY - r.minY);
////                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - rectangle.minY);
//            }
//            else if (i == field3.size() -1) {
////                field3.put(Index, rectangle);
//            }
//        }
//
//    }
=======
package com.company;

import java.util.*;

class Rectangle {


    Integer minX;
    Integer maxX;
    Integer minY;
    Integer maxY;
    int rectangleSum;

    public Rectangle(int[] input){

        this.minX = input[0];
        this.maxX = input[2];
        this.minY = input[1];
        this.maxY = input[3];
        this.rectangleSum = (input[2] - input[0]) * (input[3] - input[1]);
    }
}

public class RectanglesUnion {

    static ArrayList<Rectangle> field2 = new ArrayList<>();
    static int overlapcounter = 0;
    static TreeMap<int[], int[]> field3 = new TreeMap<int[], int[]>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] < o2[0])
                return -1;
            if (o1[0] > o2[0])
                return 1;
            else
                return 0;
        }
    });
    HashSet<Rectangle> field4 = new HashSet<>();
    static int sum = 0;
    static int tempIndex = 0;


    public static int calculateSpace(int[][] rectangles) {
        sum = 0;
        tempIndex = 0;
        field2.clear();
        field3.clear();
        for (int[] rectangle :rectangles) {
//            checkOverlap(new Rectangle(rectangles[i]), i );
//            System.out.println("hoi " + field3.keySet().stream().filter(x -> x[0] <= rectangle[2] && x[1] <= rectangle[3]).count()
//            );
//            if (field3.keySet().stream().filter(x -> x[0] >= rectangle[0] && x[0] <= rectangle[2] && x[1] == rectangle[1]).count() > 0
//                    && field3.values().stream().filter(x -> x[0] > rectangle[2]).count() > 0) {
//                if (field3.entrySet().stream().filter(x -> x.getKey()[0] >= rectangle[0] && x.getKey()[0] <= rectangle[2] && x.getKey()[1] == rectangle[1]
//                && x.getValue()[0] == rectangle[2] && x.getValue()[1] == rectangle[3]).count() > 0)

            if (field3.entrySet().stream().filter(x -> x.getKey()[0] <= rectangle[2] && x.getKey()[1] == rectangle[1] && x.getValue()[0] < rectangle[2]).count() > 0) {
                overlapcounter++;
            }
            //if erboven
            //if eronder
//            else {
//                for (int j = rectangle[0]; j <= rectangle[2]; j++) {
//                    field3.put(new int[]{j, rectangle[1]}, new int[]{j, rectangle[3]});
//                }
//            }
            else {
                for (int j = rectangle[1]; j <= rectangle[3]; j++) {
                    System.out.println(j);
                    field3.put(new int[]{j, rectangle[0]}, new int[]{j, rectangle[2],});
                }
            }
        }
        for (Map.Entry<int[], int[]> entry : field3.entrySet()) {
            int[] key = entry.getKey();
            int[] value = entry.getValue();

            System.out.println("key: "+ key[0] +" "+ key[1] + " values: " + value[0] + " " + value[1]);
        }
        System.out.println(overlapcounter);
        System.out.println(field3.size());
        return sum;
    }
}

//    public static void checkOverlap (Rectangle rectangle, int Index){
//        for (Integer i = tempIndex; i < field3.size(); i++) {
//            //Rectangle r = field3.get(i);
//            //toprightoverlap
//            if (rectangle.minX < r.maxX && rectangle.minY < r.maxY
//                    && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY) {
////                    && rectangle.minX >= r.minX && rectangle.minY >= r.minY) {
//
//                System.out.println("hoi1 " + field3.size());
//                System.out.println("yes " + tempIndex);
//                field3.put(tempIndex + 1, new Rectangle(new int[] {r.maxX, r.maxY, rectangle.maxX, rectangle.maxY}));
//                System.out.println("hoi2 " + field3.size());
//                field3.put(tempIndex + 2, new Rectangle(new int[] {r.maxX, rectangle.minY, rectangle.maxX, r.maxY}));
//                System.out.println("hoi3 " + field3.size());
//                tempIndex += 2;
//
//                if (field3.keySet().stream().filter(x -> x >= rectangle.minX && x <= rectangle.maxX).count() > 0) {
////                        field2.add(new Rectangle(new int[] {r.maxX, r.maxY, rectangle.maxX, rectangle.maxY}));
////                        field2.add(new Rectangle(new int[] {r.maxX, rectangle.minY, rectangle.maxX, r.maxY}));
////                        break;
//                //System.out.println("{"+ rectangle.minX + ", " + rectangle.maxX + ", " + rectangle.maxX + ", " + rectangle.maxY + "},");
////                sum += (r.maxX - rectangle.minX) * (rectangle.maxY - r.maxY);
//                //System.out.println((r.maxX - rectangle.minX) + " " + (rectangle.maxY - r.maxY));
////                sum += (rectangle.maxX - r.maxX) * (rectangle.maxY - rectangle.minY);
//                //System.out.println((rectangle.maxX - r.maxX)+ " " + (rectangle.maxY - rectangle.minY));
//
//                //overlaps.add(new Rectangle(new int[] {rectangle.minX, rectangle.minY, r.maxX, r.maxY}));
//            }
//            //bottomleftoverlap
//            if (rectangle.maxX > r.maxX && rectangle.maxY > r.minY
//                    && rectangle.minX < r.minX && rectangle.minY < r.minY) {
//
//
////                sum += (rectangle.maxX - r.minX) * (r.minY - rectangle.minY);
////                sum += (r.minX - rectangle.minY) * (rectangle.maxY - rectangle.minY);
//            }
//            //topleftoverlap
//            if (rectangle.maxX > r.minX && rectangle.minY < r.maxY
//                    && rectangle.minX < r.minX && rectangle.maxY > r.maxY) {
////                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - rectangle.minY);
////                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - r.maxY);
//            }
//            //bottomrightoverlap
//            if (rectangle.minX < r.maxX && rectangle.maxY > r.minY
//                    && rectangle.maxX > r.maxX && rectangle.minY < r.minY) {
////                sum += (r.minX - rectangle.minX) * (rectangle.maxY - r.minY);
////                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - rectangle.minY);
//            }
//            else if (i == field3.size() -1) {
////                field3.put(Index, rectangle);
//            }
//        }
//
//    }
>>>>>>> cb881e417863984f2fdc738a364bbde6b5f3e18b
//}