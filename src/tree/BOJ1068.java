package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1068 {

    static int N, erase, root;
    static ArrayList<Integer>[] child;
    static ArrayList<Integer> leaf = new ArrayList<>();


    static int atoi(String st){
        return Integer.parseInt(st);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = atoi(br.readLine());
        child = new ArrayList[N];

        for(int i=0; i<N; i++) child[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = atoi(st.nextToken());

            //root node
            if(parent == -1) {
                root = i;
                continue;
            }

            child[parent].add(i);
        }
        erase = atoi(br.readLine());
    }


    static void dfs(int x, int par) {

        //Leaf node일 경우
        if (child[x].isEmpty()) {
            leaf.add(x);
        }

        for (int i : child[x]) {
            if(i==par) continue;
            dfs(i, x);
        }

    }

    static void solution() {
        //노드 삭제
        for (int i = 0; i < N; i++) {
            if (child[i].contains(erase)) {
                child[i].remove(child[i].indexOf(erase));  //그 값의 인덱스를 remove 매개변수로 지정해줘야 함 !
            }
        }

        //지우는 node가 root일 경우 예외 처리
        if(root != erase ) dfs(root, root);

//        System.out.println(leaf);
        System.out.println(leaf.size());

    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
//   0
// 0   0
//0 0