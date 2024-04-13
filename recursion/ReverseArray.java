package recursion;


public class ReverseArray {
    public static void reverseUsingIteration(int[] list){
        int i = 0, j = list.length - 1;
        while (i < j) {
            int temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            i++;
            j--;
        }
    }

    public static void reverseUsingRecursion(int[] list, int index){
        if(index < 0 || list.length == 0 || index >= list.length){
            return;
        }
        int temp = list[index];
        reverseUsingRecursion(list, index + 1);
        list[list.length - index - 1] = temp;
    }


    // Take half of auxilary stackMa
    public static void reverseUsingRecursionOptimised(int[] list, int i, int j){
        if(i < 0 || j < 0 ||  i >= list.length || j >= list.length || i >= j){
            return;
        }
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
        reverseUsingRecursionOptimised(list, i + 1, j - 1);
    }

    public static void print(int[] list){
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args){
        int[] list = new int[]{1,2,3,4,5};
        reverseUsingRecursionOptimised(list, 0, list.length - 1);
        print(list);
    }
}
