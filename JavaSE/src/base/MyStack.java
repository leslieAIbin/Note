package base;
import java.util.*;


class MyStack {

    /** Initialize your data structure here. */
    // 队列是先进先出
    // 栈是先进后出

    private Queue<Integer> queueMain;// push
    private Queue<Integer> queueHelp;// pop
    public MyStack() {
        this.queueMain = new LinkedList<Integer>();
        this.queueHelp = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        this.queueMain.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 如果主的只有一个元素那就直接pop
        int res = 0;
        int size = this.queueMain.size();
        if(size == 1) return this.queueMain.poll();
        else {
            // 先把 前size- 1个元素压入辅助队列
            while(size != 1){
                this.queueHelp.offer(this.queueMain.poll());
                size--;
            }

            // 弹出 元素
            res = this.queueMain.poll();

            // 调换队列 这样就不用再装回去啦
            Queue<Integer> temp = this.queueMain;
            this.queueMain = this.queueHelp;
            this.queueHelp = temp;
        }

        return res;
    }
    
    /** Get the top element. */
    public int top() {
        int size  = this.queueMain.size();
        if(size == 1) return this.queueMain.element();
        // 转移n-1
        while(size != 1){
            this.queueHelp.offer(this.queueMain.poll());
            size--;
        }
        // 然后取出第n个元素
        int res = this.queueHelp.element();
        // 转移到辅助队列
        this.queueHelp.offer(this.queueMain.poll());
        // 再调换
        Queue<Integer> temp = this.queueMain;
        this.queueMain = this.queueHelp;
        this.queueHelp = temp;

        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queueMain.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        Stack<Integer> stack = new Stack<>();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */