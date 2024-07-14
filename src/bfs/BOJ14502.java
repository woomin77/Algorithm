package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ14502 {

    static int N,M, idx;
    static int[][] a, blank;
    static int[][] dir = { {-1,0}, {0, 1}, {1, 0}, {0, -1}};  //격자 방향대로 체크
    static boolean[][] visit;  //방문 유무 체크

    static int atoi(String st) {
        return Integer.parseInt(st);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        a = new int[N + 1][M + 1];
        blank = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                a[i][j] = atoi(st2.nextToken());
            }
        }
    }

    // cnt 번째에 벽을 세울지 말지 결정
    // 여기까지 총 selected_cnt 개의 벽을 세움
    static void dfs(int cnt, int selected_cnt) {
        if (selected_cnt == 3) {
            //bfs();   TODO
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

        dfs()
    }


    public static void main(String[] args) {

    }
}
