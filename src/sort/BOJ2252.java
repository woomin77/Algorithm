package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2252 {

    static int N,M;
    static ArrayList<Integer>[] adj;
    static int[] inDegree; //진입차수 계산

    static int atoi(String st) {
        return Integer.parseInt(st);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        inDegree = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

        int v1, v2;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            v1 = atoi(st.nextToken());
            v2 = atoi(st.nextToken());

            adj[v1].add(v2);
            inDegree[v2]++;
        }
    }

    static void solution() {
        Deque<Integer> que = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기

        que.add(1);
        que.add(2);
        que.add(3);


        // 정렬될 수 있는 정점이 있다면?
        // 1. 정렬 결과에 추가하기
        // 2. 정점과 연결된 간선 제거하기
        // 3. 새롭에 "정렬 될 수 있는" 정점
        /* TODO */

    }


    public static void main(String[] args) {

    }
}
