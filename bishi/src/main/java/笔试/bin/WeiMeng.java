package bishi.src.main.java.笔试.bin;

import java.util.HashSet;

/**
 * Created by 林松斌的船 on 2020/10/11.
 */
public class WeiMeng {
    public String findMaxSubstr(String str) {
        if (str.length()==0){
            return "";
        }
        HashSet<Character> set=new HashSet<>();
        int l=0;
        int r=0;
        int len=0;
        int max=Integer.MIN_VALUE;
        int resl=-1;
        int resr=-1;
        while (r<str.length()){
            while (r<str.length()&&(!set.contains(str.charAt(r)))){
                set.add(str.charAt(r));
                r++;
            }
            len=r-l;
            if (max<len){
                max=len;
                resl=l;
                resr=r;
            }
            if (r==str.length()){
               break;
            }
            while (str.charAt(l)!=str.charAt(r)){
                set.remove(str.charAt(l));
                l++;
            }
            set.remove(str.charAt(l));
            l++;
        }
        if (max<len){
            max=len;
            resl=l;
            resr=r;
        }
        return str.substring(resl,resr);

    }
}
