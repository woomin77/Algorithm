package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgo {


    public void knapsackFunc(int[][] objectList, double capacity) {

        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<int[]>() {

            @Override
            public int compare(int[] objectItem1, int[] objectItem2) {
                return (objectItem2[1]/objectItem2[0])   - (objectItem1[1]/objectItem1[0]);
            }

        });

        for (int i = 0; i < objectList.length; i++) {

            //물건이 통채로 담김
            if(capacity - (double)objectList[i][0] > 0) {
                capacity -= (double) objectList[i][0];
                totalValue += (double)objectList[i][1];
            }
            //물건을 쪼개서 담아야 함
            else {
                fraction = capacity / (double)objectList[i][0];
                totalValue += fraction * (double)objectList[i][1];
                break;
            }
        }

        System.out.println("fraction = " + fraction);
        System.out.println("totalValue = " + totalValue);






    }
}
