package OfferJava;

import java.security.PrivateKey;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/08/20
 * Time: 18:13
 * Description:
 */
public class test1 {

    private static final Pattern PATTERN = Pattern.compile("^([0-9]+)|([A-Za-z]+)$");

    /**
     * 产生字母和数字的随机组合,长度为length
     * @param length 需要的长度
     * @return 一个字母和数字随机组合的String型数据
     */
    public static String getRandomNumAndChacters(int length){
        Random random = new Random();
        //随机到65：大写字母  97：小写字母 如果需要加小写字母可以去掉注释
        //int choice = random.nextBoolean() ? 65 : 97;
        int choice = 65;
        String str = null;
        do {
            str = new String();
            for (int i = 0; i < length; i++) {
                boolean b = random.nextBoolean();
                if(b){
                    str += (char)(choice + random.nextInt(26));
                }else{
                    str += String.valueOf(random.nextInt(10));
                }
            }
        //验证是否为字母和数字的组合
        } while (validate(str));
        return str;
    }

    /**
     * 验证产生的随机字母数字组合是否是纯数字或者存字母
     * @param str
     * @return   true:纯字母或者纯数字组成；false：不是纯字母或者纯数字组成
     */
    public static boolean validate(String str){
        Matcher matcher = PATTERN.matcher(str);
        return matcher.matches();
    }



    public static String getOrderNumber() {
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        System.out.println("hashCodeV：" + hashCodeV);
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正整型
        //edit---20181203 hzj
        Date date=new Date();
        return  String.format("%010d", hashCodeV)+date.getTime();
    }

    public static void main(String[] args) {
        System.out.println(getRandomNumAndChacters(14));
    }
}
