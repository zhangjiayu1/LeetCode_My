package OfferJava;

import java.util.Scanner;

/**
 *  Created with IntelliJ IDEA.
 *  User: Administrator
 *  Date: 2020/3/23 0023
 *  Time: 16:20
 *  Description: 17. 打印从1到最大的n位数 easy
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * 思路：就正常找到边界值，数组输出即可 如果不是int的话需要考虑一下大数的问题
 */
public class OF17PrintNumbers {

    public static int[] printNumbers(int n) {
        int max = (int)Math.pow(10,n);
        int[] array = new int[max - 1];
        for (int i = 1;i <= max - 1;i++){
            array[i - 1] = i;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println("输入n:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = printNumbers(n);
        for (int o : a){
            System.out.println(o);
        }

    }
}
