package meituan.jungel;

import java.util.*;

public class MeiTu02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, LinkedList<String>> map = new HashMap<>();


        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            if (!map.containsKey(split[0])) {
                LinkedList<String> strings = new LinkedList<>();
                strings.addLast(split[1]);
                map.put(split[0],strings);
            }else {
                map.get(split[0]).addLast(split[1]);
            }

        }


        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(o -> map.get(o).size()));


        for (String s : map.keySet()) {
            queue.add(s);
        }

        int res=0;
        while (queue.size()!=0) {
            String s = queue.remove();

            if (map.get(s).size()!=0) {
                // 起点
                String start = s;
                LinkedList<String> list = map.get(s);
                String temp = list.removeFirst();
                if (list.size()!=0) queue.add(s);


                while (!temp.equals(start)) {
                    temp = map.get(temp).removeFirst();
                }

                res++;
            }


        }


        System.out.println(res);
    }
}
