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

        int res=0;
        while (getIndex(monsters)!=-1) {

            int index = getIndex(monsters);

            LinkedList<Integer> list = getList(index,windows,monsters);
            int hp = monsters[index].HP;
            res=res+hp;
            for (Integer integer : list) {
                monsters[integer].HP=monsters[integer].HP-hp;
            }

        }

        System.out.println(res);

    }

    private static LinkedList<Integer> getList(int index, int windows,Monster[] monsters) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = monsters.length;
        for (int i = index; i < n; i++) {
            if (monsters[i].X>=monsters[index].X&&(monsters[i].X<=monsters[index].X+windows)&&monsters[i].HP>0) list.addLast(i);
        }

        return list;
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
