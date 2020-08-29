package Code.bishi.src.main.java.笔试.bin;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**6 3
 0 0 1 1 0 0
 * Created by 林松斌的船 on 2020/8/29.
 */
public class SF01 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        List<Integer> list=new LinkedList<>();
        for (int i=0;i<n;i++){
            list.add(s.nextInt());
        }
        int res=0;
        int reslen=Integer.MIN_VALUE;
        while (list.size()>0){

            int max = 0;
            int sum = 0;
            int l = 0, r = list.size() - k;
            int resl = l, resr = r;
            //System.out.println("k="+k+"size="+list.size());
            for (int m = 0; m <= r; m++) {
                sum += list.get(m);
            }
            max = sum;
            while (r <= list.size() - 2) {
                // System.out.println("123");
                r++;
                sum += list.get(r);
                sum -= list.get(l);
                l++;
                if (max < sum) {
                    max = sum;
                    resl = l;
                    resr = r;
                }
            }
            // System.out.println("resl="+resl+"resr="+resr);
            // System.out.println(max);
            if (max==0){
                double len=Math.ceil(list.size()/k);
                reslen=Math.max(reslen,(int) len);
                break;
            }
            res += max * max;
            //  System.out.println(resl);

            while (list.get(resl) == 0&&resl<resr) {
                resl++;
            }
            while (list.get(resr) == 0&&resl<resr) {
                resr--;
            }
            int len = resr - resl + 1;
            for (int i=0;i<len;i++){
                list.remove(resl);
            }
            // System.out.println("resl="+resl+"resr="+resr);
            reslen=Math.max(reslen,len);
            // System.out.println(len);
            k--;
        }
        System.out.print(res+" ");
        System.out.print(reslen);

    }
}
