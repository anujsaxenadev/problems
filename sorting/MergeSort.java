package sorting;

public class MergeSort {
    static int[] merge(int[] list1, int[] list2){
        int i = 0, j = 0, length1 = list1.length, length2 = list2.length;
        int[] listResult = new int[length1 + length2];
        int baseIndex = 0;
        while(i < list1.length && j < list2.length){
            if(list1[i] < list2[j]){
                listResult[baseIndex] = list1[i];
                i++;
            }
            else{
                listResult[baseIndex] = list2[j];
                j++;
            }
            baseIndex++;
        }
        while(i < list1.length){
            listResult[baseIndex] = list1[i];
            i++;
            baseIndex++;
        }
        while(j < list2.length){
            listResult[baseIndex] = list2[j];
            j++;
            baseIndex++;
        }
        return listResult;
    }

    static int[] sort(int[] list){
        int length = list.length;
        if(length == 0 || length == 1){
            return list;
        }
        return merge(
            sort(getListSubset(list, 0, (length / 2) - 1)),
            sort(getListSubset(list, length / 2, length - 1))
        );
    }

    static int[] getListSubset(int[] list, int i, int j){
        int[] resultList = new int[j - i + 1];
        for(int index = i, baseIndex = 0; index <= j; index++, baseIndex++){
            resultList[baseIndex] = list[index];
        }
        return resultList;
    }

    static void printList(int[] list){
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args) {
        int[] list = new int[] {4,2,5,1,3};
        printList(sort(list));
    }
}
