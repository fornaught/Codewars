<<<<<<< HEAD
package com.company;

import java.util.*;

class Rectangle {

    HashMap<Integer, ArrayList<int[]>> top = new HashMap<>();
    HashMap<Integer, ArrayList<int[]>> bottom = new HashMap<>();
    Integer minX;
    Integer maxX;
    Integer minY;
    Integer maxY;
    int rectangleSum;

    public Rectangle(int[] input)
    {
        top.computeIfAbsent(input[3], x -> new ArrayList<>()).add(new int[] {input[0], input[2]});
        bottom.computeIfAbsent(input[1], x-> new ArrayList<>()).add(new int[] {input[0], input[2]});
        this.minX = input[0];
        this.maxX = input[2];
        this.minY = input[1];
        this.maxY = input[3];
        this.rectangleSum = (input[2] - input[0]) * (input[3] - input[1]);
    }
}

public class RectanglesUnion {

    static ArrayList<Rectangle> field = new ArrayList<>();
    static ArrayList<Rectangle> overlaps = new ArrayList<>();
    static ArrayList<Rectangle> tro = new ArrayList<>();
    static ArrayList<Rectangle> tlo = new ArrayList<>();
    static ArrayList<Rectangle> blo = new ArrayList<>();
    static ArrayList<Rectangle> bro = new ArrayList<>();
    static int sum = 0;
    static int tempIndex = 0;
    static HashMap<Integer, ArrayList<int[]>> upper = new HashMap<>();
    static HashMap<Integer, ArrayList<int[]>> lower = new HashMap<>();
    static TreeMap<int[], int[]> both = new TreeMap<int[], int[]>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] < o2[0])
                return 1;
            else
                return -1;
        }
    });

    public static int calculateSpace(int[][] rectangles) {
        sum = 0;
        tempIndex = 0;
        field.clear();
        overlaps.clear();
        upper.computeIfAbsent(rectangles[0][3], x -> new ArrayList<>()).add(new int[]{rectangles[0][0], rectangles[0][2]});
        lower.computeIfAbsent(rectangles[0][1], x -> new ArrayList<>()).add(new int[]{rectangles[0][0], rectangles[0][2]});
        int[] r2 = new int[]{rectangles[0][0], rectangles[0][2]};
        int[] r3 = new int[]{rectangles[0][1], rectangles[0][3]};
        both.put(r2, r3);//new Integer[]{rectangles[0][0], rectangles[0][2]}, new Integer[]{rectangles[0][1], rectangles[0][3]});
        for (int[] rectangle : rectangles) {
            if (rectangle[0] < r2[1] && rectangle[1] < r3[1]
                    && rectangle[2] > r2[1] && rectangle[3] > r3[1]) {
               if (both.entrySet().stream().filter(map -> map.getKey()[0] <= rectangle.minX && map.getKey()[0]<= rectangle.maxX).count() > 0) {
               // System.out.println("hoi");
                both.computeIfAbsent(new int[]{r2[0], rectangle[2]}, x -> new int[]{r3[0], rectangle[3]});
                r2[0] = rectangle[0];
                r2[1] = rectangle[1];
                r3[0] = rectangle[2];
                r2[1] = rectangle[3];
//           checkOverlaps(new Rectangle(rectangles[i]), i);
            }
//        System.out.println("upper");
//        for (Map.Entry<Integer, ArrayList<int[]>> entry : upper.entrySet()) {
//            Integer key = entry.getKey();
//            ArrayList<int[]> value = entry.getValue();
//            System.out.println("key: " + key + " " + value.get(0)[0] + " " + value.get(0)[1]);
//        }
//        System.out.println("lower");
//        for (Map.Entry<Integer, ArrayList<int[]>> entry : lower.entrySet()) {
//            Integer key = entry.getKey();
//            ArrayList<int[]> value = entry.getValue();
//            System.out.println("key: " + key + " " + value.get(0)[0] + " " + value.get(0)[1]);
//        }
        }
        for (Map.Entry<int[], int[]> entry : both.entrySet()) {
            int[] key = entry.getKey();
            int[] value = entry.getValue();
            System.out.println("key: " + key[0] + " " + key[1] + " " + value[0] + " " + value[1]);
        }


        System.out.println(("ol " + both.size()));
        System.out.println(field.size());
        System.out.println(sum);
        return sum;
    }
}

