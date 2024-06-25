package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1015 {

    static int N;
    static int[] A, P;
    static Elem[] bList;
    StringBuilder sb = new StringBuilder();

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        P = new int[N];
        bList = new Elem[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            bList[i] = new Elem(A[i], i);
        }
    }

    public void solution() {
        //비내림차순으로 정렬
        Arrays.sort(bList);

        for (int i = 0; i < N; i++) {
            P[bList[i].idx] = i;
        }

        for (int i=0; i<N; i++) {
            sb.append(P[i]).append(' ');
        }

        System.out.println(sb.toString());

    }

    static class Elem implements Comparable<Elem> {

        int num, idx;

        public Elem(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        public int compareTo(Elem other) {
            return num - other.num;
        }

    }

    public static void main(String[] args) throws IOException {
        BOJ1015 b = new BOJ1015();
        b.input();
        b.solution();
    }
}
