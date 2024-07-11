package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ15970 {

    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N;
    static ArrayList<Integer>[] list;


    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = atoi(st.nextToken());  //index
            int y = atoi(st.nextToken());  //color

            list[y].add(x);   //색깔 별로 ArrayList에 추가
        }
    }

    public void solution() {

        //색깔 별 ArrayList 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }


        int result = 0;
        //각 색깔 별 ArrayList 마다 화살표 총합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                int Left = getLeft(list[i], j);
                int Right = getRight(list[i], j);

                result += Math.min(Left, Right);
            }
        }

        System.out.println(result);

    }

    // colorList의 idx 번째 있는 점이 왼쪽으로 화살표를 그리면
    // 화살표의 길이 return, 왼쪽에 점이 없으면 무한대 return
    private int getLeft(ArrayList<Integer> colorList, int idx) {
        if (idx == 0)
            return Integer.MAX_VALUE;
        return colorList.get(idx) - colorList.get(idx - 1);
    }

    private int getRight(ArrayList<Integer> colorList, int idx) {
        if(idx == colorList.size()-1)
            return Integer.MAX_VALUE;
        return colorList.get(idx + 1) - colorList.get(idx);
    }


    public static void main(String[] args) throws IOException {
        BOJ15970 b = new BOJ15970();
        b.input();
        b.solution();
    }
}
