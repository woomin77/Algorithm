package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3055 {

    static int R, C;
    static String[] a;
    static boolean[][] visit;
    static int[][] waterDist, sDist;  //물의 최소 시간을 저장할 waterDist, 고슴도치의 최소 시간을 저장할 sDist
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    static int atoi(String st) {
        return Integer.parseInt(st);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = atoi(st.nextToken());
        C = atoi(st.nextToken());

        a = new String[R];
        visit = new boolean[R][C];
        waterDist = new int[R][C];
        sDist = new int[R][C];

        for (int i = 0; i < R; i++) {
            a[i] = br.readLine();
        }

    }


    static void waterBfs() {
        Queue<Integer> que = new LinkedList<>();

        //모든 물 위치 파악 해서 que에 add -> MultiBfs
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (a[i].charAt(j) == '*') {
                    que.add(i);
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

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(a[nx].charAt(ny) != '.') continue;
                if(visit[nx][ny]) continue;

                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;

                waterDist[nx][ny] = waterDist[x][y] + 1;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(waterDist[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void sBfs(int x, int y) {
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        que.add(y);
        visit[x][y] = true;

        while (!que.isEmpty()) {
            x = que.poll();
            y = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(visit[nx][ny]) continue;
                if(a[nx].charAt(ny) == '*' || a[nx].charAt(ny) == 'X') continue;

                //고슴도치 보다 물이 먼저 빈칸에 찰 수 있으면 패스
                if(sDist[x][y]+1 >= waterDist[nx][ny]) continue;
                sDist[nx][ny] = sDist[x][y] + 1;

                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;

            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(sDist[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void solution() {
        //물의 최소시간을 구하는 BFS
        waterBfs();

        int x = 0, y = 0;
        int x2 = 0, y2 = 0;
        //visit 배열 초기화 & 고슴 도치 초기 위치 파악
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visit[i][j] = false;

                //고슴 도치 초기 위치 파악
                if(a[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }

                //굴 위치 파악
                if (a[i].charAt(j) == 'D') {
                    x2 = i;
                    y2 = j;
                }
            }
        }

        //고슴도치의 최소시간을 구하는 BFS
        sBfs(x, y);

        if (sDist[x2][y2] == 0) System.out.println("KAKTUS");
        else System.out.println(sDist[x2][y2]);

    }



    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
