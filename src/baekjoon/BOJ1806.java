package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {

    static int N,S;
    static int[] list;

    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = atoi(st.nextToken());
        S = atoi(st.nextToken());
        list = new int[N + 1];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = atoi(st2.nextToken());
        }
    }

        //  5 1 3 5 10 7 4 9 2 8
    static void solution() {


        //R        1   2   3   4    5
        //sum      5   6   9   14   24

        int result=0, R = 0, sum=0;
        for (int L = 1; L <= N; L++) {
            sum -= list[L - 1];

            //R을 옮길 수 있을 때 까지 옮기기
            while (R+1 <= N && sum < S) {
                R++;
                sum += list[R];
                //R++; 헷갈림 주의!! 인덱스 잘 생각하기!

                System.out.println("R = " + R + " sum = " + sum);

            }
        }


    }



    public static void main(String[] args) throws IOException {
        input();
        solution();
    }


    /**
     *   int sum = 0, R = 0, result = N + 1;
     *         for (int L = 1; L <= N; L++) {
     *             sum = sum - list[L - 1];
     *
     *             //R을 옮길 수 있을 때 까지 옮기기
     *             while (R+1 <= N && sum < S) {
     *                 R++;
     *                 sum += list[R];   //24    24-5 = 19  19-1=18   18-3=15
     *             }
     *
     *             if (sum >= S) {
     *                 result = Math.min(result, R-L+1);
     *             }
     *         }
     *
     *
     *         // ans 값을 보고 불가능 판단하기
     *         if (result == N + 1)
     *             result = 0;
     *
     *         System.out.println(result);
     */
}
