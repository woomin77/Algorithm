package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {

    static int N, K;
    static int[] dist;  //이동 횟수 체크
    static boolean[] visit;

    static int atoi(String st) {
        return Integer.parseInt(st);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        K = atoi(st.nextToken());
        visit = new boolean[100001];
        dist = new int[100001];
    }

    //5 10 9 18 17
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        dist[start] = 0;  //시작 위치의 이동 횟수는 0
        visit[start] = true;

        while (!que.isEmpty()) {
            int x = que.poll();

            //+1, -1, *2 상태 그래프 만들기
            int x1 = x + 1;
            if (!(x1 > 100000) && !visit[x1]) {
                que.add(x1);
                visit[x1] = true;
                dist[x1] = dist[x] + 1;
            }

            int x2 = x - 1;
            if(!(x2 < 0) && !visit[x2]) {
                que.add(x2);
                visit[x2] = true;
                dist[x2] = dist[x] + 1;
            }

            int x3 = x * 2;
            if (!(x3 > 100000) && !visit[x3]) {
                que.add(x3);
                visit[x3] = true;
                dist[x3] = dist[x] + 1;
            }
        }
    }

    static void solution() {
        bfs(N);   // 수빈이가 있는 위치 부터 시작
        System.out.println(dist[K]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
