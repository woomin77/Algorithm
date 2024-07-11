package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10825 {

    static int N;
    static Student[] stu;
    static class Student implements Comparable<Student> {

        String name;
        int korean, english, math;


        public int compareTo(Student other) {
            //국어 점수 내림차순
            if (korean != other.korean) return other.korean - korean;
            //영어 점수 오름차순
            if (english != other.english) return english - other.english;
            //수학 점수 내림차순
            if (math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }


    public void input() throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(scan.readLine());
        stu = new Student[N];

        for (int i = 0; i < N; i++) {
            stu[i] = new Student();
            StringTokenizer st = new StringTokenizer(scan.readLine());
            stu[i].name = st.nextToken();
            stu[i].korean = Integer.parseInt(st.nextToken());
            stu[i].english = Integer.parseInt(st.nextToken());
            stu[i].math = Integer.parseInt(st.nextToken());
        }

    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BOJ10825 s = new BOJ10825();

        s.input();
        Arrays.sort(stu);

        for (int i = 0; i < stu.length; i++) {
            sb.append(stu[i].name).append('\n');
        }
        System.out.println(sb);

    }

}

