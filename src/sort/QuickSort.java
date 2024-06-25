package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {


    public ArrayList<Integer> sort(ArrayList<Integer> list) {

        if (list.size() <= 1) {
            return list;
        }

        int pivot = list.get(0);
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < pivot) {
                leftArr.add(list.get(i));
            } else {
                rightArr.add(list.get(i));
            }
        }


        ArrayList<Integer> mergedList = new ArrayList<>();


        mergedList.addAll(sort(leftArr));
        mergedList.addAll(Arrays.asList(pivot));
        mergedList.addAll(sort(rightArr));


        return mergedList;

    }
}
