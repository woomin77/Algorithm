package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {

    static int N, M;
    static int[] trees;

    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static void input() throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        trees = new int[N +1];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            trees[i] = atoi(st2.nextToken());
        }
    }

    //나무를 H 높이로 잘랐을 경우, 원하는 길이 M을 얻을 수 있으면 YES, 없으면 NO
    static boolean determine(long h) {

        long sum = 0;
        for (int i = 1; i <= N; i++) {
            if(trees[i] > h)
                sum += trees[i] - h;
        }

        return sum >= M;
    }

    //l ~ r 까지 이분탐색 진행!
    static void solution() {
        long l=0, r=2000000000;
        int result = 0;

        while (l <= r) {
            int mid = (int) (l + r) / 2;
            if (determine(mid)) {
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
