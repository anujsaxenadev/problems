package recursion;

import java.util.Stack;

public class ReverseStack {

    void reverse(Stack<Integer> givenStack){
        if(givenStack.isEmpty()){
            return;
        }
        int number = givenStack.pop();
        reverse(givenStack);
        givenStack.push(number);
    }

    public static void main(String[] args){
        Stack<Integer> givenStack = new Stack<Integer>();
        givenStack.push(1);
        givenStack.push(2);
        givenStack.push(3);
        givenStack.push(4);
        givenStack.push(5);

        while(!givenStack.isEmpty()){
            System.out.println(givenStack.pop());
        }
    }
}
