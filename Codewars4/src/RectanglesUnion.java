<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;

// the arraylist version

class Figure {
    ArrayList<Integer[]> topLeft = new ArrayList<>();
    ArrayList<Integer[]> topRight = new ArrayList<>();
    ArrayList<Integer[]> bottomLeft = new ArrayList<>();
    ArrayList<Integer[]> bottomRight = new ArrayList<>();

    public Figure(int[] rectangle){
        this.bottomLeft = new ArrayList<>();
        this.bottomRight = new ArrayList<>();
        this.topLeft = new ArrayList<>();
        this.topRight  = new ArrayList<>();
        this.bottomLeft.add(new Integer[] {rectangle[0], rectangle[1]});
        this.bottomRight.add(new Integer[] {rectangle[2], rectangle[1]});
        this.topLeft.add(new Integer[] {rectangle[0], rectangle[3]});
        this.topRight.add(new Integer[] {rectangle[2], rectangle[3]});
    }
}

class Rectangle {

    int minX;
    int maxX;
    int minY;
    int maxY;

    public Rectangle(int[] input)
    {
        this.minX = input[0];
        this.maxX = input[2];
        this.minY = input[1];
        this.maxY = input[3];
    }
}

public class RectanglesUnion {

    public static ArrayList<Figure> figures = new ArrayList<>();
    public static ArrayList<Rectangle> rectz = new ArrayList<>();
    public static boolean overlap = false;
    static int sum = 0;

    public static int calculateSpace(int[][] rectangles) {
        figures.clear();
        sum = 0;
        overlap = false;
        for (int[] rectangle : rectangles) {
            Rectangle rect = new Rectangle(rectangle);
            addRectangle(rect);
            System.out.println("{"+ Rectangle[0] + ", " + Rectangle[1] + ", " + Rectangle[2] + ", " + Rectangle[3] + "},");
        }

        System.out.println("figures size " + figures.size());
//        for (int i = 0; i < figures.get(0).topLeft.size(); i++) {
//            System.out.println(figures.get(0).topLeft.get(i)[0] + figures.get(0).topLeft.get(i)[1]);
//        }
        System.out.println("sum = " + sum);
        return sum;
    }

