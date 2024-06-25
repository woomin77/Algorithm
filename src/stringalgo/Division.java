package stringalgo;

public class Division {

    int sum, result;
    int[] arr = new int[100];

    public void solution(int mySum, int idx, int num) {

        if(idx > num) return;

        if (mySum == num) {
            for (int i = 0; i < idx-1; i++) {
                System.out.print(arr[i] + " + ");
            }
            System.out.print(arr[idx-1]);

            System.out.println();
        }
        else {
            for (int i = 1; i <= num; i++) {
                arr[idx] = i;
                solution(mySum + i, idx+1, num);
                arr[idx] = 0;

            }
        }
    }
}
