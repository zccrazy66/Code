package main.java.笔试.joey.xingye;

/**
 * @author JoeyChen
 * @data 2020/10/12 10:59
 */
public class xingye01 {
    public String changeFormatNumber(String number) {
        String Binary = Integer.toBinaryString(number).substring(0,16);
        String Hex = Integer.toHexString(number).toUpperCase().substring(0,4);

        StringBuffer res_1 = new StringBuffer();
        StringBuffer res_2 = new StringBuffer();
        for (int i = 0; i < 16-Binary.length(); i++) {
            res_1.append(0);
        }
        for (int i = 0; i < Binary.length(); i++) {
            res_1.append(Binary.charAt(i));
        }
        res_1.append(',');
        for (int i = 0; i < 4 - Hex.length(); i++) {
            res_2.append(0);
        }
        for (int i = 0; i < Hex.length(); i++) {
            res_2.append(Hex.charAt(i));
        }
        String res = res_1.toString().concat(res_2.toString());
        return res;
    }
}
