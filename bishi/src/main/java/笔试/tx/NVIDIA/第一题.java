package main.java.笔试.tx.NVIDIA;

import java.util.Scanner;

/**
 * @author xin Tan
 * @create 2020-09-07 19:45
 */
public class 第一题 {
    static String[] oper = {"-", "*", "/", "+"};

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] strArr = line.split(" ");
                for (int i = 0; i < strArr.length; i++) {
                    strArr[i] = String.valueOf(convert(strArr[i]));
                }
                //1取出四个字符串的全排列
                String[][] aOrdered = getFullOrder(strArr);
                //全排列中加入三个运算符字符串,输出表达式字符串
                String[][] aWithOper = addOper(aOrdered);
                //计算表达式
                checkAll(aWithOper);
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    /**
     * 对字符串数组进行计算,校验是否等于24
     *
     * @param a
     * @return
     */
    public static String checkAll(String[][] a) {
        String out = "NONE";
        for (int i = 0; i < a.length; i++) {
            float re = calculate(a[i]);
            if (re == 24f) {
                out = join(a[i]);
                break;
            }
        }
        System.out.println(out);
        return out;
    }

    /**
     * 将字符串数组转换成表达式,数字转换成牌面,11->J...
     *
     * @param a
     * @return
     */
    public static String join(String[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if ("11".equals(a[i])) {
                sb.append("J");
            } else if ("12".equals(a[i])) {
                sb.append("Q");
            }else if ("13".equals(a[i])) {
                sb.append("K");
            } else if ("1".equals(a[i])) {
                sb.append("A");
            } else {
                sb.append(a[i]);
            }
        }
        return sb.toString();
    }

    public static float calculate(String[] a) {
        float r1 = oper(a[0], a[1], a[2]);
        float r2 = oper(String.valueOf(r1), a[3], a[4]);
        float r3 = oper(String.valueOf(r2), a[5], a[6]);
        return r3;
    }

    public static float oper(String a, String o, String b) {
        Float a_ = Float.valueOf(a);
        Float b_ = Float.valueOf(b);
        switch (o) {
            case "+":
                return a_ + b_;
            case "-":
                return a_ - b_;
            case "*":
                return a_ * b_;
            case "/":
                return a_ / b_;
        }
        return 0;
    }

    /**
     * 对全排列的数组中加入所有可能的运算符
     *
     * @param arr
     * @return
     */
    public static String[][] addOper(String[][] arr) {
        int operLen = oper.length;
        int numLen = arr[0].length;
        int innerlen = numLen + numLen - 1;
        int outlen = arr.length * 64;
        String[][] re = new String[outlen][innerlen];
        int c = 0;
        for (int i = 0; i < operLen; i++) {
            for (int j = 0; j < operLen; j++) {
                for (int k = 0; k < operLen; k++) {
                    for (int x = 0; x < arr.length; x++) {
                        re[c][0] = arr[x][0];
                        re[c][1] = oper[i];
                        re[c][2] = arr[x][1];
                        re[c][3] = oper[j];
                        re[c][4] = arr[x][2];
                        re[c][5] = oper[k];
                        re[c][6] = arr[x][3];
                        c++;
                    }
                }
            }
        }
        return re;
    }


    /**
     * 数组全排列
     *
     * @param arr
     * @return
     */
    public static String[][] getFullOrder(String[] arr) {
        int len = arr.length;
        int num = getNum(len);
        String[][] re = new String[num][len];
        if (len == 2) {
            re[0] = arr;
            String[] t = new String[len];
            t[0] = arr[1];
            t[1] = arr[0];
            re[1] = t;
            return re;
        } else {
            int r = 0;
            for (int i = 0; i < len; i++) {
                String[] t = new String[len];
                String[] surfixArr = cut(arr, i);
                String[][] surfixArrOrders = getFullOrder(surfixArr);
                for (int j = 0; j < surfixArrOrders.length; j++) {
                    t = append(arr[i], surfixArrOrders[j]);
                    re[r] = t;
                    r++;
                }
            }
        }
        return re;
    }

    public static String[] append(String pre, String[] sur) {
        int len = sur.length + 1;
        String[] re = new String[len];
        re[0] = pre;
        for (int i = 0; i < sur.length; i++) {
            re[i + 1] = sur[i];
        }
        return re;
    }

    /**
     * 对数组剪切,取出一个,剩下的组成新的数组
     *
     * @param arr
     * @param index
     * @return
     */
    public static String[] cut(String[] arr, int index) {
        int len = arr.length;
        String[] re = new String[len - 1];
        for (int i = 0, j = 0; i < len; i++) {
            if (i != index) {
                re[j] = arr[i];
                j++;
            }
        }
        return re;
    }

    public static int getNum(int len) {
        int re = 1;
        for (int i = 1; i <= len; i++) {
            re *= i;
        }
        return re;
    }

    public static String[] getInput() throws Exception {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strArr = line.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(convert(strArr[i]));
        }
        return strArr;
    }

    public static int convert(String s) {
        s = s.toUpperCase();
        switch (s) {
            case "A":
                return 1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            default:
                return Integer.valueOf(s);
        }
    }
}