    static void addRectangle(Rectangle rectangle) {
        rectz.add(rectangle);
        if (overlap) {
            overlap = false;
            checkOverlaps(rectangle, figures.size() - 1);
        }

        if (!overlap) {
            Integer i = figures.size();
            figures.add(new Figure(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, rectangle.maxY}));
            sum += (rectangle.maxY - rectangle.minY) * (rectangle.maxX - rectangle.minX);
            overlap = true;
        }
    }

    static void checkOverlaps(Rectangle rectangle, Integer figureNumber) {
        // check if Rectangle's bottomleft is beyond FigureTopRight
//        System.out.println("checking Rectangle: " + rectangle.minX + " " + rectangle.minY + " " + rectangle.maxX + " " + rectangle.maxY);
        for (int j = 0; j < figures.get(figureNumber).topRight.size(); j++) {
            if (rectangle.minX < figures.get(figureNumber).topRight.get(j)[0] && rectangle.minY < figures.get(figureNumber).topRight.get(j)[1]
                    && rectangle.maxX > figures.get(figureNumber).topRight.get(j)[0] && rectangle.maxY > figures.get(figureNumber).topRight.get(j)[1]) { // add if statement to make sure rectangle corner is inside
                overlap = true;
//                System.out.println("toprightoverlap");

                sum += (figures.get(figureNumber).topRight.get(j)[0] - rectangle.minX) * (rectangle.maxY - figures.get(figureNumber).topRight.get(j)[1]);

                sum += (rectangle.maxX - figures.get(figureNumber).topRight.get(j)[0]) * (rectangle.maxY - rectangle.minY);

                figures.get(figureNumber).topLeft.add(new Integer[]{rectangle.minX, rectangle.maxY}); // can contain duplicates
                figures.get(figureNumber).topRight.set(j, new Integer[]{rectangle.maxX, rectangle.maxY});
                figures.get(figureNumber).bottomRight.add(new Integer[]{rectangle.maxX, rectangle.minY}); // can contain duplicates
            }
        }

        // check if Rectangle's topRight is beyond FigureBottomLeft

        for (int j = 0; j < figures.get(figureNumber).bottomLeft.size(); j++) {
            if (rectangle.maxX > figures.get(figureNumber).bottomLeft.get(j)[0] && rectangle.maxY > figures.get(figureNumber).bottomLeft.get(j)[1]
                    && rectangle.minX < figures.get(figureNumber).bottomLeft.get(j)[0] && rectangle.minY < figures.get(figureNumber).bottomLeft.get(j)[1]) {
                overlap = true;
//                System.out.println("bottomleftoverlap");
                sum += (rectangle.maxX - figures.get(figureNumber).bottomLeft.get(j)[0]) * (figures.get(figureNumber).bottomLeft.get(j)[1] - rectangle.minY);

                sum += (figures.get(figureNumber).bottomLeft.get(0)[0] - rectangle.minY) * (rectangle.maxY - rectangle.minY);

                figures.get(figureNumber).topLeft.add(new Integer[]{rectangle.minX, rectangle.maxY}); // can contain duplicates
                figures.get(figureNumber).bottomLeft.set(j, new Integer[]{rectangle.minX, rectangle.minY});
                figures.get(figureNumber).bottomRight.add(new Integer[]{rectangle.maxX, rectangle.minY}); // can contain duplicates
            }
        }
        // check if Rectangle's bottomleft is beyond FigureTopRight

        for (int j = 0; j < figures.get(figureNumber).topLeft.size(); j++) {
            if (rectangle.maxX > figures.get(figureNumber).topLeft.get(j)[0] && rectangle.minY < figures.get(figureNumber).topLeft.get(j)[1]
                    && rectangle.minX < figures.get(figureNumber).topLeft.get(j)[0] && rectangle.maxY > figures.get(figureNumber).topLeft.get(j)[1]) {
                overlap = true;

//                for (int i = rectangle.minX; i < figures.get(figureNumber).topLeft.get(j)[0]; i++) {
//                    sum += rectangle.maxY - rectangle.minY;
//                }
//                for (int i = figures.get(figureNumber).topLeft.get(j)[0]; i < rectangle.maxX; i++) {
//                    sum += rectangle.maxY - figures.get(figureNumber).topLeft.get(j)[1];
//                }
//                System.out.println("topleftoverlap");
//                System.out.println(rectangle.minX + " " + figures.get(figureNumber).topLeft.get(j)[0] + " " + rectangle.maxY + " " + figures.get(figureNumber).topLeft.get(j)[1]);
//                for (int i = 0; i < figures.get(figureNumber).topRight.size(); i++) {
//                    Integer[] newTR = new Integer[] {rectangle.maxX, rectangle.maxY};
//                    if (Arrays.equals(figures.get(figureNumber).topRight.get(i), newTR))
//                    {
//                        break;
//                    }
//                    figures.get(figureNumber).topLeft.add(newTR);
//                }
//
//                figures.get(figureNumber).topLeft.set(j, new Integer[] {rectangle.minX, rectangle.maxY});
//
//                for (int i = 0; i < figures.get(figureNumber).bottomLeft.size(); i++) {
//                    Integer[] newBR = new Integer[] {rectangle.maxX, rectangle.minY};
//                    if (Arrays.equals(figures.get(figureNumber).bottomLeft.get(i), newBR))
//                    {
//                        break;
//                    }
//                    figures.get(figureNumber).bottomRight.add(newBR);
//                }

                sum += (rectangle.maxX - figures.get(figureNumber).topLeft.get(j)[0]) * (rectangle.maxY - rectangle.minY);
//                System.out.println("hoi2 " + (figures.get(figureNumber).topLeft.get(j)[0] - rectangle.minX) + " " + (rectangle.maxY - rectangle.minY));

                sum += (rectangle.maxX - figures.get(figureNumber).topLeft.get(j)[0]) * (rectangle.maxY - figures.get(figureNumber).topLeft.get(j)[1]);
//                System.out.println("hoi3 " + (rectangle.maxX - figures.get(figureNumber).topLeft.get(j)[0]) + " " + (rectangle.maxY - figures.get(figureNumber).topLeft.get(j)[1]));

                figures.get(figureNumber).topLeft.set(j, new Integer[]{rectangle.minX, rectangle.maxY}); // can contain duplicates
                figures.get(figureNumber).topRight.add(new Integer[]{rectangle.maxX, rectangle.maxY});
                figures.get(figureNumber).bottomLeft.add(new Integer[]{rectangle.minX, rectangle.minY}); // can contain duplicates
            }
        }
        // check if Rectangle's bottomleft is beyond FigureTopRight

        for (int j = 0; j < figures.get(figureNumber).bottomRight.size(); j++) {
            if (rectangle.minX < figures.get(figureNumber).bottomRight.get(j)[0] && rectangle.maxY > figures.get(figureNumber).bottomRight.get(j)[1]
                    && rectangle.maxX > figures.get(figureNumber).bottomRight.get(j)[0] && rectangle.minY < figures.get(figureNumber).bottomRight.get(j)[1]) {
                overlap = true;
//                for (int i = rectangle.minX; i < figures.get(figureNumber).bottomRight.get(j)[0]; i++) {
//                    sum += figures.get(figureNumber).bottomRight.get(j)[1] - rectangle.minY;
//                }
//                for (int i = figures.get(figureNumber).bottomRight.get(j)[0]; i < rectangle.maxX; i++) {
//                    sum += rectangle.maxY - rectangle.minY;
//                }
//                System.out.println("bottomrightoverlap");
//                for (int i = 0; i < figures.get(figureNumber).topRight.size(); i++) {
//                    Integer[] newTR = new Integer[] {rectangle.maxX, rectangle.maxY};
//                    if (Arrays.equals(figures.get(figureNumber).topRight.get(i), newTR))
//                    {
//                        break;
//                    }
//                    figures.get(figureNumber).topRight.add(newTR);
//                }
//
//                figures.get(figureNumber).bottomRight.set(j, new Integer[] {rectangle.minX, rectangle.minY});
//
//                for (int i = 0; i < figures.get(figureNumber).bottomLeft.size(); i++) {
//                    Integer[] newBL = new Integer[] {rectangle.minX, rectangle.minY};
//                    if (Arrays.equals(figures.get(figureNumber).bottomLeft.get(i), newBL))
//                    {
//                        break;
//                    }
//                    figures.get(figureNumber).bottomRight.add(newBL);
                sum += (figures.get(figureNumber).bottomRight.get(j)[0] - rectangle.minX) * (rectangle.maxY - figures.get(figureNumber).bottomRight.get(j)[1]);
//                System.out.println(("hoi5 " + (figures.get(figureNumber).bottomRight.get(j)[0] - rectangle.minX) + " " + (rectangle.maxY - figures.get(figureNumber).bottomRight.get(j)[1])));
                sum += (rectangle.maxX - figures.get(figureNumber).bottomRight.get(j)[0]) * (rectangle.maxY - rectangle.minY);
//                System.out.println(("hoi5 " + (rectangle.maxX - figures.get(figureNumber).bottomRight.get(j)[0]) + " " + (rectangle.maxY - rectangle.minY)));

                figures.get(figureNumber).topLeft.add(new Integer[]{rectangle.minX, rectangle.maxY}); // can contain duplicates
                figures.get(figureNumber).bottomRight.set(j, new Integer[]{rectangle.maxX, rectangle.maxY});
                figures.get(figureNumber).bottomLeft.add(new Integer[]{rectangle.minX, rectangle.minY}); // can contain duplicates
            }
        }

        for (int j = 0; j < figures.get(figureNumber).topLeft.size(); j++) {
            for (int k = 0; k < figures.get(figureNumber).topRight.size(); k++) {
                if (rectangle.minY <= figures.get(figureNumber).topLeft.get(j)[1] && rectangle.minY <= figures.get(figureNumber).topRight.get(k)[1]
                        && rectangle.maxY > figures.get(figureNumber).topLeft.get(j)[1] && rectangle.maxY > figures.get(figureNumber).topRight.get(k)[1]
                        && rectangle.minX == figures.get(figureNumber).topLeft.get(j)[0] && rectangle.maxX == figures.get(figureNumber).topRight.get(k)[0]) {
                    overlap = true;
//                    System.out.println("topextension");
                    sum += (rectangle.maxY - figures.get(figureNumber).topLeft.get(j)[1]) * (rectangle.maxX - rectangle.minX); // werkt alleen bij gelijke hoeken
                    figures.get(figureNumber).topLeft.set(j, new Integer[]{rectangle.minX, rectangle.maxY});
                    figures.get(figureNumber).topRight.set(k, new Integer[]{rectangle.maxX, rectangle.maxY});
                    break;
                }
            }
        }

        for (int j = 0; j < figures.get(figureNumber).bottomLeft.size(); j++) {
            for (int k = 0; k < figures.get(figureNumber).bottomRight.size(); k++) {
                if (rectangle.maxY >= figures.get(figureNumber).bottomLeft.get(j)[1] && rectangle.maxY >= figures.get(figureNumber).bottomRight.get(k)[1]
                        && rectangle.minY < figures.get(figureNumber).bottomLeft.get(j)[1] && rectangle.minY < figures.get(figureNumber).bottomRight.get(k)[1]
                        && rectangle.minX == figures.get(figureNumber).bottomLeft.get(j)[0] && rectangle.maxX == figures.get(figureNumber).bottomRight.get(k)[0]) {
                    overlap = true;
//                    System.out.println("bottomextension");
                    sum += (figures.get(figureNumber).topLeft.get(j)[1] - rectangle.minY) * (rectangle.maxX - rectangle.minX);
                    figures.get(figureNumber).bottomLeft.set(j, new Integer[]{rectangle.minX, rectangle.minY});
                    figures.get(figureNumber).bottomRight.set(k, new Integer[]{rectangle.maxX, rectangle.minY});
                    break;
                }
            }
        }

        for (int j = 0; j < figures.get(figureNumber).topRight.size(); j++) {
            for (int k = 0; k < figures.get(figureNumber).bottomRight.size(); k++) {
                if (rectangle.minX <= figures.get(figureNumber).topRight.get(j)[0] && rectangle.minX <= figures.get(figureNumber).bottomRight.get(k)[0]
                        && rectangle.maxX > figures.get(figureNumber).topRight.get(j)[0] && rectangle.maxX > figures.get(figureNumber).bottomRight.get(k)[0]
                        && rectangle.maxY == figures.get(figureNumber).topRight.get(j)[1] && rectangle.minY == figures.get(figureNumber).bottomRight.get(k)[1]) {
                    overlap = true;
//                    System.out.println("rightextension");
                    sum += (rectangle.maxX - figures.get(figureNumber).topRight.get(j)[0]) * (rectangle.maxY - rectangle.minY);
                    figures.get(figureNumber).topRight.set(j, new Integer[]{rectangle.maxX, rectangle.maxY});
                    figures.get(figureNumber).bottomRight.set(k, new Integer[]{rectangle.maxX, rectangle.minY});
                }
            }
        }

        for (int j = 0; j < figures.get(figureNumber).topLeft.size(); j++) {
            for (int k = 0; k < figures.get(figureNumber).bottomLeft.size(); k++) {
                if (rectangle.maxX >= figures.get(figureNumber).topLeft.get(j)[0] && rectangle.maxX >= figures.get(figureNumber).bottomLeft.get(k)[0]
                        && rectangle.minX < figures.get(figureNumber).topLeft.get(j)[0] && rectangle.minX < figures.get(figureNumber).bottomLeft.get(k)[0]
                        && rectangle.maxY == figures.get(figureNumber).topLeft.get(j)[1] && rectangle.minY == figures.get(figureNumber).bottomLeft.get(k)[1]) {
                    overlap = true;
//                    System.out.println("leftextension");
                    sum += (figures.get(figureNumber).topLeft.get(j)[0] - rectangle.minX) * (rectangle.maxY - rectangle.minY);
//                    System.out.println((figures.get(figureNumber).topLeft.get(j)[0] - rectangle.minX) + " " + (rectangle.maxY - rectangle.minY));
                    figures.get(figureNumber).topLeft.set(j, new Integer[]{rectangle.minX, rectangle.maxY});
                    figures.get(figureNumber).bottomLeft.set(k, new Integer[]{rectangle.minX, rectangle.minY});
                }
            }
        }
//        //intersections: add figures to avoid mutlicorner clusterfuck?
//        outerloop:
//        for (int j = 0; j < figures.get(figureNumber).bottomLeft.size(); j++) {
////            for (int k = 0; k  < figures.get(figureNumber).bottomLeft.size(); k++){
//            if (rectangle.minY >= figures.get(figureNumber).bottomLeft.get(j)[1] && rectangle.maxY <= figures.get(figureNumber).topLeft.get(j)[1]
//                    && rectangle.maxX >= figures.get(figureNumber).bottomLeft.get(j)[0]
//                    && rectangle.minX < figures.get(figureNumber).bottomLeft.get(j)[0]) {
//                overlap = true;
////                System.out.println("left intersection");
//                sum += (figures.get(figureNumber).topLeft.get(j)[0] - rectangle.minX) * (rectangle.maxY - rectangle.minY);
////                System.out.println((figures.get(figureNumber).topLeft.get(j)[0] - rectangle.minX) + " " + (rectangle.maxY - rectangle.minY));
//                figures.get(figureNumber).topLeft.add(new Integer[]{rectangle.minX, rectangle.maxY});
//                figures.get(figureNumber).bottomLeft.add(new Integer[]{rectangle.minX, rectangle.minY});
////                figures.get(figureNumber).topRight.add(new Integer[]{figures.get(figureNumber).topLeft.get(j)[0], rectangle.maxY});
////                figures.get(figureNumber).bottomRight.add(new Integer[]{figures.get(figureNumber).topLeft.get(j)[0], rectangle.minY});
//                break outerloop;
//            }
//        }
//
//        outerloop:
//        for (int j = 0; j < figures.get(figureNumber).bottomLeft.size(); j++) {
////            for (int k = 0; k  < figures.get(figureNumber).bottomLeft.size(); k++){
//            if (rectangle.maxX >= figures.get(figureNumber).bottomLeft.get(j)[0] && rectangle.maxX <= figures.get(figureNumber).bottomRight.get(j)[0]
//                    && rectangle.maxY >= figures.get(figureNumber).bottomLeft.get(j)[1]
//                    && rectangle.minY < figures.get(figureNumber).bottomLeft.get(j)[1]) {
//                overlap = true;
////                System.out.println("bottom intersection");
//                sum += ((figures.get(figureNumber).bottomLeft.get(j)[1] -rectangle.minY)  * (rectangle.maxX - rectangle.minX));
////                System.out.println("hoi9 " + (figures.get(figureNumber).bottomLeft.get(j)[1] -rectangle.minY) + " " + (rectangle.maxX - rectangle.minX));
//                figures.get(figureNumber).bottomLeft.add(new Integer[]{rectangle.minX, rectangle.minY});
//                figures.get(figureNumber).bottomRight.add(new Integer[]{rectangle.maxX, rectangle.minY});
////                figures.get(figureNumber).topLeft.add(new Integer[]{rectangle.minX, figures.get(figureNumber).bottomLeft.get(j)[1]});
////                figures.get(figureNumber).topRight.add(new Integer[]{rectangle.maxX, figures.get(figureNumber).bottomLeft.get(j)[1]});
//                break outerloop;
//            }
//        }
//
//        outerloop:
//        for (int j = 0; j < figures.get(figureNumber).topLeft.size(); j++) {
////            for (int k = 0; k  < figures.get(figureNumber).bottomLeft.size(); k++){
//            if (rectangle.maxX >= figures.get(figureNumber).topLeft.get(j)[0] && rectangle.maxX <= figures.get(figureNumber).topRight.get(j)[0]
//                    && rectangle.maxY > figures.get(figureNumber).topLeft.get(j)[1]
//                    && rectangle.minY <= figures.get(figureNumber).topLeft.get(j)[1]) {
//                overlap = true;
////                System.out.println("top intersection");
//                sum += ((rectangle.maxY - figures.get(figureNumber).topLeft.get(j)[1]) * (rectangle.maxX - rectangle.minX));
////                System.out.println("hoi9 "+ j);
////                System.out.println("hoi9 "+ j + (rectangle.maxY - figures.get(figureNumber).topRight.get(j)[1]) + " " + (rectangle.maxX - rectangle.minX));
////                figures.get(figureNumber).bottomLeft.add(new Integer[]{rectangle.minX, rectangle.minY});
////                figures.get(figureNumber).bottomRight.add(new Integer[]{rectangle.maxX, rectangle.minY});
//                figures.get(figureNumber).topLeft.add(new Integer[]{rectangle.minX, figures.get(figureNumber).bottomLeft.get(j)[1]});
//                figures.get(figureNumber).topRight.add(new Integer[]{rectangle.maxX, figures.get(figureNumber).bottomLeft.get(j)[1]});
//                break outerloop;
//            }
//        }
//
//        outerloop:
//        for (int j = 0; j < figures.get(figureNumber).bottomRight.size(); j++) {
////            for (int k = 0; k  < figures.get(figureNumber).bottomLeft.size(); k++){
//            if (rectangle.minY >= figures.get(figureNumber).bottomRight.get(j)[1] && rectangle.maxY <= figures.get(figureNumber).topRight.get(j)[1]
//                    && rectangle.maxX > figures.get(figureNumber).bottomRight.get(j)[0]
//                    && rectangle.minX <= figures.get(figureNumber).bottomRight.get(j)[0]) {
//                overlap = true;
////                System.out.println("right intersection");
//                sum += (rectangle.maxX - figures.get(figureNumber).bottomRight.get(j)[0]) * (rectangle.maxY - rectangle.minY);
////                System.out.println((figures.get(figureNumber).bottomRight.get(j)[0] - rectangle.minX) + " " + (rectangle.maxY - rectangle.minY));
//                figures.get(figureNumber).topRight.add(new Integer[]{figures.get(figureNumber).topRight.get(j)[0], rectangle.maxY});
//                figures.get(figureNumber).bottomRight.add(new Integer[]{figures.get(figureNumber).topRight.get(j)[0], rectangle.minY});
////                figures.get(figureNumber).topRight.add(new Integer[]{figures.get(figureNumber).topLeft.get(j)[0], rectangle.maxY});
////                figures.get(figureNumber).bottomRight.add(new Integer[]{figures.get(figureNumber).topLeft.get(j)[0], rectangle.minY});
//                break outerloop;
//            }
//        }
    }
}
=======
import java.util.ArrayList;
import java.util.Arrays;

