package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



//TODO 다시 풀기!!!!
public class BOJ2470 {
    static int N;
    static int[] list;

    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());
        list = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = atoi(st.nextToken());
        }
    }

    //list 배열에서 x 보다 큰 숫자중에 가장 왼쪽에 있는 값 index return
    //만약 큰 숫자가 없다면 r+1 return
    static int getHighLeft(int[] a, int l, int r, int x) {

        int result = r+1;
        while (l <= r) {
            int mid = (l+r)/2;
            if (a[mid]  >= x ) {
                result = mid;
                r = mid - 1;

            } else{
                l = mid+1;
            }
        }

        return result;
    }


    static void solution() {
        //이분탐색을 하기 위해 오름차순 정렬
        Arrays.sort(list);

        int min = Integer.MAX_VALUE, ans=0;
        for (int i = 1; i <= N-1; i++) {  //list 배열 왼쪽부터 순회하며
            int result = getHighLeft(list, i + 1, N, -list[i]);
            if (result < min) {
                min = result;
                System.out.println(list[i]);
                ans = list[i];
            }
        }
        System.out.println(ans + " " + list[min]);
    }



    public static void main(String[] args) throws IOException{
        input();
        solution();

    }

}
