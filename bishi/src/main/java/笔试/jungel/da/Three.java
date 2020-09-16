package 笔试.jungel.da;

import java.util.LinkedList;
import java.util.Scanner;

public class Three {

    private static class Monster{
        int X;
        int HP;

        public Monster(int x, int HP) {
            X = x;
            this.HP = HP;
        }
    }

    private static Monster[] arr;
    private static int size;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int y = scanner.nextInt();
        Monster[] monsters = new Monster[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int hp = scanner.nextInt();

            monsters[i]=new Monster(x,hp);
        }

        // 窗口大小
        int windows = y*2;
        arr = monsters;
        size=n;
        int res=0;

        while (getIndex(monsters)!=-1) {

            int index = getIndex(monsters);
            int hp = arr[index].HP;
            getList(index,windows,hp);

            res=res+hp;

        }

        System.out.println(res);

    }

    private static void  getList(int index, int windows,int hp) {

        for (int i = index; i < size; i++) {
            if (arr[i].X>=arr[index].X&&(arr[i].X<=arr[index].X+windows)&&arr[i].HP>0) {
                arr[i].HP=arr[i].HP-hp;
            }
        }


    }

    /**
     * 获取第一个不为零的下标
     * @return 如果不存在，返回-1；
     */
    private static int getIndex(Monster[] monsters) {

        int index =-1;
        int n = monsters.length;
        for (int i = 0; i < n; i++) {
            if (monsters[i].HP>0) {
                index=i;
                break;
            }
        }
        return index;
    }
}
