package meituan.jungel;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.*;

public class MeiTu04 {


    private static class Area {
        int a;
        int b;

        public Area(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();
        LinkedList<Area> list = new LinkedList<>();


        PriorityQueue<Area> areas = new PriorityQueue<>(new Comparator<Area>() {
            @Override
            public int compare(Area o1, Area o2) {
                if (o1.a!=o2.a) {
                    return o2.a-o1.a;
                }else {
                    return o2.b-o1.b;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            Area area = new Area(a, b);

            areas.add(area);
        }

        int res =0;


        for (int i = 0; i < A; i++) {
            Area remove = areas.remove();
            res = res+remove.a;
        }
        for (int i = 0; i < B; i++) {
            Area remove = areas.remove();
            res = res+remove.b;
        }

        System.out.println(res);

    }

}
