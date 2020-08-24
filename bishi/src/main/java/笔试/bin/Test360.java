package Code.bishi.src.main.java.笔试.bin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/22.
 */
public class Test360 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str=s.nextLine();
        List<String> list=new ArrayList<>();
        int last=0;
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)=='n'){
              //  System.out.println(i);
                String t=str.substring(last,i);
                list.add(t);
                last=i;
            }
        }
        String t=str.substring(last,str.length());
        list.add(t);
        for (int i=0;i<list.size();i++){
            String cur=list.get(i);
            char x=(char)((int)cur.charAt(0)-32);
            System.out.print(x);
            System.out.println(cur.substring(1,cur.length()));
        }

    }
}
