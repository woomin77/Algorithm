package baekjoon;

import java.util.ArrayList;

/**
 * NQueen
 */
public class BOJ9663 {

    static int N, result;
    ArrayList<Integer> candidate = new ArrayList<>();

    public void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
    }

    public void solution(int row) {
        if (row == N) {     //마지막 행까지 통과(퀸을 놓는 방법의 수 +1)
            result++;
        }
        else {
            for (int c = 0; c < N; c++) {
                if (isAvailable(c)) {
                    candidate.add(c);
                    solution(row + 1);
                    candidate.remove(candidate.size() - 1);
                }
            }
        }
    }

    //퀸을 놓을 수 있으면 true, 못 놓으면 False
    private boolean isAvailable(int col) {
        int currentRow = candidate.size();
        for (int index = 0; index < currentRow; index++) {
            if(candidate.get(index) == col || Math.abs(candidate.get(index)-col) == currentRow - index)
                return false;
        }
        return true;
    }



    public static void main(String[] args) {
        BOJ9663 p = new BOJ9663();
        p.input();
        p.solution(0);
        System.out.println(result);
    }

}
