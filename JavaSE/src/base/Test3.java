package base;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }
}
public class Test3 {
    public int a = 1;
    public Test3() {
        this.a = 100;
    }

    /**
     * 左叶子 之和
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        // 如何判断一个叶子节点
    }

    /**
     * 统计一个数中二进制的个数
     * @param num
     * @return
     */
    private int CountOnes(int n){
        int count = 0;
        while(n != 0) {
            count = count + (n&1);
            n = n>>1;
        }

        return count;
    }

    public List<String> readBinaryWatch(int num) {
        // 亮的数量表示了有多少个1
        List<String> result = new ArrayList<>();
        String str = "";
        for(int i = 0;i<=11;++i){
            for(int j = 0;j<=59;++j){
                if(CountOnes(i) + CountOnes(j) == num){
                    if(j<10){
                        str = String.valueOf(i) +":0"+String.valueOf(j);
                        result.add(str);
                    } else {
                        str = String.valueOf(i) + ":"+String.valueOf(j);
                        result.add(str);
                    }
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {  

    }
    
}