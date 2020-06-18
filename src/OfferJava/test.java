package OfferJava;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/06/18
 * Time: 13:39
 * Description:
 */
public class test {

    public void test_1(String[] str){
        Stack<Integer> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (String s : str){
            if("]" != s){
                if(IsNumber(s)){
                    stack1.push(Integer.valueOf(s));
                }
            }else {
                if(stack1.size() != 0){
                    list.add(stack1.pop());
                }
            }
        }

    }

    public List<Integer> plus(List<Integer> leftList,List<Integer> rightList){
        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(leftList);
        resultList.addAll(rightList);
        resultList = new ArrayList<>(new LinkedHashSet<>(resultList));
        return resultList;
    }

    public List<Integer> Mlut(List<Integer> leftList,List<Integer> rightList){
        List<Integer> resultList = new ArrayList<>();
        for (Integer a : leftList){
            for (Integer b : rightList){
                resultList.add(a * 10 + b);
            }
        }
        resultList = new ArrayList<>(new LinkedHashSet<>(resultList));
        return resultList;
    }

    //正则表达式判断数字
    public  Boolean IsNumber(String str){
        if(str == null){
            return false;
        }
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        return pattern.matcher(str).matches();
    }

}
