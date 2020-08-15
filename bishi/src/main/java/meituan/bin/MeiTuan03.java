package meituan.bin;

import java.util.*;

/**
 * Created by 林松斌的船 on 2020/8/15.
 */
public class MeiTuan03 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int[][] nums=new int[m][2];
        int[] check=new int[n+1];
        List<Integer> integerList=new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer, ArrayList<Integer>>();
        for (int i=0;i<m;i++){
            int a=s.nextInt();
            int b=s.nextInt();
            if ((!map.containsKey(a))&&(!map.containsKey(b))){
                integerList.add(a);
            }
            ArrayList list=map.getOrDefault(a,new ArrayList<>());
            list.add(b);
            map.put(a,list);
            // System.out.println(a+"+"+Arrays.toString(list.toArray()));
            ArrayList list2=map.getOrDefault(b,new ArrayList<>());
            // System.out.println(b+"+"+Arrays.toString(list.toArray()));
            list2.add(a);
            map.put(b,list2);
            // System.out.println(b+"+"+Arrays.toString(list2.toArray()));
        }
        // System.out.println(Arrays.toString(map.get(1).toArray()));
        List<Set<Integer>> list=new ArrayList<>();
        for (int i=0;i<integerList.size();i++){
            Queue<Integer> queue=new LinkedList<>();
            queue.add(integerList.get(i));
            // System.out.println(integerList.get(i));
            check[integerList.get(i)]=1;
            Set<Integer> set=new HashSet<>();
            while (!queue.isEmpty()){
                int cur=queue.poll();
                //  System.out.println(cur);
                set.add(cur);
                List curlist=map.get(cur);
                //   System.out.println(Arrays.toString(curlist.toArray())+curlist.size());
                for (int j=0;j<curlist.size();j++){
                    // System.out.println(j+"qwe");
                    if (check[(int)curlist.get(j)]==1){
                        continue;
                    }
                    else {
                        //  System.out.println(curlist.get(j));
                        queue.add((int)curlist.get(j));
                        check[(int)curlist.get(j)]=1;
                    }
                }
            }
            System.out.println(Arrays.toString(set.toArray()));
            list.add(set);
        }
        System.out.println(list.size());
        for (int i=0;i<list.size();i++){
            PriorityQueue<Integer> queue= new PriorityQueue<>(list.get(i));
            int t=queue.size();
            for (int k=0;k<t;k++){
                System.out.print(queue.poll());
            }
            System.out.println();


        }




    }
}
