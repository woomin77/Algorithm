package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {

    static int N,M, idx;
    static int[][] a, blank;
    static int[][] dir = { {-1,0}, {0, 1}, {1, 0}, {0, -1}};  //격자 방향대로 체크
    static boolean[][] visit;  //방문 유무 체크
    static int result;

    static int atoi(String st) {
        return Integer.parseInt(st);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        a = new int[N + 1][M + 1];
        blank = new int[N * M + 1][2];
        visit = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                a[i][j] = atoi(st2.nextToken());
            }
        }
    }

    // 바이러스가 퍼질수 있는 좌표들 visit check
    static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        //모든 바이러스가 시작점으로 가능, 전부 큐에 삽입
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visit[i][j] = false;
                if (a[i][j] == 2) {
                    que.add(i);   //좌표 표현을 위해 2개 씩 add 해주고, 2개씩 poll
                    que.add(j);
                    visit[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if(a[nx][ny] != 0) continue;
                if(visit[nx][ny]) continue;

                visit[nx][ny] = true;
                que.add(nx);
                que.add(ny);
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (a[i][j] == 0 && !visit[i][j]) {
                    cnt++;
                }
            }
        }

        result = Math.max(result, cnt);
    }


    // cnt 번째에 벽을 세울지 말지 결정
    // 여기까지 총 selected_cnt 개의 벽을 세움
    static void dfs(int cnt, int selected_cnt) {
        if (selected_cnt == 3) {
            bfs();
            return;
        }

        if(cnt > idx) return;   //빈 칸(0)을 모두 스쳐 지나감!

        a[blank[cnt][0]][blank[cnt][1]] = 1;   //빈 칸(0)에 벽 세우기
        dfs(cnt + 1, selected_cnt + 1);

        a[blank[cnt][0]][blank[cnt][1]] = 0;   //다른 곳에 벽 세우기 위해 빈 칸으로 다시 설정
        dfs(cnt + 1, selected_cnt);

    }

    static void solution() {

        //빈칸(0) 체크
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(a[i][j]==0) {
                    idx++;
                    blank[idx][0] = i;
                    blank[idx][1] = j;
                }
            }
        }

        dfs(1,0);

        System.out.println(result);

    }


    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
