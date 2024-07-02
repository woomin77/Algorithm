package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {


    static int N;
    static int[] list;

    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        N = atoi(br.readLine());
        list = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = atoi(st.nextToken());
        }
    }

    /**
     * sum = 6
     * sum = 5
     * sum = 5
     * sum = 4
     * sum = 5
     * sum = 3
     * sum = 4
     * 2
     */


    //두 수의 합이 list[idx] 라면 true
    static boolean tf(int idx) {
        int l=1, r=N;
        while (l < r) {
            //list[l] 또는 list[r]값이 value이면 Pass, 자신의 값을 더 하면 안된다!
            if(l==idx) ++l;
            else if(r==idx) r--;

            else {

                int sum = list[l] + list[r];
                System.out.println("sum = " + sum);
                if (sum > list[idx]) {
                    r--;
                } else if (sum == list[idx]) {
                    return true;
                } else {
                    l++;
                }
            }

        }
        return false;
    }

    //  1 2 3 4 5 6 7 8 9 10
    static void solution() {
        //두 수의 합을 구하기 위해 정렬 필요
        Arrays.sort(list, 1, N + 1);

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (tf(i)) {
                result++;
            }
        }

        System.out.println(result);


    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
