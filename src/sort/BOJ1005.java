package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1005 {

    static int T, N, K, W;
    static int[] time, inDegree, result;
    static ArrayList<Integer>[] adj;


    static int atoi(String st) {
        return Integer.parseInt(st);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = atoi(br.readLine());

        for (int i = 1; i <= T; i++) {
            //건물의 개수N, 건설 순서 규칙 개수 K
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = atoi(st.nextToken());
            K = atoi(st.nextToken());
            time = new int[N + 1];
            inDegree = new int[N + 1];
            result = new int[N + 1];

            //객체 초기화
            for(int j=1; j<=N; j++) adj[j] = new ArrayList<>();

            //건물당 건설에 걸리는 시간
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) time[i] = atoi(st.nextToken());

            //건설순서, 인접 리스트
            for(int j=1; j<=K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = atoi(st.nextToken());
                int y = atoi(st.nextToken());

                adj[x].add(y);
                inDegree[y]++;
            }

            //승리하기 위해 건설해야 할 건물의 번호
            W = atoi(br.readLine());



        }
    }

    static void solution() {
        Queue<Integer> que = new LinkedList<>();

        //제일 앞의 정점 찾기
        for (int i = 1; i <= N; i++)
            if(inDegree[i] == 0) {
                que.add(i);
                result[i] = time[i];   //시작 값
            }

        while (!que.isEmpty()) {
            int x = que.poll();

//            1 2
//            1 3
//            2 4
//            3 4

            for (int i : adj[x]) {
                inDegree[i]--;
                result[i] = Math.max(result[i], result[x] + time[i]);
            }
        }

    }

    public static void main(String[] args) {

    }
}