// the arraylist version

class Figure {
    ArrayList<Integer[]> topLeft = new ArrayList<>();
    ArrayList<Integer[]> topRight = new ArrayList<>();
    ArrayList<Integer[]> bottomLeft = new ArrayList<>();
    ArrayList<Integer[]> bottomRight = new ArrayList<>();

    public Figure(int[] rectangle){
        this.bottomLeft = new ArrayList<>();
        this.bottomRight = new ArrayList<>();
        this.topLeft = new ArrayList<>();
        this.topRight  = new ArrayList<>();
        this.bottomLeft.add(new Integer[] {rectangle[0], rectangle[1]});
        this.bottomRight.add(new Integer[] {rectangle[2], rectangle[1]});
        this.topLeft.add(new Integer[] {rectangle[0], rectangle[3]});
        this.topRight.add(new Integer[] {rectangle[2], rectangle[3]});
    }
}

class Rectangle {

    int minX;
    int maxX;
    int minY;
    int maxY;

    public Rectangle(int[] input)
    {
        this.minX = input[0];
        this.maxX = input[2];
        this.minY = input[1];
        this.maxY = input[3];
    }
}

public class RectanglesUnion {

    public static ArrayList<Figure> figures = new ArrayList<>();
    public static ArrayList<Rectangle> rectz = new ArrayList<>();
    public static boolean overlap = false;
    static int sum = 0;

