package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11652 {

    int N;
    long[] numList;  //-2의 62승 ~ 2의 62승이므로 int로 담을 수 없다

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numList = new long[N];
        for (int i = 0; i < N; i++) {
            numList[i] = Long.parseLong(br.readLine());
        }
    }

    /**
     *  currentCnt = 현재 숫자가 등장한 횟수
     *  changeCnt = 최빈값이 등장한 횟수
     *  result = 현재 최빈값
     */
    public void solution() {
        Arrays.sort(numList, 0, N);

        int currentCnt = 1, changeCnt = 1;
        long result = numList[0];

        for (int i = 1; i < N; i++) {
            if (numList[i] == numList[i - 1]) {
                currentCnt++;
                if (currentCnt > changeCnt) {
                    changeCnt++;
                    result = numList[i];
                }
            } else {
                currentCnt = 1;
            }
        }

        System.out.println(result);

    }


    public static void main(String[] args) throws IOException {
        BOJ11652 b = new BOJ11652();
        b.input();
        b.solution();
    }
}
