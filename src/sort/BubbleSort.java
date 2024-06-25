package sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {

    public void sort(ArrayList<Integer> dataList) {
        boolean swap = false;
        for (int i = 0; i < dataList.size(); i++) {
            for (int j = 0; j < dataList.size() - i -1 ; j++) {
                if (dataList.get(j) > dataList.get(j + 1)) {
                    Collections.swap(dataList, j, j+1);
                    swap = true;
                }
            }

            if(swap == false) break;
        }
    }
}
