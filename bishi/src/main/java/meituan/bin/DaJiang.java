package Code.bishi.src.main.java.meituan.bin;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/16.
 */
public class DaJiang {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        int k=s.nextInt();
        DaJiang daJiang=new DaJiang();
        String str2=daJiang.help(str,k);
      //  System.out.println(str2);
        while (str2.charAt(0)=='0'&&str2.length()>1){
           // System.out.println("2");
            str2=str2.substring(1,str2.length());

        }
        System.out.println(str2);
    }
   public String help(String str,int k){
            if (k==0){
               // System.out.println(str);
                return str;
            }
           if (k==str.length()){
               return "";
           }
            int min=str.charAt(0)-'0';
            int index=0;
            for(int i=1;i<=k;i++){
                if (min>str.charAt(i)-'0'){
                    min=str.charAt(i)-'0';
                    index=i;
                }
            }
            StringBuffer stringBuffer=new StringBuffer();
                stringBuffer.append(min);
                // System.out.println(str.substring(index+1));
           return stringBuffer.append(help(str.substring(index+1),k-index)).toString();
   }

}
