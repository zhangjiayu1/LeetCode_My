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
 *
 * 然后就是用魔法打败魔法的时候了，在评论区跟答案的地方看到了两个神奇的公式，蔡勒公式跟基姆拉尔森公式，都是专门用来计算某年的某一天是星期几的公式
 *
 * 蔡勒公式：1582年10月4日之后：w=(y1+(y1/4)+(c/4)-2*c+(26*(m+1)/10)+d-1)mod7 (从周日开始)
 *
 *        1582年10月4日以及之前：w=(y1+y/4+c/4-2*c+13*(m+1)/5+d+2)mod7;
 *
 *        w为星期几，0为周日，y为年份的后两位，c为世纪数减一其实也就是年份的前两位，m为月份（3<=m<=14）注意这里的月份是从三月份到十四月份，所以把每年的一月二月当作上一年的十三月十四月来处理，
 *        d为天数，公视具体怎么推导出来的可百度
 *
 * 基姆拉尔森公式：W=(d+2*m+3*(m+1)/5+y+y/4-y/100+y/400)mod7 (从周一开始)
 *
 *              w为星期几，0为周日，y为年份，m为月份（3<=m<=14）注意这里的月份是从三月份到十四月份，所以把每年的一月二月当作上一年的十三月十四月来处理，
 *              d为天数，公视具体怎么推导出来的可百度
 */
public class LC1185DayOfTheWeek {

    public static String[] DAYS = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

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

    /**
     * 蔡勒 w=(y1+(y1/4)+(c/4)-2*c+(26*(m+1)/10)+d-1)mod7
     * @param day 天
     * @param month 月
     * @param year 年
     * @return 星期
     */
    public static String zeller(int day, int month, int year){
        int y = year,m = month;
        if(month == 1 || month == 2){
            y--;
            m += 12;
        }
        int c = y / 100,ny = y % 100;
        int dayOfWeek =(c / 4 - 2 * c + ny + ny / 4 + 26 * (m + 1) / 10 + day - 1) % 7;
        while (dayOfWeek < 0){
            dayOfWeek += 7;
        }
        return DAYS[dayOfWeek];
    }

    /**
     * 基姆拉尔森 W=(d+2*m+3*(m+1)/5+y+y/4-y/100+y/400)mod7；
     * @param day 天
     * @param month 月
     * @param year 年
     * @return 星期
     */
    public static String kimLarsen(int day, int month, int year){
        if(month == 1 || month == 2){
            year--;
            month += 12;
        }
        int iWeek = (day+2*month+3*(month+1)/5+year+year/4-year/100+year/400)%7;
        while (iWeek < 0){
            iWeek += 7;
        }
        return DAYS[iWeek + 1];
    }

    public static Boolean isLeap(int year){
        boolean leap_1 = (year % 4 == 0 && year % 100 != 0);
        boolean leap_2 = (year % 400 == 0);
        return leap_1 || leap_2;
    }

    public static void main(String[] args) {
        System.out.println(kimLarsen(31,8,2019));
    }
}
