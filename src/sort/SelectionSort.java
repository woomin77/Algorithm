package sort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {

    public void selectionSort(ArrayList<Integer> dataList) {

        for (int i = 0; i < dataList.size(); i++) {
            int lowest = i;
            for (int j = i; j < dataList.size(); j++) {
                if (dataList.get(j) < dataList.get(lowest)) {
                    lowest = j;
                }
            }
            Collections.swap(dataList, lowest, i);
        }
    }
}
