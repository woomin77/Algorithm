package backtracking;

import java.util.ArrayList;

public class NQueen1 {

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int N = scan.nextInt();

        NQueen1 nqueen = new NQueen1();
        nqueen.dfsFunc(N, 0, new ArrayList<>());

    }

    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {

        if (currentRow == N) {
            System.out.println(currentCandidate);
            return;
        }

        for (int col = 0; col < N; col++) {

            if (isPossible(currentCandidate, col) == true) {
                currentCandidate.add(col);
                dfsFunc(N, currentRow + 1, currentCandidate);
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }

    }

    public boolean isPossible(ArrayList<Integer> candidate, Integer currentCol) {
        int row = candidate.size();
        for (int i = 0; i < row; i++) {
            if(candidate.get(i) == currentCol || Math.abs(candidate.get(i)-currentCol) == (row-i)) {
                return false;
            }
        }
        return true;
    }

      /*
         0,0  0,1  0,2  0,3
         1,0  1,1  1,2  1,3
         2,0  2,1  2,2  2,3
         3,0  3,1  3,2  3,3
        */
}
