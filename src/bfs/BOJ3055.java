package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        for (int i = 0; i < R; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
