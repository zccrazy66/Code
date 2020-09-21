package 笔试.jungel.sanliuling;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test360 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str=s.nextLine();
        LinkedList<String> list=new LinkedList<>();
        int last=0;
        for (int i=1;i<str.length();i++){
            if(str.charAt(i)=='n'){
                String t=str.substring(last,i);
                list.addLast(t);
                last=i;
            }
        }
        String t=str.substring(last);
        list.addLast(t);
//        for (int i=0;i<list.size();i++){
//            String cur=list.get(i);
//            char x=(char)((int)cur.charAt(0)-32);
//            System.out.print(x);
//            System.out.println(cur.substring(1));
//        }

        while (list.size()!=0) {
            String cur=list.removeFirst();
            char x=(char)((int)cur.charAt(0)-32);
            System.out.print(x);
            System.out.println(cur.substring(1));
        }

    }
}