//    public static <K, V> void printMap(Map<K, V> map) {
//        for (Map.Entry<K, V> entry : map.entrySet()) {
//            System.out.println("Key : " + entry.getKey()
//                    + " Value : " + entry.getValue());
//        }
//    }

//    static void checkOverlaps(Rectangle rectangle, int Index) {
//        for (Rectangle r : field) {
//            //toprightoverlap
//            if (rectangle.minX < r.maxX && rectangle.minY < r.maxY
//            && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY){
////               if (both.entrySet().stream().filter(map -> map.getKey()[0] <= rectangle.minX && map.getKey()[0]<= rectangle.maxX).count() > 0) {
//                System.out.println("hoi");
//                   both.computeIfAbsent(new Integer[]{r.minX, rectangle.maxX}, x -> new Integer[]{r.minY,rectangle.maxY});
//                //both.put(new Integer[]{r.minX, rectangle.maxX}, new Integer[]{r.minY,rectangle.maxY});
////             upper.computeIfAbsent(rectangle.maxY, x -> new ArrayList<>()).add(new int[]{rectangle.minX, rectangle.maxX});
////             lower.computeIfAbsent(rectangle.minY, x -> new ArrayList<>()).add(new int[]{r.minX, rectangle.maxX});
//
//
//                //System.out.println("{"+ rectangle.minX + ", " + rectangle.maxX + ", " + rectangle.maxX + ", " + rectangle.maxY + "},");
//                sum += (r.maxX - rectangle.minX) * (rectangle.maxY - r.maxY);
//                //System.out.println((r.maxX - rectangle.minX) + " " + (rectangle.maxY - r.maxY));
//                sum += (rectangle.maxX - r.maxX) * (rectangle.maxY - rectangle.minY);
//                //System.out.println((rectangle.maxX - r.maxX)+ " " + (rectangle.maxY - rectangle.minY));
//
//                //overlaps.add(new Rectangle(new int[] {rectangle.minX, rectangle.minY, r.maxX, r.maxY}));
//            }
//            //bottomleftoverlap
//            if (rectangle.maxX > r.maxX && rectangle.maxY > r.minY
//                    && rectangle.minX < r.minX && rectangle.minY < r.minY) {
//                System.out.println("blo");
//                sum += (rectangle.maxX - r.minX) * (r.minY - rectangle.minY);
//                sum += (r.minX - rectangle.minY) * (rectangle.maxY - rectangle.minY);
//                overlaps.add(new Rectangle(new int[] {r.minX, r.minY, rectangle.maxX, rectangle.maxY}));
//            }
//            //topleftoverlap
//            if (rectangle.maxX > r.minX && rectangle.minY < r.maxY
//                    && rectangle.minX < r.minX && rectangle.maxY > r.maxY) {
//                System.out.println("tlo");
//                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - rectangle.minY);
//                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - r.maxY);
//                overlaps.add(new Rectangle(new int[] {r.minX, rectangle.minY, rectangle.maxX, r.maxY}));
//            }
//            //bottomrightoverlap
//            if (rectangle.minX < r.maxX && rectangle.maxY > r.minY
//                    && rectangle.maxX > r.maxX && rectangle.minY < r.minY) {
//                System.out.println("bro");
//                sum += (r.minX - rectangle.minX) * (rectangle.maxY - r.minY);
//                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - rectangle.minY);
//                overlaps.add(new Rectangle(new int[] {rectangle.minX, r.minY, r.maxX, rectangle.maxY}));
//            }
//        }
//        field.add(rectangle);
//    }
=======
package com.company;

