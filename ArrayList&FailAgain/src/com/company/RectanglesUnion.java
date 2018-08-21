package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RectanglesUnion {
    public static HashMap<int[], Integer> startingPoints = new HashMap<>();
    public static HashMap<Integer, int[]> endPoints = new HashMap<>();
    public static int sum = 0 ;
    public static int tempIndex = 0;

    public static int calculateSpace(int[][] rectangles){
        startingPoints.clear();
        endPoints.clear();
        sum = 0;


        for (int[] r : rectangles)
        {
            setStartinPoints(r);
        }
//         for (int[] key : startingPoints.keySet()) {
//             for (int i : key){
//                 System.out.print(i);
//             }
//             System.out.println();
//         }
        return 0;
    }

    public static void setStartinPoints(int[] rectangle) {

        //Map<int[], Integer> a = startingPoints.entrySet().stream().filter(x-> x.getKey()[0] < rectangle[0] && x.getKey()[1] >= rectangle[1] && x.getKey()[1] <= rectangle[3] && x.getValue() < rectangle[2]).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
//        List<int[]> b = startingPoints.entrySet().stream().filter(x-> x.getKey()[0] < rectangle[0] && rectangle[0] < x.getValue() && x.getKey()[1] >= rectangle[1] && x.getKey()[1] <= rectangle[3] && x.getValue() < rectangle[2]).map(x -> x.getKey()).collect(Collectors.toList());
        Optional<Map.Entry<int[],Integer>> c = Optional.empty();
        c = startingPoints.entrySet().stream().filter(x-> x.getKey()[0] < rectangle[0] && rectangle[0] < x.getValue() && x.getKey()[1] >= rectangle[1] && x.getKey()[1] <= rectangle[3] && x.getValue() < rectangle[2]).max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1);

//        Optional<Map.Entry<int[], Integer>> a = startingPoints.entrySet().stream().filter(x-> x.getKey()[0] < rectangle[0] && rectangle[0] < x.getValue() && x.getKey()[1] >= rectangle[1] && x.getKey()[1] <= rectangle[3] && x.getValue() < rectangle[2]).max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1);

        List<int[]> b = endPoints.values().stream().filter(x-> x[0] < rectangle[0] && rectangle[0] < x[2] && x[1] >= rectangle[1] && x[1] <= rectangle[3] && x[2] < rectangle[2]).collect(Collectors.toList());


//                System.out.print("hoi"+ key[0] + " " + key[1]);
//            System.out.println("tering"+ b.size());
//            if (b.size() > 0) {
//                endPoints.replace();
//            }
//            System.out.println();
//        List<int[]> c = endPoints.entrySet().stream().filter(x-> x.getKey()[0] < rectangle[0] && x.getKey()[1] >= rectangle[1] && x.getKey()[1] <= rectangle[3] && x.getValue() < rectangle[2]).map(x -> x.getKey()).collect(Collectors.toList());
//        if (b.isEmpty()) {
            startingPoints.put(new int[] {rectangle[0], rectangle[1]}, rectangle[2]);
            startingPoints.put(new int[] {rectangle[0], rectangle[3]}, rectangle[2]);
//        }
//        if (c.isEmpty()){
            endPoints.put(tempIndex, new int[] {rectangle[0], rectangle[1], rectangle[2]});
            tempIndex++;
            endPoints.put(tempIndex, new int[] {rectangle[0], rectangle[3], rectangle[2]});
            tempIndex++;
//        }

    }
}

//    List<int[]> a = startingPoints.values().stream().flatMap(List::stream).filter(x -> x[0] <= rectangle[1] ).collect(Collectors.toList());
//
//    List<int[]> b = startingPoints.values().stream().filter(x ->  < rectangle[0]).collect(Collectors.toList());

