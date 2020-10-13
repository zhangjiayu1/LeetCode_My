package LCJava;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/10/13
 * Time: 16:40
 * Description:1185. 一周中的第几天 easy
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 *
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 * 示例 1：
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 *
 * 示例 2：
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 *
 * 示例 3：
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *  
 * 提示：
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 *
 * 思路：首先要知道开始日子是星期几，看日历知道1971年一月一日是周五，接下来只需要计算出从1971年1月1日到给出的日子的天数对7取余，就可以算出来了
 */
public class LC1185DayOfTheWeek {

    public static String dayOfTheWeek(int day, int month, int year) {
        String[] DAYS = new String[]{"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int[] MONTHS = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = day;
        if(year > 1971){
            for (int i = 1971;i < year;i++){
                days += 365;
                if(isLeap(i)){
                    days++;
                }
            }
        }
        for (int i = 0;i < month - 1;i++){
            days += MONTHS[i];
        }
        if(isLeap(year) && month > 2){
            days++;
        }
        return DAYS[(days - 1) % 7];
    }

    public static Boolean isLeap(int year){
        boolean leap_1 = (year % 4 == 0 && year % 100 != 0);
        boolean leap_2 = (year % 400 == 0);
        return leap_1 || leap_2;
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31,8,2019));
    }
}