    public static int calculateSpace(int[][] rectangles) {
        figures.clear();
        sum = 0;
        overlap = false;
        for (int[] rectangle : rectangles) {
            Rectangle rect = new Rectangle(rectangle);
            addRectangle(rect);
            System.out.println("{"+ Rectangle[0] + ", " + Rectangle[1] + ", " + Rectangle[2] + ", " + Rectangle[3] + "},");
        }

        System.out.println("figures size " + figures.size());
//        for (int i = 0; i < figures.get(0).topLeft.size(); i++) {
//            System.out.println(figures.get(0).topLeft.get(i)[0] + figures.get(0).topLeft.get(i)[1]);
//        }
        System.out.println("sum = " + sum);
        return sum;
    }

    static void addRectangle(Rectangle rectangle) {
        rectz.add(rectangle);
        if (overlap) {
            overlap = false;
            checkOverlaps(rectangle, figures.size() - 1);
        }

        if (!overlap) {
            Integer i = figures.size();
            figures.add(new Figure(new int[]{rectangle.minX, rectangle.minY, rectangle.maxX, rectangle.maxY}));
            sum += (rectangle.maxY - rectangle.minY) * (rectangle.maxX - rectangle.minX);
            overlap = true;
        }
    }

    static void checkOverlaps(Rectangle rectangle, Integer figureNumber) {
        // check if Rectangle's bottomleft is beyond FigureTopRight
//        System.out.println("checking Rectangle: " + rectangle.minX + " " + rectangle.minY + " " + rectangle.maxX + " " + rectangle.maxY);
        for (int j = 0; j < figures.get(figureNumber).topRight.size(); j++) {
            if (rectangle.minX < figures.get(figureNumber).topRight.get(j)[0] && rectangle.minY < figures.get(figureNumber).topRight.get(j)[1]
                    && rectangle.maxX > figures.get(figureNumber).topRight.get(j)[0] && rectangle.maxY > figures.get(figureNumber).topRight.get(j)[1]) { // add if statement to make sure rectangle corner is inside
                overlap = true;
//                System.out.println("toprightoverlap");

                sum += (figures.get(figureNumber).topRight.get(j)[0] - rectangle.minX) * (rectangle.maxY - figures.get(figureNumber).topRight.get(j)[1]);

                sum += (rectangle.maxX - figures.get(figureNumber).topRight.get(j)[0]) * (rectangle.maxY - rectangle.minY);

                figures.get(figureNumber).topLeft.add(new Integer[]{rectangle.minX, rectangle.maxY}); // can contain duplicates
                figures.get(figureNumber).topRight.set(j, new Integer[]{rectangle.maxX, rectangle.maxY});
                figures.get(figureNumber).bottomRight.add(new Integer[]{rectangle.maxX, rectangle.minY}); // can contain duplicates
            }
        }

        // check if Rectangle's topRight is beyond FigureBottomLeft

        for (int j = 0; j < figures.get(figureNumber).bottomLeft.size(); j++) {
            if (rectangle.maxX > figures.get(figureNumber).bottomLeft.get(j)[0] && rectangle.maxY > figures.get(figureNumber).bottomLeft.get(j)[1]
                    && rectangle.minX < figures.get(figureNumber).bottomLeft.get(j)[0] && rectangle.minY < figures.get(figureNumber).bottomLeft.get(j)[1]) {
                overlap = true;
//                System.out.println("bottomleftoverlap");
                sum += (rectangle.maxX - figures.get(figureNumber).bottomLeft.get(j)[0]) * (figures.get(figureNumber).bottomLeft.get(j)[1] - rectangle.minY);

                sum += (figures.get(figureNumber).bottomLeft.get(0)[0] - rectangle.minY) * (rectangle.maxY - rectangle.minY);

                figures.get(figureNumber).topLeft.add(new Integer[]{rectangle.minX, rectangle.maxY}); // can contain duplicates
                figures.get(figureNumber).bottomLeft.set(j, new Integer[]{rectangle.minX, rectangle.minY});
                figures.get(figureNumber).bottomRight.add(new Integer[]{rectangle.maxX, rectangle.minY}); // can contain duplicates
            }
        }
        // check if Rectangle's bottomleft is beyond FigureTopRight

        for (int j = 0; j < figures.get(figureNumber).topLeft.size(); j++) {
            if (rectangle.maxX > figures.get(figureNumber).topLeft.get(j)[0] && rectangle.minY < figures.get(figureNumber).topLeft.get(j)[1]
                    && rectangle.minX < figures.get(figureNumber).topLeft.get(j)[0] && rectangle.maxY > figures.get(figureNumber).topLeft.get(j)[1]) {
                overlap = true;

//                for (int i = rectangle.minX; i < figures.get(figureNumber).topLeft.get(j)[0]; i++) {
//                    sum += rectangle.maxY - rectangle.minY;
//                }
//                for (int i = figures.get(figureNumber).topLeft.get(j)[0]; i < rectangle.maxX; i++) {
//                    sum += rectangle.maxY - figures.get(figureNumber).topLeft.get(j)[1];
//                }
//                System.out.println("topleftoverlap");
//                System.out.println(rectangle.minX + " " + figures.get(figureNumber).topLeft.get(j)[0] + " " + rectangle.maxY + " " + figures.get(figureNumber).topLeft.get(j)[1]);
//                for (int i = 0; i < figures.get(figureNumber).topRight.size(); i++) {
//                    Integer[] newTR = new Integer[] {rectangle.maxX, rectangle.maxY};
//                    if (Arrays.equals(figures.get(figureNumber).topRight.get(i), newTR))
//                    {
//                        break;
//                    }
//                    figures.get(figureNumber).topLeft.add(newTR);
//                }
//
//                figures.get(figureNumber).topLeft.set(j, new Integer[] {rectangle.minX, rectangle.maxY});
//
//                for (int i = 0; i < figures.get(figureNumber).bottomLeft.size(); i++) {
//                    Integer[] newBR = new Integer[] {rectangle.maxX, rectangle.minY};
//                    if (Arrays.equals(figures.get(figureNumber).bottomLeft.get(i), newBR))
//                    {
//                        break;
//                    }
//                    figures.get(figureNumber).bottomRight.add(newBR);
//                }

                sum += (rectangle.maxX - figures.get(figureNumber).topLeft.get(j)[0]) * (rectangle.maxY - rectangle.minY);
//                System.out.println("hoi2 " + (figures.get(figureNumber).topLeft.get(j)[0] - rectangle.minX) + " " + (rectangle.maxY - rectangle.minY));

                sum += (rectangle.maxX - figures.get(figureNumber).topLeft.get(j)[0]) * (rectangle.maxY - figures.get(figureNumber).topLeft.get(j)[1]);
//                System.out.println("hoi3 " + (rectangle.maxX - figures.get(figureNumber).topLeft.get(j)[0]) + " " + (rectangle.maxY - figures.get(figureNumber).topLeft.get(j)[1]));

                figures.get(figureNumber).topLeft.set(j, new Integer[]{rectangle.minX, rectangle.maxY}); // can contain duplicates
                figures.get(figureNumber).topRight.add(new Integer[]{rectangle.maxX, rectangle.maxY});
                figures.get(figureNumber).bottomLeft.add(new Integer[]{rectangle.minX, rectangle.minY}); // can contain duplicates
            }
        }
        // check if Rectangle's bottomleft is beyond FigureTopRight

        for (int j = 0; j < figures.get(figureNumber).bottomRight.size(); j++) {
            if (rectangle.minX < figures.get(figureNumber).bottomRight.get(j)[0] && rectangle.maxY > figures.get(figureNumber).bottomRight.get(j)[1]
                    && rectangle.maxX > figures.get(figureNumber).bottomRight.get(j)[0] && rectangle.minY < figures.get(figureNumber).bottomRight.get(j)[1]) {
                overlap = true;
//                for (int i = rectangle.minX; i < figures.get(figureNumber).bottomRight.get(j)[0]; i++) {
//                    sum += figures.get(figureNumber).bottomRight.get(j)[1] - rectangle.minY;
//                }
//                for (int i = figures.get(figureNumber).bottomRight.get(j)[0]; i < rectangle.maxX; i++) {
//                    sum += rectangle.maxY - rectangle.minY;
//                }
//                System.out.println("bottomrightoverlap");
//                for (int i = 0; i < figures.get(figureNumber).topRight.size(); i++) {
//                    Integer[] newTR = new Integer[] {rectangle.maxX, rectangle.maxY};
//                    if (Arrays.equals(figures.get(figureNumber).topRight.get(i), newTR))
//                    {
//                        break;
//                    }
//                    figures.get(figureNumber).topRight.add(newTR);
//                }
//
//                figures.get(figureNumber).bottomRight.set(j, new Integer[] {rectangle.minX, rectangle.minY});
//
//                for (int i = 0; i < figures.get(figureNumber).bottomLeft.size(); i++) {
//                    Integer[] newBL = new Integer[] {rectangle.minX, rectangle.minY};
//                    if (Arrays.equals(figures.get(figureNumber).bottomLeft.get(i), newBL))
//                    {
//                        break;
//                    }
//                    figures.get(figureNumber).bottomRight.add(newBL);
                sum += (figures.get(figureNumber).bottomRight.get(j)[0] - rectangle.minX) * (rectangle.maxY - figures.get(figureNumber).bottomRight.get(j)[1]);
//                System.out.println(("hoi5 " + (figures.get(figureNumber).bottomRight.get(j)[0] - rectangle.minX) + " " + (rectangle.maxY - figures.get(figureNumber).bottomRight.get(j)[1])));
                sum += (rectangle.maxX - figures.get(figureNumber).bottomRight.get(j)[0]) * (rectangle.maxY - rectangle.minY);
//                System.out.println(("hoi5 " + (rectangle.maxX - figures.get(figureNumber).bottomRight.get(j)[0]) + " " + (rectangle.maxY - rectangle.minY)));

                figures.get(figureNumber).topLeft.add(new Integer[]{rectangle.minX, rectangle.maxY}); // can contain duplicates
                figures.get(figureNumber).bottomRight.set(j, new Integer[]{rectangle.maxX, rectangle.maxY});
                figures.get(figureNumber).bottomLeft.add(new Integer[]{rectangle.minX, rectangle.minY}); // can contain duplicates
            }
        }

        for (int j = 0; j < figures.get(figureNumber).topLeft.size(); j++) {
            for (int k = 0; k < figures.get(figureNumber).topRight.size(); k++) {
                if (rectangle.minY <= figures.get(figureNumber).topLeft.get(j)[1] && rectangle.minY <= figures.get(figureNumber).topRight.get(k)[1]
                        && rectangle.maxY > figures.get(figureNumber).topLeft.get(j)[1] && rectangle.maxY > figures.get(figureNumber).topRight.get(k)[1]
                        && rectangle.minX == figures.get(figureNumber).topLeft.get(j)[0] && rectangle.maxX == figures.get(figureNumber).topRight.get(k)[0]) {
                    overlap = true;
//                    System.out.println("topextension");
                    sum += (rectangle.maxY - figures.get(figureNumber).topLeft.get(j)[1]) * (rectangle.maxX - rectangle.minX); // werkt alleen bij gelijke hoeken
                    figures.get(figureNumber).topLeft.set(j, new Integer[]{rectangle.minX, rectangle.maxY});
                    figures.get(figureNumber).topRight.set(k, new Integer[]{rectangle.maxX, rectangle.maxY});
                    break;
                }
            }
        }

        for (int j = 0; j < figures.get(figureNumber).bottomLeft.size(); j++) {
            for (int k = 0; k < figures.get(figureNumber).bottomRight.size(); k++) {
                if (rectangle.maxY >= figures.get(figureNumber).bottomLeft.get(j)[1] && rectangle.maxY >= figures.get(figureNumber).bottomRight.get(k)[1]
                        && rectangle.minY < figures.get(figureNumber).bottomLeft.get(j)[1] && rectangle.minY < figures.get(figureNumber).bottomRight.get(k)[1]
                        && rectangle.minX == figures.get(figureNumber).bottomLeft.get(j)[0] && rectangle.maxX == figures.get(figureNumber).bottomRight.get(k)[0]) {
                    overlap = true;
//                    System.out.println("bottomextension");
                    sum += (figures.get(figureNumber).topLeft.get(j)[1] - rectangle.minY) * (rectangle.maxX - rectangle.minX);
                    figures.get(figureNumber).bottomLeft.set(j, new Integer[]{rectangle.minX, rectangle.minY});
                    figures.get(figureNumber).bottomRight.set(k, new Integer[]{rectangle.maxX, rectangle.minY});
                    break;
                }
            }
        }

        for (int j = 0; j < figures.get(figureNumber).topRight.size(); j++) {
            for (int k = 0; k < figures.get(figureNumber).bottomRight.size(); k++) {
                if (rectangle.minX <= figures.get(figureNumber).topRight.get(j)[0] && rectangle.minX <= figures.get(figureNumber).bottomRight.get(k)[0]
                        && rectangle.maxX > figures.get(figureNumber).topRight.get(j)[0] && rectangle.maxX > figures.get(figureNumber).bottomRight.get(k)[0]
                        && rectangle.maxY == figures.get(figureNumber).topRight.get(j)[1] && rectangle.minY == figures.get(figureNumber).bottomRight.get(k)[1]) {
                    overlap = true;
//                    System.out.println("rightextension");
                    sum += (rectangle.maxX - figures.get(figureNumber).topRight.get(j)[0]) * (rectangle.maxY - rectangle.minY);
                    figures.get(figureNumber).topRight.set(j, new Integer[]{rectangle.maxX, rectangle.maxY});
                    figures.get(figureNumber).bottomRight.set(k, new Integer[]{rectangle.maxX, rectangle.minY});
                }
            }
        }

        for (int j = 0; j < figures.get(figureNumber).topLeft.size(); j++) {
            for (int k = 0; k < figures.get(figureNumber).bottomLeft.size(); k++) {
                if (rectangle.maxX >= figures.get(figureNumber).topLeft.get(j)[0] && rectangle.maxX >= figures.get(figureNumber).bottomLeft.get(k)[0]
                        && rectangle.minX < figures.get(figureNumber).topLeft.get(j)[0] && rectangle.minX < figures.get(figureNumber).bottomLeft.get(k)[0]
                        && rectangle.maxY == figures.get(figureNumber).topLeft.get(j)[1] && rectangle.minY == figures.get(figureNumber).bottomLeft.get(k)[1]) {
                    overlap = true;
//                    System.out.println("leftextension");
                    sum += (figures.get(figureNumber).topLeft.get(j)[0] - rectangle.minX) * (rectangle.maxY - rectangle.minY);
//                    System.out.println((figures.get(figureNumber).topLeft.get(j)[0] - rectangle.minX) + " " + (rectangle.maxY - rectangle.minY));
                    figures.get(figureNumber).topLeft.set(j, new Integer[]{rectangle.minX, rectangle.maxY});
                    figures.get(figureNumber).bottomLeft.set(k, new Integer[]{rectangle.minX, rectangle.minY});
                }
            }
        }
//        //intersections: add figures to avoid mutlicorner clusterfuck?
//        outerloop:
//        for (int j = 0; j < figures.get(figureNumber).bottomLeft.size(); j++) {
////            for (int k = 0; k  < figures.get(figureNumber).bottomLeft.size(); k++){
//            if (rectangle.minY >= figures.get(figureNumber).bottomLeft.get(j)[1] && rectangle.maxY <= figures.get(figureNumber).topLeft.get(j)[1]
//                    && rectangle.maxX >= figures.get(figureNumber).bottomLeft.get(j)[0]
//                    && rectangle.minX < figures.get(figureNumber).bottomLeft.get(j)[0]) {
//                overlap = true;
////                System.out.println("left intersection");
//                sum += (figures.get(figureNumber).topLeft.get(j)[0] - rectangle.minX) * (rectangle.maxY - rectangle.minY);
////                System.out.println((figures.get(figureNumber).topLeft.get(j)[0] - rectangle.minX) + " " + (rectangle.maxY - rectangle.minY));
//                figures.get(figureNumber).topLeft.add(new Integer[]{rectangle.minX, rectangle.maxY});
//                figures.get(figureNumber).bottomLeft.add(new Integer[]{rectangle.minX, rectangle.minY});
////                figures.get(figureNumber).topRight.add(new Integer[]{figures.get(figureNumber).topLeft.get(j)[0], rectangle.maxY});
////                figures.get(figureNumber).bottomRight.add(new Integer[]{figures.get(figureNumber).topLeft.get(j)[0], rectangle.minY});
//                break outerloop;
//            }
//        }
//
//        outerloop:
//        for (int j = 0; j < figures.get(figureNumber).bottomLeft.size(); j++) {
////            for (int k = 0; k  < figures.get(figureNumber).bottomLeft.size(); k++){
//            if (rectangle.maxX >= figures.get(figureNumber).bottomLeft.get(j)[0] && rectangle.maxX <= figures.get(figureNumber).bottomRight.get(j)[0]
//                    && rectangle.maxY >= figures.get(figureNumber).bottomLeft.get(j)[1]
//                    && rectangle.minY < figures.get(figureNumber).bottomLeft.get(j)[1]) {
//                overlap = true;
////                System.out.println("bottom intersection");
//                sum += ((figures.get(figureNumber).bottomLeft.get(j)[1] -rectangle.minY)  * (rectangle.maxX - rectangle.minX));
////                System.out.println("hoi9 " + (figures.get(figureNumber).bottomLeft.get(j)[1] -rectangle.minY) + " " + (rectangle.maxX - rectangle.minX));
//                figures.get(figureNumber).bottomLeft.add(new Integer[]{rectangle.minX, rectangle.minY});
//                figures.get(figureNumber).bottomRight.add(new Integer[]{rectangle.maxX, rectangle.minY});
////                figures.get(figureNumber).topLeft.add(new Integer[]{rectangle.minX, figures.get(figureNumber).bottomLeft.get(j)[1]});
////                figures.get(figureNumber).topRight.add(new Integer[]{rectangle.maxX, figures.get(figureNumber).bottomLeft.get(j)[1]});
//                break outerloop;
//            }
//        }
//
//        outerloop:
//        for (int j = 0; j < figures.get(figureNumber).topLeft.size(); j++) {
////            for (int k = 0; k  < figures.get(figureNumber).bottomLeft.size(); k++){
//            if (rectangle.maxX >= figures.get(figureNumber).topLeft.get(j)[0] && rectangle.maxX <= figures.get(figureNumber).topRight.get(j)[0]
//                    && rectangle.maxY > figures.get(figureNumber).topLeft.get(j)[1]
//                    && rectangle.minY <= figures.get(figureNumber).topLeft.get(j)[1]) {
//                overlap = true;
////                System.out.println("top intersection");
//                sum += ((rectangle.maxY - figures.get(figureNumber).topLeft.get(j)[1]) * (rectangle.maxX - rectangle.minX));
////                System.out.println("hoi9 "+ j);
////                System.out.println("hoi9 "+ j + (rectangle.maxY - figures.get(figureNumber).topRight.get(j)[1]) + " " + (rectangle.maxX - rectangle.minX));
////                figures.get(figureNumber).bottomLeft.add(new Integer[]{rectangle.minX, rectangle.minY});
////                figures.get(figureNumber).bottomRight.add(new Integer[]{rectangle.maxX, rectangle.minY});
//                figures.get(figureNumber).topLeft.add(new Integer[]{rectangle.minX, figures.get(figureNumber).bottomLeft.get(j)[1]});
//                figures.get(figureNumber).topRight.add(new Integer[]{rectangle.maxX, figures.get(figureNumber).bottomLeft.get(j)[1]});
//                break outerloop;
//            }
//        }
//
//        outerloop:
//        for (int j = 0; j < figures.get(figureNumber).bottomRight.size(); j++) {
////            for (int k = 0; k  < figures.get(figureNumber).bottomLeft.size(); k++){
//            if (rectangle.minY >= figures.get(figureNumber).bottomRight.get(j)[1] && rectangle.maxY <= figures.get(figureNumber).topRight.get(j)[1]
//                    && rectangle.maxX > figures.get(figureNumber).bottomRight.get(j)[0]
//                    && rectangle.minX <= figures.get(figureNumber).bottomRight.get(j)[0]) {
//                overlap = true;
////                System.out.println("right intersection");
//                sum += (rectangle.maxX - figures.get(figureNumber).bottomRight.get(j)[0]) * (rectangle.maxY - rectangle.minY);
////                System.out.println((figures.get(figureNumber).bottomRight.get(j)[0] - rectangle.minX) + " " + (rectangle.maxY - rectangle.minY));
//                figures.get(figureNumber).topRight.add(new Integer[]{figures.get(figureNumber).topRight.get(j)[0], rectangle.maxY});
//                figures.get(figureNumber).bottomRight.add(new Integer[]{figures.get(figureNumber).topRight.get(j)[0], rectangle.minY});
////                figures.get(figureNumber).topRight.add(new Integer[]{figures.get(figureNumber).topLeft.get(j)[0], rectangle.maxY});
////                figures.get(figureNumber).bottomRight.add(new Integer[]{figures.get(figureNumber).topLeft.get(j)[0], rectangle.minY});
//                break outerloop;
//            }
//        }
    }
}
>>>>>>> cb881e417863984f2fdc738a364bbde6b5f3e18b
