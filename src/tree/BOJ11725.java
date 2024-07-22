package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {

    static ArrayList<Integer>[] adj;
    static ArrayList<Integer>[] result;
    static boolean[] visit;
    static int N;


    static int atoi(String st){
        return Integer.parseInt(st);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());
        adj = new ArrayList[N + 1];
        result = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
            result[i] = new ArrayList<>();
        }

        int n1=0, n2=0;
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n1 = atoi(st.nextToken());
            n2 = atoi(st.nextToken());

            adj[n1].add(n2);
            adj[n2].add(n1);
        }
    }

    static void dfs(int x, int parent) {

        //VISIT 체크를 굳이 안해줘도 됨!
        for (int i : adj[x]) {
            if(i == parent) continue;
            result[i].add(x);
            dfs(i, x);
        }
    }

    static void solution() {
        //루트를 1로 설정, 루트의 부모는 자신
        dfs(1, 1);

        for (int i = 2; i <= N; i++) {
            System.out.println(result[i].get(0));
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
