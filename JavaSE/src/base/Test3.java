package base;

import java.util.*;

import sun.net.httpserver.HttpServerImpl;

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
    // private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        if(root.left != null && root.left.left == null && root.left.right ==null){
            sum += root.left.val;
        }
        // 分治法
        if(root.left != null) sum += sumOfLeftLeaves(root.left);
        if(root.right != null) sum += sumOfLeftLeaves(root.right);

        return sum; 
    }


    public String toHex(int num){
        if(num == 0) return "0";
        String res = "";
        int len = 0;
        while(num != 0 && len < 8){
            int bit = num & 15;
            if(bit < 10){
                res = String.valueOf(bit) + res;
            } else {
                res = String.valueOf((char)('a'+bit-10)) + res;
            }
            num >>= 4;
            len++;
        }
        return res;

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

    // 最长 最大奇数 加上 所有偶数
    public int longestPalindrome(String s) {
        char[] carr = s.toCharArray();
        int[] map = new int[256];
        int maxOdd = 0;// 最大奇数
        for(int i = 0;i<carr.length;++i){
            map[carr[i]]++;
        }

        int sum =  0;// 先加上偶数

        for(int i = 0;i<map.length;++i){
            if(map[i] % 2 == 1) maxOdd = Math.max(maxOdd, map[i]);
            else sum += map[i];
        }

        return sum + maxOdd;
        
    }

    // public int numberOfBoomerangs(int[][] points) {

    // }

    public int helper(int num){
        int result = 0;
        // 取出每一个最后的数
        while(num != 0){
            result = result << 1 + (~(num & 1));
            num >>= 1;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new Test3().helper(5));
        System.out.println(~1);
    }
    
}