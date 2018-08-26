package com.company;

import java.util.ArrayList;
import java.util.List;

public class BattleField {

    static List<String> ships = new ArrayList<>();

    public static boolean fieldValidator(int[][] field) {
        ships.clear();
        field = detectShipsHorizontal(field);
        field = detectShipsVertical(field);
        if (shipCheck())
        return clearWaters(field);
        else return false;
    }

    public static int[][] detectShipsHorizontal(int[][] field) {
        for (int j = 0; j < 10; j++) {
            int shipCounter = 0;
            for (int i = 0; i < 10; i++) {
                if (field[j][i] == 1 ||field[j][i] == 5) {
                    shipCounter++;
                } else if ((field[j][i] == 0 || i == field[j].length -1) && shipCounter > 0) {
                    switch (shipCounter) {
                        case 1:
                            field[j][i - 1] = 5;
                            shipCounter = 0;
                            break;
                        case 2:
                            field[j][i - 1] = 2;
                            field[j][i - 2] = 2;
                            ships.add("Destroyer");
                            shipCounter = 0;
                            break;
                        case 3:
                            field[j][i - 1] = 3;
                            field[j][i - 2] = 3;
                            field[j][i - 3] = 3;
                            ships.add("Cruiser");
                            shipCounter = 0;
                            break;
                        case 4:
                            field[j][i - 1] = 4;
                            field[j][i - 2] = 4;
                            field[j][i - 3] = 4;
                            field[j][i - 4] = 4;
                            ships.add("Battleship");
                            shipCounter = 0;
                            break;
                    }
                }
            }
        }
        return field;
    }

    public static int[][] detectShipsVertical(int[][] field) {
        for (int i = 0; i < 10 ; i++){
            int shipCounter = 0;
            for (int j = 0; j < 10; j++) {
                if (field[j][i] == 1 || field[j][i] == 5) {
                    shipCounter++;
                } else if ((field[j][i] == 0 || j == 9) && shipCounter > 0) {
                    switch (shipCounter) {
                        case 1:
                            field[j - 1][i] = 5;
                            ships.add("Sub");
                            shipCounter = 0;
                            break;
                        case 2:
                            field[j - 1][i] = 2;
                            field[j - 2][i] = 2;
                            ships.add("Destroyer");
                            shipCounter = 0;
                            break;
                        case 3:
                            field[j - 1][i] = 3;
                            field[j - 2][i] = 3;
                            field[j - 3][i] = 3;
                            ships.add("Cruiser");
                            shipCounter = 0;
                            break;
                        case 4:
                            field[j - 1][i] = 4;
                            field[j - 2][i] = 4;
                            field[j - 3][i] = 4;
                            field[j - 4][i] = 4;
                            ships.add("Battleship");
                            shipCounter = 0;
                            break;
                    }
                }
            }
        }
    return field;
    }

    public static boolean shipCheck() {
        if (ships.stream().filter(x -> x =="Sub").count() ==4
        && ships.stream().filter(x -> x =="Destroyer").count() == 3
        && ships.stream().filter(x -> x =="Cruiser").count() == 2
        && ships.stream().filter(x -> x =="Battleship").count() == 1) {
            return true;
        }
        else return false;
    }

    public static boolean clearWaters(int[][] field){
        for (int i = 1; i < 10; i++){
            for (int j = 1; j < 10; j++){
                if (field[j - 1][i - 1] > 0 && field[j][i] > 0 || (field[i -1][j] > 0 && field[i][j -1] > 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
