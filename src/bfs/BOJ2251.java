package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//물통의 상태를 나타내고 물을 붓는 행위를 구현할 구조체
class State {
    int[] stateList;

    State(int[] list) {
        stateList = new int[3];
        for (int i = 0; i < 3; i++) {
            stateList[i] = list[i];
        }
    }

    //다른 물통에 물 붓는 행위  to의 용량 = limit
    State move(int from, int to, int[] limit) {
        int[] nx = new int[]{stateList[0], stateList[1], stateList[2]};

        //from의 물통을 to의 몰통에다 다 쏟을 수 없다. -> to의 물통은 꽉 차도 from 의 물통은 남아있다.
        if(stateList[from] + stateList[to] >= limit[to] ) {
            nx[from] = nx[from] - (limit[to] - nx[to]);
            nx[to] = limit[to];
        }
        else {  //from의 물통을 to의 물통에다 다 쏟을 수 있다.
            nx[to] += nx[from];
            nx[from] = 0;
        }

        return new State(nx);
    }
}


public class BOJ2251 {

    static int[] limit, result;
    static boolean[][][] visit;
    static List<Integer> resultList = new ArrayList<>();



    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static void input() throws Exception{
        int A, B, C;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = atoi(st.nextToken());
        }
        visit = new boolean[201][201][201];
        result = new int[201];
    }

    //A -> B,C    B-> A,C   C->A,B
    static void bfs(int A, int B, int C) {
        Queue<State> que = new LinkedList<>();

        que.add(new State(new int[]{A, B, C}));
        visit[A][B][C] = true;

        while (!que.isEmpty()) {
            State st = que.poll();

            //A가 0일 경우 C의 상태를 저장
            if (st.stateList[0] == 0) {
                resultList.add(st.stateList[2]);
            }

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if(from==to) continue;
                    State nst = st.move(from, to, limit);

                    //이미 방문
                    if (!visit[nst.stateList[0]][nst.stateList[1]][nst.stateList[2]]) {
                        que.add(nst);
                        visit[nst.stateList[0]][nst.stateList[1]][nst.stateList[2]] = true;
                    }
                }
            }
        }

    }

    static void solution() {
        bfs(0, 0, limit[2]);
        Collections.sort(resultList);
        for (int i : resultList) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
}
