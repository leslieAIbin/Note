package base;
import java.util.*;
public class Test2 {
    public static void main(String[] args) {
        String str = " dog cat  cat dog " ;
        List<String> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        // 先确定start str[start] != ' '
        while(start < str.length()){
            while(start < str.length() && str.charAt(start) == ' ') start++;
            // start是第一个非空字符
            end = start;
            while(end < str.length() && str.charAt(end) != ' ') end++;
            if(end <= str.length()) list.add(str.substring(start, end));
            System.out.println(start+"\t"+end);
            start = end;

        }



        for(String string : list){
            System.out.println(string);
        }


        System.out.println("012345".substring(0,5));
    }
}