import java.util.*;

class Rectangle {

    HashMap<Integer, ArrayList<int[]>> top = new HashMap<>();
    HashMap<Integer, ArrayList<int[]>> bottom = new HashMap<>();
    Integer minX;
    Integer maxX;
    Integer minY;
    Integer maxY;
    int rectangleSum;

    public Rectangle(int[] input)
    {
        top.computeIfAbsent(input[3], x -> new ArrayList<>()).add(new int[] {input[0], input[2]});
        bottom.computeIfAbsent(input[1], x-> new ArrayList<>()).add(new int[] {input[0], input[2]});
        this.minX = input[0];
        this.maxX = input[2];
        this.minY = input[1];
        this.maxY = input[3];
        this.rectangleSum = (input[2] - input[0]) * (input[3] - input[1]);
    }
}

public class RectanglesUnion {

    static ArrayList<Rectangle> field = new ArrayList<>();
    static ArrayList<Rectangle> overlaps = new ArrayList<>();
    static ArrayList<Rectangle> tro = new ArrayList<>();
    static ArrayList<Rectangle> tlo = new ArrayList<>();
    static ArrayList<Rectangle> blo = new ArrayList<>();
    static ArrayList<Rectangle> bro = new ArrayList<>();
    static int sum = 0;
    static int tempIndex = 0;
    static HashMap<Integer, ArrayList<int[]>> upper = new HashMap<>();
    static HashMap<Integer, ArrayList<int[]>> lower = new HashMap<>();
    static TreeMap<int[], int[]> both = new TreeMap<int[], int[]>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] < o2[0])
                return 1;
            else
                return -1;
        }
    });

    public static int calculateSpace(int[][] rectangles) {
        sum = 0;
        tempIndex = 0;
        field.clear();
        overlaps.clear();
        upper.computeIfAbsent(rectangles[0][3], x -> new ArrayList<>()).add(new int[]{rectangles[0][0], rectangles[0][2]});
        lower.computeIfAbsent(rectangles[0][1], x -> new ArrayList<>()).add(new int[]{rectangles[0][0], rectangles[0][2]});
        int[] r2 = new int[]{rectangles[0][0], rectangles[0][2]};
        int[] r3 = new int[]{rectangles[0][1], rectangles[0][3]};
        both.put(r2, r3);//new Integer[]{rectangles[0][0], rectangles[0][2]}, new Integer[]{rectangles[0][1], rectangles[0][3]});
        for (int[] rectangle : rectangles) {
            if (rectangle[0] < r2[1] && rectangle[1] < r3[1]
                    && rectangle[2] > r2[1] && rectangle[3] > r3[1]) {
               if (both.entrySet().stream().filter(map -> map.getKey()[0] <= rectangle.minX && map.getKey()[0]<= rectangle.maxX).count() > 0) {
               // System.out.println("hoi");
                both.computeIfAbsent(new int[]{r2[0], rectangle[2]}, x -> new int[]{r3[0], rectangle[3]});
                r2[0] = rectangle[0];
                r2[1] = rectangle[1];
                r3[0] = rectangle[2];
                r2[1] = rectangle[3];
//           checkOverlaps(new Rectangle(rectangles[i]), i);
            }
//        System.out.println("upper");
//        for (Map.Entry<Integer, ArrayList<int[]>> entry : upper.entrySet()) {
//            Integer key = entry.getKey();
//            ArrayList<int[]> value = entry.getValue();
//            System.out.println("key: " + key + " " + value.get(0)[0] + " " + value.get(0)[1]);
//        }
//        System.out.println("lower");
//        for (Map.Entry<Integer, ArrayList<int[]>> entry : lower.entrySet()) {
//            Integer key = entry.getKey();
//            ArrayList<int[]> value = entry.getValue();
//            System.out.println("key: " + key + " " + value.get(0)[0] + " " + value.get(0)[1]);
//        }
        }
        for (Map.Entry<int[], int[]> entry : both.entrySet()) {
            int[] key = entry.getKey();
            int[] value = entry.getValue();
            System.out.println("key: " + key[0] + " " + key[1] + " " + value[0] + " " + value[1]);
        }


        System.out.println(("ol " + both.size()));
        System.out.println(field.size());
        System.out.println(sum);
        return sum;
    }
}

