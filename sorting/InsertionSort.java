package sorting;

public class InsertionSort {
    
     // Inplace Sort
     static void sort(int[] list){
        int length = list.length;
        for(int i = 1; i < length; i++){
            for(int j = i; j > 0; j--){
                if(list[j] < list[j - 1]){
                    swapValues(list, j, j - 1);
                }
            }
        }
    }

    static void swapValues(int[] list, int i, int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    static void printList(int[] list){
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
    }
    
    public static void main(String[] args) {
        int[] list = new int[] {4,2,5,1,3};
        sort(list);
        printList(list);
    }
}
