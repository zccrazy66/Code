package main.java.笔试.zczc.VMware;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        List res = new ArrayList();
        while (T > 0){
            int number = scanner.nextInt();
            int[] origin = new int[number];
            for (int i = 0; i < number; i++) {
                origin[i] = scanner.nextInt();
            }
            int[] target = new int[number];
            for (int i = 0; i < number; i++) {
                target[i] = scanner.nextInt();
            }
            res.add(canchange(origin,target));
            T--;
        }
        for (Object re : res) {
            System.out.println(re);
        }
    }

    private static String canchange(int[] origin, int[] target){
        LinkedHashMap map = new LinkedHashMap();
        for (int i = 0; i < target.length; i++) {
            if (!map.containsKey(target[i])){
                map.put(target[i],1);
            }
        }
        ArrayList<Integer> temp = new ArrayList();
        Iterator it=map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry en=(Map.Entry)it.next();
            temp.add((Integer) en.getKey());
        }
        // 要匹配的数量，严格按顺序来
        int count = temp.size();
        int t = 0;
        for (int i = 0; i < count; i++) {
            if (t >= origin.length){
                return "NO";
            }
            for (int j = t; j < origin.length ; j++) {
                t = j + 1;
                if (origin[j] == temp.get(i)){
                    break;
                }
            }
        }
        return "YES";
    }
}
