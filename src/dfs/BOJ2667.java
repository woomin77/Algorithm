package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2667 {

    static StringBuilder sb = new StringBuilder();
    static int N, group_cnt;  //단지내 집의 수
    static String[] list;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    static int atoi(String st) {
        return Integer.parseInt(st);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = atoi(br.readLine());
        visit = new boolean[N][N];
        list = new String[N];

        for (int i = 0; i < N; i++) {
//            list[i] = new String();
            list[i] = br.readLine();
        }
    }

    static void dfs(int x, int y) {

        group_cnt++;  //집 개수 +1
        visit[x][y] = true;

        //인접한 집으로 방문
        for (int i = 0; i < 4; i++) {
            //(x,y) -> dir[i]
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            //[nx][ny]

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;  //격자를 벗어나면 pass
            if(list[nx].charAt(ny) == '0') continue;  //0이면 집이 존재 하지 않으니 pass
            if(visit[nx][ny]) continue;  //이미 방문 했으면 pass
            dfs(nx, ny);
        }
    }

    static void solution() {
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!visit[x][y] && list[x].charAt(y) == '1') {
                    //새로운 단지 시작(여기서 부터 단지 탐색하면서 집의 개수 세기!)
                    group_cnt=0;
                    dfs(x, y);
                    resultList.add(group_cnt);
                }
            }
        }

        Collections.sort(resultList);
        sb.append(resultList.size()).append("\n");
        for (int i : resultList) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
