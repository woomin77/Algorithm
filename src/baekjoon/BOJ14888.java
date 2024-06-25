package baekjoon;

/**
 * 백준, 14888
 * 연산자 끼워넣기
 * 중복없이, 순서 O
 */
public class BOJ14888 {

    static int N, max, min;
    static int[] numbers, operators;

    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        BOJ14888 p = new BOJ14888();
        p.input();
        p.solution(1, numbers[1]);

        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }

    public void input() {
        N = scan.nextInt();
        numbers = new int[N+1];
        operators = new int[5];
        for (int i = 1; i <= N; i++) {
            numbers[i] = scan.nextInt();
        }
        for (int i = 1; i <= 4; i++) {
            operators[i] = scan.nextInt();
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }


    public void solution(int k, int value) {

        if (k == N) {

            max = Math.max(max, value);
            min = Math.min(min, value);


        }else {

            for (int i = 1; i <= 4; i++) {
                if (operators[i] >= 1) {
                    operators[i]--;
                    solution(k + 1, calculator(value, i, numbers[k+1]));
                    operators[i]++;
                }
            }
        }
    }

    private int calculator(int oriNum, int operators, int nextNum) {
        if (operators == 1) {
            oriNum += nextNum;
        } else if (operators == 2) {
            oriNum -= nextNum;
        } else if (operators == 3) {
            oriNum *= nextNum;
        } else {
            oriNum /= nextNum;
        }

        return oriNum;
    }

}
