package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470_twoPointer {

    static int N;
    static int []a;
    static StringBuilder sb = new StringBuilder();

    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = atoi(br.readLine());
        a = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = atoi(st.nextToken());
        }
    }

    static void solution() {
        //최소, 최대값에 쉽게 접근하기 위해 정렬
        Arrays.sort(a, 1, N+1);

        int l = 1, r = N, best_sum = Integer.MAX_VALUE;
        int v1=0, v2=0; //답을 저장할 두 변수

        //-99, -4, -2, -1, 98
        while (l < r) {
            int temp = a[l] + a[r];
            if (temp <= 0) {  //최대+최소가 음수라면 최솟값 입장에서는 최선책을 선택
                if (best_sum > Math.abs(temp)) {
                    best_sum = Math.abs(temp);
                    v1 = a[l];
                    v2 = a[r];
                }
                l++;
            } else {
                if (best_sum > Math.abs(temp)) {
                    best_sum = Math.abs(temp);
                    v1 = a[l];
                    v2 = a[r];
                }
                r--;
            }
        }

        sb.append(v1).append(" ").append(v2);

    }

    public static void main(String[] args) throws IOException{
        input();
        solution();
        System.out.println(sb);
    }


}
