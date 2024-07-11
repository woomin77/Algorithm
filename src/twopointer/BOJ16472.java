package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16472 {

    static int N, kind;
    static String str;
    static int[] cnt;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
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
        int result=0, len = str.length(), l=0;

        for (int r = 0; r < len; r++) {
            add(str.charAt(r));  //r번째 인덱스의 알파벳 추가

            while (l<=r) {
                //cnt 배열에 알파벳이 몇 종류 들어가있는지 계산
                int kind = 0;
                for (int i = 0; i < 26; i++)   {
                    if(cnt[i] != 0) kind++;
                }
                if(kind <= N) break;  //알파벳 종류가 N보다 작으면 break(r 인덱스 이동)

                //N을 만족할 만큼 L 인덱스를 앞으로 이동
                remove(str.charAt(l));
                l++;
            }

            result = Math.max(result, r - l + 1);
        }
        System.out.println(result);

    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
