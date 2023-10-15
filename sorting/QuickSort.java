package sorting;

public class QuickSort {
    static void swapValues(int[] list, int i, int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    static int partition(int[] list, int start, int end){
        int pivot = end;
        int partitionIndex = start;
        for(int i = start; i < end; i++){
            if(list[i] <= list[pivot]){
                swapValues(list, partitionIndex, i);
                partitionIndex++;
            }
        }
        
        swapValues(list, pivot, partitionIndex);
        return partitionIndex;
    }

    static void quickSort(int[] list, int start, int end){
        if(start < end){
            int pivotIndex = partition(list, start, end);
            quickSort(list, start, pivotIndex - 1);
            quickSort(list, pivotIndex, end);
        }
    }

    static void sort(int[] list){
        quickSort(list, 0, list.length - 1);
    }

    static void printList(int[] list){
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{4,1,5,1,6,7};
        sort(list);
        printList(list);
    }
}
