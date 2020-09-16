package bishi.src.main.java.笔试.bin.Dianxin;

import java.util.*;

/**
 * Created by 林松斌的船 on 2020/9/9.
 */
public class DianXin02 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        StringBuffer stringBuffer=new StringBuffer();
        int[] nums=new int[26];
        for (int i=0;i<str.length();i++){
            nums[str.charAt(i)-'a']++;
        }
        HashMap<Integer,List<Integer>> hashMap=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            List<Integer> list=hashMap.getOrDefault(nums[i],new LinkedList<>());
            list.add(i);
            hashMap.put(nums[i],list);
        }
        Arrays.sort(nums);
        int min=0;
        for (int i=0;i<25;i++){
            if (nums[i]>0){
                min=nums[i];
                break;
            }
        }
        List<Integer> list=hashMap.get(min);
        for (int i=0;i<list.size();i++){
            char cur=(char) ('a'+list.get(i));
            //System.out.println(cur);
            str=str.replace(cur+"","");
            //System.out.println(str);
        }
       // str.replace("d","");
        System.out.println(str);


    }
}
