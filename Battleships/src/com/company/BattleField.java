package com.company;

import java.util.ArrayList;
import java.util.List;

public class BattleField {

    public static boolean fieldValidator(int[][] field) {

        return false;
    }

    public static int[][] detectShipsHorizontal(int[][] field) {
        for (int[] array : field) {
            List<String> ships = new ArrayList<>();
            for (int i : array) {
                int shipCounter = 0;
                if (array[i] == 1) {
                    shipCounter++;
                } else if (array[i] == 0 && shipCounter > 0) {
                    switch (shipCounter) {
                        case 1:
                            array[i - 1] = 5;
                            break;
                        case 2:
                            array[i - 1] = 2;
                            array[i - 2] = 2;
                            ships.add("Sweeper");
                            break;
                        case 3:
                            array[i - 1] = 3;
                            array[i - 2] = 3;
                            array[i - 3] = 3;
                            ships.add("Destroyer");
                            break;
                        case 4:
                            array[i - 1] = 4;
                            array[i - 2] = 4;
                            array[i - 3] = 4;
                            array[i - 4] = 4;
                            ships.add("Cruiser");
                            break;
                    }
                }
            }
        }
        return field;
    }

    public static int[][] detectShipsVertical(int[][] field) {
        for (int i = 0; i < 10 ; i++){
            for (int j = 0; j < 10; j++) {
                int shipCounter = 0;
                if (field[j][i] == 1) {
                    shipCounter++;
                } else if (field[j][i] == 0 && shipCounter > 0) {
                    switch (shipCounter) {
                        case 1:
                            array[i - 1] = 5;
                            break;
                        case 2:
                            array[i - 1] = 2;
                            array[i - 2] = 2;
                            ships.add("Sweeper");
                            break;
                        case 3:
                            array[i - 1] = 3;
                            array[i - 2] = 3;
                            array[i - 3] = 3;
                            ships.add("Destroyer");
                            break;
                        case 4:
                            array[i - 1] = 4;
                            array[i - 2] = 4;
                            array[i - 3] = 4;
                            array[i - 4] = 4;
                            ships.add("Cruiser");
                            break;
                    }
                }
            }
        }

    return field;
    }

    public static boolean clearWaters(int[][] field){

    }
}
