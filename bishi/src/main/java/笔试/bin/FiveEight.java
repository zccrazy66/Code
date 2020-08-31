package Code.bishi.src.main.java.笔试.bin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**[["a", "adb", "gae", "ddd", "you", "better", "aaaaa" ],
 * ["a1", "adb", "g2ae", "dd1d", "you", "better", "aaabaa"],
 * ["2a1", "adb2", "g2ae", "ddd", "you", "better", "aaabaa"]]
 * Created by 林松斌的船 on 2020/8/31.
 */
public class FiveEight {

    public static ArrayList<String> findCommonString (ArrayList<ArrayList<String>> values) {
        if(values.size()==0)return null;
        ArrayList<String> res=new ArrayList<>();
        // write code here
        HashMap<String,Integer> hashMap=new HashMap<>();
        int num=values.size();
        for (int i=0;i<num;i++){
            List<String> curlist=values.get(i);
            if (curlist.size()==0)return null;
            for (int j=0;j<curlist.size();j++){
                System.out.println(curlist.get(j));
                int cur=hashMap.getOrDefault(curlist.get(j),0);
                cur++;
               // System.out.println(cur);
                if(cur==num){
                    System.out.println(curlist.get(j));
                    res.add(curlist.get(j));
                }
                hashMap.put(curlist.get(j),cur);
            }
        }
        System.out.println(res.size());
        return res;
    }
}
