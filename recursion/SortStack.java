package recursion;

import java.util.Stack;

public class SortStack {
    public static void sortStack(Stack<Integer> stack){
        if(stack.isEmpty() || stack.size() == 1){
            return;
        }
        Integer num = stack.pop();
        sortStack(stack);
        insertInSortedStack(stack, num);
    }

    public static void insertInSortedStack(Stack<Integer> sortedStack, Integer num){
        if(sortedStack.isEmpty()){
            sortedStack.push(num);
            return;
        }
        if(sortedStack.peek() > num){
            Integer top = sortedStack.pop();
            insertInSortedStack(sortedStack, num);
            sortedStack.push(top);
        }
        else {
            sortedStack.push(num);
        }
    }

    public static void main(String[] args){
        Stack<Integer> givenStack = new Stack<>();
        givenStack.push(4);
        givenStack.push(7);
        givenStack.push(3);
        givenStack.push(2);
        givenStack.push(0);
        sortStack(givenStack);

        while(!givenStack.isEmpty()){
            System.out.println(givenStack.pop());
        }
    }
}
