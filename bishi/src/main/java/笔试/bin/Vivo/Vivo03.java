package bishi.src.main.java.笔试.bin.Vivo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 林松斌的船 on 2020/9/12.
 */
public class Vivo03 {
    public static void main(String[] args){
            Vivo03 vivo03=new Vivo03();
            String s="3,-1,2,-1";
            System.out.println(vivo03.compileSeq(s));

    }
    HashMap<Integer,Integer> hashMap=new HashMap<>();
    List<Integer> list=new LinkedList<>();
    int[] checked;
    public String compileSeq (String input) {
        if (input.length()==0)return new String();
        // write code here
        String[] strings=input.split(",");
        checked=new int[strings.length];
        for (int i=0;i<strings.length;i++){
            if (strings[i].charAt(0)!='-'){
                hashMap.put(i,Integer.valueOf(strings[i]));
            }
        }
        for (int i=0;i<strings.length;i++){
            if (checked[i]==0){
                dfs(i);
            }
        }
        StringBuffer s=new StringBuffer();
        //System.out.println(Arrays.toString(list.toArray()));
        for (int i=0;i<list.size();i++){
            s.append(list.get(i));
            s.append(",");
        }
        s.deleteCharAt(s.length()-1);
        //System.out.println();
        return s.toString();


    }
    public void dfs(Integer cur){
        checked[cur]=1;
        if (!hashMap.containsKey(cur))
        {
            list.add(cur);
            return;
        }
        int need=hashMap.get(cur);
        if (checked[need]==0){
            dfs(need);
        }
        list.add(cur);
    }

}
