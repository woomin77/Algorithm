package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {

    static int N, C;
    static int[] house;

    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = atoi(st.nextToken());
        C = atoi(st.nextToken());
        house = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            house[i] = atoi(br.readLine());
        }
    }

    static boolean tf(int m, int[] a) {

        int cnt = 1, tmp=a[1];
        for (int i = 2; i <= N; i++) {
            if(a[i] - tmp >= m) {
                cnt++;
                tmp = a[i];
            }
        }
        return cnt >= C;
    }

    static void solution() {
        //집 거리 계산을 하기 위해 먼저 정렬 필요!
        Arrays.sort(house);

        int l=0, r=1000000000, result = 0;

        while (l <= r) {
            int mid = (l+r) / 2;
            if (tf(mid, house)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(result);

    }


    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

}
