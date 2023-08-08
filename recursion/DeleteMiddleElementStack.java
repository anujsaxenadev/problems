package recursion;

import java.util.Stack;

public class DeleteMiddleElementStack {
    private static void deleteMiddle(Stack<Integer> givenStack, int counter){
        if(counter >= (givenStack.size() / 2)){
            givenStack.pop();
            return;
        }
        int element = givenStack.pop();
        counter++;
        deleteMiddle(givenStack, counter);
        givenStack.push(element);
    }
    public static void main(String[] args){
        Stack<Integer> givenStack = new Stack<>();
        givenStack.push(1);
        givenStack.push(2);
        givenStack.push(3);
        givenStack.push(4);
        givenStack.push(5);
        deleteMiddle(givenStack, 0);
        while(!givenStack.isEmpty()){
            System.out.println(givenStack.pop());
        }
    }
}
