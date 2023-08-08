package recursion;

public class SortArray {
    public static void sort(int[] arr,int p2){
        if(p2 <= 0){
            return;
        }
        sort(arr, p2 - 1);
        for(int i = p2; i > 0; i--){
            if(arr[i - 1] > arr[i]){
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[] data = new int[]{4,3,6,1};
        sort(data, data.length - 1);
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
    }
}
