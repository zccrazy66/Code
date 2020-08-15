package meituan.jungel;

import java.util.*;


public class MeiTuan03 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
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
            ArrayList list2=map.getOrDefault(b,new ArrayList<>());
            list2.add(a);
            map.put(b,list2);
        }
        List<Set<Integer>> list=new ArrayList<>();
        for (int i=0;i<integerList.size();i++){
            Queue<Integer> queue=new LinkedList<>();
            queue.add(integerList.get(i));
            check[integerList.get(i)]=1;
            Set<Integer> set=new HashSet<>();
            while (!queue.isEmpty()){
                int cur=queue.poll();
                set.add(cur);
                List curlist=map.get(cur);
                for (int j=0;j<curlist.size();j++){
                    if (check[(int)curlist.get(j)]==1){
                        continue;
                    }
                    else {
                        queue.add((int)curlist.get(j));
                        check[(int)curlist.get(j)]=1;
                    }
                }
            }
            list.add(set);
        }
        System.out.println(list.size());
        for (int i=0;i<list.size();i++){
            PriorityQueue<Integer> queue= new PriorityQueue<>(list.get(i));
            int t=queue.size();
            for (int k=0;k<t;k++){
                Integer poll = queue.poll();
                if (queue.size()!=0) {
                    System.out.print(poll+" ");
                }else {
                    System.out.print(poll);
                }

            }
        }
    }
}
