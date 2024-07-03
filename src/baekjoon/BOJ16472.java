package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16472 {

    static int N, kind;
    static String str;
    static int[] A, cnt;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        cnt = new int[26];
        str = br.readLine();
    }

    static void add(char x) {  //x 라는 알파벳 추가
        cnt[x-'a']++;
    }

    static void remove(char x) { //x 라는 알파벳 제거
        cnt[x-'a']--;
    }

    static void solution() {
        int len = str.length(), result = 0;
        for (int R = 0, L = 0; R < len; R++) {
            add(str.charAt(R));

            kind = 0;
            while (true) {
                for (int i = 0; i < 26; i++) {
                    if(cnt[i] != 0) kind++;
                }
                if(kind <= N) break;
                remove(str.charAt(L));
                L++;
            }

            result = Math.max(result, R - L + 1);

        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
