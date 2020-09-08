package bishi.src.main.java.笔试.bin.Mi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**you
 i love you,oyu love me
 jack
 * Created by 林松斌的船 on 2020/9/8.
 */
public class XieChen01 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String tar=s.nextLine();
        String str=s.nextLine();
        StringBuffer str2=new StringBuffer(str);
        for (int i=0;i<str2.length();i++){
           // System.out.println(str2.charAt(i));
            if (str2.charAt(i)==','||str2.charAt(i)=='.'){
                //System.out.println("xuyaoshanchu");
                str2.insert(i+1," ");
                str2.insert(i," ");
               // System.out.println(str2+"qw");
                i+=2;
            }
        }
        //str.replace(","," ");
       // System.out.println(str2);
        String[] strings=str2.toString().split(" ");
        //System.out.println(Arrays.toString(strings));
        String g=s.nextLine();
        for (int i=0;i<strings.length;i++){
            //System.out.println(strings[i]+tar+"bijiao");
            if (needchange(strings[i],tar)){
                //System.out.println(strings[i]+tar+"bijiao");
                strings[i]=g;
            }
        }
        StringBuffer res=new StringBuffer();
        for (int i=0;i<strings.length;i++){
            if (strings[i].equals(",")||strings[i].equals(".")){
               // System.out.println("qwe");
                res.deleteCharAt(res.length()-1);
                res.append(strings[i]);
            }
           else res.append(strings[i]+" ");
        }
        res.deleteCharAt(res.length()-1);
        System.out.println(res.toString());


    }
    public static boolean needchange(String x,String tar){
            int[] ints=new int[26];
            if (x.length()!=tar.length())return false;
            char[] chars=x.toCharArray();
            List<Character> list=new LinkedList<>();
            for (int i=0;i<chars.length;i++){
                list.add(chars[i]);
            }
            for (int i=0;i<tar.length();i++){
                if (list.contains((Character) tar.charAt(i))){
                    list.remove((Character)tar.charAt(i));
                }
                else return false;
            }
            return true;

    }
}
