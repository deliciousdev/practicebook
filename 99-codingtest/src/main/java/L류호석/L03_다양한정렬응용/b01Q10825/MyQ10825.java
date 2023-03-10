package L류호석.L03_다양한정렬응용.b01Q10825;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MyQ10825 {
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Person[] student;

    public static void input(){
        FastReader sc = new FastReader();
        N = sc.nextInt();

        student = new Person[N];
        for(int i=0; i<N; ++i){
            student[i] = new Person(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
    }



    public static void main(String[] args) {

        input();
        Arrays.sort(student);
        for(int i=0; i<N; ++i) sb.append(student[i].name).append('\n');
        System.out.println(sb.toString());

    }

    static class Person implements Comparable<Person> {

        String name;
        int korean;
        int english;
        int math;

        public Person(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Person o) {
            if (this.korean > o.korean) return -1;
            if (this.korean < o.korean) return 1;

            if (this.english > o.english) return 1;
            if (this.english < o.english) return -1;

            if (this.math > o.math) return -1;
            if (this.math < o.math) return 1;

            return this.name.compareTo(o.name);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
