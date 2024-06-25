package baekjoon;


/**
 * 부분 수열의 합
 */
public class BOJ1182 {

    static int N, S, result;
    int[] numbers, tf;


    public void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        S = scan.nextInt();
        numbers = new int[N];
        tf = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scan.nextInt();
        }
    }

    public void solution(int k) {
        if (k == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if(tf[i]==1)  sum += numbers[i];
            }
            if(sum == S) result++;
        }

        else {
            tf[k] = 1;
            solution(k + 1);
            tf[k] = 0;
            solution(k + 1);
        }
    }


    public static void main(String[] args) {
        BOJ1182 p = new BOJ1182();
        p.input();
        p.solution(0);
        System.out.println(result);

    }


}
