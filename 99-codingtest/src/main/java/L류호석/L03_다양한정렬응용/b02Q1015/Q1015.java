package L류호석.L03_다양한정렬응용.b02Q1015;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1015 {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static Element[] A;
    static int[] P_result;

    public static void input(){
        FastReader sc = new FastReader();
        N = sc.nextInt();
        A = new Element[N];
        for(int i=0; i<A.length; ++i){
            A[i] = new Element(sc.nextInt(), i);
        }
        P_result = new int[N];
    }

    public static void print(){
        for(int i=0; i<P_result.length; ++i) sb.append(P_result[i]).append(" ");
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        input();
        Arrays.sort(A);

        for(int i=0; i<A.length; ++i){
            P_result[A[i].index]=i;
        }

        print();
    }

    static class Element implements Comparable<Element> {

        int value;
        int index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Element o) {
            return Integer.compare(this.value, o.value);

            //Object 정렬은 Tim Sort -> stable 이므로 굳이 이렇게 경우를 나눠주지않아도됨.
            //if(this.value!= o.value) return this.value-o.value;
            //return this.index - o.index;
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