//    public static <K, V> void printMap(Map<K, V> map) {
//        for (Map.Entry<K, V> entry : map.entrySet()) {
//            System.out.println("Key : " + entry.getKey()
//                    + " Value : " + entry.getValue());
//        }
//    }

//    static void checkOverlaps(Rectangle rectangle, int Index) {
//        for (Rectangle r : field) {
//            //toprightoverlap
//            if (rectangle.minX < r.maxX && rectangle.minY < r.maxY
//            && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY){
////               if (both.entrySet().stream().filter(map -> map.getKey()[0] <= rectangle.minX && map.getKey()[0]<= rectangle.maxX).count() > 0) {
//                System.out.println("hoi");
//                   both.computeIfAbsent(new Integer[]{r.minX, rectangle.maxX}, x -> new Integer[]{r.minY,rectangle.maxY});
//                //both.put(new Integer[]{r.minX, rectangle.maxX}, new Integer[]{r.minY,rectangle.maxY});
////             upper.computeIfAbsent(rectangle.maxY, x -> new ArrayList<>()).add(new int[]{rectangle.minX, rectangle.maxX});
////             lower.computeIfAbsent(rectangle.minY, x -> new ArrayList<>()).add(new int[]{r.minX, rectangle.maxX});
//
//
//                //System.out.println("{"+ rectangle.minX + ", " + rectangle.maxX + ", " + rectangle.maxX + ", " + rectangle.maxY + "},");
//                sum += (r.maxX - rectangle.minX) * (rectangle.maxY - r.maxY);
//                //System.out.println((r.maxX - rectangle.minX) + " " + (rectangle.maxY - r.maxY));
//                sum += (rectangle.maxX - r.maxX) * (rectangle.maxY - rectangle.minY);
//                //System.out.println((rectangle.maxX - r.maxX)+ " " + (rectangle.maxY - rectangle.minY));
//
//                //overlaps.add(new Rectangle(new int[] {rectangle.minX, rectangle.minY, r.maxX, r.maxY}));
//            }
//            //bottomleftoverlap
//            if (rectangle.maxX > r.maxX && rectangle.maxY > r.minY
//                    && rectangle.minX < r.minX && rectangle.minY < r.minY) {
//                System.out.println("blo");
//                sum += (rectangle.maxX - r.minX) * (r.minY - rectangle.minY);
//                sum += (r.minX - rectangle.minY) * (rectangle.maxY - rectangle.minY);
//                overlaps.add(new Rectangle(new int[] {r.minX, r.minY, rectangle.maxX, rectangle.maxY}));
//            }
//            //topleftoverlap
//            if (rectangle.maxX > r.minX && rectangle.minY < r.maxY
//                    && rectangle.minX < r.minX && rectangle.maxY > r.maxY) {
//                System.out.println("tlo");
//                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - rectangle.minY);
//                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - r.maxY);
//                overlaps.add(new Rectangle(new int[] {r.minX, rectangle.minY, rectangle.maxX, r.maxY}));
//            }
//            //bottomrightoverlap
//            if (rectangle.minX < r.maxX && rectangle.maxY > r.minY
//                    && rectangle.maxX > r.maxX && rectangle.minY < r.minY) {
//                System.out.println("bro");
//                sum += (r.minX - rectangle.minX) * (rectangle.maxY - r.minY);
//                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - rectangle.minY);
//                overlaps.add(new Rectangle(new int[] {rectangle.minX, r.minY, r.maxX, rectangle.maxY}));
//            }
//        }
//        field.add(rectangle);
//    }
>>>>>>> cb881e417863984f2fdc738a364bbde6b5f3e18b
//}