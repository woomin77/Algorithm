package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] A, B;

    static int atoi(String st) {
        return Integer.parseInt(st);
    }

    static void input() throws IOException {

        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        A = new int[N + 1];
        B = new int[M + 1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = atoi(st1.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            B[i] = atoi(st2.nextToken());
        }
    }


    //B 배열에서 A보다 작은 수 중 가장 오른쪽 Index return
    static int getLow(int[] a, int l, int r, int x) {
        int result = 0, mid = 0;

        while (l <= r) {
            mid = (l+r) / 2;
            if (a[mid] < x) {  //탐색할 가치 O
                result = mid;
                l = mid + 1;
            }
            else {  //탐색할 가치 X  (x보다 큰 값은 찾을 필요가 없다!)
                r = mid - 1;
            }
        }

        return result;
    }

    static void solution() {
        //이분탐색을 위해 B 배열 정렬
        Arrays.sort(B);

        int result = 0;
        for (int i = 1; i < A.length; i++) {  //A의 원소들을 하나씩 순회하며
            result += getLow(B, 1, B.length-1, A[i]);
        }

        System.out.println(result);
    }




    public static void main(String[] args) throws IOException {
        int T = atoi(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            solution();
        }
    }
}
