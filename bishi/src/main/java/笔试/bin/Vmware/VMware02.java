package bishi.src.main.java.笔试.bin.Vmware;

import java.util.*;

/**
 * Created by 林松斌的船 on 2020/9/21.
 */
public class VMware02 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        List<Integer> res=new LinkedList<>();
        int n=s.nextInt();
        int K=s.nextInt();
        HashMap<Integer,HashSet<Integer>> hashMap=new HashMap<>();
        for (int i=1;i<=n;i++){
            int x1=s.nextInt();
            HashSet<Integer> list=hashMap.getOrDefault(x1,new HashSet<Integer>());
            list.add(i);
            if (list.size()>=K)res.add(x1);
            hashMap.put(x1,list);
            ///////////////////////
            int x2=s.nextInt();
            HashSet<Integer> list2=hashMap.getOrDefault(x2,new HashSet<Integer>());
            list2.add(i);
            if (list2.size()>=K)res.add(x2);
            hashMap.put(x2,list2);
        }
        int sum=0;
        for (int i=1;i<=n;i++){
            HashSet<Integer> list1=hashMap.get(i);
           // System.out.println("list1.size"+list1.size());
            if (list1.size()>K){
                sum+=n-i;
                //System.out.println(i);
                continue;
            }
          //  Iterator<Integer> it=list1.iterator();
            for (int j=i+1;j<=n;j++){
                HashSet<Integer> list2=hashMap.get(j);
                Iterator<Integer> it=list1.iterator();
                Iterator<Integer> it2=list2.iterator();
                HashSet<Integer> newset=new HashSet<>();
                while (it.hasNext()){
                    int c=it.next();
                   // System.out.println("add"+c);
                    newset.add(c);
                }
                while (it2.hasNext()){
                    int c=it2.next();
                   // System.out.println("add"+c);
                    newset.add(c);
                }
                if (newset.size()>=K){
                   // System.out.println(i+" "+j);
                   // System.out.println(newset.size());
                    sum++;
                }
            }

        }
        System.out.println(sum);

    }
}
