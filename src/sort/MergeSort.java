package sort;

import java.util.ArrayList;

public class MergeSort {
    ArrayList<Integer> dataList = new ArrayList<>();

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        Integer leftPoint = 0;
        Integer rightPoint = 0;

        // case1 - left/right 둘다 있을때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint += 1;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
        }

        // case2 - right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint += 1;
        }

        // case3 - left 데이터가 없을 때
        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }

        System.out.println("mergedList = " + mergedList);

        return mergedList;
    }



//    public void mergeFunc(ArrayList<Integer> dataList) {
//        ArrayList<Integer> mergedList = new ArrayList<Integer>();
//
//        Integer mid = dataList.size() / 2;   //dataList.size = 3 , mid = 1,
//        Integer lp = 0;
//        Integer rp = mid;
//
//
//        while (lp < mid && rp < dataList.size()) {
//            if (dataList.get(lp) < dataList.get(rp)) {
//                mergedList.add(dataList.get(lp));
//                lp++;
//            } else {
//                mergedList.add(dataList.get(rp));
//                rp++;
//            }
//        }
//
//        while (lp < mid) {
//            mergedList.add(dataList.get(lp));
//            lp++;
//        }
//        while (rp < dataList.size()) {
//            mergedList.add(dataList.get(rp));
//            rp++;
//        }
//
//        System.out.println("mergedList = " + mergedList);
//
//        for (int i = 0; i < mergedList.size(); i++) {
//            dataList.set(i, mergedList.get(i));
//        }
//
//    }

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
//            System.out.println("dataList = " + dataList);
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr;
        ArrayList<Integer> rightArr;

        leftArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
        System.out.println("left = " + dataList);

        rightArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));
        System.out.println("right = " + dataList);


        System.out.println("dataList = " + dataList);

        return mergeFunc(leftArr, rightArr);
    }

    /*

    left = [5, 4, 3]
left = [4, 3]
right = [4, 3]
dataList = [4, 3]
mergedList = [3, 4]
right = [5, 4, 3]
dataList = [5, 4, 3]
mergedList = [4, 3, 5]
     */


}
