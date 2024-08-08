package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {

    static int N,M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();


    static int atoi(String st) {
        return Integer.parseInt(st);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        selected = new int[M + 1];

    }

    static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <=M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

            for(int i=1; i<=N; i++) {
                selected[k] = i;
                rec_func(k + 1);
                selected[k] = 0;
            }

    }


    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }
}
