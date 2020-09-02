package main.java.笔试.zczc.华为;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 小朋友拿球 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] input = new int[N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                input[i][j] = in.nextInt();
            }
        }

        List<String> red = new ArrayList();
        List<String> blue = new ArrayList();


        for (int i = 0; i < N; i++) {
            if (input[i][1] == 1) {
                red.add(input[i][0] + "," + (i + 1));
            } else {
                blue.add(input[i][0] + "," + (i + 1));
            }
        }

        if (red.size() < 3 && blue.size() < 3) {
            System.out.println("null");
            return;
        }

        int max = 0;
        int color = 1;

        String res = "";

        if (red.size() < 3) {
            max = 0;
        } else {
            for (int i = 0; i < red.size(); i++) {
                for (int j = i + 1; j < red.size(); j++) {
                    for (int k = j + 1; k < red.size(); k++) {

                        int first = Integer.parseInt(red.get(i).split(",")[0]);
                        int second = Integer.parseInt(red.get(j).split(",")[0]);
                        int third = Integer.parseInt(red.get(k).split(",")[0]);

                        if (first + second + third > max) {
                            max = first + second + third;
                            if (first <= second && second <= third) {
                                res = red.get(i).split(",")[1] + " " + red.get(j).split(",")[1]+ " " + red.get(k).split(",")[1];
                            } else if (first <= third && third <= second) {
                                res = red.get(i).split(",")[1] + " " + red.get(k).split(",")[1]+ " " + red.get(j).split(",")[1];
                            } else if (second <= first && first <= third) {
                                res = red.get(j).split(",")[1] + " " + red.get(i).split(",")[1]+ " " + red.get(k).split(",")[1];
                            } else if (second <= third && third <= first) {
                                res = red.get(j).split(",")[1] + " " + red.get(k).split(",")[1]+ " " + red.get(i).split(",")[1];
                            } else if (third <= second && second <= first) {
                                res = red.get(k).split(",")[1] + " " + red.get(j).split(",")[1]+ " " + red.get(i).split(",")[1];
                            } else if (third <= first && first <= second) {
                                res = red.get(k).split(",")[1] + " " + red.get(i).split(",")[1]+ " " + red.get(j).split(",")[1];
                            }
                        }
                    }
                }
            }
        }

        if (blue.size() >= 3) {
            for (int i = 0; i < blue.size(); i++) {
                for (int j = i + 1; j < blue.size(); j++) {
                    for (int k = j + 1; k < blue.size(); k++) {
                        if (Integer.parseInt(blue.get(i).split(",")[0]) + Integer.parseInt(blue.get(j).split(",")[0]) + Integer.parseInt(blue.get(k).split(",")[0]) > max) {
                            int first = Integer.parseInt(blue.get(i).split(",")[0]);
                            int second = Integer.parseInt(blue.get(j).split(",")[0]);
                            int third = Integer.parseInt(blue.get(k).split(",")[0]);

                            if (first + second + third > max) {
                                max = first + second + third;
                                if (first <= second && second <= third) {
                                    res = blue.get(i).split(",")[1] + " " + blue.get(j).split(",")[1] + " " + blue.get(k).split(",")[1];
                                } else if (first <= third && third <= second) {
                                    res = blue.get(i).split(",")[1] + " " + blue.get(k).split(",")[1]+ " " + blue.get(j).split(",")[1];
                                } else if (second <= first && first <= third) {
                                    res = blue.get(j).split(",")[1] + " " + blue.get(i).split(",")[1]+ " " + blue.get(k).split(",")[1];
                                } else if (second <= third && third <= first) {
                                    res = blue.get(j).split(",")[1] + " " + blue.get(k).split(",")[1]+ " " + blue.get(i).split(",")[1];
                                } else if (third <= second && second <= first) {
                                    res = blue.get(k).split(",")[1] + " " + blue.get(j).split(",")[1]+ " " + blue.get(i).split(",")[1];
                                } else if (third <= first && first <= second) {
                                    res = blue.get(k).split(",")[1] + " " + blue.get(i).split(",")[1]+ " " + blue.get(j).split(",")[1];
                                }
                            }
                            color = 2;
                        }
                    }
                }
            }
            System.out.println(res);
            System.out.println(color);
            System.out.println(max);
        }
    }
}
