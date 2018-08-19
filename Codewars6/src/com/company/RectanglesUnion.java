<<<<<<< HEAD
package com.company;

import java.util.ArrayList;
import java.util.HashMap;

class Rectangle {

    HashMap<Integer, int[]> top = new HashMap<>();
    HashMap<Integer, int[]> bottom = new HashMap<>();

    int minX;
    int maxX;
    int minY;
    int maxY;
    int rectangleSum;

    public Rectangle(int[] input)
    {
        this.top.put(input[3], new int[] {input[0], input[2]});
        this.bottom.put(input[1], new int[] {input[0], input[2]});
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

    public static int calculateSpace(int[][] rectangles) {
        sum = 0;
        tempIndex = 0;
        field.clear();
        overlaps.clear();
        for (int i = 0; i < rectangles.length; i++) {
            checkOverlaps(new com.company.Rectangle(rectangles[i]), i);
        }
        System.out.println(("ol " + overlaps.size()));
        System.out.println(field.size());
        System.out.println(sum);
        return sum;
    }

    static void checkOverlaps(Rectangle rectangle, int Index) {
        for (Rectangle r : field) {
            //toprightoverlap
            if (rectangle.minX < r.maxX && rectangle.minY < r.maxY
                    && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY){
                // System.out.println("tro");



                sum += (r.maxX - rectangle.minX) * (rectangle.maxY - r.maxY);
                sum += (rectangle.maxX - r.maxX) * (rectangle.maxY - rectangle.minY);

                overlaps.add(new Rectangle(new int[] {rectangle.minX, rectangle.minY, r.maxX, r.maxY}));
            }
            //bottomleftoverlap
            if (rectangle.maxX > r.maxX && rectangle.maxY > r.minY
                    && rectangle.minX < r.minX && rectangle.minY < r.minY) {
                //    System.out.println("blo");
                sum += (rectangle.maxX - r.minX) * (r.minY - rectangle.minY);
                sum += (r.minX - rectangle.minY) * (rectangle.maxY - rectangle.minY);
                overlaps.add(new Rectangle(new int[] {r.minX, r.minY, rectangle.maxX, rectangle.maxY}));
            }
            //topleftoverlap
            if (rectangle.maxX > r.minX && rectangle.minY < r.maxY
                    && rectangle.minX < r.minX && rectangle.maxY > r.maxY) {
                //    System.out.println("tlo");
                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - rectangle.minY);
                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - r.maxY);
                overlaps.add(new Rectangle(new int[] {r.minX, rectangle.minY, rectangle.maxX, r.maxY}));
            }
            //bottomrightoverlap
            if (rectangle.minX < r.maxX && rectangle.maxY > r.minY
                    && rectangle.maxX > r.maxX && rectangle.minY < r.minY) {
                //    System.out.println("bro");
                sum += (r.minX - rectangle.minX) * (rectangle.maxY - r.minY);
                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - rectangle.minY);
                overlaps.add(new Rectangle(new int[] {rectangle.minX, r.minY, r.maxX, rectangle.maxY}));
            }
        }
    }
=======
package com.company;

import java.util.ArrayList;
import java.util.HashMap;

class Rectangle {

    HashMap<Integer, int[]> top = new HashMap<>();
    HashMap<Integer, int[]> bottom = new HashMap<>();

    int minX;
    int maxX;
    int minY;
    int maxY;
    int rectangleSum;

    public Rectangle(int[] input)
    {
        this.top.put(input[3], new int[] {input[0], input[2]});
        this.bottom.put(input[1], new int[] {input[0], input[2]});
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

    public static int calculateSpace(int[][] rectangles) {
        sum = 0;
        tempIndex = 0;
        field.clear();
        overlaps.clear();
        for (int i = 0; i < rectangles.length; i++) {
            checkOverlaps(new com.company.Rectangle(rectangles[i]), i);
        }
        System.out.println(("ol " + overlaps.size()));
        System.out.println(field.size());
        System.out.println(sum);
        return sum;
    }

    static void checkOverlaps(Rectangle rectangle, int Index) {
        for (Rectangle r : field) {
            //toprightoverlap
            if (rectangle.minX < r.maxX && rectangle.minY < r.maxY
                    && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY){
                // System.out.println("tro");



                sum += (r.maxX - rectangle.minX) * (rectangle.maxY - r.maxY);
                sum += (rectangle.maxX - r.maxX) * (rectangle.maxY - rectangle.minY);

                overlaps.add(new Rectangle(new int[] {rectangle.minX, rectangle.minY, r.maxX, r.maxY}));
            }
            //bottomleftoverlap
            if (rectangle.maxX > r.maxX && rectangle.maxY > r.minY
                    && rectangle.minX < r.minX && rectangle.minY < r.minY) {
                //    System.out.println("blo");
                sum += (rectangle.maxX - r.minX) * (r.minY - rectangle.minY);
                sum += (r.minX - rectangle.minY) * (rectangle.maxY - rectangle.minY);
                overlaps.add(new Rectangle(new int[] {r.minX, r.minY, rectangle.maxX, rectangle.maxY}));
            }
            //topleftoverlap
            if (rectangle.maxX > r.minX && rectangle.minY < r.maxY
                    && rectangle.minX < r.minX && rectangle.maxY > r.maxY) {
                //    System.out.println("tlo");
                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - rectangle.minY);
                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - r.maxY);
                overlaps.add(new Rectangle(new int[] {r.minX, rectangle.minY, rectangle.maxX, r.maxY}));
            }
            //bottomrightoverlap
            if (rectangle.minX < r.maxX && rectangle.maxY > r.minY
                    && rectangle.maxX > r.maxX && rectangle.minY < r.minY) {
                //    System.out.println("bro");
                sum += (r.minX - rectangle.minX) * (rectangle.maxY - r.minY);
                sum += (rectangle.maxX - r.minX) * (rectangle.maxY - rectangle.minY);
                overlaps.add(new Rectangle(new int[] {rectangle.minX, r.minY, r.maxX, rectangle.maxY}));
            }
        }
    }
>>>>>>> cb881e417863984f2fdc738a364bbde6b5f3e18b
}