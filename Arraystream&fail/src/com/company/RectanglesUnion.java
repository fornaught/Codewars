package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

// approach this fucking time: add rectangleSum - overlapSum

class Rectangle<Rectangle> {

    Integer minX;
    Integer maxX;
    Integer minY;
    Integer maxY;
    Integer rectangleSum;
    Integer overlapSum;

    public Rectangle(int[] input) {

        this.minX = input[0];
        this.maxX = input[2];
        this.minY = input[1];
        this.maxY = input[3];
        this.rectangleSum = (input[2] - input[0]) * (input[3] - input[1]);
    }
}

public class RectanglesUnion {

    public static HashSet<Rectangle> set = new HashSet<>();
    public static int calculateSpace(int[][] rectangles) {
            for (int[] rectangle : rectangles) {
                checkOverlap(new Rectangle(rectangle));
        }
        return 0;
    }

    public static void checkOverlap(Rectangle rectangle) {
        HashMap<int[], Integer> overlap = new HashMap<>();


        //toprightoverlap
        List<Rectangle> fr = set.stream().filter(r -> rectangle.minX < r.maxX && rectangle.minY < r.maxY
                && rectangle.maxX > r.maxX && rectangle.maxY > r.maxY).collect(Collectors.toList());

        if (!fr.isEmpty()) {
            System.out.println("toprightoverlap");

            for (Rectangle r : fr){
            overlap.put(new int[]{r.minX, r.minY}, rectangle.maxX - r.minX);
            }
        }

        fr = set.stream().filter(r -> rectangle.maxX < r.maxX && rectangle.maxY > r.minY
                && rectangle.minX < r.minX && rectangle.minY < r.minY).collect(Collectors.toList());
        if (!fr.isEmpty()) {
            System.out.println("bottomleftoverlap");
            for (Rectangle r : fr){
                overlap.put(new int[]{rectangle.minX, rectangle.minY}, r.minX - rectangle.maxX);
            }
        }
        set.add(rectangle);
    }
}
