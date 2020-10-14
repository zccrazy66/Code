package main.java.笔试.joey.tuhu;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * @author JoeyChen
 * @data 2020/10/8 19:53
 */
public class th01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param y1 int整型 当前日期的年
     * @param m1 int整型 当前日期的月
     * @param d1 int整型 当前日期的日
     * @param y2 int整型 项目截止日期的年
     * @param m2 int整型 项目截止日期的月
     * @param d2 int整型 项目截止日期的日
     * @return int整型
     */
    public int workdays_between (int y1, int m1, int d1, int y2, int m2, int d2) {
        // write code here
        StringBuffer ss1 = new StringBuffer();
        StringBuffer ss2 = new StringBuffer();

        ss1.append(y1);
        ss1.append('-');
        ss1.append(m1);
        ss1.append('-');
        ss1.append(d1);

        ss2.append(y2);
        ss2.append('-');
        ss2.append(m2);
        ss2.append('-');
        ss2.append(d2);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cl1 = Calendar.getInstance();
        Calendar cl2 = Calendar.getInstance();

        try {
            cl1.setTime(df.parse(ss1.toString()));
            cl2.setTime(df.parse(ss2.toString()));

        } catch (ParseException e) {
            System.out.println("日期格式非法");
            e.printStackTrace();
        }

        int count = 0;
        while (cl1.compareTo(cl2) <= 0) {
            if (cl1.get(Calendar.DAY_OF_WEEK) != 7 && cl1.get(Calendar.DAY_OF_WEEK) != 1)
                count++;
            cl1.add(Calendar.DAY_OF_MONTH, 1);
        }
        return count-1;
    }
}