package bishi.src.main.java.笔试.bin.TENXUN;

import java.util.*;

/**
 * Created by 林松斌的船 on 2020/8/23.
 */
public class TX033 {

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();

        HashMap<String,Integer> hashMap=new HashMap<>();
        List<String> list=new LinkedList<>();
        List<Integer> numslist=new LinkedList<>();
        for (int i=0;i<n;i++){
            String cur=s.next();
            // System.out.println("cur="+cur);
            if(list.contains(cur)){
                int index=list.indexOf(cur);
                Integer get=numslist.get(index);
                get++;
                numslist.remove(index);
                numslist.add(index,get);
            }else {
                list.add(cur);
                numslist.add(1);
            }
        }
        // System.out.println(Arrays.toString(list.toArray()));
        // System.out.println(Arrays.toString(numslist.toArray()));
        PriorityQueue<S> queue=new PriorityQueue<>(new Comparator<S>() {
            @Override
            public int compare(S o1, S o2) {
                if (o2.t>o1.t){
                    return 1;
                }
                if (o2.t<o1.t){
                    return -1;
                }
                else {
                    int i=0;
                    return o1.s.compareTo(o2.s);
                }
            }
        });
        PriorityQueue<S> queue1=new PriorityQueue<>(new Comparator<S>() {
            @Override
            public int compare(S o1, S o2) {
                if (o2.t>o1.t){
                    return -1;
                }
                if (o2.t<o1.t){
                    return 1;
                }
                else {
                    int i=0;
                    return o1.s.compareTo(o2.s);
                }
            }
        });
        int[] nums=new int[numslist.size()];
        for (int i=0;i<nums.length;i++){
            nums[i]=numslist.get(i);
        }
        Arrays.sort(nums);
        int t=k;
        int start=nums.length-1;
        while (t>0){
            //nums[start]
        }





        for (int i=0;i<numslist.size();i++){
            S cur=new S(list.get(i),numslist.get(i));
            S cur1=new S(list.get(i),numslist.get(i));
            queue.add(cur);
            queue1.add(cur1);

        }
        for (int i=0;i<k;i++){
            S cur=queue.poll();
            System.out.print(cur.s+" ");
            System.out.println(cur.t);
        }
        for (int i=0;i<k;i++){
            S cur=queue1.poll();
            System.out.print(cur.s+" ");
            System.out.println(cur.t);
        }


    }
}
class S {
    public S(String s, int t) {
        this.s = s;
        this.t = t;
    }
    String s;
    int t;

}