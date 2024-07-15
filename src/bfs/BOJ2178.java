package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

    static int N,M;
    static String[] a;
    static int[][]  dist;   //dist : 거리를 담을 배열
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};



    static int atoi(String st) {
        return Integer.parseInt(st);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        a = new String[N];
        dist = new int[N][M];
        visit = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }
    }

    //x, y 에 갈 수 있다는 걸 알고 방문한 상태
    static void bfs(int x, int y) {
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        que.add(y);
        visit[x][y] = true;
        dist[x][y] = 1;

        while (!que.isEmpty()) {
            x = que.poll();
            y = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)  continue;
                if(visit[nx][ny]) continue;
                if(a[nx].charAt(ny) == '0') continue;

                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;  //거리(이동 횟수) 누적

            }
        }

    }

    static void solution() {
        bfs(0, 0);

        //bfs 가 끝나면 dist의 도착지 좌표에는 이동 횟수가 생성되어있다.
        System.out.println(dist[N-1][M-1]);
    }


    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
