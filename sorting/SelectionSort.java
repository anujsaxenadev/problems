package sorting;

public class SelectionSort {

    // Inplace Sort
    static void sort(int[] list){
        for(int i = 0; i < list.length; i++){
            int minIndex = i;
            for(int j = i; j < list.length; j++){
                if(list[minIndex] > list[j]){
                    minIndex = j;
                }
            }
            swapValues(list, minIndex, i);
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
