package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class NtoM3 {
     static int N,M;
     static int[] selected, used;

    StringBuilder sb = new StringBuilder();

    public String solution(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        else {

            for (int i = 1; i <= N; i++) {
                    selected[k] = i;
                    solution(k + 1);
                    selected[k] = 0;

            }
        }
        return sb.toString();
    }

    public void input() {
        FastReader scan = new FastReader();
         N = scan.nextInt();
         M = scan.nextInt();
        selected = new int[M + 1];
        used = new int[N+1];

    }

}
