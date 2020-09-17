package main.java.笔试.joey.guanglianda;

import java.util.*;
import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/9/16 19:57
 */
public class AOE {
    public static void main(String args[]){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int y = cin.nextInt();
        int[][] monster = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = cin.nextInt();
            int hp = cin.nextInt();
            monster[i][0] = x;
            monster[i][1] = hp;
        }
        // 注意二维数组的重排序需要实现Comparator接口的对应比较方法
        Arrays.sort(monster,Comparator.comparingInt(p -> p[0]));
        // 总攻击次数
        int time = 0;
        // 遍历每一个怪物
        for (int i = 0; i < n; i++) {
            // 若怪物还有血
            while (monster[i][1] > 0) {
                // 灭掉该怪物还需多少刀
                int killTime = monster[i][1];
                // 看看同时还能顺便砍到右边哪些怪
                for (int j = i; j < n; j++) {
                    // 满足该条件，则这些怪也能被顺便砍
                    if (monster[j][0]-monster[i][0] <= y*2) {
                        monster[j][1] -= killTime;
                    }
                }
                time += killTime;
            }
        }
        System.out.println(time);
    }
}
