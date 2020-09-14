package 企鹅精选练习50题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author chengzhen
 * @date 2020/9/14
 * @time 10:56 AM
 */
public class Q155最小栈 {
    Stack<Integer> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();

    /** initialize your data structure here. */
    public Q155最小栈() {

    }

    public void push(int x) {
        stack.push(x);
        list.add(x);
    }

    public void pop() {
        list.remove(Integer.valueOf(stack.pop()));
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        Collections.sort(list);
        return list.get(0);
    }

    public static void main(String[] args) {
        Q155最小栈 minStack = new Q155最小栈();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */