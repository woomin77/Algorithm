package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260_Matrix {

    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        V = atoi(st.nextToken());
        adj = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        int x=0, y=0;
        for (int i = 0; i < M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            x = atoi(str.nextToken());
            y = atoi(str.nextToken());
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');

        for (int y = 1; y <= N; y++) {
            if(visit[y]) continue;
            if(adj[x][y]==0) continue;
            dfs(y);
        }
    }

    static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        visit[x] = true;

        while (!que.isEmpty()) {
            x = que.poll();
            sb.append(x).append(' ');
            for (int y = 1; y <= N; y++) {
                if(adj[x][y]==0) continue;
                if(visit[y]) continue;

                que.add(y);
                visit[y] = true;
            }
        }

    }


    static void solution() {
        dfs(V);
        sb.append("\n");
        for(int i=0; i<=N; i++) visit[i] = false;  //visit 다시 초기화
        bfs(V);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
