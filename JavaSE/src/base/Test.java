package base;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
public class Test {
    /**
     * 同构字符串
     */
    public boolean isIsomorphic(String ss, String tt) {
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();
        if(s.length != t.length){
            return false;
        }

        for(int i = 0;i<s.length;++i){
            if(ss.indexOf(ss.charAt(i)) != tt.indexOf(tt.charAt(i))){
                return false;
            }
        }

        return true;
    }

    public boolean wordPattern(String pattern, String str) {
        // 单个字母的异构问题
        // 字符串 异构 

        List<String> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        // 先确定start str[start] != ' '
        while(start < str.length() && end < str.length()){
            while(start < str.length() && str.charAt(start) == ' ') start++;
            end = start;
            // 找到第一个空格给
            while(end < str.length() && str.charAt(end) != ' ') end++;
            if(end <= str.length()) list.add(str.substring(start, end));
            start = end + 1;
        }
        System.out.println(list);
        if(list.size() != pattern.length()) return false;
        // 长度相等才可以进行比较
        // pattern - string 
        // string - pattern 
        for(int i = 0 ;i<pattern.length();++i){
            if(
                pattern.indexOf(pattern.charAt(i)) != list.indexOf(list.get(i))
            ){
                return false;
            }
        }

        return true;

    }


    public static void main(String[] args) {

        String pattern = "abba";
        String str = "dog cat  cat fish";
        System.out.println(new Test().wordPattern(pattern, str));

        List<String> list = new ArrayList<>();
        list.add("1234");
        list.add("1234");
        System.out.println(list.indexOf("1234"));

    }
    
}