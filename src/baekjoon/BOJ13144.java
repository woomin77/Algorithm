package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13144 {

    static int N;
    static int[] a;

    static int atoi(String st) {
        return Integer.parseInt(st);
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
        long result = 0;
        int r=1;
        int[] cnt = new int[N + 1];   //각 숫자가 있는지 여부를 나타내는 CNT 배열

        for (int l = 1; l <= N; l++) {
            //r을 옮길 수 있는 만큼 옮긴다!
            while (r <= N && cnt[a[r]] == 0) {
                cnt[a[r]] = 1;
                r++;
            }
            result += (r-l);

            //l을 옮겨주면서 a[l]값은 삭제
            cnt[a[l]] = 0;
        }

        System.out.println(result);

    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
