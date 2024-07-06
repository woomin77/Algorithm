package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260_List {

    static int N, M, V;
    static ArrayList<Integer>[] adj;
//    static ArrayList<ArrayList<Integer>> list= new ArrayList<>();
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
        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        //객체 배열 초기화
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
//
//        for (int i = 0; i <= N; i++) {
//            list.add(new ArrayList<>());
//        }

        int x=0, y=0;
        for (int i = 0; i < M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            x = atoi(str.nextToken());
            y = atoi(str.nextToken());
//            list.get(x).add(y);
//            list.get(y).add(x);
            adj[x].add(y);
            adj[y].add(x);
        }

        //작은 수 부터 방문할 수 있도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
//
//        for (int i = 1; i <= N; i++) {
//            Collections.sort(list.get(i));
//        }
    }

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');

        for (int y : adj[x]) {
            if(visit[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int x) {
        Queue<Integer> que = new LinkedList();

        visit[x] = true;
        que.add(x);

        while (!que.isEmpty()) {
            x = que.poll();
            sb.append(x).append(' ');

            for (int y : adj[x]) {
                if(visit[y]) continue;

                que.add(y);
                visit[y] = true;
            }
        }

    }


    static void solution() {
        dfs(V);
        sb.append("\n");
        for(int i=1; i<=N; i++) visit[i] = false;
        bfs(V);
        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
