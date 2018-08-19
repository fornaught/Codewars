<<<<<<< HEAD
package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class RectanglesUnion {

    static HashMap<int[], Integer> lowPoints = new HashMap<>();
    static HashMap<int[], Integer> highPoints = new HashMap<>();
    static ArrayList<int[]> rStartingPoints = new ArrayList<>();
    static int sum = 0;

    public static int calculateSpace(int[][] rectangles) {
        lowPoints.clear();
        highPoints.clear();
        sum = 0;

        for (int[] r : rectangles) {
            checkOverlap(r);
        }
//        for (int[] key : lowPoints.keySet()) {
//            for (int i : key){
//                System.out.print(i);
//            }
//            System.out.println();
//        }
        return sum;
    }

    public static void checkOverlap(int[] r) {
//        if (lowPoints.keySet().stream().filter(x -> x[0] < r[0] && x[1] >= r[1] && x[1] <= r[3] && (x[3] + x[0]) < r[0] ).count() == 1){
//        List<int[]> a = lowPoints.keySet().stream().filter(x -> x[0] < r[0] && x[1] >= r[1] && x[1] <= r[3]).collect(Collectors.toList());
        List<int[]> a = lowPoints.keySet().stream().filter(x -> x[0] < r[0] && x[1] >= r[1] && x[1] <= r[3]&& (x[2] + x[0]) > r[3]).collect(Collectors.toList());
//        System.out.println("r: "+ r[0]);
//        for (int i = 0; i< a.size(); i++)
//        {
//            for (int j = 0; j< a.get(i).length; j++) {
////                System.out.print("a: " + a.get(i)[j] + " ");
//            }
////            System.out.println();
//        }

        List<int[]> b = highPoints.keySet().stream().filter(x -> x[0] < r[0] && x[1] <= r[3] && x[1] <= r[3]&& (x[2] + x[0]) > r[3]).collect(Collectors.toList());
//        List<int[]> c = highPoints.entrySet().stream().filter(x -> x.getKey()[0] < r[0] && x.getKey()[1] <= r[3] && x.getKey()[1] <= r[3]&& (x.getValue() + x.getKey()[0]) > r[2]).map(x -> x.getKey()).collect(Collectors.toList());
//        System.out.println("r: "+ r[0] + " " + r[1] + " " + r[2] + " " + r[3]);
//        for (int i = 0; i< b.size(); i++)
//        {
////            for (int j = 0; j< b.get(i).length; j++) {
////                System.out.print("b: " + b.get(i)[j] + " ");
////
////            }
////            System.out.print("keyget"+ highPoints.get(c.get(i)));
////            System.out.println(c.size());
//        }

        if (a.size() == 0) {

//            rStartingPoints.add(new int[] {r[1], r[3], r[2] - r[0]});
            lowPoints.put(new int[]{r[0], r[1], r[2] - r[0]}, r[2] - r[0]);
        }

        if (b.size() == 0){
            highPoints.put(new int[]{r[0], r[3], r[2] - r[0]}, r[2] - r[0]);
        }
    }
}

//HashMap<int[], Integer> d = new HashMap<>();
//        highPoints.entrySet().stream().filter(x -> x.getKey()[0] < r[0] && x.getKey()[1] <= r[3] && x.getKey()[1] <= r[3]&& (x.getValue() + x.getKey()[0]) > r[0]).forEach(x -> d.put(x.getKey(), x.getValue()));
=======
package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class RectanglesUnion {

    static HashMap<int[], Integer> lowPoints = new HashMap<>();
    static HashMap<int[], Integer> highPoints = new HashMap<>();
    static ArrayList<int[]> rStartingPoints = new ArrayList<>();
    static int sum = 0;

    public static int calculateSpace(int[][] rectangles) {
        lowPoints.clear();
        highPoints.clear();
        sum = 0;

        for (int[] r : rectangles) {
            checkOverlap(r);
        }
//        for (int[] key : lowPoints.keySet()) {
//            for (int i : key){
//                System.out.print(i);
//            }
//            System.out.println();
//        }
        return sum;
    }

    public static void checkOverlap(int[] r) {
//        if (lowPoints.keySet().stream().filter(x -> x[0] < r[0] && x[1] >= r[1] && x[1] <= r[3] && (x[3] + x[0]) < r[0] ).count() == 1){
//        List<int[]> a = lowPoints.keySet().stream().filter(x -> x[0] < r[0] && x[1] >= r[1] && x[1] <= r[3]).collect(Collectors.toList());
        List<int[]> a = lowPoints.keySet().stream().filter(x -> x[0] < r[0] && x[1] >= r[1] && x[1] <= r[3]&& (x[2] + x[0]) > r[3]).collect(Collectors.toList());
//        System.out.println("r: "+ r[0]);
//        for (int i = 0; i< a.size(); i++)
//        {
//            for (int j = 0; j< a.get(i).length; j++) {
////                System.out.print("a: " + a.get(i)[j] + " ");
//            }
////            System.out.println();
//        }

        List<int[]> b = highPoints.keySet().stream().filter(x -> x[0] < r[0] && x[1] <= r[3] && x[1] <= r[3]&& (x[2] + x[0]) > r[3]).collect(Collectors.toList());
//        List<int[]> c = highPoints.entrySet().stream().filter(x -> x.getKey()[0] < r[0] && x.getKey()[1] <= r[3] && x.getKey()[1] <= r[3]&& (x.getValue() + x.getKey()[0]) > r[2]).map(x -> x.getKey()).collect(Collectors.toList());
//        System.out.println("r: "+ r[0] + " " + r[1] + " " + r[2] + " " + r[3]);
//        for (int i = 0; i< b.size(); i++)
//        {
////            for (int j = 0; j< b.get(i).length; j++) {
////                System.out.print("b: " + b.get(i)[j] + " ");
////
////            }
////            System.out.print("keyget"+ highPoints.get(c.get(i)));
////            System.out.println(c.size());
//        }

        if (a.size() == 0) {

//            rStartingPoints.add(new int[] {r[1], r[3], r[2] - r[0]});
            lowPoints.put(new int[]{r[0], r[1], r[2] - r[0]}, r[2] - r[0]);
        }

        if (b.size() == 0){
            highPoints.put(new int[]{r[0], r[3], r[2] - r[0]}, r[2] - r[0]);
        }
    }
}

//HashMap<int[], Integer> d = new HashMap<>();
//        highPoints.entrySet().stream().filter(x -> x.getKey()[0] < r[0] && x.getKey()[1] <= r[3] && x.getKey()[1] <= r[3]&& (x.getValue() + x.getKey()[0]) > r[0]).forEach(x -> d.put(x.getKey(), x.getValue()));
>>>>>>> cb881e417863984f2fdc738a364bbde6b5f3e18b
