package Arrays;
import java.util.ArrayList;

public class JosephusProblem {

    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> itemList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            itemList.add(i + 1);
        }
        findTheWinner(itemList, k, 0);
        return itemList.get(0);
    }

    public static void findTheWinner(ArrayList<Integer> itemList, int k, int index) {
        int size = itemList.size();
        if(size <= 1){
            return;
        }
        else {
            int nextIndex = (index + k - 1) % size;
            itemList.remove(nextIndex);
            findTheWinner(itemList, k, nextIndex %  (size - 1));
        }
    }

    public static void main(String[] args){
        System.out.println(findTheWinner(5, 2));
    }
}
